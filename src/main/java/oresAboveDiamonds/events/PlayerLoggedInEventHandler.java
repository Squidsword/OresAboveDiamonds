package oresAboveDiamonds.events;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.network.PacketDistributor;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.network.OADPacketHandler;
import oresAboveDiamonds.network.PacketSyncConfig;

public class PlayerLoggedInEventHandler {
	
	
	
	@SubscribeEvent
	public void onLoginEvent(PlayerLoggedInEvent event) {
		
		ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();
		
		int amethyst_enchant = OADConfig.amethyst_enchantability.get();
		int black_opal_enchant = OADConfig.black_opal_enchantability.get();
		
		int amethyst_ad = OADConfig.amethyst_attack_damage.get();
		int amethyst_efficiency = OADConfig.amethyst_efficiency.get();
		int amethyst_tool_durability = OADConfig.amethyst_durability.get();
		
		int black_opal_ad = OADConfig.black_opal_attack_damage.get();
		int black_opal_efficiency = OADConfig.black_opal_efficiency.get();
		int black_opal_tool_durability = OADConfig.black_opal_durability.get();
		
		int amethyst_toughness = OADConfig.amethyst_armor_toughness.get();
		int black_opal_toughness = OADConfig.black_opal_armor_toughness.get();
		
		int amethyst_armor_durability = OADConfig.amethyst_armor_durability.get();
		int black_opal_armor_durability = OADConfig.black_opal_armor_durability.get();
		
	    int amethyst_helmet_armor = OADConfig.amethyst_helmet_armor.get();
		int amethyst_chestplate_armor = OADConfig.amethyst_chestplate_armor.get();
		int amethyst_leggings_armor = OADConfig.amethyst_leggings_armor.get();
		int amethyst_boots_armor = OADConfig.amethyst_boots_armor.get();
		
		int black_opal_helmet_armor = OADConfig.black_opal_helmet_armor.get();
		int black_opal_chestplate_armor = OADConfig.black_opal_chestplate_armor.get();
		int black_opal_leggings_armor = OADConfig.black_opal_leggings_armor.get();
		int black_opal_boots_armor = OADConfig.black_opal_boots_armor.get();
		
		boolean old_combat_mechanics = OADConfig.old_combat_mechanics.get();
		
		OADPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), new PacketSyncConfig(amethyst_enchant, black_opal_enchant, amethyst_ad, amethyst_efficiency, amethyst_tool_durability,
				 black_opal_ad, black_opal_efficiency, black_opal_tool_durability, amethyst_toughness, black_opal_toughness,
				 amethyst_armor_durability, black_opal_armor_durability, amethyst_helmet_armor, amethyst_chestplate_armor,
				 amethyst_leggings_armor, amethyst_boots_armor, black_opal_helmet_armor, black_opal_chestplate_armor,
				 black_opal_leggings_armor, black_opal_boots_armor, old_combat_mechanics));
	}	
}
