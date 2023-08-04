package com.momo.hormone.events.simpleFarming;

import com.momo.hormone.MoMoFramework;
import com.momo.hormone.blocks.ModBlocks;
import com.momo.hormone.item.ModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

@Mod.EventBusSubscriber(modid = MoMoFramework.MODID)
public class PlantCrops {
    @SubscribeEvent
    public static void plantCrops(PlayerInteractEvent.RightClickBlock evt) {
        World world = evt.getWorld();
        BlockPos pos = evt.getPos();
        EntityPlayer player = evt.getEntityPlayer();
        IBlockState state = world.getBlockState(pos);
        EnumHand hand = evt.getHand();
        Block block = state.getBlock();
        EnumFacing facing = evt.getFace();
        ItemStack itemstack = player.getHeldItem(hand);

        if(block == Blocks.FARMLAND && facing == EnumFacing.UP && world.isAirBlock(pos.up()))
        {
            if(itemstack.getItem() == ModItems.HORMONE_MUSHROOM_RED)
            {
                player.swingArm(hand);
                plantCrops(world, pos, ModBlocks.MUSHROOM_RED, player, itemstack);
            }

            if(itemstack.getItem() == ModItems.HORMONE_MUSHROOM_BROWN)
            {
                player.swingArm(hand);
                plantCrops(world, pos, ModBlocks.MUSHROOM_BROWN, player, itemstack);
            }

            if(itemstack.getItem() == ModItems.HORMONE_GOLD_CARROT)
            {
                player.swingArm(hand);
                plantCrops(world, pos, ModBlocks.GOLED_CARROT, player, itemstack);
            }
        }

        if(block == Blocks.DIRT || block == Blocks.MYCELIUM)
        {
            if(itemstack.getItem() == ModItems.HORMONE_GRASS)
            {
                player.swingArm(hand);
                plantBlock(world, pos, Blocks.GRASS, player, itemstack);
            }
        }

        if(block == Blocks.DIRT || block == Blocks.GRASS)
        {
            if(itemstack.getItem() == ModItems.HORMONE_MUSHROOM)
            {
                player.swingArm(hand);
                plantBlock(world, pos, Blocks.MYCELIUM, player, itemstack);
            }
        }
    }

    public static void plantCrops(World world, BlockPos pos, Block block, EntityPlayer player, ItemStack itemstack)
    {
        if(!world.isRemote)
        {
            world.setBlockState(pos.up(), block.getDefaultState(), 3);
        }

        if (!player.capabilities.isCreativeMode)
        {
            itemstack.shrink(1);
        }
    }

    public static void plantBlock(World world, BlockPos pos, Block block, EntityPlayer player, ItemStack itemstack)
    {
        if (!player.capabilities.isCreativeMode) { itemstack.shrink(1); }

        if(!world.isRemote)
        {
            for(int i = -1; i <= 1; i++)
            {
                for(int j = -1; j <= 1; j++)
                {
                    if(block == Blocks.DIRT || block == Blocks.GRASS || block == Blocks.MYCELIUM)
                    {
                        world.setBlockState(pos.add(i, 0, j), block.getDefaultState(), 3);
                    }
                }
            }
        }
    }

}
