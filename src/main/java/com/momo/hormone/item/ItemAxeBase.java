package com.momo.hormone.item;

import com.momo.hormone.init.ModCreativeTab;
import com.momo.hormone.IdlFramework;
import com.momo.hormone.util.CommonFunctions;
import com.momo.hormone.util.IDLSkillNBT;
import com.momo.hormone.util.IHasModel;
import com.momo.hormone.util.NBTStrDef.IDLNBTDef;
import com.momo.hormone.util.NBTStrDef.IDLNBTUtil;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemAxeBase extends ItemAxe implements IHasModel {
	private boolean overrideRarity = false;
	private EnumRarity enumRarity = EnumRarity.COMMON;
	protected boolean showGuaSocketDesc = false;
	protected boolean shiftToShowDesc = false;
	protected boolean use_flavor = false;
	protected boolean useable = false;
	private boolean isRangedWeapon = false;
	protected boolean logNBT = false;
	protected boolean glitters = false;

	//for accessing the private value
	protected ToolMaterial toolMaterial;

	public ItemAxeBase(String name, ToolMaterial material)
	{
		super(material, 8.0F, -2.8F);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.TOOLS);
		toolMaterial = material;
		ModItems.ITEMS.add(this);

		InitItem();
	}

	public ItemAxeBase setRarity(EnumRarity enumRarity)
	{
		overrideRarity = true;
		this.enumRarity = enumRarity;
		return this;
	}

	public EnumRarity getRarity(ItemStack stack)
	{
		if (overrideRarity)
		{
			return enumRarity;
		}else {
			return super.getRarity(stack);
		}
	}

	public void InitItem()
	{
		if (this instanceof IGuaEnhance)
		{
			showGuaSocketDesc = true;
		}
	}

	public String GetStringForThisByKey(String key)
	{
		return CommonFunctions.GetStringLocalTranslated(getUnlocalizedName() + key);
	}

	public String GetBasicDesc()
	{
		return CommonFunctions.GetStringLocalTranslated(getUnlocalizedName() + IDLNBTDef.DESC_COMMON);
	}

	@Override
	public void onUsingTick(ItemStack stack, EntityLivingBase living, int count) {
		//Particle;
		super.onUsingTick(stack, living, count);
		//Idealland.LogWarning(String.format("base onUsingTick %s",count));

		if (living.world.isRemote)
		{
			clientUseTick(stack, living, getMaxItemUseDuration(stack) - count);
		}
		else
		{
			serverUseTick(stack, living, getMaxItemUseDuration(stack) - count);
		}
	}

	public void clientUseTick(ItemStack stack, EntityLivingBase living, int count)
	{

	}

	public void serverUseTick(ItemStack stack, EntityLivingBase living, int count)
	{

	}

	@Override
	public void registerModels() 
	{
		IdlFramework.proxy.registerItemRenderer(this, 0, "inventory");
	}
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {

		IDLSkillNBT.addInformation(stack,world,tooltip,flag,shiftToShowDesc, showGuaSocketDesc, use_flavor,
				getMainDesc(stack,world,tooltip,flag));

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

	//for accessing private values
	protected float getBaseAttackDamage()
	{
		return 3.0F + toolMaterial.getAttackDamage();
	}
}
