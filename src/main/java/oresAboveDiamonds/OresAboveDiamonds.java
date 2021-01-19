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
		ConfigHelper.loadConfig(ConfigHelper.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("ores_above_diamonds-1.16.4.toml"));
		
		ModItems.ITEMS.register(modEventBus);
		ModBlocks.BLOCKS.register(modEventBus);
	}
	
	public void setup(final FMLCommonSetupEvent event)
	{
		event.enqueueWork(() -> {
			OreGeneration.registerConfiguredFeatures();
		});
		
	}
	/*
	public void clientRegistries(final FMLClientSetupEvent event)
	{
		LOGGER.info("clientRegistries method registered.");
	}

	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll
			(		
					BlockList.amethyst_ore.setRegistryName(location("amethyst_ore")),
					BlockList.black_opal_ore.setRegistryName(location("black_opal_ore")),
					BlockList.amethyst_block.setRegistryName(location("amethyst_block")),
					BlockList.black_opal_block.setRegistryName(location("black_opal_block")),
					
					BlockList.nether_amethyst_ore.setRegistryName(location("nether_amethyst_ore")),
					BlockList.end_amethyst_ore.setRegistryName(location("end_amethyst_ore")),
					
					BlockList.nether_black_opal_ore.setRegistryName(location("nether_black_opal_ore")),
					BlockList.end_black_opal_ore.setRegistryName(location("end_black_opal_ore"))
					
			);
		}
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			
			int axedmg;
			int shoveldmg;
			int pickdmg;
			
			if(OADConfig.old_combat_mechanics.get() == true) {
				axedmg = 2;
				pickdmg = 1;
				shoveldmg = 0;
			} else {
				axedmg = 5;
				pickdmg = 1;
				shoveldmg = 2;
			}
			
			event.getRegistry().registerAll
			(		
			ItemList.black_opal = new Item(new Item.Properties().group(ItemGroup.MISC).group(OAD)).setRegistryName(location("black_opal")),
			ItemList.amethyst = new Item(new Item.Properties().group(ItemGroup.MISC).group(OAD)).setRegistryName(location("amethyst")),
			
			ItemList.amethyst_sword = new CustomSwordItem(ToolMaterialList.AMETHYST, 3, -2.4f, new Item.Properties().group(ItemGroup.COMBAT).group(OAD)).setRegistryName(location("amethyst_sword")),
			ItemList.amethyst_pickaxe = new CustomPickaxeItem(ToolMaterialList.AMETHYST, pickdmg, -2.8f, new Item.Properties().group(ItemGroup.TOOLS).group(OAD)).setRegistryName(location("amethyst_pickaxe")),
			ItemList.amethyst_shovel = new CustomShovelItem(ToolMaterialList.AMETHYST, shoveldmg, -3f, new Item.Properties().group(ItemGroup.TOOLS).group(OAD)).setRegistryName(location("amethyst_shovel")),
			ItemList.amethyst_axe = new CustomAxeItem(ToolMaterialList.AMETHYST, axedmg, -3f, new Item.Properties().group(ItemGroup.TOOLS).group(OAD)).setRegistryName(location("amethyst_axe")),
			ItemList.amethyst_hoe = new CustomHoeItem(ToolMaterialList.AMETHYST, -4, 1f, new Item.Properties().group(ItemGroup.TOOLS).group(OAD)).setRegistryName(location("amethyst_hoe")),
			
			ItemList.black_opal_sword = new CustomSwordItem(ToolMaterialList.BLACK_OPAL, 3, -2.4f, new Item.Properties().group(ItemGroup.COMBAT).group(OAD)).setRegistryName(location("black_opal_sword")),
			ItemList.black_opal_pickaxe = new CustomPickaxeItem(ToolMaterialList.BLACK_OPAL, pickdmg, -2.8f, new Item.Properties().group(ItemGroup.TOOLS).group(OAD)).setRegistryName(location("black_opal_pickaxe")),
			ItemList.black_opal_shovel = new CustomShovelItem(ToolMaterialList.BLACK_OPAL, shoveldmg, -3f, new Item.Properties().group(ItemGroup.TOOLS).group(OAD)).setRegistryName(location("black_opal_shovel")),
			ItemList.black_opal_axe = new CustomAxeItem(ToolMaterialList.BLACK_OPAL, axedmg, -3f, new Item.Properties().group(ItemGroup.TOOLS).group(OAD)).setRegistryName(location("black_opal_axe")),
			ItemList.black_opal_hoe = new CustomHoeItem(ToolMaterialList.BLACK_OPAL, -5, 2f, new Item.Properties().group(ItemGroup.TOOLS).group(OAD)).setRegistryName(location("black_opal_hoe")),
			
			ItemList.netherite_opal_sword = new CustomSwordItem(ToolMaterialList.NETHERITE_OPAL, 3, -2.4f, new Item.Properties().group(ItemGroup.COMBAT).group(OAD).isImmuneToFire()).setRegistryName(location("netherite_opal_sword")),
			ItemList.netherite_opal_pickaxe = new CustomPickaxeItem(ToolMaterialList.NETHERITE_OPAL, pickdmg, -2.8f, new Item.Properties().group(ItemGroup.TOOLS).group(OAD).isImmuneToFire()).setRegistryName(location("netherite_opal_pickaxe")),
			ItemList.netherite_opal_shovel = new CustomShovelItem(ToolMaterialList.NETHERITE_OPAL, shoveldmg, -3f, new Item.Properties().group(ItemGroup.TOOLS).group(OAD).isImmuneToFire()).setRegistryName(location("netherite_opal_shovel")),
			ItemList.netherite_opal_axe = new CustomAxeItem(ToolMaterialList.NETHERITE_OPAL, axedmg, -3f, new Item.Properties().group(ItemGroup.TOOLS).group(OAD).isImmuneToFire()).setRegistryName(location("netherite_opal_axe")),
			ItemList.netherite_opal_hoe = new CustomHoeItem(ToolMaterialList.NETHERITE_OPAL, -6, 2f, new Item.Properties().group(ItemGroup.TOOLS).group(OAD).isImmuneToFire()).setRegistryName(location("netherite_opal_hoe")),
			
			ItemList.amethyst_helmet = new CustomArmorItem(ArmorMaterialList.amethyst, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT).group(OAD)).setRegistryName(location("amethyst_helmet")),
			ItemList.amethyst_chestplate = new CustomArmorItem(ArmorMaterialList.amethyst, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT).group(OAD)).setRegistryName(location("amethyst_chestplate")),
			ItemList.amethyst_leggings = new CustomArmorItem(ArmorMaterialList.amethyst, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT).group(OAD)).setRegistryName(location("amethyst_leggings")),
			ItemList.amethyst_boots = new CustomArmorItem(ArmorMaterialList.amethyst, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT).group(OAD)).setRegistryName(location("amethyst_boots")),
			
			ItemList.black_opal_helmet = new CustomArmorItem(ArmorMaterialList.black_opal, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT).group(OAD)).setRegistryName(location("black_opal_helmet")),
			ItemList.black_opal_chestplate = new CustomArmorItem(ArmorMaterialList.black_opal, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT).group(OAD)).setRegistryName(location("black_opal_chestplate")),
			ItemList.black_opal_leggings = new CustomArmorItem(ArmorMaterialList.black_opal, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT).group(OAD)).setRegistryName(location("black_opal_leggings")),
			ItemList.black_opal_boots = new CustomArmorItem(ArmorMaterialList.black_opal, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT).group(OAD)).setRegistryName(location("black_opal_boots")),
			
			ItemList.netherite_opal_helmet = new CustomArmorItem(ArmorMaterialList.netherite_opal, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT).group(OAD).isImmuneToFire()).setRegistryName(location("netherite_opal_helmet")),
			ItemList.netherite_opal_chestplate = new CustomArmorItem(ArmorMaterialList.netherite_opal, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT).group(OAD).isImmuneToFire()).setRegistryName(location("netherite_opal_chestplate")),
			ItemList.netherite_opal_leggings = new CustomArmorItem(ArmorMaterialList.netherite_opal, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT).group(OAD).isImmuneToFire()).setRegistryName(location("netherite_opal_leggings")),
			ItemList.netherite_opal_boots = new CustomArmorItem(ArmorMaterialList.netherite_opal, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT).group(OAD).isImmuneToFire()).setRegistryName(location("netherite_opal_boots")),
			
			ItemList.amethyst_ore = new TooltipBlockItem(BlockList.amethyst_ore, new Item.Properties().group(ItemGroup.MISC).group(OAD)).setRegistryName(location("amethyst_ore")),
			ItemList.nether_amethyst_ore = new TooltipBlockItem(BlockList.nether_amethyst_ore, new Item.Properties().group(ItemGroup.MISC).group(OAD)).setRegistryName(location("nether_amethyst_ore")),
			ItemList.end_amethyst_ore = new TooltipBlockItem(BlockList.end_amethyst_ore, new Item.Properties().group(ItemGroup.MISC).group(OAD)).setRegistryName(location("end_amethyst_ore")),
			ItemList.black_opal_ore = new TooltipBlockItem(BlockList.black_opal_ore, new Item.Properties().group(ItemGroup.MISC).group(OAD)).setRegistryName(location("black_opal_ore")),
			ItemList.nether_black_opal_ore = new TooltipBlockItem(BlockList.nether_black_opal_ore, new Item.Properties().group(ItemGroup.MISC).group(OAD)).setRegistryName(location("nether_black_opal_ore")),
			ItemList.end_black_opal_ore = new TooltipBlockItem(BlockList.end_black_opal_ore, new Item.Properties().group(ItemGroup.MISC).group(OAD)).setRegistryName(location("end_black_opal_ore")),

			ItemList.black_opal_block = new BlockItem(BlockList.black_opal_block, new Item.Properties().group(ItemGroup.MISC).group(OAD)).setRegistryName(BlockList.black_opal_block.getRegistryName()),
			ItemList.amethyst_block = new BlockItem(BlockList.amethyst_block, new Item.Properties().group(ItemGroup.MISC).group(OAD)).setRegistryName(BlockList.amethyst_block.getRegistryName())
			);
		}
	}	
	*/
}
