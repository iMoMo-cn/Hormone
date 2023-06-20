package com.momo.hormone.item.food;

import com.momo.hormone.item.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDrink extends ItemFoodBase {
    public ItemDrink(String name, int amount, float saturation) {
        super(name, amount, saturation, false);

        this.setAlwaysEdible();
    }

    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        if (entityLiving instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) entityLiving;
            ItemStack itemStack = new ItemStack(ModItems.GLASS_CUP);
            if(!player.addItemStackToInventory(itemStack) && !worldIn.isRemote)
            {
                player.dropItem(itemStack, false);
                worldIn.spawnEntity(new EntityItem(worldIn, player.posX, player.posY, player.posZ, new ItemStack(Items.GLASS_BOTTLE)));
            }
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }

    public EnumAction getItemUseAction(ItemStack stack) { return EnumAction.DRINK; }
}
