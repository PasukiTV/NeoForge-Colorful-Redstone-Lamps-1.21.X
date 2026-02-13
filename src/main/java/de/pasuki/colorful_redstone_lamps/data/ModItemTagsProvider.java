package de.pasuki.colorful_redstone_lamps.data;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {

    public static final TagKey<Item> ANY_LAMP =
            TagKey.create(Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID, "any_lamp"));
    public static final TagKey<Item> LAMPS =
            TagKey.create(Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID, "redstone_lamps"));
    public static final TagKey<Item> INVERTED_LAMPS =
            TagKey.create(Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID, "inverted_redstone_lamps"));

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
