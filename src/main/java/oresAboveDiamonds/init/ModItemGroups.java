package oresAboveDiamonds.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroups {

	public static final ItemGroup OAD_ITEM_GROUP = new ModItemGroup();
	
	public static final class ModItemGroup extends ItemGroup {
	
		public ModItemGroup() {
			super("oresabovediamonds");
			// TODO Auto-generated constructor stub
		}

		@Override
		public ItemStack createIcon() {
			// TODO Auto-generated method stub
			return new ItemStack(ModItems.AMETHYST.get());
		}
	}
}