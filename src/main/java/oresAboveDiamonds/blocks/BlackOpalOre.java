package oresAboveDiamonds.blocks;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class BlackOpalOre extends DropExperienceBlock {

	public BlackOpalOre() {
		this(SoundType.STONE, 3f);
	}
	
	public BlackOpalOre(SoundType soundType) {
		this(soundType, 3f);
	}
	
	public BlackOpalOre(SoundType soundType, float hardness) {
		super(Properties
				.of()
				.mapColor(MapColor.STONE)
				.requiresCorrectToolForDrops()
				.strength(hardness, 3f)
				.sound(soundType),
				
			 UniformInt.of(25, 75));
	}

}
