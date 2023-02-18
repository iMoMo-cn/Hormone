package com.momo.hormone.blocks.blockBush;



import com.momo.hormone.blocks.ModBlocks;
import com.momo.hormone.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;


public class BlockPlant extends BlockBush implements IHasModel {

    public BlockPlant(String name, Material material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);

        setHardness(0.0F);
        setLightOpacity(0);
        this.blockSoundType = SoundType.PLANT;

        ModBlocks.BLOCKS.add(this);
    }

    @Override
    public void registerModels() {
    }

    /**
     * BushBlock
     */
    public static final AxisAlignedBB NULL_AABB = null;

    protected static final AxisAlignedBB CROP_AABB = new AxisAlignedBB(0.1D, 0.0D, 0.1D, 0.9D, 0.8D, 0.9D);
    protected static final AxisAlignedBB CARROT_AABB = new AxisAlignedBB(0.34D, 0.0D, 0.34D, 0.67D, 0.8D, 0.67D);
    protected static final AxisAlignedBB BEET_AABB = new AxisAlignedBB(0.34D, 0.0D, 0.34D, 0.67D, 0.55D, 0.67D);

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        Block block = state.getBlock();
        if(block == ModBlocks.WILD_CARROT) return CARROT_AABB;
        else if(block == ModBlocks.WILD_BEET) return BEET_AABB;
        else return CROP_AABB;
    }

    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }

    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    protected boolean canSustainBush(IBlockState state)
    {
        return state.getBlock() == Blocks.GRASS;
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        Block block = state.getBlock();

        Random r = new Random();
        int num = r.nextInt(2) + 1;
        int num1 = r.nextInt(2)+ 1;

        if(block == ModBlocks.WILD_WHEAT)
        {
            drops.add(new ItemStack(Items.WHEAT, num));
            drops.add(new ItemStack(Items.WHEAT_SEEDS,num1));
        }
        else if(block == ModBlocks.WILD_CARROT)
        {
            drops.add(new ItemStack(Items.CARROT, num));
        }
        else if(block == ModBlocks.WILD_POTATO)
        {
            drops.add(new ItemStack(Items.POTATO, num));
        }
        else if(block == ModBlocks.WILD_BEET)
        {
            drops.add(new ItemStack(Items.BEETROOT, num));
            drops.add(new ItemStack(Items.BEETROOT_SEEDS, num1));
        }
    }
}
