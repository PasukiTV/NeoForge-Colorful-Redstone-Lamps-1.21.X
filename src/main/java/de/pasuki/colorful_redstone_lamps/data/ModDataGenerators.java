package de.pasuki.colorful_redstone_lamps.data;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = ColorfulRedstoneLamps.MOD_ID)
public final class ModDataGenerators {

    // -------- CLIENT --------
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput out         = generator.getPackOutput();
        var lookup             = event.getLookupProvider();

        // nur clientseitige Provider
        generator.addProvider(true, new ModRecipeProvider.Runner(out, lookup));
        generator.addProvider(true, new ModModelProvider(out));
        generator.addProvider(true, new ModEnglishLangProvider(out));
        generator.addProvider(true, new ModGermanLangProvider(out));
    }

    // -------- SERVER --------
    @SubscribeEvent
    public static void gatherServerData(GatherDataEvent.Server event) {
        DataGenerator generator = event.getGenerator();
        PackOutput out         = generator.getPackOutput();
        var lookup             = event.getLookupProvider();

        // Loot
        generator.addProvider(true, new ModLootTableProvider(out, lookup));

        // Block-Tags
        var blockTags = new ModBlockTagsProvider(out, lookup);
        generator.addProvider(true, blockTags);

        // Item-Tags (benötigen blockTags.contentsGetter())
        generator.addProvider(true,
                new ModItemTagsProvider(out, lookup));
    }
}
