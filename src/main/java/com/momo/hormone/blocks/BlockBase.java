package com.momo.hormone.blocks;

import com.momo.hormone.MoMoFramework;
import com.momo.hormone.init.ModCreativeTab;
import com.momo.hormone.item.ModItems;
import com.momo.hormone.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import java.util.Random;

public class BlockBase extends Block implements IHasModel
{
	public BlockBase(String name, Material material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);

		setSoundType(SoundType.WOOD);
		setCreativeTab(ModCreativeTab.HORMONE);

		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return super.getItemDropped(state, rand, fortune);
	}

	@Override
	public int quantityDropped(Random rand) {
		return super.quantityDropped(rand);
	}
	
	@Override
	public void registerModels() {
		MoMoFramework.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
