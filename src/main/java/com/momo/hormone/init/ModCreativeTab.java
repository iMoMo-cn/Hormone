package com.momo.hormone.init;

import com.momo.hormone.item.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModCreativeTab {
//    public static final CreativeTabs TAB_NAME = new CreativeTabs(CreativeTabs.getNextID(), "tab_name")
//    {
//        @SideOnly(Side.CLIENT)
//        public ItemStack getTabIconItem() { return new ItemStack(Items.GOLD_INGOT); }
//    };

    public static final CreativeTabs HORMONE = new CreativeTabs(CreativeTabs.getNextID(), "hormone")
    {
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem()
        {
            return new ItemStack(ModItems.HORMONE_BONEMEAL);
        }
    };

    public static final CreativeTabs FARMING = new CreativeTabs(CreativeTabs.getNextID(), "easy_farming")
    {
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem()
        {
            return new ItemStack(ModItems.FIBRE);
        }
    };

    public static final CreativeTabs EXTRA_FOOD = new CreativeTabs(CreativeTabs.getNextID(), "extra_food")
    {
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem()
        {
            return new ItemStack(ModItems.CLASSICAL_BARBECUE);
        }
    };
}
