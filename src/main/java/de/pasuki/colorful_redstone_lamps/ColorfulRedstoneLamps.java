package de.pasuki.colorful_redstone_lamps;

import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import de.pasuki.colorful_redstone_lamps.datagen.ModDataGenerators;
import de.pasuki.colorful_redstone_lamps.item.ModCreativeModeTab;
import de.pasuki.colorful_redstone_lamps.item.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(ColorfulRedstoneLamps.MOD_ID)
public class ColorfulRedstoneLamps {
    public static final String MOD_ID = "colorful_redstone_lamps";

    public ColorfulRedstoneLamps(IEventBus modEventBus, ModContainer modContainer) {
        // Register all mod content in a single, predictable place.
        modEventBus.addListener(ModDataGenerators::gatherData);
        ModCreativeModeTab.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Keep a dedicated common config file even if currently empty.
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
