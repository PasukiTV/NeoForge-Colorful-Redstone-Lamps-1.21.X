package de.pasuki.colorful_redstone_lamps;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = ColorfulRedstoneLamps.MOD_ID, dist = Dist.CLIENT)
public class ColorfulRedstoneLampsClient {
    public ColorfulRedstoneLampsClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}
