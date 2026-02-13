package de.pasuki.colorful_redstone_lamps.client;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

public final class TooltipHandler {
    private static final String NORMAL_SUFFIX = "_redstone_lamp";
    private static final String INVERTED_SUFFIX = "_redstone_lamp_inverted";

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

        ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(stack.getItem());
        if (!ColorfulRedstoneLamps.MOD_ID.equals(itemId.getNamespace())) {
            return;
        }

        String path = itemId.getPath();
        if (path.endsWith(INVERTED_SUFFIX)) {
            event.getToolTip().add(INVERTED_LAMP_TOOLTIP);
        } else if (path.endsWith(NORMAL_SUFFIX)) {
            event.getToolTip().add(NORMAL_LAMP_TOOLTIP);
        }
    }
}
