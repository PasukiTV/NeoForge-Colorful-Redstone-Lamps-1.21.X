package de.pasuki.colorful_redstone_lamps.datagen;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        addColoredLampRecipe(ModBlocks.WHITE_REDSTONE_LAMP.get().asItem(), Items.WHITE_DYE, "white");
        addColoredLampRecipe(ModBlocks.LIGHT_GRAY_REDSTONE_LAMP.get().asItem(), Items.LIGHT_GRAY_DYE, "light_gray");
        addColoredLampRecipe(ModBlocks.GRAY_REDSTONE_LAMP.get().asItem(), Items.GRAY_DYE, "gray");
        addColoredLampRecipe(ModBlocks.BLACK_REDSTONE_LAMP.get().asItem(), Items.BLACK_DYE, "black");
        addColoredLampRecipe(ModBlocks.BROWN_REDSTONE_LAMP.get().asItem(), Items.BROWN_DYE, "brown");
        addColoredLampRecipe(ModBlocks.RED_REDSTONE_LAMP.get().asItem(), Items.RED_DYE, "red");
        addColoredLampRecipe(ModBlocks.ORANGE_REDSTONE_LAMP.get().asItem(), Items.ORANGE_DYE, "orange");
        addColoredLampRecipe(ModBlocks.YELLOW_REDSTONE_LAMP.get().asItem(), Items.YELLOW_DYE, "yellow");
        addColoredLampRecipe(ModBlocks.LIME_REDSTONE_LAMP.get().asItem(), Items.LIME_DYE, "lime");
        addColoredLampRecipe(ModBlocks.GREEN_REDSTONE_LAMP.get().asItem(), Items.GREEN_DYE, "green");
        addColoredLampRecipe(ModBlocks.CYAN_REDSTONE_LAMP.get().asItem(), Items.CYAN_DYE, "cyan");
        addColoredLampRecipe(ModBlocks.LIGHT_BLUE_REDSTONE_LAMP.get().asItem(), Items.LIGHT_BLUE_DYE, "light_blue");
        addColoredLampRecipe(ModBlocks.BLUE_REDSTONE_LAMP.get().asItem(), Items.BLUE_DYE, "blue");
        addColoredLampRecipe(ModBlocks.PURPLE_REDSTONE_LAMP.get().asItem(), Items.PURPLE_DYE, "purple");
        addColoredLampRecipe(ModBlocks.MAGENTA_REDSTONE_LAMP.get().asItem(), Items.MAGENTA_DYE, "magenta");
        addColoredLampRecipe(ModBlocks.PINK_REDSTONE_LAMP.get().asItem(), Items.PINK_DYE, "pink");

        addInvertedRecipe(ModBlocks.WHITE_INVERTED_REDSTONE_LAMP.get().asItem(), ModBlocks.WHITE_REDSTONE_LAMP.get().asItem(), "white");
        addInvertedRecipe(ModBlocks.LIGHT_GRAY_INVERTED_REDSTONE_LAMP.get().asItem(), ModBlocks.LIGHT_GRAY_REDSTONE_LAMP.get().asItem(), "light_gray");
        addInvertedRecipe(ModBlocks.GRAY_INVERTED_REDSTONE_LAMP.get().asItem(), ModBlocks.GRAY_REDSTONE_LAMP.get().asItem(), "gray");
        addInvertedRecipe(ModBlocks.BLACK_INVERTED_REDSTONE_LAMP.get().asItem(), ModBlocks.BLACK_REDSTONE_LAMP.get().asItem(), "black");
        addInvertedRecipe(ModBlocks.BROWN_INVERTED_REDSTONE_LAMP.get().asItem(), ModBlocks.BROWN_REDSTONE_LAMP.get().asItem(), "brown");
        addInvertedRecipe(ModBlocks.RED_INVERTED_REDSTONE_LAMP.get().asItem(), ModBlocks.RED_REDSTONE_LAMP.get().asItem(), "red");
        addInvertedRecipe(ModBlocks.ORANGE_INVERTED_REDSTONE_LAMP.get().asItem(), ModBlocks.ORANGE_REDSTONE_LAMP.get().asItem(), "orange");
        addInvertedRecipe(ModBlocks.YELLOW_INVERTED_REDSTONE_LAMP.get().asItem(), ModBlocks.YELLOW_REDSTONE_LAMP.get().asItem(), "yellow");
        addInvertedRecipe(ModBlocks.LIME_INVERTED_REDSTONE_LAMP.get().asItem(), ModBlocks.LIME_REDSTONE_LAMP.get().asItem(), "lime");
        addInvertedRecipe(ModBlocks.GREEN_INVERTED_REDSTONE_LAMP.get().asItem(), ModBlocks.GREEN_REDSTONE_LAMP.get().asItem(), "green");
        addInvertedRecipe(ModBlocks.CYAN_INVERTED_REDSTONE_LAMP.get().asItem(), ModBlocks.CYAN_REDSTONE_LAMP.get().asItem(), "cyan");
        addInvertedRecipe(ModBlocks.LIGHT_BLUE_INVERTED_REDSTONE_LAMP.get().asItem(), ModBlocks.LIGHT_BLUE_REDSTONE_LAMP.get().asItem(), "light_blue");
        addInvertedRecipe(ModBlocks.BLUE_INVERTED_REDSTONE_LAMP.get().asItem(), ModBlocks.BLUE_REDSTONE_LAMP.get().asItem(), "blue");
        addInvertedRecipe(ModBlocks.PURPLE_INVERTED_REDSTONE_LAMP.get().asItem(), ModBlocks.PURPLE_REDSTONE_LAMP.get().asItem(), "purple");
        addInvertedRecipe(ModBlocks.MAGENTA_INVERTED_REDSTONE_LAMP.get().asItem(), ModBlocks.MAGENTA_REDSTONE_LAMP.get().asItem(), "magenta");
        addInvertedRecipe(ModBlocks.PINK_INVERTED_REDSTONE_LAMP.get().asItem(), ModBlocks.PINK_REDSTONE_LAMP.get().asItem(), "pink");
    }

    private void addColoredLampRecipe(net.minecraft.world.item.Item result, net.minecraft.world.item.Item dye, String colorName) {
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, result)
                .pattern(" X ")
                .pattern("X#X")
                .pattern(" X ")
                .define('#', Items.REDSTONE_LAMP)
                .define('X', dye)
                .unlockedBy("has_" + colorName + "_dye", has(dye))
                .save(this.output, ColorfulRedstoneLamps.MOD_ID + ":" + colorName + "_redstone_lamp");
    }

    private void addInvertedRecipe(net.minecraft.world.item.Item result, net.minecraft.world.item.Item baseLamp, String colorName) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, result)
                .requires(baseLamp)
                .requires(Items.REDSTONE_TORCH)
                .unlockedBy("has_" + colorName + "_redstone_lamp", has(baseLamp))
                .save(this.output, ColorfulRedstoneLamps.MOD_ID + ":" + colorName + "_inverted_redstone_lamp");
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
            super(output, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new ModRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return "Colorful Redstone Lamps Recipes";
        }
    }
}
