package oresAboveDiamonds.OresMod.world;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ChanceRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import oresAboveDiamonds.OresMod.config.ConfigValues;
import oresAboveDiamonds.OresMod.lists.BlockList;

public class OreGeneration 
{	
	public static void setupOreGeneration() 
	{
		
		double d = ConfigValues.amethyst_chance.get();
		float amethyst_chance = (float)d;
		
		double d2 = ConfigValues.black_opal_chance.get();
		float black_opal_chance = (float)d2;
		
		final EndOreFeature END_OREGEN = new EndOreFeature(null);
		
		if(ConfigValues.overworld_ores.get() == true) {
			for(Biome biome : ForgeRegistries.BIOMES) 
			{

			
					biome.addFeature(Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.amethyst_ore.getDefaultState(), ConfigValues.amethyst_max_vein_size.get())).func_227228_a_( Placement.CHANCE_RANGE.func_227446_a_(new ChanceRangeConfig(amethyst_chance, 0, 0, 16))));

			
				
					biome.addFeature(Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.black_opal_ore.getDefaultState(), ConfigValues.black_opal_max_vein_size.get())).func_227228_a_( Placement.CHANCE_RANGE.func_227446_a_(new ChanceRangeConfig(black_opal_chance, 0, 0, 16))));
			}

		}
		
		if (ConfigValues.nether_ores.get() == true) {
			Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(
					new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlockList.nether_amethyst_ore.getDefaultState(),  (int) Math.min((ConfigValues.amethyst_max_vein_size.get()*ConfigValues.nether_vein_multiplier.get()), 64))).func_227228_a_( Placement.CHANCE_RANGE.func_227446_a_(new ChanceRangeConfig((float)(amethyst_chance*ConfigValues.nether_chance_multiplier.get()), 0, 0, 128))));
	
			Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(
					new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlockList.nether_black_opal_ore.getDefaultState(),  (int) Math.min((ConfigValues.black_opal_max_vein_size.get()*ConfigValues.nether_vein_multiplier.get()), 64))).func_227228_a_( Placement.CHANCE_RANGE.func_227446_a_(new ChanceRangeConfig((float)(black_opal_chance*ConfigValues.nether_chance_multiplier.get()), 0, 0, 128))));
			
		}
		if (ConfigValues.end_ores.get() == true) {
			ForgeRegistries.BIOMES.getValues().stream()
		      .filter(biome -> (biome.getCategory() == Biome.Category.THEEND))
		      .forEach(biome -> {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, END_OREGEN.func_225566_b_(
					new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.end_amethyst_ore.getDefaultState(), (int) Math.min((ConfigValues.amethyst_max_vein_size.get()*ConfigValues.end_vein_multiplier.get()), 64))).func_227228_a_( Placement.CHANCE_RANGE.func_227446_a_(new ChanceRangeConfig((float)(amethyst_chance*ConfigValues.end_chance_multiplier.get()), 0, 0, 75))));
	
			
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, END_OREGEN.func_225566_b_(
					new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.end_black_opal_ore.getDefaultState(), (int) Math.min((ConfigValues.black_opal_max_vein_size.get()*ConfigValues.end_vein_multiplier.get()), 64))).func_227228_a_( Placement.CHANCE_RANGE.func_227446_a_(new ChanceRangeConfig((float) (black_opal_chance*ConfigValues.end_chance_multiplier.get()), 0, 0, 75))));
		      });
		}
	}
}
