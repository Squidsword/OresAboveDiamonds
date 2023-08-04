package oresAboveDiamonds.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import oresAboveDiamonds.OresAboveDiamonds;

@Mod.EventBusSubscriber(modid = OresAboveDiamonds.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItemGroups {

	public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OresAboveDiamonds.MODID);

	public static final RegistryObject<CreativeModeTab> OAD_TAB = TABS.register("tab", () -> CreativeModeTab.builder()
			.title(Component.translatable("itemGroup." + OresAboveDiamonds.MODID))
			.icon(() -> new ItemStack(ModItems.AMETHYST.get()))
			.build()
	);

	@SubscribeEvent
	public static void buildContents(final BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == OAD_TAB.getKey()) {
			ModItems.ITEMS.getEntries().stream().map(RegistryObject::get).forEach(event::accept);
		}
	}

}