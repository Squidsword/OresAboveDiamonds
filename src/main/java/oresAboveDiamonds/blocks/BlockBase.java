package oresAboveDiamonds.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import oresAboveDiamonds.Main;
import oresAboveDiamonds.init.ModBlocks;
import oresAboveDiamonds.init.ModItems;
import oresAboveDiamonds.util.IHasModel;

public class BlockBase extends Block implements IHasModel {

	public BlockBase(String name, Material material) {
		
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new CustomItemBlock(this).setRegistryName(this.getRegistryName()));
		
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

}
