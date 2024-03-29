package com.momo.hormone.init;

import com.momo.hormone.MoMoFramework;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModBiomeInit {

    public static void registerBiomes()
    {
        //initBiome(BIOME_ONE, "biome_one", BiomeManager.BiomeType.WARM, Type.HILLS, Type.DENSE);
    }

    public static Biome initBiome(Biome biome, String name, BiomeManager.BiomeType biomeType, Type... type)
    {
        biome.setRegistryName(name);
        ForgeRegistries.BIOMES.register(biome);
        MoMoFramework.LogWarning("Biome registered:%s", name);
        BiomeDictionary.addTypes(biome, type);
        BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 10));
        BiomeManager.addSpawnBiome(biome);
        return biome;
    }

}
