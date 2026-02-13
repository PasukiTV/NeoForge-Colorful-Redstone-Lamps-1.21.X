package de.pasuki.colorful_redstone_lamps.item;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Supplier;

public final class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ColorfulRedstoneLamps.MOD_ID);

    public static final Supplier<CreativeModeTab> COLORFUL_REDSTONE_LAMPS =
            CREATIVE_MODE_TABS.register("colorful_redstone_lamps_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.WHITE_REDSTONE_LAMP.get()))
                    .title(Component.translatable("creativetab.colorful_redstone_lamps"))
                    .displayItems((itemDisplayParameters, output) -> {
                        // Keep order stable so players can quickly find colors they expect.
                        for (DeferredBlock<?> block : DISPLAY_ORDER) {
                            output.accept(block);
                        }
                    })
                    .build());

    private static final List<DeferredBlock<?>> DISPLAY_ORDER = List.of(
            ModBlocks.WHITE_REDSTONE_LAMP,
            ModBlocks.LIGHT_GRAY_REDSTONE_LAMP,
            ModBlocks.GRAY_REDSTONE_LAMP,
            ModBlocks.BLACK_REDSTONE_LAMP,
            ModBlocks.BROWN_REDSTONE_LAMP,
            ModBlocks.RED_REDSTONE_LAMP,
            ModBlocks.ORANGE_REDSTONE_LAMP,
            ModBlocks.YELLOW_REDSTONE_LAMP,
            ModBlocks.LIME_REDSTONE_LAMP,
            ModBlocks.GREEN_REDSTONE_LAMP,
            ModBlocks.CYAN_REDSTONE_LAMP,
            ModBlocks.LIGHT_BLUE_REDSTONE_LAMP,
            ModBlocks.BLUE_REDSTONE_LAMP,
            ModBlocks.PURPLE_REDSTONE_LAMP,
            ModBlocks.MAGENTA_REDSTONE_LAMP,
            ModBlocks.PINK_REDSTONE_LAMP,
            ModBlocks.WHITE_INVERTED_REDSTONE_LAMP,
            ModBlocks.LIGHT_GRAY_INVERTED_REDSTONE_LAMP,
            ModBlocks.GRAY_INVERTED_REDSTONE_LAMP,
            ModBlocks.BLACK_INVERTED_REDSTONE_LAMP,
            ModBlocks.BROWN_INVERTED_REDSTONE_LAMP,
            ModBlocks.RED_INVERTED_REDSTONE_LAMP,
            ModBlocks.ORANGE_INVERTED_REDSTONE_LAMP,
            ModBlocks.YELLOW_INVERTED_REDSTONE_LAMP,
            ModBlocks.LIME_INVERTED_REDSTONE_LAMP,
            ModBlocks.GREEN_INVERTED_REDSTONE_LAMP,
            ModBlocks.CYAN_INVERTED_REDSTONE_LAMP,
            ModBlocks.LIGHT_BLUE_INVERTED_REDSTONE_LAMP,
            ModBlocks.BLUE_INVERTED_REDSTONE_LAMP,
            ModBlocks.PURPLE_INVERTED_REDSTONE_LAMP,
            ModBlocks.MAGENTA_INVERTED_REDSTONE_LAMP,
            ModBlocks.PINK_INVERTED_REDSTONE_LAMP
    );

    private ModCreativeModeTab() {
    }

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
