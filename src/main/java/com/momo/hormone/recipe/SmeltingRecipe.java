package com.momo.hormone.recipe;

import com.momo.hormone.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nonnull;

public class SmeltingRecipe {

    public static void addSmeltingRecipe(){
        add(ModItems.PASTE_FLOWER, new ItemStack(ModItems.BISCUIT_FLOWER), 0.3F);
        add(ModItems.PASTE_BONE, new ItemStack(ModItems.BISCUIT_BONE), 0.3F);
        add(ModItems.PASTE_CARROT, new ItemStack(ModItems.BISCUIT_CARROT), 0.3F);
        add(ModItems.PASTE_FISH, new ItemStack(ModItems.BISCUIT_FISH), 0.3F);
        add(ModItems.PASTE_SEEDS, new ItemStack(ModItems.BISCUIT_SEEDS), 0.3F);
        add(ModItems.PASTE_WHEAT, new ItemStack(ModItems.BISCUIT_WHEAT), 0.3F);
        add(ModItems.PASTE_ROTTEN, new ItemStack(ModItems.BISCUIT_ROTTEN), 0.3F);
        add(ModItems.PASTE_HOLY, new ItemStack(ModItems.BISCUIT_HOLY), 0.3F);

        add(ModItems.BLACK_POWDER, new ItemStack(Items.BLAZE_POWDER), 0.3F);

        add(Items.APPLE, new ItemStack(ModItems.BAKED_APPLE), 0.3F);
        add(Items.CARROT, new ItemStack(ModItems.BAKED_CARROT), 0.3F);
        add(Items.BEETROOT, new ItemStack(ModItems.BAKED_BEETROOT), 0.3F);
        add(Items.EGG, new ItemStack(ModItems.COOKED_EGG), 0.3F);
        add(ModItems.SCRAPED_FLESH, new ItemStack(ModItems.COOKED_FLESH), 0.3F);
        add(new ItemStack(Items.DYE, 1, 3), new ItemStack(ModItems.CHOCOLATE), 0.3F);

        add(ModItems.BAKED_APPLE, new ItemStack(ModItems.COAL_APPLE), 0.5F);
        add(ModItems.BAKED_CARROT, new ItemStack(ModItems.COAL_CARROT), 0.5F);
        add(Items.BAKED_POTATO, new ItemStack(ModItems.COAL_POTATO), 0.5F);
        add(ModItems.BAKED_BEETROOT, new ItemStack(ModItems.COAL_BEETROOT), 0.5F);
        add(ModItems.PUMPKIN_SLICE, new ItemStack(ModItems.COAL_PUMPKIN), 0.5F);
        add(Items.MELON, new ItemStack(ModItems.COAL_MELON), 0.5F);
        add(Items.WHEAT, new ItemStack(ModItems.COAL_WHEAT), 0.5F);

        add(ModItems.DICED_VEGETABLE, new ItemStack(ModItems.COOKED_DICED_VEGETABLE), 0.5F);
        add(ModItems.DICED_MEAT, new ItemStack(ModItems.COOKED_DICED_MEAT), 0.5F);
        add(ModItems.VEGETABLE_SKEWERS, new ItemStack(ModItems.VEGETABLE_BARBECUE), 0.5F);
        add(ModItems.MEAT_SKEWERS, new ItemStack(ModItems.MEAT_BARBECUE), 0.5F);
        add(ModItems.MUSHROOM_SKEWERS, new ItemStack(ModItems.MUSHROOM_BARBECUE), 0.5F);
        add(ModItems.CLASSICAL_SKEWERS, new ItemStack(ModItems.CLASSICAL_BARBECUE), 0.5F);
    }

    public static void add(Block input, @Nonnull ItemStack output, float xp)
    {
        GameRegistry.addSmelting(input, output, xp);
    }

    public static void add(Item input, @Nonnull ItemStack output, float xp)
    {
        GameRegistry.addSmelting(input, output, xp);
    }

    public static void add(@Nonnull ItemStack input, @Nonnull ItemStack output, float xp)
    {
        GameRegistry.addSmelting(input, output, xp);
    }
}
