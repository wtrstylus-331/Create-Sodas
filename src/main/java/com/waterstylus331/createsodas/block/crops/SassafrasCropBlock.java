package com.waterstylus331.createsodas.block.crops;

import com.waterstylus331.createsodas.item.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class SassafrasCropBlock extends CropBlock {
    public static final int maxAge = 5;
    public static final IntegerProperty age = BlockStateProperties.AGE_5;

    public SassafrasCropBlock(Properties p_52247_) {
        super(p_52247_);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.SASSAFRAS_SEEDS.get();
    }

    @Override
    protected IntegerProperty getAgeProperty() {
        return age;
    }

    @Override
    public int getMaxAge() {
        return maxAge;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(age);
    }
}
