package com.momo.hormone.init;

import com.momo.hormone.item.ModItems;
import com.momo.hormone.util.Reference;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class ModRecipes {
	
	
	public static void Init() {
		//Only smelting recipes
		GameRegistry.addSmelting(ModItems.PASTE_BONE, new ItemStack(ModItems.BISCUIT_BONE), 0.3f);
		GameRegistry.addSmelting(ModItems.PASTE_CARROT, new ItemStack(ModItems.BISCUIT_CARROT), 0.3f);
		GameRegistry.addSmelting(ModItems.PASTE_FISH, new ItemStack(ModItems.BISCUIT_FISH), 0.3f);
		GameRegistry.addSmelting(ModItems.PASTE_SEEDS, new ItemStack(ModItems.BISCUIT_SEEDS), 0.3f);
		GameRegistry.addSmelting(ModItems.PASTE_WHEAT, new ItemStack(ModItems.BISCUIT_WHEAT), 0.3f);
		GameRegistry.addSmelting(ModItems.PASTE_ROTTEN, new ItemStack(ModItems.BISCUIT_ROTTEN), 0.3f);
	}
	
	@SubscribeEvent
	public static void registerRecipes(RegistryEvent.Register<IRecipe> evt) {
		IForgeRegistry<IRecipe> r = evt.getRegistry();
		//Example
		//r.register(new GobletFill().setRegistryName(new ResourceLocation(Reference.MOD_ID, "goblet_fill")));
	}
}
