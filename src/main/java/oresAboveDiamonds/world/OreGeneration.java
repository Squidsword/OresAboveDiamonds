package oresAboveDiamonds.world;

import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ChanceRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.lists.BlockList;

public class OreGeneration 
{	
	
	public static OreFeatureConfig.FillerBlockType END_STONE = OreFeatureConfig.FillerBlockType.create("END_STONE", "end_stone", new BlockMatcher(Blocks.END_STONE));
	
	public static void setupOreGeneration() 
	{
		
		double d = OADConfig.amethyst_chance.get();
		float amethyst_chance = (float)d;
		
		double d2 = OADConfig.black_opal_chance.get();
		float black_opal_chance = (float)d2;
		
		//final EndOreFeature END_OREGEN = new EndOreFeature(null);
		
		if(OADConfig.overworld_ores.get() == true) {
			for(Biome biome : ForgeRegistries.BIOMES) 
			{

			
					biome.addFeature(Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.amethyst_ore.getDefaultState(), OADConfig.amethyst_max_vein_size.get())).withPlacement( Placement.CHANCE_RANGE.configure(new ChanceRangeConfig(amethyst_chance, 0, 0, 16))));

			
				
					biome.addFeature(Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.black_opal_ore.getDefaultState(), OADConfig.black_opal_max_vein_size.get())).withPlacement( Placement.CHANCE_RANGE.configure(new ChanceRangeConfig(black_opal_chance, 0, 0, 16))));
			}

		}
		
		if (OADConfig.nether_ores.get() == true) {
			for (Biome biome : ForgeRegistries.BIOMES) {
				if(biome.getCategory() == Biome.Category.NETHER) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(
							new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHER_ORE_REPLACEABLES, BlockList.nether_amethyst_ore.getDefaultState(),  (int) Math.min((OADConfig.amethyst_max_vein_size.get()*OADConfig.nether_vein_multiplier.get()), 64))).withPlacement( Placement.CHANCE_RANGE.configure(new ChanceRangeConfig((float)(amethyst_chance*OADConfig.nether_chance_multiplier.get()), 0, 0, 128))));
		
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(
							new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHER_ORE_REPLACEABLES, BlockList.nether_black_opal_ore.getDefaultState(),  (int) Math.min((OADConfig.black_opal_max_vein_size.get()*OADConfig.nether_vein_multiplier.get()), 64))).withPlacement( Placement.CHANCE_RANGE.configure(new ChanceRangeConfig((float)(black_opal_chance*OADConfig.nether_chance_multiplier.get()), 0, 0, 128))));
				}
			
			}
			
		}
		
		if (OADConfig.end_ores.get() == true) {
			for (Biome biome : ForgeRegistries.BIOMES ) { 
				if(biome.getCategory() == Biome.Category.THEEND) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(
							new OreFeatureConfig(END_STONE, BlockList.end_amethyst_ore.getDefaultState(), (int) Math.min((OADConfig.amethyst_max_vein_size.get()*OADConfig.end_vein_multiplier.get()), 64))).withPlacement( Placement.CHANCE_RANGE.configure(new ChanceRangeConfig((float)(amethyst_chance*OADConfig.end_chance_multiplier.get()), 0, 0, 75))));
			
					
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(
							new OreFeatureConfig(END_STONE, BlockList.end_black_opal_ore.getDefaultState(), (int) Math.min((OADConfig.black_opal_max_vein_size.get()*OADConfig.end_vein_multiplier.get()), 64))).withPlacement( Placement.CHANCE_RANGE.configure(new ChanceRangeConfig((float) (black_opal_chance*OADConfig.end_chance_multiplier.get()), 0, 0, 75))));
					
				      }
				}
			}
			
	}
}
