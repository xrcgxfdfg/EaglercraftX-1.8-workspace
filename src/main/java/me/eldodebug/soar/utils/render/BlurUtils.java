package me.eldodebug.soar.utils.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.util.ResourceLocation;

public class BlurUtils {
	
	private static Minecraft mc = Minecraft.getMinecraft();
	
	private static ShaderGroup blurShader;
	private static Framebuffer buffer;
	
    private static float lastScale = 0;
    private static float lastScaleWidth = 0;
    private static float lastScaleHeight = 0;
    
    private static void reinitShader() {
		buffer = null;
		blurShader = null;
    }
    
    public static void drawBlurScreen(float radius) {
    	// TODO: Eagler hook - shader-based blur is not supported in the web/TeaVM port.
        if (mc == null) {
            return;
        }

        ScaledResolution sr = new ScaledResolution(mc);
        int factor = sr.getScaleFactor();
        int factor2 = sr.getScaledWidth();
        int factor3 = sr.getScaledHeight();
        
        if (lastScale != factor || lastScaleWidth != factor2 || lastScaleHeight != factor3) {
            reinitShader();
        }
        
        lastScale = factor;
        lastScaleWidth = factor2;
        lastScaleHeight = factor3;
        
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
    }
}
