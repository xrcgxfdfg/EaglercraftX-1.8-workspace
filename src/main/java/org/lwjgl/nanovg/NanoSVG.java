package org.lwjgl.nanovg;

public class NanoSVG {
	public static NSVGImage nsvgParse(CharSequence s, String units, float dpi) {
		return new NSVGImage();
	}

	public static long nsvgCreateRasterizer() {
		return 0L;
	}

	public static void nsvgRasterize(long rasterizer, NSVGImage image, float x, float y, float scale, java.nio.ByteBuffer output, int w, int h, int stride) {
	}

	public static void nsvgDeleteRasterizer(long rasterizer) {
	}

	public static void nsvgDelete(NSVGImage image) {
	}
}
