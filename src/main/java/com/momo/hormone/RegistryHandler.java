package com.momo.hormone;

import com.momo.hormone.enchantments.ModEnchantmentInit;
import com.momo.hormone.entity.creatures.ModEntityInit;
import com.momo.hormone.entity.creatures.villager.ModVillagers;
import com.momo.hormone.entity.creatures.villager.VillagerMerchants;
import com.momo.hormone.entity.renders.RenderHandler;
import com.momo.hormone.blocks.ModBlocks;
import com.momo.hormone.init.ModBiomeInit;
import com.momo.hormone.init.ModDimensionInit;
import com.momo.hormone.item.ModItems;

import com.momo.hormone.potion.effect.ModPotions;
import com.momo.hormone.potion.item.ModPotionTypes;
import com.momo.hormone.util.IHasModel;
import com.momo.hormone.util.sound.ModSoundHandler;
import com.momo.hormone.worldgen.ModWorldGenOld;
import com.momo.hormone.worldgen.WildPlantGen;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class RegistryHandler {
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
	}

	@SubscribeEvent
	public static void onEnchantmentRegister(RegistryEvent.Register<Enchantment> event)
	{
		ModEnchantmentInit.BeforeRegister();
		event.getRegistry().registerAll(ModEnchantmentInit.ENCHANTMENT_LIST.toArray(new Enchantment[0]));
	}

	@SubscribeEvent
	public static void onPotionRegistry(RegistryEvent.Register<Potion> event)
	{
		event.getRegistry().registerAll(ModPotions.POTIONS.toArray(new Potion[0]));
	}

	@SubscribeEvent
	public static void onPotionTypeRegistry(RegistryEvent.Register<PotionType> event)
	{
		event.getRegistry().registerAll(ModPotionTypes.POTION_TYPES.toArray(new PotionType[0]));
	}

	@SubscribeEvent
	public static void onRegistry(RegistryEvent.Register<VillagerRegistry.VillagerProfession>event)
	{
		VillagerMerchants.addMerchants();
		event.getRegistry().registerAll(ModVillagers.VILLAGERS.toArray(new VillagerRegistry.VillagerProfession[0]));
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Item item : ModItems.ITEMS)
		{
			if (item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
		
		for(Block block : ModBlocks.BLOCKS)
		{
			if (block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}

		RenderHandler.registerEntityRenders();
	}

	public static void preInitRegistries(FMLPreInitializationEvent event)
	{
		//GameRegistry.registerWorldGenerator(new ModWorldGenOld(), 0);
		//GameRegistry.registerWorldGenerator(new ModWorldGenNew(), 0);
		GameRegistry.registerWorldGenerator(new WildPlantGen(), 0);

		ModBiomeInit.registerBiomes();
		ModDimensionInit.registerDimensions();
		ModPotionTypes.registerPotionType();
		ModEntityInit.registerEntities();
	}

	public static void postInitReg()
	{
		//WorldType TYPE_ONE = new WorldTypeOne();
	}

	public static void initRegistries(FMLInitializationEvent event)
	{
		ModSoundHandler.soundRegister();
	}

	public static void serverRegistries(FMLServerStartingEvent event)
    {
        //event.registerServerCommand(new CommandDimTeleport());
    }
}
