package oresAboveDiamonds.events;

import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import oresAboveDiamonds.init.ModItems;

public class LootTableHandler {
	
	@SubscribeEvent
	public void onLootTableLoad(final LootTableLoadEvent event) {
		
            if(event.getName().equals(LootTableList.CHESTS_ABANDONED_MINESHAFT)) {
        	
            	LootEntry entry = new LootEntryItem(
            			ModItems.AMETHYST, 100, 50, new LootFunction[0], new LootCondition[0], "oresabovediamonds:amethyst");
            	
            	LootEntry entry2 = new LootEntryItem(
            			ModItems.BLACK_OPAL, 100, 50, new LootFunction[0], new LootCondition[0], "oresabovediamonds:amethyst");
            	
                event.getTable().getPool("main").addEntry(entry);
                event.getTable().getPool("main").addEntry(entry2);
            }
	}
}
