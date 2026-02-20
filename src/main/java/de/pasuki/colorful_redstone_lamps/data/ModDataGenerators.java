package de.pasuki.colorful_redstone_lamps.data;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = ColorfulRedstoneLamps.MOD_ID)
public final class ModDataGenerators {

    @SubscribeEvent
    // Registered from the mod constructor via mod event bus (no annotation required).
    public static void gatherData(GatherDataEvent event) {
        var generator   = event.getGenerator();
        var packOutput  = generator.getPackOutput();
        var fileHelper  = event.getExistingFileHelper();

        // Blockstates and block models
        generator.addProvider(
                event.includeClient(),
                new ModBlockStateProvider(packOutput, ColorfulRedstoneLamps.MOD_ID, fileHelper)
        );

        // Item models
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

        generator.addProvider(event.includeServer(),
                new ModItemTagsProvider(packOutput, event.getLookupProvider(), blockTags.contentsGetter()));

    }
}
