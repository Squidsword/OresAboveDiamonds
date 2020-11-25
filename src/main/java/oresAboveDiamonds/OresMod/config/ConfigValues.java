package oresAboveDiamonds.OresMod.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

//improved config coming up
@Mod.EventBusSubscriber
public class ConfigValues {
	
	public static ForgeConfigSpec.DoubleValue amethyst_chance;
	public static ForgeConfigSpec.DoubleValue black_opal_chance;
	
	public static ForgeConfigSpec.IntValue amethyst_max_vein_size;
	public static ForgeConfigSpec.IntValue black_opal_max_vein_size;
	
	public static ForgeConfigSpec.IntValue amethyst_armor_toughness;
	public static ForgeConfigSpec.IntValue black_opal_armor_toughness;
	
	public static ForgeConfigSpec.IntValue amethyst_armor_durability;
	public static ForgeConfigSpec.IntValue black_opal_armor_durability;
	
	public static ForgeConfigSpec.IntValue amethyst_helmet_armor;
	public static ForgeConfigSpec.IntValue amethyst_chestplate_armor;
	public static ForgeConfigSpec.IntValue amethyst_leggings_armor;
	public static ForgeConfigSpec.IntValue amethyst_boots_armor;
	
	public static ForgeConfigSpec.IntValue black_opal_helmet_armor;
	public static ForgeConfigSpec.IntValue black_opal_chestplate_armor;
	public static ForgeConfigSpec.IntValue black_opal_leggings_armor;
	public static ForgeConfigSpec.IntValue black_opal_boots_armor;
	
	public static ForgeConfigSpec.IntValue amethyst_attack_damage;
	public static ForgeConfigSpec.IntValue amethyst_efficiency;
	public static ForgeConfigSpec.IntValue amethyst_durability;
	
	public static ForgeConfigSpec.IntValue black_opal_attack_damage;
	public static ForgeConfigSpec.IntValue black_opal_efficiency;
	public static ForgeConfigSpec.IntValue black_opal_durability;
	
	public static ForgeConfigSpec.IntValue amethyst_enchantability;
	public static ForgeConfigSpec.IntValue black_opal_enchantability;
	
	public static ForgeConfigSpec.DoubleValue nether_chance_multiplier;
	public static ForgeConfigSpec.DoubleValue end_chance_multiplier;
	public static ForgeConfigSpec.DoubleValue nether_vein_multiplier;
	public static ForgeConfigSpec.DoubleValue end_vein_multiplier;
	
	public static ForgeConfigSpec.BooleanValue overworld_ores;
	public static ForgeConfigSpec.BooleanValue nether_ores;
	public static ForgeConfigSpec.BooleanValue end_ores;
	
	public static void init(ForgeConfigSpec.Builder SERVER_BUILDER) {
		
		SERVER_BUILDER.comment("Note that almost all config changes require a server restart. Dimensional Ore Configuration").push("dimensional_ore");
		
		overworld_ores = SERVER_BUILDER
				.comment("Spawn ores in the overworld? Default = true")
				.define("overworld_ores", true);
		
		nether_ores = SERVER_BUILDER
				.comment("Spawn ores in the nether? Default = false")
				.define("nether_ores", false);
		
		end_ores = SERVER_BUILDER
				.comment("Spawn ores in the end? Default = false")
				.define("end_ores", false);
		
		nether_chance_multiplier = SERVER_BUILDER
				.comment("If nether_ores is enabled, the spawn chance per chunk in the nether will be the chances set for amethyst_chance and black_opal_chance times this multiplier. The default value tries to imitate the rarity in the overworld. Default = 1.35.")
				.defineInRange("nether_chance_multiplier", 1.35d, 0.00, 10.0d);
		
		end_chance_multiplier = SERVER_BUILDER
				.comment("If end_ores is enabled, the spawn chance per chunk in the end will be the chances set for amethyst_chance and black_opal_chance times this multiplier. The default value tries to imitate the rarity in the overworld. Default = 1.0")
				.defineInRange("end_chance_multiplier", 1.0d, 0.00, 10.0d);
		
		nether_vein_multiplier = SERVER_BUILDER
				.comment("If nether_ores is enableld, multiplies the max vein size of nether ores. Rounds to the nearest integer. Final max vein size cannot exceed 64 for stability reasons. Default = 1.0")
				.defineInRange("nether_vein_multiplier", 1.0d, 0, 10.0d);
		
		end_vein_multiplier = SERVER_BUILDER
				.comment("If end_ores is enableld, multiplies the max vein size of end ores. Rounds to the nearest integer. Final max vein size cannot exceed 64 for stability reasons. Default = 1.2")
				.defineInRange("end_vein_multiplier", 1.2d, 0, 10.0d);
		
		SERVER_BUILDER.pop();
		
		SERVER_BUILDER.comment("Rarity Configuration").push("ore_rarity");
		
		amethyst_chance = SERVER_BUILDER
				.comment("Chance for an Amethyst Ore vein to spawn in a chunk. 1.00 = As common as diamonds, 0.50 = Half as common as diamonds etc. Default = 0.35")
				.defineInRange("amethyst_chance", 0.35d, 0.00, 1.00);
		
		black_opal_chance = SERVER_BUILDER
				.comment("Chance for a Black Opal Ore vein to spawn in a chunk. Default = 0.12")
				.defineInRange("black_opal_chance", 0.12d, 0.00, 1.00);
		
		amethyst_max_vein_size = SERVER_BUILDER
				.comment("Maximum vein size for an Amethyst Ore vein. For reference, diamonds have a max vein size of 8. Default = 7")
				.defineInRange("amethyst_max_vein_size", 7, 0, 64);
		
		black_opal_max_vein_size = SERVER_BUILDER
				.comment("Maximum vein size for an Black Opal Ore vein. Default = 6")
				.defineInRange("black_opal_max_vein_size", 6, 0, 64);
		
		SERVER_BUILDER.pop();
		
		SERVER_BUILDER.comment("Tool Settings. Changing these in a server will work, but it will not display the changes to the players.").push("tool");
		
		amethyst_attack_damage = SERVER_BUILDER
				.comment("Base Attack Damage of the Amethyst Tool Set. For reference, the Diamond Tool Set has 3 base attack damage. Default = 4")
				.defineInRange("amethyst_ad", 4, 0, Integer.MAX_VALUE);
		
		amethyst_efficiency = SERVER_BUILDER
				.comment("Efficiency of the Amethyst Tool Set. For reference, the Diamond Tool Set has 8 efficiency. Default = 12")
				.defineInRange("amethyst_efficiency", 12, 0, Integer.MAX_VALUE);
		
		amethyst_durability = SERVER_BUILDER
				.comment("Durability of the Amethyst Tool Set. For reference, the Diamond Tool Set has 1561 durability. Set to -1 for infinite durability. Default = 4500")
				.defineInRange("amethyst_durability", 4500, -1, Integer.MAX_VALUE);
		
		black_opal_attack_damage = SERVER_BUILDER
				.comment("Base Attack Damage of the Black Opal Tool Set. Default = 5")
				.defineInRange("black_opal_ad", 5, 0, Integer.MAX_VALUE);
		
		black_opal_efficiency = SERVER_BUILDER
				.comment("Efficiency of the Black Opal Tool Set. Default = 16")
				.defineInRange("black_opal_efficiency", 16, 0, Integer.MAX_VALUE);
		
		black_opal_durability = SERVER_BUILDER
				.comment("Durability of the Black Opal Tool Set. Set to -1 for infinite durability. Default = -1")
				.defineInRange("black_opal_durability", -1, -1, Integer.MAX_VALUE);
		
		SERVER_BUILDER.pop();
		
		SERVER_BUILDER.comment("Armor Settings. These values are delicate and changing them may significantly affect the strength of the armor.").push("armor");
		
		amethyst_armor_toughness = SERVER_BUILDER
				.comment("Toughness for the Amethyst Armor Set. Toughness reduces the armor penetration of high damaging attacks. Default = 4")
				.defineInRange("amethyst_armor_toughness", 4 , 0, Integer.MAX_VALUE);
		
		black_opal_armor_toughness = SERVER_BUILDER
				.comment("Toughness for the Black Opal Armor Set. Default = 6")
				.defineInRange("black_opal_armor_toughness", 6 , 0, Integer.MAX_VALUE);
		
		amethyst_armor_durability = SERVER_BUILDER
				.comment("Base Durability for the Amethyst Armor Set. For reference, Diamond Armor has 33 base durability. Set -1 for infinite durability. Default = 132")
				.defineInRange("amethyst_armor_durability", 132, -1, Integer.MAX_VALUE);
		
		black_opal_armor_durability = SERVER_BUILDER
				.comment("Base Durability for the Black Opal Armor Set. Set -1 for infinite durability. Default = -1")
				.defineInRange("black_opal_armor_durability", -1, -1, Integer.MAX_VALUE);
		
		amethyst_helmet_armor = SERVER_BUILDER
				.comment("Amethyst Helmet Armor Value. Indicates how many half-armor points the indicated armor will give. Default = 3")
				.defineInRange("amethyst_helmet_armor", 3, 0, Integer.MAX_VALUE);
		
		amethyst_chestplate_armor = SERVER_BUILDER
				.comment("Amethyst Chestplate Armor Value. Default = 8")
				.defineInRange("amethyst_chestplate_armor", 8, 0, Integer.MAX_VALUE);
		
		amethyst_leggings_armor = SERVER_BUILDER
				.comment("Amethyst Leggings Armor Value. Default = 7")
				.defineInRange("amethyst_leggings_armor", 7, 0, Integer.MAX_VALUE);
		
		amethyst_boots_armor = SERVER_BUILDER
				.comment("Amethyst Boots Armor Value. Default = 3")
				.defineInRange("amethyst_boots_armor", 3, 0, Integer.MAX_VALUE);
		
		black_opal_helmet_armor = SERVER_BUILDER
				.comment("Black Opal Helmet Armor Value. Default = 3")
				.defineInRange("black_opal_helmet_armor", 3, 0, Integer.MAX_VALUE);
		
		black_opal_chestplate_armor = SERVER_BUILDER
				.comment("Black Opal Chestplate Armor Value. Default = 9")
				.defineInRange("black_opal_chestplate_armor", 9, 0, Integer.MAX_VALUE);
		
		black_opal_leggings_armor = SERVER_BUILDER
				.comment("Black Opal Leggings Armor Value. Default = 7")
				.defineInRange("black_opal_leggings_armor", 7, 0, Integer.MAX_VALUE);
		
		black_opal_boots_armor = SERVER_BUILDER
				.comment("Black Opal Boots Armor Value. Default = 3")
				.defineInRange("black_opal_boots_armor", 3, 0, Integer.MAX_VALUE);
		
		SERVER_BUILDER.pop();
		
		SERVER_BUILDER.comment("Enchantability Settings").push("enchant");
		
		amethyst_enchantability = SERVER_BUILDER
				.comment("Amethyst Enchantability. A higher value makes it easier to obtain higher level enchantments for less experience. For reference, diamonds have an enchantability of 10 and gold has an enchantability of 25. Default = 35")
				.defineInRange("amethyst", 35, 0, Integer.MAX_VALUE);
		
		black_opal_enchantability = SERVER_BUILDER
				.comment("Black Opal Enchantability. Default = 15")
				.defineInRange("black_opal", 15, 0, Integer.MAX_VALUE);
		
		SERVER_BUILDER.pop();
		
	}
	
}
