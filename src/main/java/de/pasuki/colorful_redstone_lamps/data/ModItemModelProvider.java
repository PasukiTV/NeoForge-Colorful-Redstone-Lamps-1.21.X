package de.pasuki.colorful_redstone_lamps.data;

import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (net.minecraft.world.item.DyeColor c : net.minecraft.world.item.DyeColor.values()) {
            String base = c.getName() + "_redstone_lamp";

            // Normale Items: parent = Blockmodell "_off" (Inventar zeigt AUS)
            if (de.pasuki.colorful_redstone_lamps.block.ModBlocks.LAMPS.containsKey(c)) {
                withExistingParent(base, modLoc("block/" + base + "_off"));
            }

            // Invertierte Items: parent = Blockmodell "_on" (Inventar zeigt AN)
            if (de.pasuki.colorful_redstone_lamps.block.ModBlocks.INVERTED_LAMPS.containsKey(c)) {
                withExistingParent(base + "_inverted", modLoc("block/" + base + "_on"));
            }
        }
    }


}
