package org.lwjgl.nanovg;

public class NVGColor {
	public float r;
	public float g;
	public float b;
	public float a;

	public static NVGColor create() {
		return new NVGColor();
	}

	public static void nvgRGBA(byte r, byte g, byte b, byte a, NVGColor out) {
		out.r = r & 0xFF;
		out.g = g & 0xFF;
		out.b = b & 0xFF;
		out.a = a & 0xFF;
	}
}
