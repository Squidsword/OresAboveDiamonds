package oresAboveDiamonds.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import oresAboveDiamonds.init.ModItems;

public class OresAboveDiamondsTab extends CreativeTabs {
	
	public OresAboveDiamondsTab(String label) {
		super("oresabovediamonds");		
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.AMETHYST);
	}
	
}
