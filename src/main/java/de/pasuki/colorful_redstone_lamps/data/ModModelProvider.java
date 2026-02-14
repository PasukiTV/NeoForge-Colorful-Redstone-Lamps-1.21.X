//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package de.pasuki.colorful_redstone_lamps.data;

import de.pasuki.colorful_redstone_lamps.block.ModBlocks;
import de.pasuki.colorful_redstone_lamps.item.ModItems;
import java.util.stream.Stream;
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
import net.neoforged.neoforge.registries.DeferredBlock;

public final class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, "colorful_redstone_lamps");
    }

    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        for(DyeColor c : DyeColor.values()) {
            Block normal = (Block)((DeferredBlock)ModBlocks.LAMPS.get(c)).get();
            Block inverted = (Block)((DeferredBlock)ModBlocks.INVERTED_LAMPS.get(c)).get();
            String base = c.getName() + "_redstone_lamp";
            ResourceLocation TEX_OFF = modLoc("block/" + base);
            ResourceLocation TEX_ON = modLoc("block/" + base + "_on");
            ResourceLocation normalOff = TexturedModel.CUBE.create(normal, blockModels.modelOutput);
            ResourceLocation normalOn = blockModels.createSuffixedVariant(normal, "_on", ModelTemplates.CUBE_ALL, (b) -> TextureMapping.cube(TEX_ON));
            blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(normal).with(BlockModelGenerators.createBooleanModelDispatch(BlockStateProperties.LIT, BlockModelGenerators.plainVariant(normalOn), BlockModelGenerators.plainVariant(normalOff))));
            ResourceLocation invOff = blockModels.createSuffixedVariant(inverted, "_off", ModelTemplates.CUBE_ALL, (b) -> TextureMapping.cube(TEX_OFF));
            ResourceLocation invOn = blockModels.createSuffixedVariant(inverted, "_on", ModelTemplates.CUBE_ALL, (b) -> TextureMapping.cube(TEX_ON));
            blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(inverted).with(BlockModelGenerators.createBooleanModelDispatch(BlockStateProperties.LIT, BlockModelGenerators.plainVariant(invOn), BlockModelGenerators.plainVariant(invOff))));
            itemModels.itemModelOutput.register(inverted.asItem(), new ClientItem(ItemModelUtils.plainModel(invOn), new ClientItem.Properties(false, false)));
        }

    }

    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream();
    }

    protected Stream<? extends Holder<Item>> getKnownItems() {
        return ModItems.ITEMS.getEntries().stream();
    }

    private static ResourceLocation modLoc(String path) {
        return ResourceLocation.fromNamespaceAndPath("colorful_redstone_lamps", path);
    }
}
