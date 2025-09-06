package de.pasuki.colorful_redstone_lamps.item;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ColorfulRedstoneLamps.MOD_ID);

    public static final Supplier<CreativeModeTab> MAIN = TABS.register("colorful_redstone_lamps",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.colorful_redstone_lamps"))
                    .icon(() -> new ItemStack(ModBlocks.LAMPS.get(DyeColor.RED).get()))
                    .displayItems((params, output) -> {
                        // zuerst normale Lampen
                        for (DyeColor color : DyeColor.values()) {
                            var sup = ModBlocks.LAMPS.get(color);
                            if (sup != null) output.accept(sup.get());
                        }
                        // dann invertierte
                        for (DyeColor color : DyeColor.values()) {
                            var sup = ModBlocks.INVERTED_LAMPS.get(color);
                            if (sup != null) output.accept(sup.get());
                        }
                    })
                    .build());

    // <— diese Methode fehlt oft, wird aber in deiner Hauptklasse aufgerufen
    public static void register(IEventBus modEventBus) {
        TABS.register(modEventBus);
    }
}
