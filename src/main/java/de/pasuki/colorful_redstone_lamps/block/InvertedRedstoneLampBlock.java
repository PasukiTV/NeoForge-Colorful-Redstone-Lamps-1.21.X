package de.pasuki.colorful_redstone_lamps.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;                 // <— wichtig (für Direction.Orientation)
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.redstone.Orientation;
import org.jetbrains.annotations.Nullable;

public class InvertedRedstoneLampBlock extends Block {

    public InvertedRedstoneLampBlock(BlockBehaviour.Properties props) {
        super(props);
        // invertierte Lampe ist standardmäßig an
        this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.LIT, Boolean.TRUE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.LIT);
    }

    // 1.21.2 – EXAKTE Signatur (beachte Direction.Orientation!)
    @Override
    protected void neighborChanged(BlockState state,
                                   Level level,
                                   BlockPos pos,
                                   Block neighborBlock,
                                   @Nullable Orientation orientation,
                                   boolean isMoving) {
        if (level.isClientSide) return;

        boolean lit       = state.getValue(BlockStateProperties.LIT);
        boolean hasSignal = level.hasNeighborSignal(pos); // Orientierung wird hier nicht benötigt

        // Invertierte Logik: Lampe soll AN sein, wenn KEIN Signal anliegt.
        // D.h. wenn (lit == hasSignal) stimmt etwas nicht und wir reagieren.
        if (lit == hasSignal) {
            if (lit) {
                // War an, bekommt jetzt Signal -> wie Vanilla zeitverzögert ausschalten
                level.scheduleTick(pos, this, 4);
            } else {
                // War aus, Signal ist weg -> sofort einschalten
                level.setBlock(pos, state.setValue(BlockStateProperties.LIT, Boolean.TRUE), Block.UPDATE_CLIENTS);
            }
        }
    }

    // Wird von neighborChanged (oben) genutzt, um verzögert auszuschalten – wie bei der Vanilla-Lampe,
    // aber invertiert.
    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        // Ausschalten nur, wenn sie an ist UND ein Signal anliegt (invertiert)
        if (state.getValue(BlockStateProperties.LIT) && level.hasNeighborSignal(pos)) {
            level.setBlock(pos, state.setValue(BlockStateProperties.LIT, Boolean.FALSE), Block.UPDATE_CLIENTS);
        }
    }
}
