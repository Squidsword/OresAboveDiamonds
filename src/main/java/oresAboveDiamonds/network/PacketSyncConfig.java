package oresAboveDiamonds.network;

import java.util.function.Supplier;

import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.fml.network.NetworkEvent;
import oresAboveDiamonds.config.OADConfig;

public class PacketSyncConfig {
	
	private int amethyst_enchant;
	private int black_opal_enchant;
	private int netherite_opal_enchant;
	
	private int amethyst_ad;
	private int amethyst_efficiency;
	private int amethyst_tool_durability;
	
	private int black_opal_ad;
	private int black_opal_efficiency;
	private int black_opal_tool_durability;
	
	private int netherite_opal_ad;
	private int netherite_opal_efficiency;
	private int netherite_opal_tool_durability;
	
	private int amethyst_toughness;
	private int black_opal_toughness;
	private int netherite_opal_toughness;
	
	private int amethyst_knockback_resistance;
	private int black_opal_knockback_resistance;
	private int netherite_opal_knockback_resistance;
	
	private int amethyst_armor_durability;
	private int black_opal_armor_durability;
	private int netherite_opal_armor_durability;
	
	private int amethyst_helmet_armor;
	private int amethyst_chestplate_armor;
	private int amethyst_leggings_armor;
	private int amethyst_boots_armor;
	
	private int black_opal_helmet_armor;
	private int black_opal_chestplate_armor;
	private int black_opal_leggings_armor;
	private int black_opal_boots_armor;
	
	private int netherite_opal_helmet_armor;
	private int netherite_opal_chestplate_armor;
	private int netherite_opal_leggings_armor;
	private int netherite_opal_boots_armor;
	
	private boolean old_combat_mechanics;
	
	public PacketSyncConfig() {
		
	}
	
	public PacketSyncConfig(int amethyst_enchant, int black_opal_enchant, int netherite_opal_enchant, int amethyst_ad, int amethyst_efficiency,
							int amethyst_tool_durability, int black_opal_ad, int black_opal_efficiency, int black_opal_tool_durability, int netherite_opal_ad, int netherite_opal_efficiency, int netherite_opal_tool_durability,
							int amethyst_toughness, int black_opal_toughness, int netherite_opal_toughness, int amethyst_knockback_resistance, int black_opal_knockback_resistance, int netherite_opal_knockback_resistance, int amethyst_armor_durability, int black_opal_armor_durability, int netherite_opal_armor_durability,
							int amethyst_helmet_armor, int amethyst_chestplate_armor, int amethyst_leggings_armor, int amethyst_boots_armor,
							int black_opal_helmet_armor, int black_opal_chestplate_armor, int black_opal_leggings_armor, int black_opal_boots_armor, int netherite_opal_helmet_armor, int netherite_opal_chestplate_armor, int netherite_opal_leggings_armor, int netherite_opal_boots_armor, boolean old_combat_mechanics) {
	
		this.amethyst_enchant = amethyst_enchant;
		this.black_opal_enchant = black_opal_enchant;
		this.netherite_opal_enchant = netherite_opal_enchant;
		
		this.amethyst_ad = amethyst_ad;
		this.amethyst_efficiency = amethyst_efficiency;
		this.amethyst_tool_durability = amethyst_tool_durability;
		
		this.black_opal_ad = black_opal_ad;
		this.black_opal_efficiency = black_opal_efficiency;
		this.black_opal_tool_durability = black_opal_tool_durability;
		
		this.netherite_opal_ad = netherite_opal_ad;
		this.netherite_opal_efficiency = netherite_opal_efficiency;
		this.netherite_opal_tool_durability = netherite_opal_tool_durability;
		
		this.amethyst_toughness = amethyst_toughness;
		this.black_opal_toughness = black_opal_toughness;
		this.netherite_opal_toughness = netherite_opal_toughness;
		
		this.amethyst_helmet_armor = amethyst_helmet_armor;
		this.amethyst_chestplate_armor = amethyst_chestplate_armor;
		this.amethyst_leggings_armor = amethyst_leggings_armor;
		this.amethyst_boots_armor = amethyst_boots_armor;
		
		this.black_opal_helmet_armor = black_opal_helmet_armor;
		this.black_opal_chestplate_armor = black_opal_chestplate_armor;
		this.black_opal_leggings_armor = black_opal_leggings_armor;
		this.black_opal_boots_armor = black_opal_boots_armor;	
		
		this.netherite_opal_helmet_armor = netherite_opal_helmet_armor;
		this.netherite_opal_chestplate_armor = netherite_opal_chestplate_armor;
		this.netherite_opal_leggings_armor = netherite_opal_leggings_armor;
		this.netherite_opal_boots_armor = netherite_opal_boots_armor;
		
		this.old_combat_mechanics = old_combat_mechanics;
	}
	
	public static void encode(PacketSyncConfig msg, PacketBuffer buf) { 
		 buf.writeInt(msg.amethyst_enchant);
		 buf.writeInt(msg.black_opal_enchant);
		
		 buf.writeInt(msg.amethyst_ad);
		 buf.writeInt(msg.amethyst_efficiency);
		 buf.writeInt(msg.amethyst_tool_durability);
		
		 buf.writeInt(msg.black_opal_ad);
		 buf.writeInt(msg.black_opal_efficiency);
		 buf.writeInt(msg.black_opal_tool_durability);
		 
		 buf.writeInt(msg.netherite_opal_ad);
		 buf.writeInt(msg.netherite_opal_efficiency);
		 buf.writeInt(msg.netherite_opal_tool_durability);
		
		 buf.writeInt(msg.amethyst_toughness);
		 buf.writeInt(msg.black_opal_toughness);
		 buf.writeInt(msg.netherite_opal_toughness);
		 
		 buf.writeInt(msg.amethyst_knockback_resistance);
		 buf.writeInt(msg.black_opal_knockback_resistance);
		 buf.writeInt(msg.netherite_opal_knockback_resistance);
		
		 buf.writeInt(msg.amethyst_armor_durability);
		 buf.writeInt(msg.black_opal_armor_durability);
		 buf.writeInt(msg.netherite_opal_armor_durability);
		
		 buf.writeInt(msg.amethyst_helmet_armor);
		 buf.writeInt(msg.amethyst_chestplate_armor);
		 buf.writeInt(msg.amethyst_leggings_armor);
		 buf.writeInt(msg.amethyst_boots_armor);
		
		 buf.writeInt(msg.black_opal_helmet_armor);
		 buf.writeInt(msg.black_opal_chestplate_armor);
		 buf.writeInt(msg.black_opal_leggings_armor);
		 buf.writeInt(msg.black_opal_boots_armor);
		 
		 buf.writeInt(msg.netherite_opal_helmet_armor);
		 buf.writeInt(msg.netherite_opal_chestplate_armor);
		 buf.writeInt(msg.netherite_opal_leggings_armor);
		 buf.writeInt(msg.netherite_opal_boots_armor);
		 
		 buf.writeBoolean(msg.old_combat_mechanics);
		 
	}
	
	public static PacketSyncConfig decode(PacketBuffer buf) {
		return new PacketSyncConfig(buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readBoolean());
	}
	
	@SuppressWarnings("resource")
	public static void handle(PacketSyncConfig message, Supplier<NetworkEvent.Context> ctx) {
		
		int counter = 0;
		if(OADConfig.enable_server_config_sync.get() == true) {
		
			if(OADConfig.amethyst_enchantability.get() != message.amethyst_enchant) {OADConfig.amethyst_enchantability.set(message.amethyst_enchant); counter++;}
			if(OADConfig.black_opal_enchantability.get() != message.black_opal_enchant) {OADConfig.black_opal_enchantability.set(message.black_opal_enchant); counter++;}
			if(OADConfig.netherite_opal_enchantability.get() != message.netherite_opal_enchant) {OADConfig.netherite_opal_enchantability.set(message.netherite_opal_enchant); counter++;}
			if(OADConfig.amethyst_attack_damage.get() != message.amethyst_ad) {OADConfig.amethyst_attack_damage.set(message.amethyst_ad); counter++;}
			if(OADConfig.amethyst_efficiency.get() != message.amethyst_efficiency) {OADConfig.amethyst_efficiency.set(message.amethyst_efficiency); counter++;}
			if(OADConfig.amethyst_durability.get() != message.amethyst_tool_durability) {OADConfig.amethyst_durability.set(message.amethyst_tool_durability); counter++;}
			if(OADConfig.black_opal_attack_damage.get() != message.black_opal_ad) {OADConfig.black_opal_attack_damage.set(message.black_opal_ad); counter++;}
			if(OADConfig.black_opal_efficiency.get() != message.black_opal_efficiency) {OADConfig.black_opal_efficiency.set(message.black_opal_efficiency); counter++;}
			if(OADConfig.black_opal_durability.get() != message.black_opal_tool_durability) {OADConfig.black_opal_durability.set(message.black_opal_tool_durability); counter++;}
			if(OADConfig.netherite_opal_attack_damage.get() != message.netherite_opal_ad) {OADConfig.netherite_opal_attack_damage.set(message.netherite_opal_ad); counter++;}
			if(OADConfig.netherite_opal_efficiency.get() != message.netherite_opal_efficiency) {OADConfig.netherite_opal_efficiency.set(message.netherite_opal_efficiency); counter++;}
			if(OADConfig.netherite_opal_durability.get() != message.netherite_opal_tool_durability) {OADConfig.netherite_opal_durability.set(message.netherite_opal_tool_durability); counter++;}
			if(OADConfig.amethyst_armor_toughness.get() != message.amethyst_toughness) {OADConfig.amethyst_armor_toughness.set(message.amethyst_toughness);counter++;}
			if(OADConfig.black_opal_armor_toughness.get() != message.black_opal_toughness) {OADConfig.black_opal_armor_toughness.set(message.black_opal_toughness); counter++;}
			if(OADConfig.netherite_opal_armor_toughness.get() != message.netherite_opal_toughness) {OADConfig.netherite_opal_armor_toughness.set(message.netherite_opal_toughness); counter++;}
			if(OADConfig.amethyst_helmet_armor.get() != message.amethyst_helmet_armor) {OADConfig.amethyst_helmet_armor.set(message.amethyst_helmet_armor); counter++;}
			if(OADConfig.amethyst_chestplate_armor.get() != message.amethyst_chestplate_armor) {OADConfig.amethyst_chestplate_armor.set(message.amethyst_chestplate_armor); counter++;}
			if(OADConfig.amethyst_leggings_armor.get() != message.amethyst_leggings_armor) {OADConfig.amethyst_leggings_armor.set(message.amethyst_leggings_armor); counter++;}
			if(OADConfig.amethyst_boots_armor.get() != message.amethyst_boots_armor) {OADConfig.amethyst_boots_armor.set(message.amethyst_boots_armor); counter++;}
			if(OADConfig.black_opal_helmet_armor.get() != message.black_opal_helmet_armor) {OADConfig.black_opal_helmet_armor.set(message.black_opal_helmet_armor); counter++;}
			if(OADConfig.black_opal_chestplate_armor.get() != message.black_opal_chestplate_armor) {OADConfig.black_opal_chestplate_armor.set(message.black_opal_chestplate_armor); counter++;}
			if(OADConfig.black_opal_leggings_armor.get() != message.black_opal_leggings_armor) {OADConfig.black_opal_leggings_armor.set(message.black_opal_leggings_armor); counter++;}
			if(OADConfig.black_opal_boots_armor.get() != message.black_opal_boots_armor) {OADConfig.black_opal_boots_armor.set(message.black_opal_boots_armor); counter++;}
			if(OADConfig.netherite_opal_helmet_armor.get() != message.netherite_opal_helmet_armor) {OADConfig.netherite_opal_helmet_armor.set(message.netherite_opal_helmet_armor); counter++;}
			if(OADConfig.netherite_opal_chestplate_armor.get() != message.netherite_opal_chestplate_armor) {OADConfig.netherite_opal_chestplate_armor.set(message.netherite_opal_chestplate_armor); counter++;}
			if(OADConfig.netherite_opal_leggings_armor.get() != message.netherite_opal_leggings_armor) {OADConfig.netherite_opal_leggings_armor.set(message.netherite_opal_leggings_armor); counter++;}
			if(OADConfig.netherite_opal_boots_armor.get() != message.netherite_opal_boots_armor) {OADConfig.netherite_opal_boots_armor.set(message.netherite_opal_boots_armor); counter++;}
			if(OADConfig.old_combat_mechanics.get() != message.old_combat_mechanics) {OADConfig.old_combat_mechanics.set(message.old_combat_mechanics); counter++;}
			
			if(counter > 1) {
			ITextComponent playermessage = new StringTextComponent("§dOres Above Diamonds: " + "§rYour config has been synced with the server. " + "§cPlease completely restart minecraft and then rejoin the server for the effects to take place. " + "§9" + counter + " settings were changed.");
			Minecraft.getInstance().player.sendMessage(playermessage, null);
			}	
			if(counter == 1) {
				ITextComponent playermessage = new StringTextComponent("§dOres Above Diamonds: " + "§rYour config has been synced with the server. " + "§cPlease completely restart minecraft and then rejoin the server for the effects to take place. " + "§9" + counter + " setting was changed.");
				Minecraft.getInstance().player.sendMessage(playermessage, null);
			}
		}
		
		ctx.get().setPacketHandled(true);
		
	}
}
