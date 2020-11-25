package oresAboveDiamonds.customItems;

import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

public class CustomAxeItem extends AxeItem {

	public CustomAxeItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
		
	}
	
	@Override
	public boolean isEnchantable(ItemStack stack) {
		return true;
	}
	
}
