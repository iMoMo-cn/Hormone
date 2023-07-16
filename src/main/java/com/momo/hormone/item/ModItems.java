package com.momo.hormone.item;

import com.momo.hormone.init.ModCreativeTab;
import com.momo.hormone.item.food.ItemBowlFood;
import com.momo.hormone.item.food.ItemDrink;
import com.momo.hormone.item.food.ItemFoodBase;
import com.momo.hormone.item.misc.ItemFibre;
import com.momo.hormone.item.misc.ItemGlassCup;
import com.momo.hormone.item.tools.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.*;
import net.minecraft.potion.PotionEffect;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();

	//public static final Item ITEM_NAME = new ItemBase("item_name").setCreativeTab(ModCreativeTab.CREATIVE_TAB);
	public static final Item PASTE_FLOWER = new ItemBase("paste_flower").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item PASTE_WHEAT = new ItemBase("paste_wheat").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item PASTE_SEEDS = new ItemBase("paste_seeds").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item PASTE_CARROT = new ItemBase("paste_carrot").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item PASTE_BONE = new ItemBase("paste_bone").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item PASTE_FISH = new ItemBase("paste_fish").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item PASTE_ROTTEN = new ItemBase("paste_rotten").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item PASTE_HOLY = new ItemBase("paste_holy").setCreativeTab(ModCreativeTab.HORMONE);

	public static final Item BISCUIT_FLOWER = new ItemFoodBase("biscuit_flower",2, 1.0F,false).setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item BISCUIT_WHEAT = new ItemFoodBase("biscuit_wheat",3, 2.0F,false).setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item BISCUIT_SEEDS = new ItemFoodBase("biscuit_seeds",2,1.0F,false).setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item BISCUIT_CARROT = new ItemFoodBase("biscuit_carrot",3,2.0F,false).setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item BISCUIT_BONE = new ItemFoodBase("biscuit_bone",3,2.0F,false).setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item BISCUIT_FISH = new ItemFoodBase("biscuit_fish",4,3.0F,false).setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item BISCUIT_ROTTEN = new ItemFoodBase("biscuit_rotten",3,0.5F,false).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 20*20, 0), 0.5F).setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item BISCUIT_HOLY = new ItemFoodBase("biscuit_holy",3,1.0F,false).setPotionEffect(new PotionEffect(MobEffects.REGENERATION, 20*20, 0), 1.0F).setCreativeTab(ModCreativeTab.HORMONE);

	public static final Item HORMONE_EMPTY = new ItemBase("hormone_empty").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_BONEMEAL = new ItemBase("hormone_bonemeal").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_FLOWER = new ItemBase("hormone_flower").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_FLOWER_PRO = new ItemBase("hormone_flower_pro").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_WHEAT = new ItemBase("hormone_wheat").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_SEEDS = new ItemBase("hormone_seeds").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_CARROT = new ItemBase("hormone_carrot").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_BONE = new ItemBase("hormone_bone").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_FISH = new ItemBase("hormone_fish").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_ROTTEN = new ItemBase("hormone_rotten").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_HOLY = new ItemBase("hormone_holy").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_MUSHROOM_BROWN = new ItemBase("hormone_mushroom_brown").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_MUSHROOM_RED = new ItemBase("hormone_mushroom_red").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_GOLD_CARROT = new ItemBase("hormone_gold_carrot").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_MUSHROOM = new ItemBase("hormone_mushroom").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_GRASS = new ItemBase("hormone_grass").setCreativeTab(ModCreativeTab.HORMONE);

	public static final ItemSword KNIFE = new Knife();
	public static final ItemPickaxe HAMMER = new Hammer();
	public static final ItemAxe SAW = new Saw();
	public static final ItemShears SHEARS = new Shears();
	public static final Item BUCKET = new WoodBucket("wood_bucket", Blocks.AIR).setMaxStackSize(16);
	public static final Item WATER_BUCKET = new WoodBucket("wood_bucket_water", Blocks.FLOWING_WATER).setContainerItem(BUCKET);

	public static final Item PUMPKIN_SLICE = new ItemFoodBase("pumpkin_slice", 2, 1.2F, false).setCreativeTab(ModCreativeTab.EXTRA_FOOD);

	public static final Item BAKED_APPLE = new ItemFoodBase("baked_apple", 6, 2.0F, false).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item BAKED_CARROT = new ItemFoodBase("baked_carrot", 5, 1.5F, false).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item BAKED_BEETROOT = new ItemFoodBase("baked_beetroot", 5, 1.0F, false).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item COOKED_EGG = new ItemFoodBase("cooked_egg", 3, 1.0F, false).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item SCRAPED_FLESH = new ItemFoodBase("scraped_flesh", 3, 0.8F, true).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item COOKED_FLESH = new ItemFoodBase("cooked_flesh", 5, 1.5F, true).setCreativeTab(ModCreativeTab.EXTRA_FOOD);

	public static final Item DICED_VEGETABLE = new ItemFoodBase("diced_vegetable", 1, 0.3F, false).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item COOKED_DICED_VEGETABLE = new ItemFoodBase("cooked_diced_vegetable", 1, 0.8F, false).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item DICED_MEAT = new ItemFoodBase("diced_meat", 2, 0.6F, true).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item COOKED_DICED_MEAT = new ItemFoodBase("cooked_diced_meat", 2, 1.6F, true).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item MUSHROOM_SKEWERS = new ItemFoodBase("mushroom_skewers", 3, 0.5F, false).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item MUSHROOM_BARBECUE = new ItemFoodBase("mushroom_barbecue", 6, 4.8F, false).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item VEGETABLE_SKEWERS = new ItemFoodBase("vegetable_skewers", 3, 0.9F, false).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item VEGETABLE_BARBECUE = new ItemFoodBase("vegetable_barbecue", 4, 3.2F, false).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item MEAT_SKEWERS = new ItemFoodBase("meat_skewers", 6, 1.8F, true).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item MEAT_BARBECUE = new ItemFoodBase("meat_barbecue", 8, 6.4F, true).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item CLASSICAL_SKEWERS = new ItemFoodBase("classical_skewers", 9, 2.7F, true).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item CLASSICAL_BARBECUE = new ItemFoodBase("classical_barbecue", 12, 9.6F, true).setCreativeTab(ModCreativeTab.EXTRA_FOOD);

	public static final Item SALAD = new ItemFoodBase("salad", 2, 1.0F, false).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item VEGETABLE_SALAD = new ItemFoodBase("vegetable_salad", 3, 2.0F, false).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item MEAT_SALAD = new ItemFoodBase("meat_salad", 4, 3.0F, false).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item HEARTY_SALAD = new ItemFoodBase("hearty_salad", 5, 4.0F, false).setCreativeTab(ModCreativeTab.EXTRA_FOOD);

	public static final Item CARAMEL = new ItemFoodBase("caramel", 1, 0.5F, false).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
    public static final Item HONEY_BEEF = new ItemFoodBase("honey_beef", 9, 3.0F, false).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
    public static final Item HONEY_PORKCHOP = new ItemFoodBase("honey_porkchop", 9, 3.0F, false).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
    public static final Item HONEY_MUTTON = new ItemFoodBase("honey_mutton", 7, 2.5F, false).setCreativeTab(ModCreativeTab.EXTRA_FOOD);

    public static final Item PUMPKIN_STEW = new ItemBowlFood("pumpkin_stew", 6, 7.2F).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item MUSHROOM_STEW = new ItemBowlFood("mushroom_stew", 6, 7.2F).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item CHICKEN_MUSHROOM = new ItemBowlFood("chicken_mushroom", 9, 11F).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item MUTTON_CARROT = new ItemBowlFood("mutton_carrot", 9, 11F).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item BEEF_POTATO = new ItemBowlFood("beef_potato", 11, 13F).setCreativeTab(ModCreativeTab.EXTRA_FOOD);

	public static final Item TOFFEE = new ItemFoodBase("toffee", 1, 0.2F, false).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
    public static final Item CHOCOLATE = new ItemFoodBase("chocolate", 2, 1.0F, false).setCreativeTab(ModCreativeTab.EXTRA_FOOD);

	public static final Item GLASS_CUP = new ItemGlassCup().setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item WATER_CUP = new ItemDrink("water_cup", 0, 0.0F).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item APPLE_JUICE = new ItemDrink("apple_juice", 4, 2.0F).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item CARROT_JUICE = new ItemDrink("carrot_juice", 3, 1.5F).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item MELON_JUICE = new ItemDrink("melon_juice", 2, 1.0F).setCreativeTab(ModCreativeTab.EXTRA_FOOD);
	public static final Item BEER = new ItemDrink("beer", 2, 2.0F).setPotionEffect(new PotionEffect(MobEffects.STRENGTH, 20*120, 0), 1.0F).setCreativeTab(ModCreativeTab.EXTRA_FOOD).setMaxStackSize(16);
	public static final Item COFFEE = new ItemDrink("coffee", 2, 2.0F).setPotionEffect(new PotionEffect(MobEffects.HASTE, 20*120, 0), 1.0F).setCreativeTab(ModCreativeTab.EXTRA_FOOD).setMaxStackSize(16);
	public static final Item SUGAR_WATER = new ItemDrink("sugar_water", 2, 2.0F).setPotionEffect(new PotionEffect(MobEffects.SPEED, 20*120, 0), 1.0F).setCreativeTab(ModCreativeTab.EXTRA_FOOD).setMaxStackSize(16);
	public static final Item SCENTED_TEA = new ItemDrink("scented_tea", 2, 2.0F).setPotionEffect(new PotionEffect(MobEffects.REGENERATION, 20*120, 0), 1.0F).setCreativeTab(ModCreativeTab.EXTRA_FOOD).setMaxStackSize(16);
	public static final Item LAVA_CUP = new ItemDrink("lava_cup", 0, 0.0F).setPotionEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE, 20, 1), 1.0F).setCreativeTab(ModCreativeTab.EXTRA_FOOD);

	public static final Item FIBRE = new ItemFibre("fibre").setCreativeTab(ModCreativeTab.FARMING);
	public static final Item PIG_EYE = new ItemFoodBase("pig_eye", 2, 3.2F, false).setCreativeTab(ModCreativeTab.FARMING);
	public static final Item PASTEBALL = new ItemBase("pasteball").setCreativeTab(ModCreativeTab.FARMING);
	public static final Item BLACK_POWDER = new ItemBase("black_powder").setCreativeTab(ModCreativeTab.FARMING);
	public static final Item PEARL = new ItemBase("pearl").setCreativeTab(ModCreativeTab.FARMING);

	public static final Item COAL_APPLE = new ItemBurnable("coal_apple", 1600).setCreativeTab(ModCreativeTab.FARMING);
	public static final Item COAL_CARROT = new ItemBurnable("coal_carrot", 1600).setCreativeTab(ModCreativeTab.FARMING);
	public static final Item COAL_POTATO = new ItemBurnable("coal_potato", 1600).setCreativeTab(ModCreativeTab.FARMING);
	public static final Item COAL_BEETROOT = new ItemBurnable("coal_beetroot", 1600).setCreativeTab(ModCreativeTab.FARMING);
	public static final Item COAL_PUMPKIN = new ItemBurnable("coal_pumpkin", 1200).setCreativeTab(ModCreativeTab.FARMING);
	public static final Item COAL_MELON = new ItemBurnable("coal_melon", 1200).setCreativeTab(ModCreativeTab.FARMING);
	public static final Item COAL_WHEAT = new ItemBurnable("coal_wheat", 1200).setCreativeTab(ModCreativeTab.FARMING);
}
