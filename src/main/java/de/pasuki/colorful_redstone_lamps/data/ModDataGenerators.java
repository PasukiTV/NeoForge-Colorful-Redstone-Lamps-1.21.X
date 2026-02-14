package de.pasuki.colorful_redstone_lamps.data;

import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(
        modid = "colorful_redstone_lamps"
)
public final class ModDataGenerators {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput out = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookup = event.getLookupProvider();
        generator.addProvider(true, new ModRecipeProvider.Runner(out, lookup));
        generator.addProvider(true, new ModModelProvider(out));
        generator.addProvider(true, new ModEnglishLangProvider(out));
        generator.addProvider(true, new ModGermanLangProvider(out));
    }

    @SubscribeEvent
    public static void gatherServerData(GatherDataEvent.Server event) {
        DataGenerator generator = event.getGenerator();
        PackOutput out = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookup = event.getLookupProvider();
        generator.addProvider(true, new ModLootTableProvider(out, lookup));
        ModBlockTagsProvider blockTags = new ModBlockTagsProvider(out, lookup);
        generator.addProvider(true, blockTags);
        generator.addProvider(true, new ModItemTagsProvider(out, lookup));
    }
}
