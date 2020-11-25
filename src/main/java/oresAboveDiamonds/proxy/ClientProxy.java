package oresAboveDiamonds.proxy;

import com.google.common.util.concurrent.ListenableFuture;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import oresAboveDiamonds.init.ModBlocks;
import oresAboveDiamonds.init.ModItems;
import oresAboveDiamonds.util.IHasModel;

@EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
    public void preInit(FMLPreInitializationEvent event) {
       super.preInit(event);
    }
	
    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
    
    }
    
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
	
		for(Item item : ModItems.ITEMS) {
			
			if(item instanceof IHasModel) {
				
				((IHasModel)item).registerModels();
				
			}
		}
		
		for(Block block : ModBlocks.BLOCKS) {
			
			if(block instanceof IHasModel) {
				
				((IHasModel)block).registerModels();
				
			}
		}
		
	}
    
    public ListenableFuture<Object> addScheduledTaskClient(Runnable runnableToSchedule) {
        return Minecraft.getMinecraft().addScheduledTask(runnableToSchedule);
    }

    public EntityPlayer getClientPlayer() {
        return Minecraft.getMinecraft().player;
    }
}
