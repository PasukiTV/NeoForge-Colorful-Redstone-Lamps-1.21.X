package de.pasuki.colorful_redstone_lamps.data;

import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import java.util.Set;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

public class ModBlockLoot extends BlockLootSubProvider {
    public ModBlockLoot(HolderLookup.Provider lookup) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), lookup);
    }

    @Override
    protected void generate() {
        for (Block block : getKnownBlocks()) {
            dropSelf(block);
        }
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(deferredBlock -> deferredBlock.get()).toList();
    }
}
