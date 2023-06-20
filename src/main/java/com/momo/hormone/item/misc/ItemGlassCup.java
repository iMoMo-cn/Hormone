package com.momo.hormone.item.misc;

import com.momo.hormone.item.ItemBase;
import com.momo.hormone.item.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;


public class ItemGlassCup extends ItemBase {
    public ItemGlassCup() {
        super("glass_cup");
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, true);

        if (raytraceresult == null)
        {
            return new ActionResult(EnumActionResult.PASS, itemstack);
        }
        else {
            if (raytraceresult.typeOfHit == RayTraceResult.Type.BLOCK)
            {
                BlockPos blockpos = raytraceresult.getBlockPos();
                if (!worldIn.isBlockModifiable(playerIn, blockpos) || !playerIn.canPlayerEdit(blockpos.offset(raytraceresult.sideHit), raytraceresult.sideHit, itemstack))
                {
                    return new ActionResult(EnumActionResult.PASS, itemstack);
                }
                if (worldIn.getBlockState(blockpos).getMaterial() == Material.WATER)
                {
                    worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                    return new ActionResult(EnumActionResult.SUCCESS, this.turnBottleIntoItem(itemstack, playerIn, new ItemStack(ModItems.WATER_CUP)));
                }
                if (worldIn.getBlockState(blockpos).getMaterial() == Material.LAVA)
                {
                    worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                    return new ActionResult(EnumActionResult.SUCCESS, this.turnBottleIntoItem(itemstack, playerIn, new ItemStack(ModItems.LAVA_CUP)));
                }
            }

            return new ActionResult(EnumActionResult.PASS, itemstack);
        }
    }

    private ItemStack turnBottleIntoItem(ItemStack stack, EntityPlayer player, ItemStack cup)
    {
        stack.shrink(1);
        player.addStat(StatList.getObjectUseStats(this));

        if (stack.isEmpty())
        {
            return cup;
        }
        else
        {
            if (!player.inventory.addItemStackToInventory(cup))
            {
                player.dropItem(cup, false);
            }

            return stack;
        }
    }
}
