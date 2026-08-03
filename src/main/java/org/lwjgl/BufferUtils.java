package org.lwjgl;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class BufferUtils {
	public static FloatBuffer createFloatBuffer(int size) {
		return java.nio.FloatBuffer.allocate(size);
	}

	public static IntBuffer createIntBuffer(int size) {
		return java.nio.IntBuffer.allocate(size);
	}
}
