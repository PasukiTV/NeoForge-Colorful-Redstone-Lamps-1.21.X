package de.pasuki.colorful_redstone_lamps;

import com.mojang.logging.LogUtils;
import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import de.pasuki.colorful_redstone_lamps.item.ModCreativeModeTab;
import de.pasuki.colorful_redstone_lamps.item.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(ColorfulRedstoneLamps.MOD_ID)
public class ColorfulRedstoneLamps {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "colorful_redstone_lamps";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public ColorfulRedstoneLamps(IEventBus modEventBus) {
        ModCreativeModeTab.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(de.pasuki.colorful_redstone_lamps.data.ModDataGenerators::gatherData);
    }
}
