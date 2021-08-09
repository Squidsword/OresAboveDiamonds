package oresAboveDiamonds.network;

import java.util.function.Supplier;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraftforge.fmllegacy.network.NetworkEvent;
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
	
	private boolean spawn_amethyst_overworld;
	private boolean spawn_black_opal_overworld;
	private boolean spawn_amethyst_nether;
	private boolean spawn_black_opal_nether;
	private boolean spawn_amethyst_end;
	private boolean spawn_black_opal_end;
	
	private int amethyst_times_rarer;
	private int black_opal_times_rarer;
	
	private int amethyst_max_vein_size;
	private int black_opal_max_vein_size;
	
	private int amethyst_max_spawn_height_overworld;
	private int black_opal_max_spawn_height_overworld;
	
	private int amethyst_max_spawn_height_nether;
	private int black_opal_max_spawn_height_nether;
	
	private int amethyst_max_spawn_height_end;
	private int black_opal_max_spawn_height_end;
	
	public PacketSyncConfig() {
		
	}
	
	public PacketSyncConfig(int amethyst_enchant, int black_opal_enchant, int netherite_opal_enchant, int amethyst_ad, int amethyst_efficiency,
							int amethyst_tool_durability, int black_opal_ad, int black_opal_efficiency, int black_opal_tool_durability, int netherite_opal_ad, int netherite_opal_efficiency, int netherite_opal_tool_durability,
							int amethyst_toughness, int black_opal_toughness, int netherite_opal_toughness, int amethyst_knockback_resistance, int black_opal_knockback_resistance, int netherite_opal_knockback_resistance, int amethyst_armor_durability, int black_opal_armor_durability, int netherite_opal_armor_durability,
							int amethyst_helmet_armor, int amethyst_chestplate_armor, int amethyst_leggings_armor, int amethyst_boots_armor,
							int black_opal_helmet_armor, int black_opal_chestplate_armor, int black_opal_leggings_armor, int black_opal_boots_armor, int netherite_opal_helmet_armor, int netherite_opal_chestplate_armor, int netherite_opal_leggings_armor, int netherite_opal_boots_armor, boolean old_combat_mechanics,
							boolean spawn_amethyst_overworld, boolean spawn_black_opal_overworld, boolean spawn_amethyst_nether, boolean spawn_black_opal_nether, boolean spawn_amethyst_end, boolean spawn_black_opal_end,
							int amethyst_times_rarer, int black_opal_times_rarer, int amethyst_max_vein_size, int black_opal_max_vein_size, int amethyst_max_spawn_height_overworld, int black_opal_max_spawn_height_overworld, int amethyst_max_spawn_height_nether, int black_opal_max_spawn_height_nether, int amethyst_max_spawn_height_end, int black_opal_max_spawn_height_end) {
	
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
		
		this.spawn_amethyst_overworld = spawn_amethyst_overworld;
		this.spawn_black_opal_overworld = spawn_black_opal_overworld;
		this.spawn_amethyst_nether = spawn_amethyst_nether;
		this.spawn_black_opal_nether = spawn_black_opal_nether;
		this.spawn_amethyst_end = spawn_amethyst_end;
		this.spawn_black_opal_end = spawn_black_opal_end;
		
		this.amethyst_times_rarer = amethyst_times_rarer;
		this.black_opal_times_rarer = black_opal_times_rarer;
		
		this.amethyst_max_vein_size = amethyst_max_vein_size;
		this.black_opal_max_vein_size = black_opal_max_vein_size;
		
		this.amethyst_max_spawn_height_overworld = amethyst_max_spawn_height_overworld;
		this.black_opal_max_spawn_height_overworld = black_opal_max_spawn_height_overworld;
		
		this.amethyst_max_spawn_height_nether = amethyst_max_spawn_height_nether;
		this.black_opal_max_spawn_height_nether = black_opal_max_spawn_height_nether;
		
		this.amethyst_max_spawn_height_end = amethyst_max_spawn_height_end;
		this.black_opal_max_spawn_height_end = black_opal_max_spawn_height_end;
		
	}
	
	public static void encode(PacketSyncConfig msg, FriendlyByteBuf buf) { 
		 buf.writeInt(msg.amethyst_enchant);
		 buf.writeInt(msg.black_opal_enchant);
		 buf.writeInt(msg.netherite_opal_enchant);
		
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
		 
		 buf.writeBoolean(msg.spawn_amethyst_overworld);
		 buf.writeBoolean(msg.spawn_black_opal_overworld);
		 buf.writeBoolean(msg.spawn_amethyst_nether);
		 buf.writeBoolean(msg.spawn_black_opal_nether);
		 buf.writeBoolean(msg.spawn_amethyst_end);
		 buf.writeBoolean(msg.spawn_black_opal_end);
		 
		 buf.writeInt(msg.amethyst_times_rarer);
		 buf.writeInt(msg.black_opal_times_rarer);
		 buf.writeInt(msg.amethyst_max_vein_size);
		 buf.writeInt(msg.black_opal_max_vein_size);
		 buf.writeInt(msg.amethyst_max_spawn_height_overworld);
		 buf.writeInt(msg.black_opal_max_spawn_height_overworld);
		 buf.writeInt(msg.amethyst_max_spawn_height_nether);
		 buf.writeInt(msg.black_opal_max_spawn_height_nether);
		 buf.writeInt(msg.amethyst_max_spawn_height_end);
		 buf.writeInt(msg.black_opal_max_spawn_height_end);
	}
	
	public static PacketSyncConfig decode(FriendlyByteBuf buf) {
		return new PacketSyncConfig(buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readBoolean(), buf.readBoolean(), buf.readBoolean(), buf.readBoolean(), buf.readBoolean(), buf.readBoolean(), buf.readBoolean(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt());
	}
	
	@SuppressWarnings("resource")
	public static void handle(PacketSyncConfig message, Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
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
			
				if(OADConfig.spawn_amethyst_overworld.get() != message.spawn_amethyst_overworld) {OADConfig.spawn_amethyst_overworld.set(message.spawn_amethyst_overworld); counter++;}
				if(OADConfig.spawn_amethyst_nether.get() != message.spawn_amethyst_nether) {OADConfig.spawn_amethyst_nether.set(message.spawn_amethyst_nether); counter++;}
				if(OADConfig.spawn_amethyst_end.get() != message.spawn_amethyst_end) {OADConfig.spawn_amethyst_end.set(message.spawn_amethyst_end); counter++;}
				if(OADConfig.spawn_black_opal_overworld.get() != message.spawn_black_opal_overworld) {OADConfig.spawn_black_opal_overworld.set(message.spawn_black_opal_overworld); counter++;}
				if(OADConfig.spawn_black_opal_nether.get() != message.spawn_black_opal_nether) {OADConfig.spawn_black_opal_nether.set(message.spawn_black_opal_nether); counter++;}
				if(OADConfig.spawn_black_opal_end.get() != message.spawn_black_opal_end) {OADConfig.spawn_black_opal_end.set(message.spawn_black_opal_end); counter++;}
			
				if(OADConfig.amethyst_times_rarer.get() != message.amethyst_times_rarer) {OADConfig.amethyst_times_rarer.set(message.amethyst_times_rarer); counter++;}
				if(OADConfig.black_opal_times_rarer.get() != message.black_opal_times_rarer) {OADConfig.black_opal_times_rarer.set(message.black_opal_times_rarer); counter++;}
			
				if(OADConfig.amethyst_max_vein_size.get() != message.amethyst_max_vein_size) {OADConfig.amethyst_max_vein_size.set(message.amethyst_max_vein_size); counter++;}
				if(OADConfig.black_opal_max_vein_size.get() != message.black_opal_max_vein_size) {OADConfig.black_opal_max_vein_size.set(message.black_opal_max_vein_size); counter++;}
			
				if(OADConfig.amethyst_max_spawn_height_overworld.get() != message.amethyst_max_spawn_height_overworld) {OADConfig.amethyst_max_spawn_height_overworld.set(message.amethyst_max_spawn_height_overworld); counter++;}
				if(OADConfig.black_opal_max_spawn_height_overworld.get() != message.black_opal_max_spawn_height_overworld) {OADConfig.black_opal_max_spawn_height_overworld.set(message.black_opal_max_spawn_height_overworld); counter++;}
			
				if(OADConfig.amethyst_max_spawn_height_nether.get() != message.amethyst_max_spawn_height_nether) {OADConfig.amethyst_max_spawn_height_nether.set(message.amethyst_max_spawn_height_nether); counter++;}
				if(OADConfig.black_opal_max_spawn_height_nether.get() != message.black_opal_max_spawn_height_nether) {OADConfig.black_opal_max_spawn_height_nether.set(message.black_opal_max_spawn_height_nether); counter++;}
			
				if(OADConfig.amethyst_max_spawn_height_end.get() != message.amethyst_max_spawn_height_end) {OADConfig.amethyst_max_spawn_height_end.set(message.amethyst_max_spawn_height_end); counter++;}
				if(OADConfig.black_opal_max_spawn_height_end.get() != message.black_opal_max_spawn_height_end) {OADConfig.black_opal_max_spawn_height_end.set(message.black_opal_max_spawn_height_end); counter++;}
			
				if(counter > 1) {
					TextComponent playermessage = new TextComponent("§dOres Above Diamonds: " + "§rYour config has been synced with the server. " + "§cPlease completely restart minecraft and then rejoin the server for the effects to take place. " + "§9" + counter + " settings were changed.");
					Minecraft.getInstance().player.sendMessage((Component) playermessage, null);
				}	
				if(counter == 1) {
					TextComponent playermessage = new TextComponent("§dOres Above Diamonds: " + "§rYour config has been synced with the server. " + "§cPlease completely restart minecraft and then rejoin the server for the effects to take place. " + "§9" + counter + " setting was changed.");
					Minecraft.getInstance().player.sendMessage((Component) playermessage, null);
				}
			}
		});
		ctx.get().setPacketHandled(true);
		
	}
}
