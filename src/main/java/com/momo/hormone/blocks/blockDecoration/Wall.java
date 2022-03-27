package com.momo.hormone.blocks.blockDecoration;

import com.momo.hormone.MoMoFramework;
import com.momo.hormone.blocks.ModBlocks;
import com.momo.hormone.item.ModItems;
import com.momo.hormone.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class Wall extends BlockWall implements IHasModel {

    public Wall(String name, Block modelBlock) {
        super(modelBlock);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        MoMoFramework.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        items.add(new ItemStack(this, 1, 0));
    }
}

