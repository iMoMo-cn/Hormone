package com.momo.hormone.events.hormone.plant;

import com.momo.hormone.MoMoFramework;
import com.momo.hormone.blocks.ModBlocks;
import com.momo.hormone.item.ModItems;
import net.minecraft.block.Block;
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
public class WildHormone {
    @SubscribeEvent
    public static void growWildCrops(PlayerInteractEvent.RightClickBlock evt) {
        World world = evt.getWorld();
        ItemStack itemstack = evt.getEntityPlayer().getHeldItem(evt.getHand());
        BlockPos pos = evt.getPos();
        EntityPlayer player = evt.getEntityPlayer();
        IBlockState state = world.getBlockState(pos);

        Block block = state.getBlock();
        boolean isCrops = (block == Blocks.POTATOES || block == Blocks.CARROTS || block == Blocks.BEETROOTS || block == Blocks.WHEAT);

        if (itemstack.getItem() == ModItems.HORMONE_WILD && isCrops) {
            player.swingArm(evt.getHand());

            if (!world.isRemote) {
                if (!player.capabilities.isCreativeMode) {
                    itemstack.shrink(1);
                }

                Block wildCrop;

                if(block == Blocks.POTATOES) { wildCrop = ModBlocks.WILD_POTATO; }
                else if(block == Blocks.CARROTS){ wildCrop = ModBlocks.WILD_CARROT; }
                else if(block == Blocks.BEETROOTS){ wildCrop = ModBlocks.WILD_BEET; }
                else { wildCrop = ModBlocks.WILD_WHEAT; }

                world.setBlockState(pos, wildCrop.getDefaultState(), 3);
                ((net.minecraft.world.WorldServer) world).spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, false, pos.getX() + 0.5D, pos.getY() + 1.0D, pos.getZ() + 0.5D, 5, 0.15D, 0.15D, 0.15D, 0.0D);

                if(world.getBlockState(pos.down()).getBlock() == Blocks.FARMLAND)
                {
                    world.setBlockState(pos.down(), Blocks.GRASS.getDefaultState(), 3);
                }
            }
        }
    }
}
