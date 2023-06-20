package com.momo.hormone.item.tools;


import com.momo.hormone.MoMoFramework;
import com.momo.hormone.init.ModCreativeTab;
import com.momo.hormone.item.ModItems;
import com.momo.hormone.util.CommonFunctions;
import com.momo.hormone.util.IDLSkillNBT;
import com.momo.hormone.util.IHasModel;
import com.momo.hormone.util.NBTStrDef.IDLNBTDef;
import com.momo.hormone.util.NBTStrDef.IDLNBTUtil;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class Shears extends ItemShears implements IHasModel
{
    protected boolean shiftToShowDesc = false;
    protected boolean use_flavor = false;
    protected boolean logNBT = false;

    public Shears() {
        super();

        setUnlocalizedName("shears");
        setRegistryName("shears");
        ModItems.ITEMS.add(this);
        setCreativeTab(ModCreativeTab.FARMING);

        this.setMaxDamage(-1);
        this.setContainerItem(this);
    }

    @Override
    public void registerModels()
    {
        MoMoFramework.proxy.registerItemRenderer(this, 0, "inventory");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {

        IDLSkillNBT.addInformation(stack, world, tooltip, flag, shiftToShowDesc, use_flavor, getMainDesc(stack, world, tooltip, flag));

        if (logNBT)
        {
            tooltip.add(IDLNBTUtil.getNBT(stack).toString());
        }
    }

    @SideOnly(Side.CLIENT)
    public String descGetKey(ItemStack stack, World world, boolean showFlavor)
    {
        return showFlavor ? (stack.getUnlocalizedName() + IDLNBTDef.FLAVOR_KEY)
                : (stack.getUnlocalizedName() + IDLNBTDef.DESC_COMMON);
    }

    @SideOnly(Side.CLIENT)
    public String getMainDesc(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag)
    {
        if (CommonFunctions.isShiftPressed() || !shiftToShowDesc)
        {
            String key = descGetKey(stack,world,false);
            if (I18n.hasKey(key))
            {
                return I18n.format(key);
            }
            else
            {
                return "";
            }
        }

        if (!CommonFunctions.isShiftPressed() && use_flavor)
        {
            String key = descGetKey(stack,world,true);
            if (I18n.hasKey(key))
            {
                return I18n.format(key);
            }
            else
            {
                return "";
            }
        }
        return "";
    }

    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) { return false; }

    public int getItemEnchantability()
    {
        return 0;
    }
}