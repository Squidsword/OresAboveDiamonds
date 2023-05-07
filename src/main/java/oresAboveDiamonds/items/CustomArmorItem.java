package oresAboveDiamonds.items;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import oresAboveDiamonds.lists.ArmorMaterialList;

public class CustomArmorItem extends ArmorItem {

	public CustomArmorItem(ArmorMaterial materialIn, ArmorItem.Type type, Properties builder) {
		super(materialIn, type, builder);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isEnchantable(ItemStack stack) {
		return true;
	}

	
	// Reference: gobber by kwpugh
	@Override
	public void onArmorTick(ItemStack stack, Level world, Player player) {
		ArmorMaterial material = this.getMaterial();
		if(material.equals(ArmorMaterialList.AMETHYST) || material.equals(ArmorMaterialList.BLACK_OPAL) || material.equals(ArmorMaterialList.NETHERITE_OPAL)) {
			ArmorMaterialList modMaterial = (ArmorMaterialList) material;
			if(modMaterial.isInfinite()) {
				ItemStack head = player.getItemBySlot(EquipmentSlot.HEAD);
				ItemStack chest = player.getItemBySlot(EquipmentSlot.CHEST);
				ItemStack legs = player.getItemBySlot(EquipmentSlot.LEGS);
				ItemStack feet = player.getItemBySlot(EquipmentSlot.FEET);	
			
				setDamage(head, 0);
				setDamage(chest, 0);
				setDamage(legs, 0);
				setDamage(feet, 0);
				return;
			} 
		}
		super.onArmorTick(stack, world, player);
	}
	
	@Override
	public void onCraftedBy(ItemStack stack, Level worldIn, Player playerIn) {
		ArmorMaterial material = this.getMaterial();
		if(material.equals(ArmorMaterialList.AMETHYST) || material.equals(ArmorMaterialList.BLACK_OPAL) || material.equals(ArmorMaterialList.NETHERITE_OPAL)) {
			ArmorMaterialList modMaterial = (ArmorMaterialList) material;
			if(modMaterial.isInfinite()) {
				stack.getOrCreateTag().putBoolean("Unbreakable", true);
				return;
			}
		}
		super.onCraftedBy(stack, worldIn, playerIn);
	}
	
}
