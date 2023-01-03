package oresAboveDiamonds.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class AmethystBlock extends Block {

	public AmethystBlock() {
		super(Block.Properties
				.of(Material.METAL, MaterialColor.COLOR_MAGENTA)
				.strength(10f, 50f)
				.requiresCorrectToolForDrops()
				.sound(SoundType.AMETHYST));
	}
		
}
