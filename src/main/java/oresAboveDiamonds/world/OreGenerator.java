package oresAboveDiamonds.world;

import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.event.world.ChunkDataEvent;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import oresAboveDiamonds.config.OADConfig;


import java.util.ArrayDeque;
import java.util.Random;

public class OreGenerator implements IWorldGenerator {

    public static final String RETRO_NAME = "MyModOreGen";
    public static OreGenerator instance = new OreGenerator();

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        generateWorld(random, chunkX, chunkZ, world, true);
    }

	public int roll(double chance) {
		
		Random random = new Random();
		double roll = random.nextDouble();
		
		if(roll*2 < chance) {
			//System.out.println("As the roll " + roll + " was 2x lower than the chance " + chance + ", the ore will spawn twice.");
			return 2;
		} else if(roll < chance) {
			//System.out.println("As the roll " + roll + " was lower than the chance " + chance + ", the ore will spawn.");
			return 1;
		} else {
			//System.out.println("As the roll " + roll + " was higher than the chance " + chance + ", the ore will not spawn.");
			return 0;
		}
		
	}
    
    public void generateWorld(Random random, int chunkX, int chunkZ, World world, boolean newGen) {
        if (!newGen && !OADConfig.ab_enable_retrogen) {
            return;
        }

        if (world.provider.getDimension() == DimensionType.OVERWORLD.getId()) {
            if (OADConfig.abg_enable_overworld_ores) {
                addOreSpawn(oresAboveDiamonds.init.ModBlocks.AMETHYST_ORE, (byte) OreType.ORE_OVERWORLD.ordinal(), Blocks.STONE, world, random, chunkX * 16, chunkZ * 16,
                       OADConfig.ae_min_amethyst_vein_size, OADConfig.af_max_amethyst_vein_size, roll(OADConfig.ac_amethyst_chance), OADConfig.ai_amethyst_min_y_value, OADConfig.aj_amethyst_max_y_value);
            }
        } else if (world.provider.getDimension() == DimensionType.NETHER.getId()) {
            if (OADConfig.aaa_netherconfig.aa_enable_nether_ores) {
                addOreSpawn(oresAboveDiamonds.init.ModBlocks.NETHER_AMETHYST_ORE, (byte) OreType.ORE_NETHER.ordinal(), Blocks.NETHERRACK, world, random, chunkX * 16, chunkZ * 16,
                       (int)(OADConfig.ae_min_amethyst_vein_size * OADConfig.aaa_netherconfig.ac_nether_amethyst_vein_multiplier), (int)(OADConfig.af_max_amethyst_vein_size * OADConfig.aaa_netherconfig.ac_nether_amethyst_vein_multiplier), roll(OADConfig.ac_amethyst_chance * OADConfig.aaa_netherconfig.ab_nether_amethyst_chance_multiplier), OADConfig.aaa_netherconfig.af_nether_amethyst_min_y_value, OADConfig.aaa_netherconfig.ag_nether_amethyst_max_y_value);
            }
        } else if (world.provider.getDimension() == DimensionType.THE_END.getId()) {
            if (OADConfig.aab_endconfig.aaaa_enable_end_ores) {
                addOreSpawn(oresAboveDiamonds.init.ModBlocks.END_AMETHYST_ORE, (byte) OreType.ORE_END.ordinal(), Blocks.END_STONE, world, random, chunkX * 16, chunkZ * 16,
                       (int)(OADConfig.ae_min_amethyst_vein_size * OADConfig.aab_endconfig.ac_end_amethyst_vein_multiplier), (int)(OADConfig.af_max_amethyst_vein_size * OADConfig.aab_endconfig.ac_end_amethyst_vein_multiplier), roll(OADConfig.ac_amethyst_chance * OADConfig.aab_endconfig.ab_end_amethyst_chance_multiplier), OADConfig.aab_endconfig.af_end_amethyst_min_y_value, OADConfig.aab_endconfig.ag_end_amethyst_max_y_value);
            }
        }
        
        if (world.provider.getDimension() == DimensionType.OVERWORLD.getId()) {
            if (OADConfig.abg_enable_overworld_ores) {
                addOreSpawn(oresAboveDiamonds.init.ModBlocks.BLACK_OPAL_ORE, (byte) OreType.ORE_OVERWORLD.ordinal(), Blocks.STONE, world, random, chunkX * 16, chunkZ * 16,
                    OADConfig.ag_min_black_opal_vein_size, OADConfig.ah_max_black_opal_vein_size, roll(OADConfig.ad_black_opal_chance), OADConfig.ak_black_opal_min_y_value, OADConfig.al_black_opal_max_y_value);
            }
        } else if (world.provider.getDimension() == DimensionType.NETHER.getId()) {
            if (OADConfig.aaa_netherconfig.aa_enable_nether_ores) {
                addOreSpawn(oresAboveDiamonds.init.ModBlocks.NETHER_BLACK_OPAL_ORE, (byte) OreType.ORE_NETHER.ordinal(), Blocks.NETHERRACK, world, random, chunkX * 16, chunkZ * 16,
                    (int)(OADConfig.ag_min_black_opal_vein_size * OADConfig.aaa_netherconfig.ae_nether_black_opal_vein_multiplier), (int)(OADConfig.ah_max_black_opal_vein_size * OADConfig.aaa_netherconfig.ae_nether_black_opal_vein_multiplier), roll(OADConfig.ad_black_opal_chance * OADConfig.aaa_netherconfig.ad_nether_black_opal_chance_multiplier), OADConfig.aaa_netherconfig.ah_nether_black_opal_min_y_value, OADConfig.aaa_netherconfig.ai_nether_black_opal_max_y_value);
            }
        } else if (world.provider.getDimension() == DimensionType.THE_END.getId()) {
            if (OADConfig.aab_endconfig.aaaa_enable_end_ores) {
                addOreSpawn(oresAboveDiamonds.init.ModBlocks.END_BLACK_OPAL_ORE, (byte) OreType.ORE_END.ordinal(), Blocks.END_STONE, world, random, chunkX * 16, chunkZ * 16,
                	(int)(OADConfig.ag_min_black_opal_vein_size * OADConfig.aab_endconfig.ae_end_black_opal_vein_multiplier), (int)(OADConfig.ah_max_black_opal_vein_size * OADConfig.aab_endconfig.ae_end_black_opal_vein_multiplier), roll(OADConfig.ad_black_opal_chance * OADConfig.aab_endconfig.ad_end_black_opal_chance_multiplier), OADConfig.aab_endconfig.ah_end_black_opal_min_y_value, OADConfig.aab_endconfig.ai_end_black_opal_max_y_value);
            }
        }

        if (!newGen) {
            world.getChunkFromChunkCoords(chunkX, chunkZ).markDirty();
        }
    }

    public void addOreSpawn(Block block, byte blockMeta, Block targetBlock, World world, Random random, int blockXPos, int blockZPos, int minVeinSize, int maxVeinSize, int chancesToSpawn, int minY, int maxY) {
        @SuppressWarnings("deprecation")
		WorldGenMinable minable = new WorldGenMinable(block.getStateFromMeta(blockMeta), (minVeinSize + random.nextInt(maxVeinSize - minVeinSize + 1)), BlockMatcher.forBlock(targetBlock));
        for (int i = 0 ; i < chancesToSpawn ; i++) {
            int posX = blockXPos + random.nextInt(16);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZPos + random.nextInt(16);
            minable.generate(world, random, new BlockPos(posX, posY, posZ));
        }
    }

    @SubscribeEvent
    public void handleChunkSaveEvent(ChunkDataEvent.Save event) {
        NBTTagCompound genTag = event.getData().getCompoundTag(RETRO_NAME);
        if (!genTag.hasKey("generated")) {
            // If we did not have this key then this is a new chunk and we will have proper ores generated.
            // Otherwise we are saving a chunk for which ores are not yet generated.
            genTag.setBoolean("generated", true);
        }
        event.getData().setTag(RETRO_NAME, genTag);
    }

    @SubscribeEvent
    public void handleChunkLoadEvent(ChunkDataEvent.Load event) {
        int dim = event.getWorld().provider.getDimension();

        boolean regen = false;
        NBTTagCompound tag = (NBTTagCompound) event.getData().getTag(RETRO_NAME);
        ChunkPos coord = event.getChunk().getPos();

        if (tag != null) {
            boolean generated = OADConfig.ab_enable_retrogen && !tag.hasKey("generated");
            if (generated) {
            	System.out.println("Ores Above Diamonds: Retrogenning Chunk " + event.getChunk().getPos().toString());
                regen = true;
            }
        } else {
            regen = OADConfig.ab_enable_retrogen;
        }

        if (regen) {
            ArrayDeque<ChunkPos> chunks = WorldTickHandler.chunksToGen.get(dim);

            if (chunks == null) {
                WorldTickHandler.chunksToGen.put(dim, new ArrayDeque<>(128));
                chunks = WorldTickHandler.chunksToGen.get(dim);
            }
            if (chunks != null) {
                chunks.addLast(coord);
                WorldTickHandler.chunksToGen.put(dim, chunks);
            }
        }
    }



}