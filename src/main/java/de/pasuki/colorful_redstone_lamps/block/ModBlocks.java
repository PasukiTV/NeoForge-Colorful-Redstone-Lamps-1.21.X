package de.pasuki.colorful_redstone_lamps.block;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import de.pasuki.colorful_redstone_lamps.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public final class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ColorfulRedstoneLamps.MOD_ID);

    public static final DeferredBlock<Block> WHITE_REDSTONE_LAMP = registerLamp("white_redstone_lamp", MapColor.QUARTZ);
    public static final DeferredBlock<Block> LIGHT_GRAY_REDSTONE_LAMP = registerLamp("light_gray_redstone_lamp", MapColor.COLOR_LIGHT_GRAY);
    public static final DeferredBlock<Block> GRAY_REDSTONE_LAMP = registerLamp("gray_redstone_lamp", MapColor.COLOR_GRAY);
    public static final DeferredBlock<Block> BLACK_REDSTONE_LAMP = registerLamp("black_redstone_lamp", MapColor.COLOR_BLACK);
    public static final DeferredBlock<Block> BROWN_REDSTONE_LAMP = registerLamp("brown_redstone_lamp", MapColor.COLOR_BROWN);
    public static final DeferredBlock<Block> RED_REDSTONE_LAMP = registerLamp("red_redstone_lamp", MapColor.COLOR_RED);
    public static final DeferredBlock<Block> ORANGE_REDSTONE_LAMP = registerLamp("orange_redstone_lamp", MapColor.COLOR_ORANGE);
    public static final DeferredBlock<Block> YELLOW_REDSTONE_LAMP = registerLamp("yellow_redstone_lamp", MapColor.COLOR_YELLOW);
    public static final DeferredBlock<Block> LIME_REDSTONE_LAMP = registerLamp("lime_redstone_lamp", MapColor.COLOR_LIGHT_GREEN);
    public static final DeferredBlock<Block> GREEN_REDSTONE_LAMP = registerLamp("green_redstone_lamp", MapColor.COLOR_GREEN);
    public static final DeferredBlock<Block> CYAN_REDSTONE_LAMP = registerLamp("cyan_redstone_lamp", MapColor.COLOR_CYAN);
    public static final DeferredBlock<Block> LIGHT_BLUE_REDSTONE_LAMP = registerLamp("light_blue_redstone_lamp", MapColor.COLOR_LIGHT_BLUE);
    public static final DeferredBlock<Block> BLUE_REDSTONE_LAMP = registerLamp("blue_redstone_lamp", MapColor.COLOR_BLUE);
    public static final DeferredBlock<Block> PURPLE_REDSTONE_LAMP = registerLamp("purple_redstone_lamp", MapColor.COLOR_PURPLE);
    public static final DeferredBlock<Block> MAGENTA_REDSTONE_LAMP = registerLamp("magenta_redstone_lamp", MapColor.COLOR_MAGENTA);
    public static final DeferredBlock<Block> PINK_REDSTONE_LAMP = registerLamp("pink_redstone_lamp", MapColor.COLOR_PINK);

    public static final DeferredBlock<Block> WHITE_INVERTED_REDSTONE_LAMP = registerInvertedLamp("white_inverted_redstone_lamp", MapColor.QUARTZ);
    public static final DeferredBlock<Block> LIGHT_GRAY_INVERTED_REDSTONE_LAMP = registerInvertedLamp("light_gray_inverted_redstone_lamp", MapColor.COLOR_LIGHT_GRAY);
    public static final DeferredBlock<Block> GRAY_INVERTED_REDSTONE_LAMP = registerInvertedLamp("gray_inverted_redstone_lamp", MapColor.COLOR_GRAY);
    public static final DeferredBlock<Block> BLACK_INVERTED_REDSTONE_LAMP = registerInvertedLamp("black_inverted_redstone_lamp", MapColor.COLOR_BLACK);
    public static final DeferredBlock<Block> BROWN_INVERTED_REDSTONE_LAMP = registerInvertedLamp("brown_inverted_redstone_lamp", MapColor.COLOR_BROWN);
    public static final DeferredBlock<Block> RED_INVERTED_REDSTONE_LAMP = registerInvertedLamp("red_inverted_redstone_lamp", MapColor.COLOR_RED);
    public static final DeferredBlock<Block> ORANGE_INVERTED_REDSTONE_LAMP = registerInvertedLamp("orange_inverted_redstone_lamp", MapColor.COLOR_ORANGE);
    public static final DeferredBlock<Block> YELLOW_INVERTED_REDSTONE_LAMP = registerInvertedLamp("yellow_inverted_redstone_lamp", MapColor.COLOR_YELLOW);
    public static final DeferredBlock<Block> LIME_INVERTED_REDSTONE_LAMP = registerInvertedLamp("lime_inverted_redstone_lamp", MapColor.COLOR_LIGHT_GREEN);
    public static final DeferredBlock<Block> GREEN_INVERTED_REDSTONE_LAMP = registerInvertedLamp("green_inverted_redstone_lamp", MapColor.COLOR_GREEN);
    public static final DeferredBlock<Block> CYAN_INVERTED_REDSTONE_LAMP = registerInvertedLamp("cyan_inverted_redstone_lamp", MapColor.COLOR_CYAN);
    public static final DeferredBlock<Block> LIGHT_BLUE_INVERTED_REDSTONE_LAMP = registerInvertedLamp("light_blue_inverted_redstone_lamp", MapColor.COLOR_LIGHT_BLUE);
    public static final DeferredBlock<Block> BLUE_INVERTED_REDSTONE_LAMP = registerInvertedLamp("blue_inverted_redstone_lamp", MapColor.COLOR_BLUE);
    public static final DeferredBlock<Block> PURPLE_INVERTED_REDSTONE_LAMP = registerInvertedLamp("purple_inverted_redstone_lamp", MapColor.COLOR_PURPLE);
    public static final DeferredBlock<Block> MAGENTA_INVERTED_REDSTONE_LAMP = registerInvertedLamp("magenta_inverted_redstone_lamp", MapColor.COLOR_MAGENTA);
    public static final DeferredBlock<Block> PINK_INVERTED_REDSTONE_LAMP = registerInvertedLamp("pink_inverted_redstone_lamp", MapColor.COLOR_PINK);

    private ModBlocks() {
    }

    private static DeferredBlock<Block> registerLamp(String name, MapColor mapColor) {
        return registerBlock(name, () -> new RedstoneLampBlock(lampProperties(name, mapColor)));
    }

    private static DeferredBlock<Block> registerInvertedLamp(String name, MapColor mapColor) {
        return registerBlock(name, () -> new InvertedRedstoneLampBlock(lampProperties(name, mapColor)));
    }

    private static BlockBehaviour.Properties lampProperties(String name, MapColor mapColor) {
        return BlockBehaviour.Properties.of()
                .setId(blockId(name))
                .mapColor(mapColor)
                .strength(0.3F)
                .sound(SoundType.GLASS)
                .lightLevel(litBlockEmission(15));
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> blockSupplier) {
        DeferredBlock<T> block = BLOCKS.register(name, blockSupplier);
        registerBlockItem(name, block);
        return block;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().setId(itemId(name))));
    }

    private static ResourceKey<Block> blockId(String path) {
        return ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID, path));
    }

    private static ResourceKey<Item> itemId(String path) {
        return ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID, path));
    }

    private static ToIntFunction<BlockState> litBlockEmission(int value) {
        return state -> state.getValue(RedstoneLampBlock.LIT) ? value : 0;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
