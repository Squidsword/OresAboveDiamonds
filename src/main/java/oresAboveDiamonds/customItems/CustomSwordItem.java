package oresAboveDiamonds.customItems;

import net.minecraft.item.SwordItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

public class CustomSwordItem extends SwordItem {

	public CustomSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);

	}
	
	@Override
	public boolean isEnchantable(ItemStack stack) {
		return true;
	}
	
}
