package oresAboveDiamonds.events;

import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.network.NetworkDirection;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.network.OADPacketHandler;
import oresAboveDiamonds.network.PacketSyncConfig;

public class PlayerLoggedInEventHandler {

    @SubscribeEvent
    public void onLoginEvent(PlayerLoggedInEvent event) {

        ServerPlayer player = (ServerPlayer) event.getEntity();

        double amethyst_times_rarer = OADConfig.amethyst_times_rarer.get();
        double black_opal_times_rarer = OADConfig.black_opal_times_rarer.get();

        int amethyst_vein_size = OADConfig.amethyst_vein_size.get();
        int black_opal_vein_size = OADConfig.black_opal_vein_size.get();

        double overworld_discard_chance_on_air_exposure = OADConfig.overworld_discard_chance_on_air_exposure.get();
        double nether_discard_chance_on_air_exposure = OADConfig.overworld_discard_chance_on_air_exposure.get();
        double end_discard_chance_on_air_exposure = OADConfig.end_discard_chance_on_air_exposure.get();

        int amethyst_max_spawn_height_overworld = OADConfig.amethyst_max_spawn_height_overworld.get();
        int black_opal_max_spawn_height_overworld = OADConfig.black_opal_max_spawn_height_overworld.get();

        int amethyst_max_spawn_height_nether = OADConfig.amethyst_max_spawn_height_nether.get();
        int black_opal_max_spawn_height_nether = OADConfig.black_opal_max_spawn_height_nether.get();

        int amethyst_max_spawn_height_end = OADConfig.amethyst_max_spawn_height_end.get();
        int black_opal_max_spawn_height_end = OADConfig.black_opal_max_spawn_height_end.get();

        int amethyst_armor_toughness = OADConfig.amethyst_armor_toughness.get();
        int black_opal_armor_toughness = OADConfig.black_opal_armor_toughness.get();
        int netherite_opal_armor_toughness = OADConfig.netherite_opal_armor_toughness.get();

        int amethyst_armor_knockback_resistance = OADConfig.amethyst_armor_knockback_resistance.get();
        int black_opal_armor_knockback_resistance = OADConfig.black_opal_armor_knockback_resistance.get();
        int netherite_opal_armor_knockback_resistance = OADConfig.netherite_opal_armor_knockback_resistance.get();

        int amethyst_armor_durability = OADConfig.amethyst_armor_durability.get();
        int black_opal_armor_durability = OADConfig.black_opal_armor_durability.get();
        int netherite_opal_armor_durability = OADConfig.netherite_opal_armor_durability.get();

        int amethyst_helmet_armor = OADConfig.amethyst_helmet_armor.get();
        int amethyst_chestplate_armor = OADConfig.amethyst_chestplate_armor.get();
        int amethyst_leggings_armor = OADConfig.amethyst_leggings_armor.get();
        int amethyst_boots_armor = OADConfig.amethyst_boots_armor.get();

        int black_opal_helmet_armor = OADConfig.black_opal_helmet_armor.get();
        int black_opal_chestplate_armor = OADConfig.black_opal_chestplate_armor.get();
        int black_opal_leggings_armor = OADConfig.black_opal_leggings_armor.get();
        int black_opal_boots_armor = OADConfig.black_opal_boots_armor.get();

        int netherite_opal_helmet_armor = OADConfig.netherite_opal_helmet_armor.get();
        int netherite_opal_chestplate_armor = OADConfig.netherite_opal_chestplate_armor.get();
        int netherite_opal_leggings_armor = OADConfig.netherite_opal_chestplate_armor.get();
        int netherite_opal_boots_armor = OADConfig.netherite_opal_boots_armor.get();

        int amethyst_attack_damage = OADConfig.amethyst_attack_damage.get();
        int amethyst_efficiency = OADConfig.amethyst_efficiency.get();
        int amethyst_durability = OADConfig.amethyst_durability.get();

        int black_opal_attack_damage = OADConfig.black_opal_attack_damage.get();
        int black_opal_efficiency = OADConfig.black_opal_efficiency.get();
        int black_opal_durability = OADConfig.black_opal_durability.get();

        int netherite_opal_attack_damage = OADConfig.netherite_opal_attack_damage.get();
        int netherite_opal_efficiency = OADConfig.netherite_opal_efficiency.get();
        int netherite_opal_durability = OADConfig.netherite_opal_durability.get();

        int amethyst_enchantability = OADConfig.amethyst_enchantability.get();
        int black_opal_enchantability = OADConfig.black_opal_enchantability.get();
        int netherite_opal_enchantability = OADConfig.netherite_opal_enchantability.get();

        double nether_chance_multiplier = OADConfig.nether_chance_multiplier.get();
        double end_chance_multiplier = OADConfig.end_chance_multiplier.get();
        double nether_vein_multiplier = OADConfig.nether_vein_multiplier.get();
        double end_vein_multiplier = OADConfig.end_vein_multiplier.get();

        boolean spawn_amethyst_overworld = OADConfig.spawn_amethyst_overworld.get();
        boolean spawn_black_opal_overworld = OADConfig.spawn_black_opal_overworld.get();
        boolean spawn_amethyst_nether = OADConfig.spawn_amethyst_nether.get();
        boolean spawn_black_opal_nether = OADConfig.spawn_black_opal_nether.get();
        boolean spawn_amethyst_end = OADConfig.spawn_amethyst_end.get();
        boolean spawn_black_opal_end = OADConfig.spawn_black_opal_end.get();

        boolean old_combat_mechanics = OADConfig.old_combat_mechanics.get();
        boolean chest_loot = OADConfig.chest_loot.get();

        PacketSyncConfig message = new PacketSyncConfig(amethyst_times_rarer,
                black_opal_times_rarer,

                amethyst_vein_size,
                black_opal_vein_size,

                overworld_discard_chance_on_air_exposure,
                nether_discard_chance_on_air_exposure,
                end_discard_chance_on_air_exposure,

                amethyst_max_spawn_height_overworld,
                black_opal_max_spawn_height_overworld,

                amethyst_max_spawn_height_nether,
                black_opal_max_spawn_height_nether,

                amethyst_max_spawn_height_end,
                black_opal_max_spawn_height_end,

                amethyst_armor_toughness,
                black_opal_armor_toughness,
                netherite_opal_armor_toughness,

                amethyst_armor_knockback_resistance,
                black_opal_armor_knockback_resistance,
                netherite_opal_armor_knockback_resistance,

                amethyst_armor_durability,
                black_opal_armor_durability,
                netherite_opal_armor_durability,

                amethyst_helmet_armor,
                amethyst_chestplate_armor,
                amethyst_leggings_armor,
                amethyst_boots_armor,

                black_opal_helmet_armor,
                black_opal_chestplate_armor,
                black_opal_leggings_armor,
                black_opal_boots_armor,

                netherite_opal_helmet_armor,
                netherite_opal_chestplate_armor,
                netherite_opal_leggings_armor,
                netherite_opal_boots_armor,

                amethyst_attack_damage,
                amethyst_efficiency,
                amethyst_durability,

                black_opal_attack_damage,
                black_opal_efficiency,
                black_opal_durability,

                netherite_opal_attack_damage,
                netherite_opal_efficiency,
                netherite_opal_durability,

                amethyst_enchantability,
                black_opal_enchantability,
                netherite_opal_enchantability,

                nether_chance_multiplier,
                end_chance_multiplier,
                nether_vein_multiplier,
                end_vein_multiplier,

                spawn_amethyst_overworld,
                spawn_black_opal_overworld,
                spawn_amethyst_nether,
                spawn_black_opal_nether,
                spawn_amethyst_end,
                spawn_black_opal_end,

                old_combat_mechanics,
                chest_loot);

        OADPacketHandler.INSTANCE.sendTo(message, player.connection.getConnection(), NetworkDirection.PLAY_TO_CLIENT);
    }
}
