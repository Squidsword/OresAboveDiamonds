package oresAboveDiamonds.blocks;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class BlackOpalOre extends DropExperienceBlock {

	public BlackOpalOre() {
		this(SoundType.STONE, 3f);
	}
	
	public BlackOpalOre(SoundType soundType) {
		this(soundType, 3f);
	}
	
	public BlackOpalOre(SoundType soundType, float hardness) {
		super(Properties
				.of(Material.STONE)
				.requiresCorrectToolForDrops()
				.strength(hardness, 3f)
				.sound(soundType),
				
			 UniformInt.of(25, 75));
	}
	

	/*
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.PICKAXE;
	}
	
	@Override
	public int getHarvestLevel(BlockState state) {
		return 4;
	}
	

	@Override
    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
       return silktouch == 0 ? 50 : 0;
	}
	*/
}
