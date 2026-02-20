package de.pasuki.colorful_redstone_lamps;

import com.mojang.logging.LogUtils;
import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import de.pasuki.colorful_redstone_lamps.item.ModCreativeModeTab;
import de.pasuki.colorful_redstone_lamps.item.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(ColorfulRedstoneLamps.MOD_ID)
public class ColorfulRedstoneLamps {
    public static final String MOD_ID = "colorful_redstone_lamps";
//    public static final Logger LOGGER = LogUtils.getLogger();

    public ColorfulRedstoneLamps(IEventBus modEventBus) {
        ModCreativeModeTab.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
    }

}
