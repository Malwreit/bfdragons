package com.malwreit.bfdragons.block.custom;

import com.malwreit.bfdragons.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

public class OnionCropBlock extends CropBlock {

    public static final int MAX_AGE = 6; // Maximum age of the crop
    public static final IntProperty AGE = IntProperty.of("age",0,6);


    public OnionCropBlock(Settings settings) {
        super(settings);
    }


    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.ONION_SEEDS;
    }

    @Override
    protected IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
