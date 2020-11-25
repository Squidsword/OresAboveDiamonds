package oresAboveDiamonds.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import oresAboveDiamonds.util.Reference;

@Config(modid = Reference.MOD_ID, name = "ores_above_diamonds_1.12.2-v4.2")
public class OADConfig {
	
	@Config.Name("§4Config changes need a game restart!")
	@Comment("Minecraft locks all tool and armor statistics and many other values when the game starts.")
	public static boolean aac = true;
	
	@Config.Name("§8End")
	public static Aab_EndConfig aab_endconfig = new Aab_EndConfig(false, 1.0d, 1.25d, 1.0d, 1.25d, 0, 75, 0, 75);
	
	public static class Aab_EndConfig {
		
		public Aab_EndConfig(boolean aaaa_enable_end_ores, double ab_end_amethyst_chance_multiplier, 
						double ac_end_amethyst_vein_multiplier, double ad_end_black_opal_chance_multiplier, 
						double ae_end_black_opal_vein_multiplier, int af_end_amethyst_min_y_value, int ag_end_amethyst_max_y_value,
						int ah_end_black_opal_min_y_value, int ai_end_black_opal_max_y_value) {
			
			this.aaaa_enable_end_ores = aaaa_enable_end_ores;
			this.ab_end_amethyst_chance_multiplier = ab_end_amethyst_chance_multiplier;
			this.ac_end_amethyst_vein_multiplier = ac_end_amethyst_vein_multiplier;
			this.ad_end_black_opal_chance_multiplier = ad_end_black_opal_chance_multiplier;
			this.ae_end_black_opal_vein_multiplier = ae_end_black_opal_vein_multiplier;
			this.af_end_amethyst_min_y_value = af_end_amethyst_min_y_value;
			this.ag_end_amethyst_max_y_value = ag_end_amethyst_max_y_value;
			this.ah_end_black_opal_min_y_value = ah_end_black_opal_min_y_value;
			this.ai_end_black_opal_max_y_value = ai_end_black_opal_max_y_value;
		
		}

		@Config.Name("§4§r§8End Ores")
		@Comment("Spawn both ores in the end?")
		public boolean aaaa_enable_end_ores;
		
		@Config.Name("§dEnd Amethyst Chance Multiplier")
		@Comment("How much the overworld chance per chunk gets multiplied in the End.")
		public double ab_end_amethyst_chance_multiplier;
		
		@Config.Name("§dEnd Amethyst Vein Size Multiplier")
		@Comment("How much the overworld vein size gets multiplied in the End.")
		public double ac_end_amethyst_vein_multiplier;
		
		@Config.Name("§5End Black Opal Chance Multiplier")
		@Comment("How much the overworld chance per chunk gets multiplied in the End.")
		public double ad_end_black_opal_chance_multiplier;
		
		@Config.Name("§5End Black Opal Vein Size Multiplier")
		@Comment("How much the overworld vein size gets multiplied in the End.")
		public double ae_end_black_opal_vein_multiplier;
		
		@Config.Name("§dEnd Amethyst Min Y Value")
		@Comment("Lowest point where the amethyst can spawn.")
		public int af_end_amethyst_min_y_value;
		
		@Config.Name("§dEnd Amethyst Max Y Value")
		@Comment("Highest point where the amethyst can spawn.")
		public int ag_end_amethyst_max_y_value;
		
		@Config.Name("§5End Black Opal Min Y Value")
		@Comment("Lowest point where the black opal can spawn.")
		public int ah_end_black_opal_min_y_value;
		
		@Config.Name("§5End Black Opal Max Y Value")
		@Comment("Highest point where the black opal can spawn.")
		public int ai_end_black_opal_max_y_value;
	}
	
	@Config.Name("§4Nether")
	public static Aaa_NetherConfig aaa_netherconfig = new Aaa_NetherConfig(false, 1.35d, 1.0d, 1.35d, 1.0d, 0, 128, 0, 128);
	
	public static class Aaa_NetherConfig {
		
		public Aaa_NetherConfig(boolean aa_enable_nether_ores, double ab_nether_amethyst_chance_multiplier, 
						double ac_nether_amethyst_vein_multiplier, double ad_nether_black_opal_chance_multiplier, 
						double ae_nether_black_opal_vein_multiplier, int af_nether_amethyst_min_y_value, int ag_nether_amethyst_max_y_value,
						int ah_nether_black_opal_min_y_value, int ai_nether_black_opal_max_y_value) {
			
			this.aa_enable_nether_ores = aa_enable_nether_ores;
			this.ab_nether_amethyst_chance_multiplier = ab_nether_amethyst_chance_multiplier;
			this.ac_nether_amethyst_vein_multiplier = ac_nether_amethyst_vein_multiplier;
			this.ad_nether_black_opal_chance_multiplier = ad_nether_black_opal_chance_multiplier;
			this.ae_nether_black_opal_vein_multiplier = ae_nether_black_opal_vein_multiplier;
			this.af_nether_amethyst_min_y_value = af_nether_amethyst_min_y_value;
			this.ag_nether_amethyst_max_y_value = ag_nether_amethyst_max_y_value;
			this.ah_nether_black_opal_min_y_value = ah_nether_black_opal_min_y_value;
			this.ai_nether_black_opal_max_y_value = ai_nether_black_opal_max_y_value;
		
		}

		@Config.Name("§4Nether Ores")
		@Comment("Spawn both ores in the nether?")
		public boolean aa_enable_nether_ores;
		
		@Config.Name("§dNether Amethyst Chance Multiplier")
		@Comment("How much the overworld chance per chunk gets multiplied in the Nether.")
		public double ab_nether_amethyst_chance_multiplier;
		
		@Config.Name("§dNether Amethyst Vein Size Multiplier")
		@Comment("How much the overworld vein size gets multiplied in the Nether.")
		public double ac_nether_amethyst_vein_multiplier;
		
		@Config.Name("§5Nether Black Opal Chance Multiplier")
		@Comment("How much the overworld chance per chunk gets multiplied in the Nether.")
		public double ad_nether_black_opal_chance_multiplier;
		
		@Config.Name("§5Nether Black Opal Vein Size Multiplier")
		@Comment("How much the overworld vein size gets multiplied in the Nether.")
		public double ae_nether_black_opal_vein_multiplier;
		
		@Config.Name("§dNether Amethyst Min Y Value")
		@Comment("Lowest point where the amethyst can spawn.")
		public int af_nether_amethyst_min_y_value;
		
		@Config.Name("§dNether Amethyst Max Y Value")
		@Comment("Highest point where the amethyst can spawn.")
		public int ag_nether_amethyst_max_y_value;
		
		@Config.Name("§5Nether Black Opal Min Y Value")
		@Comment("Lowest point where the black opal can spawn.")
		public int ah_nether_black_opal_min_y_value;
		
		@Config.Name("§5Nether Black Opal Max Y Value")
		@Comment("Highest point where the black opal can spawn.")
		public int ai_nether_black_opal_max_y_value;
	}
		@Config.Name("§6Server Config Sync")
		@Comment("When you enter a server, it will automatically sync the configs so you will be able to see proper values such as durability. Will require a Minecraft restart.")
		public static boolean abe_enable_server_config_sync = true;
		
		@Config.Name("§6Send Config Sync Packet")
		@Comment("Sends a packet that attempts to automatically sync the config of a client when the client joins. This is only applicable to servers and is only effective when changed from the server's .cfg file")
		public static boolean zzy_send_config_packet = true;
	
		@Config.Name("§9Overworld Ores")
		@Comment("Spawn both ores in the overworld?")
		public static boolean abg_enable_overworld_ores = true;
		
		@Config.Name("§cOld Combat Mechanics")
		@Comment("Bases tool attack damage on the old combat system. Intended for use with a mod that removes the attack speed cooldown.")
		public static boolean old_combat_mechanics = false;
		
		@Config.Name("§cPrior work penalty for <= 0 durability.")
		@Comment("I had to hardcode default vanilla anvil behavior for infinite durability items (meaning this setting is only relevant if you set the durability of any tool to infinite), including the prior work penalty. The prior work penalty exponentially increases the cost to use the anvil for items that have already used it before. If you have disabled the prior work penalty by means of another mod or plugin, it won't automatically apply for this mod. That's what this config option is for.")
		public static boolean zzz_infinite_durability_prior_work_penalty = true;
	
		@Config.Name("§2Retrogen")
		@Comment("Retrogen allows ores to spawn in already generated chunks.")
		public static boolean ab_enable_retrogen = true;
		
		@Config.Name("§dAmethyst Chance")
		@Comment("1.00 = Same rarity as diamonds. Caps at 1.00.")
		public static double ac_amethyst_chance = 0.35;
		
		@Config.Name("§5Black Opal Chance")
		@Comment("1.00 = Same rarity as diamonds. Caps at 1.00.")
		public static double ad_black_opal_chance = 0.12;
		
		@Config.Name("§dAmethyst Minimum Vein Size")
		@Comment("Minimum amount of ores possible in a single vein.")
		public static int ae_min_amethyst_vein_size = 1;
		
		@Config.Name("§dAmethyst Maximum Vein Size")
		@Comment("Maximum amount of ores possible in a single vein.")
		public static int af_max_amethyst_vein_size = 7;
		
		@Config.Name("§5Black Opal Minimum Vein Size")
		@Comment("Minimum amount of ores possible in a single vein.")
		public static int ag_min_black_opal_vein_size = 1;
		
		@Config.Name("§5Black Opal Maximum Vein Size")
		@Comment("Maximum amount of ores possible in a single vein.")
		public static int ah_max_black_opal_vein_size = 6;
		
		@Config.Name("§dAmethyst Min Y Value")
		@Comment("Lowest height the Amethyst can spawn in.")
		public static int ai_amethyst_min_y_value = 0;
		
		@Config.Name("§dAmethyst Max Y Value")
		@Comment("Highest height the Amethyst can spawn in.")
		public static int aj_amethyst_max_y_value = 16;
		
		@Config.Name("§5Black Opal Min Y Value")
		@Comment("Lowest height the Amethyst can spawn in.")
		public static int ak_black_opal_min_y_value = 0;
		
		@Config.Name("§5Black Opal Max Y Value")
		@Comment("Highest height the Amethyst can spawn in.")
		public static int al_black_opal_max_y_value = 16;
		
		@Config.Name("§dAmethyst Enchantability")
		@Comment("The higher enchantability, the better enchantments. Diamonds have 10, Gold has 25.")
		public static int am_amethyst_enchantability = 35;
		
		@Config.Name("§5Black Opal Enchantability")
		@Comment("The higher enchantability, the better enchantments. Diamonds have 10, Gold has 25.")
		public static int an_black_opal_enchantability = 15;
	
		
		
		@Config.Name("§dAmethyst Attack Damage")
		@Comment("The Diamond Tool Set has 3.")
		public static int ao_amethyst_attack_damage = 4;
		
		@Config.Name("§dAmethyst Efficiency")
		@Comment("The Diamond Tool Set has 8.")
		public static int ap_amethyst_efficiency = 12;
		
		@Config.Name("§dAmethyst Durability")
		@Comment("The Diamond Tool Set has 1561.")
		public static int aq_amethyst_durability = 2625;
		
		@Config.Name("§5Black Opal Attack Damage")
		@Comment("The Diamond Tool Set has 3.")
		public static int ar_black_opal_attack_damage = 5;
		
		@Config.Name("§5Black Opal Efficiency")
		@Comment("The Diamond Tool Set has 8.")
		public static int as_black_opal_efficiency = 16;
		
		@Config.Name("§5Black Opal Durability")
		@Comment("The Diamond Tool Set has 1561. -1 = Infinite Durability.")
		public static int at_black_opal_durability = 5250;
		
		
		@Config.Name("§dAmethyst Armor Toughness")
		@Comment("This reduces the armor penetration from high damage attacks. The Diamond Armor Set has 2.")
		public static int au_amethyst_toughness = 4;
		
		@Config.Name("§5Black Opal Armor Toughness")
		@Comment("This reduces the armor penetration from high damage attacks. The Diamond Armor Set has 2.")
		public static int av_black_opal_toughness = 6;
		
		@Config.Name("§dAmethyst Armor Base Durability")
		@Comment("This value will be multiplied by 10-20x depending on the armor piece. The Diamond Armor Set has 33.")
		public static int aw_amethyst_armor_durability = 58;
		
		@Config.Name("§5Black Opal Armor Base Durability")
		@Comment("This value will be multiplied by 10-20x depending on the armor piece. The Diamond Armor Set has 33. -1 = Infinite Durability.")
		public static int ax_black_opal_armor_durability = 116;
		
		@Config.Name("§dAmethyst Helmet Armor Value")
		@Comment("How many half armor bars the armor piece gives. These values are extremely delicate.")
		public static int ay_amethyst_helmet_armor = 3;
		
		@Config.Name("§dAmethyst Chestplate Armor Value")
		@Comment("How many half armor bars the armor piece gives. These values are extremely delicate.")
		public static int az_amethyst_chestplate_armor = 8;
		
		@Config.Name("§dAmethyst Leggings Armor Value")
		@Comment("How many half armor bars the armor piece gives. These values are extremely delicate.")
		public static int ba_amethyst_leggings_armor = 7;
		
		@Config.Name("§dAmethyst Boots Armor Value")
		@Comment("How many half armor bars the armor piece gives. These values are extremely delicate.")
		public static int bb_amethyst_boots_armor = 3;
		
		@Config.Name("§5Black Opal Helmet Armor Value")
		@Comment("How many half armor bars the armor piece gives. These values are extremely delicate.")
		public static int bc_black_opal_helmet_armor = 3;
		
		@Config.Name("§5Black Opal Chestplate Armor Value")
		@Comment("How many half armor bars the armor piece gives. These values are extremely delicate.")
		public static int bd_black_opal_chestplate_armor = 9;
		
		@Config.Name("§5Black Opal Leggings Armor Value")
		@Comment("How many half armor bars the armor piece gives. These values are extremely delicate.")
		public static int be_black_opal_leggings_armor = 7;
		
		@Config.Name("§5Black Opal Boots Armor Value")
		@Comment("How many half armor bars the armor piece gives. These values are extremely delicate.")
		public static int bf_black_opal_boots_armor = 3;
		

		
		@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
		private static class EventHandler {
			
			@SubscribeEvent
			public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
				System.out.println("Config changed.");
				if (event.getModID().equals(Reference.MOD_ID)) {
					ConfigManager.sync(Reference.MOD_ID, Config.Type.INSTANCE);	
				}
			}
		}	
}
