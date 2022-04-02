package com.momo.hormone.item;

import net.minecraft.item.ItemStack;

public class ItemBurnable extends ItemBase {
    private int burntime;

    public ItemBurnable(String name, int burntime) {
        super(name);
        this.burntime = burntime;
    }

    @Override
    public int getItemBurnTime(ItemStack itemStack)
    {
        return burntime;
    }
}
