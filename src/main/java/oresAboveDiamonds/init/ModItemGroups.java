package oresAboveDiamonds.init;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import oresAboveDiamonds.OresAboveDiamonds;

// Reference: Advanced Netherite 1.19.3 by AutovwDev
@Mod.EventBusSubscriber(modid = OresAboveDiamonds.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItemGroups {

	@SubscribeEvent
	public static void onRegisterCreativeModeTabEvent(final CreativeModeTabEvent.Register event) {
		event.registerCreativeModeTab(new ResourceLocation(OresAboveDiamonds.MODID), builder -> {
			builder.title(Component.translatable("itemGroup." + OresAboveDiamonds.MODID))
					.icon(() -> ModItems.AMETHYST.get().getDefaultInstance())
					.displayItems((flagSet, entries) -> {
						ModItems.ITEMS.getEntries().stream().map(RegistryObject::get).forEach(entries::accept);
					});
		});
	}
}