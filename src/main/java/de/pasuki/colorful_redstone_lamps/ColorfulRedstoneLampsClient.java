package de.pasuki.colorful_redstone_lamps;

import de.pasuki.colorful_redstone_lamps.client.TooltipHandler;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(value = ColorfulRedstoneLamps.MOD_ID, dist = Dist.CLIENT)
public class ColorfulRedstoneLampsClient {
    public ColorfulRedstoneLampsClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
        NeoForge.EVENT_BUS.addListener((ItemTooltipEvent event) -> TooltipHandler.onTooltip(event));
    }
}
