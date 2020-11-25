package oresAboveDiamonds;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import oresAboveDiamonds.events.AnvilUpdateEventHandler;
import oresAboveDiamonds.events.PlayerLoggedInEventHandler;
import oresAboveDiamonds.init.ModRecipes;
import oresAboveDiamonds.proxy.CommonProxy;
import oresAboveDiamonds.tabs.OresAboveDiamondsTab;
import oresAboveDiamonds.util.OreDictionaryCompat;
import oresAboveDiamonds.util.Reference;
import oresAboveDiamonds.world.OreGenerator;
import oresAboveDiamonds.world.WorldTickHandler;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

	@Instance
	public static Main instance;
	
	public static final CreativeTabs oresabovediamondstab = new OresAboveDiamondsTab("oresabovediamondstab");

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {

		GameRegistry.registerWorldGenerator(new OreGenerator(), 10);
		MinecraftForge.EVENT_BUS.register(OreGenerator.instance);
		MinecraftForge.EVENT_BUS.register(new AnvilUpdateEventHandler());
		MinecraftForge.EVENT_BUS.register(new PlayerLoggedInEventHandler());
		proxy.preInit(event);
	}

	@EventHandler
	public static void init(FMLInitializationEvent event) {
		ModRecipes.init();
		OreDictionaryCompat.registerOres();
		MinecraftForge.EVENT_BUS.register(WorldTickHandler.instance);
		proxy.init(event);
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}

}
