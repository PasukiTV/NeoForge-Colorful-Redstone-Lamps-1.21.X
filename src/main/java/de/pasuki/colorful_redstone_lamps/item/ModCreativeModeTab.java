package de.pasuki.colorful_redstone_lamps.item;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ColorfulRedstoneLamps.MOD_ID);

    public static final Supplier<CreativeModeTab> COLORFUL_REDSTONE_LAMPS = CREATE_MODE_TAB.register("colorful_redstone_lamps_tab",
    ()-> CreativeModeTab.builder()
            .icon(()-> new ItemStack(ModBlocks.WHITE_REDSTONE_LAMP.get()))
            .title(Component.translatable("creativetab.colorful_redstone_lamps"))
            .displayItems((itemDisplayParameters, output) ->{
                output.accept(ModBlocks.WHITE_REDSTONE_LAMP);
                output.accept(ModBlocks.LIGHT_GRAY_REDSTONE_LAMP);
                output.accept(ModBlocks.GRAY_REDSTONE_LAMP);
                output.accept(ModBlocks.BLACK_REDSTONE_LAMP);
                output.accept(ModBlocks.BROWN_REDSTONE_LAMP);
                output.accept(ModBlocks.RED_REDSTONE_LAMP);
                output.accept(ModBlocks.ORANGE_REDSTONE_LAMP);
                output.accept(ModBlocks.YELLOW_REDSTONE_LAMP);
                output.accept(ModBlocks.LIME_REDSTONE_LAMP);
                output.accept(ModBlocks.GREEN_REDSTONE_LAMP);
                output.accept(ModBlocks.CYAN_REDSTONE_LAMP);
                output.accept(ModBlocks.LIGHT_BLUE_REDSTONE_LAMP);
                output.accept(ModBlocks.BLUE_REDSTONE_LAMP);
                output.accept(ModBlocks.PURPLE_REDSTONE_LAMP);
                output.accept(ModBlocks.MAGENTA_REDSTONE_LAMP);
                output.accept(ModBlocks.PINK_REDSTONE_LAMP);
            })
            .build());


    public static void register(IEventBus eventBus){
        CREATE_MODE_TAB.register(eventBus);
    }
}
