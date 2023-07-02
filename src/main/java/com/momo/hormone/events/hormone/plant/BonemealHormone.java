package com.momo.hormone.events.hormone.plant;


import com.momo.hormone.MoMoFramework;
import com.momo.hormone.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = MoMoFramework.MODID)
public class BonemealHormone {
    @SubscribeEvent
    public static void growCrop(PlayerInteractEvent.RightClickBlock evt) {
        World world = evt.getWorld();
        ItemStack itemstack = evt.getEntityPlayer().getHeldItem(evt.getHand());
        BlockPos pos = evt.getPos();
        EntityPlayer player = evt.getEntityPlayer();
        IBlockState state = world.getBlockState(pos);
        Block block = state.getBlock();

        //Groups
        if (itemstack.getItem() == ModItems.HORMONE_BONEMEAL && block instanceof BlockCrops)
        {
            if(!((BlockCrops)block).isMaxAge(state))
            {
                player.swingArm(evt.getHand());

                if(!player.capabilities.isCreativeMode)
                {
                    itemstack.shrink(1);
                }

                for (int x = -1; x <= 1; x++)
                {
                    for (int z = -1; z <= 1; z++)
                    {
                        grow(pos.add(x, 0, z), world);
                    }
                }
            }
        }
        //Cocoa
        else if(itemstack.getItem() == ModItems.HORMONE_BONEMEAL && block instanceof BlockCocoa)
        {
            if((state.getValue(BlockCocoa.AGE)) < 2)
            {
                player.swingArm(evt.getHand());

                if(!player.capabilities.isCreativeMode)
                {
                    itemstack.shrink(1);
                }

                for (int x = -1; x <= 1; x++)
                {
                    for(int y = -1; y <= 1; y++)
                    {
                        for (int z = -1; z <= 1; z++)
                        {
                            grow(pos.add(x, y, z), world);
                        }
                    }
                }
            }
        }
        //Stem
        else if(itemstack.getItem() == ModItems.HORMONE_BONEMEAL && block instanceof BlockStem)
        {
            if((state.getValue(BlockStem.AGE)) != 7)
            {
                player.swingArm(evt.getHand());

                if(!player.capabilities.isCreativeMode)
                {
                    itemstack.shrink(1);
                }

                for (int x = -1; x <= 1; x++)
                {
                    for (int z = -1; z <= 1; z++)
                    {
                        grow(pos.add(x, 0, z), world);
                    }
                }
            }
        }
        //Sapling
        else if(itemstack.getItem() == ModItems.HORMONE_BONEMEAL && block instanceof BlockSapling)
        {
            player.swingArm(evt.getHand());

            if(!player.capabilities.isCreativeMode)
            {
                itemstack.shrink(1);
            }

            for (int x = -1; x <= 1; x++)
            {
                for (int z = -1; z <= 1; z++)
                {
                    grow(pos.add(x, 0, z), world);
                }
            }
        }
    }

    private static void grow(BlockPos pos, World world)
    {
        if(!world.isRemote)
        {
            IBlockState state = world.getBlockState(pos);
            Block block = state.getBlock();

            if(block instanceof BlockStem)
            {
                stemGrow(state, world, pos);
            }
            else if(block == Blocks.SAPLING)
            {
                saplingGrow(world, pos);
            }
            else if(block == Blocks.COCOA)
            {
                cropGrow(state, world, pos, 3);
            }
            else if(block instanceof BlockCrops)
            {
                cropGrow(state, world, pos, 7);
            }
        }

    }

    private static void cropGrow(IBlockState state, World world, BlockPos pos, int loops){
        for (int i = 0; i < loops; i++)
        {
            if(state.getBlock() instanceof BlockCrops)
            {
                IGrowable GrowableCrop = (IGrowable) state.getBlock();

                state = world.getBlockState(pos);

                if (GrowableCrop.canGrow(world, pos, state, false))
                {
                    GrowableCrop.grow(world, world.rand, pos, state);
                    ((net.minecraft.world.WorldServer) world).spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, false, pos.getX() + 0.5D, pos.getY() + 1.0D, pos.getZ() + 0.5D, 2, 0.15D, 0.15D, 0.15D, 0.0D);
                }
            }
        }
    }

    private static void saplingGrow(World world, BlockPos saplingPos)
    {
        for(int i = 0; i < 2; i++)
        {
            IBlockState saplingState = world.getBlockState(saplingPos);

            if(saplingState.getBlock() instanceof BlockSapling)
            {
                IGrowable sapling = (IGrowable) saplingState.getBlock();

                sapling.grow(world, world.rand, saplingPos, saplingState);

                ((net.minecraft.world.WorldServer) world).spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, false, saplingPos.getX() + 0.5D, saplingPos.getY() + 1, saplingPos.getZ() + 0.5D, 2, 0.15D, 0.15D, 0.15D, 0.0D);

            }
        }
    }

    private static void stemGrow(IBlockState state, World world, BlockPos pos)
    {
        for(int i = 0; i < 8; i++)
        {
            IGrowable GrowableStem = (IGrowable) state.getBlock();

            state  = world.getBlockState(pos);

            if (state.getBlock() instanceof BlockStem)
            {
                if (GrowableStem.canGrow(world, pos, state, false))
                {
                    GrowableStem.grow(world, world.rand, pos, state);
                    ((net.minecraft.world.WorldServer) world).spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, false, pos.getX() + 0.5D, pos.getY() + 1, pos.getZ() + 0.5D, 2, 0.15D, 0.15D, 0.15D, 0.0D);
                }
            }
        }
    }
}
