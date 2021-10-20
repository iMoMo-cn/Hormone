package com.momo.hormone.item;

import com.momo.hormone.init.ModCreativeTab;
import com.momo.hormone.item.food.ItemFoodBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();

	public static final Item PASTE_WHEAT = new ItemBase("paste_wheat").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item PASTE_SEEDS = new ItemBase("paste_seeds").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item PASTE_CARROT = new ItemBase("paste_carrot").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item PASTE_BONE = new ItemBase("paste_bone").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item PASTE_FISH = new ItemBase("paste_fish").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item PASTE_ROTTEN = new ItemBase("paste_rotten").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_EMPTY = new ItemBase("hormone_empty").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_BONEMEAL = new ItemBase("hormone_bonemeal").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_WHEAT = new ItemBase("hormone_wheat").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_SEEDS = new ItemBase("hormone_seeds").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_CARROT = new ItemBase("hormone_carrot").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_BONE = new ItemBase("hormone_bone").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_FISH = new ItemBase("hormone_fish").setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item HORMONE_ROTTEN = new ItemBase("hormone_rotten").setCreativeTab(ModCreativeTab.HORMONE);

	public static final Item BISCUIT_WHEAT = new ItemFoodBase("biscuit_wheat",3, 2.0f,false).setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item BISCUIT_SEEDS = new ItemFoodBase("biscuit_seeds",2,1.0f,false).setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item BISCUIT_CARROT = new ItemFoodBase("biscuit_carrot",3,2.0f,false).setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item BISCUIT_BONE = new ItemFoodBase("biscuit_bone",3,2.0f,false).setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item BISCUIT_FISH = new ItemFoodBase("biscuit_fish",4,3.0f,false).setCreativeTab(ModCreativeTab.HORMONE);
	public static final Item BISCUIT_ROTTEN = new ItemFoodBase("biscuit_rotten",3,0.5f,false).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 20*20, 0), 0.5F).setCreativeTab(ModCreativeTab.HORMONE);


	/*
	WOOD(0, 59, 2.0F, 0.0F, 15),
    STONE(1, 131, 4.0F, 1.0F, 5),
    IRON(2, 250, 6.0F, 2.0F, 14),
    DIAMOND(3, 1561, 8.0F, 3.0F, 10),
    GOLD(0, 32, 12.0F, 0.0F, 22);

    harvestLevel, maxUses, efficiency, damage, enchantability
	*/

	//Tool Material
//	public static final Item BLOOD_IRON_INGOT = new ItemBase("blood_iron_ingot");
//
//    public static final Item.ToolMaterial TOOL_MATERIAL_BLOOD =
//			EnumHelper.addToolMaterial("material_blood", 3, 512, 3.0F, 4F, 20).setRepairItem(new ItemStack( ModItems.BLOOD_IRON_INGOT));
//
//	public static final ItemKinshipSword KINSHIP_SWORD = new ItemKinshipSword("kinship_sword", TOOL_MATERIAL_BLOOD);

	//Armor
//    LEATHER("leather", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F),
//    CHAIN("chainmail", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F),
//    IRON("iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F),
//    GOLD("gold", 7, new int[]{1, 3, 5, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F),
//    DIAMOND("diamond", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
	//Note that if you want to set a mod thing as repair material, define them before the material, otherwise it will be empty.

//    public static final ItemArmor.ArmorMaterial moroonArmorMaterial = EnumHelper.addArmorMaterial(
//            "idlframewok:armor_moroon", "idlframewok:armor_moroon", 80, new int[] {3, 6, 8, 3}, 2, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2)
//            .setRepairItem(new ItemStack(Items.QUARTZ));
//

//	Food
//	static PotionEffect eff = new PotionEffect(MobEffects.LEVITATION, TICK_PER_SECOND * 60, 0);
//	public static final ItemFoodBase FIGHT_BREAD = (ItemFoodBase) new ItemFoodBase("war_bread", 10, 10, false).
//			setPotionEffect(eff, 1.0f).
//			setAlwaysEdible();
//    public static final ItemFoodBase MEMORY_BREAD = new ItemFoodBase("memory_bread", 3, 0.6f, false).SetXP(10);
//




	//Armor
//	public static final ItemHelmSniper helmetSniper = (ItemHelmSniper) new ItemHelmSniper("helmet_sniper", moroonArmorMaterialSniper, 1, EntityEquipmentSlot.HEAD);
//
//	public static final ItemArmorBase[] MOR_GENERAL_ARMOR =
//			{        new ItemArmorBase("mor_armor_1", moroonArmorMaterial, 1, EntityEquipmentSlot.HEAD)
//					,new ItemArmorBase("mor_armor_2", moroonArmorMaterial, 1, EntityEquipmentSlot.CHEST)
//					,new ItemArmorBase("mor_armor_3", moroonArmorMaterial, 1, EntityEquipmentSlot.LEGS)
//					,new ItemArmorBase("mor_armor_4", moroonArmorMaterial, 1, EntityEquipmentSlot.FEET)
//			};

	//public static final ItemSkillDecodeItem skillDecodeItem = (ItemSkillDecodeItem) new ItemSkillDecodeItem("skill_decode_item").setRarity(EnumRarity.RARE);

	//Package Example
//	public static final ItemPackage RANDOM_SKILL = (ItemPackage) new ItemPackage("random_skill", new Item[]{
//			Items.BLAZE_ROD, Items.PAPER
//	}).setMaxStackSize(1);
}
