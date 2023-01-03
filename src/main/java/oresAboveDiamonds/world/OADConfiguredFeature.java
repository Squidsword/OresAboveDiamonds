package oresAboveDiamonds.world;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import oresAboveDiamonds.OresAboveDiamonds;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.init.ModBlocks;

// Reference: FeatureUtils
public class OADConfiguredFeature {

    public static ImmutableList<OreConfiguration.TargetBlockState> AMETHYST_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> NETHER_AMETHYST_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> END_AMETHYST_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> BLACK_OPAL_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> NETHER_BLACK_OPAL_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> END_BLACK_OPAL_TARGET_BLOCKS;

    public static Holder.Reference<ConfiguredFeature<?, ?>> AMETHYST_SMALL;
    public static Holder.Reference<ConfiguredFeature<?, ?>> BLACK_OPAL_SMALL;
    public static Holder.Reference<ConfiguredFeature<?, ?>> AMETHYST_LARGE;
    public static Holder.Reference<ConfiguredFeature<?, ?>> BLACK_OPAL_LARGE;
    public static Holder.Reference<ConfiguredFeature<?, ?>> AMETHYST_BURIED;
    public static Holder.Reference<ConfiguredFeature<?, ?>> BLACK_OPAL_BURIED;
    public static Holder.Reference<ConfiguredFeature<?, ?>> NETHER_AMETHYST;
    public static Holder.Reference<ConfiguredFeature<?, ?>> NETHER_BLACK_OPAL;
    public static Holder.Reference<ConfiguredFeature<?, ?>> END_AMETHYST;
    public static Holder.Reference<ConfiguredFeature<?, ?>> END_BLACK_OPAL;

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> bootstrap) {
        RuleTest STONE = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest DEEPSLATE = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest NETHER = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
        AMETHYST_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(STONE, ModBlocks.AMETHYST_ORE.get().defaultBlockState()),
                OreConfiguration.target(DEEPSLATE, ModBlocks.DEEPSLATE_AMETHYST_ORE.get().defaultBlockState()));
        NETHER_AMETHYST_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(NETHER, ModBlocks.NETHER_AMETHYST_ORE.get().defaultBlockState()));
        END_AMETHYST_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.END_AMETHYST_ORE.get().defaultBlockState()));

        BLACK_OPAL_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(STONE, ModBlocks.BLACK_OPAL_ORE.get().defaultBlockState()),
                OreConfiguration.target(DEEPSLATE, ModBlocks.DEEPSLATE_BLACK_OPAL_ORE.get().defaultBlockState()));
        NETHER_BLACK_OPAL_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(NETHER, ModBlocks.NETHER_BLACK_OPAL_ORE.get().defaultBlockState()));
        END_BLACK_OPAL_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.END_BLACK_OPAL_ORE.get().defaultBlockState()));

        AMETHYST_SMALL = buildConfigured(bootstrap, "ore_amethyst", AMETHYST_TARGET_BLOCKS, (OADConfig.amethyst_vein_size.get() / 2.0), OADConfig.overworld_discard_chance_on_air_exposure.get().floatValue() * 0.715F);
        BLACK_OPAL_SMALL = buildConfigured(bootstrap, "ore_black_opal", BLACK_OPAL_TARGET_BLOCKS, (OADConfig.black_opal_vein_size.get() / 2.0), OADConfig.overworld_discard_chance_on_air_exposure.get().floatValue() * 0.715F);

        AMETHYST_BURIED = buildConfigured(bootstrap, "ore_amethyst_buried", AMETHYST_TARGET_BLOCKS, OADConfig.amethyst_vein_size.get(), Math.min(1.0F, OADConfig.overworld_discard_chance_on_air_exposure.get().floatValue() * 1.43F));
        BLACK_OPAL_BURIED = buildConfigured(bootstrap, "ore_black_opal_buried", BLACK_OPAL_TARGET_BLOCKS, OADConfig.black_opal_vein_size.get(), Math.min(1.0F, OADConfig.overworld_discard_chance_on_air_exposure.get().floatValue() * 1.43F));

        AMETHYST_LARGE = buildConfigured(bootstrap, "ore_amethyst_large", AMETHYST_TARGET_BLOCKS, (OADConfig.amethyst_vein_size.get() * 1.5), OADConfig.overworld_discard_chance_on_air_exposure.get().floatValue());
        BLACK_OPAL_LARGE = buildConfigured(bootstrap, "ore_black_opal_large", BLACK_OPAL_TARGET_BLOCKS, (OADConfig.black_opal_vein_size.get() * 1.5), OADConfig.overworld_discard_chance_on_air_exposure.get().floatValue());

        int netherAmethystVeinSize = (int) Math.round(OADConfig.amethyst_vein_size.get() * OADConfig.nether_vein_multiplier.get());
        int netherBlackOpalVeinSize = (int) Math.round(OADConfig.black_opal_vein_size.get() * OADConfig.nether_vein_multiplier.get());

        NETHER_AMETHYST = buildConfigured(bootstrap, "ore_nether_amethyst", NETHER_AMETHYST_TARGET_BLOCKS, netherAmethystVeinSize, OADConfig.nether_discard_chance_on_air_exposure.get().floatValue());
        NETHER_BLACK_OPAL = buildConfigured(bootstrap, "ore_nether_black_opal", NETHER_BLACK_OPAL_TARGET_BLOCKS, netherBlackOpalVeinSize, OADConfig.nether_discard_chance_on_air_exposure.get().floatValue());

        int endAmethystVeinSize = (int) Math.round(OADConfig.amethyst_vein_size.get() * OADConfig.end_vein_multiplier.get());
        int endBlackOpalVeinSize = (int) Math.round(OADConfig.black_opal_vein_size.get() * OADConfig.end_vein_multiplier.get());

        END_AMETHYST = buildConfigured(bootstrap, "ore_end_amethyst", END_AMETHYST_TARGET_BLOCKS, endAmethystVeinSize, OADConfig.end_discard_chance_on_air_exposure.get().floatValue());
        END_BLACK_OPAL = buildConfigured(bootstrap, "ore_end_black_opal", END_BLACK_OPAL_TARGET_BLOCKS, endBlackOpalVeinSize, OADConfig.end_discard_chance_on_air_exposure.get().floatValue());
    }

    public static Holder.Reference<ConfiguredFeature<?, ?>> buildConfigured(BootstapContext<ConfiguredFeature<?, ?>> bootstrap, String name, ImmutableList<OreConfiguration.TargetBlockState> targets, double veinSize, float discardChance) {
        ResourceKey<ConfiguredFeature<?, ?>> resourceKey = FeatureUtils.createKey(OresAboveDiamonds.key(name));
        FeatureUtils.register(bootstrap, resourceKey, Feature.ORE, new OreConfiguration(targets, (int) Math.round(veinSize), discardChance));
        return bootstrap.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(resourceKey);
    }

}
