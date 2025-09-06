package de.pasuki.colorful_redstone_lamps.data;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        super(provider, recipeOutput);
    }

    public static class Runner extends RecipeProvider.Runner{
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider) {
            super(packOutput, provider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new ModRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "Colorful Redstone Lamps Recipes";
        }

    }

    @Override
    protected void buildRecipes() {
        for (DyeColor c : DyeColor.values()) {
            String base = c.getName() + "_redstone_lamp";

            ItemLike resultNormal   = ModBlocks.LAMPS.get(c).get();
            ItemLike resultInverted = ModBlocks.INVERTED_LAMPS.get(c).get();
            Item dye = dyeFor(c);

            // 1) Normale farbige Lampe: 1x Farbstoff + 1x Vanilla-Redstone-Lampe
            shapeless(RecipeCategory.REDSTONE, resultNormal, 1)
                    .requires(Items.REDSTONE_LAMP)
                    .requires(dye)
                    .unlockedBy("has_redstone_lamp", has(Items.REDSTONE_LAMP))
                    .unlockedBy("has_dye_" + c.getName(), has(dye))
                    .save(output, id("craft/" + base));

            // 2) Invertiert herstellen: farbige Lampe + Vanilla-Lampe -> invertiert
            shapeless(RecipeCategory.REDSTONE, resultInverted, 1)
                    .requires(resultNormal)
                    .unlockedBy("has_" + base, has(resultNormal))
                    .save(output, id("invert/" + base + "_to_inverted"));

            // 3) Zurück wandeln: invertiert + Vanilla-Lampe -> normal
            shapeless(RecipeCategory.REDSTONE, resultNormal, 1)
                    .requires(resultInverted)
                    .unlockedBy("has_" + base + "_inverted", has(resultInverted))
                    .save(output, id("invert/" + base + "_to_normal"));
        }
    }

    private static ResourceKey<Recipe<?>> id(String path) {
        return ResourceKey.create(Registries.RECIPE,ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID, path));
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
