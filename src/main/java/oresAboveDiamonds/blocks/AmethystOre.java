package oresAboveDiamonds.blocks;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class AmethystOre extends OreBlock {

	public AmethystOre() {
		this(SoundType.STONE, 3f);
	}
	
	public AmethystOre(SoundType soundType) {
		this(soundType, 3f);
	}
	
	public AmethystOre(SoundType soundType, float hardness) {
		super(BlockBehaviour.Properties
				.of(Material.STONE)
				.requiresCorrectToolForDrops()
				.strength(hardness, 3f)
				.sound(soundType),
				
			  UniformInt.of(10, 30));
		
	}
	
	/*
	@Override
	public int getHarvestLevel(BlockState state) {
		return 3;
	}
	
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.PICKAXE;	
	}
	


	@Override
	public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
		return silktouch == 0 ? 20 : 0;
		
	}
	*/
}
