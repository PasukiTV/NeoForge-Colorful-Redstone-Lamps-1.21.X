package de.pasuki.colorful_redstone_lamps.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class InvertedRedstoneLampBlock extends RedstoneLampBlock {
    public InvertedRedstoneLampBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        boolean hasSignal = context.getLevel().hasNeighborSignal(context.getClickedPos());
        return this.defaultBlockState().setValue(LIT, !hasSignal);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (!level.isClientSide) {
            updateLitState(state, level, pos);
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        updateLitState(state, level, pos);
    }

    private void updateLitState(BlockState state, Level level, BlockPos pos) {
        boolean hasSignal = level.hasNeighborSignal(pos);
        boolean shouldBeLit = !hasSignal;

        if (state.getValue(LIT) != shouldBeLit) {
            level.setBlock(pos, state.setValue(LIT, shouldBeLit), 2);
        }
    }
}
