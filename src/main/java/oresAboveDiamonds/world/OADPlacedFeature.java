package oresAboveDiamonds.world;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import oresAboveDiamonds.config.OADConfig;

import java.util.List;

import static oresAboveDiamonds.world.OADConfiguredFeature.*;


@EventBusSubscriber
public class OADPlacedFeature {

    public static Holder<PlacedFeature>[] AMETHYST_SMALL_PLACED;
    public static Holder<PlacedFeature>[] BLACK_OPAL_SMALL_PLACED;
    public static Holder<PlacedFeature>[] AMETHYST_BURIED_PLACED;
    public static Holder<PlacedFeature>[] BLACK_OPAL_BURIED_PLACED;
    public static Holder<PlacedFeature>[] AMETHYST_LARGE_PLACED;
    public static Holder<PlacedFeature>[] BLACK_OPAL_LARGE_PLACED;
    public static Holder<PlacedFeature>[] NETHER_AMETHYST_PLACED;
    public static Holder<PlacedFeature>[] NETHER_BLACK_OPAL_PLACED;
    public static Holder<PlacedFeature>[] END_AMETHYST_PLACED;
    public static Holder<PlacedFeature>[] END_BLACK_OPAL_PLACED;
    
    public static Holder<PlacedFeature>[] buildFeatures(String name, Holder<ConfiguredFeature<OreConfiguration, ?>> configured, int veinCount, double timesRarer, HeightRangePlacement placement) {
    	Holder<PlacedFeature>[] fractionalFeatures = (Holder<PlacedFeature>[]) new Holder<?>[3];
    	double veinsPerChunk = veinCount / timesRarer;
    	int integerPart = (int) veinsPerChunk;
    	double doublePart = veinsPerChunk - integerPart;
    	fractionalFeatures[0] = PlacementUtils.register(name, configured, commonOrePlacement(integerPart, placement));
    	int[] denominators = closestDenominators(doublePart);
    	fractionalFeatures[1] = PlacementUtils.register(name + "_2", configured, rareOrePlacement(denominators[0], placement));
    	fractionalFeatures[2] = PlacementUtils.register(name + "_3", configured, rareOrePlacement(denominators[1], placement));
    	return fractionalFeatures;
    }

    public static HeightRangePlacement buildPlacement(int maxHeight) {
        return HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64 - maxHeight), VerticalAnchor.aboveBottom(64 + maxHeight));
    }
    public static HeightRangePlacement buildPlacement(int minHeight, int maxHeight) {
        return HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight));
    }

    public static void registerPlacedFeatures() {

        // The integers in the second paramter are based on vanilla's OrePlacements class.
        // Large_Placed turns into 1 / 9 by using 1 as the integer and multiplying times rarer by 9.
        HeightRangePlacement aPlacement = buildPlacement(OADConfig.amethyst_max_spawn_height_overworld.get());
        AMETHYST_SMALL_PLACED = buildFeatures("ore_amethyst", AMETHYST_SMALL, 7, OADConfig.amethyst_times_rarer.get(), aPlacement);
        AMETHYST_BURIED_PLACED = buildFeatures("ore_amethyst_buried", AMETHYST_BURIED, 4, OADConfig.amethyst_times_rarer.get(), aPlacement);
        AMETHYST_LARGE_PLACED = buildFeatures("ore_amethyst_large", AMETHYST_LARGE, 1, OADConfig.amethyst_times_rarer.get() * 9, buildPlacement(OADConfig.amethyst_max_spawn_height_overworld.get()));
        
        HeightRangePlacement bPlacement = buildPlacement(OADConfig.black_opal_max_spawn_height_overworld.get());
        BLACK_OPAL_SMALL_PLACED = buildFeatures("ore_black_opal", BLACK_OPAL_SMALL, 7, OADConfig.black_opal_times_rarer.get(), bPlacement);
        BLACK_OPAL_BURIED_PLACED = buildFeatures("ore_black_opal_buried", BLACK_OPAL_BURIED, 4, OADConfig.black_opal_times_rarer.get(), bPlacement);
        BLACK_OPAL_LARGE_PLACED = buildFeatures("ore_black_opal_placed", BLACK_OPAL_LARGE, 1, OADConfig.black_opal_times_rarer.get() * 9, buildPlacement(OADConfig.black_opal_max_spawn_height_overworld.get()));

        double netherAmethystTimesRarer = OADConfig.amethyst_times_rarer.get() * OADConfig.nether_chance_multiplier.get();
        double netherBlackOpalTimesRarer = OADConfig.black_opal_times_rarer.get() * OADConfig.nether_chance_multiplier.get();

        NETHER_AMETHYST_PLACED = buildFeatures("ore_nether_amethyst", NETHER_AMETHYST, 9, netherAmethystTimesRarer, buildPlacement(0, OADConfig.amethyst_max_spawn_height_nether.get()));
        NETHER_BLACK_OPAL_PLACED = buildFeatures("ore_nether_black_opal", NETHER_BLACK_OPAL, 9, netherBlackOpalTimesRarer, buildPlacement(0, OADConfig.black_opal_max_spawn_height_nether.get()));

        double endAmethystTimesRarer = OADConfig.amethyst_times_rarer.get() * OADConfig.end_chance_multiplier.get();
        double endBlackOpalTimesRarer = OADConfig.black_opal_times_rarer.get() * OADConfig.end_chance_multiplier.get();

        END_AMETHYST_PLACED = buildFeatures("ore_end_amethyst", END_AMETHYST, 3, endAmethystTimesRarer, buildPlacement(0, OADConfig.amethyst_max_spawn_height_end.get()));
        END_BLACK_OPAL_PLACED = buildFeatures("ore_end_black_opal", END_BLACK_OPAL, 3, endBlackOpalTimesRarer, buildPlacement(0, OADConfig.black_opal_max_spawn_height_end.get()));

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
    
    // Thanks to my friend Ruston for this method
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
