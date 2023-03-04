package com.momo.hormone.util;

import com.momo.hormone.item.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDict {
    public static void init()
    {
        OreDictionary.registerOre("string", new ItemStack(ModItems.FIBRE));
        OreDictionary.registerOre("slimeball", new ItemStack(ModItems.PASTEBALL));
        OreDictionary.registerOre("slimeballs", new ItemStack(ModItems.PASTEBALL));
        OreDictionary.registerOre("gunpowder", new ItemStack(ModItems.BLACK_POWDER));

        OreDictionary.registerOre("cropBeetroot", new ItemStack(Items.BEETROOT));
    }
}
