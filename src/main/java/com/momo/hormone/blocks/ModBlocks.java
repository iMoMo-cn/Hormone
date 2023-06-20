package com.momo.hormone.blocks;

import com.momo.hormone.blocks.blockBasic.BlockBase;
import com.momo.hormone.blocks.blockBush.BlockGoldCarrot;
import com.momo.hormone.blocks.blockBush.BlockMushroomCrop;
import com.momo.hormone.blocks.blockBush.BlockWildPlant;
import com.momo.hormone.init.ModCreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
	public static final List<Block> BLOCKS = new ArrayList<Block>();

	public static final Block WILD_WHEAT = new BlockWildPlant("wild_wheat", Material.PLANTS);
	public static final Block WILD_CARROT = new BlockWildPlant("wild_carrot", Material.PLANTS);
	public static final Block WILD_POTATO = new BlockWildPlant("wild_potato", Material.PLANTS);
	public static final Block WILD_BEET = new BlockWildPlant("wild_beet", Material.PLANTS);

	public static final Block GOLED_CARROT = new BlockGoldCarrot();

	public static final Block MUSHROOM_RED = new BlockMushroomCrop("mushroom_red");
	public static final Block MUSHROOM_BROWN = new BlockMushroomCrop("mushroom_brown");

	public static final Block APPLE_BASKET = new BlockBase("apple_basket", Material.WOOD).setHardness(0.5F).setCreativeTab(ModCreativeTab.FARMING);
	public static final Block POTATO_BASKET = new BlockBase("potato_basket", Material.WOOD).setHardness(0.5F).setCreativeTab(ModCreativeTab.FARMING);
	public static final Block CARROT_BASKET = new BlockBase("carrot_basket", Material.WOOD).setHardness(0.5F).setCreativeTab(ModCreativeTab.FARMING);
	public static final Block BEETROOT_BASKET = new BlockBase("beetroot_basket", Material.WOOD).setHardness(0.5F).setCreativeTab(ModCreativeTab.FARMING);
}
