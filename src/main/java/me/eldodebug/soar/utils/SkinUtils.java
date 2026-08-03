package me.eldodebug.soar.utils;

import me.eldodebug.soar.management.mods.impl.skin3d.opengl.NativeImage;
import me.eldodebug.soar.management.mods.impl.skin3d.render.CustomizableModelPart;
import me.eldodebug.soar.management.mods.impl.skin3d.render.SolidPixelWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.util.ResourceLocation;

public class SkinUtils {
	
    public static boolean hasCustomSkin(AbstractClientPlayer player) {
        return !DefaultPlayerSkin.getDefaultSkin((player).getUniqueID()).equals((player).getLocationSkin());
    }

    private static NativeImage getSkinTexture(AbstractClientPlayer player) {
        return getTexture(player.getLocationSkin());
    }
    
    private static NativeImage getTexture(ResourceLocation resource) {
    	
        NativeImage skin = new NativeImage(64, 64, false);
        TextureManager textureManager = Minecraft.getMinecraft().getTextureManager();
        ITextureObject abstractTexture = textureManager.getTexture(resource);
        
        if(abstractTexture == null) {
        	return null;
        }
        
        GlStateManager.bindTexture(abstractTexture.getGlTextureId());
        skin.downloadTexture(0, false);
        return skin;
    }
    
    public static boolean setup3dLayers(AbstractClientPlayer abstractClientPlayerEntity, Object settings, boolean thinArms, ModelPlayer model) {
    	// TODO: Eagler hook - custom skin-layer storage is not available in this port.
        if(!hasCustomSkin(abstractClientPlayerEntity)) {
            return false;
        }
        
        NativeImage skin = getSkinTexture(abstractClientPlayerEntity);
        
        if(skin == null) {
        	return false;
        }
        
        skin.close();
        
        return false;
    }
}
