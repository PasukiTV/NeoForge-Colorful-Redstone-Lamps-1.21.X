package de.pasuki.colorful_redstone_lamps.data;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = ColorfulRedstoneLamps.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class ModDataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator   = event.getGenerator();
        PackOutput packOutput     = generator.getPackOutput();
        ExistingFileHelper efh    = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // ---------- CLIENT ----------
        generator.addProvider(event.includeServer(),
                new ModRecipeProvider.Runner(packOutput, lookupProvider));

        generator.addProvider(event.includeClient(),
                new ModBlockStateProvider(packOutput, ColorfulRedstoneLamps.MOD_ID, efh));
        generator.addProvider(event.includeClient(),
                new ModItemModelProvider(packOutput, ColorfulRedstoneLamps.MOD_ID, efh));
        generator.addProvider(event.includeClient(),
                new ModEnglishLangProvider(packOutput));
        generator.addProvider(event.includeClient(),
                new ModGermanLangProvider(packOutput));

        // ---------- SERVER ----------


        DataProvider.Factory<ModLootTableProvider> lootFactory =
                (PackOutput out) -> new ModLootTableProvider(out, event.getLookupProvider());

        // Block-Tags (direkt als Provider – benötigt ExistingFileHelper)
        var blockTags = new ModBlockTagsProvider(packOutput, event.getLookupProvider(), efh);

        DataProvider.Factory<ModItemTagsProvider> itemTagsFactory =
                (PackOutput out) -> new ModItemTagsProvider(out, event.getLookupProvider(), blockTags.contentsGetter());

        // Registrieren
        generator.addProvider(event.includeServer(), lootFactory);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), itemTagsFactory);
    }
}
