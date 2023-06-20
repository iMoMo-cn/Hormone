package com.momo.hormone.blocks.blockBush;

import com.momo.hormone.blocks.ModBlocks;
import com.momo.hormone.util.IHasModel;
import net.minecraft.block.BlockCarrot;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;

public class BlockGoldCarrot extends BlockCarrot implements IHasModel
{
    public BlockGoldCarrot()
    {
        setUnlocalizedName("gold_carrot");
        setRegistryName("gold_carrot");

        ModBlocks.BLOCKS.add(this);
    }

    @Override
    public void registerModels() {

    }

    @Override
    public net.minecraftforge.common.EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        return net.minecraftforge.common.EnumPlantType.Crop;
    }

    protected Item getSeed()
    {
        return Items.GOLDEN_CARROT;
    }

    protected Item getCrop()
    {
        return Items.GOLDEN_CARROT;
    }
}
