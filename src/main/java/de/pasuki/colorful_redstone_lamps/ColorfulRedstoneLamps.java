package de.pasuki.colorful_redstone_lamps;

import com.mojang.logging.LogUtils;
import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import de.pasuki.colorful_redstone_lamps.data.ModDataGenerators;
import de.pasuki.colorful_redstone_lamps.item.ModCreativeModeTab;
import de.pasuki.colorful_redstone_lamps.item.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig.Type;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod("colorful_redstone_lamps")
public class ColorfulRedstoneLamps {
    public static final String MOD_ID = "colorful_redstone_lamps";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ColorfulRedstoneLamps(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        ModCreativeModeTab.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(ModDataGenerators::gatherClientData);
        modEventBus.addListener(ModDataGenerators::gatherServerData);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
