package de.pasuki.colorful_redstone_lamps.item;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(ColorfulRedstoneLamps.MOD_ID);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
