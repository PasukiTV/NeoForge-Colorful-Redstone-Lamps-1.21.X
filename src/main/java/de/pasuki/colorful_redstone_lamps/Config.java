package de.pasuki.colorful_redstone_lamps;

import java.util.List;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec.BooleanValue LOG_DIRT_BLOCK;
    public static final ModConfigSpec.IntValue MAGIC_NUMBER;
    public static final ModConfigSpec.ConfigValue<String> MAGIC_NUMBER_INTRODUCTION;
    public static final ModConfigSpec.ConfigValue<List<? extends String>> ITEM_STRINGS;
    static final ModConfigSpec SPEC;

    private static boolean validateItemName(Object obj) {
        boolean var10000;
        if (obj instanceof String itemName) {
            if (BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(itemName))) {
                var10000 = true;
                return var10000;
            }
        }

        var10000 = false;
        return var10000;
    }

    static {
        LOG_DIRT_BLOCK = BUILDER.comment("Whether to log the dirt block on common setup").define("logDirtBlock", true);
        MAGIC_NUMBER = BUILDER.comment("A magic number").defineInRange("magicNumber", 42, 0, Integer.MAX_VALUE);
        MAGIC_NUMBER_INTRODUCTION = BUILDER.comment("What you want the introduction message to be for the magic number").define("magicNumberIntroduction", "The magic number is... ");
        ITEM_STRINGS = BUILDER.comment("A list of items to log on common setup.").defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), () -> "", Config::validateItemName);
        SPEC = BUILDER.build();
    }
}
