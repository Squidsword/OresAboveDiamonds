package oresAboveDiamonds.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Black_Opal_Block_Settings extends BlockBase {

	public Black_Opal_Block_Settings(String name, Material material) {
		
		super(name, material);
		
		setSoundType(SoundType.METAL);
		setHardness(25.0f);
		setResistance(25.0f);
		setHarvestLevel("pickaxe", 4);
		setLightLevel(10);
		
	}

}
