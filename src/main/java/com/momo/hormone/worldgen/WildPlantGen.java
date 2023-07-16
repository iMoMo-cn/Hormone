package com.momo.hormone.worldgen;

import com.momo.hormone.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WildPlantGen implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        int x = chunkX * 16 + random.nextInt(8);
        int z = chunkZ * 16 + random.nextInt(8);

        final BlockPos blockPos = world.getHeight(new BlockPos(x, 0, z));
        final BlockPos chunkPos = new BlockPos(x, 0, z);
        final Biome biome  = world.getChunkFromBlockCoords(chunkPos).getBiome(chunkPos, world.getBiomeProvider());

        if(world.getWorldType() != WorldType.FLAT && world.getWorldType() != WorldType.DEBUG_ALL_BLOCK_STATES)
        {
            if(BiomeDictionary.hasType(biome, BiomeDictionary.Type.PLAINS)){
                switch(random.nextInt(4)){
                    case 0:
                        generatePlant(ModBlocks.WILD_POTATO, world, blockPos, random);
                        break;
                    case 1:
                        generatePlant(ModBlocks.WILD_CARROT, world, blockPos, random);
                        break;
                    case 2:
                        generatePlant(ModBlocks.WILD_BEET, world, blockPos, random);
                        break;
                    case 3:
                        generatePlant(ModBlocks.WILD_WHEAT, world, blockPos, random);
                        break;
                }
            }

            if(BiomeDictionary.hasType(biome, BiomeDictionary.Type.FOREST))
            {
                switch(random.nextInt(2)) {
                    case 0:
                        generatePlant(ModBlocks.WILD_WHEAT, world, blockPos, random);
                        break;
                    case 1:
                        generatePlant(ModBlocks.WILD_BEET, world, blockPos, random);
                        break;
                }
            }
        }
    }

    private void generatePlant(Block block, World world, BlockPos pos, Random random) {

        if (random.nextFloat() < 0.1F) {
            int posX = (pos.getX() + random.nextInt(16));
            int posY = (pos.getY());
            int posZ = (pos.getZ() + random.nextInt(16));

            final BlockPos newPos = new BlockPos(posX, posY, posZ);


            if (block.canPlaceBlockAt(world, newPos)) {
                world.setBlockState(newPos, block.getDefaultState(), 2);
            }

            for(int i = 0; i < 4; i++){
                final BlockPos newPos1 = new BlockPos(posX + random.nextInt(5) + 1, posY, posZ + random.nextInt(5) + 1);

                if (block.canPlaceBlockAt(world, newPos1)) {
                    world.setBlockState(newPos1, block.getDefaultState(), 2);
                }
            }
        }
    }
}
