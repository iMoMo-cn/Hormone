package com.momo.hormone.entity.creatures.Villager;

import com.momo.hormone.IdlFramework;
import com.momo.hormone.item.ModItems;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Random;

@Mod.EventBusSubscriber
public class VillagerRegistryHandler {
    public static final VillagerRegistry.VillagerProfession HORMONE_MERCHANT =
            new VillagerRegistry.VillagerProfession(IdlFramework.MODID + "hormone_merchant",
                    IdlFramework.MODID + ":textures/entity/villager/hormone_merchant.png",
                    IdlFramework.MODID + ":textures/entity/zombie_villager/zombie_hormone_merchant.png" );
    public static final VillagerRegistry.VillagerCareer HORMONE_MERCHANT_CAREER =
            new VillagerRegistry.VillagerCareer(HORMONE_MERCHANT, IdlFramework.MODID + ".hormoneMerchant");

    @SubscribeEvent
    public static void onRegistry(RegistryEvent.Register<VillagerRegistry.VillagerProfession>event){
        IForgeRegistry<VillagerRegistry.VillagerProfession>registry = event.getRegistry();

        //hormone_merchant add trade
        HORMONE_MERCHANT_CAREER.addTrade(1,
                new BonemealToEmerald(
                        new EntityVillager.PriceInfo(16,22)),
                new EntityVillager.EmeraldForItems(ModItems.HORMONE_EMPTY,
                        new EntityVillager.PriceInfo(4,6))
        );
        HORMONE_MERCHANT_CAREER.addTrade(2,
                new EntityVillager.ListItemForEmeralds(ModItems.HORMONE_WHEAT,
                        new EntityVillager.PriceInfo(6,9)),
                new EntityVillager.ListItemForEmeralds(ModItems.HORMONE_SEEDS,
                        new EntityVillager.PriceInfo(6,9))
                );
        HORMONE_MERCHANT_CAREER.addTrade(3,
                new EntityVillager.ListItemForEmeralds(ModItems.HORMONE_CARROT,
                        new EntityVillager.PriceInfo(6,9)),
                new EntityVillager.EmeraldForItems(ModItems.HORMONE_BONEMEAL,
                        new EntityVillager.PriceInfo(2,3))
                );
        HORMONE_MERCHANT_CAREER.addTrade(4,
                new EntityVillager.ListItemForEmeralds(ModItems.HORMONE_BONE,
                        new EntityVillager.PriceInfo(6,9)),
                new EntityVillager.ListItemForEmeralds(ModItems.HORMONE_FISH,
                        new EntityVillager.PriceInfo(6,9))
        );
        registry.register(HORMONE_MERCHANT);
    }

    private static class BonemealToEmerald implements EntityVillager.ITradeList
    {
        private final EntityVillager.PriceInfo priceInfo;

        private BonemealToEmerald(EntityVillager.PriceInfo EmeraldInfo){
            this.priceInfo = EmeraldInfo;
        }

        @Override
        public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random)
        {
            int bonemealAmount = this.priceInfo.getPrice(random);
            recipeList.add(new MerchantRecipe(
                    new ItemStack(Items.DYE, bonemealAmount ,15),
                    new ItemStack(Items.EMERALD)));
        }
    }
}
