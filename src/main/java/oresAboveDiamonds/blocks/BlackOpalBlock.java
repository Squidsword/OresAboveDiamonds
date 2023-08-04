package oresAboveDiamonds.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class BlackOpalBlock extends Block {

	public BlackOpalBlock() {
		super(Properties
				.of()
				.mapColor(MapColor.COLOR_PURPLE)
				.strength(15f, 100f)
				.requiresCorrectToolForDrops()	
				.sound(SoundType.NETHERITE_BLOCK)
			 );
	}

}