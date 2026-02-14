package de.pasuki.colorful_redstone_lamps.item;

import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import java.util.function.Supplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> TABS;
    public static final Supplier<CreativeModeTab> MAIN;

    public static void register(IEventBus modEventBus) {
        TABS.register(modEventBus);
    }

    static {
        TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "colorful_redstone_lamps");
        MAIN = TABS.register("colorful_redstone_lamps", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.colorful_redstone_lamps")).icon(() -> new ItemStack((ItemLike)((DeferredBlock)ModBlocks.LAMPS.get(DyeColor.RED)).get())).displayItems((params, output) -> {
            for(DyeColor color : DyeColor.values()) {
                DeferredBlock<Block> sup = (DeferredBlock)ModBlocks.LAMPS.get(color);
                if (sup != null) {
                    output.accept((ItemLike)sup.get());
                }
            }

            for(DyeColor color : DyeColor.values()) {
                DeferredBlock<Block> sup = (DeferredBlock)ModBlocks.INVERTED_LAMPS.get(color);
                if (sup != null) {
                    output.accept((ItemLike)sup.get());
                }
            }

        }).build());
    }
}
