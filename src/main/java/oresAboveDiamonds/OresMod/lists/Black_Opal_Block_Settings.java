package oresAboveDiamonds.OresMod.lists;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Black_Opal_Block_Settings extends Block {

	public Black_Opal_Block_Settings() {
		super(Properties.create(Material.IRON).hardnessAndResistance(25f, 100f).sound(SoundType.METAL));
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