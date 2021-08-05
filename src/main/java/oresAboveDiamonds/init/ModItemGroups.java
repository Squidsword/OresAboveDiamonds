package oresAboveDiamonds.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroups {

	public static final CreativeModeTab OAD_ITEM_GROUP = new ModItemGroup();
	
	public static final class ModItemGroup extends CreativeModeTab {
	
		public ModItemGroup() {
			super("oresabovediamonds");
			// TODO Auto-generated constructor stub
		}

		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModItems.AMETHYST.get());
		}
	}
}