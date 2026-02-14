package de.pasuki.colorful_redstone_lamps.data;

import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagAppender;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public static final TagKey<Block> ANY_LAMP;
    public static final TagKey<Block> LAMPS;
    public static final TagKey<Block> INVERTED_LAMPS;

    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, "colorful_redstone_lamps");
    }

    protected void addTags(HolderLookup.Provider provider) {
        TagAppender<Block, Block> lamps = this.tag(LAMPS);
        TagAppender<Block, Block> inverted = this.tag(INVERTED_LAMPS);

        for(DyeColor c : DyeColor.values()) {
            lamps.add((Block)((DeferredBlock)ModBlocks.LAMPS.get(c)).get());
            inverted.add((Block)((DeferredBlock)ModBlocks.INVERTED_LAMPS.get(c)).get());
        }

        this.tag(ANY_LAMP).addTag(LAMPS).addTag(INVERTED_LAMPS);
    }

    static {
        ANY_LAMP = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("colorful_redstone_lamps", "any_lamp"));
        LAMPS = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("colorful_redstone_lamps", "redstone_lamps"));
        INVERTED_LAMPS = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("colorful_redstone_lamps", "inverted_redstone_lamps"));
    }
}