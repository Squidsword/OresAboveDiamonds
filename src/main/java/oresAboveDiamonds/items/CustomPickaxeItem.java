package oresAboveDiamonds.items;

import net.minecraft.world.item.PickaxeItem;
import net.minecraftforge.common.ToolType;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;

public class CustomPickaxeItem extends PickaxeItem {

	public CustomPickaxeItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder.addToolType(ToolType.PICKAXE, tier.getLevel()));

	}
	
	@Override
	public boolean isEnchantable(ItemStack stack) {
		return true;
	}
	
}
