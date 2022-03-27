package com.momo.hormone.recipe;

import com.google.common.collect.Sets;
import com.momo.hormone.MoMoFramework;
import com.momo.hormone.item.ModItems;
import com.momo.hormone.util.Reference;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

import java.util.Set;

import static com.momo.hormone.MoMoFramework.LogWarning;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class ModRecipe {

	public static Set<ResourceLocation> recipes = Sets.newHashSet();
	
	public static void Init() {
		//Only smelting recipes
		//GameRegistry.addSmelting(ModItems.XXXX, new ItemStack(ModItems.XXXX), 0.3f);
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
		IForgeRegistryModifiable<IRecipe> registry = (IForgeRegistryModifiable<IRecipe>) r;

		//remove recipe
		removeRecipes(registry);

		//Example
		//r.register(new BasicGua8().setRegistryName(new ResourceLocation(Reference.MOD_ID, "basic_gua8")));

	}
	private static void removeRecipes(IForgeRegistryModifiable<IRecipe> registry){

		//removeRecipe(new ItemStack(Blocks.TRAPDOOR, 2));
		//removeAllRecipe

		recipes.forEach(rl -> {
			if(!rl.getResourceDomain().equals(MoMoFramework.MODID)) {
				LogWarning("Removing: " + rl);
				registry.remove(rl);
			}
		});
	}

	private static void removeRecipe(ItemStack resultItem){
		CraftingManager.REGISTRY.forEach((recipe) -> {
			if(ItemStack.areItemsEqual(recipe.getRecipeOutput(), resultItem)) {
				recipes.add(recipe.getRegistryName());
			}
		});
	}

	private static void removeAllRecipe(){
		CraftingManager.REGISTRY.forEach((recipe) -> recipes.add(recipe.getRegistryName()));
	}
}
