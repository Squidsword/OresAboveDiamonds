package oresAboveDiamonds.commands;

import java.util.List;

import com.google.common.collect.Lists;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.suggestion.SuggestionProvider;

import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.network.PacketDistributor;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.network.OADPacketHandler;
import oresAboveDiamonds.network.PacketSyncConfig;

public class CommandConfigChange {

	private static final SuggestionProvider<CommandSource> SUGGEST_OPTION = (source, builder) -> {
		return ISuggestionProvider.suggest(ConfigValuesList.getAllValues().stream(), builder);
	};
	
	private static final SuggestionProvider<CommandSource> SUGGEST_ACTION = (source, builder) -> {
		
		List<String> actions = Lists.newArrayList();
		actions.add("read");
		actions.add("write");
		
		return ISuggestionProvider.suggest(actions.stream(), builder);
	};
	
	private static final SuggestionProvider<CommandSource> SUGGEST_COMMAND = (source, builder) -> {
		List<String> words = Lists.newArrayList();
		words.add("config");
		words.add("help");
		words.add("sync");
		return ISuggestionProvider.suggest(words.stream(), builder);
	};
	
	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		
				dispatcher.register(Commands.literal("oresabovediamonds").requires(context -> {
					return context.hasPermissionLevel(3);
				})
                .executes(source -> {
                	return run(source.getSource());
                })
                .then(Commands.argument("command", StringArgumentType.string()).suggests(SUGGEST_COMMAND).executes(source -> {
                	return run(source.getSource(), StringArgumentType.getString(source, "command"));
                })
                .then(Commands.argument("option", StringArgumentType.string()).suggests(SUGGEST_OPTION).executes(source -> {
                	
                	return run(source.getSource(), StringArgumentType.getString(source, "command"), StringArgumentType.getString(source, "option"));
                	
                })
                .then(Commands.argument("action", StringArgumentType.string()).suggests(SUGGEST_ACTION).executes(source -> {
                	return run(source.getSource(), StringArgumentType.getString(source, "command"), StringArgumentType.getString(source, "option"), StringArgumentType.getString(source, "action"));
                }).then(Commands.argument("value", StringArgumentType.string()).executes(source -> {
                	return run(source.getSource(), StringArgumentType.getString(source, "command"), StringArgumentType.getString(source, "option"), StringArgumentType.getString(source, "action"), StringArgumentType.getString(source, "value"));
                }))))));      
     
					dispatcher.register(Commands.literal("oad").requires(context -> {
					return context.hasPermissionLevel(3);
				})
                .executes(source -> {
                	return run(source.getSource());
                })
                .then(Commands.argument("command", StringArgumentType.string()).suggests(SUGGEST_COMMAND).executes(source -> {
                	return run(source.getSource(), StringArgumentType.getString(source, "command"));
                })
                .then(Commands.argument("option", StringArgumentType.string()).suggests(SUGGEST_OPTION).executes(source -> {
                	
                	return run(source.getSource(), StringArgumentType.getString(source, "command"), StringArgumentType.getString(source, "option"));
                	
                })
                .then(Commands.argument("action", StringArgumentType.string()).suggests(SUGGEST_ACTION).executes(source -> {
                	return run(source.getSource(), StringArgumentType.getString(source, "command"), StringArgumentType.getString(source, "option"), StringArgumentType.getString(source, "action"));
                }).then(Commands.argument("value", StringArgumentType.string()).executes(source -> {
                	return run(source.getSource(), StringArgumentType.getString(source, "command"), StringArgumentType.getString(source, "option"), StringArgumentType.getString(source, "action"), StringArgumentType.getString(source, "value"));
                }))))));
    }

	public static int run(CommandSource source){
		source.sendFeedback(new TranslationTextComponent("§5- §dOres Above Diamonds §5-"), false);
		source.sendFeedback(new TranslationTextComponent("/OAD help §7- Displays the list of commands and arguments."), false);
		source.sendFeedback(new TranslationTextComponent("/OAD config <config_option> <read / write> <value> §7- Accesses the server's config file. The majority of changes require a minecraft restart."), false);
		return 1;
	}
	
	public static int run(CommandSource source, String command){
		if(command.equalsIgnoreCase("help")) {
			source.sendFeedback(new TranslationTextComponent(""), false);
			source.sendFeedback(new TranslationTextComponent("§5- §dOres Above Diamonds §5-"), false);
			source.sendFeedback(new TranslationTextComponent("/OAD help §7- Displays the list of commands and arguments."), false);
			source.sendFeedback(new TranslationTextComponent("/OAD config <config_option> <read / write> <value_to_write> §7- Accesses the config file."), false);
			source.sendFeedback(new TranslationTextComponent("/OAD sync §7- Syncronizes config will all clients if on a multiplayer server. This is normally done once automatically right after the client joins the server, however they still need to restart minecraft. To finalize most changes, a server restart is still required."), false);
		} else if(command.equalsIgnoreCase("config")) {
			source.sendFeedback(new TranslationTextComponent(""), false);
			source.sendFeedback(new TranslationTextComponent("§d/OAD config"), false);
			source.sendFeedback(new TranslationTextComponent("These commands can change the config file from within the game. For a singleplayer world, you can also change the config from the config folder at %appdata% -> .minecraft ."), false);
			source.sendFeedback(new TranslationTextComponent(""), false);
			source.sendFeedback(new TranslationTextComponent("Use the syntax /OAD config <config_option> <read / write> <new_value_to_write>"), false);
		} else if(command.equalsIgnoreCase("sync")){
			
			int amethyst_enchant = OADConfig.amethyst_enchantability.get();
			int black_opal_enchant = OADConfig.black_opal_enchantability.get();
			
			int amethyst_ad = OADConfig.amethyst_attack_damage.get();
			int amethyst_efficiency = OADConfig.amethyst_efficiency.get();
			int amethyst_tool_durability = OADConfig.amethyst_durability.get();
			
			int black_opal_ad = OADConfig.black_opal_attack_damage.get();
			int black_opal_efficiency = OADConfig.black_opal_efficiency.get();
			int black_opal_tool_durability = OADConfig.black_opal_durability.get();
			
			int amethyst_toughness = OADConfig.amethyst_armor_toughness.get();
			int black_opal_toughness = OADConfig.black_opal_armor_toughness.get();
			
			int amethyst_armor_durability = OADConfig.amethyst_armor_durability.get();
			int black_opal_armor_durability = OADConfig.black_opal_armor_durability.get();
			
		    int amethyst_helmet_armor = OADConfig.amethyst_helmet_armor.get();
			int amethyst_chestplate_armor = OADConfig.amethyst_chestplate_armor.get();
			int amethyst_leggings_armor = OADConfig.amethyst_leggings_armor.get();
			int amethyst_boots_armor = OADConfig.amethyst_boots_armor.get();
			
			int black_opal_helmet_armor = OADConfig.black_opal_helmet_armor.get();
			int black_opal_chestplate_armor = OADConfig.black_opal_chestplate_armor.get();
			int black_opal_leggings_armor = OADConfig.black_opal_leggings_armor.get();
			int black_opal_boots_armor = OADConfig.black_opal_boots_armor.get();
			
			boolean old_combat_mechanics = OADConfig.old_combat_mechanics.get();
			
			OADPacketHandler.INSTANCE.send(PacketDistributor.ALL.noArg(), new PacketSyncConfig(amethyst_enchant, black_opal_enchant, amethyst_ad, amethyst_efficiency, amethyst_tool_durability,
					 black_opal_ad, black_opal_efficiency, black_opal_tool_durability, amethyst_toughness, black_opal_toughness,
					 amethyst_armor_durability, black_opal_armor_durability, amethyst_helmet_armor, amethyst_chestplate_armor,
					 amethyst_leggings_armor, amethyst_boots_armor, black_opal_helmet_armor, black_opal_chestplate_armor,
					 black_opal_leggings_armor, black_opal_boots_armor, old_combat_mechanics));
			
			source.sendFeedback(new TranslationTextComponent("Client configurations synced. If they had any configuration changes, they will be notified and will be asked to restart their minecraft to finalize changes. This is an optimal time to restart the server so the changes can take effect."), false);
		} else {
			source.sendErrorMessage(new TranslationTextComponent("ERROR: Unknown command. Use /OAD help."));
		}
		
		return 1;
	}
	
	public static int run(CommandSource source, String command, String option){
		
			if(option.equalsIgnoreCase("amethyst_chance")) {source.sendFeedback(new TranslationTextComponent("Amethyst Chance: §d" + OADConfig.amethyst_chance.get().toString()), false); }
			if(option.equalsIgnoreCase("black_opal_chance")) {source.sendFeedback(new TranslationTextComponent("Black Opal Chance: §5" + OADConfig.black_opal_chance.get().toString()), false); }
			
			if(option.equalsIgnoreCase("amethyst_max_vein_size")) {source.sendFeedback(new TranslationTextComponent("Amethyst Max Vein Size: §d" + OADConfig.amethyst_max_vein_size.get().toString()), false); }
			if(option.equalsIgnoreCase("black_opal_max_vein_size")) {source.sendFeedback(new TranslationTextComponent("Black Opal Max Vein Size: §5" + OADConfig.black_opal_max_vein_size.get().toString()), false); }
			
			if(option.equalsIgnoreCase("amethyst_armor_toughness")) {source.sendFeedback(new TranslationTextComponent("Amethyst Armor Toughness: §d" + OADConfig.amethyst_armor_toughness.get().toString()), false); }
			if(option.equalsIgnoreCase("black_opal_armor_toughness")) {source.sendFeedback(new TranslationTextComponent("Black Opal Armor Toughness §5" + OADConfig.black_opal_armor_toughness.get().toString()), false); }
			
			if(option.equalsIgnoreCase("amethyst_armor_durability")) {source.sendFeedback(new TranslationTextComponent("Amethyst Armor Durability: §d" + OADConfig.amethyst_armor_durability.get().toString()), false); }
			if(option.equalsIgnoreCase("black_opal_armor_durability")) {source.sendFeedback(new TranslationTextComponent("Black Opal Armor Durabiliity §5" + OADConfig.black_opal_armor_durability.get().toString()), false); }
			
			if(option.equalsIgnoreCase("amethyst_helmet_armor")) {source.sendFeedback(new TranslationTextComponent("Amethyst Helmet Armor: §d" + OADConfig.amethyst_helmet_armor.get().toString()), false); }
			if(option.equalsIgnoreCase("amethyst_chestplate_armor")) {source.sendFeedback(new TranslationTextComponent("Amethyst Chestplate Armor: §d" + OADConfig.amethyst_chestplate_armor.get().toString()), false); }
			if(option.equalsIgnoreCase("amethyst_leggings_armor")) {source.sendFeedback(new TranslationTextComponent("Amethyst Leggings Armor: §d" + OADConfig.amethyst_leggings_armor.get().toString()), false); }
			if(option.equalsIgnoreCase("amethyst_boots_armor")) {source.sendFeedback(new TranslationTextComponent("Amethyst Boots Armor: §d" + OADConfig.amethyst_boots_armor.get().toString()), false); }
			
			if(option.equalsIgnoreCase("black_opal_helmet_armor")) {source.sendFeedback(new TranslationTextComponent("Black Opal Helmet Armor: §5" + OADConfig.black_opal_helmet_armor.get().toString()), false); }
			if(option.equalsIgnoreCase("black_opal_chestplate_armor")) {source.sendFeedback(new TranslationTextComponent("Black Opal Chetplate Armor: §5" + OADConfig.black_opal_chestplate_armor.get().toString()), false); }
			if(option.equalsIgnoreCase("black_opal_leggings_armor")) {source.sendFeedback(new TranslationTextComponent("Black Opal Leggings Armor: §5" + OADConfig.black_opal_leggings_armor.get().toString()), false); }
			if(option.equalsIgnoreCase("black_opal_boots_armor")) {source.sendFeedback(new TranslationTextComponent("Black Opal Boots Armor: §5" + OADConfig.black_opal_boots_armor.get().toString()), false); }
			
			if(option.equalsIgnoreCase("amethyst_attack_damage")) {source.sendFeedback(new TranslationTextComponent("Amethyst Attack Damage: §d" + OADConfig.amethyst_attack_damage.get().toString()), false); }
			if(option.equalsIgnoreCase("amethyst_efficiency")) {source.sendFeedback(new TranslationTextComponent("Amethyst Efficiency: §d" + OADConfig.amethyst_efficiency.get().toString()), false); }
			if(option.equalsIgnoreCase("amethyst_durability")) {source.sendFeedback(new TranslationTextComponent("Amethyst Durability: §d" + OADConfig.amethyst_durability.get().toString()), false); }
			
			if(option.equalsIgnoreCase("black_opal_attack_damage")) {source.sendFeedback(new TranslationTextComponent("Black Opal Attack Damage: §5" + OADConfig.black_opal_attack_damage.get().toString()), false); }
			if(option.equalsIgnoreCase("black_opal_efficiency")) {source.sendFeedback(new TranslationTextComponent("Black Opal Efficiency: §5" + OADConfig.black_opal_efficiency.get().toString()), false); }
			if(option.equalsIgnoreCase("black_opal_durability")) {source.sendFeedback(new TranslationTextComponent("Black Opal Durability: §5" + OADConfig.black_opal_durability.get().toString()), false); }
			
			if(option.equalsIgnoreCase("amethyst_enchantability")) {source.sendFeedback(new TranslationTextComponent("Amethyst Enchantability: §d" + OADConfig.amethyst_enchantability.get().toString()), false); }
			if(option.equalsIgnoreCase("black_opal_enchantability")) {source.sendFeedback(new TranslationTextComponent("Black Opal Enchantability: §5" + OADConfig.black_opal_enchantability.get().toString()), false); }
			
			if(option.equalsIgnoreCase("nether_chance_multiplier")) {source.sendFeedback(new TranslationTextComponent("Nether Chance Multiplier: §" + OADConfig.nether_chance_multiplier.get().toString()), false); }
			if(option.equalsIgnoreCase("end_chance_multiplier")) {source.sendFeedback(new TranslationTextComponent("End Chance Multiplier: §" + OADConfig.end_chance_multiplier.get().toString()), false); }
			if(option.equalsIgnoreCase("nether_vein_multiplier")) {source.sendFeedback(new TranslationTextComponent("Nether Vein Multiplier: §" + OADConfig.nether_vein_multiplier.get().toString()), false); }
			if(option.equalsIgnoreCase("end_vein_multiplier")) {source.sendFeedback(new TranslationTextComponent("End Vein Multiplier: §" + OADConfig.end_vein_multiplier.get().toString()), false); }
			
			if(option.equalsIgnoreCase("enable_server_config_sync")) {source.sendFeedback(new TranslationTextComponent("(Client Side) Enable Server Config Sync: §" + OADConfig.enable_server_config_sync.get().toString()), false); }
			if(option.equalsIgnoreCase("send_config_sync_packet")) {source.sendFeedback(new TranslationTextComponent("(Server Side) Send Config Sync Packet: §" + OADConfig.send_config_sync_packet.get().toString()), false); }
			if(option.equalsIgnoreCase("overworld_ores")) {source.sendFeedback(new TranslationTextComponent("Overworld Ores: §" + OADConfig.overworld_ores.get().toString()), false); }
			if(option.equalsIgnoreCase("nether_ores")) {source.sendFeedback(new TranslationTextComponent("Nether Ores: §" + OADConfig.nether_ores.get().toString()), false); }
			if(option.equalsIgnoreCase("end_ores")) {source.sendFeedback(new TranslationTextComponent("End Ores: §" + OADConfig.end_ores.get().toString()), false); }
			if(option.equalsIgnoreCase("old_combat_mechanics")) {source.sendFeedback(new TranslationTextComponent("Old Combat Mechanics §" + OADConfig.old_combat_mechanics.get().toString()), false); }
			
		return 1;
	}
	
	public static int run(CommandSource source, String command, String option, String action){
		if(action.equalsIgnoreCase("write")) {
			source.sendErrorMessage(new TranslationTextComponent("ERROR: Please enter a value to write. Use /OAD help."));
		} else if(action.equalsIgnoreCase("read")) {
			if(option.equalsIgnoreCase("amethyst_chance")) {source.sendFeedback(new TranslationTextComponent("Amethyst Chance: §d" + OADConfig.amethyst_chance.get().toString()), false); }
			if(option.equalsIgnoreCase("black_opal_chance")) {source.sendFeedback(new TranslationTextComponent("Black Opal Chance: §5" + OADConfig.black_opal_chance.get().toString()), false); }
			
			if(option.equalsIgnoreCase("amethyst_max_vein_size")) {source.sendFeedback(new TranslationTextComponent("Amethyst Max Vein Size: §d" + OADConfig.amethyst_max_vein_size.get().toString()), false); }
			if(option.equalsIgnoreCase("black_opal_max_vein_size")) {source.sendFeedback(new TranslationTextComponent("Black Opal Max Vein Size: §5" + OADConfig.black_opal_max_vein_size.get().toString()), false); }
			
			if(option.equalsIgnoreCase("amethyst_armor_toughness")) {source.sendFeedback(new TranslationTextComponent("Amethyst Armor Toughness: §d" + OADConfig.amethyst_armor_toughness.get().toString()), false); }
			if(option.equalsIgnoreCase("black_opal_armor_toughness")) {source.sendFeedback(new TranslationTextComponent("Black Opal Armor Toughness §5" + OADConfig.black_opal_armor_toughness.get().toString()), false); }
			
			if(option.equalsIgnoreCase("amethyst_armor_durability")) {source.sendFeedback(new TranslationTextComponent("Amethyst Armor Durability: §d" + OADConfig.amethyst_armor_durability.get().toString()), false); }
			if(option.equalsIgnoreCase("black_opal_armor_durability")) {source.sendFeedback(new TranslationTextComponent("Black Opal Armor Durabiliity §5" + OADConfig.black_opal_armor_durability.get().toString()), false); }
			
			if(option.equalsIgnoreCase("amethyst_helmet_armor")) {source.sendFeedback(new TranslationTextComponent("Amethyst Helmet Armor: §d" + OADConfig.amethyst_helmet_armor.get().toString()), false); }
			if(option.equalsIgnoreCase("amethyst_chestplate_armor")) {source.sendFeedback(new TranslationTextComponent("Amethyst Chestplate Armor: §d" + OADConfig.amethyst_chestplate_armor.get().toString()), false); }
			if(option.equalsIgnoreCase("amethyst_leggings_armor")) {source.sendFeedback(new TranslationTextComponent("Amethyst Leggings Armor: §d" + OADConfig.amethyst_leggings_armor.get().toString()), false); }
			if(option.equalsIgnoreCase("amethyst_boots_armor")) {source.sendFeedback(new TranslationTextComponent("Amethyst Boots Armor: §d" + OADConfig.amethyst_boots_armor.get().toString()), false); }
			
			if(option.equalsIgnoreCase("black_opal_helmet_armor")) {source.sendFeedback(new TranslationTextComponent("Black Opal Helmet Armor: §5" + OADConfig.black_opal_helmet_armor.get().toString()), false); }
			if(option.equalsIgnoreCase("black_opal_chestplate_armor")) {source.sendFeedback(new TranslationTextComponent("Black Opal Chetplate Armor: §5" + OADConfig.black_opal_chestplate_armor.get().toString()), false); }
			if(option.equalsIgnoreCase("black_opal_leggings_armor")) {source.sendFeedback(new TranslationTextComponent("Black Opal Leggings Armor: §5" + OADConfig.black_opal_leggings_armor.get().toString()), false); }
			if(option.equalsIgnoreCase("black_opal_boots_armor")) {source.sendFeedback(new TranslationTextComponent("Black Opal Boots Armor: §5" + OADConfig.black_opal_boots_armor.get().toString()), false); }
			
			if(option.equalsIgnoreCase("amethyst_attack_damage")) {source.sendFeedback(new TranslationTextComponent("Amethyst Attack Damage: §d" + OADConfig.amethyst_attack_damage.get().toString()), false); }
			if(option.equalsIgnoreCase("amethyst_efficiency")) {source.sendFeedback(new TranslationTextComponent("Amethyst Efficiency: §d" + OADConfig.amethyst_efficiency.get().toString()), false); }
			if(option.equalsIgnoreCase("amethyst_durability")) {source.sendFeedback(new TranslationTextComponent("Amethyst Durability: §d" + OADConfig.amethyst_durability.get().toString()), false); }
			
			if(option.equalsIgnoreCase("black_opal_attack_damage")) {source.sendFeedback(new TranslationTextComponent("Black Opal Attack Damage: §5" + OADConfig.black_opal_attack_damage.get().toString()), false); }
			if(option.equalsIgnoreCase("black_opal_efficiency")) {source.sendFeedback(new TranslationTextComponent("Black Opal Efficiency: §5" + OADConfig.black_opal_efficiency.get().toString()), false); }
			if(option.equalsIgnoreCase("black_opal_durability")) {source.sendFeedback(new TranslationTextComponent("Black Opal Durability: §5" + OADConfig.black_opal_durability.get().toString()), false); }
			
			if(option.equalsIgnoreCase("amethyst_enchantability")) {source.sendFeedback(new TranslationTextComponent("Amethyst Enchantability: §d" + OADConfig.amethyst_enchantability.get().toString()), false); }
			if(option.equalsIgnoreCase("black_opal_enchantability")) {source.sendFeedback(new TranslationTextComponent("Black Opal Enchantability: §5" + OADConfig.black_opal_enchantability.get().toString()), false); }
			
			if(option.equalsIgnoreCase("nether_chance_multiplier")) {source.sendFeedback(new TranslationTextComponent("Nether Chance Multiplier: §" + OADConfig.nether_chance_multiplier.get().toString()), false); }
			if(option.equalsIgnoreCase("end_chance_multiplier")) {source.sendFeedback(new TranslationTextComponent("End Chance Multiplier: §" + OADConfig.end_chance_multiplier.get().toString()), false); }
			if(option.equalsIgnoreCase("nether_vein_multiplier")) {source.sendFeedback(new TranslationTextComponent("Nether Vein Multiplier: §" + OADConfig.nether_vein_multiplier.get().toString()), false); }
			if(option.equalsIgnoreCase("end_vein_multiplier")) {source.sendFeedback(new TranslationTextComponent("End Vein Multiplier: §" + OADConfig.end_vein_multiplier.get().toString()), false); }
			
			if(option.equalsIgnoreCase("enable_server_config_sync")) {source.sendFeedback(new TranslationTextComponent("(Client Side) Enable Server Config Sync: §" + OADConfig.enable_server_config_sync.get().toString()), false); }
			if(option.equalsIgnoreCase("send_config_sync_packet")) {source.sendFeedback(new TranslationTextComponent("(Server Side) Send Config Sync Packet: §" + OADConfig.send_config_sync_packet.get().toString()), false); }
			if(option.equalsIgnoreCase("overworld_ores")) {source.sendFeedback(new TranslationTextComponent("Overworld Ores: §" + OADConfig.overworld_ores.get().toString()), false); }
			if(option.equalsIgnoreCase("nether_ores")) {source.sendFeedback(new TranslationTextComponent("Nether Ores: §" + OADConfig.nether_ores.get().toString()), false); }
			if(option.equalsIgnoreCase("end_ores")) {source.sendFeedback(new TranslationTextComponent("End Ores: §" + OADConfig.end_ores.get().toString()), false); }
			if(option.equalsIgnoreCase("old_combat_mechanics")) {source.sendFeedback(new TranslationTextComponent("Old Combat Mechanics §" + OADConfig.old_combat_mechanics.get().toString()), false); }
		} else {
			source.sendErrorMessage(new TranslationTextComponent("ERROR: Unknown Command. Use /OAD help."));
		}
		return 1;
	}
	
	public static boolean isParsableInt(String input) {
	    try {
	        Integer.parseInt(input);
	        return true;
	    } catch (final NumberFormatException e) {
	        return false;
	    }
	}
	
	public static boolean isParsableDouble(String input) {
	    try {
	        Double.parseDouble(input);
	        return true;
	    } catch (final NumberFormatException e) {
	        return false;
	    }
	}
	
	public static boolean isParsableBoolean(String input) {
		return Boolean.parseBoolean(input);
	}
	
	public static int run(CommandSource source, String command, String option, String action, String value) {
		/*
		final double initial_amethyst_chance = OADConfig.amethyst_chance.get();
		final double initial_black_opal_chance = OADConfig.black_opal_chance.get();
		final int initial_amethyst_max_vein_size = OADConfig.amethyst_max_vein_size.get();
		final int initial_black_opal_max_vein_size = OADConfig.black_opal_max_vein_size.get();
		final int initial_amethyst_armor_toughness = OADConfig.amethyst_armor_toughness.get();
		final int initial_black_opal_armor_toughness = OADConfig.black_opal_armor_toughness.get();
		final int initial_amethyst_armor_durability = OADConfig.amethyst_armor_durability.get();
		final int initial_black_opal_armor_durability = OADConfig.black_opal_armor_durability.get();
		final int initial_amethyst_helmet_armor = OADConfig.amethyst_helmet_armor.get();
		final int initial_amethyst_chestplate_armor = OADConfig.amethyst_chestplate_armor.get();
		final int initial_amethyst_leggings_armor = OADConfig.amethyst_leggings_armor.get();
		final int initial_amethyst_boots_armor = OADConfig.amethyst_boots_armor.get();
		final int initial_black_opal_helmet_armor = OADConfig.black_opal_helmet_armor.get();
		final int initial_black_opal_chestplate_armor = OADConfig.black_opal_chestplate_armor.get();
		final int initial_black_opal_leggings_armor = OADConfig.black_opal_leggings_armor.get();
		final int initial_black_opal_boots_armor = OADConfig.black_opal_boots_armor.get();
		final int initial_amethyst_attack_damage = OADConfig.amethyst_attack_damage.get();
		final int initial_amethyst_efficiency = OADConfig.amethyst_efficiency.get();
		final int initial_amethyst_durability = OADConfig.amethyst_efficiency.get();
		final int initial_amethyst_enchantability = OADConfig.amethyst_enchantability.get();
		final int initial_black_opal_attack_damage = OADConfig.black_opal_attack_damage.get();
		final int initial_black_opal_efficiency = OADConfig.black_opal_efficiency.get();
		final int initial_black_opal_durability = OADConfig.black_opal_durability.get();
		final int initial_black_opal_enchantability = OADConfig.black_opal_enchantability.get();
		*/
		/*
		final double initial_nether_chance_multiplier = OADConfig.nether_chance_multiplier.get();
		final double initial_end_chance_multiplier = OADConfig.end_chance_multiplier.get();
		final double initial_nether_vein_multiplier = OADConfig.nether_vein_multiplier.get();
		final double initial_end_vein_multiplier = OADConfig.end_vein_multiplier.get();
		*/
		 		
		if(action.equalsIgnoreCase("write")) {
			
			if(option.equalsIgnoreCase("amethyst_chance")) {
				if(isParsableDouble(value)) {
					OADConfig.amethyst_chance.set(Double.parseDouble(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Amethyst Chance to §d" + OADConfig.amethyst_chance.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a double."));
				}
			}
			if(option.equalsIgnoreCase("black_opal_chance")) {
				if(isParsableDouble(value)) {
					OADConfig.black_opal_chance.set(Double.parseDouble(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Black Opal Chance to §5" + OADConfig.black_opal_chance.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a double."));
				}
			}
			
			if(option.equalsIgnoreCase("amethyst_max_vein_size")) {
				if(isParsableInt(value)) {
					OADConfig.amethyst_max_vein_size.set(Integer.parseInt(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Amethyst Max Vein Size to §d" + OADConfig.amethyst_max_vein_size.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a int."));
				}
			}
			if(option.equalsIgnoreCase("black_opal_max_vein_size")) {
				if(isParsableInt(value)) {
					OADConfig.black_opal_max_vein_size.set(Integer.parseInt(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Black Opal Max Vein Size to §5" + OADConfig.black_opal_max_vein_size.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a int."));
				}
			}
			
			if(option.equalsIgnoreCase("amethyst_armor_toughness")) {
				if(isParsableInt(value)) {
					OADConfig.amethyst_armor_toughness.set(Integer.parseInt(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Amethyst Armor Toughness to §d" + OADConfig.amethyst_armor_toughness.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a int."));
				}
			}
			if(option.equalsIgnoreCase("black_opal_armor_toughness")) {
				if(isParsableInt(value)) {
					OADConfig.black_opal_armor_toughness.set(Integer.parseInt(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Black Opal Armor Toughness to §5" + OADConfig.black_opal_armor_toughness.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a int."));
				}
			}
			
			if(option.equalsIgnoreCase("amethyst_armor_durability")) {
				if(isParsableInt(value)) {
					OADConfig.amethyst_armor_durability.set(Integer.parseInt(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Amethyst Armor Durability to §d" + OADConfig.amethyst_armor_durability.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a int."));
				}
			}
			if(option.equalsIgnoreCase("black_opal_armor_durability")) {
				if(isParsableInt(value)) {
					OADConfig.black_opal_armor_durability.set(Integer.parseInt(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Black Opal Armor DUrability to §5" + OADConfig.black_opal_armor_durability.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a int."));
				}
			}
			
			if(option.equalsIgnoreCase("amethyst_helmet_armor")) {
				if(isParsableInt(value)) {
					OADConfig.amethyst_helmet_armor.set(Integer.parseInt(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Amethyst Helmet Armor to §d" + OADConfig.amethyst_helmet_armor.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a int."));
				}
			}
			if(option.equalsIgnoreCase("amethyst_chestplate_armor")) {
				if(isParsableInt(value)) {
					OADConfig.amethyst_chestplate_armor.set(Integer.parseInt(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Amethyst Chestplate Armor to §d" + OADConfig.amethyst_chestplate_armor.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a int."));
				}
			}
			if(option.equalsIgnoreCase("amethyst_leggings_armor")) {
				if(isParsableInt(value)) {
					OADConfig.amethyst_leggings_armor.set(Integer.parseInt(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Amethyst Leggngs Armor to §d" + OADConfig.amethyst_leggings_armor.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a int."));
				}
			}
			if (option.equalsIgnoreCase("amethyst_boots_armor")) {
				if(isParsableInt(value)) {
					OADConfig.amethyst_boots_armor.set(Integer.parseInt(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Amethyst Boots Armor to §d" + OADConfig.amethyst_boots_armor.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a int."));
				}
			}

			if (option.equalsIgnoreCase("black_opal_helmet_armor")) {
				if(isParsableInt(value)) {
					OADConfig.black_opal_helmet_armor.set(Integer.parseInt(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Black Opal Helmet Armor to §5" + OADConfig.black_opal_helmet_armor.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a int."));
				}
			}
			if (option.equalsIgnoreCase("black_opal_chestplate_armor")) {
				if(isParsableInt(value)) {
					OADConfig.black_opal_chestplate_armor.set(Integer.parseInt(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Black Opal Chestplate Armor to §5" + OADConfig.black_opal_chestplate_armor.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a int."));
				}
			}
			if (option.equalsIgnoreCase("black_opal_leggings_armor")) {
				if(isParsableInt(value)) {
					OADConfig.black_opal_leggings_armor.set(Integer.parseInt(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Black Opal Leggings Armor to §5" + OADConfig.black_opal_leggings_armor.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a int."));
				}
			}
			if (option.equalsIgnoreCase("black_opal_boots_armor")) {
				if(isParsableInt(value)) {
					OADConfig.black_opal_boots_armor.set(Integer.parseInt(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Black Opal Boots Armor to §5" + OADConfig.black_opal_boots_armor.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a int."));
				}
			}

			if (option.equalsIgnoreCase("amethyst_attack_damage")) {
				if(isParsableInt(value)) {
					OADConfig.amethyst_attack_damage.set(Integer.parseInt(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Amethyst Attack Damage to §d" + OADConfig.amethyst_attack_damage.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a int."));
				}
			}
			
			if (option.equalsIgnoreCase("amethyst_efficiency")) {
				if(isParsableInt(value)) {
					OADConfig.amethyst_efficiency.set(Integer.parseInt(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Amethyst Efficiency to §d" + OADConfig.amethyst_efficiency.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a int."));
				}
			}

			if (option.equalsIgnoreCase("amethyst_durability")) {
				if(isParsableInt(value)) {
					OADConfig.amethyst_durability.set(Integer.parseInt(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Amethyst Durability to §d" + OADConfig.amethyst_durability.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a int."));
				}
			}
			
			
			if (option.equalsIgnoreCase("black_opal_attack_damage")) {
				if(isParsableInt(value)) {
					OADConfig.black_opal_attack_damage.set(Integer.parseInt(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Black Opal Attack Damage to §5" + OADConfig.black_opal_attack_damage.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a int."));
				}
			}
			if (option.equalsIgnoreCase("black_opal_efficiency")) {
				if(isParsableInt(value)) {
					OADConfig.black_opal_efficiency.set(Integer.parseInt(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Black Opal Efficiency to §5" + OADConfig.black_opal_efficiency.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a int."));
				}
			}
			if (option.equalsIgnoreCase("black_opal_durability")) {
				if(isParsableInt(value)) {
					OADConfig.black_opal_durability.set(Integer.parseInt(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Black Opal Durability to §5" + OADConfig.black_opal_durability.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a int."));
				}
			}
			if (option.equalsIgnoreCase("amethyst_enchantability")) {
				if(isParsableInt(value)) {
					OADConfig.amethyst_enchantability.set(Integer.parseInt(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Amethyst Enchantability to §d" + OADConfig.amethyst_enchantability.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a int."));
				}
			}
			if (option.equalsIgnoreCase("black_opal_enchantability")) {
				if(isParsableInt(value)) {
					OADConfig.black_opal_enchantability.set(Integer.parseInt(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Black Opal Enchantability to §5" + OADConfig.black_opal_enchantability.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a int."));
				}
			}

			if (option.equalsIgnoreCase("nether_chance_multiplier")) {
				if(isParsableDouble(value)) {
					OADConfig.nether_chance_multiplier.set(Double.parseDouble(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Nether Chance Multiplier to " + OADConfig.nether_chance_multiplier.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a double."));
				}
			}
			if (option.equalsIgnoreCase("end_chance_multiplier")) {
				if(isParsableDouble(value)) {
					OADConfig.end_chance_multiplier.set(Double.parseDouble(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed End Chance Multiplier to " + OADConfig.end_chance_multiplier.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a double."));
				}
			}
			if (option.equalsIgnoreCase("nether_vein_multiplier")) {
				if(isParsableDouble(value)) {
					OADConfig.nether_vein_multiplier.set(Double.parseDouble(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Nether Vein Multiplier to " + OADConfig.nether_vein_multiplier.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a double."));
				}
			}
			if (option.equalsIgnoreCase("end_vein_multiplier")) {
				if(isParsableDouble(value)) {
					OADConfig.end_vein_multiplier.set(Double.parseDouble(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed End Vein Multiplier to " + OADConfig.end_vein_multiplier.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a double."));
				}
			}

			if (option.equalsIgnoreCase("enable_server_config_sync")) {
				if(Boolean.parseBoolean(value)) {
					OADConfig.enable_server_config_sync.set(Boolean.parseBoolean(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Enable Server Config Sync to " + OADConfig.enable_server_config_sync.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a boolean."));
				}
			}
			if (option.equalsIgnoreCase("send_config_sync_packet")) {
				if(Boolean.parseBoolean(value)) {
					OADConfig.send_config_sync_packet.set(Boolean.parseBoolean(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Send Config Sync Packet to " + OADConfig.send_config_sync_packet.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a boolean."));
				}
			}
			if (option.equalsIgnoreCase("overworld_ores")) {
				if(Boolean.parseBoolean(value)) {
					OADConfig.overworld_ores.set(Boolean.parseBoolean(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Overworld Ores to " + OADConfig.overworld_ores.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a boolean."));
				}
			}
			if (option.equalsIgnoreCase("nether_ores")) {
				if(Boolean.parseBoolean(value)) {
					OADConfig.nether_ores.set(Boolean.parseBoolean(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Nether Ores to " + OADConfig.nether_ores.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a boolean."));
				}
			}
			if (option.equalsIgnoreCase("end_ores")) {
				if(Boolean.parseBoolean(value)) {
					OADConfig.end_ores.set(Boolean.parseBoolean(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed End Ores to " + OADConfig.end_ores.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a boolean."));
				}
			}
			if (option.equalsIgnoreCase("old_combat_mechanics")) {
				if(Boolean.parseBoolean(value)) {
					OADConfig.old_combat_mechanics.set(Boolean.parseBoolean(value));
					source.sendFeedback(new TranslationTextComponent("Successfully changed Old Combat Mechanics to " + OADConfig.old_combat_mechanics.get().toString()), false);
				} else {
					source.sendErrorMessage(new TranslationTextComponent("Invalid input. New value must be a boolean."));
				}
			}
		}

		return 1;
	}
}
