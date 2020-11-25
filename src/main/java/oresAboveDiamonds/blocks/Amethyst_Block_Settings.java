package oresAboveDiamonds.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Amethyst_Block_Settings extends BlockBase {

	public Amethyst_Block_Settings(String name, Material material) {
		
		super(name, material);
		
		setSoundType(SoundType.METAL);
		setHardness(10f);
		setResistance(20f);
		setHarvestLevel("pickaxe", 3);
		
	}

}
