package org.lwjgl.input;

public class Mouse {
	public static int getDWheel() {
		return net.lax1dude.eaglercraft.v1_8.Mouse.getDWheel();
	}

	public static int getX() {
		return net.lax1dude.eaglercraft.v1_8.Mouse.getX();
	}

	public static int getY() {
		return net.lax1dude.eaglercraft.v1_8.Mouse.getY();
	}

	public static boolean isButtonDown(int button) {
		return net.lax1dude.eaglercraft.v1_8.Mouse.isButtonDown(button);
	}

	public static boolean isGrabbed() {
		return net.lax1dude.eaglercraft.v1_8.Mouse.isMouseGrabbed();
	}

	public static void setGrabbed(boolean grabbed) {
		net.lax1dude.eaglercraft.v1_8.Mouse.setGrabbed(grabbed);
	}
}
