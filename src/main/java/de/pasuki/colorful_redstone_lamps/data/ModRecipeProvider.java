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

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    private static final Map<DyeColor, Item> DYE_ITEMS = createDyeItemMap();

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
        super(output, lookup);
    }

    @Override
    protected void buildRecipes(RecipeOutput out) {
        for (DyeColor c : DyeColor.values()) {
            String base = c.getName() + "_redstone_lamp";

            ItemLike resultNormal = ModBlocks.LAMPS.get(c).get();
            ItemLike resultInverted = ModBlocks.INVERTED_LAMPS.get(c).get();
            Item dye = DYE_ITEMS.get(c);

            ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, resultNormal, 1)
                    .requires(Items.REDSTONE_LAMP)
                    .requires(dye)
                    .unlockedBy("has_redstone_lamp", has(Items.REDSTONE_LAMP))
                    .unlockedBy("has_dye_" + c.getName(), has(dye))
                    .save(out, id("craft/" + base));

            ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, resultInverted, 1)
                    .requires(resultNormal)
                    .unlockedBy("has_" + base, has(resultNormal))
                    .save(out, id("invert/" + base + "_to_inverted"));

            ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, resultNormal, 1)
                    .requires(resultInverted)
                    .unlockedBy("has_" + base + "_inverted", has(resultInverted))
                    .save(out, id("invert/" + base + "_to_normal"));
        }
    }

    private static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID, path);
    }

    private static Map<DyeColor, Item> createDyeItemMap() {
        Map<DyeColor, Item> dyes = new EnumMap<>(DyeColor.class);
        dyes.put(DyeColor.WHITE, Items.WHITE_DYE);
        dyes.put(DyeColor.ORANGE, Items.ORANGE_DYE);
        dyes.put(DyeColor.MAGENTA, Items.MAGENTA_DYE);
        dyes.put(DyeColor.LIGHT_BLUE, Items.LIGHT_BLUE_DYE);
        dyes.put(DyeColor.YELLOW, Items.YELLOW_DYE);
        dyes.put(DyeColor.LIME, Items.LIME_DYE);
        dyes.put(DyeColor.PINK, Items.PINK_DYE);
        dyes.put(DyeColor.GRAY, Items.GRAY_DYE);
        dyes.put(DyeColor.LIGHT_GRAY, Items.LIGHT_GRAY_DYE);
        dyes.put(DyeColor.CYAN, Items.CYAN_DYE);
        dyes.put(DyeColor.PURPLE, Items.PURPLE_DYE);
        dyes.put(DyeColor.BLUE, Items.BLUE_DYE);
        dyes.put(DyeColor.BROWN, Items.BROWN_DYE);
        dyes.put(DyeColor.GREEN, Items.GREEN_DYE);
        dyes.put(DyeColor.RED, Items.RED_DYE);
        dyes.put(DyeColor.BLACK, Items.BLACK_DYE);
        return dyes;
    }
}
