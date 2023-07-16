package com.momo.hormone.item.tools;


import com.momo.hormone.init.ModCreativeTab;
import net.minecraft.item.ItemStack;

public class Saw extends ItemAxeBase {
    public Saw() {
        super("saw", ToolMaterial.STONE, ModCreativeTab.FARMING);

        this.setMaxDamage(-1);
        this.setContainerItem(this);
    }

    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) { return false; }

    public int getItemEnchantability()
    {
        return 0;
    }
}
