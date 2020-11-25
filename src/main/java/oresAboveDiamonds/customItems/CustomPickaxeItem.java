package oresAboveDiamonds.customItems;

import net.minecraft.item.PickaxeItem;
import net.minecraftforge.common.ToolType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

public class CustomPickaxeItem extends PickaxeItem {

	public CustomPickaxeItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder.addToolType(ToolType.PICKAXE, tier.getHarvestLevel()));

	}
	
	@Override
	public boolean isEnchantable(ItemStack stack) {
		return true;
	}
	
}
