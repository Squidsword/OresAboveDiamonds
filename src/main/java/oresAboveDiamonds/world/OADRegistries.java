package oresAboveDiamonds.world;

// Reference: Randomite 1.19.3 by Modding Legacy

import net.minecraft.Util;
import net.minecraft.core.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import oresAboveDiamonds.OresAboveDiamonds;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = OresAboveDiamonds.MODID, bus = EventBusSubscriber.Bus.MOD)
public class OADRegistries {
    private static final RegistrySetBuilder BUILDER = (new RegistrySetBuilder()).add(Registries.CONFIGURED_FEATURE, OADConfiguredFeature::bootstrap);

    public static HolderLookup.Provider createLookup() {
        RegistryAccess.Frozen registryaccess$frozen = RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY);
        HolderLookup.Provider holderlookup$provider = BUILDER.build(registryaccess$frozen);
        validateThatAllBiomeFeaturesHaveBiomeFilter(holderlookup$provider);
        return holderlookup$provider;
    }
    private static void validateThatAllBiomeFeaturesHaveBiomeFilter(HolderLookup.Provider p_256242_) {
        HolderGetter<PlacedFeature> holdergetter = p_256242_.lookupOrThrow(Registries.PLACED_FEATURE);
        p_256242_.lookupOrThrow(Registries.BIOME).listElements().forEach((p_256326_) -> {
            ResourceLocation resourcelocation = p_256326_.key().location();
            List<HolderSet<PlacedFeature>> list = p_256326_.value().getGenerationSettings().features();
            list.stream().flatMap(HolderSet::stream).forEach((p_256657_) -> {
                p_256657_.unwrap().ifLeft((p_256188_) -> {
                    Holder.Reference<PlacedFeature> reference = holdergetter.getOrThrow(p_256188_);
                    if (!validatePlacedFeature(reference.value())) {
                        Util.logAndPauseIfInIde("Placed feature " + p_256188_.location() + " in biome " + resourcelocation + " is missing BiomeFilter.biome()");
                    }

                }).ifRight((p_256575_) -> {
                    if (!validatePlacedFeature(p_256575_)) {
                        Util.logAndPauseIfInIde("Placed inline feature in biome " + p_256326_ + " is missing BiomeFilter.biome()");
                    }

                });
            });
        });
    }

    private static boolean validatePlacedFeature(PlacedFeature p_255656_) {
        return p_255656_.placement().contains(BiomeFilter.biome());
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        gen.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(gen.getPackOutput(),
                new CompletableFuture<>(), BUILDER, new HashSet(List.of(OresAboveDiamonds.MODID))));

    }
}
