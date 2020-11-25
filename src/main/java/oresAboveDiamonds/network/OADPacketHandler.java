package oresAboveDiamonds.network;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class OADPacketHandler {
	public static SimpleNetworkWrapper INSTANCE;

    private static int ID = 0;
    private static int nextID() {
        return ID++;
    }
    
    public static void registerMessages(String channelName) {
        INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(channelName);

        // Server side

        // Client side
        INSTANCE.registerMessage(PacketSyncConfig.Handler.class, PacketSyncConfig.class, nextID(), Side.CLIENT);
    }
}
