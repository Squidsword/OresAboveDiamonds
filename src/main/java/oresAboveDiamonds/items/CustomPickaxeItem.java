package oresAboveDiamonds.items;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class CustomPickaxeItem extends PickaxeItem {

	public CustomPickaxeItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);

	}
	
	@Override
	public boolean isEnchantable(ItemStack stack) {
		return true;
	}
	
}
