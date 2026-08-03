package org.lwjgl.nanovg;

import java.nio.ByteBuffer;

public class NanoVG {
	public static final int NVG_ANTIALIAS = 1;
	public static final int NVG_IMAGE_REPEATX = 1;
	public static final int NVG_IMAGE_REPEATY = 2;
	public static final int NVG_IMAGE_GENERATE_MIPMAPS = 4;
	public static final int NVG_ALIGN_LEFT = 1;
	public static final int NVG_ALIGN_MIDDLE = 2;
	public static final int NVG_CW = 1;

	public static long nvgCreateImageRGBA(long nvg, int w, int h, int flags, ByteBuffer data) {
		return 1L;
	}

	public static void nvgDeleteImage(long nvg, long image) {}
	public static void nvgBeginFrame(long nvg, int width, int height, float scale) {}
	public static void nvgScale(long nvg, float x, float y) {}
	public static void nvgEndFrame(long nvg) {}
	public static void nvgBeginPath(long nvg) {}
	public static void nvgRect(long nvg, float x, float y, float width, float height) {}
	public static void nvgRoundedRect(long nvg, float x, float y, float width, float height, float radius) {}
	public static void nvgRoundedRectVarying(long nvg, float x, float y, float width, float height, float topLeftRadius, float topRightRadius, float bottomLeftRadius, float bottomRightRadius) {}
	public static void nvgFillColor(long nvg, NVGColor color) {}
	public static void nvgFill(long nvg) {}
	public static void nvgStrokeColor(long nvg, NVGColor color) {}
	public static void nvgStroke(long nvg) {}
	public static void nvgStrokeWidth(long nvg, float width) {}
	public static void nvgGlobalAlpha(long nvg, float alpha) {}
	public static void nvgSave(long nvg) {}
	public static void nvgRestore(long nvg) {}
	public static void nvgTranslate(long nvg, float x, float y) {}
	public static void nvgRotate(long nvg, float angle) {}
	public static void nvgCircle(long nvg, float x, float y, float radius) {}
	public static void nvgArc(long nvg, float x, float y, float radius, float startAngle, float endAngle, int dir) {}
	public static void nvgFontSize(long nvg, float size) {}
	public static void nvgFontFace(long nvg, String fontFace) {}
	public static void nvgTextAlign(long nvg, int align) {}
	public static void nvgText(long nvg, float x, float y, String text) {}
	public static void nvgTextBox(long nvg, float x, float y, float maxWidth, String text) {}
	public static void nvgTextBounds(long nvg, float x, float y, String text, float[] bounds) {}
	public static void nvgTextBoxBounds(long nvg, float x, float y, float maxWidth, String text, float[] bounds) {}
	public static void nvgFontBlur(long nvg, float blur) {}
	public static void nvgScissor(long nvg, float x, float y, float width, float height) {}
	public static void nvgImagePattern(long nvg, float x, float y, float width, float height, float angle, long image, float alpha, NVGPaint paint) {}
	public static void nvgImageSize(long nvg, long image, int[] size) {}
	public static long nvgCreateFontMem(long nvg, String name, ByteBuffer data, boolean freeData) { return 1L; }
	public static void nvgAddFallbackFont(long nvg, String font, String fallback) {}
	public static void nvgFillPaint(long nvg, NVGPaint paint) {}
	public static NVGPaint nvgLinearGradient(long nvg, float x1, float y1, float x2, float y2, NVGColor innerColor, NVGColor outerColor, NVGPaint paint) { return paint; }
	public static NVGPaint nvgImagePattern(long nvg, float x, float y, float width, float height, float angle, int image, float alpha, NVGPaint paint) { return paint; }
	public static void nvgClosePath(long nvg) {}
	public static void nvgStrokePaint(long nvg, NVGPaint paint) {}
	public static void nvgFillColor(long nvg, java.awt.Color color) {}
}
