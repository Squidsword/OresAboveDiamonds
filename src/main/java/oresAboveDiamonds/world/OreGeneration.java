package oresAboveDiamonds.world;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ChanceRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.lists.BlockList;

public class OreGeneration 
{	
	public static void setupOreGeneration() 
	{
		
		double d = OADConfig.amethyst_chance.get();
		float amethyst_chance = (float)d;
		
		double d2 = OADConfig.black_opal_chance.get();
		float black_opal_chance = (float)d2;
		
		final EndOreFeature END_OREGEN = new EndOreFeature(null);
		if(OADConfig.overworld_ores.get() == true) {
			for(Biome biome : ForgeRegistries.BIOMES) 
			{

			
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE,(
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.amethyst_ore.getDefaultState(), OADConfig.amethyst_max_vein_size.get())), Placement.CHANCE_RANGE, (new ChanceRangeConfig(amethyst_chance, 0, 0, 16))));

			
				
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE,(
							new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.black_opal_ore.getDefaultState(), OADConfig.black_opal_max_vein_size.get())), Placement.CHANCE_RANGE, (new ChanceRangeConfig(black_opal_chance, 0, 0, 16))));
			}

		}
		if (OADConfig.nether_ores.get() == true) {
			Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE,(
					new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlockList.nether_amethyst_ore.getDefaultState(),  (int) Math.min((OADConfig.amethyst_max_vein_size.get()*OADConfig.nether_vein_multiplier.get()), 64))), Placement.CHANCE_RANGE, (new ChanceRangeConfig((float)(amethyst_chance*OADConfig.nether_chance_multiplier.get()), 0, 0, 128))));
	
			Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE,(
					new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlockList.nether_black_opal_ore.getDefaultState(),  (int) Math.min((OADConfig.black_opal_max_vein_size.get()*OADConfig.nether_vein_multiplier.get()), 64))), Placement.CHANCE_RANGE, (new ChanceRangeConfig((float)(black_opal_chance*OADConfig.nether_chance_multiplier.get()), 0, 0, 128))));
			
		}
		if (OADConfig.end_ores.get() == true) {
			ForgeRegistries.BIOMES.getValues().stream()
		      .filter(biome -> (biome.getCategory() == Biome.Category.THEEND))
		      .forEach(biome -> {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(END_OREGEN,(
					new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.end_amethyst_ore.getDefaultState(), (int) Math.min((OADConfig.amethyst_max_vein_size.get()*OADConfig.end_vein_multiplier.get()), 64))), Placement.CHANCE_RANGE, (new ChanceRangeConfig((float)(amethyst_chance*OADConfig.end_chance_multiplier.get()), 0, 0, 75))));
	
			
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(END_OREGEN,(
					new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.end_black_opal_ore.getDefaultState(), (int) Math.min((OADConfig.black_opal_max_vein_size.get()*OADConfig.end_vein_multiplier.get()), 64))), Placement.CHANCE_RANGE, (new ChanceRangeConfig((float) (black_opal_chance*OADConfig.end_chance_multiplier.get()), 0, 0, 75))));
		      });
		}
	}
}
