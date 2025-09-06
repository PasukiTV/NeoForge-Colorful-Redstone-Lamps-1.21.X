package de.pasuki.colorful_redstone_lamps.data;

import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, String modId, ExistingFileHelper exFileHelper) {
        super(output, modId, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (DyeColor c : DyeColor.values()) {
            String base = c.getName() + "_redstone_lamp";

            // deine vorhandenen Texturen:
            String texOn  = "block/" + base + "_on"; // vorhanden
            String texOff = "block/" + base;         // vorhanden (ohne _off)

            // Modelle erzeugen, benannt mit _on/_off, aber verknüpft mit deinen Texturen
            var onModel  = models().cubeAll(base + "_on",  modLoc(texOn));
            var offModel = models().cubeAll(base + "_off", modLoc(texOff));

            var normal = ModBlocks.LAMPS.get(c).get();
            getVariantBuilder(normal).forAllStates(s ->
                    ConfiguredModel.builder()
                            .modelFile(s.getValue(BlockStateProperties.LIT) ? onModel : offModel)
                            .build()
            );

            var inverted = ModBlocks.INVERTED_LAMPS.get(c).get();
            getVariantBuilder(inverted).forAllStates(s ->
                    ConfiguredModel.builder()
                            .modelFile(s.getValue(BlockStateProperties.LIT) ? onModel : offModel)
                            .build()
            );
        }
    }


    // -------- helpers --------
    private static Block safeGet(Object maybeSupplier) {
        try {
            if (maybeSupplier instanceof java.util.function.Supplier<?> sup) {
                Object v = sup.get();
                return (v instanceof Block b) ? b : null;
            }
        } catch (Throwable ignored) {}
        return null;
    }

    // Hinweis: modLoc(String) kommt aus BlockStateProvider – NICHT löschen/überschreiben!
    // protected ResourceLocation modLoc(String path);
}
