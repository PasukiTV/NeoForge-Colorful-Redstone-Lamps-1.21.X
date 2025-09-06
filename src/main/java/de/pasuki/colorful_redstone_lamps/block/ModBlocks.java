package de.pasuki.colorful_redstone_lamps.block;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import de.pasuki.colorful_redstone_lamps.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.Map;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(ColorfulRedstoneLamps.MOD_ID);

    // Maps: normal & invertiert
    public static final Map<DyeColor, DeferredBlock<Block>> LAMPS = new EnumMap<>(DyeColor.class);
    public static final Map<DyeColor, DeferredBlock<Block>> INVERTED_LAMPS = new EnumMap<>(DyeColor.class);

    static {
        for (DyeColor color : DyeColor.values()) {
            // ===== normale Lampe =====
            final String name = color.getName() + "_redstone_lamp";
            DeferredBlock<Block> lamp = BLOCKS.register(name, () ->
                    new RedstoneLampBlock(BlockBehaviour.Properties.of()
                            .setId(key(name))
                            .mapColor(color.getMapColor())
                            .strength(0.3F)
                            .sound(SoundType.GLASS)
                            .lightLevel(s -> s.getValue(RedstoneLampBlock.LIT) ? 15 : 0)
                    )
            );
            LAMPS.put(color, lamp);
            registerBlockItem(name, lamp);

            // ===== invertierte Lampe =====
            final String invName = color.getName() + "_redstone_lamp_inverted";
            DeferredBlock<Block> invLamp = BLOCKS.register(invName, () ->
                    new InvertedRedstoneLampBlock(BlockBehaviour.Properties.of()
                            .setId(key(invName))
                            .mapColor(color.getMapColor())
                            .strength(0.3F)
                            .sound(SoundType.GLASS)
                            .lightLevel(s -> s.getValue(BlockStateProperties.LIT) ? 15 : 0)
                    )
            );
            INVERTED_LAMPS.put(color, invLamp);
            registerBlockItem(invName, invLamp);
        }
    }

    // === Helpers ===

    private static ResourceKey<Block> key(String name) {
        return ResourceKey.create(
                Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID, name)
        );
    }

    private static void registerBlockItem(String name, DeferredBlock<Block> block) {
        ModItems.ITEMS.register(name, () ->
                new BlockItem(block.get(),
                        new BlockItem.Properties().setId(
                                ResourceKey.create(
                                        Registries.ITEM,
                                        ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID, name)
                                )
                        )
                )
        );
    }

    // (Optional – falls du es brauchst)
    @SuppressWarnings("unused")
    private static boolean always(BlockState s, BlockGetter g, BlockPos p, EntityType<?> t) { return true; }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
