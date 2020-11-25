package oresAboveDiamonds.events;

import java.util.Map;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class AnvilUpdateEventHandler {
	
	@SubscribeEvent(priority = EventPriority.LOW)
	public void anvilEvent(AnvilUpdateEvent event) {
		
		if (event.getLeft().isEmpty() || event.getRight().isEmpty()) {
	        return;
		}	  
		
		ItemStack left = event.getLeft();
		ItemStack right = event.getRight();
		
		int repairCost1 = left.getRepairCost();
		int repairCost2;
		
		if (right.getItem() != Items.ENCHANTED_BOOK) {
			repairCost2 = right.getRepairCost();
		} else {
			repairCost2 = 0;
		}
		
		int i = 0;
              
		if(left.getMaxDamage() <= 0 && right.getItem() != Items.ENCHANTED_BOOK && left.getItem().getRegistryName().equals(right.getItem().getRegistryName()) && right.isEnchanted() == true) {
			
			Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(left);
			Map<Enchantment, Integer> map1 = EnchantmentHelper.getEnchantments(right);
              
            for(Enchantment enchantment1 : map1.keySet()) {
                if (enchantment1 != null) {
                   int i2 = map.containsKey(enchantment1) ? map.get(enchantment1) : 0;
                   int j2 = map1.get(enchantment1);
                   j2 = i2 == j2 ? j2 + 1 : Math.max(j2, i2);
                   if(j2 > enchantment1.getMaxLevel()) {
                	   j2 = enchantment1.getMaxLevel();
                   }
                   if(enchantment1.canApplyAtEnchantingTable(left)) {
                       map.put(enchantment1, j2);
                       int k3 = 0;
                       switch(enchantment1.getRarity()) {
                       case COMMON:
                          k3 = 1;
                          break;
                       case UNCOMMON:
                          k3 = 2;
                          break;
                       case RARE:
                          k3 = 4;
                          break;
                       case VERY_RARE:
                          k3 = 8;
                       }

                          k3 = Math.max(1, k3 / 2);

                       i += k3 * j2;
                       if (left.getCount() > 1) {
                          i = 40;
                       }
                    }
                 }
              }  
            
            ItemStack output = left.copy();

    		if(event.getName().length() > 1 && event.getName().startsWith("§")) {
        		ITextComponent name = new StringTextComponent(event.getName().substring(1));
                output.setDisplayName(name);
                }
            output.setRepairCost(Math.max(Math.max(repairCost1, repairCost2) * 2, 1));
            EnchantmentHelper.setEnchantments(map, output);
            event.setOutput(output);
            event.setCost(i + repairCost1 + repairCost2);
		}
	}
}
