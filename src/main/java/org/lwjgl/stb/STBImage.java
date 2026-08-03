package org.lwjgl.stb;

import java.nio.ByteBuffer;

public class STBImage {
	public static ByteBuffer stbi_load_from_memory(ByteBuffer image, int[] width, int[] height, int[] channels, int desiredChannels) {
		if (width != null) width[0] = 1;
		if (height != null) height[0] = 1;
		if (channels != null) channels[0] = 4;
		return image;
	}
}
