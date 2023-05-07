package oresAboveDiamonds.events;

import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LootTableHandler {

	// Code here referenced from Vazkii's mod Botania

	@SubscribeEvent
	public static void lootLoad(LootTableLoadEvent event) {
		String prefix = "minecraft:chests/";
		String name = event.getName().toString();
		/*
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
		*/
	}

	/*
	public static LootPool getInjectPool(String entryName) {
		return LootPool.lootPool().add(getInjectEntry(entryName, 1)).name("oresabovediamonds_inject").build();
	}


	private static LootPoolEntryContainer.Builder<?> getInjectEntry(String name, int weight) {
		ResourceLocation table = new ResourceLocation("oresabovediamonds", "inject/" + name);
		return LootItem.lootTableItem(new Item(null));
	}
	*/

}
