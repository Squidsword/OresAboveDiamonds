package oresAboveDiamonds;

import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.world.OADPlacedFeature;

@EventBusSubscriber(modid = OresAboveDiamonds.MODID, bus = EventBusSubscriber.Bus.FORGE)
public class ForgeEventSubscriber {
	@SubscribeEvent(priority=EventPriority.HIGH)
 	public static void onBiomeLoading(BiomeLoadingEvent event) {
		if (event.getCategory() == Biome.BiomeCategory.NETHER) {
			if(OADConfig.spawn_amethyst_nether.get()) {
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.NETHER_AMETHYST_PLACED[0].value()));
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.NETHER_AMETHYST_PLACED[1].value()));
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.NETHER_AMETHYST_PLACED[2].value()));
			}
			if(OADConfig.spawn_black_opal_nether.get()) {
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.NETHER_BLACK_OPAL_PLACED[0].value()));
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.NETHER_BLACK_OPAL_PLACED[1].value()));
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.NETHER_BLACK_OPAL_PLACED[2].value()));

			}
		} else if(event.getCategory() == Biome.BiomeCategory.THEEND) {
			if(OADConfig.spawn_amethyst_end.get()) {
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.END_AMETHYST_PLACED[0].value()));
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.END_AMETHYST_PLACED[1].value()));
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.END_AMETHYST_PLACED[2].value()));
			}
			if(OADConfig.spawn_black_opal_end.get()) {
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.END_BLACK_OPAL_PLACED[0].value()));
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.END_BLACK_OPAL_PLACED[1].value()));
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.END_BLACK_OPAL_PLACED[2].value()));
			}
		} else {
			if(OADConfig.spawn_amethyst_overworld.get()) {
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.AMETHYST_SMALL_PLACED[0].value()));
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.AMETHYST_SMALL_PLACED[1].value()));
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.AMETHYST_SMALL_PLACED[2].value()));
				
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.AMETHYST_LARGE_PLACED[0].value()));
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.AMETHYST_LARGE_PLACED[1].value()));
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.AMETHYST_LARGE_PLACED[2].value()));
				
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.AMETHYST_BURIED_PLACED[0].value()));
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.AMETHYST_BURIED_PLACED[1].value()));
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.AMETHYST_BURIED_PLACED[2].value()));

			}
			if(OADConfig.spawn_black_opal_overworld.get()) {
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.BLACK_OPAL_SMALL_PLACED[0].value()));
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.BLACK_OPAL_SMALL_PLACED[1].value()));
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.BLACK_OPAL_SMALL_PLACED[2].value()));
					
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.BLACK_OPAL_LARGE_PLACED[0].value()));
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.BLACK_OPAL_LARGE_PLACED[1].value()));
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.BLACK_OPAL_LARGE_PLACED[2].value()));
					
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.BLACK_OPAL_BURIED_PLACED[0].value()));
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.BLACK_OPAL_BURIED_PLACED[1].value()));
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(Holder.direct(OADPlacedFeature.BLACK_OPAL_BURIED_PLACED[2].value()));
			}
		}
	}
}
