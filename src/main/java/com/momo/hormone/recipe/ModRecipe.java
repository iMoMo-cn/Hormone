package com.momo.hormone.recipe;

import com.google.common.collect.Sets;
import com.momo.hormone.MoMoFramework;
import com.momo.hormone.util.Reference;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

import java.util.Set;

import static com.momo.hormone.MoMoFramework.LogWarning;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class ModRecipe {

	public static Set<ResourceLocation> recipes = Sets.newHashSet();
	
	public static void init() {
		SmeltingRecipe.addSmeltingRecipe();

	}

	@SubscribeEvent
	public static void registerRecipes(RegistryEvent.Register<IRecipe> evt) {
		IForgeRegistry<IRecipe> r = evt.getRegistry();
		IForgeRegistryModifiable<IRecipe> registry = (IForgeRegistryModifiable<IRecipe>) r;

		//remove recipe
		removeRecipes(registry);


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
