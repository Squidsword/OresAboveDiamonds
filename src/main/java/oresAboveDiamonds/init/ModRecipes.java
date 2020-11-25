package oresAboveDiamonds.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	
	public static void init() {
		GameRegistry.addSmelting(ModBlocks.AMETHYST_ORE, new ItemStack(ModItems.AMETHYST, 1), 4f);
		GameRegistry.addSmelting(ModBlocks.BLACK_OPAL_ORE, new ItemStack(ModItems.BLACK_OPAL, 1), 16f);
	}

}
