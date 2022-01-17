package com.momo.hormone.events.RottenHormone;

import com.momo.hormone.IdlFramework;
import com.momo.hormone.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockNetherWart;
import net.minecraft.block.properties.PropertyInteger;
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
public class NetherWartGrowth {
    public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 3);

    @SubscribeEvent
    public static void onUse(PlayerInteractEvent.RightClickBlock evt) {
        World world = evt.getWorld();
        ItemStack itemstack = evt.getEntityPlayer().getHeldItem(evt.getHand());
        BlockPos pos = evt.getPos();
        EntityPlayer player = evt.getEntityPlayer();
        IBlockState state = world.getBlockState(pos);
        Block block = state.getBlock();

        if (itemstack.getItem() == ModItems.HORMONE_ROTTEN && !world.isRemote
                && block instanceof BlockNetherWart) {
            player.swingArm(evt.getHand());
            if (!player.capabilities.isCreativeMode) { itemstack.shrink(1); }
            for (int x0 = -1; x0 <= 1; x0++) {
                for (int z0 = -1; z0 <= 1; z0++) {
                    int x = pos.getX() + x0;
                    int y = pos.getY();
                    int z = pos.getZ() + z0;

                    BlockPos WartPos = new BlockPos(x, y, z);
                    IBlockState WartState = world.getBlockState(WartPos);
                    Block WartBlock =WartState.getBlock();

                    if (WartBlock instanceof BlockNetherWart) {
                        WartGrowth(WartBlock, WartState, WartPos, world);
                    }
                }
            }
        }
    }

    private static void WartGrowth(Block WartBlock, IBlockState WartState, BlockPos WartPos, World world) {
        int age = WartBlock.getMetaFromState(WartState);
        if (age < 3) {
            IBlockState newState = WartState.withProperty(AGE, Integer.valueOf(3));
            world.setBlockState(WartPos, newState, 2);
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(world, WartPos, WartState, newState);
            ((net.minecraft.world.WorldServer) world).spawnParticle(EnumParticleTypes.SPELL_WITCH, false, WartPos.getX() + 0.5D, WartPos.getY() + 1.0D, WartPos.getZ() + 0.5D, 5, 0.15D, 0.15D, 0.15D, 0.0D);
        }
    }
}
