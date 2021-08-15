package oresAboveDiamonds.lists;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;

public final class MaterialTags {
    public static final Tag.Named<Block> NEEDS_AMETHYST_TOOL = BlockTags.createOptional(new ResourceLocation("oresabovediamonds:needs_amethyst_tool"));
    public static final Tag.Named<Block> NEEDS_BLACK_OPAL_TOOL = BlockTags.createOptional(new ResourceLocation("oresabovediamonds:needs_black_opal_tool"));
    public static final Tag.Named<Block> NEEDS_NETHERITE_OPAL_TOOL = BlockTags.createOptional(new ResourceLocation("oresabovediamonds:needs_netherite_opal_tool"));

}
