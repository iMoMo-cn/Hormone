package com.momo.hormone.events;


import com.momo.hormone.IdlFramework;
import com.momo.hormone.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = IdlFramework.MODID)
public class BonemealHormone {
    @SubscribeEvent
    public static void onUse(PlayerInteractEvent.RightClickBlock evt) {
        World world = evt.getWorld();
        ItemStack itemstack = evt.getEntityPlayer().getHeldItem(evt.getHand());
        BlockPos pos = evt.getPos();
        EntityPlayer player = evt.getEntityPlayer();
        IBlockState state = world.getBlockState(pos);
        Block block = state.getBlock();

        //Groups
        if (itemstack.getItem() == ModItems.HORMONE_BONEMEAL && !world.isRemote
                && block instanceof BlockCrops && ((BlockCrops) block).canGrow(world, pos, state, false)){
            player.swingArm(evt.getHand());
            if(!player.capabilities.isCreativeMode){itemstack.shrink(1);}
            for (int x0 = -1; x0 <= 1; x0++) {
                for (int z0 = -1; z0 <= 1; z0++) {
                    int x = pos.getX() + x0;
                    int y = pos.getY();
                    int z = pos.getZ() + z0;
                    getBlock(x,y,z,world);
                }
            }
        }
        //Cocoa
        else if(itemstack.getItem() == ModItems.HORMONE_BONEMEAL && !world.isRemote
                && block instanceof BlockCocoa && ((BlockCocoa) block).canGrow(world, pos, state,false)){
            player.swingArm(evt.getHand());
            if(!player.capabilities.isCreativeMode){itemstack.shrink(1);}
            for (int x0 = -1; x0 <= 1; x0++) {
                for(int y0 = -1; y0 <= 1; y0++) {
                    for (int z0 = -1; z0 <= 1; z0++) {
                        int x = pos.getX() + x0;
                        int y = pos.getY() + y0;
                        int z = pos.getZ() + z0;
                        getBlock(x,y,z,world);
                    }
                }
            }
        }
        //Sapling
        else if(itemstack.getItem() == ModItems.HORMONE_BONEMEAL && !world.isRemote
                && block instanceof BlockSapling){
            player.swingArm(evt.getHand());
            if(!player.capabilities.isCreativeMode){itemstack.shrink(1);}
            for (int x0 = -2; x0 <= 2; x0++){
                for (int z0 = -2; z0 <= 2; z0++){
                    int x = pos.getX() + x0;
                    int y = pos.getY();
                    int z = pos.getZ() + z0;
                    getBlock(x,y,z,world);
                }
            }
        }
        //Stem
        else if(itemstack.getItem() == ModItems.HORMONE_BONEMEAL && !world.isRemote
                && block instanceof BlockStem){
            player.swingArm(evt.getHand());
            if(!player.capabilities.isCreativeMode){itemstack.shrink(1);}
            for (int x0 = -1; x0 <= 1; x0++) {
                for (int z0 = -1; z0 <= 1; z0++) {
                    int x = pos.getX() + x0;
                    int y = pos.getY();
                    int z = pos.getZ() + z0;
                    getBlock(x,y,z,world);
                }
            }
        }
    }

    private static void getBlock(int x,int y,int z, World world){
        BlockPos CropPos = new BlockPos(x, y, z); IBlockState CropState = world.getBlockState(CropPos); Block CropBlock = CropState.getBlock();
        if (CropBlock instanceof BlockStem) { GrowthStem(CropState, world, CropPos);}
        if (CropBlock instanceof BlockSapling){ GrowthSapling (CropState, world, CropPos); }
        if (CropBlock instanceof BlockCocoa) { Growth(CropState, world, CropPos, 3);}
        if (CropBlock instanceof BlockCrops) { Growth(CropState, world, CropPos, 7); }
    }

    private static void Growth(IBlockState CropState, World world, BlockPos CropPos, int loops){
        for (int i = 0; i < loops; i++) {
            IGrowable GrowableCrop = (IGrowable) CropState.getBlock();
            CropState = world.getBlockState(CropPos);
            if (GrowableCrop.canGrow(world, CropPos, CropState, false))
            {
                GrowableCrop.grow(world, world.rand, CropPos, CropState);
                ((net.minecraft.world.WorldServer) world).spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, false, CropPos.getX() + 0.5D, CropPos.getY() + 1.0D, CropPos.getZ() + 0.5D, 2, 0.15D, 0.15D, 0.15D, 0.0D);
            }
        }
    }

    private static void GrowthSapling(IBlockState SaplingState, World world, BlockPos SaplingPos){
        for (int i = 0; i < 4; i++) {
            IGrowable GrowableSapling = (IGrowable) SaplingState.getBlock();
            SaplingState = world.getBlockState(SaplingPos);
            if (SaplingState.getBlock() instanceof BlockSapling)
            {
                if (GrowableSapling.canGrow(world, SaplingPos, SaplingState, false))
                {
                    GrowableSapling.grow(world, world.rand, SaplingPos, SaplingState);
                    ((net.minecraft.world.WorldServer) world).spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, false, SaplingPos.getX() + 0.5D, SaplingPos.getY() + 1, SaplingPos.getZ() + 0.5D, 2, 0.15D, 0.15D, 0.15D, 0.0D);
                }
            }
        }
    }

    private static void GrowthStem(IBlockState StemState, World world, BlockPos StemPos){
        for (int i = 0; i < 8; i++) {
            IGrowable GrowableStem = (IGrowable) StemState.getBlock();
            StemState  = world.getBlockState(StemPos);
            if (StemState.getBlock() instanceof BlockStem)
            {
                if (GrowableStem.canGrow(world, StemPos, StemState, false))
                {
                    GrowableStem.grow(world, world.rand, StemPos, StemState);
                    ((net.minecraft.world.WorldServer) world).spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, false, StemPos.getX() + 0.5D, StemPos.getY() + 1, StemPos.getZ() + 0.5D, 2, 0.15D, 0.15D, 0.15D, 0.0D);
                }
            }
        }
    }
}
