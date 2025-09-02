package de.pasuki.colorful_redstone_lamps.item;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLampsClient;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ColorfulRedstoneLamps.MOD_ID);

    //public static final DeferredItem<Item> WHITE_DYE_DUST = ITEMS.register("white_dye_dust",
    //        () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
