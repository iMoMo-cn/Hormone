package com.momo.hormone.events;

import com.momo.hormone.MoMoFramework;
import com.momo.hormone.blocks.ModBlocks;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = MoMoFramework.MODID)
public class PlantMushroom {
    @SubscribeEvent
    public static void onUse(PlayerInteractEvent.RightClickBlock evt) {
        World world = evt.getWorld();
        BlockPos pos = evt.getPos();
        EntityPlayer player = evt.getEntityPlayer();
        IBlockState state = world.getBlockState(pos);
        Block block = state.getBlock();
        EnumFacing facing = evt.getFace();

        if(block == Blocks.FARMLAND && facing == EnumFacing.UP && world.isAirBlock(pos.up()))
        {
            ItemStack itemstack = player.getHeldItemMainhand();

            if(itemstack.getItem() == Item.getItemFromBlock(Blocks.RED_MUSHROOM))
            {
                PlaceMushroom(world, pos, ModBlocks.MUSHROOM_RED, player, itemstack);
            }

            else if(itemstack.getItem() == Item.getItemFromBlock(Blocks.BROWN_MUSHROOM))
            {
                PlaceMushroom(world, pos, ModBlocks.MUSHROOM_BROWN, player, itemstack);
            }

            else {
                itemstack = player.getHeldItemOffhand();
                if (itemstack.getItem() == Item.getItemFromBlock(Blocks.RED_MUSHROOM))
                {
                    PlaceMushroom(world, pos, ModBlocks.MUSHROOM_RED, player, itemstack);
                }

                if (itemstack.getItem() == Item.getItemFromBlock(Blocks.BROWN_MUSHROOM))
                {
                    PlaceMushroom(world, pos, ModBlocks.MUSHROOM_BROWN, player, itemstack);
                }
            }
        }
    }

    public static void PlaceMushroom(World world, BlockPos pos, Block block, EntityPlayer player, ItemStack itemstack)
    {
        world.setBlockState(pos.up(), block.getDefaultState());

        if (player instanceof EntityPlayerMP)
        {
            CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)player, pos.up(), itemstack);
        }

        if (!player.capabilities.isCreativeMode) { itemstack.shrink(1); }
    }

}
