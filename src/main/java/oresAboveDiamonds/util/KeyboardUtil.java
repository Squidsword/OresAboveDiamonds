package oresAboveDiamonds.util;

import org.lwjgl.glfw.GLFW;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class KeyboardUtil {
	private static final long MINECRAFT_WINDOW = Minecraft.getInstance().getWindow().getWindow();
	
	@OnlyIn(Dist.CLIENT)
	public static boolean isHoldingShift() {
		return InputConstants.isKeyDown(MINECRAFT_WINDOW, GLFW.GLFW_KEY_LEFT_SHIFT);
	}
}
