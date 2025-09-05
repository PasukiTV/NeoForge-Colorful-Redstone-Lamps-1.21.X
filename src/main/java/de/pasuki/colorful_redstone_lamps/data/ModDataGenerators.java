package de.pasuki.colorful_redstone_lamps.data;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public final class ModDataGenerators {
    private ModDataGenerators() {}

    // Wird über den Mod-EventBus als Listener registriert (keine Annotation nötig)
    public static void gatherData(GatherDataEvent event) {
        var generator   = event.getGenerator();
        var packOutput  = generator.getPackOutput();
        var fileHelper  = event.getExistingFileHelper();

        // Blockstates + Block-Modelle
        generator.addProvider(
                event.includeClient(),
                new ModBlockStateProvider(packOutput, ColorfulRedstoneLamps.MOD_ID, fileHelper)
        );

        // Item-Modelle
        generator.addProvider(
                event.includeClient(),
                new ModItemModelProvider(packOutput, ColorfulRedstoneLamps.MOD_ID, fileHelper)
        );
        generator.addProvider(event.includeClient(),
                new ModEnglishLangProvider(packOutput));

        generator.addProvider(event.includeClient(),
                new ModGermanLangProvider(packOutput));

        generator.addProvider(event.includeServer(),
                new ModRecipeProvider(packOutput, event.getLookupProvider()));

        generator.addProvider(event.includeServer(),
                new ModLootTableProvider(packOutput, event.getLookupProvider()));

        var blockTags = new ModBlockTagsProvider(packOutput, event.getLookupProvider(), fileHelper);
        generator.addProvider(event.includeServer(), blockTags);

// Mojang-ItemTagsProvider braucht den Block-Tag-Lookup:
        generator.addProvider(event.includeServer(),
                new ModItemTagsProvider(packOutput, event.getLookupProvider(), blockTags.contentsGetter()));

    }
}
