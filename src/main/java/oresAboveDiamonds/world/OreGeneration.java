package oresAboveDiamonds.world;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
//import net.minecraft.world.gen.placement.ChanceRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.lists.BlockList;

public class OreGeneration {	
    
    public static ConfiguredFeature<?, ?> BLACK_OPAL_OVERWORLD = buildOverworldOre(BlockList.black_opal_ore.getDefaultState(), OADConfig.black_opal_max_vein_size.get(), OADConfig.black_opal_max_spawn_height_overworld.get(), OADConfig.black_opal_times_rarer.get());
    public static ConfiguredFeature<?, ?> AMETHYST_OVERWORLD = buildOverworldOre(BlockList.amethyst_ore.getDefaultState(), OADConfig.amethyst_max_vein_size.get(), OADConfig.amethyst_max_spawn_height_overworld.get(), OADConfig.amethyst_times_rarer.get());
		
    public static ConfiguredFeature<?, ?> AMETHYST_NETHER = buildNetherOre(BlockList.amethyst_ore.getDefaultState(), OADConfig.amethyst_max_vein_size.get(), OADConfig.amethyst_max_spawn_height_nether.get(), Math.max(1, (int) (OADConfig.amethyst_times_rarer.get() / (OADConfig.nether_chance_multiplier.get()) )));
    public static ConfiguredFeature<?, ?> BLACK_OPAL_NETHER = buildNetherOre(BlockList.black_opal_ore.getDefaultState(), OADConfig.black_opal_max_vein_size.get(), OADConfig.black_opal_max_spawn_height_nether.get(), Math.max(1, (int) (OADConfig.black_opal_times_rarer.get() / (OADConfig.nether_chance_multiplier.get()) )));
        
    //public static ConfiguredFeature<?, ?> AMETHYST_END = buildEndOre(BlockList.amethyst_ore.getDefaultState(), OADConfig.amethyst_max_vein_size.get(), OADConfig.amethyst_max_spawn_height_end.get(), Math.max(1, (int) (OADConfig.amethyst_times_rarer.get() / (OADConfig.end_chance_multiplier.get()) )));
    //public static ConfiguredFeature<?, ?> BLACK_OPAL_END = buildEndOre(BlockList.black_opal_ore.getDefaultState(), OADConfig.black_opal_max_vein_size.get(), OADConfig.black_opal_max_spawn_height_end.get(), Math.max(1, (int) (OADConfig.black_opal_times_rarer.get() / (OADConfig.end_chance_multiplier.get()) ))); 
    
    public static final RuleTest END_STONE = new BlockMatchRuleTest(Blocks.END_STONE);
    
	 public static ConfiguredFeature<?, ?> buildOverworldOre(BlockState bstate, int veinSize, int maxHeight, int timesRarer) {
	        return Feature.ORE.withConfiguration(
	                new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, 
	                        bstate, veinSize)).withPlacement(Placement.RANGE.configure(
	                    			new TopSolidRangeConfig(0, 0, maxHeight))).square().chance(timesRarer);
  
	 }
	 
	 public static ConfiguredFeature<?, ?> buildNetherOre(BlockState bstate, int veinSize, int maxHeight, int timesRarer) {
	        return Feature.ORE.withConfiguration(
	                new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER, 
	                        bstate, veinSize)).withPlacement(Placement.RANGE.configure(
	                    			new TopSolidRangeConfig(0, 0, maxHeight))).square().chance(timesRarer);

	 }
	 
	 /*
	 public static ConfiguredFeature<?, ?> buildEndOre(BlockState bstate, int veinSize, int maxHeight, int timesRarer) {
	        return Feature.ORE.withConfiguration(
	                new OreFeatureConfig(END_STONE, 
	                        bstate, veinSize)).withPlacement(Placement.RANGE.configure(
	                    			new TopSolidRangeConfig(0, 0, maxHeight))).square().chance(timesRarer);

	 }
	 */
	 
	 /*
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
		*/
		
}
