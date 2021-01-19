package oresAboveDiamonds.lists;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.init.ModItems;

public enum ArmorMaterialList implements IArmorMaterial
{
	
	AMETHYST("amethyst", OADConfig.amethyst_armor_durability.get(), new int[] {OADConfig.amethyst_boots_armor.get(), OADConfig.amethyst_leggings_armor.get(), OADConfig.amethyst_chestplate_armor.get(), OADConfig.amethyst_helmet_armor.get()}, OADConfig.amethyst_enchantability.get(), ModItems.AMETHYST.get(), "item.armor.equip_diamond", OADConfig.amethyst_armor_toughness.get(), ((float)OADConfig.amethyst_armor_knockback_resistance.get()) / 10),
	BLACK_OPAL("black_opal", OADConfig.black_opal_armor_durability.get(), new int[] {OADConfig.black_opal_boots_armor.get(), OADConfig.black_opal_leggings_armor.get(), OADConfig.black_opal_chestplate_armor.get(), OADConfig.black_opal_helmet_armor.get()}, OADConfig.black_opal_enchantability.get(), ModItems.BLACK_OPAL.get(), "entity.ender_dragon.flap", OADConfig.black_opal_armor_toughness.get(), ((float)OADConfig.black_opal_armor_knockback_resistance.get()) / 10),
	NETHERITE_OPAL("netherite_opal", OADConfig.netherite_opal_armor_durability.get(), new int[] {OADConfig.netherite_opal_boots_armor.get(), OADConfig.netherite_opal_leggings_armor.get(), OADConfig.netherite_opal_chestplate_armor.get(), OADConfig.netherite_opal_helmet_armor.get()}, OADConfig.netherite_opal_enchantability.get(), ModItems.BLACK_OPAL.get(), "entity.ender_dragon.flap", OADConfig.netherite_opal_armor_toughness.get(), ((float)OADConfig.netherite_opal_armor_knockback_resistance.get()) / 10);

	
	private static final int[]MAX_DAMAGE_ARRAY = new int[] {13, 15, 16, 11};
	private String name, equipSound;
	private int durability, enchantability;
	private Item repairItem;
	private int[] damageReductionAmounts;
	private float toughness;
	private float knockback_resistance;
	
	private ArmorMaterialList(String name, int durability, int[] damageReductionAmounts, int enchantability, Item repairItem, String equipSound, float toughness, float knockback_resistance) 
	{
		this.name = name;
		this.equipSound = equipSound;
		this.durability = durability;
		this.repairItem = repairItem;
		this.enchantability = enchantability;
		this.damageReductionAmounts = damageReductionAmounts;
		this.toughness = toughness;
		this.knockback_resistance = knockback_resistance;
	}

	@Override
	public int getDurability(EquipmentSlotType slot) 
	{
		return MAX_DAMAGE_ARRAY[slot.getIndex()] * this.durability;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slot) {

		return this.damageReductionAmounts[slot.getIndex()];
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public SoundEvent getSoundEvent() 
	{
		return new SoundEvent(new ResourceLocation(equipSound));
	}
	@Override
	public Ingredient getRepairMaterial() 
	{
		return Ingredient.fromItems(this.repairItem);
	}

	@Override
	public String getName() 
	{
		return "oresabovediamonds:" + this.name;
	}

	@Override
	public float getToughness() 
	{
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		// TODO Auto-generated method stub
		return this.knockback_resistance;
	}
	
	
}
