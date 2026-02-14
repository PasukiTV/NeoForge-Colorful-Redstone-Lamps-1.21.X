package de.pasuki.colorful_redstone_lamps.data;

import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public final class ModDataGenerators {
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput out = generator.getPackOutput();

        generator.addProvider(true, new ModModelProvider(out));
        generator.addProvider(true, new ModEnglishLangProvider(out));
        generator.addProvider(true, new ModGermanLangProvider(out));
    }

    public static void gatherServerData(GatherDataEvent.Server event) {
        DataGenerator generator = event.getGenerator();
        PackOutput out = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookup = event.getLookupProvider();

        generator.addProvider(true, new ModRecipeProvider.Runner(out, lookup));
        generator.addProvider(true, new ModLootTableProvider(out, lookup));
        ModBlockTagsProvider blockTags = new ModBlockTagsProvider(out, lookup);
        generator.addProvider(true, blockTags);
        generator.addProvider(true, new ModItemTagsProvider(out, lookup));
    }
}
