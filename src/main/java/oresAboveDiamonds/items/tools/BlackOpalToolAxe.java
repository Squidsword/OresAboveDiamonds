package oresAboveDiamonds.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import oresAboveDiamonds.Main;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.init.ModItems;
import oresAboveDiamonds.util.IHasModel;

public class BlackOpalToolAxe extends ItemAxe implements IHasModel {

	public BlackOpalToolAxe(String name, ToolMaterial material) {
		
		super(material, OADConfig.ar_black_opal_attack_damage + 5, -3f);
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
