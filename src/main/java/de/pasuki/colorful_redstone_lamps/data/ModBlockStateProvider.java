package de.pasuki.colorful_redstone_lamps.data;

import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, String modId, ExistingFileHelper exFileHelper) {
        super(output, modId, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (DyeColor c : DyeColor.values()) {
            String base = c.getName() + "_redstone_lamp";

            // Texture layout used by this mod.
            String texOn  = "block/" + base + "_on"; // existing
            String texOff = "block/" + base;         // existing (without _off suffix)

            // Generate model files named *_on/*_off and map them to the textures above.
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

}
