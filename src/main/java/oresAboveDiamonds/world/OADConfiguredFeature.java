package oresAboveDiamonds.world;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.init.ModBlocks;

import java.util.ArrayList;

public record OADPlacedFeatureRecord(String name, int veinSize, float discardChance, int timesRarer, diamondVeinCount, ImmutableList<OreConfiguration.TargetBlockState> targets, HeightRangePlacement placement, Holder<ConfiguredFeature<OreConfiguration, ?>> configured) {

    private static ArrayList<OADPlacedFeatureRecord> OADConfiguredList;

    public static ImmutableList<OreConfiguration.TargetBlockState> AMETHYST_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> NETHER_AMETHYST_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> END_AMETHYST_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> BLACK_OPAL_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> NETHER_BLACK_OPAL_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> END_BLACK_OPAL_TARGET_BLOCKS;

    public static Holder<ConfiguredFeature<OreConfiguration, ?>> AMETHYST_SMALL;
    public static Holder<ConfiguredFeature<OreConfiguration, ?>> BLACK_OPAL_SMALL;
    public static Holder<ConfiguredFeature<OreConfiguration, ?>> AMETHYST_LARGE;
    public static Holder<ConfiguredFeature<OreConfiguration, ?>> BLACK_OPAL_LARGE;
    public static Holder<ConfiguredFeature<OreConfiguration, ?>> AMETHYST_BURIED;
    public static Holder<ConfiguredFeature<OreConfiguration, ?>> BLACK_OPAL_BURIED;
    public static Holder<ConfiguredFeature<OreConfiguration, ?>> NETHER_AMETHYST;
    public static Holder<ConfiguredFeature<OreConfiguration, ?>> NETHER_BLACK_OPAL;
    public static Holder<ConfiguredFeature<OreConfiguration, ?>> END_AMETHYST;
    public static Holder<ConfiguredFeature<OreConfiguration, ?>> END_BLACK_OPAL;

    public OADPlacedFeatureRecord {
        OADConfiguredList.add(this);
    }

    public static Holder<ConfiguredFeature<OreConfiguration, ?>> buildConfigured(String name, ImmutableList<OreConfiguration.TargetBlockState> targets, double veinSize, float discardChance) {
        return FeatureUtils.register(name, Feature.ORE, new OreConfiguration(targets, (int) Math.round(veinSize), discardChance));
    }

    static {

    }

    public static void registerConfiguredFeatures() {

        AMETHYST_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.AMETHYST_ORE.get().defaultBlockState()),
                OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_AMETHYST_ORE.get().defaultBlockState()));
        NETHER_AMETHYST_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHER_AMETHYST_ORE.get().defaultBlockState()));
        END_AMETHYST_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.END_AMETHYST_ORE.get().defaultBlockState()));

        BLACK_OPAL_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.BLACK_OPAL_ORE.get().defaultBlockState()),
                OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_BLACK_OPAL_ORE.get().defaultBlockState()));
        NETHER_BLACK_OPAL_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHER_BLACK_OPAL_ORE.get().defaultBlockState()));
        END_BLACK_OPAL_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.END_BLACK_OPAL_ORE.get().defaultBlockState()));

        AMETHYST_SMALL = buildConfigured("ore_amethyst", AMETHYST_TARGET_BLOCKS, (OADConfig.amethyst_vein_size.get() / 2.0), OADConfig.overworld_discard_chance_on_air_exposure.get().floatValue() * 0.715F);
        BLACK_OPAL_SMALL = buildConfigured("ore_black_opal", BLACK_OPAL_TARGET_BLOCKS, (OADConfig.black_opal_vein_size.get() / 2.0), OADConfig.overworld_discard_chance_on_air_exposure.get().floatValue() * 0.715F);
        new OADPlacedFeatureRecord("ore_amethyst")

        AMETHYST_BURIED = buildConfigured("ore_amethyst_buried", AMETHYST_TARGET_BLOCKS, OADConfig.amethyst_vein_size.get(), Math.min(1.0F, OADConfig.overworld_discard_chance_on_air_exposure.get().floatValue() * 1.43F));
        BLACK_OPAL_BURIED = buildConfigured("ore_black_opal_buried", BLACK_OPAL_TARGET_BLOCKS, OADConfig.black_opal_vein_size.get(), Math.min(1.0F, OADConfig.overworld_discard_chance_on_air_exposure.get().floatValue() * 1.43F));

        AMETHYST_LARGE = buildConfigured("ore_amethyst_large", AMETHYST_TARGET_BLOCKS, (OADConfig.amethyst_vein_size.get() * 1.5), OADConfig.overworld_discard_chance_on_air_exposure.get().floatValue());
        BLACK_OPAL_LARGE = buildConfigured("ore_black_opal_large", BLACK_OPAL_TARGET_BLOCKS, (OADConfig.black_opal_vein_size.get() * 1.5), OADConfig.overworld_discard_chance_on_air_exposure.get().floatValue());

        int netherAmethystVeinSize = (int) Math.round(OADConfig.amethyst_vein_size.get() * OADConfig.nether_vein_multiplier.get());
        int netherBlackOpalVeinSize = (int) Math.round(OADConfig.black_opal_vein_size.get() * OADConfig.nether_vein_multiplier.get());

        NETHER_AMETHYST = buildConfigured("ore_nether_amethyst", NETHER_AMETHYST_TARGET_BLOCKS, netherAmethystVeinSize, OADConfig.nether_discard_chance_on_air_exposure.get().floatValue());
        NETHER_BLACK_OPAL = buildConfigured("ore_nether_black_opal", NETHER_BLACK_OPAL_TARGET_BLOCKS, netherBlackOpalVeinSize, OADConfig.nether_discard_chance_on_air_exposure.get().floatValue());

        int endAmethystVeinSize = (int) Math.round(OADConfig.amethyst_vein_size.get() * OADConfig.end_vein_multiplier.get());
        int endBlackOpalVeinSize = (int) Math.round(OADConfig.black_opal_vein_size.get() * OADConfig.end_vein_multiplier.get());

        END_AMETHYST = buildConfigured("ore_end_amethyst", END_AMETHYST_TARGET_BLOCKS, endAmethystVeinSize, OADConfig.end_discard_chance_on_air_exposure.get().floatValue());
        END_BLACK_OPAL = buildConfigured("ore_end_black_opal", END_BLACK_OPAL_TARGET_BLOCKS, endBlackOpalVeinSize, OADConfig.end_discard_chance_on_air_exposure.get().floatValue());
    }

    public ArrayList<OADPlacedFeatureRecord> getOADConfiguredList(){
        ArrayList<OADPlacedFeatureRecord> newList = new ArrayList<>();
        newList.addAll(OADConfiguredList);
        return newList;
    }

}
