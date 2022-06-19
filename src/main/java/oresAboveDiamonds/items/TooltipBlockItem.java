package oresAboveDiamonds.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.util.KeyboardUtil;

import javax.annotation.Nullable;
import java.util.List;

public class TooltipBlockItem extends BlockItem {

	
	public TooltipBlockItem(Block blockIn, Properties builder) {
		super(blockIn, builder);
		// TODO Auto-generated constructor stub
	}

	public void addDescription(List<Component> tooltip, double chance, double vein, int height, String world, String color, double disappearChance) {
		tooltip.add(Component.literal("\u00A7a" + "Generating in the " + world));
		if (world.equalsIgnoreCase("Nether")) {
			tooltip.add(Component.literal(color + 2*chance + "x" + "\u00A7r" + " rarer than nether gold ore"));
		} else if (world.equalsIgnoreCase("End")) {
			tooltip.add(Component.literal(color + chance + "x" + "\u00A7r" + " less dense than overworld diamonds"));
		} else {
			tooltip.add(Component.literal(color + chance + "x" + "\u00A7r" + " rarer than diamonds"));
		}
		tooltip.add(Component.literal("Max vein size of " + color + vein));
		tooltip.add(Component.literal("Spawns below " + color + "y:" + height));
		tooltip.add(Component.literal(color + Math.round(disappearChance*100) + "%" + "\u00A7r" + " chance of disappearing if exposed to air"));
	}
	public void addDisabled(List<Component> tooltip) {
		tooltip.add(Component.literal("\u00A7c" + "DISABLED"));
		tooltip.add(Component.literal("Can be enabled in the config file."));
	}
	
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {

		/*
		List<Component> list1 = Lists.newArrayList();
		Items.FIREWORK_ROCKET.appendHoverText(itemstack, p_40881_, list1, p_40883_);
		if (!list1.isEmpty()) {
			for(int i = 0; i < list1.size(); ++i) {
				list1.set(i, Component.literal("  ").append(list1.get(i)).withStyle(ChatFormatting.GRAY));
			}

			p_40882_.addAll(list1);
		}
		 */

		String blockName = this.getDescriptionId().toUpperCase();
		blockName = blockName.substring(blockName.lastIndexOf(".") + 1);
		
		if(KeyboardUtil.isHoldingShift()) {
			switch(blockName) {
			case "DEEPSLATE_AMETHYST_ORE":
				if(OADConfig.spawn_amethyst_overworld.get() == true) {
					tooltip.add(Component.literal("Spawns when a normal amethyst ore tries to generate in a deepslate block."));
				} else {
					addDisabled(tooltip);
				}
				break;
			case "AMETHYST_ORE":
				if(OADConfig.spawn_amethyst_overworld.get() == true) {
					addDescription(tooltip, OADConfig.amethyst_times_rarer.get(), OADConfig.amethyst_vein_size.get(), OADConfig.amethyst_max_spawn_height_overworld.get(), "Overworld", "\u00A7d", OADConfig.overworld_discard_chance_on_air_exposure.get());
					/*
					tooltip.add(Component.literal("\u00A7a" + "Generating in the Overworld"));
					tooltip.add(Component.literal("\u00A7d" + "1 in " + OADConfig.amethyst_times_rarer.get() + "\u00A7r" + " chance of spawning per chunk"));
					tooltip.add(Component.literal("Max vein size of " + "\u00A7d" + OADConfig.amethyst_vein_size.get()));
					tooltip.add(Component.literal("Spawns below " + "\u00A7d" + "y:" + OADConfig.amethyst_max_spawn_height_overworld.get()));
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
					tooltip.add(Component.literal("Spawns when a normal black opal ore tries to generate in a deepslate block."));
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
					tooltip.add(Component.literal("\u00A7c" + "DISABLED"));
				}
				break;
			case "NETHER_AMETHYST_ORE":
				if(OADConfig.spawn_amethyst_nether.get() == false) {
					tooltip.add(Component.literal("\u00A7c" + "DISABLED"));
				}
				break;
				
			case "END_AMETHYST_ORE":
				if(OADConfig.spawn_amethyst_end.get() == false ) {
					tooltip.add(Component.literal("\u00A7c" + "DISABLED"));
				}
				break;
				
			case "DEEPSLATE_BLACK_OPAL_ORE":
			case "BLACK_OPAL_ORE":
				if(OADConfig.spawn_black_opal_overworld.get() == false) {
					tooltip.add(Component.literal("\u00A7c" + "DISABLED"));
				}
				break;
			case "NETHER_BLACK_OPAL_ORE":
				if(OADConfig.spawn_black_opal_nether.get() == false) {
					tooltip.add(Component.literal("\u00A7c" + "DISABLED"));
				}
				break;
				
			case "END_BLACK_OPAL_ORE":
				if(OADConfig.spawn_black_opal_end.get() == false) {
					tooltip.add(Component.literal("\u00A7c" + "DISABLED"));
				}
				break;
				
				default:
			}
			tooltip.add(Component.literal("\u00A77" + "\u00A7o" + "Hold " + "\u00A76" + "\u00A7o" + "SHIFT" + "\u00A77" + "\u00A7o" + " for more information"));
		}
		
	}

}
