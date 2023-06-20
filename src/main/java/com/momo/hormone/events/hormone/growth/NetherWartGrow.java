package com.momo.hormone.events.hormone.growth;

import com.momo.hormone.MoMoFramework;
import com.momo.hormone.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockNetherWart;
import net.minecraft.block.properties.PropertyInteger;
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
public class NetherWartGrow {

    @SubscribeEvent
    public static void netherWartGrow(PlayerInteractEvent.RightClickBlock evt) {
        World world = evt.getWorld();
        ItemStack itemstack = evt.getEntityPlayer().getHeldItem(evt.getHand());
        BlockPos pos = evt.getPos();
        EntityPlayer player = evt.getEntityPlayer();
        IBlockState state = world.getBlockState(pos);
        Block block = state.getBlock();

        if (itemstack.getItem() == ModItems.HORMONE_ROTTEN  && block == Blocks.NETHER_WART)
        {
            if(state.getValue(BlockNetherWart.AGE) < 3)
            {
                player.swingArm(evt.getHand());

                if (!player.capabilities.isCreativeMode)
                {
                    itemstack.shrink(1);
                }

                for (int x = -1; x <= 1; x++) {
                    for (int z = -1; z <= 1; z++)
                    {
                        BlockPos posWart = pos.add(x, 0, z);
                        IBlockState stateWart = world.getBlockState(posWart);
                        Block blockWart =stateWart.getBlock();

                        if (blockWart instanceof BlockNetherWart) {
                            WartGrowth(block, stateWart, posWart, world);
                        }
                    }
                }
            }
        }
    }

    private static void WartGrowth(Block block, IBlockState state, BlockPos pos, World world)
    {
        int age = block.getMetaFromState(state);

        if (age < 3)
        {
            IBlockState newState = state.withProperty(BlockNetherWart.AGE, 3);

            if(!world.isRemote)
            {
                world.setBlockState(pos, newState, 2);
                ((net.minecraft.world.WorldServer) world).spawnParticle(EnumParticleTypes.SPELL_WITCH, false, pos.getX() + 0.5D, pos.getY() + 0.8D, pos.getZ() + 0.5D, 5, 0.15D, 0.15D, 0.15D, 0.0D);
            }
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(world, pos, state, newState);
        }
    }
}
