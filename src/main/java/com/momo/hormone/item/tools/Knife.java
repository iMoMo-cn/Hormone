package com.momo.hormone.item.tools;


import com.momo.hormone.init.ModCreativeTab;
import net.minecraft.item.ItemStack;

public class Knife extends ItemSwordBase {
    public Knife() {
        super("knife", ToolMaterial.STONE, ModCreativeTab.FARMING);

        this.setMaxDamage(-1);
        this.setContainerItem(this);
    }

    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) { return false; }

    public int getItemEnchantability()
    {
        return 0;
    }
}
