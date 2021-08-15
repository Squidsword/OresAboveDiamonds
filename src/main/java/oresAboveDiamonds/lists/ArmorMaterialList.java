package oresAboveDiamonds.lists;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.init.ModItems;


public enum ArmorMaterialList implements ArmorMaterial
{
	
	AMETHYST("amethyst", OADConfig.amethyst_armor_durability.get(), new int[] {OADConfig.amethyst_boots_armor.get(), OADConfig.amethyst_leggings_armor.get(), OADConfig.amethyst_chestplate_armor.get(), OADConfig.amethyst_helmet_armor.get()}, OADConfig.amethyst_enchantability.get(), ModItems.AMETHYST.get(), SoundEvents.ARMOR_EQUIP_DIAMOND, OADConfig.amethyst_armor_toughness.get(), ((float)OADConfig.amethyst_armor_knockback_resistance.get()) / 10),
	BLACK_OPAL("black_opal", OADConfig.black_opal_armor_durability.get(), new int[] {OADConfig.black_opal_boots_armor.get(), OADConfig.black_opal_leggings_armor.get(), OADConfig.black_opal_chestplate_armor.get(), OADConfig.black_opal_helmet_armor.get()}, OADConfig.black_opal_enchantability.get(), ModItems.BLACK_OPAL.get(), SoundEvents.ENDER_DRAGON_FLAP, OADConfig.black_opal_armor_toughness.get(), ((float)OADConfig.black_opal_armor_knockback_resistance.get()) / 10),
	NETHERITE_OPAL("netherite_opal", OADConfig.netherite_opal_armor_durability.get(), new int[] {OADConfig.netherite_opal_boots_armor.get(), OADConfig.netherite_opal_leggings_armor.get(), OADConfig.netherite_opal_chestplate_armor.get(), OADConfig.netherite_opal_helmet_armor.get()}, OADConfig.netherite_opal_enchantability.get(), ModItems.BLACK_OPAL.get(), SoundEvents.ENDER_DRAGON_FLAP, OADConfig.netherite_opal_armor_toughness.get(), ((float)OADConfig.netherite_opal_armor_knockback_resistance.get()) / 10);
	
	private static final int[]MAX_DAMAGE_ARRAY = new int[] {13, 15, 16, 11};
	private String name;
	private SoundEvent equipSound;
	private int durability, enchantability;
	private Item repairItem;
	private int[] damageReductionAmounts;
	private float toughness;
	private float knockback_resistance;
	
	private boolean infinite_durability;
	
	private ArmorMaterialList(String name, int durability, int[] damageReductionAmounts, int enchantability, Item item, SoundEvent equipSound, float toughness, float knockback_resistance) 
	{
		this.name = name;
		this.equipSound = equipSound;
		if(durability <= 0) {
			this.durability = Integer.MAX_VALUE; 
			this.infinite_durability = true;
		} else {
			this.durability = durability;
			this.infinite_durability = false;
		}
		this.repairItem = item;
		this.enchantability = enchantability;
		this.damageReductionAmounts = damageReductionAmounts;
		this.toughness = toughness;
		this.knockback_resistance = knockback_resistance;
	}

	@Override
	public int getDurabilityForSlot(EquipmentSlot slot) 
	{
		return MAX_DAMAGE_ARRAY[slot.getIndex()] * this.durability;
	}

	@Override
	public int getDefenseForSlot(EquipmentSlot slot) {

		return this.damageReductionAmounts[slot.getIndex()];
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantability;
	}

	@Override
	public SoundEvent getEquipSound() 
	{
		return this.equipSound;
	}
	@Override
	public Ingredient getRepairIngredient() 
	{
		return Ingredient.of(this.repairItem);
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
	
	public boolean isInfinite() {
		// TODO Auto-generated method stub
		return this.infinite_durability;
	}
	
}
