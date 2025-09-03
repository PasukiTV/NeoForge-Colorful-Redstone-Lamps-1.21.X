package de.pasuki.colorful_redstone_lamps.block;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import de.pasuki.colorful_redstone_lamps.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(ColorfulRedstoneLamps.MOD_ID);

    //Functions
    private static ToIntFunction<BlockState> litBlockEmission(int value) {
        return state -> state.getValue(RedstoneLampBlock.LIT) ? value : 0;
    }

    private static boolean always(BlockState s, BlockGetter g, BlockPos p, EntityType<?> t) {
        return true;
    }

    private static boolean never(BlockState s, BlockGetter g, BlockPos p, EntityType<?> t) {
        return false;
    }

    //ModBlocks
    public static final DeferredBlock<Block> WHITE_REDSTONE_LAMP = registerBlock(
            "white_redstone_lamp",
            () -> new RedstoneLampBlock(
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID,"white_redstone_lamp")))
                            .mapColor(MapColor.QUARTZ) // optional
                            .strength(0.3F)
                            .sound(SoundType.GLASS)
                            .lightLevel(litBlockEmission(15))
                            .isValidSpawn(ModBlocks::always)
            )
    );
    public static final DeferredBlock<Block> LIGHT_GRAY_REDSTONE_LAMP = registerBlock(
            "light_gray_redstone_lamp",
            () -> new RedstoneLampBlock(
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID,"light_gray_redstone_lamp")))
                            .mapColor(MapColor.COLOR_LIGHT_GRAY) // optional
                            .strength(0.3F)
                            .sound(SoundType.GLASS)
                            .lightLevel(litBlockEmission(15))
                            .isValidSpawn(ModBlocks::always)
            )
    );
    public static final DeferredBlock<Block> GRAY_REDSTONE_LAMP = registerBlock(
            "gray_redstone_lamp",
            () -> new RedstoneLampBlock(
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID,"gray_redstone_lamp")))
                            .mapColor(MapColor.COLOR_GRAY) // optional
                            .strength(0.3F)
                            .sound(SoundType.GLASS)
                            .lightLevel(litBlockEmission(15))
                            .isValidSpawn(ModBlocks::always)
            )
    );
    public static final DeferredBlock<Block> BLACK_REDSTONE_LAMP = registerBlock(
            "black_redstone_lamp",
            () -> new RedstoneLampBlock(
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID,"black_redstone_lamp")))
                            .mapColor(MapColor.QUARTZ) // optional
                            .strength(0.3F)
                            .sound(SoundType.GLASS)
                            .lightLevel(litBlockEmission(15))
                            .isValidSpawn(ModBlocks::always)
            )
    );
    public static final DeferredBlock<Block> BROWN_REDSTONE_LAMP = registerBlock(
            "brown_redstone_lamp",
            () -> new RedstoneLampBlock(
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID,"brown_redstone_lamp")))
                            .mapColor(MapColor.QUARTZ) // optional
                            .strength(0.3F)
                            .sound(SoundType.GLASS)
                            .lightLevel(litBlockEmission(15))
                            .isValidSpawn(ModBlocks::always)
            )
    );
    public static final DeferredBlock<Block> RED_REDSTONE_LAMP = registerBlock(
            "red_redstone_lamp",
            () -> new RedstoneLampBlock(
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID,"red_redstone_lamp")))
                            .mapColor(MapColor.QUARTZ) // optional
                            .strength(0.3F)
                            .sound(SoundType.GLASS)
                            .lightLevel(litBlockEmission(15))
                            .isValidSpawn(ModBlocks::always)
            )
    );
    public static final DeferredBlock<Block> ORANGE_REDSTONE_LAMP = registerBlock(
            "orange_redstone_lamp",
            () -> new RedstoneLampBlock(
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID,"orange_redstone_lamp")))
                            .mapColor(MapColor.QUARTZ) // optional
                            .strength(0.3F)
                            .sound(SoundType.GLASS)
                            .lightLevel(litBlockEmission(15))
                            .isValidSpawn(ModBlocks::always)
            )
    );
    public static final DeferredBlock<Block> YELLOW_REDSTONE_LAMP = registerBlock(
            "yellow_redstone_lamp",
            () -> new RedstoneLampBlock(
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID,"yellow_redstone_lamp")))
                            .mapColor(MapColor.QUARTZ) // optional
                            .strength(0.3F)
                            .sound(SoundType.GLASS)
                            .lightLevel(litBlockEmission(15))
                            .isValidSpawn(ModBlocks::always)
            )
    );
    public static final DeferredBlock<Block> LIME_REDSTONE_LAMP = registerBlock(
            "lime_redstone_lamp",
            () -> new RedstoneLampBlock(
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID,"lime_redstone_lamp")))
                            .mapColor(MapColor.QUARTZ) // optional
                            .strength(0.3F)
                            .sound(SoundType.GLASS)
                            .lightLevel(litBlockEmission(15))
                            .isValidSpawn(ModBlocks::always)
            )
    );
    public static final DeferredBlock<Block> GREEN_REDSTONE_LAMP = registerBlock(
            "green_redstone_lamp",
            () -> new RedstoneLampBlock(
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID,"green_redstone_lamp")))
                            .mapColor(MapColor.QUARTZ) // optional
                            .strength(0.3F)
                            .sound(SoundType.GLASS)
                            .lightLevel(litBlockEmission(15))
                            .isValidSpawn(ModBlocks::always)
            )
    );
    public static final DeferredBlock<Block> CYAN_REDSTONE_LAMP = registerBlock(
            "cyan_redstone_lamp",
            () -> new RedstoneLampBlock(
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID,"cyan_redstone_lamp")))
                            .mapColor(MapColor.QUARTZ) // optional
                            .strength(0.3F)
                            .sound(SoundType.GLASS)
                            .lightLevel(litBlockEmission(15))
                            .isValidSpawn(ModBlocks::always)
            )
    );
    public static final DeferredBlock<Block> LIGHT_BLUE_REDSTONE_LAMP = registerBlock(
            "light_blue_redstone_lamp",
            () -> new RedstoneLampBlock(
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID,"light_blue_redstone_lamp")))
                            .mapColor(MapColor.QUARTZ) // optional
                            .strength(0.3F)
                            .sound(SoundType.GLASS)
                            .lightLevel(litBlockEmission(15))
                            .isValidSpawn(ModBlocks::always)
            )
    );
    public static final DeferredBlock<Block> BLUE_REDSTONE_LAMP = registerBlock(
            "blue_redstone_lamp",
            () -> new RedstoneLampBlock(
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID,"blue_redstone_lamp")))
                            .mapColor(MapColor.QUARTZ) // optional
                            .strength(0.3F)
                            .sound(SoundType.GLASS)
                            .lightLevel(litBlockEmission(15))
                            .isValidSpawn(ModBlocks::always)
            )
    );
    public static final DeferredBlock<Block> PURPLE_REDSTONE_LAMP = registerBlock(
            "purple_redstone_lamp",
            () -> new RedstoneLampBlock(
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID,"purple_redstone_lamp")))
                            .mapColor(MapColor.QUARTZ) // optional
                            .strength(0.3F)
                            .sound(SoundType.GLASS)
                            .lightLevel(litBlockEmission(15))
                            .isValidSpawn(ModBlocks::always)
            )
    );
    public static final DeferredBlock<Block> MAGENTA_REDSTONE_LAMP = registerBlock(
            "magenta_redstone_lamp",
            () -> new RedstoneLampBlock(
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID,"magenta_redstone_lamp")))
                            .mapColor(MapColor.QUARTZ) // optional
                            .strength(0.3F)
                            .sound(SoundType.GLASS)
                            .lightLevel(litBlockEmission(15))
                            .isValidSpawn(ModBlocks::always)
            )
    );
    public static final DeferredBlock<Block> PINK_REDSTONE_LAMP = registerBlock(
            "pink_redstone_lamp",
            () -> new RedstoneLampBlock(
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID,"pink_redstone_lamp")))
                            .mapColor(MapColor.QUARTZ) // optional
                            .strength(0.3F)
                            .sound(SoundType.GLASS)
                            .lightLevel(litBlockEmission(15))
                            .isValidSpawn(ModBlocks::always)
            )
    );

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T  extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID, name)))));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
