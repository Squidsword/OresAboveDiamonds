package oresAboveDiamonds.items;

import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

public class CustomHoeItem extends HoeItem {

	public CustomHoeItem(IItemTier tier, float attackSpeedIn, Properties builder) {
		super(tier, attackSpeedIn, builder);

	}
	
	@Override
	public boolean isEnchantable(ItemStack stack) {
		return true;
	}
}
