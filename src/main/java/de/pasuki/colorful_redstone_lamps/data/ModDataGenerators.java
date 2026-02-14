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
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput out = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookup = event.getLookupProvider();
        boolean includeClient = event.includeClient();
        boolean includeServer = event.includeServer();

        generator.addProvider(includeServer, new ModRecipeProvider.Runner(out, lookup));
        generator.addProvider(includeClient, new ModModelProvider(out));
        generator.addProvider(includeClient, new ModEnglishLangProvider(out));
        generator.addProvider(includeClient, new ModGermanLangProvider(out));
        generator.addProvider(includeServer, new ModLootTableProvider(out, lookup));
        ModBlockTagsProvider blockTags = new ModBlockTagsProvider(out, lookup);
        generator.addProvider(includeServer, blockTags);
        generator.addProvider(includeServer, new ModItemTagsProvider(out, lookup));
    }
}
