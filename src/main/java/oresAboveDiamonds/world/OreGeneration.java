package oresAboveDiamonds.world;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
//import net.minecraft.world.gen.placement.ChanceRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.lists.BlockList;

public class OreGeneration {	
    
	public static ConfiguredFeature<?, ?> AMETHYST_OVERWORLD = buildOverworldOre(BlockList.amethyst_ore.getDefaultState(), OADConfig.amethyst_max_vein_size.get(), OADConfig.amethyst_max_spawn_height_overworld.get(), OADConfig.amethyst_times_rarer.get());
    public static ConfiguredFeature<?, ?> BLACK_OPAL_OVERWORLD = buildOverworldOre(BlockList.black_opal_ore.getDefaultState(), OADConfig.black_opal_max_vein_size.get(), OADConfig.black_opal_max_spawn_height_overworld.get(), OADConfig.black_opal_times_rarer.get());
		
    public static ConfiguredFeature<?, ?> AMETHYST_NETHER = buildNetherOre(BlockList.nether_amethyst_ore.getDefaultState(), (int)Math.round(OADConfig.amethyst_max_vein_size.get() * OADConfig.nether_vein_multiplier.get()), OADConfig.amethyst_max_spawn_height_nether.get(), Math.max(1, (int) (OADConfig.amethyst_times_rarer.get() / (OADConfig.nether_chance_multiplier.get()) )));
    public static ConfiguredFeature<?, ?> BLACK_OPAL_NETHER = buildNetherOre(BlockList.nether_black_opal_ore.getDefaultState(), (int)Math.round(OADConfig.black_opal_max_vein_size.get() * OADConfig.nether_vein_multiplier.get()), OADConfig.black_opal_max_spawn_height_nether.get(), Math.max(1, (int) (OADConfig.black_opal_times_rarer.get() / (OADConfig.nether_chance_multiplier.get()) )));
        
    public static ConfiguredFeature<?, ?> AMETHYST_END = buildEndOre(BlockList.end_amethyst_ore.getDefaultState(), (int)Math.round(OADConfig.amethyst_max_vein_size.get() * OADConfig.end_vein_multiplier.get()), OADConfig.amethyst_max_spawn_height_end.get(), Math.max(1, (int) (OADConfig.amethyst_times_rarer.get() / (OADConfig.end_chance_multiplier.get()) )));
    public static ConfiguredFeature<?, ?> BLACK_OPAL_END = buildEndOre(BlockList.end_black_opal_ore.getDefaultState(), (int)Math.round(OADConfig.black_opal_max_vein_size.get() * OADConfig.end_vein_multiplier.get()), OADConfig.black_opal_max_spawn_height_end.get(), Math.max(1, (int) (OADConfig.black_opal_times_rarer.get() / (OADConfig.end_chance_multiplier.get()) ))); 
    
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
	 
	 
	 public static ConfiguredFeature<?, ?> buildEndOre(BlockState bstate, int veinSize, int maxHeight, int timesRarer) {
	        return Feature.ORE.withConfiguration(
	                new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE), 
	                        bstate, veinSize)).withPlacement(Placement.RANGE.configure(
	                    			new TopSolidRangeConfig(0, 0, maxHeight))).square().chance(timesRarer);

	 }
	 
}
