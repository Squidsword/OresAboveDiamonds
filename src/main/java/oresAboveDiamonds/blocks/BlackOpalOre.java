package oresAboveDiamonds.blocks;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ToolType;

public class BlackOpalOre extends OreBlock {

	public BlackOpalOre() {
		this(SoundType.STONE);
	}
	
	public BlackOpalOre(SoundType soundType) {
		super(Properties
				.of(Material.STONE)
				.requiresCorrectToolForDrops()
				.strength(9f, 9f)
				.harvestLevel(4)
				.harvestTool(ToolType.PICKAXE)
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
