package oresAboveDiamonds.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemPickaxe;
import oresAboveDiamonds.Main;
import oresAboveDiamonds.init.ModItems;
import oresAboveDiamonds.util.IHasModel;

public class ToolPickaxe extends ItemPickaxe implements IHasModel {
	
	public ToolPickaxe(String name, ToolMaterial material) {
		
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.oresabovediamondstab);
		
		ModItems.ITEMS.add(this);
		
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	@Override
	public boolean isEnchantable(ItemStack stack)
    {
        return true;
    }
	
	@Override
	public CreativeTabs[] getCreativeTabs() {
		 return new CreativeTabs[]{Main.oresabovediamondstab, CreativeTabs.TOOLS};
	}
	
}
