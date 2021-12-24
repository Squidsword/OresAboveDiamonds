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

	public void addDescription(List<Component> tooltip, double chance, double vein, int height, String world, String color, double disappearChance) {
		tooltip.add(new TextComponent("\u00A7a" + "Generating in the " + world));
		tooltip.add(new TextComponent(color + "1 in " + chance + "\u00A7r" + " chance of spawning per chunk"));
		tooltip.add(new TextComponent("Average vein size of " + color + vein));
		tooltip.add(new TextComponent("Spawns below " + color + "y:" + height));
		tooltip.add(new TextComponent(color + Math.round(disappearChance*100) + "%" + "\u00A7r" + " chance of disappearing if exposed to air"));
	}
	public void addDisabled(List<Component> tooltip) {
		tooltip.add(new TextComponent("\u00A7c" + "DISABLED"));
		tooltip.add(new TextComponent("Can be enabled in the config file."));
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
					addDisabled(tooltip);
				}
				break;
			case "AMETHYST_ORE":
				if(OADConfig.spawn_amethyst_overworld.get() == true) {
					addDescription(tooltip, OADConfig.amethyst_times_rarer.get(), OADConfig.amethyst_vein_size.get(), OADConfig.amethyst_max_spawn_height_overworld.get(), "Overworld", "\u00A7d", OADConfig.overworld_discard_chance_on_air_exposure.get());
					/*
					tooltip.add(new TextComponent("\u00A7a" + "Generating in the Overworld"));
					tooltip.add(new TextComponent("\u00A7d" + "1 in " + OADConfig.amethyst_times_rarer.get() + "\u00A7r" + " chance of spawning per chunk"));
					tooltip.add(new TextComponent("Max vein size of " + "\u00A7d" + OADConfig.amethyst_vein_size.get()));
					tooltip.add(new TextComponent("Spawns below " + "\u00A7d" + "y:" + OADConfig.amethyst_max_spawn_height_overworld.get()));
					*/
				} else {
					addDisabled(tooltip);
				}
				break;
			case "NETHER_AMETHYST_ORE":
				if(OADConfig.spawn_amethyst_nether.get() == true) {
					int spawnchance = Math.max(1, (int) (OADConfig.amethyst_times_rarer.get() / (OADConfig.nether_chance_multiplier.get())));
					int veinsize =  (int) (OADConfig.amethyst_vein_size.get() * OADConfig.nether_vein_multiplier.get());
					addDescription(tooltip, spawnchance, veinsize, OADConfig.amethyst_max_spawn_height_nether.get(), "Nether", "\u00A7d", OADConfig.nether_discard_chance_on_air_exposure.get());
				} else {
					addDisabled(tooltip);
				}
				break;
				
			case "END_AMETHYST_ORE":
				
				if(OADConfig.spawn_amethyst_end.get() == true) {
					int spawnchance = Math.max(1, (int) (OADConfig.amethyst_times_rarer.get() / (OADConfig.end_chance_multiplier.get())));
					int veinsize =  (int) (OADConfig.amethyst_vein_size.get() * OADConfig.end_vein_multiplier.get());
					addDescription(tooltip, spawnchance, veinsize, OADConfig.amethyst_max_spawn_height_end.get(), "End", "\u00A7d", OADConfig.end_discard_chance_on_air_exposure.get());
				} else {
					addDisabled(tooltip);
				} 
				break;
				
			case "DEEPSLATE_BLACK_OPAL_ORE":
				if(OADConfig.spawn_black_opal_overworld.get() == true) {
					tooltip.add(new TextComponent("Spawns when a normal black opal ore tries to generate in a deepslate block."));
				} else {
					addDisabled(tooltip);
				}
				break;
				
			case "BLACK_OPAL_ORE":
				if(OADConfig.spawn_black_opal_overworld.get() == true) {
					addDescription(tooltip, OADConfig.black_opal_times_rarer.get(), OADConfig.black_opal_vein_size.get(), OADConfig.black_opal_max_spawn_height_overworld.get(), "Overworld", "\u00A75", OADConfig.overworld_discard_chance_on_air_exposure.get());
				} else {
					addDisabled(tooltip);
				}
				break;
			case "NETHER_BLACK_OPAL_ORE":
				if(OADConfig.spawn_black_opal_nether.get() == true) {
					int spawnchance = Math.max(1, (int) (OADConfig.black_opal_times_rarer.get() / (OADConfig.nether_chance_multiplier.get())));
					int veinsize =  (int) (OADConfig.black_opal_vein_size.get() * OADConfig.nether_vein_multiplier.get());
					addDescription(tooltip, spawnchance, veinsize, OADConfig.black_opal_max_spawn_height_nether.get(), "Nether", "\u00A75", OADConfig.nether_discard_chance_on_air_exposure.get());
				} else {
					addDisabled(tooltip);
				}
				break;
				
			case "END_BLACK_OPAL_ORE":
				
				if(OADConfig.spawn_black_opal_end.get() == true) {
					int spawnchance = Math.max(1, (int) (OADConfig.black_opal_times_rarer.get() / (OADConfig.end_chance_multiplier.get())));
					int veinsize =  (int) (OADConfig.black_opal_vein_size.get() * OADConfig.end_vein_multiplier.get());
					addDescription(tooltip, spawnchance, veinsize, OADConfig.black_opal_max_spawn_height_end.get(), "End", "\u00A75", OADConfig.end_discard_chance_on_air_exposure.get());
				} else {
					addDisabled(tooltip);
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
