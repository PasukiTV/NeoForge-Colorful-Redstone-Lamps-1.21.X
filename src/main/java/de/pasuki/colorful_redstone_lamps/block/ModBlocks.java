package de.pasuki.colorful_redstone_lamps.block;

import de.pasuki.colorful_redstone_lamps.item.ModItems;
import java.util.EnumMap;
import java.util.Map;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks("colorful_redstone_lamps");
    public static final Map<DyeColor, DeferredBlock<Block>> LAMPS = new EnumMap(DyeColor.class);
    public static final Map<DyeColor, DeferredBlock<Block>> INVERTED_LAMPS = new EnumMap(DyeColor.class);

    private static ResourceKey<Block> key(String name) {
        return ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("colorful_redstone_lamps", name));
    }

    private static void registerBlockItem(String name, DeferredBlock<Block> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem((Block)block.get(), (new Item.Properties()).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("colorful_redstone_lamps", name)))));
    }

    private static boolean always(BlockState s, BlockGetter g, BlockPos p, EntityType<?> t) {
        return true;
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }

    static {
        for(DyeColor color : DyeColor.values()) {
            String name = color.getName() + "_redstone_lamp";
            DeferredBlock<Block> lamp = BLOCKS.register(name, () -> new RedstoneLampBlock(Properties.of().setId(key(name)).mapColor(color.getMapColor()).strength(0.3F).sound(SoundType.GLASS).lightLevel((s) -> (Boolean)s.getValue(RedstoneLampBlock.LIT) ? 15 : 0)));
            LAMPS.put(color, lamp);
            registerBlockItem(name, lamp);
            String invName = color.getName() + "_redstone_lamp_inverted";
            DeferredBlock<Block> invLamp = BLOCKS.register(invName, () -> new InvertedRedstoneLampBlock(Properties.of().setId(key(invName)).mapColor(color.getMapColor()).strength(0.3F).sound(SoundType.GLASS).lightLevel((s) -> (Boolean)s.getValue(BlockStateProperties.LIT) ? 15 : 0)));
            INVERTED_LAMPS.put(color, invLamp);
            registerBlockItem(invName, invLamp);
        }

    }
}
