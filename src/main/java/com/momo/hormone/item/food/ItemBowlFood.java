package com.momo.hormone.item.food;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBowlFood extends ItemFoodBase {
    public ItemBowlFood(String name, int amount, float saturation) {
        super(name, amount, saturation, false);
        this.setMaxStackSize(16);
    }

    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        if (entityLiving instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) entityLiving;
            if(!player.addItemStackToInventory(new ItemStack(Items.BOWL)) && !worldIn.isRemote)
            {
                worldIn.spawnEntity(new EntityItem(worldIn, player.posX, player.posY, player.posZ, new ItemStack(Items.BOWL)));
            }
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
