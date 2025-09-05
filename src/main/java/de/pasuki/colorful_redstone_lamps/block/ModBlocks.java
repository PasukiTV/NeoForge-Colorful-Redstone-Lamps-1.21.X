package de.pasuki.colorful_redstone_lamps.block;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import de.pasuki.colorful_redstone_lamps.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(ColorfulRedstoneLamps.MOD_ID);

    // ================= helpers =================
    private static ToIntFunction<BlockState> litBlockEmission(int value) {
        return state -> state.getValue(RedstoneLampBlock.LIT) ? value : 0;
    }
    private static boolean always(BlockState s, BlockGetter g, BlockPos p, EntityType<?> t) { return true; }

    private static BlockBehaviour.Properties baseProps(DyeColor color) {
        return BlockBehaviour.Properties.of()
                .mapColor(color.getMapColor())
                .strength(0.3F)
                .sound(SoundType.GLASS)
                .lightLevel(litBlockEmission(15))
                .isValidSpawn(ModBlocks::always);
    }

    // ================= maps =================
    // Normale & invertierte Lampen – beide per Schleife gefüllt
    public static final Map<DyeColor, DeferredBlock<Block>> LAMPS =
            new EnumMap<>(DyeColor.class);
    public static final Map<DyeColor, DeferredBlock<Block>> INVERTED_LAMPS =
            new EnumMap<>(DyeColor.class);

    static {
        for (DyeColor color : DyeColor.values()) {
            // normal
            String baseName = color.getName() + "_redstone_lamp";
            DeferredBlock<Block> lamp = registerBlock(baseName,
                    () -> new RedstoneLampBlock(baseProps(color)));
            LAMPS.put(color, lamp);

            // inverted
            String invName = color.getName() + "_redstone_lamp_inverted";
            DeferredBlock<Block> invLamp = registerBlock(invName,
                    () -> new InvertedRedstoneLampBlock(
                            BlockBehaviour.Properties.of()
                                    .mapColor(color.getMapColor())
                                    .strength(0.3F)
                                    .sound(SoundType.GLASS)
                                    .lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 15 : 0)
                                    .isValidSpawn(ModBlocks::always)
                    ));
            INVERTED_LAMPS.put(color, invLamp);
        }
    }

    // ================= register helpers =================
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new net.minecraft.world.item.BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
