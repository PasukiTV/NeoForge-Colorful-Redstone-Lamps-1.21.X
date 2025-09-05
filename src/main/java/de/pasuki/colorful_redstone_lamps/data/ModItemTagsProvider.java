package de.pasuki.colorful_redstone_lamps.data;

import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;          // <-- Mojang!
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {

    public static final TagKey<Item> ANY_LAMP =
            TagKey.create(net.minecraft.core.registries.Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath("colorful_redstone_lamps", "any_lamp"));
    public static final TagKey<Item> LAMPS =
            TagKey.create(net.minecraft.core.registries.Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath("colorful_redstone_lamps", "redstone_lamps"));
    public static final TagKey<Item> INVERTED_LAMPS =
            TagKey.create(net.minecraft.core.registries.Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath("colorful_redstone_lamps", "inverted_redstone_lamps"));

    // Mojang-Konstruktor: (PackOutput, CompletableFuture<HolderLookup.Provider>, CompletableFuture<TagLookup<Block>>)
    public ModItemTagsProvider(PackOutput output,
                               CompletableFuture<HolderLookup.Provider> lookupProvider,
                               CompletableFuture<TagsProvider.TagLookup<Block>> blockTagLookup) {
        super(output, lookupProvider, blockTagLookup);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        for (DyeColor c : DyeColor.values()) {
            tag(LAMPS).add(ModBlocks.LAMPS.get(c).get().asItem());
            tag(INVERTED_LAMPS).add(ModBlocks.INVERTED_LAMPS.get(c).get().asItem());
        }
        tag(ANY_LAMP).addTag(LAMPS).addTag(INVERTED_LAMPS);
    }
}
