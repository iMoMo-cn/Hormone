package com.momo.hormone.entity.creatures.villager;

import com.momo.hormone.item.ModItems;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;

import static com.momo.hormone.entity.creatures.villager.ModVillagers.*;

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

        SEED_BAG_MERCHANT_CARRER.addTrade(1,
                new MerchantHelper.EmeraldForItem(Items.DYE, 15, new EntityVillager.PriceInfo(16, 22)),
                new MerchantHelper.EmeraldForItem(ModItems.HORMONE_EMPTY, new EntityVillager.PriceInfo(4,6))
        );
        SEED_BAG_MERCHANT_CARRER.addTrade(2,
                new MerchantHelper.ItemForEmerald(ModItems.HORMONE_MUSHROOM_BROWN, new EntityVillager.PriceInfo(6,9)),
                new MerchantHelper.ItemForEmerald(ModItems.HORMONE_MUSHROOM_RED, new EntityVillager.PriceInfo(6,9))
        );
        SEED_BAG_MERCHANT_CARRER.addTrade(3,
                new MerchantHelper.EmeraldForItem(ModItems.HORMONE_MUSHROOM, new EntityVillager.PriceInfo(6,9)),
                new MerchantHelper.EmeraldForItem(ModItems.HORMONE_GRASS, new EntityVillager.PriceInfo(6,9))
        );
        SEED_BAG_MERCHANT_CARRER.addTrade(4,
                new MerchantHelper.ItemForEmerald(ModItems.HORMONE_GOLD_CARROT, new EntityVillager.PriceInfo(11,15))
        );

        BARBECUE_MASTER_CARRER.addTrade(1,
                new MerchantHelper.EmeraldForItem(Items.COAL, 0, new EntityVillager.PriceInfo(16, 24))
        );
        BARBECUE_MASTER_CARRER.addTrade(2,
                new MerchantHelper.EmeraldForItem(ModItems.DICED_MEAT, new EntityVillager.PriceInfo(16,24)),
                new MerchantHelper.EmeraldForItem(ModItems.DICED_VEGETABLE, new EntityVillager.PriceInfo(28,39)),
                new MerchantHelper.ItemForEmerald(ModItems.MUSHROOM_BARBECUE, new EntityVillager.PriceInfo(2,5))
        );
        BARBECUE_MASTER_CARRER.addTrade(3,
                new MerchantHelper.ItemForEmerald(ModItems.VEGETABLE_BARBECUE, new EntityVillager.PriceInfo(2,5))
        );
        BARBECUE_MASTER_CARRER.addTrade(4,
                new MerchantHelper.ItemForEmerald(ModItems.MEAT_BARBECUE, new EntityVillager.PriceInfo(2,5))
        );
        BARBECUE_MASTER_CARRER.addTrade(5,
                new MerchantHelper.ItemForEmerald(ModItems.CLASSICAL_BARBECUE, new EntityVillager.PriceInfo(4,7))
        );
    }

}
