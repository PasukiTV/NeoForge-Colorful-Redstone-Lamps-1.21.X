//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package de.pasuki.colorful_redstone_lamps.data;

import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import java.util.concurrent.CompletableFuture;
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
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        super(provider, recipeOutput);
    }

    protected void buildRecipes() {
        for(DyeColor c : DyeColor.values()) {
            String base = c.getName() + "_redstone_lamp";
            ItemLike resultNormal = (ItemLike)((DeferredBlock)ModBlocks.LAMPS.get(c)).get();
            ItemLike resultInverted = (ItemLike)((DeferredBlock)ModBlocks.INVERTED_LAMPS.get(c)).get();
            Item dye = dyeFor(c);
            this.shapeless(RecipeCategory.REDSTONE, resultNormal, 1).requires(Items.REDSTONE_LAMP).requires(dye).unlockedBy("has_redstone_lamp", this.has(Items.REDSTONE_LAMP)).unlockedBy("has_dye_" + c.getName(), this.has(dye)).save(this.output, id("craft/" + base));
            this.shapeless(RecipeCategory.REDSTONE, resultInverted, 1).requires(resultNormal).unlockedBy("has_" + base, this.has(resultNormal)).save(this.output, id("invert/" + base + "_to_inverted"));
            this.shapeless(RecipeCategory.REDSTONE, resultNormal, 1).requires(resultInverted).unlockedBy("has_" + base + "_inverted", this.has(resultInverted)).save(this.output, id("invert/" + base + "_to_normal"));
        }

    }

    private static ResourceKey<Recipe<?>> id(String path) {
        return ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath("colorful_redstone_lamps", path));
    }

    private static Item dyeFor(DyeColor c) {
        Item var10000;
        switch (c) {
            case WHITE -> var10000 = Items.WHITE_DYE;
            case ORANGE -> var10000 = Items.ORANGE_DYE;
            case MAGENTA -> var10000 = Items.MAGENTA_DYE;
            case LIGHT_BLUE -> var10000 = Items.LIGHT_BLUE_DYE;
            case YELLOW -> var10000 = Items.YELLOW_DYE;
            case LIME -> var10000 = Items.LIME_DYE;
            case PINK -> var10000 = Items.PINK_DYE;
            case GRAY -> var10000 = Items.GRAY_DYE;
            case LIGHT_GRAY -> var10000 = Items.LIGHT_GRAY_DYE;
            case CYAN -> var10000 = Items.CYAN_DYE;
            case PURPLE -> var10000 = Items.PURPLE_DYE;
            case BLUE -> var10000 = Items.BLUE_DYE;
            case BROWN -> var10000 = Items.BROWN_DYE;
            case GREEN -> var10000 = Items.GREEN_DYE;
            case RED -> var10000 = Items.RED_DYE;
            case BLACK -> var10000 = Items.BLACK_DYE;
            default -> throw new MatchException((String)null, (Throwable)null);
        }

        return var10000;
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider) {
            super(packOutput, provider);
        }

        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new ModRecipeProvider(provider, recipeOutput);
        }

        public String getName() {
            return "Colorful Redstone Lamps Recipes";
        }
    }
}
