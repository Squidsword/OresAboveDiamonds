package oresAboveDiamonds.commands;

import java.util.Collection;
import java.util.List;

import com.google.common.collect.Lists;

public enum ConfigValuesList {
	AMETHYST_CHANCE("amethyst_times_rarer", "int"),
	BLACK_OPAL_CHANCE("black_opal_times_rarer", "int"),

	AMETHYST_MAX_VEIN_SIZE("amethyst_max_vein_size", "int"),
	BLACK_OPAL_MAX_VEIN_SIZE("black_opal_max_vein_size", "int"),
	
	AMETHYST_MAX_SPAWN_HEIGHT("amethyst_max_spawn_height", "int"),
	BLACK_OPAL_MAX_SPAWN_HEIGHT("black_opal_max_spawn_height", "int"),
	
	AMETHYST_ARMOR_TOUGHNESS("amethyst_armor_toughness", "int"),
	BLACK_OPAL_ARMOR_TOUGHNESS("black_opal_armor_toughness", "int"),
	NETHERITE_OPAL_ARMOR_TOUGHNESS("netherite_opal_armor_toughness", "int"),
	
	AMETHYST_ARMOR_KNOCKBACK_RESISTANCE("amethyst_armor_knockback_resistance", "int"),
	BLACK_OPAL_ARMOR_KNOCKBACK_RESISTANCE("black_opal_armor_knockback_resistance", "int"),
	NETHERITE_OPAL_ARMOR_KNOCKBACK_RESISTANCE("netherite_opal_armor_knockback_resistance", "int"),

	AMETHYST_ARMOR_DURABILITY("amethyst_armor_durability", "int"),
	BLACK_OPAL_ARMOR_DURABILITY("black_opal_armor_durability", "int"),
	NETHERITE_OPAL_ARMOR_DURABILITY("netherite_opal_armor_durability", "int"),

	AMETHYST_HELMET_ARMOR("amethyst_helmet_armor", "int"),
	AMETHYST_CHESTPLATE_ARMOR("amethyst_chestplate_armor", "int"),
	AMETHYST_LEGGINGS_ARMOR("amethyst_leggings_armor", "int"),
	AMETHYST_BOOTS_ARMOR("amethyst_boots_armor", "int"),

	BLACK_OPAL_HELMET_ARMOR("black_opal_helmet_armor", "int"),
	BLACK_OPAL_CHESTPLATE_ARMOR("black_opal_chestplate_armor", "int"),
	BLACK_OPAL_LEGGINGS_ARMOR("black_opal_leggings_armor", "int"),
	BLACK_OPAL_BOOTS_ARMOR("black_opal_boots_armor", "int"),
	
	NETHERITE_OPAL_HELMET_ARMOR("netherite_opal_helmet_armor", "int"),
	NETHERITE_OPAL_CHESTPLATE_ARMOR("netherite_opal_chestplate_armor", "int"),
	NETHERITE_OPAL_LEGGINGS_ARMOR("netherite_opal_leggings_armor", "int"),
	NETHERITE_OPAL_BOOTS_ARMOR("netherite_opal_boots_armor", "int"),

	AMETHYST_ATTACK_DAMAGE("amethyst_attack_damage", "int"),
	AMETHYST_EFFICIENCY("amethyst_efficiency", "int"),
	AMETHYST_DURABILITY("amethyst_durability", "int"),

	BLACK_OPAL_ATTACK_DAMAGE("black_opal_attack_damage", "int"),
	BLACK_OPAL_EFFICIENCY("black_opal_efficiency", "int"),
	BLACK_OPAL_DURABILITY("black_opal_durability", "int"),
	
	NETHERITE_OPAL_ATTACK_DAMAGE("netherite_opal_attack_damage", "int"),
	NETHERITE_OPAL_EFFICIENCY("netherite_opal_efficiency", "int"),
	NETHERITE_OPAL_DURABILITY("netherite_opal_durability", "int"),

	AMETHYST_ENCHANTABILITY("amethyst_enchantability", "int"),
	BLACK_OPAL_ENCHANTABILITY("black_opal_enchantability", "int"),
	NETHERITE_OPAL_ENCHANTABILITY("netherite_opal_enchantability", "int"),

	NETHER_CHANCE_MULTIPLIER("nether_chance_multiplier", "double"),
	END_CHANCE_MULTIPLIER("end_chance_multiplier", "double"),
	NETHER_VEIN_MULTIPLIER("nether_vein_multiplier", "double"),
	END_VEIN_MULTIPLIER("end_vein_multiplier", "double"),

	ENABLE_SERVER_CONFIG_SYNC("enable_server_config_sync", "boolean"),
	SEND_CONFIG_SYNC_PACKET("send_config_sync_packet", "boolean"),
	SPAWN_AMETHYST_OVERWORLD("spawn_amethyst_overworld", "boolean"),
	SPAWN_BLACK_OPAL_OVERWORLD("spawn_black_opal_overworld", "boolean"),
	SPAWN_AMETHYST_NETHER("spawn_amethyst_nether", "boolean"),
	SPAWN_BLACK_OPAL_NETHER("spawn_black_opal_nether", "boolean"),
	SPAWN_AMETHYST_END("spawn_amethyst_end", "boolean"),
	SPAWN_BLACK_OPAL_END("spawn_black_opal_end", "boolean"),
	OLD_COMBAT_MECHANICS("old_combat_mechanics", "boolean"),
	CHEST_LOOT("chest_loot", "boolean");
	
	private final String configString;
	
	private final String valueType;
	
	ConfigValuesList(String configOption, String valueType) {
		this.configString = configOption;
		this.valueType = valueType;
	}
	
	public String getString() {
		return this.configString;
	}
	
	public String getValueType() {
		return this.valueType;
	}
	
	public static Collection<String> getAllValues() {
		
		List<String> value_list = Lists.newArrayList();
		
		for(ConfigValuesList configvaluelist : values()) {
			value_list.add(configvaluelist.getString());
		}
		
		return value_list;
		
	}
}
