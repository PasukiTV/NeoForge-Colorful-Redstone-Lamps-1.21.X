package de.pasuki.colorful_redstone_lamps.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class InvertedRedstoneLampBlock extends RedstoneLampBlock {
    public static final BooleanProperty LIT = RedstoneLampBlock.LIT;

    public InvertedRedstoneLampBlock(Properties props) {
        super(props);
        // Default state is lit: inverted lamps are on without redstone power.
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, true));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        boolean hasSignal = ctx.getLevel().hasNeighborSignal(ctx.getClickedPos());
        // Inverted behavior: powered -> off, unpowered -> on.
        return this.defaultBlockState().setValue(LIT, !hasSignal);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos,
                                net.minecraft.world.level.block.Block block, BlockPos fromPos, boolean isMoving) {
        if (level.isClientSide) return;

        boolean hasSignal = level.hasNeighborSignal(pos);
        boolean lit = state.getValue(LIT);

        boolean targetLit = !hasSignal;
        if (lit != targetLit) {
            level.setBlock(pos, state.setValue(LIT, targetLit), 2);
        }
    }
}
