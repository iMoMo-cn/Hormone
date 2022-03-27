package com.momo.hormone.entity.creatures.villager;

import com.momo.hormone.MoMoFramework;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

import java.util.ArrayList;
import java.util.List;


public class ModVillagers {

    public static final List<VillagerRegistry.VillagerProfession> VILLAGERS = new ArrayList<VillagerRegistry.VillagerProfession>();
    //example

//    public static final VillagerRegistry.VillagerProfession VILLAGER_NAME = new ProfessionBase("name");
//    public static final VillagerRegistry.VillagerCareer VILLAGER_NAME_CAREER = new CareerBase(VILLAGER_NAME,"name");
    public static final VillagerRegistry.VillagerProfession HORMONE_MERCHANT = new ProfessionBase("hormone_merchant");
    public static final VillagerRegistry.VillagerCareer HORMONE_MERCHANT_CARRER = new CareerBase(HORMONE_MERCHANT, "HormoneMerchant");






    public static class ProfessionBase extends VillagerRegistry.VillagerProfession{

        public ProfessionBase(String name)
        {
            super(MoMoFramework.MODID + name,
                    MoMoFramework.MODID + ":textures/entity/villager/" + name + ".png",
                    MoMoFramework.MODID + ":textures/entity/zombie_villager/zombie_" + name + ".png");

            VILLAGERS.add(this);
        }
    }

    public static class CareerBase extends VillagerRegistry.VillagerCareer{

        public CareerBase(VillagerRegistry.VillagerProfession parent, String name) {
            super(parent, MoMoFramework.MODID + "." + name);
        }
    }
}
