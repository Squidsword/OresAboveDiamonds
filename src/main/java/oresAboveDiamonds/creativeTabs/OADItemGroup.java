package oresAboveDiamonds.creativeTabs;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import oresAboveDiamonds.lists.ItemList;

public class OADItemGroup extends ItemGroup {

	public OADItemGroup() {
		super("oresabovediamonds");
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemStack createIcon() {
		// TODO Auto-generated method stub
		return new ItemStack(ItemList.amethyst);
	}

}
