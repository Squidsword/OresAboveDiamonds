package oresAboveDiamonds.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

//improved config coming up
@Mod.EventBusSubscriber
public class OADConfig {
	
	public static ForgeConfigSpec.IntValue amethyst_times_rarer;
	public static ForgeConfigSpec.IntValue black_opal_times_rarer;
	
	public static ForgeConfigSpec.IntValue amethyst_max_vein_size;
	public static ForgeConfigSpec.IntValue black_opal_max_vein_size;
	
	public static ForgeConfigSpec.IntValue amethyst_max_spawn_height_overworld;
	public static ForgeConfigSpec.IntValue black_opal_max_spawn_height_overworld;
	
	public static ForgeConfigSpec.IntValue amethyst_max_spawn_height_nether;
	public static ForgeConfigSpec.IntValue black_opal_max_spawn_height_nether;
	
	public static ForgeConfigSpec.IntValue amethyst_max_spawn_height_end;
	public static ForgeConfigSpec.IntValue black_opal_max_spawn_height_end;
	
	public static ForgeConfigSpec.IntValue amethyst_armor_toughness;
	public static ForgeConfigSpec.IntValue black_opal_armor_toughness;
	public static ForgeConfigSpec.IntValue netherite_opal_armor_toughness;
	
	public static ForgeConfigSpec.IntValue amethyst_armor_knockback_resistance;
	public static ForgeConfigSpec.IntValue black_opal_armor_knockback_resistance;
	public static ForgeConfigSpec.IntValue netherite_opal_armor_knockback_resistance;
	
	public static ForgeConfigSpec.IntValue amethyst_armor_durability;
	public static ForgeConfigSpec.IntValue black_opal_armor_durability;
	public static ForgeConfigSpec.IntValue netherite_opal_armor_durability;
	
	public static ForgeConfigSpec.IntValue amethyst_helmet_armor;
	public static ForgeConfigSpec.IntValue amethyst_chestplate_armor;
	public static ForgeConfigSpec.IntValue amethyst_leggings_armor;
	public static ForgeConfigSpec.IntValue amethyst_boots_armor;
	
	public static ForgeConfigSpec.IntValue black_opal_helmet_armor;
	public static ForgeConfigSpec.IntValue black_opal_chestplate_armor;
	public static ForgeConfigSpec.IntValue black_opal_leggings_armor;
	public static ForgeConfigSpec.IntValue black_opal_boots_armor;
	
	public static ForgeConfigSpec.IntValue netherite_opal_helmet_armor;
	public static ForgeConfigSpec.IntValue netherite_opal_chestplate_armor;
	public static ForgeConfigSpec.IntValue netherite_opal_leggings_armor;
	public static ForgeConfigSpec.IntValue netherite_opal_boots_armor;
	
	public static ForgeConfigSpec.IntValue amethyst_attack_damage;
	public static ForgeConfigSpec.IntValue amethyst_efficiency;
	public static ForgeConfigSpec.IntValue amethyst_durability;
	
	public static ForgeConfigSpec.IntValue black_opal_attack_damage;
	public static ForgeConfigSpec.IntValue black_opal_efficiency;
	public static ForgeConfigSpec.IntValue black_opal_durability;
	
	public static ForgeConfigSpec.IntValue netherite_opal_attack_damage;
	public static ForgeConfigSpec.IntValue netherite_opal_efficiency;
	public static ForgeConfigSpec.IntValue netherite_opal_durability;
	
	public static ForgeConfigSpec.IntValue amethyst_enchantability;
	public static ForgeConfigSpec.IntValue black_opal_enchantability;
	public static ForgeConfigSpec.IntValue netherite_opal_enchantability;
	
	public static ForgeConfigSpec.DoubleValue nether_chance_multiplier;
	public static ForgeConfigSpec.DoubleValue end_chance_multiplier;
	public static ForgeConfigSpec.DoubleValue nether_vein_multiplier;
	public static ForgeConfigSpec.DoubleValue end_vein_multiplier;
	
	public static ForgeConfigSpec.BooleanValue enable_server_config_sync;
	public static ForgeConfigSpec.BooleanValue send_config_sync_packet;
	
	public static ForgeConfigSpec.BooleanValue spawn_amethyst_overworld;
	public static ForgeConfigSpec.BooleanValue spawn_black_opal_overworld;
	public static ForgeConfigSpec.BooleanValue spawn_amethyst_nether;
	public static ForgeConfigSpec.BooleanValue spawn_black_opal_nether;
	public static ForgeConfigSpec.BooleanValue spawn_amethyst_end;
	public static ForgeConfigSpec.BooleanValue spawn_black_opal_end;
	
	//public static ForgeConfigSpec.BooleanValue overworld_ores;
	//public static ForgeConfigSpec.BooleanValue nether_ores;
	//public static ForgeConfigSpec.BooleanValue end_ores;
	public static ForgeConfigSpec.BooleanValue old_combat_mechanics;
	public static ForgeConfigSpec.BooleanValue ores_above_netherite;
	public static ForgeConfigSpec.BooleanValue chest_loot;
	
	public static void init(ForgeConfigSpec.Builder builder) {
		
		builder.comment("Note that almost all config changes require a server restart and/or a full minecraft restart. Dimensional Ore Configuration").push("dimensional_ore");
		
		/*
		ores_above_netherite = builder
				.comment("Allow black opal tools to be enhanced by a netherite ingot?")
				.define("ores_above_netherite", true);
				*/
		
		spawn_amethyst_overworld = builder
				.comment("Spawn amethysts in the overworld? Default = true")
				.define("spawn_amethyst_overworld", true);
		
		spawn_black_opal_overworld = builder
				.comment("Spawn black opals in the overworld? Default = true")
				.define("spawn_black_opal_overworld", true);
		
		spawn_amethyst_nether = builder
				.comment("Spawn amethysts in the nether? Default = false")
				.define("spawn_amethyst_nether", false);
		
		spawn_black_opal_nether = builder
				.comment("Spawn black opals in the nether? Default = false")
				.define("spawn_black_opal_nether", false);
		
		spawn_amethyst_end = builder
				.comment("Spawn amethysts in the end? Default = false Note: This version doesn't support End gen yet.")
				.define("spawn_amethyst_end", false);
		
		spawn_black_opal_end = builder
				.comment("Spawn black opals in the end? Default = false Note: This version doesn't support End gen yet.")
				.define("spawn_black_opal_end", false);
		
		
		nether_chance_multiplier = builder
				.comment("If nether_ores is enabled, the spawn chance per chunk in the nether will be the chances set for amethyst_chance and black_opal_chance times this multiplier. The final rarity of each ore vein cannot be more common than diamonds. The default value tries to imitate the rarity in the overworld. Default = 1.35.")
				.defineInRange("nether_chance_multiplier", 1.5d, 0.01, 1000.0d);
		
		end_chance_multiplier = builder
				.comment("If end_ores is enabled, the spawn chance per chunk in the end will be the chances set for amethyst_chance and black_opal_chance times this multiplier. The default value tries to imitate the rarity in the overworld. Default = 1.0")
				.defineInRange("end_chance_multiplier", 1.0d, 0.01, 1000.0d);
		
		nether_vein_multiplier = builder
				.comment("If nether_ores is enableld, multiplies the max vein size of nether ores. Rounds to the nearest integer. Final max vein size cannot exceed 64 for stability reasons. Default = 1.0")
				.defineInRange("nether_vein_multiplier", 1.0d, 0, 1000.0d);
		
		end_vein_multiplier = builder
				.comment("If end_ores is enableld, multiplies the max vein size of end ores. Rounds to the nearest integer. Final max vein size cannot exceed 64 for stability reasons. Default = 1.2")
				.defineInRange("end_vein_multiplier", 1.2d, 0, 1000.0d);
		
		builder.pop();
		
		builder.comment("Rarity Configuration").push("ore_rarity");
		
		amethyst_times_rarer = builder
				.comment("How many times rarer amethysts are than diamonds. 1 = As common as diamonds, 2 = Half as common as diamonds etc. Default = 3")
				.defineInRange("amethyst_times_rarer", 3, 1, Integer.MAX_VALUE);
		
		black_opal_times_rarer = builder
				.comment("How many times rarer black opals are than diamonds. Default = 9")
				.defineInRange("black_opal_times_rarer", 9, 1, Integer.MAX_VALUE);
		
		amethyst_max_vein_size = builder
				.comment("Maximum vein size for an Amethyst Ore vein. For reference, diamonds have a max vein size of 8. Default = 7")
				.defineInRange("amethyst_max_vein_size", 7, 0, 64);
		
		black_opal_max_vein_size = builder
				.comment("Maximum vein size for an Black Opal Ore vein. Default = 6")
				.defineInRange("black_opal_max_vein_size", 6, 0, 64);
		
		amethyst_max_spawn_height_overworld = builder
				.comment("Maximum spawn height size for an Amethyst ore vein. Default = 16")
				.defineInRange("amethyst_max_spawn_height_overworld", 16, 1, 255);
		
		black_opal_max_spawn_height_overworld = builder
				.comment("Maximum spawn height size for a Black Opal ore vein. Default = 16")
				.defineInRange("black_opal_max_spawn_height_overworld", 16, 1, 255);
		
		amethyst_max_spawn_height_nether = builder
				.comment("Maximum spawn height size for an Amethyst ore vein for the nether. Default = 128")
				.defineInRange("amethyst_max_spawn_height_nether", 128, 1, 255);
		
		black_opal_max_spawn_height_nether = builder
				.comment("Maximum spawn height size for a Black Opal ore vein for the nether. Default = 128")
				.defineInRange("black_opal_max_spawn_height_nether", 128, 1, 255);
		
		amethyst_max_spawn_height_end = builder
				.comment("Maximum spawn height size for an Amethyst ore vein for the end. Default = 75")
				.defineInRange("amethyst_max_spawn_height_end", 75, 1, 255);
		
		black_opal_max_spawn_height_end = builder
				.comment("Maximum spawn height size for a Black Opal ore vein for the end. Default = 75")
				.defineInRange("black_opal_max_spawn_height_end", 75, 1, 255);
		
		chest_loot = builder
				.comment("Wherever diamonds can naturally generate in chests, black opal and amethyst can too at a reduced rate! Default = true")
				.define("chest_loot", true);
		builder.pop();
		
		builder.comment("Tool Settings. Changing these in a server will work, but it will not display the changes to the players.").push("tool");
		
		old_combat_mechanics = builder
				.comment("Adjusts damage numbers for no attack speed/pre MC 1.9 combat. Intended to be used with a mod that removes the attack speed cooldown.")
				.define("old_pvp_mechanics", false);
		
		amethyst_attack_damage = builder
				.comment("Base Attack Damage of the Amethyst Tool Set. For reference, the Diamond Tool Set has 3 base attack damage. Default = 4")
				.defineInRange("amethyst_ad", 4, 0, Integer.MAX_VALUE);
		
		amethyst_efficiency = builder
				.comment("Efficiency of the Amethyst Tool Set. For reference, the Diamond Tool Set has 8 efficiency. Default = 12")
				.defineInRange("amethyst_efficiency", 12, 0, Integer.MAX_VALUE);
		
		amethyst_durability = builder
				.comment("Durability of the Amethyst Tool Set. For reference, the Diamond Tool Set has 1561 durability. Set to 0 for infinite durability. Default = 4500")
				.defineInRange("amethyst_durability", 2625, 0, Integer.MAX_VALUE);
		
		black_opal_attack_damage = builder
				.comment("Base Attack Damage of the Black Opal Tool Set. Default = 5")
				.defineInRange("black_opal_ad", 5, 0, Integer.MAX_VALUE);
		
		black_opal_efficiency = builder
				.comment("Efficiency of the Black Opal Tool Set. Default = 16")
				.defineInRange("black_opal_efficiency", 16, 0, Integer.MAX_VALUE);
		
		black_opal_durability = builder
				.comment("Durability of the Black Opal Tool Set. Set to 0 for infinite durability. Default = 0")
				.defineInRange("black_opal_durability", 5250, 0, Integer.MAX_VALUE);
		
		netherite_opal_attack_damage = builder
				.comment("Base Attack Damage of the Netherite Opal Tool Set. Default = 5")
				.defineInRange("netherite_opal_ad", 6, 0, Integer.MAX_VALUE);
		
		netherite_opal_efficiency = builder
				.comment("Efficiency of the Netherite Opal Tool Set. Default = 16")
				.defineInRange("netherite_opal_efficiency", 20, 0, Integer.MAX_VALUE);
		
		netherite_opal_durability = builder
				.comment("Durability of the Netherite Opal Tool Set. Set to 0 for infinite durability. Default = 0")
				.defineInRange("netherite_opal_durability", 6300, 0, Integer.MAX_VALUE);
		
		builder.pop();
		
		builder.comment("Armor Settings. These values are delicate and changing them may significantly affect the strength of the armor.").push("armor");
		
		amethyst_armor_toughness = builder
				.comment("Toughness for the Amethyst Armor Set. Toughness reduces the armor penetration of high damaging attacks. Default = 3")
				.defineInRange("amethyst_armor_toughness", 3 , 0, Integer.MAX_VALUE);
		
		black_opal_armor_toughness = builder
				.comment("Toughness for the Black Opal Armor Set. Default = 4")
				.defineInRange("black_opal_armor_toughness", 4 , 0, Integer.MAX_VALUE);
		
		netherite_opal_armor_toughness = builder
				.comment("Toughness for the Netherite Opal Armor Set. Default = 5")
				.defineInRange("netherite_opal_armor_toughness", 5 , 0, Integer.MAX_VALUE);
		
		amethyst_armor_knockback_resistance = builder
				.comment("Knockback resistance for the Amethyst Armor Set. Knockback resistance reduces the amount of knockback the player takes. Default = 0")
				.defineInRange("amethyst_armor_knockback_resistance", 0 , 0, Integer.MAX_VALUE);
		
		black_opal_armor_knockback_resistance = builder
				.comment("Knockback resistance for the Black Opal Armor Set. Default = 0")
				.defineInRange("black_opal_armor_knockback_resistance", 0 , 0, Integer.MAX_VALUE);
		
		netherite_opal_armor_knockback_resistance = builder
				.comment("Knockback resistance for the Netherite Opal Armor Set. Default = 1")
				.defineInRange("netherite_opal_armor_knockback_resistance", 1 , 0, Integer.MAX_VALUE);
		
		amethyst_armor_durability = builder
				.comment("Base Durability for the Amethyst Armor Set. For reference, Diamond Armor has 33 base durability. Set -1 for infinite durability. Default = 132")
				.defineInRange("amethyst_armor_durability", 58, 0, Integer.MAX_VALUE);
		
		black_opal_armor_durability = builder
				.comment("Base Durability for the Black Opal Armor Set. Set 0 for infinite durability. Default = 0")
				.defineInRange("black_opal_armor_durability", 116, 0, Integer.MAX_VALUE);
		
		netherite_opal_armor_durability = builder
				.comment("Base Durability for the Black Opal Armor Set. Set 0 for infinite durability. Default = 0")
				.defineInRange("netherite_opal_armor_durability", 140, 0, Integer.MAX_VALUE);
		
		amethyst_helmet_armor = builder
				.comment("Amethyst Helmet Armor Value. Indicates how many half-armor points the indicated armor will give. Default = 3")
				.defineInRange("amethyst_helmet_armor", 3, 0, Integer.MAX_VALUE);
		
		amethyst_chestplate_armor = builder
				.comment("Amethyst Chestplate Armor Value. Default = 8")
				.defineInRange("amethyst_chestplate_armor", 8, 0, Integer.MAX_VALUE);
		
		amethyst_leggings_armor = builder
				.comment("Amethyst Leggings Armor Value. Default = 7")
				.defineInRange("amethyst_leggings_armor", 7, 0, Integer.MAX_VALUE);
		
		amethyst_boots_armor = builder
				.comment("Amethyst Boots Armor Value. Default = 3")
				.defineInRange("amethyst_boots_armor", 3, 0, Integer.MAX_VALUE);
		
		black_opal_helmet_armor = builder
				.comment("Black Opal Helmet Armor Value. Default = 3")
				.defineInRange("black_opal_helmet_armor", 3, 0, Integer.MAX_VALUE);
		
		black_opal_chestplate_armor = builder
				.comment("Black Opal Chestplate Armor Value. Default = 9")
				.defineInRange("black_opal_chestplate_armor", 9, 0, Integer.MAX_VALUE);
		
		black_opal_leggings_armor = builder
				.comment("Black Opal Leggings Armor Value. Default = 7")
				.defineInRange("black_opal_leggings_armor", 7, 0, Integer.MAX_VALUE);
		
		black_opal_boots_armor = builder
				.comment("Black Opal Boots Armor Value. Default = 3")
				.defineInRange("black_opal_boots_armor", 3, 0, Integer.MAX_VALUE);
		
		netherite_opal_helmet_armor = builder
				.comment("Netherite Opal Helmet Armor Value. Default = 3")
				.defineInRange("netherite_opal_helmet_armor", 3, 0, Integer.MAX_VALUE);
		
		netherite_opal_chestplate_armor = builder
				.comment("Netherite Opal Chestplate Armor Value. Default = 9")
				.defineInRange("netherite_opal_chestplate_armor", 9, 0, Integer.MAX_VALUE);
		
		netherite_opal_leggings_armor = builder
				.comment("Netherite Opal Leggings Armor Value. Default = 7")
				.defineInRange("netherite_opal_leggings_armor", 7, 0, Integer.MAX_VALUE);
		
		netherite_opal_boots_armor = builder
				.comment("Netherite Opal Boots Armor Value. Default = 3")
				.defineInRange("netherite_opal_boots_armor", 3, 0, Integer.MAX_VALUE);
		
		builder.pop();
		
		builder.comment("Enchantability Settings").push("enchant");
		
		amethyst_enchantability = builder
				.comment("Amethyst Enchantability. A higher value makes it easier to obtain higher level enchantments for less experience. For reference, diamonds have an enchantability of 10 and gold has an enchantability of 25. Default = 35")
				.defineInRange("amethyst", 35, 0, Integer.MAX_VALUE);
		
		black_opal_enchantability = builder
				.comment("Black Opal Enchantability. Default = 15")
				.defineInRange("black_opal", 15, 0, Integer.MAX_VALUE);
		
		netherite_opal_enchantability = builder
				.comment("Black Opal Enchantability. Default = 15")
				.defineInRange("black_opal", 15, 0, Integer.MAX_VALUE);
		
		builder.pop();
		
		builder.push("network");
		
		enable_server_config_sync = builder
				.comment("Sync your config to the server upon joining? (Requires a Minecraft restart afterwards)")
				.define("enable_server_config_sync", true);
		
		send_config_sync_packet = builder
				.comment("Sends a packet that attempts to sync the client config file to the server?")
				.define("send_config_sync_packet", true);
		
		builder.pop();
	}
}
