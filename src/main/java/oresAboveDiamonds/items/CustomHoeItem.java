package oresAboveDiamonds.items;

import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class CustomHoeItem extends HoeItem {

	public CustomHoeItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);

	}
	
	@Override
	public boolean isEnchantable(ItemStack stack) {
		return true;
	}
	
}
