package de.pasuki.colorful_redstone_lamps.data;

import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import de.pasuki.colorful_redstone_lamps.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.renderer.item.ClientItem;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.stream.Stream;

public class ModModelProvider extends ModelProvider {

    public ModModelProvider(PackOutput output) {
        super(output, ColorfulRedstoneLamps.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        for (DyeColor c : DyeColor.values()) {
            final Block normal   = ModBlocks.LAMPS.get(c).get();
            final Block inverted = ModBlocks.INVERTED_LAMPS.get(c).get();

            final String base = c.getName() + "_redstone_lamp"; // ohne "_inverted"
            final ResourceLocation TEX_OFF = modLoc("block/" + base);
            final ResourceLocation TEX_ON  = modLoc("block/" + base + "_on");

            /* ===== NORMAL (Block) ===== */
            var normalOffModel = TexturedModel.CUBE.create(normal, blockModels.modelOutput); // block/<base>.png
            var normalOnModel  = ModelTemplates.CUBE_ALL.create(
                    ModelLocationUtils.getModelLocation(normal).withSuffix("_on"),
                    TextureMapping.cube(TEX_ON),
                    blockModels.modelOutput
            );

            blockModels.blockStateOutput.accept(
                    MultiVariantGenerator.multiVariant(normal)
                            .with(BlockModelGenerators.createBooleanModelDispatch(
                                    BlockStateProperties.LIT, normalOnModel, normalOffModel))
            );
            // KEIN explizites Item für normale Lampe -> Fallback (OFF) ist ok.


            /* ===== INVERTED (Block + Item) ===== */
            // Blockmodelle benutzen BEWUSST die normalen Texturen (kein "_inverted" in Pfaden!)
            var invertedOffModel = ModelTemplates.CUBE_ALL.create(
                    ModelLocationUtils.getModelLocation(inverted).withSuffix("_off"),
                    TextureMapping.cube(TEX_OFF),
                    blockModels.modelOutput
            );
            var invertedOnModel = ModelTemplates.CUBE_ALL.create(
                    ModelLocationUtils.getModelLocation(inverted).withSuffix("_on"),
                    TextureMapping.cube(TEX_ON),
                    blockModels.modelOutput
            );

            blockModels.blockStateOutput.accept(
                    MultiVariantGenerator.multiVariant(inverted)
                            .with(BlockModelGenerators.createBooleanModelDispatch(
                                    BlockStateProperties.LIT, invertedOnModel, invertedOffModel))
            );

            // WICHTIG (1.21.4): Client-Item registrieren, das auf das _ON-Blockmodell zeigt (WÜRFEL, kein flaches Icon).
            // -> Damit ignoriert Minecraft NICHT unser Item und zeigt im Inventar den Würfel mit ON-Textur.
            ResourceLocation onBlockModel = modLoc("block/" + base + "_on"); // normales Blockmodell _on
            ItemModel.Unbaked unbaked = ItemModelUtils.plainModel(onBlockModel);
            itemModels.itemModelOutput.register(inverted.asItem(), new ClientItem(unbaked, new ClientItem.Properties(false)));
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
