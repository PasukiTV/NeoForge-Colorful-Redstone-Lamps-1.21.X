package de.pasuki.colorful_redstone_lamps.data;

import java.util.EnumMap;
import java.util.Map;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModEnglishLangProvider extends LanguageProvider {
    private static final Map<DyeColor, String> EN = new EnumMap(DyeColor.class);

    public ModEnglishLangProvider(PackOutput output) {
        super(output, "colorful_redstone_lamps", "en_us");
    }

    protected void addTranslations() {
        this.add("itemGroup.colorful_redstone_lamps", "Colorful Redstone Lamps");
        this.add("tooltip.colorful_redstone_lamps.lamp.normal", "Turns on with a redstone signal.");
        this.add("tooltip.colorful_redstone_lamps.lamp.inverted", "Turns off with a redstone signal.");

        for(DyeColor c : DyeColor.values()) {
            String color = (String)EN.get(c);
            if (color != null) {
                String keyNormal = "block.colorful_redstone_lamps." + c.getName() + "_redstone_lamp";
                this.add(keyNormal, color + " Redstone Lamp");
                String keyInv = "block.colorful_redstone_lamps." + c.getName() + "_redstone_lamp_inverted";
                this.add(keyInv, "Inverted " + color + " Redstone Lamp");
            }
        }

        for(DyeColor c : DyeColor.values()) {
            String color = (String)EN.get(c);
            if (color != null) {
                String keyNormal = "item.colorful_redstone_lamps." + c.getName() + "_redstone_lamp";
                this.add(keyNormal, color + " Redstone Lamp");
                String keyInv = "item.colorful_redstone_lamps." + c.getName() + "_redstone_lamp_inverted";
                this.add(keyInv, "Inverted " + color + " Redstone Lamp");
            }
        }

    }

    static {
        EN.put(DyeColor.WHITE, "White");
        EN.put(DyeColor.LIGHT_GRAY, "Light Gray");
        EN.put(DyeColor.GRAY, "Gray");
        EN.put(DyeColor.BLACK, "Black");
        EN.put(DyeColor.BROWN, "Brown");
        EN.put(DyeColor.RED, "Red");
        EN.put(DyeColor.ORANGE, "Orange");
        EN.put(DyeColor.YELLOW, "Yellow");
        EN.put(DyeColor.LIME, "Lime");
        EN.put(DyeColor.GREEN, "Green");
        EN.put(DyeColor.CYAN, "Cyan");
        EN.put(DyeColor.LIGHT_BLUE, "Light Blue");
        EN.put(DyeColor.BLUE, "Blue");
        EN.put(DyeColor.PURPLE, "Purple");
        EN.put(DyeColor.MAGENTA, "Magenta");
        EN.put(DyeColor.PINK, "Pink");
    }
}
