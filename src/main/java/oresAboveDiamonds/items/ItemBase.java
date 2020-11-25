package oresAboveDiamonds.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import oresAboveDiamonds.Main;
import oresAboveDiamonds.init.ModItems;
import oresAboveDiamonds.util.IHasModel;

public class ItemBase extends Item implements IHasModel {

	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.oresabovediamondstab);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	@Override
	public CreativeTabs[] getCreativeTabs() {
		 return new CreativeTabs[]{Main.oresabovediamondstab, CreativeTabs.MISC};
	}
}
