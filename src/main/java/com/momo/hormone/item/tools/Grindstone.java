package com.momo.hormone.item.tools;

import com.momo.hormone.init.ModCreativeTab;
import com.momo.hormone.item.ItemBase;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class Grindstone extends ItemBase {
    public Grindstone() {
        super("grindstone");
        setCreativeTab(ModCreativeTab.FARMING);
    }

    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 16;
    }

    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BOW;
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        ItemStack itemstack1 = playerIn.getHeldItem(EnumHand.OFF_HAND);
        boolean flag1 = itemstack1.getItemDamage() != 0
                && (itemstack1.getItem() instanceof ItemTool || itemstack1.getItem() instanceof ItemSword) || itemstack1.getItem() instanceof ItemBow;

        if (handIn == EnumHand.MAIN_HAND && flag1 )
        {
            playerIn.setActiveHand(handIn);

            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
        }
        else
        {
            return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
        }
    }

    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        if (entityLiving instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;

            ItemStack itemstack = entityplayer.getHeldItemOffhand();

            itemstack.setItemDamage(itemstack.getItemDamage() - (int)(itemstack.getMaxDamage()*0.2));

            worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.BLOCK_ANVIL_USE, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);

            if (entityplayer instanceof EntityPlayerMP)
            {
                CriteriaTriggers.CONSUME_ITEM.trigger((EntityPlayerMP)entityplayer, stack);
            }

            if(!entityplayer.isCreative())
            {
                stack.shrink(1);
            }
        }

        return stack;
    }

}
