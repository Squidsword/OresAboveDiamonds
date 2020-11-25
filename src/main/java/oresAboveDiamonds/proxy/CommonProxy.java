package oresAboveDiamonds.proxy;

import com.google.common.util.concurrent.ListenableFuture;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import oresAboveDiamonds.init.ModBlocks;
import oresAboveDiamonds.init.ModItems;
import oresAboveDiamonds.network.OADPacketHandler;

@EventBusSubscriber
public class CommonProxy {
	public void registerItemRenderer(Item item, int meta, String id) {
		
	}
	
    public void preInit(FMLPreInitializationEvent event) {
    	OADPacketHandler.registerMessages("oresabovediamonds");
    }
	public void init(FMLInitializationEvent event) {
		
	}

	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
		
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
		
	}
	
	
    public ListenableFuture<Object> addScheduledTaskClient(Runnable runnableToSchedule) {
        throw new IllegalStateException("This should only be called from client side");
    }
	
    public EntityPlayer getClientPlayer() {
        throw new IllegalStateException("This should only be called from client side");
    }
}
