package oresAboveDiamonds.blocks;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import oresAboveDiamonds.init.ModItems;

public class Amethyst_Ore_Settings extends BlockBase {

	public Amethyst_Ore_Settings(String name, Material material) {
		
		super(name, material);
		
		setSoundType(SoundType.METAL);
		setHardness(10f);
		setResistance(20f);
		setHarvestLevel("pickaxe", 3);
		
	}
	
	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune)
    {
        return 20;
    }

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModItems.AMETHYST;
	}
	
	@Override
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), random, fortune))
        {
            int i = random.nextInt(fortune + 2) - 1;

            if (i < 0)
            {
                i = 0;
            }

            return this.quantityDropped(random) * (i + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }
}
