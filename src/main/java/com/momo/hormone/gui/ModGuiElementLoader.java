package com.momo.hormone.gui;

import com.momo.hormone.MoMoFramework;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import javax.annotation.Nullable;

//todo
//https://fmltutor.ustc-zzzz.net/3.4.3-GUI%E7%95%8C%E9%9D%A2%E4%B8%AD%E7%9A%84%E4%BA%A4%E4%BA%92.html
public class ModGuiElementLoader implements IGuiHandler {

    public static final int GUI_DEMO = 1;
    public static final int GUI_RESEARCH = 2;

    public ModGuiElementLoader()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(MoMoFramework.instance, this);
    }

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID)
        {
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID)
        {
            default:
                return null;
        }
    }
}
