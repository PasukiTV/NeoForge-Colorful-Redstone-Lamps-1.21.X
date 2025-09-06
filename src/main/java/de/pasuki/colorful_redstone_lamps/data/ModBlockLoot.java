package de.pasuki.colorful_redstone_lamps.data;

import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.data.loot.BlockLootSubProvider;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ModBlockLoot extends BlockLootSubProvider {

    public ModBlockLoot(HolderLookup.Provider lookup) {
        // 1.21.x: first arg = explosion-resistant items (none), second = feature flags
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), lookup);
    }

    @Override
    protected void generate() {
        // jede Lampe dropt sich selbst
        streamAllBlocks().forEach(b -> dropSelf(b));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return streamAllBlocks().toList();
    }

    private Stream<Block> streamAllBlocks() {
        Stream<Block> normal = ModBlocks.LAMPS.values().stream().map(Supplier::get);
        Stream<Block> inverted = ModBlocks.INVERTED_LAMPS.values().stream().map(Supplier::get);
        return Stream.concat(normal, inverted);
    }
}
