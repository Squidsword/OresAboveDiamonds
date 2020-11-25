package oresAboveDiamonds.OresMod.lists;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class Amethyst_Ore_Settings extends Block {

	public Amethyst_Ore_Settings() {
		super(Properties.create(Material.IRON).hardnessAndResistance(10f, 20f).sound(SoundType.METAL));
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
		
	@Override
	public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
		return silktouch == 0 ? 20 : 0;
		
	}
}
