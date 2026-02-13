package de.pasuki.colorful_redstone_lamps;

import com.mojang.logging.LogUtils;
import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import de.pasuki.colorful_redstone_lamps.item.ModCreativeModeTab;
import de.pasuki.colorful_redstone_lamps.item.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(ColorfulRedstoneLamps.MOD_ID)
public class ColorfulRedstoneLamps {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "colorful_redstone_lamps";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public ColorfulRedstoneLamps(IEventBus modEventBus, ModContainer modContainer) {
        ModCreativeModeTab.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(de.pasuki.colorful_redstone_lamps.data.ModDataGenerators::gatherData);
        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

}
