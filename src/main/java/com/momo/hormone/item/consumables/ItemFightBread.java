package com.momo.hormone.item.consumables;

import com.momo.hormone.init.ModCreativeTab;
import net.minecraft.creativetab.CreativeTabs;

public class ItemFightBread extends ItemConsumableBase {
    public ItemFightBread(String name) {
        super(name);
        setCreativeTab(CreativeTabs.FOOD);
    }
}
