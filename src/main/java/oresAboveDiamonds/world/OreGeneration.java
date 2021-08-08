package oresAboveDiamonds.world;

import com.google.common.collect.ImmutableList;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import oresAboveDiamonds.OresAboveDiamonds;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.init.ModBlocks;


@EventBusSubscriber
public class OreGeneration {	
    
	public static ConfiguredFeature<?, ?> AMETHYST_OVERWORLD;
	public static ConfiguredFeature<?, ?> BLACK_OPAL_OVERWORLD;
	
	public static ConfiguredFeature<?, ?> AMETHYST_NETHER;
	public static ConfiguredFeature<?, ?> BLACK_OPAL_NETHER;
	
	public static ConfiguredFeature<?, ?> AMETHYST_END;
	public static ConfiguredFeature<?, ?> BLACK_OPAL_END;
	
    // Reference: kwpugh's easy_steel mod for 1.17.1
    public static ImmutableList<OreConfiguration.TargetBlockState> AMETHYST_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> NETHER_AMETHYST_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> END_AMETHYST_TARGET_BLOCKS;
    
    public static ImmutableList<OreConfiguration.TargetBlockState> BLACK_OPAL_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> NETHER_BLACK_OPAL_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> END_BLACK_OPAL_TARGET_BLOCKS;    
    
	public static ConfiguredFeature<?, ?> buildOverworldOre(ImmutableList<OreConfiguration.TargetBlockState> targets, int veinSize, int maxHeight, int timesRarer) {
	        return Feature.ORE.configured(new OreConfiguration(targets,
	        		veinSize))
	        		.rangeUniform(VerticalAnchor.bottom(),
	        		VerticalAnchor.aboveBottom(maxHeight)).squared()
	        		.squared()
	        		.rarity(timesRarer);
	        		/*
	                new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE
	                        bstate, veinSize)).withPlacement(Placement.RANGE.configure(
	                    			new TopSolidRangeConfig(0, 0, maxHeight))).square().chance(timesRarer);
	                    			*/
  
	}
	 
	public static ConfiguredFeature<?, ?> buildNetherOre(ImmutableList<OreConfiguration.TargetBlockState> targets, int veinSize, int maxHeight, int timesRarer) {
		
		int netherVeinSize = (int)Math.round(veinSize * OADConfig.nether_vein_multiplier.get());
		int netherTimesRarer = Math.max(1, (int) (timesRarer / OADConfig.nether_chance_multiplier.get()));
		
        return Feature.ORE.configured(new OreConfiguration(targets,
        		netherVeinSize))
        		.rangeUniform(VerticalAnchor.bottom(),
        		VerticalAnchor.aboveBottom(maxHeight)).squared()
        		.squared()
        		.rarity(netherTimesRarer);
		
        /*
	        return Feature.ORE.withConfiguration(
	                new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHER_ORE_REPLACEABLES, 
	                        bstate, (int)Math.round(veinSize * OADConfig.nether_vein_multiplier.get()))).withPlacement(Placement.RANGE.configure(
	                    			new TopSolidRangeConfig(0, 0, maxHeight))).square().chance(Math.max(1, (int) (timesRarer / OADConfig.nether_chance_multiplier.get()) ));
	                    			*/

	}
	 
	 
	public static ConfiguredFeature<?, ?> buildEndOre(ImmutableList<OreConfiguration.TargetBlockState> targets, int veinSize, int maxHeight, int timesRarer) {
		
		int endVeinSize = (int)Math.round(veinSize * OADConfig.end_vein_multiplier.get());
		int endTimesRarer = Math.max(1, (int) (timesRarer / OADConfig.end_chance_multiplier.get()));
		
		 return Feature.ORE.configured(new OreConfiguration(targets,
	        		endVeinSize))
	        		.rangeUniform(VerticalAnchor.bottom(),
	        		VerticalAnchor.aboveBottom(maxHeight)).squared()
	        		.squared()
	        		.rarity(endTimesRarer);
		
		/*
	        return Feature.ORE.withConfiguration(
	                new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE), 
	                        bstate, (int)Math.round(veinSize * OADConfig.end_vein_multiplier.get()))).withPlacement(Placement.RANGE.configure(
	                    			new TopSolidRangeConfig(0, 0, maxHeight))).square().chance(Math.max(1, (int) (timesRarer / OADConfig.end_chance_multiplier.get()) ));
	*/
	}
	 
	public static void registerConfiguredFeatures() {
			// Thanks to TelepathicGrunt for finding this issue. Issue #1
		
		AMETHYST_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, ModBlocks.AMETHYST_ORE.get().defaultBlockState()),
				OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.AMETHYST_ORE.get().defaultBlockState()));
		NETHER_AMETHYST_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.NETHER_ORE_REPLACEABLES, ModBlocks.AMETHYST_ORE.get().defaultBlockState()));
		END_AMETHYST_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.AMETHYST_ORE.get().defaultBlockState()));
		
		BLACK_OPAL_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, ModBlocks.BLACK_OPAL_ORE.get().defaultBlockState()),
				OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.BLACK_OPAL_ORE.get().defaultBlockState()));
		NETHER_BLACK_OPAL_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.NETHER_ORE_REPLACEABLES, ModBlocks.BLACK_OPAL_ORE.get().defaultBlockState()));
		END_BLACK_OPAL_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.BLACK_OPAL_ORE.get().defaultBlockState()));
		
		
		AMETHYST_OVERWORLD = buildOverworldOre(AMETHYST_TARGET_BLOCKS, OADConfig.amethyst_max_vein_size.get(), OADConfig.amethyst_max_spawn_height_overworld.get(), OADConfig.amethyst_times_rarer.get());
	    BLACK_OPAL_OVERWORLD = buildOverworldOre(BLACK_OPAL_TARGET_BLOCKS, OADConfig.black_opal_max_vein_size.get(), OADConfig.black_opal_max_spawn_height_overworld.get(), OADConfig.black_opal_times_rarer.get());
			
	    AMETHYST_NETHER = buildNetherOre(NETHER_AMETHYST_TARGET_BLOCKS, OADConfig.amethyst_max_vein_size.get(), OADConfig.amethyst_max_spawn_height_nether.get(), OADConfig.amethyst_times_rarer.get());
	    BLACK_OPAL_NETHER = buildNetherOre(NETHER_BLACK_OPAL_TARGET_BLOCKS, OADConfig.black_opal_max_vein_size.get(), OADConfig.black_opal_max_spawn_height_nether.get(), OADConfig.black_opal_times_rarer.get());
	        
	    AMETHYST_END = buildEndOre(END_AMETHYST_TARGET_BLOCKS, OADConfig.amethyst_max_vein_size.get(), OADConfig.amethyst_max_spawn_height_end.get(), OADConfig.amethyst_times_rarer.get());
	    BLACK_OPAL_END = buildEndOre(END_BLACK_OPAL_TARGET_BLOCKS, OADConfig.black_opal_max_vein_size.get(), OADConfig.black_opal_max_spawn_height_end.get(), OADConfig.black_opal_times_rarer.get()); 		
			
	    
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "amethyst_ore"), AMETHYST_OVERWORLD);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "black_opal_ore"), BLACK_OPAL_OVERWORLD);
					
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "nether_amethyst_ore"), AMETHYST_NETHER);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "nether_black_opal_ore"), BLACK_OPAL_NETHER);
			
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "end_amethyst_ore"), AMETHYST_END);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "end_black_opal_ore"), BLACK_OPAL_END);
	}
	 
}
