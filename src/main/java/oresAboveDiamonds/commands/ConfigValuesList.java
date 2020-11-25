package oresAboveDiamonds.commands;

import java.util.Collection;
import java.util.List;

import com.google.common.collect.Lists;

public enum ConfigValuesList {
	AMETHYST_CHANCE("amethyst_chance", "double"),
	BLACK_OPAL_CHANCE("black_opal_chance", "double"),

	AMETHYST_MAX_VEIN_SIZE("amethyst_max_vein_size", "int"),
	BLACK_OPAL_MAX_VEIN_SIZE("black_opal_max_vein_size", "int"),

	AMETHYST_ARMOR_TOUGHNESS("amethyst_armor_toughness", "int"),
	BLACK_OPAL_ARMOR_TOUGHNESS("black_opal_armor_toughness", "int"),

	AMETHYST_ARMOR_DURABILITY("amethyst_armor_durability", "int"),
	BLACK_OPAL_ARMOR_DURABILITY("black_opal_armor_durability", "int"),

	AMETHYST_HELMET_ARMOR("amethyst_helmet_armor", "int"),
	AMETHYST_CHESTPLATE_ARMOR("amethyst_chestplate_armor", "int"),
	AMETHYST_LEGGINGS_ARMOR("amethyst_leggings_armor", "int"),
	AMETHYST_BOOTS_ARMOR("amethyst_boots_armor", "int"),

	BLACK_OPAL_HELMET_ARMOR("black_opal_helmet_armor", "int"),
	BLACK_OPAL_CHESTPLATE_ARMOR("black_opal_chestplate_armor", "int"),
	BLACK_OPAL_LEGGINGS_ARMOR("black_opal_leggings_armor", "int"),
	BLACK_OPAL_BOOTS_ARMOR("black_opal_boots_armor", "int"),

	AMETHYST_ATTACK_DAMAGE("amethyst_attack_damage", "int"),
	AMETHYST_EFFICIENCY("amethyst_efficiency", "int"),
	AMETHYST_DURABILITY("amethyst_durability", "int"),

	BLACK_OPAL_ATTACK_DAMAGE("black_opal_attack_damage", "int"),
	BLACK_OPAL_EFFICIENCY("black_opal_efficiency", "int"),
	BLACK_OPAL_DURABILITY("black_opal_durability", "int"),

	AMETHYST_ENCHANTABILITY("amethyst_enchantability", "int"),
	BLACK_OPAL_ENCHANTABILITY("black_opal_enchantability", "int"),

	NETHER_CHANCE_MULTIPLIER("nether_chance_multiplier", "double"),
	END_CHANCE_MULTIPLIER("end_chance_multiplier", "double"),
	NETHER_VEIN_MULTIPLIER("nether_vein_multiplier", "double"),
	END_VEIN_MULTIPLIER("end_vein_multiplier", "double"),

	ENABLE_SERVER_CONFIG_SYNC("enable_server_config_sync", "boolean"),
	SEND_CONFIG_SYNC_PACKET("send_config_sync_packet", "boolean"),
	OVERWORLD_ORES("overworld_ores", "boolean"),
	NETHER_ORES("nether_ores", "boolean"),
	END_ORES("end_ores", "boolean"),
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
