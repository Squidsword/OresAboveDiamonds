package oresAboveDiamonds;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import oresAboveDiamonds.config.ConfigHelper;
import oresAboveDiamonds.events.AnvilUpdateEventHandler;
import oresAboveDiamonds.events.LootTableHandler;
import oresAboveDiamonds.events.PlayerLoggedInEventHandler;
import oresAboveDiamonds.init.ModBlocks;
import oresAboveDiamonds.init.ModItems;
import oresAboveDiamonds.network.OADPacketHandler;
import oresAboveDiamonds.world.OreGeneration;


@Mod(OresAboveDiamonds.MODID)
public class OresAboveDiamonds 
{
	public static final Logger LOGGER = LogManager.getLogger("oresabovediamonds");
	public static final String MODID = "oresabovediamonds";
	
	public static OresAboveDiamonds instance;
	
	public OresAboveDiamonds() 
	{
		instance = this;
		
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		//FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new AnvilUpdateEventHandler());
		MinecraftForge.EVENT_BUS.register(new PlayerLoggedInEventHandler());
		MinecraftForge.EVENT_BUS.register(new LootTableHandler());
		MinecraftForge.EVENT_BUS.addListener(LootTableHandler::lootLoad);
		
		
		OADPacketHandler.registerMessages();
		ConfigHelper.loadConfig(ConfigHelper.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("ores_above_diamonds-1.17.1.toml"));
		
		ModItems.ITEMS.register(modEventBus);
		ModBlocks.BLOCKS.register(modEventBus);
	}
	
	public void setup(final FMLCommonSetupEvent event)
	{
		event.enqueueWork(() -> {
			OreGeneration.registerConfiguredFeatures();
		});
		
	}
}
