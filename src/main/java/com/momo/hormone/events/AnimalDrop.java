package com.momo.hormone.events;

import com.momo.hormone.MoMoFramework;
import com.momo.hormone.item.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.passive.*;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid = MoMoFramework.MODID)
public class AnimalDrop {
    @SubscribeEvent
    public static void Drop(LivingDropsEvent evt){
        EntityLivingBase living = evt.getEntityLiving();
        Random r = new Random();
        List<EntityItem> drops;

        World world = living.world;
        double x = living.posX;
        double y = living.posY;
        double z = living.posZ;

        if(living instanceof EntityPig || living instanceof EntityCow || living instanceof EntitySheep || living instanceof EntityHorse || living instanceof EntityPolarBear || living instanceof EntityMule)
        {
            drops = evt.getDrops();
            int num = r.nextInt(3);
            drops.add(new EntityItem(world, x, y, z, new ItemStack(Items.BONE, num)));
        }

        if(living instanceof EntityPig)
        {
            drops = evt.getDrops();
            int num = r.nextInt(3);
            drops.add(new EntityItem(world, x, y, z, new ItemStack(ModItems.PIG_EYE, num)));
        }
    }
}
