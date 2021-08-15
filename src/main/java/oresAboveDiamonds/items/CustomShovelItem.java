package oresAboveDiamonds.items;

import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import oresAboveDiamonds.lists.ToolMaterialList;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class CustomShovelItem extends ShovelItem {

	public CustomShovelItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);

	}
	
	@Override
	public boolean isEnchantable(ItemStack stack) {
		return true;
	}
	
	@Override
	public boolean hurtEnemy(ItemStack itemStack, LivingEntity enemy, LivingEntity damager) {
		Tier tier = this.getTier();
		if(tier.equals(ToolMaterialList.AMETHYST) || tier.equals(ToolMaterialList.BLACK_OPAL) || tier.equals(ToolMaterialList.NETHERITE_OPAL)) {
			ToolMaterialList modTier = (ToolMaterialList) tier;
			if(modTier.isInfinite()) {
				itemStack.setDamageValue(0);
				return true;
			}
		}
		return super.hurtEnemy(itemStack, enemy, damager);
	}
	
	@Override
	public boolean mineBlock(ItemStack itemStack, Level world, BlockState state, BlockPos pos, LivingEntity entityLiving) {
		Tier tier = this.getTier();
		if(tier.equals(ToolMaterialList.AMETHYST) || tier.equals(ToolMaterialList.BLACK_OPAL) || tier.equals(ToolMaterialList.NETHERITE_OPAL)) {
			ToolMaterialList modTier = (ToolMaterialList) tier;
			if(modTier.isInfinite()) {
				if (!world.isClientSide && (double)state.getDestroySpeed(world, pos) != 0.0D)
		        {
		            itemStack.setDamageValue(0);
		            return true;
		        }
			}
		}
		return super.mineBlock(itemStack, world, state, pos, entityLiving);
    }
	
	@Override
	public void onCraftedBy(ItemStack stack, Level worldIn, Player playerIn) {
		Tier tier = this.getTier();
		if(tier.equals(ToolMaterialList.AMETHYST) || tier.equals(ToolMaterialList.BLACK_OPAL) || tier.equals(ToolMaterialList.NETHERITE_OPAL)) {
			ToolMaterialList modTier = (ToolMaterialList) tier;
			if(modTier.isInfinite()) {
				stack.getOrCreateTag().putBoolean("Unbreakable", true);
				return;
			}
		}
		super.onCraftedBy(stack, worldIn, playerIn);
	}
	
}
