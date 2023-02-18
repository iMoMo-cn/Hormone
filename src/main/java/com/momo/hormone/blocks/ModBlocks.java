package com.momo.hormone.blocks;

import com.momo.hormone.blocks.blockBush.BlockCrop;
import com.momo.hormone.blocks.blockBush.BlockPlant;
import com.momo.hormone.init.ModCreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
	public static final List<Block> BLOCKS = new ArrayList<Block>();

	public static final Block WILD_WHEAT = new BlockPlant("wild_wheat", Material.GRASS);
	public static final Block WILD_CARROT = new BlockPlant("wild_carrot", Material.GRASS);
	public static final Block WILD_POTATO = new BlockPlant("wild_potato", Material.GRASS);
	public static final Block WILD_BEET = new BlockPlant("wild_beet", Material.GRASS);

	public static final Block MUSHROOM_RED = new BlockCrop("mushroom_red");
	public static final Block MUSHROOM_BROWN = new BlockCrop("mushroom_brown");


	public static final Block APPLE_BASKET = new BlockBase("apple_basket", Material.WOOD).setHardness(0.5F);
	public static final Block POTATO_BASKET = new BlockBase("potato_basket", Material.WOOD).setHardness(0.5F);
	public static final Block CARROT_BASKET = new BlockBase("carrot_basket", Material.WOOD).setHardness(0.5F);
	public static final Block BEETROOT_BASKET = new BlockBase("beetroot_basket", Material.WOOD).setHardness(0.5F);

}
