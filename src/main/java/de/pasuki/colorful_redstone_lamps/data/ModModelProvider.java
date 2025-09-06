package de.pasuki.colorful_redstone_lamps.data;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import de.pasuki.colorful_redstone_lamps.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.client.renderer.item.ClientItem;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.stream.Stream;

public final class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, ColorfulRedstoneLamps.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        for (DyeColor c : DyeColor.values()) {
            final Block normal   = ModBlocks.LAMPS.get(c).get();
            final Block inverted = ModBlocks.INVERTED_LAMPS.get(c).get();

            final String base = c.getName() + "_redstone_lamp";
            final ResourceLocation TEX_OFF = modLoc("block/" + base);       // …/block/<color>_redstone_lamp.png
            final ResourceLocation TEX_ON  = modLoc("block/" + base + "_on");// …/block/<color>_redstone_lamp_on.png

            /* ---------------- NORMAL ---------------- */

            // OFF: vanilla mapping (nimmt block/<id>.png) – bei dir = <base>.png
            var normalOff = TexturedModel.CUBE.create(normal, blockModels.modelOutput);

            // ON: eigenes Modell mit _on-Suffix und deiner _on-Textur
            var normalOn = blockModels.createSuffixedVariant(
                    normal, "_on", ModelTemplates.CUBE_ALL, b -> TextureMapping.cube(TEX_ON));

            blockModels.blockStateOutput.accept(
                    MultiVariantGenerator.dispatch(normal)
                            .with(BlockModelGenerators.createBooleanModelDispatch(
                                    BlockStateProperties.LIT,
                                    BlockModelGenerators.plainVariant(normalOn),
                                    BlockModelGenerators.plainVariant(normalOff)))
            );
            // Item der normalen Lampe: Vanilla-Fallback (OFF) reicht.


            /* ---------------- INVERTED ---------------- */

            // Inverted nutzt BEWUSST die gleichen Texturpfade (kein “…_inverted” in den Pfaden!)
            var invOff = blockModels.createSuffixedVariant(
                    inverted, "_off", ModelTemplates.CUBE_ALL, b -> TextureMapping.cube(TEX_OFF));
            var invOn = blockModels.createSuffixedVariant(
                    inverted, "_on", ModelTemplates.CUBE_ALL, b -> TextureMapping.cube(TEX_ON));

            blockModels.blockStateOutput.accept(
                    MultiVariantGenerator.dispatch(inverted)
                            .with(BlockModelGenerators.createBooleanModelDispatch(
                                    BlockStateProperties.LIT,
                                    BlockModelGenerators.plainVariant(invOn),
                                    BlockModelGenerators.plainVariant(invOff)))
            );

            // Item der INVERTED: explizit das _on-BLOCKmodell (Würfel!) als ClientItem registrieren
            itemModels.itemModelOutput.register(
                    inverted.asItem(),
                    new ClientItem(ItemModelUtils.plainModel(invOn), new ClientItem.Properties(false,false))
            );
        }
    }

    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream();
    }

    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        return ModItems.ITEMS.getEntries().stream();
    }

    private static ResourceLocation modLoc(String path) {
        return ResourceLocation.fromNamespaceAndPath(ColorfulRedstoneLamps.MOD_ID, path);
    }
}
