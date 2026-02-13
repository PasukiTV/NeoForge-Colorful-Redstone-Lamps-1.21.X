package de.pasuki.colorful_redstone_lamps.block;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import de.pasuki.colorful_redstone_lamps.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ColorfulRedstoneLamps.MOD_ID);

    public static final Map<DyeColor, DeferredBlock<Block>> LAMPS = new EnumMap<>(DyeColor.class);
    public static final Map<DyeColor, DeferredBlock<Block>> INVERTED_LAMPS = new EnumMap<>(DyeColor.class);

    static {
        for (DyeColor color : DyeColor.values()) {
            String baseName = color.getName() + "_redstone_lamp";
            LAMPS.put(color, registerBlock(baseName, () -> new RedstoneLampBlock(baseLampProperties(color))));

            String invName = color.getName() + "_redstone_lamp_inverted";
            INVERTED_LAMPS.put(color, registerBlock(invName, () -> new InvertedRedstoneLampBlock(baseLampProperties(color))));
        }
    }

    private static BlockBehaviour.Properties baseLampProperties(DyeColor color) {
        return BlockBehaviour.Properties.of()
                .mapColor(color.getMapColor())
                .strength(0.3F)
                .sound(SoundType.GLASS)
                .lightLevel(litBlockEmission(15))
                .isValidSpawn(ModBlocks::always);
    }

    private static ToIntFunction<BlockState> litBlockEmission(int value) {
        return state -> state.getValue(RedstoneLampBlock.LIT) ? value : 0;
    }

    private static boolean always(BlockState state, BlockGetter level, BlockPos pos, EntityType<?> entity) {
        return true;
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> deferredBlock = BLOCKS.register(name, block);
        registerBlockItem(name, deferredBlock);
        return deferredBlock;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
