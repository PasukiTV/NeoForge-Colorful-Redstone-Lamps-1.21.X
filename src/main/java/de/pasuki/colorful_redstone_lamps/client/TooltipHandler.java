package de.pasuki.colorful_redstone_lamps.client;

import de.pasuki.colorful_redstone_lamps.data.ModItemTagsProvider;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

public final class TooltipHandler {
    public static void onTooltip(ItemTooltipEvent e) {
        ItemStack stack = e.getItemStack();
        if (!stack.isEmpty()) {
            if (stack.is(ModItemTagsProvider.LAMPS)) {
                e.getToolTip().add(Component.translatable("tooltip.colorful_redstone_lamps.lamp.normal").withStyle(ChatFormatting.GRAY));
            } else if (stack.is(ModItemTagsProvider.INVERTED_LAMPS)) {
                e.getToolTip().add(Component.translatable("tooltip.colorful_redstone_lamps.lamp.inverted").withStyle(ChatFormatting.GRAY));
            }

        }
    }
}
