package oresAboveDiamonds.events;

import java.util.Map;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import oresAboveDiamonds.config.OADConfig;

public class AnvilUpdateEventHandler {
	
	@SubscribeEvent(priority = EventPriority.LOW)
	public void anvilEvent(AnvilUpdateEvent event) { 
		
		ItemStack left = event.getLeft();
		ItemStack right = event.getRight();
		ItemStack itemstack = event.getLeft();
		String name = "§" + event.getName();
		int i = 0;
		
		int repairCost1 = left.getRepairCost();
		int repairCost2;
		
		if (right.getItem() != Items.ENCHANTED_BOOK) {
			repairCost2 = right.getRepairCost();
		} else {
			repairCost2 = 0;
		}
		
		if (left.isEmpty() || right.isEmpty()) {
	        return;
		}	 
		
        ItemStack output = left.copy();
         
		if(left.getMaxDamage() <= 0 && right.getItem() != Items.ENCHANTED_BOOK && left.getItem().getRegistryName().equals(right.getItem().getRegistryName()) && right.isItemEnchanted()) {
			
			Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(left);
			Map<Enchantment, Integer> map1 = EnchantmentHelper.getEnchantments(right);
              
			for (Enchantment enchantment1 : map1.keySet())
            {
                if (enchantment1 != null)
                {
                    int i2 = map.containsKey(enchantment1) ? ((Integer)map.get(enchantment1)).intValue() : 0;
                    int j2 = ((Integer)map1.get(enchantment1)).intValue();
                    j2 = i2 == j2 ? j2 + 1 : Math.max(j2, i2);
                    
                    for (Enchantment enchantment : map.keySet())
                    {
                        if (enchantment != enchantment1 && !enchantment1.isCompatibleWith(enchantment))
                        {
                            return;
                        }
                    }
                    
                   if(j2 > enchantment1.getMaxLevel()) {
                	   j2 = enchantment1.getMaxLevel();
                   }
                   if(enchantment1.canApplyAtEnchantingTable(left)) {
                       map.put(enchantment1, j2);
                   }
                   
                   int k3 = 0;

                   switch (enchantment1.getRarity())
                   {
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

                       k3 = Math.max(1, k3/2);

                   i += k3 * j2;

                   if (itemstack.getCount() > 1)
                   {
                       i = 40;
                   }
                   
                }
            }
	        
            EnchantmentHelper.setEnchantments(map, output);
            if(event.getName().length() > 0) {
            output.setStackDisplayName(name);
            }
            output.setRepairCost(Math.max(Math.max(repairCost1, repairCost2) * 2, 1));
            event.setOutput(output);
            if(OADConfig.zzz_infinite_durability_prior_work_penalty = true) {
                event.setCost(i + repairCost1 + repairCost2);
            } else {
            	event.setCost(i);
            }

		} else {
			return;
		}
	}
}
