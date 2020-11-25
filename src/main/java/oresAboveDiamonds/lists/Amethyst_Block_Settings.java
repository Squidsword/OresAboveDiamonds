package oresAboveDiamonds.lists;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Amethyst_Block_Settings extends Block {

	public Amethyst_Block_Settings() {
		super(Properties.create(Material.IRON).hardnessAndResistance(10f, 50f).sound(SoundType.METAL));
	}
	
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.PICKAXE;
		
	}
	
	@Override
	public int getHarvestLevel(BlockState state) {
		return 3;
	}
}
