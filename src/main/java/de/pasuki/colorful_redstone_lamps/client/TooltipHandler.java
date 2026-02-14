package de.pasuki.colorful_redstone_lamps.client;

import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.registries.DeferredBlock;

public class TooltipHandler {
    private TooltipHandler() {
    }

    public static void onTooltip(ItemTooltipEvent e) {
        ItemStack stack = e.getItemStack();
        if (stack.isEmpty()) {
            return;
        }

        Item item = stack.getItem();
        if (isLampItem(item, false)) {
            e.getToolTip().add(Component.translatable("tooltip.colorful_redstone_lamps.lamp.normal").withStyle(ChatFormatting.GRAY));
        } else if (isLampItem(item, true)) {
            e.getToolTip().add(Component.translatable("tooltip.colorful_redstone_lamps.lamp.inverted").withStyle(ChatFormatting.GRAY));
        }
    }

    private static boolean isLampItem(Item item, boolean inverted) {
        for (DeferredBlock<Block> deferredBlock : (inverted ? ModBlocks.INVERTED_LAMPS : ModBlocks.LAMPS).values()) {
            if (deferredBlock.get().asItem() == item) {
                return true;
            }
        }
        return false;
    }
}
