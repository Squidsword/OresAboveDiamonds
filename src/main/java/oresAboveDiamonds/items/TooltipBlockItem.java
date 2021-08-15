package oresAboveDiamonds.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.util.KeyboardUtil;

public class TooltipBlockItem extends BlockItem {

	
	public TooltipBlockItem(Block blockIn, Properties builder) {
		super(blockIn, builder);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		
		String blockName = this.getDescriptionId().toUpperCase();
		blockName = blockName.substring(blockName.lastIndexOf(".") + 1);
		
		if(KeyboardUtil.isHoldingShift()) {
			switch(blockName) {
			case "DEEPSLATE_AMETHYST_ORE":
				if(OADConfig.spawn_amethyst_overworld.get() == true) {
					tooltip.add(new TextComponent("Spawns when a normal amethyst ore tries to generate in a deepslate block."));
				} else {
					tooltip.add(new TextComponent("\u00A7c" + "DISABLED"));
					tooltip.add(new TextComponent("If overworld amethyst ores are enabled, this one will be enabled as well to compliment them."));
				}
				break;
			case "AMETHYST_ORE":
				if(OADConfig.spawn_amethyst_overworld.get() == true) {
					tooltip.add(new TextComponent("\u00A7a" + "Generating in the Overworld"));
					tooltip.add(new TextComponent("\u00A7d" + "1 in " + OADConfig.amethyst_times_rarer.get() + "\u00A7r" + " chance of spawning per chunk"));
					tooltip.add(new TextComponent("Max vein size of " + "\u00A7d" + OADConfig.amethyst_max_vein_size.get()));
					tooltip.add(new TextComponent("Spawns below " + "\u00A7d" + "y:" + OADConfig.amethyst_max_spawn_height_overworld.get()));
				} else {
					tooltip.add(new TextComponent("\u00A7c" + "DISABLED"));
					tooltip.add(new TextComponent("Can be enabled in the config file."));
				}
				break;
			case "NETHER_AMETHYST_ORE":
				if(OADConfig.spawn_amethyst_nether.get() == true) {
					int spawnchance = Math.max(1, (int) (OADConfig.amethyst_times_rarer.get() / (OADConfig.nether_chance_multiplier.get())));
					int veinsize =  (int) (OADConfig.amethyst_max_vein_size.get() * OADConfig.nether_vein_multiplier.get());
					tooltip.add(new TextComponent("\u00A7a" + "Generating in the Nether"));
					tooltip.add(new TextComponent("\u00A7d" + "1 in " + spawnchance + "\u00A7r" + " chance of spawning per chunk"));
					tooltip.add(new TextComponent("Max vein size of " + "\u00A7d" + veinsize));
					tooltip.add(new TextComponent("Spawns below " + "\u00A7d" + "y:" + OADConfig.amethyst_max_spawn_height_nether.get()));
				} else {
					tooltip.add(new TextComponent("\u00A7c" + "DISABLED"));
					tooltip.add(new TextComponent("Can be enabled in the config file."));
				}
				break;
				
			case "END_AMETHYST_ORE":
				
				if(OADConfig.spawn_amethyst_end.get() == true) {
					int spawnchance = Math.max(1, (int) (OADConfig.amethyst_times_rarer.get() / (OADConfig.end_chance_multiplier.get())));
					int veinsize =  (int) (OADConfig.amethyst_max_vein_size.get() * OADConfig.end_vein_multiplier.get());
					tooltip.add(new TextComponent("\u00A7a" + "Generating in the End"));
					tooltip.add(new TextComponent("\u00A7d" + "1 in " + spawnchance + "\u00A7r" + " chance of spawning per chunk"));
					tooltip.add(new TextComponent("Max vein size of " + "\u00A7d" + veinsize));
					tooltip.add(new TextComponent("Spawns below " + "\u00A7d" + "y:" + OADConfig.amethyst_max_spawn_height_end.get()));
				} else {
					tooltip.add(new TextComponent("\u00A7c" + "DISABLED"));
					tooltip.add(new TextComponent("Can be enabled in the config file."));
				} 
				break;
				
			case "DEEPSLATE_BLACK_OPAL_ORE":
				if(OADConfig.spawn_black_opal_overworld.get() == true) {
					tooltip.add(new TextComponent("Spawns when a normal black opal ore tries to generate in a deepslate block."));
				} else {
					tooltip.add(new TextComponent("\u00A7c" + "DISABLED"));
					tooltip.add(new TextComponent("If overworld black opal ores are enabled, this one will be enabled as well to compliment them."));
				}
				break;
				
			case "BLACK_OPAL_ORE":
				if(OADConfig.spawn_black_opal_overworld.get() == true) {
					tooltip.add(new TextComponent("\u00A7a" + "Generating in the Overworld"));
					tooltip.add(new TextComponent("\u00A75" + "1 in " + OADConfig.black_opal_times_rarer.get() + "\u00A7r" + " chance of spawning per chunk"));
					tooltip.add(new TextComponent("Max vein size of " + "\u00A75" + OADConfig.black_opal_max_vein_size.get()));
					tooltip.add(new TextComponent("Spawns below " + "\u00A75" + "y:" + OADConfig.black_opal_max_spawn_height_overworld.get()));
				} else {
					tooltip.add(new TextComponent("\u00A7c" + "DISABLED"));
					tooltip.add(new TextComponent("Can be enabled in the config file."));
				}
				break;
			case "NETHER_BLACK_OPAL_ORE":
				if(OADConfig.spawn_black_opal_nether.get() == true) {
					int spawnchance = Math.max(1, (int) (OADConfig.black_opal_times_rarer.get() / (OADConfig.nether_chance_multiplier.get())));
					int veinsize =  (int) (OADConfig.black_opal_max_vein_size.get() * OADConfig.nether_vein_multiplier.get());
					tooltip.add(new TextComponent("\u00A7a" + "Generating in the Nether"));
					tooltip.add(new TextComponent("\u00A75" + "1 in " + spawnchance + "\u00A7r" + " chance of spawning per chunk"));
					tooltip.add(new TextComponent("Max vein size of " + "\u00A75" + veinsize));
					tooltip.add(new TextComponent("Spawns below " + "\u00A75" + "y:" + OADConfig.black_opal_max_spawn_height_nether.get()));
				} else {
					tooltip.add(new TextComponent("\u00A7c" + "DISABLED"));
					tooltip.add(new TextComponent("Can be enabled in the config file."));
				}
				break;
				
			case "END_BLACK_OPAL_ORE":
				
				if(OADConfig.spawn_black_opal_end.get() == true) {
					int spawnchance = Math.max(1, (int) (OADConfig.black_opal_times_rarer.get() / (OADConfig.end_chance_multiplier.get())));
					int veinsize =  (int) (OADConfig.black_opal_max_vein_size.get() * OADConfig.end_vein_multiplier.get());
					tooltip.add(new TextComponent("\u00A7a" + "Generating in the End"));
					tooltip.add(new TextComponent("\u00A75" + "1 in " + spawnchance + "\u00A7r" + " chance of spawning per chunk"));
					tooltip.add(new TextComponent("Max vein size of " + "\u00A75" + veinsize));
					tooltip.add(new TextComponent("Spawns below " + "\u00A75" + "y:" + OADConfig.black_opal_max_spawn_height_end.get()));
				} else {
					tooltip.add(new TextComponent("\u00A7c" + "DISABLED"));
					tooltip.add(new TextComponent("Can be enabled in the config file."));
				}
				break;
				
				default:
			}
		} else {
			switch(blockName) {
			case "DEEPSLATE_AMETHYST_ORE":
			case "AMETHYST_ORE":
				if(OADConfig.spawn_amethyst_overworld.get() == false) {
					tooltip.add(new TextComponent("\u00A7c" + "DISABLED"));
				}
				break;
			case "NETHER_AMETHYST_ORE":
				if(OADConfig.spawn_amethyst_nether.get() == false) {
					tooltip.add(new TextComponent("\u00A7c" + "DISABLED"));
				}
				break;
				
			case "END_AMETHYST_ORE":
				if(OADConfig.spawn_amethyst_end.get() == false ) {
					tooltip.add(new TextComponent("\u00A7c" + "DISABLED"));
				}
				break;
				
			case "DEEPSLATE_BLACK_OPAL_ORE":
			case "BLACK_OPAL_ORE":
				if(OADConfig.spawn_black_opal_overworld.get() == false) {
					tooltip.add(new TextComponent("\u00A7c" + "DISABLED"));
				}
				break;
			case "NETHER_BLACK_OPAL_ORE":
				if(OADConfig.spawn_black_opal_nether.get() == false) {
					tooltip.add(new TextComponent("\u00A7c" + "DISABLED"));
				}
				break;
				
			case "END_BLACK_OPAL_ORE":
				if(OADConfig.spawn_black_opal_end.get() == false) {
					tooltip.add(new TextComponent("\u00A7c" + "DISABLED"));
				}
				break;
				
				default:
			}
			tooltip.add(new TextComponent("\u00A77" + "\u00A7o" + "Hold " + "\u00A76" + "\u00A7o" + "SHIFT" + "\u00A77" + "\u00A7o" + " for more information"));
		}
		
	}

}
