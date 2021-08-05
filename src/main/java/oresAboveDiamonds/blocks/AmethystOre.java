package oresAboveDiamonds.blocks;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class AmethystOre extends OreBlock {

	
	public AmethystOre() {
		super(Properties
				.of(Material.METAL, MaterialColor.METAL)
				.strength(10f, 20f)
				.sound(SoundType.METAL),
				
			  UniformInt.of(10, 30));
		
	}

	/*
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.PICKAXE;	
	}
	
	@Override
	public int getHarvestLevel(BlockState state) {
		return 3;
	}
		
	@Override
	public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
		return silktouch == 0 ? 20 : 0;
		
	}
	*/
}
