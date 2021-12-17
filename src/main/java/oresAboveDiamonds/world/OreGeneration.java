package oresAboveDiamonds.world;

import java.util.List;

import com.google.common.collect.ImmutableList;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import oresAboveDiamonds.OresAboveDiamonds;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.init.ModBlocks;

@EventBusSubscriber
public class OreGeneration {	
    
	public static ConfiguredFeature<?, ?> AMETHYST;
	public static ConfiguredFeature<?, ?> BLACK_OPAL;
	
	public static ConfiguredFeature<?, ?> AMETHYST_LARGE;
	public static ConfiguredFeature<?, ?> BLACK_OPAL_LARGE;
	
	public static ConfiguredFeature<?, ?> AMETHYST_BURIED;
	public static ConfiguredFeature<?, ?> BLACK_OPAL_BURIED;
	
	public static ConfiguredFeature<?, ?> NETHER_AMETHYST;
	public static ConfiguredFeature<?, ?> NETHER_BLACK_OPAL;
	
	public static ConfiguredFeature<?, ?> END_AMETHYST;
	public static ConfiguredFeature<?, ?> END_BLACK_OPAL;
	
	public static PlacedFeature AMETHYST_PLACED;
	public static PlacedFeature BLACK_OPAL_PLACED;
	
	public static PlacedFeature NETHER_AMETHYST_PLACED;
	public static PlacedFeature NETHER_BLACK_OPAL_PLACED;
	
	public static PlacedFeature END_AMETHYST_PLACED;
	public static PlacedFeature END_BLACK_OPAL_PLACED;
	
    // Reference: kwpugh's easy_steel mod
    public static ImmutableList<OreConfiguration.TargetBlockState> AMETHYST_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> NETHER_AMETHYST_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> END_AMETHYST_TARGET_BLOCKS;
    
    public static ImmutableList<OreConfiguration.TargetBlockState> BLACK_OPAL_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> NETHER_BLACK_OPAL_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> END_BLACK_OPAL_TARGET_BLOCKS;    
    
    
    
    public static ConfiguredFeature<?, ?> buildConfigured(ImmutableList<OreConfiguration.TargetBlockState> targets, double veinSize, float discardChance) {
    	return Feature.ORE.configured(new OreConfiguration(targets, (int) Math.round(veinSize), discardChance));
    }
    
    public static ConfiguredFeature<?, ?> buildNetherConfigured(ImmutableList<OreConfiguration.TargetBlockState> targets, double veinSize, float discardChance) {
		int netherVeinSize = (int) Math.round(veinSize * OADConfig.nether_vein_multiplier.get());
    	return buildConfigured(targets, netherVeinSize, discardChance);
    }
    
    public static ConfiguredFeature<?, ?> buildEndConfigured(ImmutableList<OreConfiguration.TargetBlockState> targets, double veinSize, float discardChance) {
		int endVeinSize = (int) Math.round(veinSize * OADConfig.end_vein_multiplier.get());
    	return buildConfigured(targets, endVeinSize, discardChance);
    }
    
    
    
	public static PlacedFeature buildOre(ConfiguredFeature<?, ?> configured, int maxHeight, int timesRarer) {
	        return configured.placed(RarityFilter.onAverageOnceEvery(timesRarer), InSquarePlacement.spread(), 
	        		HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), (VerticalAnchor.absolute(maxHeight))), BiomeFilter.biome());
	}
	 
	public static PlacedFeature buildNetherOre(ConfiguredFeature<?, ?> configured, int maxHeight, int timesRarer) {
		int netherTimesRarer = Math.max(1, (int) (timesRarer / OADConfig.nether_chance_multiplier.get()));
        return buildOre(configured, maxHeight, netherTimesRarer);

	}
	 
	public static PlacedFeature buildEndOre(ConfiguredFeature<?, ?> configured, int maxHeight, int timesRarer) {
		int endTimesRarer = Math.max(1, (int) (timesRarer / OADConfig.end_chance_multiplier.get()));
		return buildOre(configured, maxHeight, endTimesRarer);
	}
	 
	public static void registerFeatures() {
		
		AMETHYST_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.AMETHYST_ORE.get().defaultBlockState()),
				OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_AMETHYST_ORE.get().defaultBlockState()));
		NETHER_AMETHYST_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHER_AMETHYST_ORE.get().defaultBlockState()));
		END_AMETHYST_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.END_AMETHYST_ORE.get().defaultBlockState()));
		
		BLACK_OPAL_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.BLACK_OPAL_ORE.get().defaultBlockState()),
				OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_BLACK_OPAL_ORE.get().defaultBlockState()));	
		NETHER_BLACK_OPAL_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHER_BLACK_OPAL_ORE.get().defaultBlockState()));
		END_BLACK_OPAL_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.END_BLACK_OPAL_ORE.get().defaultBlockState()));
		
		
		AMETHYST = buildConfigured(AMETHYST_TARGET_BLOCKS, (OADConfig.amethyst_max_vein_size.get() / 2.0), 0.5F);
	    BLACK_OPAL = buildConfigured(BLACK_OPAL_TARGET_BLOCKS, (OADConfig.black_opal_max_vein_size.get() / 2.0), 0.5F);
	    
		AMETHYST_LARGE = buildConfigured(AMETHYST_TARGET_BLOCKS, (OADConfig.amethyst_max_vein_size.get() * 1.5), 0.7F);
	    BLACK_OPAL_LARGE = buildConfigured(BLACK_OPAL_TARGET_BLOCKS, (OADConfig.black_opal_max_vein_size.get() * 1.5), 0.7F);
	    
		AMETHYST_BURIED = buildConfigured(AMETHYST_TARGET_BLOCKS, OADConfig.amethyst_max_vein_size.get(), 1.0F);
	    BLACK_OPAL_BURIED = buildConfigured(BLACK_OPAL_TARGET_BLOCKS, OADConfig.black_opal_max_vein_size.get(), 1.0F);
	    
	    NETHER_AMETHYST = buildNetherConfigured(NETHER_AMETHYST_TARGET_BLOCKS, OADConfig.amethyst_max_vein_size.get(), 0F);
	    NETHER_BLACK_OPAL = buildNetherConfigured(NETHER_BLACK_OPAL_TARGET_BLOCKS, OADConfig.black_opal_max_vein_size.get(), 0F);
	        
	    END_AMETHYST = buildEndConfigured(END_AMETHYST_TARGET_BLOCKS, OADConfig.amethyst_max_vein_size.get(), 0F);
	    END_BLACK_OPAL = buildEndConfigured(END_BLACK_OPAL_TARGET_BLOCKS, OADConfig.black_opal_max_vein_size.get(), 0F); 		
			
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "amethyst_ore"), AMETHYST);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "black_opal_ore"), BLACK_OPAL);
				
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "nether_amethyst_ore"), NETHER_AMETHYST);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "nether_black_opal_ore"), NETHER_BLACK_OPAL);
			
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "end_amethyst_ore"), END_AMETHYST);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "end_black_opal_ore"), END_BLACK_OPAL);
	    
		AMETHYST_PLACED = buildOre(AMETHYST, OADConfig.amethyst_max_spawn_height_overworld.get(), OADConfig.amethyst_times_rarer.get());
	    BLACK_OPAL_PLACED = buildOre(BLACK_OPAL, OADConfig.black_opal_max_spawn_height_overworld.get(), OADConfig.black_opal_times_rarer.get());
	    
	    AMETHYST_PLACED_FRACTION
	    BLACK_OPAL_PLACED_FRACTION =
	    
	    NETHER_AMETHYST_PLACED = buildNetherOre(NETHER_AMETHYST, OADConfig.amethyst_max_spawn_height_nether.get(), OADConfig.amethyst_times_rarer.get());
	    NETHER_BLACK_OPAL_PLACED = buildNetherOre(NETHER_BLACK_OPAL, OADConfig.black_opal_max_spawn_height_nether.get(), OADConfig.black_opal_times_rarer.get());
	        
	    END_AMETHYST_PLACED = buildEndOre(END_AMETHYST, OADConfig.amethyst_max_spawn_height_end.get(), OADConfig.amethyst_times_rarer.get());
	    END_BLACK_OPAL_PLACED = buildEndOre(END_BLACK_OPAL, OADConfig.black_opal_max_spawn_height_end.get(), OADConfig.black_opal_times_rarer.get());
	    
	    Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "amethyst_ore"), AMETHYST_PLACED);
	    Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "black_opal_ore"), BLACK_OPAL_PLACED);
	    
	    Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "nether_amethyst_ore"), NETHER_AMETHYST_PLACED);
	    Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "nether_black_opal_ore"), NETHER_BLACK_OPAL_PLACED);
	    
	    Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "end_amethyst_ore"), END_AMETHYST_PLACED);
	    Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "end_black_opal_ore"), END_BLACK_OPAL_PLACED);
		
	}
	
	   public static final PlacedFeature ORE_DIAMOND = PlacementUtils.register("ore_diamond", OreFeatures.ORE_DIAMOND_SMALL.placed(commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
	   public static final PlacedFeature ORE_DIAMOND_LARGE = PlacementUtils.register("ore_diamond_large", OreFeatures.ORE_DIAMOND_LARGE.placed(rareOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
	   public static final PlacedFeature ORE_DIAMOND_BURIED = PlacementUtils.register("ore_diamond_buried", OreFeatures.ORE_DIAMOND_BURIED.placed(commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
	
	   private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
		      return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
		   }

		   private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
		      return orePlacement(CountPlacement.of(p_195344_), p_195345_);
		   }

		   private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
		      return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
		   }
}
