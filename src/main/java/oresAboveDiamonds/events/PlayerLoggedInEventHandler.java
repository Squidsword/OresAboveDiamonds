package oresAboveDiamonds.events;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.network.OADPacketHandler;
import oresAboveDiamonds.network.PacketSyncConfig;

public class PlayerLoggedInEventHandler {
	
	@SubscribeEvent
	public void onLoginEvent(PlayerLoggedInEvent event) {
		EntityPlayerMP player = (EntityPlayerMP) event.player;
		
		if(OADConfig.zzy_send_config_packet == true) {
		OADPacketHandler.INSTANCE.sendTo(new PacketSyncConfig(), player);
		}
	}	
}
