package de.pasuki.colorful_redstone_lamps.datagen;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(net.minecraft.data.PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ColorfulRedstoneLamps.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        registerLamp(ModBlocks.WHITE_REDSTONE_LAMP, "white_redstone_lamp");
        registerLamp(ModBlocks.LIGHT_GRAY_REDSTONE_LAMP, "light_gray_redstone_lamp");
        registerLamp(ModBlocks.GRAY_REDSTONE_LAMP, "gray_redstone_lamp");
        registerLamp(ModBlocks.BLACK_REDSTONE_LAMP, "black_redstone_lamp");
        registerLamp(ModBlocks.BROWN_REDSTONE_LAMP, "brown_redstone_lamp");
        registerLamp(ModBlocks.RED_REDSTONE_LAMP, "red_redstone_lamp");
        registerLamp(ModBlocks.ORANGE_REDSTONE_LAMP, "orange_redstone_lamp");
        registerLamp(ModBlocks.YELLOW_REDSTONE_LAMP, "yellow_redstone_lamp");
        registerLamp(ModBlocks.LIME_REDSTONE_LAMP, "lime_redstone_lamp");
        registerLamp(ModBlocks.GREEN_REDSTONE_LAMP, "green_redstone_lamp");
        registerLamp(ModBlocks.CYAN_REDSTONE_LAMP, "cyan_redstone_lamp");
        registerLamp(ModBlocks.LIGHT_BLUE_REDSTONE_LAMP, "light_blue_redstone_lamp");
        registerLamp(ModBlocks.BLUE_REDSTONE_LAMP, "blue_redstone_lamp");
        registerLamp(ModBlocks.PURPLE_REDSTONE_LAMP, "purple_redstone_lamp");
        registerLamp(ModBlocks.MAGENTA_REDSTONE_LAMP, "magenta_redstone_lamp");
        registerLamp(ModBlocks.PINK_REDSTONE_LAMP, "pink_redstone_lamp");

        registerInvertedLamp(ModBlocks.WHITE_INVERTED_REDSTONE_LAMP, "white");
        registerInvertedLamp(ModBlocks.LIGHT_GRAY_INVERTED_REDSTONE_LAMP, "light_gray");
        registerInvertedLamp(ModBlocks.GRAY_INVERTED_REDSTONE_LAMP, "gray");
        registerInvertedLamp(ModBlocks.BLACK_INVERTED_REDSTONE_LAMP, "black");
        registerInvertedLamp(ModBlocks.BROWN_INVERTED_REDSTONE_LAMP, "brown");
        registerInvertedLamp(ModBlocks.RED_INVERTED_REDSTONE_LAMP, "red");
        registerInvertedLamp(ModBlocks.ORANGE_INVERTED_REDSTONE_LAMP, "orange");
        registerInvertedLamp(ModBlocks.YELLOW_INVERTED_REDSTONE_LAMP, "yellow");
        registerInvertedLamp(ModBlocks.LIME_INVERTED_REDSTONE_LAMP, "lime");
        registerInvertedLamp(ModBlocks.GREEN_INVERTED_REDSTONE_LAMP, "green");
        registerInvertedLamp(ModBlocks.CYAN_INVERTED_REDSTONE_LAMP, "cyan");
        registerInvertedLamp(ModBlocks.LIGHT_BLUE_INVERTED_REDSTONE_LAMP, "light_blue");
        registerInvertedLamp(ModBlocks.BLUE_INVERTED_REDSTONE_LAMP, "blue");
        registerInvertedLamp(ModBlocks.PURPLE_INVERTED_REDSTONE_LAMP, "purple");
        registerInvertedLamp(ModBlocks.MAGENTA_INVERTED_REDSTONE_LAMP, "magenta");
        registerInvertedLamp(ModBlocks.PINK_INVERTED_REDSTONE_LAMP, "pink");
    }

    private void registerLamp(DeferredBlock<Block> lamp, String name) {
        var offModel = models().cubeAll(name, modLoc("block/" + name));
        var onModel = models().cubeAll(name + "_on", modLoc("block/" + name + "_on"));

        getVariantBuilder(lamp.get())
                .partialState().with(net.minecraft.world.level.block.RedstoneLampBlock.LIT, false)
                .modelForState().modelFile(offModel).addModel()
                .partialState().with(net.minecraft.world.level.block.RedstoneLampBlock.LIT, true)
                .modelForState().modelFile(onModel).addModel();

        simpleBlockItem(lamp.get(), offModel);
    }

    private void registerInvertedLamp(DeferredBlock<Block> lamp, String baseColor) {
        String name = baseColor + "_inverted_redstone_lamp";
        var offModel = models().withExistingParent(name, modLoc("block/" + baseColor + "_redstone_lamp_on"));
        var onModel = models().withExistingParent(name + "_on", modLoc("block/" + baseColor + "_redstone_lamp"));

        getVariantBuilder(lamp.get())
                .partialState().with(net.minecraft.world.level.block.RedstoneLampBlock.LIT, false)
                .modelForState().modelFile(offModel).addModel()
                .partialState().with(net.minecraft.world.level.block.RedstoneLampBlock.LIT, true)
                .modelForState().modelFile(onModel).addModel();

        simpleBlockItem(lamp.get(), offModel);
    }
}
