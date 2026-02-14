package de.pasuki.colorful_redstone_lamps;

import net.neoforged.api.distmarker.Dist;
import de.pasuki.colorful_redstone_lamps.client.TooltipHandler;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.NeoForge;

@Mod(
        value = "colorful_redstone_lamps",
        dist = {Dist.CLIENT}
)
@EventBusSubscriber(
        modid = "colorful_redstone_lamps"
)
public class ColorfulRedstoneLampsClient {
    public ColorfulRedstoneLampsClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
        NeoForge.EVENT_BUS.addListener(TooltipHandler::onTooltip);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
    }
}
