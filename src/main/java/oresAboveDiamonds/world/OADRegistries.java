package oresAboveDiamonds.world;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import oresAboveDiamonds.OresAboveDiamonds;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CompletableFuture;

// Run runData to generate the appropriate JSON files
@EventBusSubscriber(modid = OresAboveDiamonds.MODID, bus = Bus.MOD)
public class OADRegistries {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.CONFIGURED_FEATURE, OADConfiguredFeature::bootstrap).add(Registries.PLACED_FEATURE, OADPlacedFeature::bootstrap);

    public static HolderLookup.Provider createLookup() {
        RegistryAccess.Frozen registryaccess$frozen = RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY);
        HolderLookup.Provider holderlookup$provider = BUILDER.build(registryaccess$frozen);
        return holderlookup$provider;
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator gen = event.getGenerator();
        gen.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(gen.getPackOutput(), CompletableFuture.completedFuture(createLookup()), BUILDER, new HashSet<>(List.of(OresAboveDiamonds.MODID))));
    }
}