package com.momo.hormone.events.hormone.aniaml;

import com.momo.hormone.MoMoFramework;
import com.momo.hormone.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = MoMoFramework.MODID)
public class HolyMob {
    @SubscribeEvent
    public static void holyMob(PlayerInteractEvent.EntityInteractSpecific evt) {
        World world = evt.getWorld();
        EntityPlayer player = evt.getEntityPlayer();
        EnumHand hand = evt.getHand();
        ItemStack itemstack = player.getHeldItem(hand);
        Entity target = evt.getTarget();

        if(!world.isRemote)
        {
            if (target instanceof EntityLiving && itemstack.getItem() == ModItems.HORMONE_HOLY)
            {
                EntityLiving targetLiving = (EntityLiving)target;
                if(targetLiving.isEntityUndead())
                {
                    if (!player.capabilities.isCreativeMode)
                    {
                        itemstack.shrink(1);
                    }

                    targetLiving.attackEntityFrom(DamageSource.MAGIC, 100.0F);

                    ((net.minecraft.world.WorldServer) world).spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, false, targetLiving.posX, targetLiving.posY + targetLiving.height, targetLiving.posZ, 10, 0.15D, 0.15D, 0.15D, 0.0D);
                }
            }
        }
    }
}
