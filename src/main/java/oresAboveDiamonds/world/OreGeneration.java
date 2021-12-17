package oresAboveDiamonds.world;

import com.google.common.collect.ImmutableList;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
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
	
    // References: kwpugh's easy_steel mod , ModdingLegacy's Randomite mod
    public static ImmutableList<OreConfiguration.TargetBlockState> AMETHYST_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> NETHER_AMETHYST_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> END_AMETHYST_TARGET_BLOCKS;
    
    public static ImmutableList<OreConfiguration.TargetBlockState> BLACK_OPAL_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> NETHER_BLACK_OPAL_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> END_BLACK_OPAL_TARGET_BLOCKS;    
    
    
    
    public static ConfiguredFeature<?, ?> buildConfigured(ImmutableList<OreConfiguration.TargetBlockState> targets, int veinSize) {
    	return Feature.ORE.configured(new OreConfiguration(targets, veinSize));
    }
    
    public static ConfiguredFeature<?, ?> buildNetherConfigured(ImmutableList<OreConfiguration.TargetBlockState> targets, int veinSize) {
		int netherVeinSize = (int)Math.round(veinSize * OADConfig.nether_vein_multiplier.get());
    	return buildConfigured(targets, netherVeinSize);
    }
    
    public static ConfiguredFeature<?, ?> buildEndConfigured(ImmutableList<OreConfiguration.TargetBlockState> targets, int veinSize) {
		int endVeinSize = (int) Math.round(veinSize * OADConfig.end_vein_multiplier.get());
    	return buildConfigured(targets, endVeinSize);
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
	
	public static String stringRL(String name) {
		return OresAboveDiamonds.MODID + ":" + name;
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
		
		
		AMETHYST = buildConfigured(AMETHYST_TARGET_BLOCKS, OADConfig.amethyst_max_vein_size.get());
	    BLACK_OPAL = buildConfigured(BLACK_OPAL_TARGET_BLOCKS, OADConfig.black_opal_max_vein_size.get());
	    
	    NETHER_AMETHYST = buildNetherConfigured(NETHER_AMETHYST_TARGET_BLOCKS, OADConfig.amethyst_max_vein_size.get());
	    NETHER_BLACK_OPAL = buildNetherConfigured(NETHER_BLACK_OPAL_TARGET_BLOCKS, OADConfig.black_opal_max_vein_size.get());
	        
	    END_AMETHYST = buildEndConfigured(END_AMETHYST_TARGET_BLOCKS, OADConfig.amethyst_max_vein_size.get());
	    END_BLACK_OPAL = buildEndConfigured(END_BLACK_OPAL_TARGET_BLOCKS, OADConfig.black_opal_max_vein_size.get()); 		
			
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "amethyst_ore"), AMETHYST);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "black_opal_ore"), BLACK_OPAL);
				
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "nether_amethyst_ore"), NETHER_AMETHYST);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "nether_black_opal_ore"), NETHER_BLACK_OPAL);
			
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "end_amethyst_ore"), END_AMETHYST);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "end_black_opal_ore"), END_BLACK_OPAL);
	    
		AMETHYST_PLACED = buildOre(AMETHYST, OADConfig.amethyst_max_spawn_height_overworld.get(), OADConfig.amethyst_times_rarer.get());
	    BLACK_OPAL_PLACED = buildOre(BLACK_OPAL, OADConfig.black_opal_max_spawn_height_overworld.get(), OADConfig.black_opal_times_rarer.get());
	    
	    NETHER_AMETHYST_PLACED = buildNetherOre(NETHER_AMETHYST, OADConfig.amethyst_max_spawn_height_nether.get(), OADConfig.amethyst_times_rarer.get());
	    NETHER_BLACK_OPAL_PLACED = buildNetherOre(NETHER_BLACK_OPAL, OADConfig.black_opal_max_spawn_height_nether.get(), OADConfig.black_opal_times_rarer.get());
	        
	    END_AMETHYST_PLACED = buildEndOre(END_AMETHYST, OADConfig.amethyst_max_spawn_height_end.get(), OADConfig.amethyst_times_rarer.get());
	    END_BLACK_OPAL_PLACED = buildEndOre(END_BLACK_OPAL, OADConfig.black_opal_max_spawn_height_end.get(), OADConfig.black_opal_times_rarer.get());
	    
	    Registry.register(BuiltinRegistries.PLACED_FEATURE, stringRL("amethyst_ore"), AMETHYST_PLACED);
	    Registry.register(BuiltinRegistries.PLACED_FEATURE, stringRL("black_opal_ore"), BLACK_OPAL_PLACED);
	    
	    Registry.register(BuiltinRegistries.PLACED_FEATURE, stringRL("nether_amethyst_ore"), NETHER_AMETHYST_PLACED);
	    Registry.register(BuiltinRegistries.PLACED_FEATURE, stringRL("nether_black_opal_ore"), NETHER_BLACK_OPAL_PLACED);
	    
	    Registry.register(BuiltinRegistries.PLACED_FEATURE, stringRL("end_amethyst_ore"), END_AMETHYST_PLACED);
	    Registry.register(BuiltinRegistries.PLACED_FEATURE, stringRL("end_black_opal_ore"), END_BLACK_OPAL_PLACED);
		
	}
	
	 
}
