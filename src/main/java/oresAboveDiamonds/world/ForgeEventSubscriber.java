package oresAboveDiamonds.world;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import oresAboveDiamonds.OresAboveDiamonds;
import oresAboveDiamonds.config.OADConfig;

@EventBusSubscriber(modid = OresAboveDiamonds.MODID, bus = EventBusSubscriber.Bus.FORGE)
public class ForgeEventSubscriber {
	@SubscribeEvent(priority=EventPriority.HIGH)
 	public static void onBiomeLoading(BiomeLoadingEvent event) {
		if (event.getCategory() == Biome.Category.NETHER) {
			if(OADConfig.spawn_amethyst_nether.get() == true) {
				event.getGeneration().withFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.AMETHYST_NETHER);
			}
			if(OADConfig.spawn_black_opal_nether.get() == true) {
				event.getGeneration().withFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.BLACK_OPAL_NETHER);
			}
		} else if(event.getCategory() == Biome.Category.THEEND) {
			/*if(OADConfig.spawn_amethyst_end.get() == true) {
				event.getGeneration().withFeature(Decoration.UNDERGROUND_ORES, OreGeneration.AMETHYST_END);
			}
			if(OADConfig.spawn_black_opal_end.get() == true) {
				event.getGeneration().withFeature(Decoration.UNDERGROUND_ORES, OreGeneration.BLACK_OPAL_END);
			}*/
		} else {
			if(OADConfig.spawn_amethyst_overworld.get() == true) {
				event.getGeneration().withFeature(Decoration.UNDERGROUND_ORES, OreGeneration.AMETHYST_OVERWORLD);
			}
			if(OADConfig.spawn_black_opal_overworld.get() == true ) {
				event.getGeneration().withFeature(Decoration.UNDERGROUND_ORES, OreGeneration.BLACK_OPAL_OVERWORLD);
			}
		}
	}
}
