package oresAboveDiamonds.lists;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class MaterialTags {
    public static final TagKey<Block> NEEDS_AMETHYST_TOOL = TagKey.create(Registries.BLOCK, new ResourceLocation("oresabovediamonds:needs_amethyst_tool"));
    public static final TagKey<Block> NEEDS_BLACK_OPAL_TOOL = TagKey.create(Registries.BLOCK, new ResourceLocation("oresabovediamonds:needs_black_opal_tool"));
    public static final TagKey<Block> NEEDS_NETHERITE_OPAL_TOOL = TagKey.create(Registries.BLOCK, new ResourceLocation("oresabovediamonds:needs_netherite_opal_tool"));

}
