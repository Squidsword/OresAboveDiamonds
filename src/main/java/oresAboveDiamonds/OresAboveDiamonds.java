package oresAboveDiamonds;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.events.LootTableHandler;
import oresAboveDiamonds.events.PlayerLoggedInEventHandler;
import oresAboveDiamonds.init.ModBlocks;
import oresAboveDiamonds.init.ModItemGroups;
import oresAboveDiamonds.init.ModItems;
import oresAboveDiamonds.network.OADPacketHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(OresAboveDiamonds.MODID)
public class OresAboveDiamonds {
	public static final Logger LOGGER = LogManager.getLogger("oresabovediamonds");
	public static final String MODID = "oresabovediamonds";

	public static OresAboveDiamonds instance;

	public OresAboveDiamonds() {
		instance = this;

		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

		OADConfig.loadConfig(OADConfig.SPEC, FMLPaths.CONFIGDIR.get().resolve("ores_above_diamonds_1.19.toml"));
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, OADConfig.SPEC);

		OADPacketHandler.registerMessages();

		ModItems.ITEMS.register(modEventBus);
		ModBlocks.BLOCKS.register(modEventBus);
		ModItemGroups.TABS.register(modEventBus);

		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new PlayerLoggedInEventHandler());
		MinecraftForge.EVENT_BUS.register(LootTableHandler.class);
		MinecraftForge.EVENT_BUS.register(ModItemGroups.class);
	}

	public static String key(String name) {
		return OresAboveDiamonds.MODID + ":" + name;
	}

	public void setup(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {

		});
	}
	
}
