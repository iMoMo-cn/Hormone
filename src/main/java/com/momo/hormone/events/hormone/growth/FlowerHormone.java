package com.momo.hormone.events.hormone.growth;


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

import java.util.Random;

@Mod.EventBusSubscriber(modid = MoMoFramework.MODID)
public class FlowerHormone {
    @SubscribeEvent
    public static void growFlower(PlayerInteractEvent.RightClickBlock evt) {
        World world = evt.getWorld();
        ItemStack itemstack = evt.getEntityPlayer().getHeldItem(evt.getHand());
        BlockPos pos = evt.getPos();
        EntityPlayer player = evt.getEntityPlayer();
        IBlockState state = world.getBlockState(pos);
        Block block = state.getBlock();
        Random random = new Random();

        if (itemstack.getItem() == ModItems.HORMONE_FLOWER && block == Blocks.GRASS)
        {
            player.swingArm(evt.getHand());

            if(!world.isRemote)
            {
                if (!player.capabilities.isCreativeMode)
                {
                    itemstack.shrink(1);
                }

                for (int x = -2; x <= 2; x++)
                {
                    for (int z = -2; z <= 2; z++)
                    {
                        BlockPos newPos = pos.add(x, 1, z);

                        if(random.nextFloat() < 0.04)
                        {
                            IBlockState iblockState = Blocks.YELLOW_FLOWER.getDefaultState();

                            if(iblockState.getBlock().canPlaceBlockAt(world, newPos))
                            {
                                world.setBlockState(newPos, iblockState, 3);
                            }

                            ((net.minecraft.world.WorldServer) world).spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, false, newPos.getX() + 0.5D, newPos.getY() + 1, newPos.getZ() + 0.5D, 2, 0.15D, 0.15D, 0.15D, 0.0D);

                            break;
                        }
                        if(random.nextFloat() < 0.36)
                        {
                            IBlockState iblockState = Blocks.RED_FLOWER.getDefaultState().withProperty(Blocks.RED_FLOWER.getTypeProperty(), BlockFlower.EnumFlowerType.getType(BlockFlower.EnumFlowerColor.RED, random.nextInt(9)));

                            if(iblockState.getBlock().canPlaceBlockAt(world, newPos))
                            {
                                world.setBlockState(newPos, iblockState, 3);
                            }

                            ((net.minecraft.world.WorldServer) world).spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, false, newPos.getX() + 0.5D, newPos.getY() + 1, newPos.getZ() + 0.5D, 2, 0.15D, 0.15D, 0.15D, 0.0D);
                        }
                    }
                }
            }
        }

        if(itemstack.getItem() == ModItems.HORMONE_FLOWER_PRO && block == Blocks.GRASS)
        {
            player.swingArm(evt.getHand());

            if(!world.isRemote)
            {
                if (!player.capabilities.isCreativeMode)
                {
                    itemstack.shrink(1);
                }

                for (int x = -2; x <= 2; x++)
                {
                    for (int z = -2; z <= 2; z++)
                    {
                        BlockPos newPos = pos.add(x, 1, z);

                        if(random.nextFloat() < 0.3)
                        {
                            int i = random.nextInt(6);
                            if(i >= 2 && i <= 3)
                            {
                                i = random.nextBoolean()? i + 2 : i - 2;
                            }

                            IBlockState iblockState = Blocks.DOUBLE_PLANT.getDefaultState().withProperty(BlockDoublePlant.VARIANT, BlockDoublePlant.EnumPlantType.byMetadata(i));

                            if(iblockState.getBlock().canPlaceBlockAt(world, newPos))
                            {
                                world.setBlockState(newPos, iblockState.withProperty(BlockDoublePlant.HALF, BlockDoublePlant.EnumBlockHalf.LOWER), 2);
                                world.setBlockState(newPos.up(), iblockState.withProperty(BlockDoublePlant.HALF, BlockDoublePlant.EnumBlockHalf.UPPER), 3);
                            }

                            ((net.minecraft.world.WorldServer) world).spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, false, newPos.getX() + 0.5D, newPos.getY() + 2, newPos.getZ() + 0.5D, 2, 0.15D, 0.15D, 0.15D, 0.0D);
                        }
                    }
                }
            }
        }
    }

}
