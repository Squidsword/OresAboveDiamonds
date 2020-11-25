package oresAboveDiamonds.OresMod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
//import oresAboveDiamonds.OresMod.config.ConfigValues;
import oresAboveDiamonds.OresMod.config.OresAboveDiamondsConfig;
import oresAboveDiamonds.OresMod.items.CustomArmorItem;
import oresAboveDiamonds.OresMod.items.CustomAxeItem;
import oresAboveDiamonds.OresMod.items.CustomHoeItem;
import oresAboveDiamonds.OresMod.items.CustomPickaxeItem;
import oresAboveDiamonds.OresMod.items.CustomShovelItem;
import oresAboveDiamonds.OresMod.items.CustomSwordItem;
//import oresAboveDiamonds.OresMod.lists.Amethyst_Ore_Settings;
import oresAboveDiamonds.OresMod.lists.ArmorMaterialList;
//import oresAboveDiamonds.OresMod.lists.Black_Opal_Ore_Settings;
import oresAboveDiamonds.OresMod.lists.BlockList;
import oresAboveDiamonds.OresMod.lists.ItemList;
import oresAboveDiamonds.OresMod.lists.ToolMaterialList;
//import oresAboveDiamonds.OresMod.lists.OresItemGroup;
import oresAboveDiamonds.OresMod.world.OreGeneration;


@Mod("oresabovediamonds")
public class OresAboveDiamonds 
{
	public static OresAboveDiamonds instance;
	public static final String modid = "oresabovediamonds";
	public static final Logger logger = LogManager.getLogger(modid);
	
	public OresAboveDiamonds() 
	{
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
		
		OresAboveDiamondsConfig.loadConfig(OresAboveDiamondsConfig.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("ores_above_diamonds.toml"));
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		OreGeneration.setupOreGeneration();
		logger.info("Setup method registered.");
		
	}
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		logger.info("clientRegistries method registered.");
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
			
			logger.info("Blocks registered.");
		}
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll
			(		
			ItemList.black_opal = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("black_opal")),
			ItemList.amethyst = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("amethyst")),
			
			ItemList.amethyst_sword = new CustomSwordItem(ToolMaterialList.amethyst, 3, -2.4f, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("amethyst_sword")),
			ItemList.amethyst_pickaxe = new CustomPickaxeItem(ToolMaterialList.amethyst, 1, -2.8f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("amethyst_pickaxe")),
			ItemList.amethyst_shovel = new CustomShovelItem(ToolMaterialList.amethyst, 2, -3f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("amethyst_shovel")),
			ItemList.amethyst_axe = new CustomAxeItem(ToolMaterialList.amethyst, 5, -3f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("amethyst_axe")),
			ItemList.amethyst_hoe = new CustomHoeItem(ToolMaterialList.amethyst, 1f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("amethyst_hoe")),
			
			ItemList.black_opal_sword = new CustomSwordItem(ToolMaterialList.black_opal, 3, -2.4f, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("black_opal_sword")),
			ItemList.black_opal_pickaxe = new CustomPickaxeItem(ToolMaterialList.black_opal, 1, -2.8f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("black_opal_pickaxe")),
			ItemList.black_opal_shovel = new CustomShovelItem(ToolMaterialList.black_opal, 2, -3f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("black_opal_shovel")),
			ItemList.black_opal_axe = new CustomAxeItem(ToolMaterialList.black_opal, 5, -3f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("black_opal_axe")),
			ItemList.black_opal_hoe = new CustomHoeItem(ToolMaterialList.black_opal, 2f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("black_opal_hoe")),
			
			ItemList.amethyst_helmet = new CustomArmorItem(ArmorMaterialList.amethyst, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("amethyst_helmet")),
			ItemList.amethyst_chestplate = new CustomArmorItem(ArmorMaterialList.amethyst, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("amethyst_chestplate")),
			ItemList.amethyst_leggings = new CustomArmorItem(ArmorMaterialList.amethyst, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("amethyst_leggings")),
			ItemList.amethyst_boots = new CustomArmorItem(ArmorMaterialList.amethyst, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("amethyst_boots")),
			
			ItemList.black_opal_helmet = new CustomArmorItem(ArmorMaterialList.black_opal, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("black_opal_helmet")),
			ItemList.black_opal_chestplate = new CustomArmorItem(ArmorMaterialList.black_opal, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("black_opal_chestplate")),
			ItemList.black_opal_leggings = new CustomArmorItem(ArmorMaterialList.black_opal, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("black_opal_leggings")),
			ItemList.black_opal_boots = new CustomArmorItem(ArmorMaterialList.black_opal, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("black_opal_boots")),
			
			ItemList.amethyst_ore = new BlockItem(BlockList.amethyst_ore, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.amethyst_ore.getRegistryName()),
			ItemList.nether_amethyst_ore = new BlockItem(BlockList.nether_amethyst_ore, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.nether_amethyst_ore.getRegistryName()),
			ItemList.end_amethyst_ore = new BlockItem(BlockList.end_amethyst_ore, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.end_amethyst_ore.getRegistryName()),
			ItemList.black_opal_ore = new BlockItem(BlockList.black_opal_ore, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.black_opal_ore.getRegistryName()),
			ItemList.nether_black_opal_ore = new BlockItem(BlockList.nether_black_opal_ore, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.nether_black_opal_ore.getRegistryName()),
			ItemList.end_black_opal_ore = new BlockItem(BlockList.end_black_opal_ore, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.end_black_opal_ore.getRegistryName()),

			ItemList.black_opal_block = new BlockItem(BlockList.black_opal_block, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.black_opal_block.getRegistryName()),
			ItemList.amethyst_block = new BlockItem(BlockList.amethyst_block, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.amethyst_block.getRegistryName())
			);
		}
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid, name);
		}
		@SubscribeEvent
		public void onServerStart(FMLServerStartingEvent event)
		{
			logger.info("Ores Above Diamonds server starting.");
		}
	}
}
