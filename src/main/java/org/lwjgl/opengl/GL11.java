package org.lwjgl.opengl;

import java.nio.FloatBuffer;

public class GL11 {
	public static final int GL_ALL_ATTRIB_BITS = 0xFFFFFFFF;
	public static final int GL_ALPHA_TEST = 0x0BC0;
	public static final int GL_COLOR_BUFFER_BIT = 0x00004000;
	public static final int GL_COLOR_CLEAR_VALUE = 0x0C22;

	public static void glPushAttrib(int mask) {}
	public static void glPopAttrib() {}
	public static void glDisable(int cap) {}
	public static void glViewport(int x, int y, int width, int height) {}
	public static void glGetFloat(int pname, FloatBuffer params) {}
	public static void glClearColor(float red, float green, float blue, float alpha) {}
	public static void glClear(int mask) {}
	public static void glColor4f(float r, float g, float b, float a) {}
	public static void glBlendFunc(int src, int dst) {}
	public static void glEnable(int cap) {}
	public static void glDisable(int cap, int something) {}
}
