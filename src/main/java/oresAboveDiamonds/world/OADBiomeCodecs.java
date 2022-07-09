package oresAboveDiamonds.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import oresAboveDiamonds.OresAboveDiamonds;

// Reference: Easy Steel by kwpugh
public class OADBiomeCodecs {
    public static DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, OresAboveDiamonds.MODID);

    public static RegistryObject<Codec<OADBiomeModifier>> OAD_CODEC = BIOME_MODIFIER_SERIALIZERS.register("oad_codec", () ->
            RecordCodecBuilder.create(builder -> builder.group(
                    Biome.LIST_CODEC.fieldOf("biomes").forGetter(OADBiomeModifier::biomes),
                    PlacedFeature.CODEC.fieldOf("feature").forGetter(OADBiomeModifier::feature)
            ).apply(builder, OADBiomeModifier::new)));
    
}
