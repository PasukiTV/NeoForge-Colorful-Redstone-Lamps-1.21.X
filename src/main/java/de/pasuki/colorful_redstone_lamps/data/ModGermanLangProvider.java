package de.pasuki.colorful_redstone_lamps.data;

import java.util.EnumMap;
import java.util.Map;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModGermanLangProvider extends LanguageProvider {
    private static final Map<DyeColor, String> DE = new EnumMap(DyeColor.class);

    public ModGermanLangProvider(PackOutput output) {
        super(output, "colorful_redstone_lamps", "de_de");
    }

    protected void addTranslations() {
        this.add("itemGroup.colorful_redstone_lamps", "Bunte Redstone-Lampen");
        this.add("tooltip.colorful_redstone_lamps.lamp.normal", "Schaltet sich bei Redstone-Signal ein.");
        this.add("tooltip.colorful_redstone_lamps.lamp.inverted", "Schaltet sich bei Redstone-Signal aus.");

        for(DyeColor c : DyeColor.values()) {
            String adj = (String)DE.get(c);
            if (adj != null) {
                String keyNormal = "block.colorful_redstone_lamps." + c.getName() + "_redstone_lamp";
                this.add(keyNormal, adj + " Redstone-Lampe");
                String keyInv = "block.colorful_redstone_lamps." + c.getName() + "_redstone_lamp_inverted";
                this.add(keyInv, adj + " invertierte Redstone-Lampe");
            }
        }

        for(DyeColor c : DyeColor.values()) {
            String adj = (String)DE.get(c);
            if (adj != null) {
                String keyNormal = "item.colorful_redstone_lamps." + c.getName() + "_redstone_lamp";
                this.add(keyNormal, adj + " Redstone-Lampe");
                String keyInv = "item.colorful_redstone_lamps." + c.getName() + "_redstone_lamp_inverted";
                this.add(keyInv, adj + " invertierte Redstone-Lampe");
            }
        }

    }

    static {
        DE.put(DyeColor.WHITE, "Weiße");
        DE.put(DyeColor.LIGHT_GRAY, "Hellgraue");
        DE.put(DyeColor.GRAY, "Graue");
        DE.put(DyeColor.BLACK, "Schwarze");
        DE.put(DyeColor.BROWN, "Braune");
        DE.put(DyeColor.RED, "Rote");
        DE.put(DyeColor.ORANGE, "Orangefarbene");
        DE.put(DyeColor.YELLOW, "Gelbe");
        DE.put(DyeColor.LIME, "Hellgrüne");
        DE.put(DyeColor.GREEN, "Grüne");
        DE.put(DyeColor.CYAN, "Türkise");
        DE.put(DyeColor.LIGHT_BLUE, "Hellblaue");
        DE.put(DyeColor.BLUE, "Blaue");
        DE.put(DyeColor.PURPLE, "Violette");
        DE.put(DyeColor.MAGENTA, "Magenta");
        DE.put(DyeColor.PINK, "Rosa");
    }
}
