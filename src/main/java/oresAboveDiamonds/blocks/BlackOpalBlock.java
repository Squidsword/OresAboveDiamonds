package oresAboveDiamonds.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class BlackOpalBlock extends Block {

	public BlackOpalBlock() {
		super(Properties
				.of(Material.METAL, MaterialColor.COLOR_PURPLE)
				.strength(15f, 100f)
				.requiresCorrectToolForDrops()	
				.sound(SoundType.NETHERITE_BLOCK)
			 );
	}

}