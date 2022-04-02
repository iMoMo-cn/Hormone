package com.momo.hormone.events;

import com.momo.hormone.MoMoFramework;
import com.momo.hormone.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid = MoMoFramework.MODID)
public class PumpkinDrop {
    @SubscribeEvent
    public static void PumpkinDestroy(BlockEvent.HarvestDropsEvent evt){
        Block blockdrop = evt.getState().getBlock();
        List<ItemStack> drops;
        Random r = new Random();
        if(blockdrop == Blocks.PUMPKIN){
            drops = evt.getDrops();
            drops.clear();

            int num = r.nextInt(5) + 3;
            drops.add(new ItemStack(ModItems.PUMPKIN_SLICE, num));
        }
    }
}
