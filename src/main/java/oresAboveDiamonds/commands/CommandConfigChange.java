package oresAboveDiamonds.commands;

/*
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
	
	|*
	private static LiteralArgumentBuilder<CommandSourceStack, ?> buildCommand(String name) {
		
		LiteralArgumentBuilder.<CommandSourceStack> literal(name).requires(context -> {
			return context.hasPermission(3);
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
        })))));
		
		return base;
	}
	*|
	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		
        dispatcher.register(
                LiteralArgumentBuilder.<CommandSourceStack> literal("oad")
                .executes(source -> run(source.getSource()))
                );
    }

	public static int run(CommandSourceStack source){
		source.sendSuccess(new TextComponent("§5- §dOres Above Diamonds §5-"), false);
		source.sendSuccess(new TextComponent("/OAD help §7- Displays the list of commands and arguments."), false);
		source.sendSuccess(new TextComponent("/OAD config <config_option> <read / write> <value> §7- Accesses the server's config file. The majority of changes require a server restart."), false);
		source.sendSuccess(new TextComponent("/OAD sync §7- Syncs all clients' configs with the servers. Clients will need to restart minecraft to finalize effects."), false);
		return 1;
	}
	
	public static int run(CommandSourceStack source, String command){
		if(command.equalsIgnoreCase("help")) {
			source.sendSuccess(new TextComponent(""), false);
			source.sendSuccess(new TextComponent("§5- §dOres Above Diamonds §5-"), false);
			source.sendSuccess(new TextComponent("/OAD help §7- Displays the list of commands and arguments."), false);
			source.sendSuccess(new TextComponent("/OAD config <config_option> <read / write> <value_to_write> §7- Accesses the server's config file. The majority of changes require a server restart."), false);
			source.sendSuccess(new TextComponent("/OAD sync §7- Syncs all clients' configs with the servers. Clients will need to restart minecraft to finalize effects."), false);
		} else if(command.equalsIgnoreCase("config")) {
			source.sendSuccess(new TextComponent(""), false);
			source.sendSuccess(new TextComponent("§d/OAD config"), false);
			source.sendSuccess(new TextComponent("These commands can change the config file from within the game. For a singleplayer world, you can also change the config from the config folder at %appdata% -> .minecraft ."), false);
			source.sendSuccess(new TextComponent(""), false);
			source.sendSuccess(new TextComponent("Use the syntax /OAD config <config_option> <read / write> <new_value_to_write>"), false);
		} else if(command.equalsIgnoreCase("sync")){
			
			int amethyst_enchant = OADConfig.amethyst_enchantability.get();
			int black_opal_enchant = OADConfig.black_opal_enchantability.get();
			int netherite_opal_enchant = OADConfig.netherite_opal_enchantability.get();
			
			int amethyst_ad = OADConfig.amethyst_attack_damage.get();
			int amethyst_efficiency = OADConfig.amethyst_efficiency.get();
			int amethyst_tool_durability = OADConfig.amethyst_durability.get();
			
			int black_opal_ad = OADConfig.black_opal_attack_damage.get();
			int black_opal_efficiency = OADConfig.black_opal_efficiency.get();
			int black_opal_tool_durability = OADConfig.black_opal_durability.get();
			
			int netherite_opal_ad = OADConfig.netherite_opal_attack_damage.get();
			int netherite_opal_efficiency = OADConfig.netherite_opal_efficiency.get();
			int netherite_opal_tool_durability = OADConfig.netherite_opal_durability.get();
			
			int amethyst_toughness = OADConfig.amethyst_armor_toughness.get();
			int black_opal_toughness = OADConfig.black_opal_armor_toughness.get();
			int netherite_opal_toughness = OADConfig.netherite_opal_armor_toughness.get();
			
			int amethyst_knockback_resistance = OADConfig.amethyst_armor_knockback_resistance.get();
			int black_opal_knockback_resistance = OADConfig.black_opal_armor_knockback_resistance.get();
			int netherite_opal_knockback_resistance = OADConfig.netherite_opal_armor_knockback_resistance.get();
			
			int amethyst_armor_durability = OADConfig.amethyst_armor_durability.get();
			int black_opal_armor_durability = OADConfig.black_opal_armor_durability.get();
			int netherite_opal_armor_durability = OADConfig.netherite_opal_armor_durability.get();
			
		    int amethyst_helmet_armor = OADConfig.amethyst_helmet_armor.get();
			int amethyst_chestplate_armor = OADConfig.amethyst_chestplate_armor.get();
			int amethyst_leggings_armor = OADConfig.amethyst_leggings_armor.get();
			int amethyst_boots_armor = OADConfig.amethyst_boots_armor.get();
			
			int black_opal_helmet_armor = OADConfig.black_opal_helmet_armor.get();
			int black_opal_chestplate_armor = OADConfig.black_opal_chestplate_armor.get();
			int black_opal_leggings_armor = OADConfig.black_opal_leggings_armor.get();
			int black_opal_boots_armor = OADConfig.black_opal_boots_armor.get();
			
			int netherite_opal_helmet_armor = OADConfig.netherite_opal_helmet_armor.get();
			int netherite_opal_chestplate_armor = OADConfig.netherite_opal_chestplate_armor.get();
			int netherite_opal_leggings_armor = OADConfig.netherite_opal_leggings_armor.get();
			int netherite_opal_boots_armor = OADConfig.netherite_opal_boots_armor.get();
			
			boolean old_combat_mechanics = OADConfig.old_combat_mechanics.get();
			
			boolean spawn_amethyst_overworld = OADConfig.spawn_amethyst_overworld.get();
			boolean spawn_black_opal_overworld = OADConfig.spawn_black_opal_overworld.get();
			boolean spawn_amethyst_nether = OADConfig.spawn_amethyst_nether.get();
			boolean spawn_black_opal_nether = OADConfig.spawn_black_opal_nether.get();
			boolean spawn_amethyst_end = OADConfig.spawn_amethyst_end.get();
			boolean spawn_black_opal_end = OADConfig.spawn_black_opal_end.get();
			
			int amethyst_times_rarer = OADConfig.amethyst_times_rarer.get();
			int black_opal_times_rarer = OADConfig.black_opal_times_rarer.get();
			
			int amethyst_max_vein_size = OADConfig.amethyst_max_vein_size.get();
			int black_opal_max_vein_size = OADConfig.black_opal_max_vein_size.get();
			
			int amethyst_max_spawn_height_overworld = OADConfig.amethyst_max_spawn_height_overworld.get();
			int black_opal_max_spawn_height_overworld = OADConfig.black_opal_max_spawn_height_overworld.get();
			
			int amethyst_max_spawn_height_nether = OADConfig.amethyst_max_spawn_height_nether.get();
			int black_opal_max_spawn_height_nether = OADConfig.black_opal_max_spawn_height_nether.get();
			
			int amethyst_max_spawn_height_end = OADConfig.amethyst_max_spawn_height_end.get();
			int black_opal_max_spawn_height_end = OADConfig.black_opal_max_spawn_height_end.get();
			
			PacketSyncConfig message = new PacketSyncConfig(amethyst_enchant, black_opal_enchant, netherite_opal_enchant, amethyst_ad, amethyst_efficiency, amethyst_tool_durability,
					 black_opal_ad, black_opal_efficiency, black_opal_tool_durability, netherite_opal_ad, netherite_opal_efficiency, netherite_opal_tool_durability, amethyst_toughness, black_opal_toughness, netherite_opal_toughness,
					 amethyst_knockback_resistance, black_opal_knockback_resistance, netherite_opal_knockback_resistance, amethyst_armor_durability, black_opal_armor_durability, netherite_opal_armor_durability, amethyst_helmet_armor, amethyst_chestplate_armor,
					 amethyst_leggings_armor, amethyst_boots_armor, black_opal_helmet_armor, black_opal_chestplate_armor,
					 black_opal_leggings_armor, black_opal_boots_armor, netherite_opal_helmet_armor, netherite_opal_chestplate_armor, netherite_opal_leggings_armor, netherite_opal_boots_armor, old_combat_mechanics,
					 spawn_amethyst_overworld, spawn_black_opal_overworld, spawn_amethyst_nether, spawn_black_opal_nether, spawn_amethyst_end, spawn_black_opal_end, amethyst_times_rarer, black_opal_times_rarer, amethyst_max_vein_size, black_opal_max_vein_size, amethyst_max_spawn_height_overworld,
					 black_opal_max_spawn_height_overworld, amethyst_max_spawn_height_nether, black_opal_max_spawn_height_nether, amethyst_max_spawn_height_end, black_opal_max_spawn_height_end);
			
					OADPacketHandler.INSTANCE.send(PacketDistributor.ALL.noArg(), message);
			
			source.sendSuccess(new TextComponent("Client configurations synced. If they had any configuration changes, they will be notified and will be asked to restart their minecraft to finalize changes. This is an optimal time to restart the server so the changes can take effect."), false);
		} else {
			source.sendFailure(new TextComponent("ERROR: Unknown command. Use /OAD help."));
		}
		
		return 1;
	}
	
	public static int run(CommandSourceStack source, String command, String option){
		readConfigInput(source, option);
		return 1;
	}
	
	public static int run(CommandSourceStack source, String command, String option, String action){
		if(action.equalsIgnoreCase("write")) {
			source.sendFailure(new TextComponent("ERROR: Please enter a value to write. Use /OAD help."));
		} else if(action.equalsIgnoreCase("read")) {
			readConfigInput(source, option);
		} else {
			source.sendFailure(new TextComponent("ERROR: Unknown Command. Use /OAD help."));
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
		if(input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static int run(CommandSourceStack source, String command, String option, String action, String value) {
		/*
		double initial_amethyst_chance = OADConfig.amethyst_chance.get();
		double initial_black_opal_chance = OADConfig.black_opal_chance.get();
		int initial_amethyst_max_vein_size = OADConfig.amethyst_max_vein_size.get();
		int initial_black_opal_max_vein_size = OADConfig.black_opal_max_vein_size.get();
		int initial_amethyst_armor_toughness = OADConfig.amethyst_armor_toughness.get();
		int initial_black_opal_armor_toughness = OADConfig.black_opal_armor_toughness.get();
		int initial_amethyst_armor_durability = OADConfig.amethyst_armor_durability.get();
		int initial_black_opal_armor_durability = OADConfig.black_opal_armor_durability.get();
		int initial_amethyst_helmet_armor = OADConfig.amethyst_helmet_armor.get();
		int initial_amethyst_chestplate_armor = OADConfig.amethyst_chestplate_armor.get();
		int initial_amethyst_leggings_armor = OADConfig.amethyst_leggings_armor.get();
		int initial_amethyst_boots_armor = OADConfig.amethyst_boots_armor.get();
		int initial_black_opal_helmet_armor = OADConfig.black_opal_helmet_armor.get();
		int initial_black_opal_chestplate_armor = OADConfig.black_opal_chestplate_armor.get();
		int initial_black_opal_leggings_armor = OADConfig.black_opal_leggings_armor.get();
		int initial_black_opal_boots_armor = OADConfig.black_opal_boots_armor.get();
		int initial_amethyst_attack_damage = OADConfig.amethyst_attack_damage.get();
		int initial_amethyst_efficiency = OADConfig.amethyst_efficiency.get();
		int initial_amethyst_durability = OADConfig.amethyst_efficiency.get();
		int initial_amethyst_enchantability = OADConfig.amethyst_enchantability.get();
		int initial_black_opal_attack_damage = OADConfig.black_opal_attack_damage.get();
		int initial_black_opal_efficiency = OADConfig.black_opal_efficiency.get();
		int initial_black_opal_durability = OADConfig.black_opal_durability.get();
		int initial_black_opal_enchantability = OADConfig.black_opal_enchantability.get();
		
		
		double initial_nether_chance_multiplier = OADConfig.nether_chance_multiplier.get();
		double initial_end_chance_multiplier = OADConfig.end_chance_multiplier.get();
		double initial_nether_vein_multiplier = OADConfig.nether_vein_multiplier.get();
		double initial_end_vein_multiplier = OADConfig.end_vein_multiplier.get();
		*|
		
		if(action.equalsIgnoreCase("write")) {
			
			if(option.equalsIgnoreCase("amethyst_times_rarer")) {
				if(isParsableInt(value)) {
					OADConfig.amethyst_times_rarer.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Amethyst Chance to §d" + OADConfig.amethyst_times_rarer.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be an int."));
				}
			}
			if(option.equalsIgnoreCase("black_opal_times_rarer")) {
				if(isParsableInt(value)) {
					OADConfig.black_opal_times_rarer.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Black Opal Chance to §5" + OADConfig.black_opal_times_rarer.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be an int."));
				}
			}
			
			if(option.equalsIgnoreCase("amethyst_max_vein_size")) {
				if(isParsableInt(value)) {
					OADConfig.amethyst_max_vein_size.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Amethyst Max Vein Size to §d" + OADConfig.amethyst_max_vein_size.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			if(option.equalsIgnoreCase("black_opal_max_vein_size")) {
				if(isParsableInt(value)) {
					OADConfig.black_opal_max_vein_size.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Black Opal Max Vein Size to §5" + OADConfig.black_opal_max_vein_size.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			
			if(option.equalsIgnoreCase("amethyst_max_spawn_height_overworld")) {
				if(isParsableInt(value)) {
					OADConfig.amethyst_max_spawn_height_overworld.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Amethyst Max Spawn Height Overworld to §d" + OADConfig.amethyst_max_spawn_height_overworld.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			
			if(option.equalsIgnoreCase("amethyst_max_spawn_height_nether")) {
				if(isParsableInt(value)) {
					OADConfig.amethyst_max_spawn_height_nether.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Amethyst Max Spawn Height Nether to §d" + OADConfig.amethyst_max_spawn_height_nether.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			
			if(option.equalsIgnoreCase("amethyst_max_spawn_height_end")) {
				if(isParsableInt(value)) {
					OADConfig.amethyst_max_spawn_height_end.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Amethyst Max Spawn Height End to §d" + OADConfig.amethyst_max_spawn_height_end.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			
			if(option.equalsIgnoreCase("black_opal_max_spawn_height_overworld")) {
				if(isParsableInt(value)) {
					OADConfig.black_opal_max_spawn_height_overworld.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Black Opal Max Spawn Height Overworld to §d" + OADConfig.black_opal_max_spawn_height_overworld.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			
			if(option.equalsIgnoreCase("black_opal_max_spawn_height_nether")) {
				if(isParsableInt(value)) {
					OADConfig.black_opal_max_spawn_height_nether.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Black Opal Max Spawn Height Nether to §5" + OADConfig.black_opal_max_spawn_height_nether.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			
			if(option.equalsIgnoreCase("black_opal_max_spawn_height_end")) {
				if(isParsableInt(value)) {
					OADConfig.black_opal_max_spawn_height_end.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Black Opal Max Spawn Height End to §5" + OADConfig.black_opal_max_spawn_height_end.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			
			if(option.equalsIgnoreCase("amethyst_armor_toughness")) {
				if(isParsableInt(value)) {
					OADConfig.amethyst_armor_toughness.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Amethyst Armor Toughness to §d" + OADConfig.amethyst_armor_toughness.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			if(option.equalsIgnoreCase("black_opal_armor_toughness")) {
				if(isParsableInt(value)) {
					OADConfig.black_opal_armor_toughness.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Black Opal Armor Toughness to §5" + OADConfig.black_opal_armor_toughness.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			
			if(option.equalsIgnoreCase("netherite_opal_armor_toughness")) {
				if(isParsableInt(value)) {
					OADConfig.netherite_opal_armor_toughness.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Netherite Opal Armor Toughness to §5" + OADConfig.netherite_opal_armor_toughness.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			
			if(option.equalsIgnoreCase("amethyst_armor_knockback_resistance")) {
				if(isParsableInt(value)) {
					OADConfig.amethyst_armor_knockback_resistance.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Amethyst Armor Knockback Resistance to §d" + OADConfig.amethyst_armor_knockback_resistance.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			if(option.equalsIgnoreCase("black_opal_armor_knockback_resistance")) {
				if(isParsableInt(value)) {
					OADConfig.black_opal_armor_knockback_resistance.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Black Opal Armor Knockback Resistance to §5" + OADConfig.black_opal_armor_knockback_resistance.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			
			if(option.equalsIgnoreCase("netherite_opal_armor_knockback_resistance")) {
				if(isParsableInt(value)) {
					OADConfig.netherite_opal_armor_knockback_resistance.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Netherite Opal Armor Knockback Resistance to §5" + OADConfig.netherite_opal_armor_knockback_resistance.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			
			if(option.equalsIgnoreCase("amethyst_armor_durability")) {
				if(isParsableInt(value)) {
					OADConfig.amethyst_armor_durability.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Amethyst Armor Durability to §d" + OADConfig.amethyst_armor_durability.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			if(option.equalsIgnoreCase("black_opal_armor_durability")) {
				if(isParsableInt(value)) {
					OADConfig.black_opal_armor_durability.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Black Opal Armor DUrability to §5" + OADConfig.black_opal_armor_durability.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			
			if(option.equalsIgnoreCase("netherite_opal_armor_durability")) {
				if(isParsableInt(value)) {
					OADConfig.netherite_opal_armor_durability.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Netherite Opal Armor DUrability to §5" + OADConfig.netherite_opal_armor_durability.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			
			if(option.equalsIgnoreCase("amethyst_helmet_armor")) {
				if(isParsableInt(value)) {
					OADConfig.amethyst_helmet_armor.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Amethyst Helmet Armor to §d" + OADConfig.amethyst_helmet_armor.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			if(option.equalsIgnoreCase("amethyst_chestplate_armor")) {
				if(isParsableInt(value)) {
					OADConfig.amethyst_chestplate_armor.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Amethyst Chestplate Armor to §d" + OADConfig.amethyst_chestplate_armor.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			if(option.equalsIgnoreCase("amethyst_leggings_armor")) {
				if(isParsableInt(value)) {
					OADConfig.amethyst_leggings_armor.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Amethyst Leggngs Armor to §d" + OADConfig.amethyst_leggings_armor.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			if (option.equalsIgnoreCase("amethyst_boots_armor")) {
				if(isParsableInt(value)) {
					OADConfig.amethyst_boots_armor.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Amethyst Boots Armor to §d" + OADConfig.amethyst_boots_armor.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}

			if (option.equalsIgnoreCase("black_opal_helmet_armor")) {
				if(isParsableInt(value)) {
					OADConfig.black_opal_helmet_armor.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Black Opal Helmet Armor to §5" + OADConfig.black_opal_helmet_armor.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			if (option.equalsIgnoreCase("black_opal_chestplate_armor")) {
				if(isParsableInt(value)) {
					OADConfig.black_opal_chestplate_armor.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Black Opal Chestplate Armor to §5" + OADConfig.black_opal_chestplate_armor.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			if (option.equalsIgnoreCase("black_opal_leggings_armor")) {
				if(isParsableInt(value)) {
					OADConfig.black_opal_leggings_armor.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Black Opal Leggings Armor to §5" + OADConfig.black_opal_leggings_armor.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			
			if (option.equalsIgnoreCase("black_opal_boots_armor")) {
				if(isParsableInt(value)) {
					OADConfig.black_opal_boots_armor.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Black Opal Boots Armor to §5" + OADConfig.black_opal_boots_armor.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			
			if (option.equalsIgnoreCase("netherite_opal_helmet_armor")) {
				if(isParsableInt(value)) {
					OADConfig.netherite_opal_helmet_armor.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Netherite Opal Helmet Armor to §5" + OADConfig.netherite_opal_helmet_armor.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			
			if (option.equalsIgnoreCase("netherite_opal_chestplate_armor")) {
				if(isParsableInt(value)) {
					OADConfig.netherite_opal_chestplate_armor.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Netherite Opal Chestplate Armor to §5" + OADConfig.netherite_opal_chestplate_armor.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			if (option.equalsIgnoreCase("netherite_opal_leggings_armor")) {
				if(isParsableInt(value)) {
					OADConfig.netherite_opal_leggings_armor.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Netherite Opal Leggings Armor to §5" + OADConfig.netherite_opal_leggings_armor.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			if (option.equalsIgnoreCase("netherite_opal_boots_armor")) {
				if(isParsableInt(value)) {
					OADConfig.netherite_opal_boots_armor.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Netherite Opal Boots Armor to §5" + OADConfig.netherite_opal_boots_armor.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}

			if (option.equalsIgnoreCase("amethyst_attack_damage")) {
				if(isParsableInt(value)) {
					OADConfig.amethyst_attack_damage.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Amethyst Attack Damage to §d" + OADConfig.amethyst_attack_damage.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			
			if (option.equalsIgnoreCase("amethyst_efficiency")) {
				if(isParsableInt(value)) {
					OADConfig.amethyst_efficiency.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Amethyst Efficiency to §d" + OADConfig.amethyst_efficiency.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}

			if (option.equalsIgnoreCase("amethyst_durability")) {
				if(isParsableInt(value)) {
					OADConfig.amethyst_durability.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Amethyst Durability to §d" + OADConfig.amethyst_durability.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			
			
			if (option.equalsIgnoreCase("black_opal_attack_damage")) {
				if(isParsableInt(value)) {
					OADConfig.black_opal_attack_damage.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Black Opal Attack Damage to §5" + OADConfig.black_opal_attack_damage.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			if (option.equalsIgnoreCase("black_opal_efficiency")) {
				if(isParsableInt(value)) {
					OADConfig.black_opal_efficiency.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Black Opal Efficiency to §5" + OADConfig.black_opal_efficiency.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			if (option.equalsIgnoreCase("black_opal_durability")) {
				if(isParsableInt(value)) {
					OADConfig.black_opal_durability.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Black Opal Durability to §5" + OADConfig.black_opal_durability.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			
			if (option.equalsIgnoreCase("netherite_opal_attack_damage")) {
				if(isParsableInt(value)) {
					OADConfig.netherite_opal_attack_damage.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Netherite Opal Attack Damage to §5" + OADConfig.netherite_opal_attack_damage.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			if (option.equalsIgnoreCase("netherite_opal_efficiency")) {
				if(isParsableInt(value)) {
					OADConfig.netherite_opal_efficiency.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Netherite Opal Efficiency to §5" + OADConfig.netherite_opal_efficiency.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			if (option.equalsIgnoreCase("netherite_opal_durability")) {
				if(isParsableInt(value)) {
					OADConfig.netherite_opal_durability.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Netherite Opal Durability to §5" + OADConfig.netherite_opal_durability.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			
			if (option.equalsIgnoreCase("amethyst_enchantability")) {
				if(isParsableInt(value)) {
					OADConfig.amethyst_enchantability.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Amethyst Enchantability to §d" + OADConfig.amethyst_enchantability.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			if (option.equalsIgnoreCase("black_opal_enchantability")) {
				if(isParsableInt(value)) {
					OADConfig.black_opal_enchantability.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Black Opal Enchantability to §5" + OADConfig.black_opal_enchantability.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}
			
			if (option.equalsIgnoreCase("netherite_opal_enchantability")) {
				if(isParsableInt(value)) {
					OADConfig.netherite_opal_enchantability.set(Integer.parseInt(value));
					source.sendSuccess(new TextComponent("Successfully changed Netherite Opal Enchantability to §5" + OADConfig.netherite_opal_enchantability.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a int."));
				}
			}

			if (option.equalsIgnoreCase("nether_chance_multiplier")) {
				if(isParsableDouble(value)) {
					OADConfig.nether_chance_multiplier.set(Double.parseDouble(value));
					source.sendSuccess(new TextComponent("Successfully changed Nether Chance Multiplier to " + OADConfig.nether_chance_multiplier.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a double."));
				}
			}
			if (option.equalsIgnoreCase("end_chance_multiplier")) {
				if(isParsableDouble(value)) {
					OADConfig.end_chance_multiplier.set(Double.parseDouble(value));
					source.sendSuccess(new TextComponent("Successfully changed End Chance Multiplier to " + OADConfig.end_chance_multiplier.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a double."));
				}
			}
			if (option.equalsIgnoreCase("nether_vein_multiplier")) {
				if(isParsableDouble(value)) {
					OADConfig.nether_vein_multiplier.set(Double.parseDouble(value));
					source.sendSuccess(new TextComponent("Successfully changed Nether Vein Multiplier to " + OADConfig.nether_vein_multiplier.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a double."));
				}
			}
			if (option.equalsIgnoreCase("end_vein_multiplier")) {
				if(isParsableDouble(value)) {
					OADConfig.end_vein_multiplier.set(Double.parseDouble(value));
					source.sendSuccess(new TextComponent("Successfully changed End Vein Multiplier to " + OADConfig.end_vein_multiplier.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a double."));
				}
			}

			if (option.equalsIgnoreCase("enable_server_config_sync")) {
				if(isParsableBoolean(value)) {
					OADConfig.enable_server_config_sync.set(Boolean.parseBoolean(value));
					source.sendSuccess(new TextComponent("Successfully changed Enable Server Config Sync to " + OADConfig.enable_server_config_sync.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a boolean."));
				}
			}
			if (option.equalsIgnoreCase("send_config_sync_packet")) {
				if(isParsableBoolean(value)) {
					OADConfig.send_config_sync_packet.set(Boolean.parseBoolean(value));
					source.sendSuccess(new TextComponent("Successfully changed Send Config Sync Packet to " + OADConfig.send_config_sync_packet.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a boolean."));
				}
			}
			
			if (option.equalsIgnoreCase("spawn_amethyst_overworld")) {
				if(isParsableBoolean(value)) {
					OADConfig.spawn_amethyst_overworld.set(Boolean.parseBoolean(value));
					source.sendSuccess(new TextComponent("Successfully changed Spawn Amethyst Overworld to " + OADConfig.spawn_amethyst_overworld.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a boolean."));
				}
			}
			if (option.equalsIgnoreCase("spawn_black_opal_overworld")) {
				if(isParsableBoolean(value)) {
					OADConfig.spawn_black_opal_overworld.set(Boolean.parseBoolean(value));
					source.sendSuccess(new TextComponent("Successfully changed Spawn Black Opal Overworld to " + OADConfig.spawn_black_opal_overworld.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a boolean."));
				}
			}
			if (option.equalsIgnoreCase("spawn_amethyst_nether")) {
				if(isParsableBoolean(value)) {
					OADConfig.spawn_amethyst_nether.set(Boolean.parseBoolean(value));
					source.sendSuccess(new TextComponent("Successfully changed Spawn Amethyst Nether to " + OADConfig.spawn_amethyst_nether.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a boolean."));
				}
			}
			if (option.equalsIgnoreCase("spawn_black_opal_nether")) {
				if(isParsableBoolean(value)) {
					OADConfig.spawn_black_opal_nether.set(Boolean.parseBoolean(value));
					source.sendSuccess(new TextComponent("Successfully changed Spawn Black Opal Nether to " + OADConfig.spawn_black_opal_nether.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a boolean."));
				}
			}
			if (option.equalsIgnoreCase("spawn_amethyst_end")) {
				if(isParsableBoolean(value)) {
					OADConfig.spawn_amethyst_end.set(Boolean.parseBoolean(value));
					source.sendSuccess(new TextComponent("Successfully changed Spawn Amethyst End to " + OADConfig.spawn_amethyst_end.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a boolean."));
				}
			}
			
			if (option.equalsIgnoreCase("spawn_black_opal_end")) {
				if(isParsableBoolean(value)) {
					OADConfig.spawn_black_opal_end.set(Boolean.parseBoolean(value));
					source.sendSuccess(new TextComponent("Successfully changed Spawn Black Opal End to " + OADConfig.spawn_black_opal_end.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a boolean."));
				}
			}
			if (option.equalsIgnoreCase("old_combat_mechanics")) {
				if(isParsableBoolean(value)) {
					OADConfig.old_combat_mechanics.set(Boolean.parseBoolean(value));
					source.sendSuccess(new TextComponent("Successfully changed Old Combat Mechanics to " + OADConfig.old_combat_mechanics.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a boolean."));
				}
			}
			if (option.equalsIgnoreCase("chest_loot")) {
				if(isParsableBoolean(value)) {
					OADConfig.chest_loot.set(Boolean.parseBoolean(value));
					source.sendSuccess(new TextComponent("Successfully changed Chest Loot to " + OADConfig.chest_loot.get().toString()), false);
				} else {
					source.sendFailure(new TextComponent("Invalid input. New value must be a boolean."));
				}
			}
		}
		return 1;
	}
	
	private static void readConfigInput(CommandSourceStack source, String option) {
		if(option.equalsIgnoreCase("amethyst_times_rarer")) {source.sendSuccess(new TextComponent("Amethyst Chance: §d" + OADConfig.amethyst_times_rarer.get().toString()), false); }
		if(option.equalsIgnoreCase("black_opal_times_rarer")) {source.sendSuccess(new TextComponent("Black Opal Chance: §5" + OADConfig.black_opal_times_rarer.get().toString()), false); }
		
		if(option.equalsIgnoreCase("amethyst_max_vein_size")) {source.sendSuccess(new TextComponent("Amethyst Max Vein Size: §d" + OADConfig.amethyst_max_vein_size.get().toString()), false); }
		if(option.equalsIgnoreCase("black_opal_max_vein_size")) {source.sendSuccess(new TextComponent("Black Opal Max Vein Size: §5" + OADConfig.black_opal_max_vein_size.get().toString()), false); }
		
		if(option.equalsIgnoreCase("amethyst_armor_toughness")) {source.sendSuccess(new TextComponent("Amethyst Armor Toughness: §d" + OADConfig.amethyst_armor_toughness.get().toString()), false); }
		if(option.equalsIgnoreCase("black_opal_armor_toughness")) {source.sendSuccess(new TextComponent("Black Opal Armor Toughness §5" + OADConfig.black_opal_armor_toughness.get().toString()), false); }
		if(option.equalsIgnoreCase("netherite_opal_armor_toughness")) {source.sendSuccess(new TextComponent("Netherite Opal Armor Toughness §5" + OADConfig.netherite_opal_armor_toughness.get().toString()), false); }
		
		if(option.equalsIgnoreCase("amethyst_armor_knockback_resistance")) {source.sendSuccess(new TextComponent("Amethyst Armor Knockback Resistance: §d" + OADConfig.amethyst_armor_knockback_resistance.get().toString()), false); }
		if(option.equalsIgnoreCase("black_opal_armor_knockback_resistance")) {source.sendSuccess(new TextComponent("Black Opal Armor Knockback Resistance §5" + OADConfig.black_opal_armor_knockback_resistance.get().toString()), false); }
		if(option.equalsIgnoreCase("netherite_opal_armor_knockback_resistance")) {source.sendSuccess(new TextComponent("Netherite Opal Armor Knockback Resistance §5" + OADConfig.netherite_opal_armor_knockback_resistance.get().toString()), false); }
		
		if(option.equalsIgnoreCase("amethyst_armor_durability")) {source.sendSuccess(new TextComponent("Amethyst Armor Durability: §d" + OADConfig.amethyst_armor_durability.get().toString()), false); }
		if(option.equalsIgnoreCase("black_opal_armor_durability")) {source.sendSuccess(new TextComponent("Black Opal Armor Durabiliity §5" + OADConfig.black_opal_armor_durability.get().toString()), false); }
		if(option.equalsIgnoreCase("netherite_opal_armor_durability")) {source.sendSuccess(new TextComponent("Netherite Opal Armor Durabiliity §5" + OADConfig.netherite_opal_armor_durability.get().toString()), false); }
		
		if(option.equalsIgnoreCase("amethyst_helmet_armor")) {source.sendSuccess(new TextComponent("Amethyst Helmet Armor: §d" + OADConfig.amethyst_helmet_armor.get().toString()), false); }
		if(option.equalsIgnoreCase("amethyst_chestplate_armor")) {source.sendSuccess(new TextComponent("Amethyst Chestplate Armor: §d" + OADConfig.amethyst_chestplate_armor.get().toString()), false); }
		if(option.equalsIgnoreCase("amethyst_leggings_armor")) {source.sendSuccess(new TextComponent("Amethyst Leggings Armor: §d" + OADConfig.amethyst_leggings_armor.get().toString()), false); }
		if(option.equalsIgnoreCase("amethyst_boots_armor")) {source.sendSuccess(new TextComponent("Amethyst Boots Armor: §d" + OADConfig.amethyst_boots_armor.get().toString()), false); }
		
		if(option.equalsIgnoreCase("amethyst_max_spawn_height_overworld")) {source.sendSuccess(new TextComponent("Amethyst Max Spawn Height Overworld: §d" + OADConfig.amethyst_max_spawn_height_overworld.get().toString()), false); }
		if(option.equalsIgnoreCase("amethyst_max_spawn_height_nether")) {source.sendSuccess(new TextComponent("Amethyst Max Spawn Height Nether: §d" + OADConfig.amethyst_max_spawn_height_nether.get().toString()), false); }
		if(option.equalsIgnoreCase("amethyst_max_spawn_height_end")) {source.sendSuccess(new TextComponent("Amethyst Max Spawn Height End: §d" + OADConfig.amethyst_max_spawn_height_end.get().toString()), false); }
		
		if(option.equalsIgnoreCase("black_opal_max_spawn_height_overworld")) {source.sendSuccess(new TextComponent("Black Opal Max Spawn Height Overworld: §5" + OADConfig.black_opal_max_spawn_height_overworld.get().toString()), false); }
		if(option.equalsIgnoreCase("black_opal_max_spawn_height_nether")) {source.sendSuccess(new TextComponent("Black Opal Max Spawn Height Nether: §5" + OADConfig.black_opal_max_spawn_height_nether.get().toString()), false); }
		if(option.equalsIgnoreCase("black_opal_max_spawn_height_end")) {source.sendSuccess(new TextComponent("Black Opal Max Spawn Height End: §5" + OADConfig.black_opal_max_spawn_height_end.get().toString()), false); }
		
		if(option.equalsIgnoreCase("black_opal_helmet_armor")) {source.sendSuccess(new TextComponent("Black Opal Helmet Armor: §5" + OADConfig.black_opal_helmet_armor.get().toString()), false); }
		if(option.equalsIgnoreCase("black_opal_chestplate_armor")) {source.sendSuccess(new TextComponent("Black Opal Chetplate Armor: §5" + OADConfig.black_opal_chestplate_armor.get().toString()), false); }
		if(option.equalsIgnoreCase("black_opal_leggings_armor")) {source.sendSuccess(new TextComponent("Black Opal Leggings Armor: §5" + OADConfig.black_opal_leggings_armor.get().toString()), false); }
		if(option.equalsIgnoreCase("black_opal_boots_armor")) {source.sendSuccess(new TextComponent("Black Opal Boots Armor: §5" + OADConfig.black_opal_boots_armor.get().toString()), false); }
		
		if(option.equalsIgnoreCase("netherite_opal_helmet_armor")) {source.sendSuccess(new TextComponent("Netherite Opal Helmet Armor: §5" + OADConfig.netherite_opal_helmet_armor.get().toString()), false); }
		if(option.equalsIgnoreCase("netherite_opal_chestplate_armor")) {source.sendSuccess(new TextComponent("Netherite Opal Chetplate Armor: §5" + OADConfig.netherite_opal_chestplate_armor.get().toString()), false); }
		if(option.equalsIgnoreCase("netherite_opal_leggings_armor")) {source.sendSuccess(new TextComponent("Netherite Opal Leggings Armor: §5" + OADConfig.netherite_opal_leggings_armor.get().toString()), false); }
		if(option.equalsIgnoreCase("netherite_opal_boots_armor")) {source.sendSuccess(new TextComponent("Netherite Opal Boots Armor: §5" + OADConfig.netherite_opal_boots_armor.get().toString()), false); }
		
		if(option.equalsIgnoreCase("amethyst_attack_damage")) {source.sendSuccess(new TextComponent("Amethyst Attack Damage: §d" + OADConfig.amethyst_attack_damage.get().toString()), false); }
		if(option.equalsIgnoreCase("amethyst_efficiency")) {source.sendSuccess(new TextComponent("Amethyst Efficiency: §d" + OADConfig.amethyst_efficiency.get().toString()), false); }
		if(option.equalsIgnoreCase("amethyst_durability")) {source.sendSuccess(new TextComponent("Amethyst Durability: §d" + OADConfig.amethyst_durability.get().toString()), false); }
		
		if(option.equalsIgnoreCase("black_opal_attack_damage")) {source.sendSuccess(new TextComponent("Black Opal Attack Damage: §5" + OADConfig.black_opal_attack_damage.get().toString()), false); }
		if(option.equalsIgnoreCase("black_opal_efficiency")) {source.sendSuccess(new TextComponent("Black Opal Efficiency: §5" + OADConfig.black_opal_efficiency.get().toString()), false); }
		if(option.equalsIgnoreCase("black_opal_durability")) {source.sendSuccess(new TextComponent("Black Opal Durability: §5" + OADConfig.black_opal_durability.get().toString()), false); }
		
		if(option.equalsIgnoreCase("netherite_opal_attack_damage")) {source.sendSuccess(new TextComponent("Netherite Opal Attack Damage: §5" + OADConfig.netherite_opal_attack_damage.get().toString()), false); }
		if(option.equalsIgnoreCase("netherite_opal_efficiency")) {source.sendSuccess(new TextComponent("Netherite Opal Efficiency: §5" + OADConfig.netherite_opal_efficiency.get().toString()), false); }
		if(option.equalsIgnoreCase("netherite_opal_durability")) {source.sendSuccess(new TextComponent("Netherite Opal Durability: §5" + OADConfig.netherite_opal_durability.get().toString()), false); }
		
		if(option.equalsIgnoreCase("amethyst_enchantability")) {source.sendSuccess(new TextComponent("Amethyst Enchantability: §d" + OADConfig.amethyst_enchantability.get().toString()), false); }
		if(option.equalsIgnoreCase("black_opal_enchantability")) {source.sendSuccess(new TextComponent("Black Opal Enchantability: §5" + OADConfig.black_opal_enchantability.get().toString()), false); }
		if(option.equalsIgnoreCase("netherite_opal_enchantability")) {source.sendSuccess(new TextComponent("Black Opal Enchantability: §5" + OADConfig.netherite_opal_enchantability.get().toString()), false); }
		
		if(option.equalsIgnoreCase("nether_chance_multiplier")) {source.sendSuccess(new TextComponent("Nether Chance Multiplier: " + OADConfig.nether_chance_multiplier.get().toString()), false); }
		if(option.equalsIgnoreCase("end_chance_multiplier")) {source.sendSuccess(new TextComponent("End Chance Multiplier: " + OADConfig.end_chance_multiplier.get().toString()), false); }
		if(option.equalsIgnoreCase("nether_vein_multiplier")) {source.sendSuccess(new TextComponent("Nether Vein Multiplier: " + OADConfig.nether_vein_multiplier.get().toString()), false); }
		if(option.equalsIgnoreCase("end_vein_multiplier")) {source.sendSuccess(new TextComponent("End Vein Multiplier: " + OADConfig.end_vein_multiplier.get().toString()), false); }
		
		if(option.equalsIgnoreCase("enable_server_config_sync")) {source.sendSuccess(new TextComponent("(Client Side) Enable Server Config Sync: " + OADConfig.enable_server_config_sync.get().toString()), false); }
		if(option.equalsIgnoreCase("send_config_sync_packet")) {source.sendSuccess(new TextComponent("(Server Side) Send Config Sync Packet: " + OADConfig.send_config_sync_packet.get().toString()), false); }
		if(option.equalsIgnoreCase("spawn_amethyst_overworld")) {source.sendSuccess(new TextComponent("Spawn Amethyst Overworld: " + OADConfig.spawn_amethyst_overworld.get().toString()), false); }
		if(option.equalsIgnoreCase("spawn_black_opal_overworld")) {source.sendSuccess(new TextComponent("Spawn Black Opal Overworld: " + OADConfig.spawn_black_opal_overworld.get().toString()), false); }
		if(option.equalsIgnoreCase("spawn_amethyst_nether")) {source.sendSuccess(new TextComponent("Spawn Amethyst Nether: " + OADConfig.spawn_amethyst_nether.get().toString()), false); }
		if(option.equalsIgnoreCase("spawn_black_opal_nether")) {source.sendSuccess(new TextComponent("Spawn Black Opal Nether: " + OADConfig.spawn_black_opal_nether.get().toString()), false); }
		if(option.equalsIgnoreCase("spawn_amethyst_end")) {source.sendSuccess(new TextComponent("Spawn Amethyst End: " + OADConfig.spawn_amethyst_end.get().toString()), false); }
		if(option.equalsIgnoreCase("spawn_black_opal_end")) {source.sendSuccess(new TextComponent("Spawn Black Opal End: " + OADConfig.spawn_black_opal_end.get().toString()), false); }
		if(option.equalsIgnoreCase("old_combat_mechanics")) {source.sendSuccess(new TextComponent("Old Combat Mechanics " + OADConfig.old_combat_mechanics.get().toString()), false); }
		if(option.equalsIgnoreCase("chest_loot")) {source.sendSuccess(new TextComponent("Chest Loot " + OADConfig.chest_loot.get().toString()), false); }
	}
}
*/
