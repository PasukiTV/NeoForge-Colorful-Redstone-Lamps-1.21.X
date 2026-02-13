package de.pasuki.colorful_redstone_lamps.client;

import de.pasuki.colorful_redstone_lamps.data.ModItemTagsProvider;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

public class TooltipHandler {
    public static void onTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (stack.isEmpty()) return;

        if (stack.is(ModItemTagsProvider.LAMPS)) {
            event.getToolTip().add(Component.translatable("tooltip.colorful_redstone_lamps.lamp.normal")
                    .withStyle(ChatFormatting.GRAY));
        } else if (stack.is(ModItemTagsProvider.INVERTED_LAMPS)) {
            event.getToolTip().add(Component.translatable("tooltip.colorful_redstone_lamps.lamp.inverted")
                    .withStyle(ChatFormatting.GRAY));
        }
    }
}
