package com.momo.hormone.blocks.blockBush;

import com.momo.hormone.blocks.ModBlocks;
import com.momo.hormone.util.IHasModel;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockMushroomCrop extends BlockCrops implements IHasModel {
    public static final PropertyInteger CROPS_AGE = PropertyInteger.create("age", 0, 3);
    private static final AxisAlignedBB[] CROPS_AABB = new AxisAlignedBB[]
            {
                    new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D),
                    new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D),
                    new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D),
                    new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D)
            };

    public BlockMushroomCrop(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);

        this.setDefaultState(this.blockState.getBaseState().withProperty(CROPS_AGE, 0));

        ModBlocks.BLOCKS.add(this);
    }

    @Override
    public void registerModels() {
    }

    protected PropertyInteger getAgeProperty()
    {
        return CROPS_AGE;
    }

    public int getMaxAge()
    {
        return 3;
    }

    protected Item getSeed()
    {
        if(this == ModBlocks.MUSHROOM_RED) return Item.getItemFromBlock(Blocks.RED_MUSHROOM);
        else if(this == ModBlocks.MUSHROOM_BROWN) return Item.getItemFromBlock(Blocks.BROWN_MUSHROOM);
        else return null;
    }

    protected Item getCrop()
    {
        if(this == ModBlocks.MUSHROOM_RED) return Item.getItemFromBlock(Blocks.RED_MUSHROOM);
        else if(this == ModBlocks.MUSHROOM_BROWN) return Item.getItemFromBlock(Blocks.BROWN_MUSHROOM);
        else return null;
    }

    @Deprecated // Forge: Use more sensitive version below: getPickBlock
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        if(this == ModBlocks.MUSHROOM_RED) return new ItemStack(Item.getItemFromBlock(Blocks.RED_MUSHROOM), 1);
        else if(this == ModBlocks.MUSHROOM_BROWN) return new ItemStack(Item.getItemFromBlock(Blocks.BROWN_MUSHROOM), 1);
        else return null;
    }

    @Override
    public net.minecraftforge.common.EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        return net.minecraftforge.common.EnumPlantType.Crop;
    }

    protected int getBonemealAgeIncrease(World worldIn)
    {
        return super.getBonemealAgeIncrease(worldIn) / 3;
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] { CROPS_AGE });
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return CROPS_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
    }

}
