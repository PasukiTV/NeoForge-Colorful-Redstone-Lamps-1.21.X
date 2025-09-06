package de.pasuki.colorful_redstone_lamps.data;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.EnumMap;
import java.util.Map;

public class ModGermanLangProvider extends LanguageProvider {

    // Adjektive stimmen mit Vanilla-Deutsch überein (Lampe = feminin → -e)
    private static final Map<DyeColor, String> DE = new EnumMap<>(DyeColor.class);
    static {
        DE.put(DyeColor.WHITE,      "Weiße");
        DE.put(DyeColor.LIGHT_GRAY, "Hellgraue");
        DE.put(DyeColor.GRAY,       "Graue");
        DE.put(DyeColor.BLACK,      "Schwarze");
        DE.put(DyeColor.BROWN,      "Braune");
        DE.put(DyeColor.RED,        "Rote");
        DE.put(DyeColor.ORANGE,     "Orangefarbene");
        DE.put(DyeColor.YELLOW,     "Gelbe");
        DE.put(DyeColor.LIME,       "Hellgrüne");
        DE.put(DyeColor.GREEN,      "Grüne");
        DE.put(DyeColor.CYAN,       "Türkise");
        DE.put(DyeColor.LIGHT_BLUE, "Hellblaue");
        DE.put(DyeColor.BLUE,       "Blaue");
        DE.put(DyeColor.PURPLE,     "Violette");
        DE.put(DyeColor.MAGENTA,    "Magenta");   // wie Vanilla: z. B. „Magenta Keramik“
        DE.put(DyeColor.PINK,       "Rosa");      // wie Vanilla: z. B. „Rosa Keramik“
    }

    public ModGermanLangProvider(PackOutput output) {
        super(output, ColorfulRedstoneLamps.MOD_ID, "de_de");
    }

    @Override
    protected void addTranslations() {
        // Creative tab
        add("itemGroup.colorful_redstone_lamps", "Bunte Redstone-Lampen");
        add("tooltip.colorful_redstone_lamps.lamp.normal",   "Schaltet sich bei Redstone-Signal ein.");
        add("tooltip.colorful_redstone_lamps.lamp.inverted", "Schaltet sich bei Redstone-Signal aus.");

        // Blocks
        for (DyeColor c : DyeColor.values()) {
            String adj = DE.get(c);
            if (adj == null) continue;

            // normal
            String keyNormal = "block." + ColorfulRedstoneLamps.MOD_ID + "." + c.getName() + "_redstone_lamp";
            add(keyNormal, adj + " Redstone-Lampe");

            // inverted (Adjektiv bleibt vorne)
            String keyInv = "block." + ColorfulRedstoneLamps.MOD_ID + "." + c.getName() + "_redstone_lamp_inverted";
            add(keyInv, adj + " invertierte Redstone-Lampe");
        }

        // Items
        for (DyeColor c : DyeColor.values()) {
            String adj = DE.get(c);
            if (adj == null) continue;

            // normal
            String keyNormal = "item." + ColorfulRedstoneLamps.MOD_ID + "." + c.getName() + "_redstone_lamp";
            add(keyNormal, adj + " Redstone-Lampe");

            // inverted (Adjektiv bleibt vorne)
            String keyInv = "item." + ColorfulRedstoneLamps.MOD_ID + "." + c.getName() + "_redstone_lamp_inverted";
            add(keyInv, adj + " invertierte Redstone-Lampe");
        }
    }
}
