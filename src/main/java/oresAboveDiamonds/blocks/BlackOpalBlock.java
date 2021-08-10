package oresAboveDiamonds.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.ToolType;

public class BlackOpalBlock extends Block {

	public BlackOpalBlock() {
		super(Properties
				.of(Material.METAL, MaterialColor.COLOR_PURPLE)
				.strength(15f, 100f)
				.harvestLevel(4)
				.harvestTool(ToolType.PICKAXE)
				.requiresCorrectToolForDrops()
				.sound(SoundType.NETHERITE_BLOCK)
			 );
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
	*/
	
}