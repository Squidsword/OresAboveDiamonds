package oresAboveDiamonds.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import oresAboveDiamonds.OresAboveDiamonds;
import oresAboveDiamonds.blocks.AmethystBlock;
import oresAboveDiamonds.blocks.AmethystOre;
import oresAboveDiamonds.blocks.BlackOpalBlock;
import oresAboveDiamonds.blocks.BlackOpalOre;

public final class ModBlocks {

	//Thanks to Cadiboo for the tutorial
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, OresAboveDiamonds.MODID);

	public static final RegistryObject<AmethystOre> AMETHYST_ORE = BLOCKS.register("amethyst_ore", () -> new AmethystOre());
	public static final RegistryObject<BlackOpalOre> BLACK_OPAL_ORE = BLOCKS.register("black_opal_ore", () -> new BlackOpalOre());
	
	public static final RegistryObject<AmethystBlock> AMETHYST_BLOCK = BLOCKS.register("amethyst_block", () -> new AmethystBlock());
	public static final RegistryObject<BlackOpalBlock> BLACK_OPAL_BLOCK = BLOCKS.register("black_opal_block", () -> new BlackOpalBlock());
	
	public static final RegistryObject<AmethystOre> DEEPSLATE_AMETHYST_ORE = BLOCKS.register("deepslate_amethyst_ore", () -> new AmethystOre(SoundType.DEEPSLATE, 4.5f));
	public static final RegistryObject<AmethystOre> NETHER_AMETHYST_ORE = BLOCKS.register("nether_amethyst_ore", () -> new AmethystOre(SoundType.NETHER_ORE));
	public static final RegistryObject<AmethystOre> END_AMETHYST_ORE = BLOCKS.register("end_amethyst_ore", () -> new AmethystOre());
	
	public static final RegistryObject<BlackOpalOre> DEEPSLATE_BLACK_OPAL_ORE = BLOCKS.register("deepslate_black_opal_ore", () -> new BlackOpalOre(SoundType.DEEPSLATE, 4.5f));
	public static final RegistryObject<BlackOpalOre> NETHER_BLACK_OPAL_ORE = BLOCKS.register("nether_black_opal_ore", () -> new BlackOpalOre(SoundType.NETHER_ORE));
	public static final RegistryObject<BlackOpalOre> END_BLACK_OPAL_ORE = BLOCKS.register("end_black_opal_ore", () -> new BlackOpalOre());
}