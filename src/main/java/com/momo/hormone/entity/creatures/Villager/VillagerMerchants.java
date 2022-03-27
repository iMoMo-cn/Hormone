package com.momo.hormone.entity.creatures.villager;

import com.momo.hormone.item.ModItems;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;

import static com.momo.hormone.entity.creatures.villager.ModVillagers.HORMONE_MERCHANT_CARRER;

public class VillagerMerchants {

    public static void addMerchants()
    {
        //add trade
        HORMONE_MERCHANT_CARRER.addTrade(1,
                new MerchantHelper.EmeraldForItem(Items.DYE, 15, new EntityVillager.PriceInfo(16, 22)),
                new MerchantHelper.EmeraldForItem(ModItems.HORMONE_EMPTY, new EntityVillager.PriceInfo(4,6))
        );
        HORMONE_MERCHANT_CARRER.addTrade(2,
                new MerchantHelper.ItemForEmerald(ModItems.HORMONE_WHEAT, new EntityVillager.PriceInfo(6,9)),
                new MerchantHelper.ItemForEmerald(ModItems.HORMONE_SEEDS, new EntityVillager.PriceInfo(6,9))
        );
        HORMONE_MERCHANT_CARRER.addTrade(3,
                new MerchantHelper.ItemForEmerald(ModItems.HORMONE_CARROT, new EntityVillager.PriceInfo(6,9)),
                new MerchantHelper.EmeraldForItem(ModItems.HORMONE_BONEMEAL, new EntityVillager.PriceInfo(2,3))
        );
        HORMONE_MERCHANT_CARRER.addTrade(4,
                new MerchantHelper.ItemForEmerald(ModItems.HORMONE_BONE, new EntityVillager.PriceInfo(6,9)),
                new MerchantHelper.ItemForEmerald(ModItems.HORMONE_FISH, new EntityVillager.PriceInfo(6,9))
        );
    }

}
