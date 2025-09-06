package de.pasuki.colorful_redstone_lamps.data;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.EnumMap;
import java.util.Map;

public class ModEnglishLangProvider extends LanguageProvider {

    private static final Map<DyeColor, String> EN = new EnumMap<>(DyeColor.class);
    static {
        EN.put(DyeColor.WHITE,      "White");
        EN.put(DyeColor.LIGHT_GRAY, "Light Gray");
        EN.put(DyeColor.GRAY,       "Gray");
        EN.put(DyeColor.BLACK,      "Black");
        EN.put(DyeColor.BROWN,      "Brown");
        EN.put(DyeColor.RED,        "Red");
        EN.put(DyeColor.ORANGE,     "Orange");
        EN.put(DyeColor.YELLOW,     "Yellow");
        EN.put(DyeColor.LIME,       "Lime");
        EN.put(DyeColor.GREEN,      "Green");
        EN.put(DyeColor.CYAN,       "Cyan");
        EN.put(DyeColor.LIGHT_BLUE, "Light Blue");
        EN.put(DyeColor.BLUE,       "Blue");
        EN.put(DyeColor.PURPLE,     "Purple");
        EN.put(DyeColor.MAGENTA,    "Magenta");
        EN.put(DyeColor.PINK,       "Pink");
    }

    public ModEnglishLangProvider(PackOutput output) {
        super(output, ColorfulRedstoneLamps.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // Creative tab
        add("itemGroup.colorful_redstone_lamps", "Colorful Redstone Lamps");
        add("tooltip.colorful_redstone_lamps.lamp.normal",   "Turns on with a redstone signal.");
        add("tooltip.colorful_redstone_lamps.lamp.inverted", "Turns off with a redstone signal.");

        // Blocks
        for (DyeColor c : DyeColor.values()) {
            String color = EN.get(c);
            if (color == null) continue;

            // normal
            String keyNormal = "block." + ColorfulRedstoneLamps.MOD_ID + "." + c.getName() + "_redstone_lamp";
            add(keyNormal, color + " Redstone Lamp");

            // inverted
            String keyInv = "block." + ColorfulRedstoneLamps.MOD_ID + "." + c.getName() + "_redstone_lamp_inverted";
            add(keyInv, "Inverted " + color + " Redstone Lamp");

        }

        // Items
        for (DyeColor c : DyeColor.values()) {
            String color = EN.get(c);
            if (color == null) continue;

            // normal
            String keyNormal = "item." + ColorfulRedstoneLamps.MOD_ID + "." + c.getName() + "_redstone_lamp";
            add(keyNormal, color + " Redstone Lamp");

            // inverted
            String keyInv = "item." + ColorfulRedstoneLamps.MOD_ID + "." + c.getName() + "_redstone_lamp_inverted";
            add(keyInv, "Inverted " + color + " Redstone Lamp");

        }
    }
}
