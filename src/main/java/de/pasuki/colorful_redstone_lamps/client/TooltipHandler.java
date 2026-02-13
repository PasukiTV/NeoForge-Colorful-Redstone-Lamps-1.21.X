package de.pasuki.colorful_redstone_lamps.client;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import de.pasuki.colorful_redstone_lamps.data.ModItemTagsProvider;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

@EventBusSubscriber(modid = ColorfulRedstoneLamps.MOD_ID, value = Dist.CLIENT)
public final class TooltipHandler {
    private static final Component NORMAL_LAMP_TOOLTIP = Component
            .translatable("tooltip.colorful_redstone_lamps.lamp.normal")
            .withStyle(ChatFormatting.GRAY);
    private static final Component INVERTED_LAMP_TOOLTIP = Component
            .translatable("tooltip.colorful_redstone_lamps.lamp.inverted")
            .withStyle(ChatFormatting.GRAY);

    private TooltipHandler() {
    }

    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (stack.isEmpty()) {
            return;
        }

        if (stack.is(ModItemTagsProvider.LAMPS)) {
            event.getToolTip().add(NORMAL_LAMP_TOOLTIP);
        } else if (stack.is(ModItemTagsProvider.INVERTED_LAMPS)) {
            event.getToolTip().add(INVERTED_LAMP_TOOLTIP);
        }
    }
}
