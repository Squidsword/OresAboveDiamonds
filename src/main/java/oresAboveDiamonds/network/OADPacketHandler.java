package oresAboveDiamonds.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fmllegacy.network.NetworkRegistry;
import net.minecraftforge.fmllegacy.network.simple.SimpleChannel;

public class OADPacketHandler  {
	
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
	    new ResourceLocation("oresabovediamonds", "main"),
	    () -> PROTOCOL_VERSION,
	    PROTOCOL_VERSION::equals,
	    PROTOCOL_VERSION::equals
	);
	
    public static void registerMessages() {
    	int id = 0;  	
    	INSTANCE.registerMessage(id++, PacketSyncConfig.class, PacketSyncConfig::encode, PacketSyncConfig::decode, PacketSyncConfig::handle);
    }
}
