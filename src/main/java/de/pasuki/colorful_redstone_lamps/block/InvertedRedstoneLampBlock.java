package de.pasuki.colorful_redstone_lamps.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.redstone.Orientation;
import org.jetbrains.annotations.Nullable;

public class InvertedRedstoneLampBlock extends Block {
    public InvertedRedstoneLampBlock(BlockBehaviour.Properties props) {
        super(props);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(BlockStateProperties.LIT, Boolean.TRUE));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{BlockStateProperties.LIT});
    }

    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, @Nullable Orientation orientation, boolean isMoving) {
        if (!level.isClientSide) {
            boolean lit = (Boolean)state.getValue(BlockStateProperties.LIT);
            boolean hasSignal = level.hasNeighborSignal(pos);
            if (lit == hasSignal) {
                if (lit) {
                    level.scheduleTick(pos, this, 4);
                } else {
                    level.setBlock(pos, (BlockState)state.setValue(BlockStateProperties.LIT, Boolean.TRUE), 2);
                }
            }

        }
    }

    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if ((Boolean)state.getValue(BlockStateProperties.LIT) && level.hasNeighborSignal(pos)) {
            level.setBlock(pos, (BlockState)state.setValue(BlockStateProperties.LIT, Boolean.FALSE), 2);
        }

    }
}
