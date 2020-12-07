package oresAboveDiamonds.world;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import oresAboveDiamonds.OresAboveDiamonds;

@EventBusSubscriber(modid = OresAboveDiamonds.MODID, bus = EventBusSubscriber.Bus.FORGE)
public class ForgeEventSubscriber {
	@SubscribeEvent(priority=EventPriority.HIGH)
    public static void onBiomeLoading(BiomeLoadingEvent event)
    {    
            OreGeneration.generateOres(event);
    }
}
