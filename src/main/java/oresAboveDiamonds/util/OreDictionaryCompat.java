package oresAboveDiamonds.util;

import net.minecraftforge.oredict.OreDictionary;
import oresAboveDiamonds.init.ModBlocks;
import oresAboveDiamonds.init.ModItems;

public class OreDictionaryCompat {
	
	public static void registerOres()
	{
		OreDictionary.registerOre("oreAmethyst", ModBlocks.AMETHYST_ORE);
		OreDictionary.registerOre("oreBlackOpal", ModBlocks.BLACK_OPAL_ORE);
		OreDictionary.registerOre("oreAmethyst", ModBlocks.NETHER_AMETHYST_ORE);
		OreDictionary.registerOre("oreBlackOpal", ModBlocks.NETHER_BLACK_OPAL_ORE);
		OreDictionary.registerOre("oreAmethyst", ModBlocks.END_AMETHYST_ORE);
		OreDictionary.registerOre("oreBlackOpal", ModBlocks.END_BLACK_OPAL_ORE);
		OreDictionary.registerOre("blockAmethyst", ModBlocks.AMETHYST_BLOCK);
		OreDictionary.registerOre("blockBlackOpal", ModBlocks.BLACK_OPAL_BLOCK);
		OreDictionary.registerOre("gemAmethyst", ModItems.AMETHYST);
		OreDictionary.registerOre("gemBlackOpal", ModItems.BLACK_OPAL);
		OreDictionary.registerOre("amethyst", ModItems.AMETHYST);
		OreDictionary.registerOre("blackOpal", ModItems.BLACK_OPAL);
		OreDictionary.registerOre("Amethyst", ModItems.AMETHYST);
		OreDictionary.registerOre("BlackOpal", ModItems.BLACK_OPAL);
	}
	
}
