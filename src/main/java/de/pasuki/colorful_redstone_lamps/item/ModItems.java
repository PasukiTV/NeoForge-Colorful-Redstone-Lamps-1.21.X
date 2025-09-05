package de.pasuki.colorful_redstone_lamps.item;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLampsClient;
import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ColorfulRedstoneLamps.MOD_ID);

    //public static final DeferredItem<Item> WHITE_DYE_DUST = ITEMS.register("white_dye_dust",
    //        () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

    public static final Map<DyeColor, Supplier<Item>> INVERTED_LAMP_ITEMS = new EnumMap<>(DyeColor.class);

    static {
        for (DyeColor color : DyeColor.values()) {
            String name = color.getName() + "_lamp_inverted";
            INVERTED_LAMP_ITEMS.put(color, ITEMS.register(name, () ->
                    new BlockItem(ModBlocks.INVERTED_LAMPS.get(color).get(), new Item.Properties())));
        }
    }

}
