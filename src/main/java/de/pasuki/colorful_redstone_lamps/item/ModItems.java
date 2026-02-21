package de.pasuki.colorful_redstone_lamps.item;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ColorfulRedstoneLamps.MOD_ID);

    public static final Map<DyeColor, Supplier<Item>> LAMP_ITEMS = new EnumMap<>(DyeColor.class);
    public static final Map<DyeColor, Supplier<Item>> INVERTED_LAMP_ITEMS = new EnumMap<>(DyeColor.class);

    static {
        for (DyeColor color : DyeColor.values()) {
            String normalName = color.getName() + "_redstone_lamp";
            LAMP_ITEMS.put(color, ITEMS.register(normalName, () ->
                    new BlockItem(ModBlocks.LAMPS.get(color).get(), new Item.Properties())));

            String invertedName = color.getName() + "_redstone_lamp_inverted";
            INVERTED_LAMP_ITEMS.put(color, ITEMS.register(invertedName, () ->
                    new BlockItem(ModBlocks.INVERTED_LAMPS.get(color).get(), new Item.Properties())));
        }
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
