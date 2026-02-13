package de.pasuki.colorful_redstone_lamps;

import net.neoforged.api.distmarker.Dist;
import de.pasuki.colorful_redstone_lamps.client.TooltipHandler;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

@Mod(value = ColorfulRedstoneLamps.MOD_ID, dist = Dist.CLIENT)
public class ColorfulRedstoneLampsClient {
    public ColorfulRedstoneLampsClient() {
        NeoForge.EVENT_BUS.addListener(TooltipHandler::onTooltip);
    }

}
