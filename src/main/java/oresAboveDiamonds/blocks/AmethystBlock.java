package oresAboveDiamonds.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class AmethystBlock extends Block {

	public AmethystBlock() {
		super(BlockBehaviour.Properties
				.of()
				.mapColor(MapColor.COLOR_MAGENTA)
				.strength(10f, 50f)
				.requiresCorrectToolForDrops()
				.sound(SoundType.AMETHYST));
	}
		
}
