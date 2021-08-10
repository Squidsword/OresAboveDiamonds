package oresAboveDiamonds.lists;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.init.ModItems;

public enum ToolMaterialList implements Tier 
{
	
	AMETHYST(OADConfig.amethyst_attack_damage.get() , OADConfig.amethyst_efficiency.get(), OADConfig.amethyst_durability.get(), 4, OADConfig.amethyst_enchantability.get(), ModItems.AMETHYST.get()),
	BLACK_OPAL(OADConfig.black_opal_attack_damage.get(), OADConfig.black_opal_efficiency.get(), OADConfig.black_opal_durability.get(), 5, OADConfig.black_opal_enchantability.get(), ModItems.BLACK_OPAL.get()),
	NETHERITE_OPAL(OADConfig.netherite_opal_attack_damage.get(), OADConfig.netherite_opal_efficiency.get(), OADConfig.netherite_opal_durability.get(), 5, OADConfig.netherite_opal_enchantability.get(), ModItems.BLACK_OPAL.get());
	
	private float attackDamage, efficiency;
	private int durability, harvestLevel, enchantability;
	private Item repairMaterial;
	
	private ToolMaterialList(int attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Item repairMaterial) 
	{
		this.attackDamage = attackDamage;
		this.efficiency = efficiency;
		this.durability = durability;
		this.harvestLevel = harvestLevel;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial;
	}

	@Override
	public int getUses() 
	{
		return this.durability;
	}

	@Override
	public float getSpeed() 
	{
		return this.efficiency;
	}

	@Override
	public float getAttackDamageBonus() 
	{
		return this.attackDamage;
	}

	@Override
	public int getLevel() 
	{
		return this.harvestLevel;
	}

	@Override
	public int getEnchantmentValue() 
	{
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairIngredient() 
	{
		return Ingredient.of(this.repairMaterial);
	}

}
 