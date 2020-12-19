package oresAboveDiamonds.customItems;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.util.KeyboardUtil;

public class TooltipBlockItem extends BlockItem {

	
	public TooltipBlockItem(Block blockIn, Properties builder) {
		super(blockIn, builder);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		
		String blockName = this.getName().getString().toUpperCase();
		blockName = blockName.substring(blockName.indexOf("§") + 2); //Gets the block name right after the color tag
		
		if(KeyboardUtil.isHoldingShift()) {
			switch(blockName) {
			case "AMETHYST ORE":
				if(OADConfig.spawn_amethyst_overworld.get() == true) {
					double percentChance = Math.min(OADConfig.amethyst_chance.get(), 1.000);
					percentChance = Math.round(percentChance * 100D);
					tooltip.add(new StringTextComponent("\u00A7a" + "Generating in the Overworld"));
					tooltip.add(new StringTextComponent("\u00A7d" + percentChance + "%\u00A7r" + " chance of spawning per chunk."));
					tooltip.add(new StringTextComponent("Max vein size of " + "\u00A7d" + OADConfig.amethyst_max_vein_size.get()));
					tooltip.add(new StringTextComponent("Spawns below " + "\u00A7d" + "y:" + OADConfig.amethyst_max_spawn_height_overworld.get()));
				} else {
					tooltip.add(new StringTextComponent("\u00A7c" + "DISABLED"));
					tooltip.add(new StringTextComponent("Can be enabled in the config file."));
				}
				break;
			case "NETHER AMETHYST ORE":
				if(OADConfig.spawn_amethyst_nether.get() == true) {
					double percentChance =  Math.min(OADConfig.amethyst_chance.get() * OADConfig.nether_chance_multiplier.get(), 1.000);
					percentChance = Math.round(percentChance*100D);
					int veinsize =  (int) (OADConfig.amethyst_max_vein_size.get() * OADConfig.nether_vein_multiplier.get());
					tooltip.add(new StringTextComponent("\u00A7a" + "Generating in the Nether"));
					tooltip.add(new StringTextComponent("\u00A7d" + percentChance + "%\u00A7r" + " chance of spawning per chunk."));
					tooltip.add(new StringTextComponent("Max vein size of " + "\u00A7d" + veinsize));
					tooltip.add(new StringTextComponent("Spawns below " + "\u00A7d" + "y:" + OADConfig.amethyst_max_spawn_height_nether.get()));
				} else {
					tooltip.add(new StringTextComponent("\u00A7c" + "DISABLED"));
					tooltip.add(new StringTextComponent("Can be enabled in the config file."));
				}
				break;
				
			case "END AMETHYST ORE":
				
				if(OADConfig.spawn_amethyst_end.get() == true) {
					double percentChance =  Math.min(OADConfig.amethyst_chance.get() * OADConfig.end_chance_multiplier.get(), 1.000);
					percentChance = Math.round(percentChance*100D);
					int veinsize =  (int) (OADConfig.amethyst_max_vein_size.get() * OADConfig.end_vein_multiplier.get());
					tooltip.add(new StringTextComponent("\u00A7a" + "Generating in the End"));
					tooltip.add(new StringTextComponent("\u00A7d" + percentChance + "%\u00A7r" + " chance of spawning per chunk."));
					tooltip.add(new StringTextComponent("Max vein size of " + "\u00A7d" + veinsize));
					tooltip.add(new StringTextComponent("Spawns below " + "\u00A7d" + "y:" + OADConfig.amethyst_max_spawn_height_nether.get()));
				} else {
					tooltip.add(new StringTextComponent("\u00A7c" + "DISABLED"));
					tooltip.add(new StringTextComponent("Can be enabled in the config file."));
				} 
				//tooltip.add(new StringTextComponent("End ore generation isn't supported currently."));
				break;
				
			case "BLACK OPAL ORE":
				if(OADConfig.spawn_black_opal_overworld.get() == true) {
					double percentChance = Math.min(OADConfig.black_opal_chance.get(), 1.000);
					percentChance = Math.round(percentChance * 100D);
					tooltip.add(new StringTextComponent("\u00A7a" + "Generating in the Overworld"));
					tooltip.add(new StringTextComponent("\u00A75" + percentChance + "%\u00A7r" + " chance of spawning per chunk"));
					tooltip.add(new StringTextComponent("Max vein size of " + "\u00A75" + OADConfig.black_opal_max_vein_size.get()));
					tooltip.add(new StringTextComponent("Spawns below " + "\u00A75" + "y:" + OADConfig.black_opal_max_spawn_height_overworld.get()));
				} else {
					tooltip.add(new StringTextComponent("\u00A7c" + "DISABLED"));
					tooltip.add(new StringTextComponent("Can be enabled in the config file."));
				}
				break;
			case "NETHER BLACK OPAL ORE":
				if(OADConfig.spawn_black_opal_nether.get() == true) {
					double percentChance =  Math.min(OADConfig.black_opal_chance.get() * OADConfig.nether_chance_multiplier.get(), 1.000);
					percentChance = Math.round(percentChance*100D);
					int veinsize =  (int) (OADConfig.black_opal_max_vein_size.get() * OADConfig.nether_vein_multiplier.get());
					tooltip.add(new StringTextComponent("\u00A7a" + "Generating in the Nether"));
					tooltip.add(new StringTextComponent("\u00A75" + percentChance + "%\u00A7r" + " chance of spawning per chunk."));
					tooltip.add(new StringTextComponent("Max vein size of " + "\u00A75" + veinsize));
					tooltip.add(new StringTextComponent("Spawns below " + "\u00A75" + "y:" + OADConfig.black_opal_max_spawn_height_nether.get()));
				} else {
					tooltip.add(new StringTextComponent("\u00A7c" + "DISABLED"));
					tooltip.add(new StringTextComponent("Can be enabled in the config file."));
				}
				break;
				
			case "END BLACK OPAL ORE":
				
				if(OADConfig.spawn_black_opal_end.get() == true) {
					double percentChance =  Math.min(OADConfig.black_opal_chance.get() * OADConfig.end_chance_multiplier.get(), 1.000);
					percentChance = Math.round(percentChance*100D);
					int veinsize =  (int) (OADConfig.black_opal_max_vein_size.get() * OADConfig.end_vein_multiplier.get());
					tooltip.add(new StringTextComponent("\u00A7a" + "Generating in the End"));
					tooltip.add(new StringTextComponent("\u00A75" + percentChance + "%\u00A7r" + " chance of spawning per chunk."));
					tooltip.add(new StringTextComponent("Max vein size of " + "\u00A75" + + veinsize))	 ;
					tooltip.add(new StringTextComponent("Spawns below " + "\u00A75" + "y:" + OADConfig.black_opal_max_spawn_height_end.get()));
				} else {
					tooltip.add(new StringTextComponent("\u00A7c" + "DISABLED"));
					tooltip.add(new StringTextComponent("Can be enabled in the config file."));
				}
				//tooltip.add(new StringTextComponent("End ore generation isn't supported currently."));
				break;
				
				default:
			}
		} else {
			switch(blockName) {
			case "AMETHYST ORE":
				if(OADConfig.spawn_amethyst_overworld.get() == false) {
					tooltip.add(new StringTextComponent("\u00A7c" + "DISABLED"));
				}
				break;
			case "NETHER AMETHYST ORE":
				if(OADConfig.spawn_amethyst_nether.get() == false) {
					tooltip.add(new StringTextComponent("\u00A7c" + "DISABLED"));
				}
				break;
				
			case "END AMETHYST ORE":
				if(OADConfig.spawn_amethyst_end.get() == false) {
					tooltip.add(new StringTextComponent("\u00A7c" + "DISABLED"));
				}
				break;
				
			case "BLACK OPAL ORE":
				if(OADConfig.spawn_black_opal_overworld.get() == false) {
					tooltip.add(new StringTextComponent("\u00A7c" + "DISABLED"));
				}
				break;
			case "NETHER BLACK OPAL ORE":
				if(OADConfig.spawn_black_opal_nether.get() == false) {
					tooltip.add(new StringTextComponent("\u00A7c" + "DISABLED"));
				}
				break;
				
			case "END BLACK OPAL ORE":
				if(OADConfig.spawn_black_opal_end.get() == false) {
					tooltip.add(new StringTextComponent("\u00A7c" + "DISABLED"));
				}
				break;
				
				default:
			}
			tooltip.add(new StringTextComponent("\u00A77" + "\u00A7o" + "Hold " + "\u00A76" + "\u00A7o" + "SHIFT" + "\u00A77" + "\u00A7o" + " for more information."));
		}
		
	}

}
