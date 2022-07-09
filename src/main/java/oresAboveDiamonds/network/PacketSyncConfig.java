package oresAboveDiamonds.network;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.network.NetworkEvent;
import oresAboveDiamonds.config.OADConfig;

import java.util.function.Supplier;

public class PacketSyncConfig {

	private double amethyst_times_rarer;
	private double black_opal_times_rarer;

	private int amethyst_vein_size;
	private int black_opal_vein_size;

	private double overworld_discard_chance_on_air_exposure;
	private double nether_discard_chance_on_air_exposure;
	private double end_discard_chance_on_air_exposure;

	private int amethyst_max_spawn_height_overworld;
	private int black_opal_max_spawn_height_overworld;

	private int amethyst_max_spawn_height_nether;
	private int black_opal_max_spawn_height_nether;

	private int amethyst_max_spawn_height_end;
	private int black_opal_max_spawn_height_end;

	private int amethyst_armor_toughness;
	private int black_opal_armor_toughness;
	private int netherite_opal_armor_toughness;

	private int amethyst_armor_knockback_resistance;
	private int black_opal_armor_knockback_resistance;
	private int netherite_opal_armor_knockback_resistance;

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

	private int amethyst_attack_damage;
	private int amethyst_efficiency;
	private int amethyst_durability;

	private int black_opal_attack_damage;
	private int black_opal_efficiency;
	private int black_opal_durability;

	private int netherite_opal_attack_damage;
	private int netherite_opal_efficiency;
	private int netherite_opal_durability;

	private int amethyst_enchantability;
	private int black_opal_enchantability;
	private int netherite_opal_enchantability;

	private double nether_chance_multiplier;
	private double end_chance_multiplier;
	private double nether_vein_multiplier;
	private double end_vein_multiplier;

	private boolean spawn_amethyst_overworld;
	private boolean spawn_black_opal_overworld;
	private boolean spawn_amethyst_nether;
	private boolean spawn_black_opal_nether;
	private boolean spawn_amethyst_end;
	private boolean spawn_black_opal_end;

	private boolean old_combat_mechanics;
	private boolean ores_above_netherite;
	private boolean chest_loot;


	public PacketSyncConfig() {

	}

	public PacketSyncConfig(double amethyst_times_rarer,
	double black_opal_times_rarer,

	int amethyst_vein_size,
	int black_opal_vein_size,

	double overworld_discard_chance_on_air_exposure,
	double nether_discard_chance_on_air_exposure,
	double end_discard_chance_on_air_exposure,

	int amethyst_max_spawn_height_overworld,
	int black_opal_max_spawn_height_overworld,

	int amethyst_max_spawn_height_nether,
	int black_opal_max_spawn_height_nether,

	int amethyst_max_spawn_height_end,
	int black_opal_max_spawn_height_end,

	int amethyst_armor_toughness,
	int black_opal_armor_toughness,
	int netherite_opal_armor_toughness,

	int amethyst_armor_knockback_resistance,
	int black_opal_armor_knockback_resistance,
	int netherite_opal_armor_knockback_resistance,

	int amethyst_armor_durability,
	int black_opal_armor_durability,
	int netherite_opal_armor_durability,

	int amethyst_helmet_armor,
	int amethyst_chestplate_armor,
	int amethyst_leggings_armor,
	int amethyst_boots_armor,

	int black_opal_helmet_armor,
	int black_opal_chestplate_armor,
	int black_opal_leggings_armor,
	int black_opal_boots_armor,

	int netherite_opal_helmet_armor,
	int netherite_opal_chestplate_armor,
	int netherite_opal_leggings_armor,
	int netherite_opal_boots_armor,

	int amethyst_attack_damage,
	int amethyst_efficiency,
	int amethyst_durability,

	int black_opal_attack_damage,
	int black_opal_efficiency,
	int black_opal_durability,

	int netherite_opal_attack_damage,
	int netherite_opal_efficiency,
	int netherite_opal_durability,

	int amethyst_enchantability,
	int black_opal_enchantability,
	int netherite_opal_enchantability,

	double nether_chance_multiplier,
	double end_chance_multiplier,
	double nether_vein_multiplier,
	double end_vein_multiplier,

	boolean spawn_amethyst_overworld,
	boolean spawn_black_opal_overworld,
	boolean spawn_amethyst_nether,
	boolean spawn_black_opal_nether,
	boolean spawn_amethyst_end,
	boolean spawn_black_opal_end,

	boolean old_combat_mechanics,
	boolean chest_loot) {

		this.amethyst_enchantability = amethyst_enchantability;
		this.black_opal_enchantability = black_opal_enchantability;
		this.netherite_opal_enchantability = netherite_opal_enchantability;

		this.amethyst_attack_damage = amethyst_attack_damage;
		this.amethyst_efficiency = amethyst_efficiency;
		this.amethyst_durability = amethyst_durability;

		this.black_opal_attack_damage = black_opal_attack_damage;
		this.black_opal_efficiency = black_opal_efficiency;
		this.black_opal_durability = black_opal_durability;

		this.netherite_opal_attack_damage = netherite_opal_attack_damage;
		this.netherite_opal_efficiency = netherite_opal_efficiency;
		this.netherite_opal_durability = netherite_opal_durability;

		this.amethyst_armor_toughness = amethyst_armor_toughness;
		this.amethyst_armor_knockback_resistance = amethyst_armor_knockback_resistance;
		this.amethyst_armor_durability = amethyst_armor_durability;
		this.amethyst_helmet_armor = amethyst_helmet_armor;
		this.amethyst_chestplate_armor = amethyst_chestplate_armor;
		this.amethyst_leggings_armor = amethyst_leggings_armor;
		this.amethyst_boots_armor = amethyst_boots_armor;

		this.black_opal_armor_toughness = black_opal_armor_toughness;
		this.black_opal_armor_knockback_resistance = black_opal_armor_knockback_resistance;
		this.black_opal_armor_durability = black_opal_armor_durability;
		this.black_opal_helmet_armor = black_opal_helmet_armor;
		this.black_opal_chestplate_armor = black_opal_chestplate_armor;
		this.black_opal_leggings_armor = black_opal_leggings_armor;
		this.black_opal_boots_armor = black_opal_boots_armor;

		this.netherite_opal_armor_toughness = netherite_opal_armor_toughness;
		this.netherite_opal_armor_knockback_resistance = netherite_opal_armor_knockback_resistance;
		this.netherite_opal_armor_durability = netherite_opal_armor_durability;
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

		this.amethyst_vein_size = amethyst_vein_size;
		this.black_opal_vein_size = black_opal_vein_size;

		this.nether_chance_multiplier = nether_chance_multiplier;
		this.nether_vein_multiplier = nether_vein_multiplier;
		this.end_chance_multiplier = end_chance_multiplier;
		this.end_vein_multiplier = end_vein_multiplier;

		this.overworld_discard_chance_on_air_exposure = overworld_discard_chance_on_air_exposure;
		this.nether_discard_chance_on_air_exposure = nether_discard_chance_on_air_exposure;
		this.end_discard_chance_on_air_exposure = end_discard_chance_on_air_exposure;

		this.amethyst_max_spawn_height_overworld = amethyst_max_spawn_height_overworld;
		this.black_opal_max_spawn_height_overworld = black_opal_max_spawn_height_overworld;

		this.amethyst_max_spawn_height_nether = amethyst_max_spawn_height_nether;
		this.black_opal_max_spawn_height_nether = black_opal_max_spawn_height_nether;

		this.amethyst_max_spawn_height_end = amethyst_max_spawn_height_end;
		this.black_opal_max_spawn_height_end = black_opal_max_spawn_height_end;

		this.chest_loot = chest_loot;
	}

	public static void encode(PacketSyncConfig msg, FriendlyByteBuf buf) {
		buf.writeDouble(msg.amethyst_times_rarer);
		buf.writeDouble(msg.black_opal_times_rarer);

		buf.writeInt(msg.amethyst_vein_size);
		buf.writeInt(msg.black_opal_vein_size);

		buf.writeDouble(msg.overworld_discard_chance_on_air_exposure);
		buf.writeDouble(msg.nether_discard_chance_on_air_exposure);
		buf.writeDouble(msg.end_discard_chance_on_air_exposure);

		buf.writeInt(msg.amethyst_max_spawn_height_overworld);
		buf.writeInt(msg.black_opal_max_spawn_height_overworld);

		buf.writeInt(msg.amethyst_max_spawn_height_nether);
		buf.writeInt(msg.black_opal_max_spawn_height_nether);

		buf.writeInt(msg.amethyst_max_spawn_height_end);
		buf.writeInt(msg.black_opal_max_spawn_height_end);

		buf.writeInt(msg.amethyst_armor_toughness);
		buf.writeInt(msg.black_opal_armor_toughness);
		buf.writeInt(msg.netherite_opal_armor_toughness);

		buf.writeInt(msg.amethyst_armor_knockback_resistance);
		buf.writeInt(msg.black_opal_armor_knockback_resistance);
		buf.writeInt(msg.netherite_opal_armor_knockback_resistance);

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

		buf.writeInt(msg.amethyst_attack_damage);
		buf.writeInt(msg.amethyst_efficiency);
		buf.writeInt(msg.amethyst_durability);

		buf.writeInt(msg.black_opal_attack_damage);
		buf.writeInt(msg.black_opal_efficiency);
		buf.writeInt(msg.black_opal_durability);

		buf.writeInt(msg.netherite_opal_attack_damage);
		buf.writeInt(msg.netherite_opal_efficiency);
		buf.writeInt(msg.netherite_opal_durability);

		buf.writeInt(msg.amethyst_enchantability);
		buf.writeInt(msg.black_opal_enchantability);
		buf.writeInt(msg.netherite_opal_enchantability);

		buf.writeDouble(msg.nether_chance_multiplier);
		buf.writeDouble(msg.end_chance_multiplier);
		buf.writeDouble(msg.nether_vein_multiplier);
		buf.writeDouble(msg.end_vein_multiplier);

		buf.writeBoolean(msg.spawn_amethyst_overworld);
		buf.writeBoolean(msg.spawn_black_opal_overworld);
		buf.writeBoolean(msg.spawn_amethyst_nether);
		buf.writeBoolean(msg.spawn_black_opal_nether);
		buf.writeBoolean(msg.spawn_amethyst_end);
		buf.writeBoolean(msg.spawn_black_opal_end);

		buf.writeBoolean(msg.old_combat_mechanics);
		buf.writeBoolean(msg.ores_above_netherite);
		buf.writeBoolean(msg.chest_loot);
	}
	
	public static PacketSyncConfig decode(FriendlyByteBuf buf) {
		return new PacketSyncConfig(buf.readDouble(),
		buf.readDouble(),

		buf.readInt(),
		buf.readInt(),

		buf.readDouble(),
		buf.readDouble(),
		buf.readDouble(),

		buf.readInt(),
		buf.readInt(),

		buf.readInt(),
		buf.readInt(),

		buf.readInt(),
		buf.readInt(),

		buf.readInt(),
		buf.readInt(),
		buf.readInt(),

		buf.readInt(),
		buf.readInt(),
		buf.readInt(),

		buf.readInt(),
		buf.readInt(),
		buf.readInt(),

		buf.readInt(),
		buf.readInt(),
		buf.readInt(),
		buf.readInt(),

		buf.readInt(),
		buf.readInt(),
		buf.readInt(),
		buf.readInt(),

		buf.readInt(),
		buf.readInt(),
		buf.readInt(),
		buf.readInt(),

		buf.readInt(),
		buf.readInt(),
		buf.readInt(),

		buf.readInt(),
		buf.readInt(),
		buf.readInt(),

		buf.readInt(),
		buf.readInt(),
		buf.readInt(),

		buf.readInt(),
		buf.readInt(),
		buf.readInt(),

		buf.readDouble(),
		buf.readDouble(),
		buf.readDouble(),
		buf.readDouble(),

		buf.readBoolean(),
		buf.readBoolean(),
		buf.readBoolean(),
		buf.readBoolean(),
		buf.readBoolean(),
		buf.readBoolean(),

		buf.readBoolean(),
		buf.readBoolean());
	}

	public static int counter = 0;

	@SuppressWarnings("resource")
	public static void handle(PacketSyncConfig msg, Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {

			counter = 0;

			if(OADConfig.enable_server_config_sync.get() == true) {

				update(OADConfig.amethyst_times_rarer, msg.amethyst_times_rarer);
				update(OADConfig.black_opal_times_rarer, msg.black_opal_times_rarer);

				update(OADConfig.amethyst_vein_size, msg.amethyst_vein_size);
				update(OADConfig.black_opal_vein_size, msg.black_opal_vein_size);

				update(OADConfig.overworld_discard_chance_on_air_exposure, msg.overworld_discard_chance_on_air_exposure);
				update(OADConfig.nether_discard_chance_on_air_exposure, msg.nether_discard_chance_on_air_exposure);
				update(OADConfig.end_discard_chance_on_air_exposure, msg.end_discard_chance_on_air_exposure);

				update(OADConfig.amethyst_max_spawn_height_overworld, msg.amethyst_max_spawn_height_overworld);
				update(OADConfig.black_opal_max_spawn_height_overworld, msg.black_opal_max_spawn_height_overworld);

				update(OADConfig.amethyst_max_spawn_height_nether, msg.amethyst_max_spawn_height_nether);
				update(OADConfig.black_opal_max_spawn_height_nether, msg.black_opal_max_spawn_height_nether);

				update(OADConfig.amethyst_max_spawn_height_end, msg.amethyst_max_spawn_height_end);
				update(OADConfig.black_opal_max_spawn_height_end, msg.black_opal_max_spawn_height_end);

				update(OADConfig.amethyst_armor_toughness, msg.amethyst_armor_toughness);
				update(OADConfig.black_opal_armor_toughness, msg.black_opal_armor_toughness);
				update(OADConfig.netherite_opal_armor_toughness, msg.netherite_opal_armor_toughness);

				update(OADConfig.amethyst_armor_knockback_resistance, msg.amethyst_armor_knockback_resistance);
				update(OADConfig.black_opal_armor_knockback_resistance, msg.black_opal_armor_knockback_resistance);
				update(OADConfig.netherite_opal_armor_knockback_resistance, msg.netherite_opal_armor_knockback_resistance);

				update(OADConfig.amethyst_armor_durability, msg.amethyst_armor_durability);
				update(OADConfig.black_opal_armor_durability, msg.black_opal_armor_durability);
				update(OADConfig.netherite_opal_armor_durability, msg.netherite_opal_armor_durability);

				update(OADConfig.amethyst_helmet_armor, msg.amethyst_helmet_armor);
				update(OADConfig.amethyst_chestplate_armor, msg.amethyst_chestplate_armor);
				update(OADConfig.amethyst_leggings_armor, msg.amethyst_leggings_armor);
				update(OADConfig.amethyst_boots_armor, msg.amethyst_boots_armor);

				update(OADConfig.black_opal_helmet_armor, msg.black_opal_helmet_armor);
				update(OADConfig.black_opal_chestplate_armor, msg.black_opal_chestplate_armor);
				update(OADConfig.black_opal_leggings_armor, msg.black_opal_leggings_armor);
				update(OADConfig.black_opal_boots_armor, msg.black_opal_boots_armor);

				update(OADConfig.netherite_opal_helmet_armor, msg.netherite_opal_helmet_armor);
				update(OADConfig.netherite_opal_chestplate_armor, msg.netherite_opal_chestplate_armor);
				update(OADConfig.netherite_opal_leggings_armor, msg.netherite_opal_leggings_armor);
				update(OADConfig.netherite_opal_boots_armor, msg.netherite_opal_boots_armor);

				update(OADConfig.amethyst_attack_damage, msg.amethyst_attack_damage);
				update(OADConfig.amethyst_efficiency, msg.amethyst_efficiency);
				update(OADConfig.amethyst_durability, msg.amethyst_durability);

				update(OADConfig.black_opal_attack_damage, msg.black_opal_attack_damage);
				update(OADConfig.black_opal_efficiency, msg.black_opal_efficiency);
				update(OADConfig.black_opal_durability, msg.black_opal_durability);

				update(OADConfig.netherite_opal_attack_damage, msg.netherite_opal_attack_damage);
				update(OADConfig.netherite_opal_efficiency, msg.netherite_opal_efficiency);
				update(OADConfig.netherite_opal_durability, msg.netherite_opal_durability);

				update(OADConfig.amethyst_enchantability, msg.amethyst_enchantability);
				update(OADConfig.black_opal_enchantability, msg.black_opal_enchantability);
				update(OADConfig.netherite_opal_enchantability, msg.netherite_opal_enchantability);

				update(OADConfig.nether_chance_multiplier, msg.nether_chance_multiplier);
				update(OADConfig.end_chance_multiplier, msg.end_chance_multiplier);
				update(OADConfig.nether_vein_multiplier, msg.nether_vein_multiplier);
				update(OADConfig.end_vein_multiplier, msg.end_chance_multiplier);

				update(OADConfig.spawn_amethyst_overworld, msg.spawn_amethyst_overworld);
				update(OADConfig.spawn_black_opal_overworld, msg.spawn_black_opal_overworld);
				update(OADConfig.spawn_amethyst_nether, msg.spawn_amethyst_nether);
				update(OADConfig.spawn_black_opal_nether, msg.spawn_black_opal_nether);
				update(OADConfig.spawn_amethyst_end, msg.spawn_amethyst_end);
				update(OADConfig.spawn_black_opal_end, msg.spawn_black_opal_end);

				update(OADConfig.old_combat_mechanics, msg.old_combat_mechanics);
				update(OADConfig.chest_loot, msg.chest_loot);
			
				if(counter > 1) {
					Component playerMessage = Component.literal("§dOres Above Diamonds: " + "§rYour config has been synced with the server. " + "§cPlease completely restart minecraft and then rejoin the server for the effects to take place. " + "§9" + counter + " settings were changed.");
					Minecraft.getInstance().player.sendSystemMessage(playerMessage);
				}	
				if(counter == 1) {
					Component playerMessage = Component.literal("§dOres Above Diamonds: " + "§rYour config has been synced with the server. " + "§cPlease completely restart minecraft and then rejoin the server for the effects to take place. " + "§9" + counter + " setting was changed.");
					Minecraft.getInstance().player.sendSystemMessage(playerMessage);
				}
			}
		});
		ctx.get().setPacketHandled(true);
		
	}

	public static boolean update(ForgeConfigSpec.IntValue cfg, int msg) {
		if (cfg.get() == msg)  {
			return false;
		}
		cfg.set(msg);
		System.out.println(cfg.toString() + " " + msg);
		counter++;
		return true;
	}
	public static boolean update(ForgeConfigSpec.DoubleValue cfg, double msg) {
		if (Math.abs(cfg.get() - msg) < 0.00001)  {
			return false;
		}
		cfg.set(msg);
		counter++;
		System.out.println(cfg.toString() + " " + msg);
		return true;
	}

	public static boolean update(ForgeConfigSpec.BooleanValue cfg, boolean msg) {
		if (cfg.get() == msg) {
			return false;
		}
		cfg.set(msg);
		System.out.println(cfg.toString() + " " + msg);
		counter++;
		return true;
	}
}
