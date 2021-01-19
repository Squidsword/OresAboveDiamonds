package oresAboveDiamonds.lists;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.init.ModItems;

public enum ToolMaterialList implements IItemTier 
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
	public int getMaxUses() 
	{
		return this.durability;
	}

	@Override
	public float getEfficiency() 
	{
		return this.efficiency;
	}

	@Override
	public float getAttackDamage() 
	{
		return this.attackDamage;
	}

	@Override
	public int getHarvestLevel() 
	{
		return this.harvestLevel;
	}

	@Override
	public int getEnchantability() 
	{
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() 
	{
		return Ingredient.fromItems(this.repairMaterial);
	}
}
