package com.momo.hormone.init;

import com.momo.hormone.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ModOreDict {
    public static void init()
    {
        OreDictionary.registerOre("string", ModItems.FIBRE);
        OreDictionary.registerOre("slimeball", ModItems.PASTEBALL);
        OreDictionary.registerOre("slimeballs", ModItems.PASTEBALL);
        OreDictionary.registerOre("gunpowder", ModItems.BLACK_POWDER);
        OreDictionary.registerOre("enderpearl", ModItems.PEARL);

        OreDictionary.registerOre("cropBeetroot", Items.BEETROOT);
        OreDictionary.registerOre("pumpkin", Blocks.PUMPKIN);
        OreDictionary.registerOre("melon", Blocks.MELON_BLOCK);
        OreDictionary.registerOre("listAllmushroom", Blocks.RED_MUSHROOM);
        OreDictionary.registerOre("listAllmushroom", Blocks.BROWN_MUSHROOM);
        OreDictionary.registerOre("listAllegg", ModItems.COOKED_EGG);

        OreDictionary.registerOre("listAllmeatraw", ModItems.SCRAPED_FLESH);
        OreDictionary.registerOre("listAllmeatraw", Items.CHICKEN);
        OreDictionary.registerOre("listAllmeatraw", Items.RABBIT);
        OreDictionary.registerOre("listAllmeatraw", Items.PORKCHOP);
        OreDictionary.registerOre("listAllmeatraw", Items.MUTTON);
        OreDictionary.registerOre("listAllmeatraw", Items.BEEF);

        OreDictionary.registerOre("listAllmeatcooked", ModItems.COOKED_FLESH);
        OreDictionary.registerOre("listAllmeatcooked", Items.COOKED_CHICKEN);
        OreDictionary.registerOre("listAllmeatcooked", Items.COOKED_RABBIT);
        OreDictionary.registerOre("listAllmeatcooked", Items.COOKED_PORKCHOP);
        OreDictionary.registerOre("listAllmeatcooked", Items.COOKED_MUTTON);
        OreDictionary.registerOre("listAllmeatcooked", Items.COOKED_BEEF);
    }
}
