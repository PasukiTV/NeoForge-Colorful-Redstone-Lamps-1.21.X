package de.pasuki.colorful_redstone_lamps.data;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, ColorfulRedstoneLamps.MOD_ID);
    }

    public static final TagKey<Block> ANY_LAMP =
            TagKey.create(net.minecraft.core.registries.Registries.BLOCK,
                    ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID, "any_lamp"));

    public static final TagKey<Block> LAMPS =
            TagKey.create(net.minecraft.core.registries.Registries.BLOCK,
                    ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID, "redstone_lamps"));

    public static final TagKey<Block> INVERTED_LAMPS =
            TagKey.create(net.minecraft.core.registries.Registries.BLOCK,
                    ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID, "inverted_redstone_lamps"));



    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // Eigene Gruppen
        var lamps = this.tag(LAMPS);
        var inverted = this.tag(INVERTED_LAMPS);
        for (DyeColor c : DyeColor.values()) {
            lamps.add(ModBlocks.LAMPS.get(c).get());
            inverted.add(ModBlocks.INVERTED_LAMPS.get(c).get());
        }
        this.tag(ANY_LAMP).addTag(LAMPS).addTag(INVERTED_LAMPS);

        // (Optional) Vanilla Tag – nur aktivieren, wenn gewünscht:
        // Alle Lampen als „mit Spitzhacke abbaubar“
        // this.tag(BlockTags.MINEABLE_WITH_PICKAXE).addTag(ANY_LAMP);
    }
}
