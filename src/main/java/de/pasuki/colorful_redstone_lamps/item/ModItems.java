package de.pasuki.colorful_redstone_lamps.item;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems("colorful_redstone_lamps");

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
