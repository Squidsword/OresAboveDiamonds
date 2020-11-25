package oresAboveDiamonds.blocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import oresAboveDiamonds.Main;
import oresAboveDiamonds.util.IHasModel;

public class CustomItemBlock extends ItemBlock implements IHasModel {

	public CustomItemBlock(Block block) {
		super(block);
		
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer((this), 0, "inventory");
	}
	@Override
	public CreativeTabs[] getCreativeTabs() {
		 return new CreativeTabs[]{Main.oresabovediamondstab, CreativeTabs.BUILDING_BLOCKS};
	}

}
