package oresAboveDiamonds;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.world.OreGeneration;

@EventBusSubscriber(modid = OresAboveDiamonds.MODID, bus = EventBusSubscriber.Bus.FORGE)
public class ForgeEventSubscriber {
	@SubscribeEvent(priority=EventPriority.HIGH)
 	public static void onBiomeLoading(BiomeLoadingEvent event) {
		if (event.getCategory() == Biome.BiomeCategory.NETHER) {
			if(OADConfig.spawn_amethyst_nether.get() == true) {
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.NETHER_AMETHYST_PLACED[0]);
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.NETHER_AMETHYST_PLACED[1]);
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.NETHER_AMETHYST_PLACED[2]);
			}
			if(OADConfig.spawn_black_opal_nether.get() == true) {
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.NETHER_BLACK_OPAL_PLACED[0]);
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.NETHER_BLACK_OPAL_PLACED[1]);
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.NETHER_BLACK_OPAL_PLACED[2]);

			}
		} else if(event.getCategory() == Biome.BiomeCategory.THEEND) {
			if(OADConfig.spawn_amethyst_end.get() == true) {
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.END_AMETHYST_PLACED[0]);
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.END_AMETHYST_PLACED[1]);
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.END_AMETHYST_PLACED[2]);
			}
			if(OADConfig.spawn_black_opal_end.get() == true) {
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.END_BLACK_OPAL_PLACED[0]);
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.END_BLACK_OPAL_PLACED[1]);
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.END_BLACK_OPAL_PLACED[2]);
			}
		} else {
			if(OADConfig.spawn_amethyst_overworld.get() == true) {
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.AMETHYST_SMALL_PLACED[0]);
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.AMETHYST_SMALL_PLACED[1]);
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.AMETHYST_SMALL_PLACED[2]);
				
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.AMETHYST_LARGE_PLACED[0]);
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.AMETHYST_LARGE_PLACED[1]);
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.AMETHYST_LARGE_PLACED[2]);
				
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.AMETHYST_BURIED_PLACED[0]);
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.AMETHYST_BURIED_PLACED[1]);
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.AMETHYST_BURIED_PLACED[2]);

			}
			if(OADConfig.spawn_black_opal_overworld.get() == true ) {
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.BLACK_OPAL_SMALL_PLACED[0]);
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.BLACK_OPAL_SMALL_PLACED[1]);
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.BLACK_OPAL_SMALL_PLACED[2]);
					
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.BLACK_OPAL_LARGE_PLACED[0]);
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.BLACK_OPAL_LARGE_PLACED[1]);
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.BLACK_OPAL_LARGE_PLACED[2]);
					
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.BLACK_OPAL_BURIED_PLACED[0]);
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.BLACK_OPAL_BURIED_PLACED[1]);
				event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> OreGeneration.BLACK_OPAL_BURIED_PLACED[2]);
			}
		}
	}
}
