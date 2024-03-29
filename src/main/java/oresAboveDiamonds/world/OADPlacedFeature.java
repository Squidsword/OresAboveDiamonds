package oresAboveDiamonds.world;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import oresAboveDiamonds.OresAboveDiamonds;
import oresAboveDiamonds.config.OADConfig;

import java.util.List;

@EventBusSubscriber
public class OADPlacedFeature {

    // Reference: Gems And Crystals by Coliwogg
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, OresAboveDiamonds.MODID);

    public static final HeightRangePlacement aPlacement = buildPlacement(OADConfig.amethyst_max_spawn_height_overworld.get());
    public static final HeightRangePlacement bPlacement = buildPlacement(OADConfig.black_opal_max_spawn_height_overworld.get());

    // putting these a method wont work
    static {
        boolean enabled = OADConfig.spawn_amethyst_overworld.get();
        String name = "ore_amethyst";
        double veinsPerChunk = 7 / OADConfig.amethyst_times_rarer.get();

        int integerPart = enabled ? (int) veinsPerChunk : 0;
        double doublePart = veinsPerChunk - integerPart;
        int[] denominators = enabled ? closestDenominators(doublePart) : new int[]{-1, -1};

        PLACED_FEATURES.register(name,
                () -> new PlacedFeature((Holder<ConfiguredFeature<?, ?>>) (Holder<? extends ConfiguredFeature<?, ?>>)
                        OADConfiguredFeature.AMETHYST_SMALL, commonOrePlacement(integerPart, aPlacement)));

        PLACED_FEATURES.register(String.format("%s_2", name),
                () -> new PlacedFeature((Holder<ConfiguredFeature<?, ?>>) (Holder<? extends ConfiguredFeature<?, ?>>)
                        OADConfiguredFeature.AMETHYST_SMALL, rareOrePlacement(denominators[0], aPlacement)));

        PLACED_FEATURES.register(String.format("%s_3", name),
                () -> new PlacedFeature((Holder<ConfiguredFeature<?, ?>>) (Holder<? extends ConfiguredFeature<?, ?>>)
                        OADConfiguredFeature.AMETHYST_SMALL, rareOrePlacement(denominators[1], aPlacement)));
    }

    static {
        boolean enabled = OADConfig.spawn_amethyst_overworld.get();
        String name = "ore_amethyst_buried";
        double veinsPerChunk = 4 / OADConfig.amethyst_times_rarer.get();

        int integerPart = enabled ? (int) veinsPerChunk : 0;
        double doublePart = veinsPerChunk - integerPart;
        int[] denominators = enabled ? closestDenominators(doublePart) : new int[]{-1, -1};

        PLACED_FEATURES.register(name,
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        OADConfiguredFeature.AMETHYST_BURIED, commonOrePlacement(integerPart, aPlacement)));

        PLACED_FEATURES.register(String.format("%s_2", name),
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        OADConfiguredFeature.AMETHYST_BURIED, rareOrePlacement(denominators[0], aPlacement)));

        PLACED_FEATURES.register(String.format("%s_3", name),
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        OADConfiguredFeature.AMETHYST_BURIED, rareOrePlacement(denominators[1], aPlacement)));
    }

    static {
        boolean enabled = OADConfig.spawn_amethyst_overworld.get();
        String name = "ore_amethyst_large";
        double veinsPerChunk = 1 / (OADConfig.amethyst_times_rarer.get() * 9);

        int integerPart = enabled ? (int) veinsPerChunk : 0;
        double doublePart = veinsPerChunk - integerPart;
        int[] denominators = enabled ? closestDenominators(doublePart) : new int[]{-1, -1};

        PLACED_FEATURES.register(name,
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        OADConfiguredFeature.AMETHYST_LARGE, commonOrePlacement(integerPart, aPlacement)));

        PLACED_FEATURES.register(String.format("%s_2", name),
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        OADConfiguredFeature.AMETHYST_LARGE, rareOrePlacement(denominators[0], aPlacement)));

        PLACED_FEATURES.register(String.format("%s_3", name),
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        OADConfiguredFeature.AMETHYST_LARGE, rareOrePlacement(denominators[1], aPlacement)));
    }

    static {
        boolean enabled = OADConfig.spawn_black_opal_overworld.get();
        String name = "ore_black_opal";
        double veinsPerChunk = 7 / OADConfig.black_opal_times_rarer.get();

        int integerPart = enabled ? (int) veinsPerChunk : 0;
        double doublePart = veinsPerChunk - integerPart;
        int[] denominators = enabled ? closestDenominators(doublePart) : new int[]{-1, -1};

        PLACED_FEATURES.register(name,
                () -> new PlacedFeature((Holder<ConfiguredFeature<?, ?>>) (Holder<? extends ConfiguredFeature<?, ?>>)
                        OADConfiguredFeature.BLACK_OPAL_SMALL, commonOrePlacement(integerPart, bPlacement)));

        PLACED_FEATURES.register(String.format("%s_2", name),
                () -> new PlacedFeature((Holder<ConfiguredFeature<?, ?>>) (Holder<? extends ConfiguredFeature<?, ?>>)
                        OADConfiguredFeature.BLACK_OPAL_SMALL, rareOrePlacement(denominators[0], bPlacement)));

        PLACED_FEATURES.register(String.format("%s_3", name),
                () -> new PlacedFeature((Holder<ConfiguredFeature<?, ?>>) (Holder<? extends ConfiguredFeature<?, ?>>)
                        OADConfiguredFeature.BLACK_OPAL_SMALL, rareOrePlacement(denominators[1], bPlacement)));
    }

    static {
        boolean enabled = OADConfig.spawn_black_opal_overworld.get();
        String name = "ore_black_opal_buried";
        double veinsPerChunk = 4 / OADConfig.black_opal_times_rarer.get();

        int integerPart = enabled ? (int) veinsPerChunk : 0;
        double doublePart = veinsPerChunk - integerPart;
        int[] denominators = enabled ? closestDenominators(doublePart) : new int[]{-1, -1};

        PLACED_FEATURES.register(name,
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        OADConfiguredFeature.BLACK_OPAL_BURIED, commonOrePlacement(integerPart, bPlacement)));

        PLACED_FEATURES.register(String.format("%s_2", name),
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        OADConfiguredFeature.BLACK_OPAL_BURIED, rareOrePlacement(denominators[0], bPlacement)));

        PLACED_FEATURES.register(String.format("%s_3", name),
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        OADConfiguredFeature.BLACK_OPAL_BURIED, rareOrePlacement(denominators[1], bPlacement)));
    }

    static {
        boolean enabled = OADConfig.spawn_black_opal_overworld.get();
        String name = "ore_black_opal_large";
        double veinsPerChunk = 1 / (OADConfig.black_opal_times_rarer.get() * 9);

        int integerPart = enabled ? (int) veinsPerChunk : 0;
        double doublePart = veinsPerChunk - integerPart;
        int[] denominators = enabled ? closestDenominators(doublePart) : new int[]{-1, -1};

        PLACED_FEATURES.register(name,
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        OADConfiguredFeature.BLACK_OPAL_LARGE, commonOrePlacement(integerPart, bPlacement)));

        PLACED_FEATURES.register(String.format("%s_2", name),
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        OADConfiguredFeature.BLACK_OPAL_LARGE, rareOrePlacement(denominators[0], bPlacement)));

        PLACED_FEATURES.register(String.format("%s_3", name),
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        OADConfiguredFeature.BLACK_OPAL_LARGE, rareOrePlacement(denominators[1], bPlacement)));
    }

    static {
        boolean enabled = OADConfig.spawn_amethyst_nether.get();
        String name = "ore_nether_amethyst";
        double veinsPerChunk = 9 * OADConfig.nether_chance_multiplier.get() / OADConfig.amethyst_times_rarer.get();

        int integerPart = enabled ? (int) veinsPerChunk : 0;
        double doublePart = veinsPerChunk - integerPart;
        int[] denominators = enabled ? closestDenominators(doublePart) : new int[]{-1, -1};

        PLACED_FEATURES.register(name,
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        OADConfiguredFeature.NETHER_AMETHYST, commonOrePlacement(integerPart, buildPlacement(0, OADConfig.amethyst_max_spawn_height_nether.get()))));

        PLACED_FEATURES.register(String.format("%s_2", name),
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        OADConfiguredFeature.NETHER_AMETHYST, rareOrePlacement(denominators[0], buildPlacement(0, OADConfig.amethyst_max_spawn_height_nether.get()))));

        PLACED_FEATURES.register(String.format("%s_3", name),
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        OADConfiguredFeature.NETHER_AMETHYST, rareOrePlacement(denominators[1], buildPlacement(0, OADConfig.amethyst_max_spawn_height_nether.get()))));
    }

    static {
        boolean enabled = OADConfig.spawn_black_opal_nether.get();
        String name = "ore_nether_black_opal";
        double veinsPerChunk = 9 * OADConfig.nether_chance_multiplier.get() / OADConfig.black_opal_times_rarer.get();

        int integerPart = enabled ? (int) veinsPerChunk : 0;
        double doublePart = veinsPerChunk - integerPart;
        int[] denominators = enabled ? closestDenominators(doublePart) : new int[]{-1, -1};

        PLACED_FEATURES.register(name,
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        OADConfiguredFeature.NETHER_BLACK_OPAL, commonOrePlacement(integerPart, buildPlacement(0, OADConfig.black_opal_max_spawn_height_nether.get()))));

        PLACED_FEATURES.register(String.format("%s_2", name),
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        OADConfiguredFeature.NETHER_BLACK_OPAL, rareOrePlacement(denominators[0], buildPlacement(0, OADConfig.black_opal_max_spawn_height_nether.get()))));

        PLACED_FEATURES.register(String.format("%s_3", name),
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        OADConfiguredFeature.NETHER_BLACK_OPAL, rareOrePlacement(denominators[1], buildPlacement(0, OADConfig.black_opal_max_spawn_height_nether.get()))));
    }

    static {
        boolean enabled = OADConfig.spawn_amethyst_end.get();
        String name = "ore_end_amethyst";
        double veinsPerChunk = 3 * OADConfig.end_chance_multiplier.get() / OADConfig.amethyst_times_rarer.get();

        int integerPart = enabled ? (int) veinsPerChunk : 0;
        double doublePart = veinsPerChunk - integerPart;
        int[] denominators = enabled ? closestDenominators(doublePart) : new int[]{-1, -1};

        PLACED_FEATURES.register(name,
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        OADConfiguredFeature.END_AMETHYST, commonOrePlacement(integerPart, buildPlacement(0, OADConfig.amethyst_max_spawn_height_end.get()))));

        PLACED_FEATURES.register(String.format("%s_2", name),
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        OADConfiguredFeature.END_AMETHYST, rareOrePlacement(denominators[0], buildPlacement(0, OADConfig.amethyst_max_spawn_height_end.get()))));

        PLACED_FEATURES.register(String.format("%s_3", name),
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        OADConfiguredFeature.END_AMETHYST, rareOrePlacement(denominators[1], buildPlacement(0, OADConfig.amethyst_max_spawn_height_end.get()))));
    }

    static {
        boolean enabled = OADConfig.spawn_black_opal_end.get();
        String name = "ore_end_black_opal";
        double veinsPerChunk = 3 * OADConfig.end_chance_multiplier.get() / OADConfig.black_opal_times_rarer.get();

        int integerPart = enabled ? (int) veinsPerChunk : 0;
        double doublePart = veinsPerChunk - integerPart;
        int[] denominators = enabled ? closestDenominators(doublePart) : new int[]{-1, -1};

        PLACED_FEATURES.register(name,
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        OADConfiguredFeature.END_BLACK_OPAL, commonOrePlacement(integerPart, buildPlacement(0, OADConfig.black_opal_max_spawn_height_end.get()))));

        PLACED_FEATURES.register(String.format("%s_2", name),
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        OADConfiguredFeature.END_BLACK_OPAL, rareOrePlacement(denominators[0], buildPlacement(0, OADConfig.black_opal_max_spawn_height_end.get()))));

        PLACED_FEATURES.register(String.format("%s_3", name),
                () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                        OADConfiguredFeature.END_BLACK_OPAL, rareOrePlacement(denominators[1], buildPlacement(0, OADConfig.black_opal_max_spawn_height_end.get()))));
    }

    public static HeightRangePlacement buildPlacement(int maxHeight) {
        return HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64 - maxHeight), VerticalAnchor.aboveBottom(64 + maxHeight));
    }
    public static HeightRangePlacement buildPlacement(int minHeight, int maxHeight) {
        return HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight));
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        if (p_195350_ <= 0) {
            return commonOrePlacement(0, p_195351_);
        }
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
