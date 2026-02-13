package de.pasuki.colorful_redstone_lamps.data;

import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (DyeColor c : DyeColor.values()) {
            String base = c.getName() + "_redstone_lamp";

            // Normal lamp items use the *_off block model in inventory.
            if (ModBlocks.LAMPS.containsKey(c)) {
                withExistingParent(base, modLoc("block/" + base + "_off"));
            }

            // Inverted lamp items use the *_on block model in inventory.
            if (ModBlocks.INVERTED_LAMPS.containsKey(c)) {
                withExistingParent(base + "_inverted", modLoc("block/" + base + "_on"));
            }
        }
    }

}
