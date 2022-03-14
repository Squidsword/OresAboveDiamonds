package oresAboveDiamonds.lists;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.TierSortingRegistry;
import oresAboveDiamonds.OresAboveDiamonds;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.init.ModItems;

import javax.annotation.Nonnull;
import java.util.List;

public enum ToolMaterialList implements Tier 
{
	
	//Reference: gobber by kwpugh
	
	
	AMETHYST(OADConfig.amethyst_attack_damage.get() , OADConfig.amethyst_efficiency.get(), OADConfig.amethyst_durability.get(), 4, OADConfig.amethyst_enchantability.get(), ModItems.AMETHYST.get(), MaterialTags.NEEDS_AMETHYST_TOOL),
	BLACK_OPAL(OADConfig.black_opal_attack_damage.get(), OADConfig.black_opal_efficiency.get(), OADConfig.black_opal_durability.get(), 5, OADConfig.black_opal_enchantability.get(), ModItems.BLACK_OPAL.get(), MaterialTags.NEEDS_BLACK_OPAL_TOOL),
	NETHERITE_OPAL(OADConfig.netherite_opal_attack_damage.get(), OADConfig.netherite_opal_efficiency.get(), OADConfig.netherite_opal_durability.get(), 5, OADConfig.netherite_opal_enchantability.get(), ModItems.BLACK_OPAL.get(), MaterialTags.NEEDS_NETHERITE_OPAL_TOOL);
	
    public static Tier AMETHYST_TIER;
    public static Tier BLACK_OPAL_TIER;
    public static Tier NETHERITE_OPAL_TIER;
    
    static {
        ResourceLocation diamond = new ResourceLocation("diamond");
        ResourceLocation netherite = new ResourceLocation("netherite");
        ResourceLocation amethyst = new ResourceLocation(OresAboveDiamonds.MODID, "amethyst");
        ResourceLocation black_opal = new ResourceLocation(OresAboveDiamonds.MODID, "black_opal");
        ResourceLocation netherite_opal = new ResourceLocation(OresAboveDiamonds.MODID, "netherite_opal");
    	
        AMETHYST_TIER = TierSortingRegistry.registerTier(
        		AMETHYST,
                amethyst,
                List.of(diamond, netherite), List.of(black_opal));

        BLACK_OPAL_TIER = TierSortingRegistry.registerTier(
        		BLACK_OPAL,
                black_opal,
                List.of(amethyst), List.of(netherite_opal));
        
        NETHERITE_OPAL_TIER = TierSortingRegistry.registerTier(
        		NETHERITE_OPAL,
                netherite_opal,
                List.of(black_opal), List.of());
        
    }
    
	private float attackDamageBonus, efficiency;
	private int durability, harvestLevel, enchantability;
	private Item repairMaterial;
	
	private TagKey<Block> tag;
	
	private boolean infinite_durability;
	
	private ToolMaterialList(int attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Item repairMaterial, TagKey<Block> tag)
	{
		this.attackDamageBonus = attackDamage;
		this.efficiency = efficiency;
		if(durability <= 0) {
			this.durability = Integer.MAX_VALUE; 
			this.infinite_durability = true;
		} else {
			this.durability = durability;
			this.infinite_durability = false;
		}
		this.harvestLevel = harvestLevel;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial;
		this.tag = tag;
	}

	@Override
	public int getUses() 
	{
		return this.durability;
	}

	@Override
	public float getSpeed() 
	{
		return this.efficiency;
	}

	@Override
	public float getAttackDamageBonus() 
	{
		return this.attackDamageBonus;
	}

	@Override
	public int getLevel() 
	{
		return this.harvestLevel;
	}

	@Override
	public int getEnchantmentValue() 
	{
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairIngredient() 
	{
		return Ingredient.of(this.repairMaterial);
	}
	
    @Nonnull
    public TagKey<Block> getTag()
    {
        return this.tag;
    }
    
	public boolean isInfinite() {
		return this.infinite_durability;
	}

}
 