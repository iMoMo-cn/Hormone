package com.momo.hormone.events;

import com.momo.hormone.IdlFramework;
import com.momo.hormone.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = IdlFramework.MODID)
public class InstantGrowth {
    @SubscribeEvent
    public static void Target(PlayerInteractEvent.EntityInteractSpecific evt) {
        EntityPlayer player = evt.getEntityPlayer();
        Entity target = evt.getTarget();
        EnumHand hand = evt.getHand();
        ItemStack itemstack = player.getHeldItem(hand);

        if ((target instanceof EntityCow || target instanceof EntitySheep || target instanceof EntityLlama)
                && itemstack.getItem() == ModItems.HORMONE_WHEAT ) {
            Growth(player, target, itemstack);
        }

        if ((target instanceof EntityChicken) && itemstack.getItem() == ModItems.HORMONE_SEEDS) {
            Growth(player, target, itemstack);
        }

        if ((target instanceof EntityPig || target instanceof EntityRabbit || target instanceof EntityMule
                || target instanceof EntityHorse || target instanceof EntityDonkey)
                && itemstack.getItem() == ModItems.HORMONE_CARROT) {
            Growth(player, target, itemstack);
        }

        if ((target instanceof EntityOcelot || target instanceof EntityPolarBear)
                && itemstack.getItem() == ModItems.HORMONE_FISH) {
            Growth(player, target, itemstack);
        }

        if ((target instanceof EntityWolf) && itemstack.getItem() == ModItems.HORMONE_BONE) {
            Growth(player, target, itemstack);
        }
    }

    private static void Growth(EntityPlayer player, Entity target, ItemStack itemstack) {
        if (((EntityAnimal) target).isChild() && !target.world.isRemote) {
            if (!player.capabilities.isCreativeMode) { itemstack.shrink(1); }
            ((EntityAnimal) target).setGrowingAge(1);
            ((net.minecraft.world.WorldServer) target.world).spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, false, target.posX, target.posY + (double) (target.height), target.posZ, 5, 0.15D, 0.15D, 0.15D, 0.0D);
        }
    }
}
