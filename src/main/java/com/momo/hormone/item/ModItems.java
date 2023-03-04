package com.momo.hormone.item;

import com.momo.hormone.init.ModCreativeTab;
import com.momo.hormone.item.food.ItemFoodBase;
import com.momo.hormone.item.misc.ItemFibre;
import net.minecraft.init.MobEffects;
import net.minecraft.item.*;
import net.minecraft.potion.PotionEffect;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();

	//public static final Item ITEM_NAME = new ItemBase("item_name").setCreativeTab(ModCreativeTab.CREATIVE_TAB);
	public static final Item PASTE_WHEAT = new ItemBase("paste_wheat").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item PASTE_SEEDS = new ItemBase("paste_seeds").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item PASTE_CARROT = new ItemBase("paste_carrot").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item PASTE_BONE = new ItemBase("paste_bone").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item PASTE_FISH = new ItemBase("paste_fish").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item PASTE_ROTTEN = new ItemBase("paste_rotten").setCreativeTab(ModCreativeTab.HORMONE);

	public static final Item BISCUIT_WHEAT = new ItemFoodBase("biscuit_wheat",3, 2.0F,false).setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item BISCUIT_SEEDS = new ItemFoodBase("biscuit_seeds",2,1.0F,false).setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item BISCUIT_CARROT = new ItemFoodBase("biscuit_carrot",3,2.0F,false).setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item BISCUIT_BONE = new ItemFoodBase("biscuit_bone",3,2.0F,false).setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item BISCUIT_FISH = new ItemFoodBase("biscuit_fish",4,3.0F,false).setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item BISCUIT_ROTTEN = new ItemFoodBase("biscuit_rotten",3,0.5F,false).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 20*20, 0), 0.5F).setCreativeTab(ModCreativeTab.HORMONE);

	public static final Item HORMONE_EMPTY = new ItemBase("hormone_empty").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_BONEMEAL = new ItemBase("hormone_bonemeal").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_WHEAT = new ItemBase("hormone_wheat").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_SEEDS = new ItemBase("hormone_seeds").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_CARROT = new ItemBase("hormone_carrot").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_BONE = new ItemBase("hormone_bone").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_FISH = new ItemBase("hormone_fish").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_ROTTEN = new ItemBase("hormone_rotten").setCreativeTab(ModCreativeTab.HORMONE);

	public static final Item FIBRE = new ItemFibre("fibre").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item PIG_EYE = new ItemFoodBase("pig_eye", 2, 3.2F, false).setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item PASTEBALL = new ItemBase("pasteball").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item BLACK_POWDER = new ItemBase("black_powder").setCreativeTab(ModCreativeTab.HORMONE);

	public static final Item PUMPKIN_SLICE = new ItemFoodBase("pumpkin_slice", 2, 1.2F, false).setCreativeTab(ModCreativeTab.HORMONE);

	public static final Item BAKED_APPLE = new ItemFoodBase("baked_apple", 6, 7.2F, false).setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item BAKED_CARROT = new ItemFoodBase("baked_carrot", 8, 10.0F, false).setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item BAKED_BEETROOT = new ItemFoodBase("baked_beetroot", 5, 8.0F, false).setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item COOKED_EGG = new ItemFoodBase("cooked_egg", 5, 6.4F, false).setCreativeTab(ModCreativeTab.HORMONE);

	public static final Item COAL_APPLE = new ItemBurnable("coal_apple", 1600).setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item COAL_CARROT = new ItemBurnable("coal_carrot", 1600).setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item COAL_POTATO = new ItemBurnable("coal_potato", 1600).setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item COAL_BEETROOT = new ItemBurnable("coal_beetroot", 1600).setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item COAL_PUMPKIN = new ItemBurnable("coal_pumpkin", 1200).setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item COAL_MELON = new ItemBurnable("coal_melon", 1200).setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item COAL_WHEAT = new ItemBurnable("coal_wheat", 1200).setCreativeTab(ModCreativeTab.HORMONE);

}
