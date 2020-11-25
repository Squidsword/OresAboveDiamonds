package oresAboveDiamonds.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import oresAboveDiamonds.blocks.Amethyst_Block_Settings;
import oresAboveDiamonds.blocks.Amethyst_Ore_Settings;
import oresAboveDiamonds.blocks.Black_Opal_Block_Settings;
import oresAboveDiamonds.blocks.Black_Opal_Ore_Settings;

public class ModBlocks {
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	public static final Block AMETHYST_BLOCK = new Amethyst_Block_Settings("amethyst_block", Material.IRON);
	public static final Block BLACK_OPAL_BLOCK = new Black_Opal_Block_Settings("black_opal_block", Material.IRON);
	
	public static final Block AMETHYST_ORE = new Amethyst_Ore_Settings("amethyst_ore", Material.ROCK);
	public static final Block BLACK_OPAL_ORE = new Black_Opal_Ore_Settings("black_opal_ore", Material.ROCK);
	
	public static final Block NETHER_AMETHYST_ORE = new Amethyst_Ore_Settings("nether_amethyst_ore", Material.ROCK);
	public static final Block NETHER_BLACK_OPAL_ORE = new Black_Opal_Ore_Settings("nether_black_opal_ore", Material.ROCK);
	
	public static final Block END_AMETHYST_ORE = new Amethyst_Ore_Settings("end_amethyst_ore", Material.ROCK);
	public static final Block END_BLACK_OPAL_ORE = new Black_Opal_Ore_Settings("end_black_opal_ore", Material.ROCK);
}
