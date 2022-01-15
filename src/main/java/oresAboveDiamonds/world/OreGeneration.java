package oresAboveDiamonds.world;

import com.google.common.collect.ImmutableList;
import java.util.List;
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
    
    public static ConfiguredFeature<?, ?> AMETHYST_SMALL;
    public static ConfiguredFeature<?, ?> BLACK_OPAL_SMALL;
    public static ConfiguredFeature<?, ?> AMETHYST_LARGE;
    public static ConfiguredFeature<?, ?> BLACK_OPAL_LARGE;
    public static ConfiguredFeature<?, ?> AMETHYST_BURIED;
    public static ConfiguredFeature<?, ?> BLACK_OPAL_BURIED;
    public static ConfiguredFeature<?, ?> NETHER_AMETHYST;
    public static ConfiguredFeature<?, ?> NETHER_BLACK_OPAL;
    public static ConfiguredFeature<?, ?> END_AMETHYST;
    public static ConfiguredFeature<?, ?> END_BLACK_OPAL;

    public static PlacedFeature[] AMETHYST_SMALL_PLACED;
    public static PlacedFeature[] BLACK_OPAL_SMALL_PLACED;
    public static PlacedFeature[] AMETHYST_BURIED_PLACED;
    public static PlacedFeature[] BLACK_OPAL_BURIED_PLACED;
    public static PlacedFeature[] AMETHYST_LARGE_PLACED;
    public static PlacedFeature[] BLACK_OPAL_LARGE_PLACED;
    public static PlacedFeature[] NETHER_AMETHYST_PLACED;
    public static PlacedFeature[] NETHER_BLACK_OPAL_PLACED;
    public static PlacedFeature[] END_AMETHYST_PLACED;
    public static PlacedFeature[] END_BLACK_OPAL_PLACED;

    public static ImmutableList<OreConfiguration.TargetBlockState> AMETHYST_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> NETHER_AMETHYST_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> END_AMETHYST_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> BLACK_OPAL_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> NETHER_BLACK_OPAL_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> END_BLACK_OPAL_TARGET_BLOCKS;    
    
    public static ConfiguredFeature<?, ?> buildConfigured(ImmutableList<OreConfiguration.TargetBlockState> targets, double veinSize, float discardChance) {
        return Feature.ORE.configured(new OreConfiguration(targets, (int) Math.round(veinSize), discardChance));
    }
    
    // Only used for non-default config options
    public static PlacedFeature[] buildFeatures(ConfiguredFeature<?, ?> configured, int veinCount, double timesRarer, HeightRangePlacement placement) {
    	PlacedFeature[] fractionalFeatures = new PlacedFeature[3];
    	double veinsPerChunk = veinCount / timesRarer;
    	int integerPart = (int) veinsPerChunk;
    	double doublePart = veinsPerChunk - integerPart;
    	fractionalFeatures[0] = configured.placed(commonOrePlacement(integerPart, placement));
    	int[] denominators = closestDenominators(doublePart);
    	fractionalFeatures[1] = configured.placed(rareOrePlacement(denominators[0], placement));
    	fractionalFeatures[2] = configured.placed(rareOrePlacement(denominators[1], placement));
    	return fractionalFeatures;
    }

    public static HeightRangePlacement buildPlacement(int maxHeight) {
        return HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64 - maxHeight), VerticalAnchor.aboveBottom(64 + maxHeight));
    }
    public static HeightRangePlacement buildPlacement(int minHeight, int maxHeight) {
        return HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight));
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

        AMETHYST_SMALL = buildConfigured(AMETHYST_TARGET_BLOCKS, (OADConfig.amethyst_vein_size.get() / 2.0), OADConfig.overworld_discard_chance_on_air_exposure.get().floatValue() * 0.715F);
        BLACK_OPAL_SMALL = buildConfigured(BLACK_OPAL_TARGET_BLOCKS, (OADConfig.black_opal_vein_size.get() / 2.0), OADConfig.overworld_discard_chance_on_air_exposure.get().floatValue() * 0.715F);

        AMETHYST_LARGE = buildConfigured(AMETHYST_TARGET_BLOCKS, (OADConfig.amethyst_vein_size.get() * 1.5), OADConfig.overworld_discard_chance_on_air_exposure.get().floatValue());
        BLACK_OPAL_LARGE = buildConfigured(BLACK_OPAL_TARGET_BLOCKS, (OADConfig.black_opal_vein_size.get() * 1.5), OADConfig.overworld_discard_chance_on_air_exposure.get().floatValue());

        AMETHYST_BURIED = buildConfigured(AMETHYST_TARGET_BLOCKS, OADConfig.amethyst_vein_size.get(), Math.min(1.0F, OADConfig.overworld_discard_chance_on_air_exposure.get().floatValue() * 1.43F));
        BLACK_OPAL_BURIED = buildConfigured(BLACK_OPAL_TARGET_BLOCKS, OADConfig.black_opal_vein_size.get(), Math.min(1.0F, OADConfig.overworld_discard_chance_on_air_exposure.get().floatValue() * 1.43F));

        int netherAmethystVeinSize = (int) Math.round(OADConfig.amethyst_vein_size.get() * OADConfig.nether_vein_multiplier.get());
        int netherBlackOpalVeinSize = (int) Math.round(OADConfig.black_opal_vein_size.get() * OADConfig.nether_vein_multiplier.get());

        NETHER_AMETHYST = buildConfigured(NETHER_AMETHYST_TARGET_BLOCKS, netherAmethystVeinSize, OADConfig.nether_discard_chance_on_air_exposure.get().floatValue());
        NETHER_BLACK_OPAL = buildConfigured(NETHER_BLACK_OPAL_TARGET_BLOCKS, netherBlackOpalVeinSize, OADConfig.nether_discard_chance_on_air_exposure.get().floatValue());

        int endAmethystVeinSize = (int) Math.round(OADConfig.amethyst_vein_size.get() * OADConfig.end_vein_multiplier.get());
        int endBlackOpalVeinSize = (int) Math.round(OADConfig.black_opal_vein_size.get() * OADConfig.end_vein_multiplier.get());

        END_AMETHYST = buildConfigured(END_AMETHYST_TARGET_BLOCKS, endAmethystVeinSize, OADConfig.end_discard_chance_on_air_exposure.get().floatValue());
        END_BLACK_OPAL = buildConfigured(END_BLACK_OPAL_TARGET_BLOCKS, endBlackOpalVeinSize, OADConfig.end_discard_chance_on_air_exposure.get().floatValue());

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_amethyst"), AMETHYST_SMALL);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_black_opal"), BLACK_OPAL_SMALL);

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_amethyst_large"), AMETHYST_LARGE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_black_opal_large"), BLACK_OPAL_LARGE);

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_amethyst_buried"), AMETHYST_BURIED);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_black_opal_buried"), BLACK_OPAL_BURIED);

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_nether_amethyst"), NETHER_AMETHYST);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_nether_black_opal"), NETHER_BLACK_OPAL);

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_end_amethyst"), END_AMETHYST);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_end_black_opal"), END_BLACK_OPAL);

        // Uses fractions to try and better imitate vanilla's ore spawning
        HeightRangePlacement aPlacement = buildPlacement(OADConfig.amethyst_max_spawn_height_overworld.get());
        if (OADConfig.amethyst_times_rarer.get() == 3) {
        	AMETHYST_SMALL_PLACED = new PlacedFeature[3];
            AMETHYST_SMALL_PLACED[0] = AMETHYST_SMALL.placed(commonOrePlacement(2, aPlacement));
            AMETHYST_SMALL_PLACED[1] = AMETHYST_SMALL.placed(rareOrePlacement(6, aPlacement));
            AMETHYST_SMALL_PLACED[2] = AMETHYST_SMALL.placed(rareOrePlacement(6, aPlacement));
            
            AMETHYST_BURIED_PLACED = new PlacedFeature[3];
            AMETHYST_BURIED_PLACED[0] = AMETHYST_BURIED.placed(commonOrePlacement(1, aPlacement));
            AMETHYST_BURIED_PLACED[1] = AMETHYST_BURIED.placed(rareOrePlacement(6, aPlacement));
            AMETHYST_BURIED_PLACED[2] = AMETHYST_BURIED.placed(rareOrePlacement(6, aPlacement));
        } else {
            AMETHYST_SMALL_PLACED = buildFeatures(AMETHYST_SMALL, 7, OADConfig.amethyst_times_rarer.get(), aPlacement);
            AMETHYST_BURIED_PLACED = buildFeatures(AMETHYST_BURIED, 4, OADConfig.amethyst_times_rarer.get(), aPlacement);
        }

        HeightRangePlacement bPlacement = buildPlacement(OADConfig.black_opal_max_spawn_height_overworld.get());
        if (OADConfig.black_opal_times_rarer.get() == 9) {
        	BLACK_OPAL_SMALL_PLACED = new PlacedFeature[3];
        	BLACK_OPAL_SMALL_PLACED[0] = BLACK_OPAL_SMALL.placed(commonOrePlacement(0, bPlacement));
            BLACK_OPAL_SMALL_PLACED[1] = BLACK_OPAL_SMALL.placed(rareOrePlacement(2, bPlacement));
            BLACK_OPAL_SMALL_PLACED[2] =  BLACK_OPAL_SMALL.placed(rareOrePlacement(4, bPlacement));

            BLACK_OPAL_BURIED_PLACED = new PlacedFeature[3];
            BLACK_OPAL_BURIED_PLACED[0] = BLACK_OPAL_BURIED.placed(commonOrePlacement(0, bPlacement));
            BLACK_OPAL_BURIED_PLACED[1] = BLACK_OPAL_BURIED.placed(rareOrePlacement(3, bPlacement));
            BLACK_OPAL_BURIED_PLACED[2] = BLACK_OPAL_BURIED.placed(rareOrePlacement(9, bPlacement));
        } else {
            BLACK_OPAL_SMALL_PLACED = buildFeatures(BLACK_OPAL_SMALL, 7, OADConfig.black_opal_times_rarer.get(), bPlacement);
            BLACK_OPAL_BURIED_PLACED = buildFeatures(BLACK_OPAL_BURIED, 4, OADConfig.black_opal_times_rarer.get(), bPlacement);
        }

        AMETHYST_LARGE_PLACED = buildFeatures(AMETHYST_LARGE, 1, OADConfig.amethyst_times_rarer.get() * 9, buildPlacement(OADConfig.amethyst_max_spawn_height_overworld.get()));
        BLACK_OPAL_LARGE_PLACED = buildFeatures(BLACK_OPAL_LARGE, 1, OADConfig.black_opal_times_rarer.get() * 9, buildPlacement(OADConfig.black_opal_max_spawn_height_overworld.get()));

        double netherAmethystTimesRarer = OADConfig.amethyst_times_rarer.get() * OADConfig.nether_chance_multiplier.get();
        double netherBlackOpalTimesRarer = OADConfig.black_opal_times_rarer.get() * OADConfig.nether_chance_multiplier.get();

        NETHER_AMETHYST_PLACED = buildFeatures(NETHER_AMETHYST, 9, netherAmethystTimesRarer, buildPlacement(0, OADConfig.amethyst_max_spawn_height_nether.get()));
        NETHER_BLACK_OPAL_PLACED = buildFeatures(NETHER_BLACK_OPAL, 9, netherBlackOpalTimesRarer, buildPlacement(0, OADConfig.black_opal_max_spawn_height_nether.get()));

        double endAmethystTimesRarer = OADConfig.amethyst_times_rarer.get() * OADConfig.end_chance_multiplier.get();
        double endBlackOpalTimesRarer = OADConfig.black_opal_times_rarer.get() * OADConfig.end_chance_multiplier.get();

        END_AMETHYST_PLACED = buildFeatures(END_AMETHYST, 3, endAmethystTimesRarer, buildPlacement(0, OADConfig.amethyst_max_spawn_height_end.get()));
        END_BLACK_OPAL_PLACED = buildFeatures(END_BLACK_OPAL, 3, endBlackOpalTimesRarer, buildPlacement(0, OADConfig.black_opal_max_spawn_height_end.get()));

        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_amethyst"), AMETHYST_SMALL_PLACED[0]);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_black_opal"), BLACK_OPAL_SMALL_PLACED[0]);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_amethyst_2"), AMETHYST_SMALL_PLACED[1]);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_black_opal_2"), BLACK_OPAL_SMALL_PLACED[1]);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_amethyst_3"), AMETHYST_SMALL_PLACED[2]);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_black_opal_3"), BLACK_OPAL_SMALL_PLACED[2]);

        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_amethyst_large"), AMETHYST_LARGE_PLACED[0]);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_black_opal_large"), BLACK_OPAL_LARGE_PLACED[0]);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_amethyst_large_2"), AMETHYST_LARGE_PLACED[1]);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_black_opal_large_2"), BLACK_OPAL_LARGE_PLACED[1]);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_amethyst_large_3"), AMETHYST_LARGE_PLACED[2]);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_black_opal_large_3"), BLACK_OPAL_LARGE_PLACED[2]);
        
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_amethyst_buried"), AMETHYST_BURIED_PLACED[0]);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_black_opal_buried"), BLACK_OPAL_BURIED_PLACED[0]);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_amethyst_buried_2"), AMETHYST_BURIED_PLACED[1]);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_black_opal_buried_2"), BLACK_OPAL_BURIED_PLACED[1]);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_amethyst_buried_3"), AMETHYST_BURIED_PLACED[2]);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_black_opal_buried_3"), BLACK_OPAL_BURIED_PLACED[2]);

        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_nether_amethyst"), NETHER_AMETHYST_PLACED[0]);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_nether_black_opal"), NETHER_BLACK_OPAL_PLACED[0]);

        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_nether_amethyst_2"), NETHER_AMETHYST_PLACED[1]);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_nether_black_opal_2"), NETHER_BLACK_OPAL_PLACED[1]);
        
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_nether_amethyst_3"), NETHER_AMETHYST_PLACED[2]);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_nether_black_opal_3"), NETHER_BLACK_OPAL_PLACED[2]);
        
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_end_amethyst"), END_AMETHYST_PLACED[0]);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_end_black_opal"), END_BLACK_OPAL_PLACED[0]);

        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_end_amethyst_2"), END_AMETHYST_PLACED[1]);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_end_black_opal_2"), END_BLACK_OPAL_PLACED[1]);
        
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_end_amethyst_3"), END_AMETHYST_PLACED[2]);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_end_black_opal_3"), END_BLACK_OPAL_PLACED[2]);
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }
    
    private static int[] closestDenominators(double c) {
    	//the following code was designed to solve the problem (1/x) + (1/y) = c, given some c
        //where x and y are integers and c is a continuos value between 0 and 1
        //it also calculates the error
    	int x = 0;
    	int y = 0;
        double error = Double.MAX_VALUE;
        double s = (double)2/c;
        if (Math.floor(s) == Math.ceil(s)) {
            //optimization
            //note that Math.floor(double value) == Math.ceil(double value) implies that the value is a whole number
            x = (int) s;
            y = (int) s;
            error = 0;
        } else {
            s = (double) 1 / c;
            int min = ((Math.floor(s) == Math.ceil(s)) ? ((int) (Math.floor(s) + 1)) : ((int) (Math.ceil(s))));
            //min is the smallest integer greater than the asymptote

            double r = -(double) min / (1 - (c * min));
            //r is the the other coordinate pair value at min
            if (Math.floor(r) == Math.ceil(r)) {
                //optimization
                x = min;
                y = (int) Math.ceil(r);
                error = 0;
            } else {
                int max = (int) Math.floor(r);
                //max is the greatest integer value one member of the x,y pair can take...
                //without exceeding the min of the other member

                //this loop iterates throught the set of possible integer values
                //while there are methods that result in lower asymptotic runtimes
                //they require so many operations that the runtime should be comparable
                double exact;
                for (int i = min; i <= max; i++) {
                    exact = -(double) i / (1 - (c * i));
                    if (Math.floor(exact) == Math.ceil(exact)) {
                        //solution
                        x = i;
                        y = (int) Math.ceil(exact);
                        error = 0;
                        break;
                    } else {
                        double local_error = Math.abs(c - ((double) 1 / i) - ((double) 1 / Math.round(exact)));
                        if (local_error < error) {
                            error = local_error;
                            x = i;
                            y = (int) Math.round(exact);
                        }
                    }
                }
            }
        }
        int[] denominators = {x, y};
        return denominators;
    }
}
