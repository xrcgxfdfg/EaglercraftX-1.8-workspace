package me.eldodebug.soar.utils;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import me.eldodebug.soar.logger.GlideLogger;
import me.eldodebug.soar.utils.transferable.ImageTransferable;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class IOUtils {

	private static Minecraft mc = Minecraft.getMinecraft();
	
	public static void copyStringToClipboard(String s) {
		StringSelection stringSelection = new StringSelection(s);
		getToolkit().getSystemClipboard().setContents(stringSelection, null);
	}
	
	public static String getStringFromClipboard() {
		try {
			return getToolkit().getSystemClipboard().getContents(null).getTransferData(DataFlavor.stringFlavor).toString();
		} catch(Exception e) {
			return null;
		}
	}
	
	public static void copyImageToClipboard(Image image) {
		ImageTransferable imageSelection = new ImageTransferable(image);
		getToolkit().getSystemClipboard().setContents(imageSelection, null);
	}
	
	public static Image getImageFromClipboard() {
		try {
			return (Image) getToolkit().getSystemClipboard().getContents(null).getTransferData(DataFlavor.imageFlavor);
		} catch (Exception e) {
			return null;
		}
	}
	
	private static Toolkit getToolkit() {
		return Toolkit.getDefaultToolkit();
	}
	
    public static ByteBuffer resourceToByteBuffer(ResourceLocation location) {
    	
		try {
			try (InputStream inputStream = mc.getResourceManager().getResource(location).getInputStream()) {
				byte[] bytes = readAllBytes(inputStream);
				
			    ByteBuffer data = ByteBuffer.allocateDirect(bytes.length).order(ByteOrder.nativeOrder()).put(bytes);
			    ((Buffer) data).flip();
			    
			    return data;
			}
		} catch (Exception e) {
			GlideLogger.error("Failed to load resource", e);
		}
        
		return null;
    }
    
    public static ByteBuffer resourceToByteBuffer(File file) {
    	
		try {
			try (FileInputStream inputStream = new FileInputStream(file)) {
				byte[] bytes = readAllBytes(inputStream);
				
			    ByteBuffer data = ByteBuffer.allocateDirect(bytes.length).order(ByteOrder.nativeOrder()).put(bytes);
			    ((Buffer) data).flip();
			    
			    return data;
			}
		} catch (Exception e) {
			GlideLogger.error("Failed to load resource", e);
		}
        
		return null;
    }
    
    private static byte[] readAllBytes(InputStream inputStream) throws Exception {
		java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();
		byte[] buffer = new byte[4096];
		int read;
		while ((read = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, read);
		}
		return outputStream.toByteArray();
    }
}
