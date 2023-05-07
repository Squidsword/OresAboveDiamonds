package oresAboveDiamonds.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import java.nio.file.Path;

import java.util.HashMap;

//improved config coming up
@Mod.EventBusSubscriber
public class OADConfig {

	private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static HashMap<String, ForgeConfigSpec.ConfigValue<?>> map = new HashMap<>();

	static
	{
		OADConfig.init(BUILDER);
		SPEC = BUILDER.build();
	}

	public static void loadConfig(ForgeConfigSpec spec, Path path) {

		final CommentedFileConfig configData = CommentedFileConfig.builder(path)
				.sync()
				.autosave()
				.writingMode(WritingMode.REPLACE)
				.preserveInsertionOrder()
				.build();

		configData.load();
		spec.setConfig(configData);
	}

	public static ForgeConfigSpec.DoubleValue amethyst_times_rarer;
	public static ForgeConfigSpec.DoubleValue black_opal_times_rarer;
	
	public static ForgeConfigSpec.IntValue amethyst_vein_size;
	public static ForgeConfigSpec.IntValue black_opal_vein_size;
	
	public static ForgeConfigSpec.DoubleValue overworld_discard_chance_on_air_exposure;
	public static ForgeConfigSpec.DoubleValue nether_discard_chance_on_air_exposure;
	public static ForgeConfigSpec.DoubleValue end_discard_chance_on_air_exposure;
	
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
	
	public static ForgeConfigSpec.BooleanValue old_combat_mechanics;
	public static ForgeConfigSpec.BooleanValue chest_loot;

	public static void init(ForgeConfigSpec.Builder builder) {
		builder.comment("Note that almost all config changes require a server restart and/or a full minecraft restart. Dimension Configuration").push("dimensional_ore");

		spawn_amethyst_overworld = builder
				.comment("Spawn amethysts in the overworld? Default = true")
				.define("spawn_amethyst_overworld", true);

		map.putIfAbsent("spawn_amethyst_overworld", spawn_amethyst_overworld);

		spawn_black_opal_overworld = builder
				.comment("Spawn black opals in the overworld? Default = true")
				.define("spawn_black_opal_overworld", true);

		map.putIfAbsent("spawn_black_opal_overworld", spawn_black_opal_overworld);

		spawn_amethyst_nether = builder
				.comment("Spawn amethysts in the nether? Default = false")
				.define("spawn_amethyst_nether", false);

		map.putIfAbsent("spawn_amethyst_nether", spawn_amethyst_nether);

		spawn_black_opal_nether = builder
				.comment("Spawn black opals in the nether? Default = false")
				.define("spawn_black_opal_nether", false);

		map.putIfAbsent("spawn_black_opal_nether", spawn_black_opal_nether);

		spawn_amethyst_end = builder
				.comment("Spawn amethysts in the end? Default = false")
				.define("spawn_amethyst_end", false);

		map.putIfAbsent("spawn_amethyst_end", spawn_amethyst_end);

		spawn_black_opal_end = builder
				.comment("Spawn black opals in the end? Default = false")
				.define("spawn_black_opal_end", false);

		map.putIfAbsent("spawn_black_opal_end", spawn_black_opal_end);

		overworld_discard_chance_on_air_exposure = builder
				.comment("The average chance to delete an overworld ore that is exposed to air. High values discourage cave mining and encourage strip mining. Default value 0.7F is similar to vanilla's diamonds.")
				.defineInRange("overworld_discard_chance_on_air_exposure", 0.7d, 0.0, 1.0);

		map.putIfAbsent("overworld_discard_chance_on_air_exposure", overworld_discard_chance_on_air_exposure);

		nether_discard_chance_on_air_exposure = builder
				.comment("The average chance to delete a nether ore that is exposed to air. Default value = 0.95")
				.defineInRange("nether_discard_chance_on_air_exposure", 0.95d, 0.0, 1.0);

		map.putIfAbsent("nether_discard_chance_on_air_exposure", nether_discard_chance_on_air_exposure);

		end_discard_chance_on_air_exposure = builder
				.comment("The average chance to delete an end ore that is exposed to air. Default value = 0.95")
				.defineInRange("end_discard_chance_on_air_exposure", 0.95d, 0.0, 1.0);

		map.putIfAbsent("end_discard_chance_on_air_exposure", end_discard_chance_on_air_exposure);

		nether_chance_multiplier = builder
				.comment("Increases the chance that an ore above diamonds will spawn in the nether. Default = 1.0 which is tailored to be similar in density to the overworld")
				.defineInRange("nether_chance_multiplier", 1.0d, 0.01, 100.0d);

		map.putIfAbsent("nether_chance_multiplier", nether_chance_multiplier);

		end_chance_multiplier = builder
				.comment("Increases the chance that an ore above diamonds will spawn in the end. Default = 1.0 which is tailored to be similar in density to the overworld")
				.defineInRange("end_chance_multiplier", 1.0d, 0.01, 100.0d);

		map.putIfAbsent("end_chance_multiplier", end_chance_multiplier);

		nether_vein_multiplier = builder
				.comment("Multiplies the max vein size of nether ores. Rounds to the nearest integer. Default = 0.75")
				.defineInRange("nether_vein_multiplier", 0.75d, 0, 64.0d);

		map.putIfAbsent("nether_vein_multiplier", nether_vein_multiplier);

		end_vein_multiplier = builder
				.comment("Multiplies the max vein size of end ores. Rounds to the nearest integer. Default = 1.25")
				.defineInRange("end_vein_multiplier", 1.25d, 0, 64.0d);

		map.putIfAbsent("end_vein_multiplier", end_vein_multiplier);

		builder.pop();

		builder.comment("Rarity Configuration").push("ore_rarity");

		amethyst_times_rarer = builder
				.comment("Approximately how many times rarer the amethyst should be than diamonds. All dimensions uses these values. 1 = As common as diamonds, 2 = Half as common as diamonds etc. Default = 3")
				.defineInRange("amethyst_chance", 3d, -1d, 1000d);

		map.putIfAbsent("amethyst_times_rarer", amethyst_times_rarer);

		black_opal_times_rarer = builder
				.comment("Approximately how many times rarer the black opal should be than diamonds. All dimensions uses these values. Default = 9")
				.defineInRange("black_opal_chance", 9d, -1d, 1000d);

		map.putIfAbsent("black_opal_chance", black_opal_times_rarer);

		amethyst_vein_size = builder
				.comment("Max vein size for an Amethyst Ore vein. WARNING: Reducing vein sizes by 10%+ for some reason can reduce the total ores by 35%+. For reference, diamonds have a vein size of 8. Default = 8")
				.defineInRange("amethyst_vein_size", 8, 0, 64);

		map.putIfAbsent("amethyst_vein_size", amethyst_vein_size);

		black_opal_vein_size = builder
				.comment("Max vein size for an Black Opal Ore vein. WARNING: Reducing vein sizes by 10%+ for some reason can reduce the total ores by 35%+.  Default = 8")
				.defineInRange("black_opal_vein_size", 8, 0, 64);

		map.putIfAbsent("amethyst_vein_size", black_opal_times_rarer);

		amethyst_max_spawn_height_overworld = builder
				.comment("Maximum spawn height size for an Amethyst ore vein. Default = 8")
				.defineInRange("amethyst_max_spawn_height_overworld", 8,-63, 255);

		map.putIfAbsent("amethyst_max_spawn_height_overworld", amethyst_max_spawn_height_overworld);

		black_opal_max_spawn_height_overworld = builder
				.comment("Maximum spawn height size for a Black Opal ore vein. Default = 0")
				.defineInRange("black_opal_max_spawn_height_overworld", 0, -63, 255);

		map.putIfAbsent("black_opal_max_spawn_height_overworld", black_opal_max_spawn_height_overworld);

		amethyst_max_spawn_height_nether = builder
				.comment("Maximum spawn height size for an Amethyst ore vein for the nether. Default = 128")
				.defineInRange("amethyst_max_spawn_height_nether", 128, 0, 255);

		map.putIfAbsent("amethyst_max_spawn_height_nether", amethyst_max_spawn_height_nether);

		black_opal_max_spawn_height_nether = builder
				.comment("Maximum spawn height size for a Black Opal ore vein for the nether. Default = 128")
				.defineInRange("black_opal_max_spawn_height_nether", 128, 0, 255);

		map.putIfAbsent("black_opal_max_spawn_height_nether", black_opal_max_spawn_height_nether);

		amethyst_max_spawn_height_end = builder
				.comment("Maximum spawn height size for an Amethyst ore vein for the end. Default = 75")
				.defineInRange("amethyst_max_spawn_height_end", 75, 0, 255);

		map.putIfAbsent("amethyst_max_spawn_height_end", amethyst_max_spawn_height_end);

		black_opal_max_spawn_height_end = builder
				.comment("Maximum spawn height size for a Black Opal ore vein for the end. Default = 75")
				.defineInRange("black_opal_max_spawn_height_end", 75, 0, 255);

		map.putIfAbsent("black_opal_max_spawn_height_end", black_opal_max_spawn_height_end);

		chest_loot = builder
				.comment("Wherever diamonds can naturally generate in chests, black opal and amethyst can too at a reduced rate! Default = true")
				.define("chest_loot", true);
		builder.pop();

		map.putIfAbsent("black_opal_max_spawn_height_end", black_opal_max_spawn_height_end);

		builder.comment("Tool Settings. Changing these in a server will work, but it will not display the changes to the players without syncing.").push("tool");

		old_combat_mechanics = builder
				.comment("Adjusts damage numbers for no attack speed/pre MC 1.9 combat. Intended to be used with a mod that removes the attack speed cooldown.")
				.define("old_pvp_mechanics", false);

		map.putIfAbsent("old_pvp_mechanics", old_combat_mechanics);

		amethyst_attack_damage = builder
				.comment("Base Attack Damage of the Amethyst Tool Set. For reference, the Diamond Tool Set has 3 base attack damage. Default = 4")
				.defineInRange("amethyst_ad", 4, 0, Integer.MAX_VALUE);

		map.putIfAbsent("amethyst_ad", amethyst_attack_damage);

		amethyst_efficiency = builder
				.comment("Efficiency of the Amethyst Tool Set. For reference, the Diamond Tool Set has 8 efficiency. Default = 12")
				.defineInRange("amethyst_efficiency", 12, 0, Integer.MAX_VALUE);

		map.putIfAbsent("amethyst_efficiency", amethyst_efficiency);

		amethyst_durability = builder
				.comment("Durability of the Amethyst Tool Set. For reference, the Diamond Tool Set has 1561 durability. Set to -1 for infinite durability. Default = 2625")
				.defineInRange("amethyst_durability", 2625, -1, Integer.MAX_VALUE);

		map.putIfAbsent("amethyst_durability", amethyst_durability);

		black_opal_attack_damage = builder
				.comment("Base Attack Damage of the Black Opal Tool Set. Default = 5")
				.defineInRange("black_opal_ad", 5, 0, Integer.MAX_VALUE);

		map.putIfAbsent("black_opal_ad", black_opal_attack_damage);

		black_opal_efficiency = builder
				.comment("Efficiency of the Black Opal Tool Set. Default = 16")
				.defineInRange("black_opal_efficiency", 16, 0, Integer.MAX_VALUE);

		map.putIfAbsent("black_opal_efficiency", black_opal_efficiency);

		black_opal_durability = builder
				.comment("Durability of the Black Opal Tool Set. Set to -1 for infinite durability. Default = 5250")
				.defineInRange("black_opal_durability", 5250, -1, Integer.MAX_VALUE);

		map.putIfAbsent("black_opal_durability", black_opal_durability);

		netherite_opal_attack_damage = builder
				.comment("Base Attack Damage of the Netherite Opal Tool Set. Default = 6")
				.defineInRange("netherite_opal_ad", 6, 0, Integer.MAX_VALUE);

		map.putIfAbsent("netherite_opal_ad", netherite_opal_attack_damage);

		netherite_opal_efficiency = builder
				.comment("Efficiency of the Netherite Opal Tool Set. Default = 16")
				.defineInRange("netherite_opal_efficiency", 20, 0, Integer.MAX_VALUE);

		map.putIfAbsent("netherite_opal_efficiency", netherite_opal_efficiency);

		netherite_opal_durability = builder
				.comment("Durability of the Netherite Opal Tool Set. Set to -1 for infinite durability. Default = 6300")
				.defineInRange("netherite_opal_durability", 6300, -1, Integer.MAX_VALUE);

		map.putIfAbsent("netherite_opal_durability", netherite_opal_durability);

		builder.pop();

		builder.comment("Armor Settings. These values are delicate and changing them may significantly affect the strength of the armor. Changing these in a server will work, but it will not display the changes to the players without syncing.").push("armor");

		amethyst_armor_toughness = builder
				.comment("Toughness for the Amethyst Armor Set. Toughness reduces the armor penetration of high damaging attacks. Default = 3")
				.defineInRange("amethyst_armor_toughness", 3 , 0, Integer.MAX_VALUE);

		map.putIfAbsent("amethyst_armor_toughness", amethyst_armor_toughness);

		black_opal_armor_toughness = builder
				.comment("Toughness for the Black Opal Armor Set. Default = 4")
				.defineInRange("black_opal_armor_toughness", 4 , 0, Integer.MAX_VALUE);

		map.putIfAbsent("black_opal_armor_toughness", black_opal_armor_toughness);

		netherite_opal_armor_toughness = builder
				.comment("Toughness for the Netherite Opal Armor Set. Default = 5")
				.defineInRange("netherite_opal_armor_toughness", 5 , 0, Integer.MAX_VALUE);

		map.putIfAbsent("netherite_opal_armor_toughness", netherite_opal_armor_toughness);

		amethyst_armor_knockback_resistance = builder
				.comment("Knockback resistance for the Amethyst Armor Set. Knockback resistance reduces the amount of knockback the player takes. Default = 0")
				.defineInRange("amethyst_armor_knockback_resistance", 0 , 0, Integer.MAX_VALUE);

		map.putIfAbsent("amethyst_armor_knockback_resistance", amethyst_armor_knockback_resistance);

		black_opal_armor_knockback_resistance = builder
				.comment("Knockback resistance for the Black Opal Armor Set. Default = 0")
				.defineInRange("black_opal_armor_knockback_resistance", 0 , 0, Integer.MAX_VALUE);

		map.putIfAbsent("black_opal_armor_knockback_resistance", black_opal_armor_knockback_resistance);

		netherite_opal_armor_knockback_resistance = builder
				.comment("Knockback resistance for the Netherite Opal Armor Set. Default = 1")
				.defineInRange("netherite_opal_armor_knockback_resistance", 1 , 0, Integer.MAX_VALUE);

		map.putIfAbsent("netherite_opal_armor_knockback_resistance", netherite_opal_armor_knockback_resistance);

		amethyst_armor_durability = builder
				.comment("Base Durability for the Amethyst Armor Set. For reference, Diamond Armor has 33 base durability. Set to -1 for infinite durability. Default = 58")
				.defineInRange("amethyst_armor_durability", 58, -1, Integer.MAX_VALUE);

		map.putIfAbsent("amethyst_armor_durability", amethyst_armor_durability);

		black_opal_armor_durability = builder
				.comment("Base Durability for the Black Opal Armor Set. Set -1 for infinite durability. Default = 116")
				.defineInRange("black_opal_armor_durability", 116, -1, Integer.MAX_VALUE);

		map.putIfAbsent("black_opal_armor_durability", black_opal_armor_durability);

		netherite_opal_armor_durability = builder
				.comment("Base Durability for the Black Opal Armor Set. Set -1 for infinite durability. Default = 140")
				.defineInRange("netherite_opal_armor_durability", 140, -1, Integer.MAX_VALUE);

		map.putIfAbsent("netherite_opal_armor_durability", netherite_opal_armor_durability);

		amethyst_helmet_armor = builder
				.comment("Amethyst Helmet Armor Value. Indicates how many half-armor points the indicated armor will give. Default = 3")
				.defineInRange("amethyst_helmet_armor", 3, 0, Integer.MAX_VALUE);

		map.putIfAbsent("amethyst_helmet_armor", amethyst_helmet_armor);

		amethyst_chestplate_armor = builder
				.comment("Amethyst Chestplate Armor Value. Default = 8")
				.defineInRange("amethyst_chestplate_armor", 8, 0, Integer.MAX_VALUE);

		map.putIfAbsent("amethyst_chestplate_armor", amethyst_chestplate_armor);

		amethyst_leggings_armor = builder
				.comment("Amethyst Leggings Armor Value. Default = 7")
				.defineInRange("amethyst_leggings_armor", 7, 0, Integer.MAX_VALUE);

		map.putIfAbsent("amethyst_leggings_armor", amethyst_leggings_armor);

		amethyst_boots_armor = builder
				.comment("Amethyst Boots Armor Value. Default = 3")
				.defineInRange("amethyst_boots_armor", 3, 0, Integer.MAX_VALUE);

		map.putIfAbsent("amethyst_boots_armor", amethyst_boots_armor);

		black_opal_helmet_armor = builder
				.comment("Black Opal Helmet Armor Value. Default = 3")
				.defineInRange("black_opal_helmet_armor", 3, 0, Integer.MAX_VALUE);

		map.putIfAbsent("black_opal_helmet_armor", black_opal_helmet_armor);

		black_opal_chestplate_armor = builder
				.comment("Black Opal Chestplate Armor Value. Default = 9")
				.defineInRange("black_opal_chestplate_armor", 9, 0, Integer.MAX_VALUE);

		map.putIfAbsent("black_opal_chestplate_armor", black_opal_chestplate_armor);

		black_opal_leggings_armor = builder
				.comment("Black Opal Leggings Armor Value. Default = 7")
				.defineInRange("black_opal_leggings_armor", 7, 0, Integer.MAX_VALUE);

		map.putIfAbsent("black_opal_leggings_armor", black_opal_leggings_armor);

		black_opal_boots_armor = builder
				.comment("Black Opal Boots Armor Value. Default = 3")
				.defineInRange("black_opal_boots_armor", 3, 0, Integer.MAX_VALUE);

		map.putIfAbsent("black_opal_boots_armor", black_opal_boots_armor);

		netherite_opal_helmet_armor = builder
				.comment("Netherite Opal Helmet Armor Value. Default = 3")
				.defineInRange("netherite_opal_helmet_armor", 3, 0, Integer.MAX_VALUE);

		map.putIfAbsent("netherite_opal_helmet_armor", netherite_opal_helmet_armor);

		netherite_opal_chestplate_armor = builder
				.comment("Netherite Opal Chestplate Armor Value. Default = 9")
				.defineInRange("netherite_opal_chestplate_armor", 9, 0, Integer.MAX_VALUE);

		map.putIfAbsent("netherite_opal_chestplate_armor", netherite_opal_chestplate_armor);

		netherite_opal_leggings_armor = builder
				.comment("Netherite Opal Leggings Armor Value. Default = 7")
				.defineInRange("netherite_opal_leggings_armor", 7, 0, Integer.MAX_VALUE);

		map.putIfAbsent("netherite_opal_leggings_armor", netherite_opal_leggings_armor);

		netherite_opal_boots_armor = builder
				.comment("Netherite Opal Boots Armor Value. Default = 3")
				.defineInRange("netherite_opal_boots_armor", 3, 0, Integer.MAX_VALUE);

		map.putIfAbsent("netherite_opal_boots_armor", netherite_opal_boots_armor);

		builder.pop();

		builder.comment("Enchantability Settings").push("enchant");

		amethyst_enchantability = builder
				.comment("Amethyst Enchantability. A higher value makes it easier to obtain higher level enchantments for less experience. For reference, diamonds have an enchantability of 10 and gold has an enchantability of 25. Default = 35")
				.defineInRange("amethyst_enchantability", 35, 0, Integer.MAX_VALUE);

		map.putIfAbsent("amethyst_enchantability", amethyst_enchantability);

		black_opal_enchantability = builder
				.comment("Black Opal Enchantability. Default = 15")
				.defineInRange("black_opal_enchantability", 15, 0, Integer.MAX_VALUE);

		map.putIfAbsent("black_opal_enchantability", black_opal_enchantability);

		netherite_opal_enchantability = builder
				.comment("Netherite Opal Enchantability. Default = 20")
				.defineInRange("netherite_opal_enchantability", 20, 0, Integer.MAX_VALUE);

		map.putIfAbsent("netherite_opal_enchantability", netherite_opal_enchantability);

		builder.pop();

		builder.push("network");

		enable_server_config_sync = builder
				.comment("(Clients only) Sync your config to the server upon joining? (Will still require a Minecraft restart after joining)")
				.define("enable_server_config_sync", true);

		map.putIfAbsent("enable_server_config_sync", enable_server_config_sync);

		send_config_sync_packet = builder
				.comment("(Servers only) Sends a packet that attempts to sync the client config file to the server?")
				.define("send_config_sync_packet", true);

		map.putIfAbsent("send_config_sync_packet", send_config_sync_packet);

		builder.pop();
	}



}
