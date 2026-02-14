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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemTagsProvider extends ItemTagsProvider {
    public static final TagKey<Item> ANY_LAMP;
    public static final TagKey<Item> LAMPS;
    public static final TagKey<Item> INVERTED_LAMPS;

    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, "colorful_redstone_lamps");
    }

    protected void addTags(HolderLookup.Provider provider) {
        for(DyeColor c : DyeColor.values()) {
            this.tag(LAMPS).add(((Block)((DeferredBlock)ModBlocks.LAMPS.get(c)).get()).asItem());
            this.tag(INVERTED_LAMPS).add(((Block)((DeferredBlock)ModBlocks.INVERTED_LAMPS.get(c)).get()).asItem());
        }

        this.tag(ANY_LAMP).addTag(LAMPS).addTag(INVERTED_LAMPS);
    }

    static {
        ANY_LAMP = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("colorful_redstone_lamps", "any_lamp"));
        LAMPS = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("colorful_redstone_lamps", "redstone_lamps"));
        INVERTED_LAMPS = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("colorful_redstone_lamps", "inverted_redstone_lamps"));
    }
}
