package com.momo.hormone.events.hormone.aniaml;

import com.momo.hormone.MoMoFramework;
import com.momo.hormone.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = MoMoFramework.MODID)
public class RottenMob {
    @SubscribeEvent
    public static void rottenMob(PlayerInteractEvent.EntityInteractSpecific evt) {
        World world = evt.getWorld();
        EntityPlayer player = evt.getEntityPlayer();
        EnumHand hand = evt.getHand();
        ItemStack itemstack = player.getHeldItem(hand);
        Entity target = evt.getTarget();

        if (!world.isRemote) {
            if (target instanceof EntityZombie && itemstack.getItem() == ModItems.HORMONE_ROTTEN) {
                if (!player.capabilities.isCreativeMode) {
                    itemstack.shrink(1);
                }

                EntitySkeleton entitySkeleton = new EntitySkeleton(target.world);
                eventBase(target, entitySkeleton);
                target.playSound(SoundEvents.ENTITY_SKELETON_AMBIENT, 1.0F, 1.0F);
            }

            if (target instanceof EntitySkeleton && itemstack.getItem() == ModItems.HORMONE_ROTTEN) {
                if (!player.capabilities.isCreativeMode) {
                    itemstack.shrink(1);
                }

                EntityWitherSkeleton entityWitherSkeleton = new EntityWitherSkeleton(target.world);
                eventBase(target, entityWitherSkeleton);
                target.playSound(SoundEvents.ENTITY_WITHER_SKELETON_AMBIENT, 1.0F, 1.0F);
            }

            if (target instanceof EntityVillager && itemstack.getItem() == ModItems.HORMONE_ROTTEN) {
                if (!player.capabilities.isCreativeMode) {
                    itemstack.shrink(1);
                }

                EntityWitch entityWitch = new EntityWitch(target.world);
                eventBase(target, entityWitch);
                target.playSound(SoundEvents.ENTITY_WITCH_AMBIENT, 1.0F, 1.0F);
            }
        }
    }

    private static void eventBase(Entity target, Entity newborn)
    {
        livingBaseIn(target, newborn);
        equipmentIn(target, newborn);
        deadAndBorn(target, newborn);
    }

    private static void equipmentIn(Entity target, Entity newborn)
    {
        final EntityEquipmentSlot array[] = new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND, EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET};
        for(int i = 0; i < array.length; i++)
        {
            newborn.setItemStackToSlot(array[i], ((EntityLiving) target).getItemStackFromSlot(array[i]));
        }
    }

    private static void livingBaseIn(Entity target, Entity newborn)
    {
        newborn.setPositionAndRotation(target.posX, target.posY, target.posZ, target.rotationYaw, target.rotationPitch);
        ((EntityLiving) newborn).renderYawOffset = ((EntityLiving) target).renderYawOffset;

        if (target.hasCustomName())
        {
            newborn.setCustomNameTag(target.getCustomNameTag());
        }

        float health = ((EntityLiving) target).getHealth() / ((EntityLiving) target).getMaxHealth();
        ((EntityLiving) newborn).setHealth(((EntityLiving) newborn).getMaxHealth() * health);
    }

    private  static void deadAndBorn(Entity target, Entity newborn)
    {
        target.setDead();
        ((net.minecraft.world.WorldServer) target.world).spawnParticle(EnumParticleTypes.SPELL_WITCH, false, target.posX, target.posY + (double) target.height, target.posZ, 10, 0.5D, 0.5D, 0.5D, 0.0D);
        target.world.spawnEntity(newborn);
    }
}
