package de.pasuki.colorful_redstone_lamps.data;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
        super(output, lookup);
    }

    @Override
    protected void buildRecipes(RecipeOutput out) {
        for (DyeColor c : DyeColor.values()) {
            String base = c.getName() + "_redstone_lamp";

            ItemLike resultNormal   = ModBlocks.LAMPS.get(c).get();
            ItemLike resultInverted = ModBlocks.INVERTED_LAMPS.get(c).get();

            Item dye = dyeFor(c);

            // Normale Lampe
            ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, resultNormal, 1)
                    .requires(Items.REDSTONE_LAMP)
                    .requires(dye)
                    .unlockedBy("has_redstone_lamp", has(Items.REDSTONE_LAMP))
                    .unlockedBy("has_dye_" + c.getName(), has(dye))
                    .save(out, id("craft/" + base));

            // Invertiert herstellen
            ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, resultInverted, 1)
                    .requires(resultNormal)
                    .unlockedBy("has_" + base, has(resultNormal))
                    .save(out, id("invert/" + base + "_to_inverted"));

            // Zurück wandeln
            ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, resultNormal, 1)
                    .requires(resultInverted)
                    .unlockedBy("has_" + base + "_inverted", has(resultInverted))
                    .save(out, id("invert/" + base + "_to_normal"));
        }
    }

    private static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID, path);
    }

    private static Item dyeFor(DyeColor c) {
        return switch (c) {
            case WHITE      -> Items.WHITE_DYE;
            case ORANGE     -> Items.ORANGE_DYE;
            case MAGENTA    -> Items.MAGENTA_DYE;
            case LIGHT_BLUE -> Items.LIGHT_BLUE_DYE;
            case YELLOW     -> Items.YELLOW_DYE;
            case LIME       -> Items.LIME_DYE;
            case PINK       -> Items.PINK_DYE;
            case GRAY       -> Items.GRAY_DYE;
            case LIGHT_GRAY -> Items.LIGHT_GRAY_DYE;
            case CYAN       -> Items.CYAN_DYE;
            case PURPLE     -> Items.PURPLE_DYE;
            case BLUE       -> Items.BLUE_DYE;
            case BROWN      -> Items.BROWN_DYE;
            case GREEN      -> Items.GREEN_DYE;
            case RED        -> Items.RED_DYE;
            case BLACK      -> Items.BLACK_DYE;
        };
    }
}
