package de.pasuki.colorful_redstone_lamps.client;

import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

public final class TooltipHandler {
    private static final Component NORMAL_LAMP_TOOLTIP = Component
            .translatable("tooltip.colorful_redstone_lamps.lamp.normal")
            .withStyle(ChatFormatting.GRAY);
    private static final Component INVERTED_LAMP_TOOLTIP = Component
            .translatable("tooltip.colorful_redstone_lamps.lamp.inverted")
            .withStyle(ChatFormatting.GRAY);

    private TooltipHandler() {
    }

    public static void onTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (stack.isEmpty()) {
            return;
        }

        Item item = stack.getItem();
        if (isNormalLamp(item)) {
            event.getToolTip().add(NORMAL_LAMP_TOOLTIP);
        } else if (isInvertedLamp(item)) {
            event.getToolTip().add(INVERTED_LAMP_TOOLTIP);
        }
    }

    private static boolean isNormalLamp(Item item) {
        return ModBlocks.LAMPS.values().stream().anyMatch(block -> block.get().asItem() == item);
    }

    private static boolean isInvertedLamp(Item item) {
        return ModBlocks.INVERTED_LAMPS.values().stream().anyMatch(block -> block.get().asItem() == item);
    }
}
