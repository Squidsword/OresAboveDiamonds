package oresAboveDiamonds.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.items.ItemBase;
import oresAboveDiamonds.items.armor.ArmorBase;
import oresAboveDiamonds.items.tools.AmethystToolAxe;
import oresAboveDiamonds.items.tools.BlackOpalToolAxe;
import oresAboveDiamonds.items.tools.ToolHoe;
import oresAboveDiamonds.items.tools.ToolPickaxe;
import oresAboveDiamonds.items.tools.ToolSpade;
import oresAboveDiamonds.items.tools.ToolSword;
import oresAboveDiamonds.util.Reference;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item AMETHYST = new ItemBase("amethyst");	
	public static final Item BLACK_OPAL = new ItemBase("black_opal");
	
	public static final ToolMaterial MATERIAL_AMETHYST = EnumHelper.addToolMaterial("material_amethyst", 4, OADConfig.aq_amethyst_durability, OADConfig.ap_amethyst_efficiency, OADConfig.ao_amethyst_attack_damage, OADConfig.ap_amethyst_efficiency).setRepairItem(new ItemStack(ModItems.AMETHYST));
	public static final ToolMaterial MATERIAL_BLACK_OPAL = EnumHelper.addToolMaterial("material_black_opal", 5, OADConfig.at_black_opal_durability, OADConfig.as_black_opal_efficiency, OADConfig.ar_black_opal_attack_damage, OADConfig.as_black_opal_efficiency).setRepairItem(new ItemStack(ModItems.BLACK_OPAL));
	
	public static final ArmorMaterial ARMOR_MATERIAL_AMETHYST = EnumHelper.addArmorMaterial("armor_material_amethyst", Reference.MOD_ID + ":amethyst", OADConfig.aw_amethyst_armor_durability, new int[] {OADConfig.bb_amethyst_boots_armor,OADConfig.ba_amethyst_leggings_armor,OADConfig.az_amethyst_chestplate_armor, OADConfig.ay_amethyst_helmet_armor}, OADConfig.am_amethyst_enchantability, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, OADConfig.au_amethyst_toughness).setRepairItem(new ItemStack(ModItems.AMETHYST));
	public static final ArmorMaterial ARMOR_MATERIAL_BLACK_OPAL = EnumHelper.addArmorMaterial("armor_material_black_opal", Reference.MOD_ID + ":black_opal", OADConfig.ax_black_opal_armor_durability, new int[] {OADConfig.bf_black_opal_boots_armor,OADConfig.be_black_opal_leggings_armor,OADConfig.bd_black_opal_chestplate_armor,OADConfig.bc_black_opal_helmet_armor}, OADConfig.an_black_opal_enchantability, SoundEvents.ENTITY_ENDERDRAGON_FLAP, OADConfig.av_black_opal_toughness).setRepairItem(new ItemStack(ModItems.BLACK_OPAL));
	
	public static final ItemSword AMETHYST_SWORD = new ToolSword("amethyst_sword", MATERIAL_AMETHYST);
	public static final ItemSword BLACK_OPAL_SWORD = new ToolSword("black_opal_sword", MATERIAL_BLACK_OPAL);
	
	public static final ItemPickaxe AMETHYST_PICKAXE = new ToolPickaxe("amethyst_pickaxe", MATERIAL_AMETHYST);
	public static final ItemPickaxe BLACK_OPAL_PICKAXE = new ToolPickaxe("black_opal_pickaxe", MATERIAL_BLACK_OPAL);

	public static final ItemSpade AMETHYST_SHOVEL = new ToolSpade("amethyst_shovel", MATERIAL_AMETHYST);
	public static final ItemSpade BLACK_OPAL_SHOVEL = new ToolSpade("black_opal_shovel", MATERIAL_BLACK_OPAL);
	
	public static final ItemAxe AMETHYST_AXE = new AmethystToolAxe("amethyst_axe", MATERIAL_AMETHYST);
	public static final ItemAxe BLACK_OPAL_AXE = new BlackOpalToolAxe("black_opal_axe", MATERIAL_BLACK_OPAL);

	public static final ItemHoe AMETHYST_HOE = new ToolHoe("amethyst_hoe", MATERIAL_AMETHYST);
	public static final ItemHoe BLACK_OPAL_HOE = new ToolHoe("black_opal_hoe", MATERIAL_BLACK_OPAL);
	
	
	public static final Item AMETHYST_HELMET = new ArmorBase("amethyst_helmet", ARMOR_MATERIAL_AMETHYST, 1, EntityEquipmentSlot.HEAD);
	public static final Item AMETHYST_CHESTPLATE = new ArmorBase("amethyst_chestplate", ARMOR_MATERIAL_AMETHYST, 1, EntityEquipmentSlot.CHEST);
	public static final Item AMETHYST_LEGGINGS = new ArmorBase("amethyst_leggings", ARMOR_MATERIAL_AMETHYST, 2, EntityEquipmentSlot.LEGS);
	public static final Item AMETHYST_BOOTS = new ArmorBase("amethyst_boots", ARMOR_MATERIAL_AMETHYST, 1, EntityEquipmentSlot.FEET);
	
	public static final Item BLACK_OPAL_HELMET = new ArmorBase("black_opal_helmet", ARMOR_MATERIAL_BLACK_OPAL, 1, EntityEquipmentSlot.HEAD);
	public static final Item BLACK_OPAL_CHESTPLATE = new ArmorBase("black_opal_chestplate", ARMOR_MATERIAL_BLACK_OPAL, 1, EntityEquipmentSlot.CHEST);
	public static final Item BLACK_OPAL_LEGGINGS = new ArmorBase("black_opal_leggings", ARMOR_MATERIAL_BLACK_OPAL, 2, EntityEquipmentSlot.LEGS);
	public static final Item BLACK_OPAL_BOOTS = new ArmorBase("black_opal_boots", ARMOR_MATERIAL_BLACK_OPAL, 1, EntityEquipmentSlot.FEET);
	
}
