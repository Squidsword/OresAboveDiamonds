package oresAboveDiamonds.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import oresAboveDiamonds.Main;
import oresAboveDiamonds.config.OADConfig;

public class PacketSyncConfig implements IMessage {
	
	private int amethyst_enchant = OADConfig.am_amethyst_enchantability;
	private int black_opal_enchant = OADConfig.an_black_opal_enchantability;
	
	private int amethyst_ad = OADConfig.ao_amethyst_attack_damage;
	private int amethyst_efficiency = OADConfig.ap_amethyst_efficiency;
	private int amethyst_tool_durability = OADConfig.aq_amethyst_durability;
	
	private int black_opal_ad = OADConfig.ar_black_opal_attack_damage;
	private int black_opal_efficiency = OADConfig.as_black_opal_efficiency;
	private int black_opal_tool_durability = OADConfig.at_black_opal_durability;
	
	private int amethyst_toughness = OADConfig.au_amethyst_toughness;
	private int black_opal_toughness = OADConfig.av_black_opal_toughness;
	
	private int amethyst_armor_durability = OADConfig.aw_amethyst_armor_durability;
	private int black_opal_armor_durability = OADConfig.ax_black_opal_armor_durability;
	
	private int amethyst_helmet_armor = OADConfig.ay_amethyst_helmet_armor;
	private int amethyst_chestplate_armor = OADConfig.az_amethyst_chestplate_armor;
	private int amethyst_leggings_armor = OADConfig.ba_amethyst_leggings_armor;
	private int amethyst_boots_armor = OADConfig.bb_amethyst_boots_armor;
	
	private int black_opal_helmet_armor = OADConfig.bc_black_opal_helmet_armor;
	private int black_opal_chestplate_armor = OADConfig.bd_black_opal_chestplate_armor;
	private int black_opal_leggings_armor = OADConfig.be_black_opal_leggings_armor;
	private int black_opal_boots_armor = OADConfig.bf_black_opal_boots_armor;
	
	private int configValue;
	
	@Override
	public void fromBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		configValue = buf.readInt();
		
		 amethyst_enchant = buf.readInt();
		 black_opal_enchant = buf.readInt();
		
		 amethyst_ad = buf.readInt();
		 amethyst_efficiency = buf.readInt();
		 amethyst_tool_durability = buf.readInt();
		
		 black_opal_ad = buf.readInt();
		 black_opal_efficiency = buf.readInt();
		 black_opal_tool_durability = buf.readInt();
		
		 amethyst_toughness = buf.readInt();
		 black_opal_toughness = buf.readInt();
		
		 amethyst_armor_durability = buf.readInt();
		 black_opal_armor_durability = buf.readInt();
		
		 amethyst_helmet_armor = buf.readInt();
		 amethyst_chestplate_armor = buf.readInt();
		 amethyst_leggings_armor = buf.readInt();
		 amethyst_boots_armor = buf.readInt();
		
		 black_opal_helmet_armor = buf.readInt();
		 black_opal_chestplate_armor = buf.readInt();
		 black_opal_leggings_armor = buf.readInt();
		 black_opal_boots_armor = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		buf.writeInt(configValue);
		
		 buf.writeInt(amethyst_enchant);
		 buf.writeInt(black_opal_enchant);
		
		 buf.writeInt(amethyst_ad);
		 buf.writeInt(amethyst_efficiency);
		 buf.writeInt(amethyst_tool_durability);
		
		 buf.writeInt(black_opal_ad);
		 buf.writeInt(black_opal_efficiency);
		 buf.writeInt(black_opal_tool_durability);
		
		 buf.writeInt(amethyst_toughness);
		 buf.writeInt(black_opal_toughness);
		
		 buf.writeInt(amethyst_armor_durability);
		 buf.writeInt(black_opal_armor_durability);
		
		 buf.writeInt(amethyst_helmet_armor);
		 buf.writeInt(amethyst_chestplate_armor);
		 buf.writeInt(amethyst_leggings_armor);
		 buf.writeInt(amethyst_boots_armor);
		
		 buf.writeInt(black_opal_helmet_armor);
		 buf.writeInt(black_opal_chestplate_armor);
		 buf.writeInt(black_opal_leggings_armor);
		 buf.writeInt(black_opal_boots_armor);
	}
	
	public PacketSyncConfig() {
		
	}
	
	public static class Handler implements IMessageHandler<PacketSyncConfig, IMessage> {

		@Override
		public IMessage onMessage(PacketSyncConfig message, MessageContext ctx) {
			Main.proxy.addScheduledTaskClient(() -> handle(message, ctx));
			return null;
		}
		private void handle(PacketSyncConfig message, MessageContext ctx) {
			int counter = 0;
			if(Minecraft.getMinecraft().isSingleplayer() == false && OADConfig.abe_enable_server_config_sync == true) {
			
				if(OADConfig.am_amethyst_enchantability != message.amethyst_enchant) {OADConfig.am_amethyst_enchantability = message.amethyst_enchant; counter++;}
				if(OADConfig.an_black_opal_enchantability != message.black_opal_enchant) {OADConfig.an_black_opal_enchantability = message.black_opal_enchant; counter++;}
				if(OADConfig.ao_amethyst_attack_damage != message.amethyst_ad) {OADConfig.ao_amethyst_attack_damage = message.amethyst_ad; counter++;}
				if(OADConfig.ap_amethyst_efficiency != message.amethyst_efficiency) {OADConfig.ap_amethyst_efficiency = message.amethyst_efficiency; counter++;}
				if(OADConfig.aq_amethyst_durability != message.amethyst_tool_durability) {OADConfig.aq_amethyst_durability = message.amethyst_tool_durability; counter++;}
				if(OADConfig.ar_black_opal_attack_damage != message.black_opal_ad) {OADConfig.ar_black_opal_attack_damage = message.black_opal_ad; counter++;}
				if(OADConfig.as_black_opal_efficiency != message.black_opal_efficiency) {OADConfig.as_black_opal_efficiency = message.black_opal_efficiency; counter++;}
				if(OADConfig.at_black_opal_durability != message.black_opal_tool_durability) {OADConfig.at_black_opal_durability = message.black_opal_tool_durability; counter++;}
				if(OADConfig.au_amethyst_toughness != message.amethyst_toughness) {OADConfig.au_amethyst_toughness = message.amethyst_toughness; counter++;}
				if(OADConfig.av_black_opal_toughness != message.black_opal_toughness) {OADConfig.av_black_opal_toughness = message.black_opal_toughness; counter++;}
				if(OADConfig.ay_amethyst_helmet_armor != message.amethyst_helmet_armor) {OADConfig.ay_amethyst_helmet_armor = message.amethyst_helmet_armor; counter++;}
				if(OADConfig.az_amethyst_chestplate_armor != message.amethyst_chestplate_armor) {OADConfig.az_amethyst_chestplate_armor = message.amethyst_chestplate_armor; counter++;}
				if(OADConfig.ba_amethyst_leggings_armor != message.amethyst_leggings_armor) {OADConfig.ba_amethyst_leggings_armor = message.amethyst_leggings_armor; counter++;}
				if(OADConfig.bb_amethyst_boots_armor != message.amethyst_boots_armor) {OADConfig.bb_amethyst_boots_armor = message.amethyst_boots_armor; counter++;}
				if(OADConfig.bc_black_opal_helmet_armor != message.black_opal_helmet_armor) {OADConfig.bc_black_opal_helmet_armor = message.black_opal_helmet_armor; counter++;}
				if(OADConfig.bd_black_opal_chestplate_armor != message.black_opal_chestplate_armor) {OADConfig.bd_black_opal_chestplate_armor = message.black_opal_chestplate_armor; counter++;}
				if(OADConfig.be_black_opal_leggings_armor != message.black_opal_leggings_armor) {OADConfig.be_black_opal_leggings_armor = message.black_opal_leggings_armor; counter++;}
				if(OADConfig.bf_black_opal_boots_armor != message.black_opal_boots_armor) {OADConfig.bf_black_opal_boots_armor = message.black_opal_boots_armor; counter++;}
				
				ConfigManager.sync("oresabovediamonds", Config.Type.INSTANCE);	
			
				
				if(counter > 1) {
				ITextComponent playermessage = new TextComponentString("§dOres Above Diamonds: " + "§rYour config has been synced with the server. " + "§cPlease completely restart minecraft and then rejoin the server for the effects to take place. " + "§9" + counter + " settings were changed.");
				Minecraft.getMinecraft().player.sendMessage(playermessage);
				}
				if(counter == 1) {
					ITextComponent playermessage = new TextComponentString("§dOres Above Diamonds: " + "§rYour config has been synced with the server. " + "§cPlease completely restart minecraft and then rejoin the server for the effects to take place. " + "§9" + counter + " setting was changed.");
					Minecraft.getMinecraft().player.sendMessage(playermessage);
				}
			}
		}
	}
	
}
