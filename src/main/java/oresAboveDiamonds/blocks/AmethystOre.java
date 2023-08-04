package oresAboveDiamonds.blocks;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class AmethystOre extends DropExperienceBlock {

	public AmethystOre() {
		this(SoundType.STONE, 3f);
	}
	
	public AmethystOre(SoundType soundType) {
		this(soundType, 3f);
	}
	
	public AmethystOre(SoundType soundType, float hardness) {
		super(BlockBehaviour.Properties
				.of()
				.mapColor(MapColor.STONE)
				.requiresCorrectToolForDrops()
				.strength(hardness, 3f)
				.sound(soundType),
				
			  UniformInt.of(10, 30));
		
	}

}
