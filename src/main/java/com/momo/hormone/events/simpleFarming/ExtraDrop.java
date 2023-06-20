package com.momo.hormone.events.simpleFarming;

import com.momo.hormone.MoMoFramework;
import com.momo.hormone.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.passive.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid = MoMoFramework.MODID)
public class ExtraDrop {
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

    @SubscribeEvent
    public static void TallGrassDestroy(BlockEvent.HarvestDropsEvent evt){
        Block blockdrop = evt.getState().getBlock();
        List<ItemStack> drops;
        Random r = new Random();
        if(blockdrop == Blocks.TALLGRASS){
            drops = evt.getDrops();

            if(r.nextFloat() < 0.3 )
            {
                drops.add(new ItemStack(ModItems.FIBRE, 1));
            }
        }
    }

    @SubscribeEvent
    public static void FishingLoot(LootTableLoadEvent evt) {

        String name = evt.getName().toString();
        if (name.equals("minecraft:gameplay/fishing/fish"))
        {
            LootPool pool1 = evt.getTable().getPool("main");
            if (pool1 != null)
            {
                pool1.addEntry(getInjectEntry("hormone:fishing/fish", 20, 0));
            }
        }
    }

    static LootEntryTable getInjectEntry(String name, int weight, int quality)
    {
        return new LootEntryTable(new ResourceLocation(name), weight, quality, new LootCondition[0], MoMoFramework.MODID + "_inject_entry");
    }
}
