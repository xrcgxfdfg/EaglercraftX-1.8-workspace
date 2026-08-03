package org.lwjgl.nanovg;

public class NVGPaint {
	public NVGColor innerColor;
	public NVGColor outerColor;

	public static NVGPaint create() {
		return new NVGPaint();
	}

	public static NVGPaint calloc() {
		return new NVGPaint();
	}

	public void innerColor(NVGColor color) {
		this.innerColor = color;
	}

	public void outerColor(NVGColor color) {
		this.outerColor = color;
	}

	public void free() {
	}
}
