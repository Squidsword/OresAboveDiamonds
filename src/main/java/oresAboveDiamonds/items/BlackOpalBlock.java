package oresAboveDiamonds.items;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlackOpalBlock extends Block {

	public BlackOpalBlock() {
		super(Properties
				.create(Material.IRON)
				.hardnessAndResistance(25f, 100f)
				.sound(SoundType.METAL)
				.setRequiresTool()
			);
	}
	
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.PICKAXE;
		
	}
	
	@Override
	public int getHarvestLevel(BlockState state) {
		return 4;
	}
}