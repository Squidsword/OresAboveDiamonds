package oresAboveDiamonds.events;


import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.TableLootEntry;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import oresAboveDiamonds.config.OADConfig;


public class LootTableHandler {

	//Code here created by Vazkii's mod Botania
	
	@SubscribeEvent
	public static void lootLoad(LootTableLoadEvent event) {
		String prefix = "minecraft:chests/";
		String name = event.getName().toString();

		if (name.startsWith(prefix) && OADConfig.chest_loot.get() == true) {
			String file = name.substring(name.indexOf(prefix) + prefix.length());
			switch (file) {
			case "abandoned_mineshaft":
			case "bastion_treasure":
			case "jungle_temple":
			case "buried_treasure":
			case "desert_pyramid":
			case "end_city_treasure":
			case "nether_bridge":
			case "shipwreck_treasure":
			case "village_toolsmith":
			case "village_weaponsmith":
				event.getTable().addPool(getInjectPool(file));
				break;
			default:
				break;
			}
		}
	}

	public static LootPool getInjectPool(String entryName) {
		return LootPool.builder()
				.addEntry(getInjectEntry(entryName, 1))
				.name("oresabovediamonds_inject")
				.build();
	}

	private static LootEntry.Builder<?> getInjectEntry(String name, int weight) {
		ResourceLocation table = new ResourceLocation("oresabovediamonds", "inject/" + name);
		return TableLootEntry.builder(table)
				.weight(weight);
	}

}
