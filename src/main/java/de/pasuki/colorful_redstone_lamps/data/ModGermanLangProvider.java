package de.pasuki.colorful_redstone_lamps.data;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.EnumMap;
import java.util.Map;

public class ModGermanLangProvider extends LanguageProvider {

    // Adjectives match vanilla German naming ("Lampe" is feminine).
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
        DE.put(DyeColor.MAGENTA,    "Magenta");   // Matches vanilla phrasing, e.g. "Magenta Keramik"
        DE.put(DyeColor.PINK,       "Rosa");      // Matches vanilla phrasing, e.g. "Rosa Keramik"
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
        add("colorful_redstone_lamps.welcome.title", "Colorful Redstone Lamps!");
        add("colorful_redstone_lamps.welcome.body1", "Hast du Ideen zur Verbesserung?");
        add("colorful_redstone_lamps.welcome.body2", "Ich freue mich über dein Feedback!");
        add("colorful_redstone_lamps.welcome.body3", "Feedback auf CurseForge");

        // Blocks
        for (DyeColor c : DyeColor.values()) {
            String adj = DE.get(c);
            if (adj == null) continue;

            // Normal
            String keyNormal = "block." + ColorfulRedstoneLamps.MOD_ID + "." + c.getName() + "_redstone_lamp";
            add(keyNormal, adj + " Redstone-Lampe");

            // Inverted (adjective remains before the noun in German).
            String keyInv = "block." + ColorfulRedstoneLamps.MOD_ID + "." + c.getName() + "_redstone_lamp_inverted";
            add(keyInv, adj + " invertierte Redstone-Lampe");
        }
    }
}
