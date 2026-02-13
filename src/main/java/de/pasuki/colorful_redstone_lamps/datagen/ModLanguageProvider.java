package de.pasuki.colorful_redstone_lamps.datagen;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output, String locale) {
        super(output, ColorfulRedstoneLamps.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add("creativetab.colorful_redstone_lamps", "Colorful Redstone Lamps");

        add(ModBlocks.WHITE_REDSTONE_LAMP.get(), "White Redstone Lamp");
        add(ModBlocks.LIGHT_GRAY_REDSTONE_LAMP.get(), "Light Gray Redstone Lamp");
        add(ModBlocks.GRAY_REDSTONE_LAMP.get(), "Gray Redstone Lamp");
        add(ModBlocks.BLACK_REDSTONE_LAMP.get(), "Black Redstone Lamp");
        add(ModBlocks.BROWN_REDSTONE_LAMP.get(), "Brown Redstone Lamp");
        add(ModBlocks.RED_REDSTONE_LAMP.get(), "Red Redstone Lamp");
        add(ModBlocks.ORANGE_REDSTONE_LAMP.get(), "Orange Redstone Lamp");
        add(ModBlocks.YELLOW_REDSTONE_LAMP.get(), "Yellow Redstone Lamp");
        add(ModBlocks.LIME_REDSTONE_LAMP.get(), "Lime Redstone Lamp");
        add(ModBlocks.GREEN_REDSTONE_LAMP.get(), "Green Redstone Lamp");
        add(ModBlocks.CYAN_REDSTONE_LAMP.get(), "Cyan Redstone Lamp");
        add(ModBlocks.LIGHT_BLUE_REDSTONE_LAMP.get(), "Light Blue Redstone Lamp");
        add(ModBlocks.BLUE_REDSTONE_LAMP.get(), "Blue Redstone Lamp");
        add(ModBlocks.PURPLE_REDSTONE_LAMP.get(), "Purple Redstone Lamp");
        add(ModBlocks.MAGENTA_REDSTONE_LAMP.get(), "Magenta Redstone Lamp");
        add(ModBlocks.PINK_REDSTONE_LAMP.get(), "Pink Redstone Lamp");

        add(ModBlocks.WHITE_INVERTED_REDSTONE_LAMP.get(), "Inverted White Redstone Lamp");
        add(ModBlocks.LIGHT_GRAY_INVERTED_REDSTONE_LAMP.get(), "Inverted Light Gray Redstone Lamp");
        add(ModBlocks.GRAY_INVERTED_REDSTONE_LAMP.get(), "Inverted Gray Redstone Lamp");
        add(ModBlocks.BLACK_INVERTED_REDSTONE_LAMP.get(), "Inverted Black Redstone Lamp");
        add(ModBlocks.BROWN_INVERTED_REDSTONE_LAMP.get(), "Inverted Brown Redstone Lamp");
        add(ModBlocks.RED_INVERTED_REDSTONE_LAMP.get(), "Inverted Red Redstone Lamp");
        add(ModBlocks.ORANGE_INVERTED_REDSTONE_LAMP.get(), "Inverted Orange Redstone Lamp");
        add(ModBlocks.YELLOW_INVERTED_REDSTONE_LAMP.get(), "Inverted Yellow Redstone Lamp");
        add(ModBlocks.LIME_INVERTED_REDSTONE_LAMP.get(), "Inverted Lime Redstone Lamp");
        add(ModBlocks.GREEN_INVERTED_REDSTONE_LAMP.get(), "Inverted Green Redstone Lamp");
        add(ModBlocks.CYAN_INVERTED_REDSTONE_LAMP.get(), "Inverted Cyan Redstone Lamp");
        add(ModBlocks.LIGHT_BLUE_INVERTED_REDSTONE_LAMP.get(), "Inverted Light Blue Redstone Lamp");
        add(ModBlocks.BLUE_INVERTED_REDSTONE_LAMP.get(), "Inverted Blue Redstone Lamp");
        add(ModBlocks.PURPLE_INVERTED_REDSTONE_LAMP.get(), "Inverted Purple Redstone Lamp");
        add(ModBlocks.MAGENTA_INVERTED_REDSTONE_LAMP.get(), "Inverted Magenta Redstone Lamp");
        add(ModBlocks.PINK_INVERTED_REDSTONE_LAMP.get(), "Inverted Pink Redstone Lamp");
    }
}
