package oresAboveDiamonds.events;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import oresAboveDiamonds.commands.CommandConfigChange;

@Mod.EventBusSubscriber(modid = "oresabovediamonds")
public class ServerStartEventHandler {
	
	@SubscribeEvent
	public static void onServerStart(final FMLServerStartingEvent event)
	{
		CommandConfigChange.register(event.getCommandDispatcher());
	}
	
}
