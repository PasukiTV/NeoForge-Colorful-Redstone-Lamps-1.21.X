package de.pasuki.colorful_redstone_lamps.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
        // Keine bereits vorhandenen Loot-Tables ersetzen -> leeres Set
        super(output,
                Set.of(),
                List.of(new SubProviderEntry(ModBlockLoot::new, LootContextParamSets.BLOCK)),
                lookup);
    }
}
