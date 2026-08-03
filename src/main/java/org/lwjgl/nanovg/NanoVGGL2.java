package org.lwjgl.nanovg;

public class NanoVGGL2 {
	public static final int NVG_ANTIALIAS = 1;

	public static long nvgCreate(int flags) {
		return 1L;
	}

	public static NVGLUFramebuffer nvgluCreateFramebuffer(long nvg, int width, int height, int flags) {
		return new NVGLUFramebuffer();
	}

	public static void nvgluBindFramebuffer(long nvg, NVGLUFramebuffer framebuffer) {
	}

	public static void nvgluDeleteFramebuffer(long nvg, NVGLUFramebuffer framebuffer) {
	}

	public static int nvglCreateImageFromHandle(long nvg, int texture, int width, int height, int flags) {
		return 1;
	}
}
