package de.pasuki.colorful_redstone_lamps.data;

import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Stream;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

public class ModBlockLoot extends BlockLootSubProvider {
    public ModBlockLoot(HolderLookup.Provider lookup) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), lookup);
    }

    protected void generate() {
        this.streamAllBlocks().forEach((b) -> this.dropSelf(b));
    }

    protected Iterable<Block> getKnownBlocks() {
        return this.streamAllBlocks().toList();
    }

    private Stream<Block> streamAllBlocks() {
        Stream<Block> normal = ModBlocks.LAMPS.values().stream().map(Supplier::get);
        Stream<Block> inverted = ModBlocks.INVERTED_LAMPS.values().stream().map(Supplier::get);
        return Stream.concat(normal, inverted);
    }
}
