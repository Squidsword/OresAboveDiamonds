package oresAboveDiamonds.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import oresAboveDiamonds.commands.ConfigValuesList;

public class ConfigHolder {
	public static Pair<List<String>, HashMap<String, ForgeConfigSpec.ConfigValue<Object>>> OADconfig;
	public static HashMap<String, ForgeConfigSpec.ConfigValue<Object>> configMap;
	public static List<String> configNames;
	
	static {
		for(String names : ConfigValuesList.getAllValues()) {
			configNames.add(names);
		}
	}
	
}
