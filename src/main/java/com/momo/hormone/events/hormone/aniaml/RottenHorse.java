package com.momo.hormone.events.hormone.aniaml;

import com.momo.hormone.MoMoFramework;
import com.momo.hormone.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = MoMoFramework.MODID)
public class RottenHorse {
    @SubscribeEvent
    public static void rottenHorse(PlayerInteractEvent.EntityInteractSpecific evt) {
        World world = evt.getWorld();
        EntityPlayer player = evt.getEntityPlayer();
        EnumHand hand = evt.getHand();
        ItemStack itemstack = player.getHeldItem(hand);
        Entity target = evt.getTarget();

        if (!world.isRemote) {
            if (target instanceof EntityHorse && itemstack.getItem() == ModItems.HORMONE_ROTTEN) {
                if (!player.capabilities.isCreativeMode) { itemstack.shrink(1); }

                EntityZombieHorse entityZombieHorse = new EntityZombieHorse(target.world);

                LivingBaseIn(target, entityZombieHorse);
                entityZombieHorse.setHealth(15*((EntityHorse) target).getHealth()/((EntityHorse) target).getMaxHealth());

                TampIn(target, entityZombieHorse);

                HorseArmor(target);

                DeadAndBorn(target, entityZombieHorse);
            }

            if (target instanceof EntityZombieHorse && itemstack.getItem() == ModItems.HORMONE_ROTTEN) {
                if (!player.capabilities.isCreativeMode) { itemstack.shrink(1); }

                EntitySkeletonHorse entitySkeletonHorse = new EntitySkeletonHorse(target.world);

                LivingBaseIn(target, entitySkeletonHorse);

                TampIn(target, entitySkeletonHorse);

                DeadAndBorn(target, entitySkeletonHorse);
            }
        }
    }

    private static void LivingBaseIn(Entity target, Entity newborn)
    {
        newborn.setLocationAndAngles(target.posX, target.posY, target.posZ, target.rotationYaw, target.rotationPitch);
        ((EntityLiving) newborn).setHealth(((EntityLiving) target).getHealth());
        ((EntityLiving) newborn).renderYawOffset = ((EntityLiving) target).renderYawOffset;
        ((EntityAgeable) newborn).setGrowingAge(((EntityAgeable) target).getGrowingAge());

        if (target.hasCustomName())
        {
            newborn.setCustomNameTag(target.getCustomNameTag());
        }
    }

    private static void TampIn(Entity target, Entity newborn)
    {
        if(((AbstractHorse) target).isTame())
        {
            if(((AbstractHorse) target).isHorseSaddled())
            {
                target.world.spawnEntity(new EntityItem(target.world, target.posX, target.posY, target.posZ, new ItemStack(Items.SADDLE)));
            }
            ((AbstractHorse) newborn).setHorseTamed(true);
        }
    }

    private static void HorseArmor(Entity target)
    {
        EntityHorse horse = (EntityHorse)target;
        if (horse.getHorseArmorType() == HorseArmorType.IRON){target.world.spawnEntity(new EntityItem(target.world, target.posX, target.posY, target.posZ, new ItemStack(Items.IRON_HORSE_ARMOR)));}
        else if(horse.getHorseArmorType() == HorseArmorType.GOLD){target.world.spawnEntity(new EntityItem(target.world, target.posX, target.posY, target.posZ, new ItemStack(Items.GOLDEN_HORSE_ARMOR)));}
        else if(horse.getHorseArmorType() == HorseArmorType.DIAMOND){target.world.spawnEntity(new EntityItem(target.world, target.posX, target.posY, target.posZ, new ItemStack(Items.DIAMOND_HORSE_ARMOR)));}
    }

    private  static void DeadAndBorn(Entity target, Entity newborn)
    {
        target.setDead();
        target.world.addWeatherEffect(new EntityLightningBolt(target.world, target.posX, target.posY, target.posZ, true));
        target.world.spawnEntity(newborn);
    }
}
