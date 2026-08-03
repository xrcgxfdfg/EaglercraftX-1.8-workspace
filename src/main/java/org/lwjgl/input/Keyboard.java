package org.lwjgl.input;

import net.lax1dude.eaglercraft.v1_8.Keyboard;

public class Keyboard {
	public static final int KEY_LSHIFT = 42;
	public static final int KEY_RSHIFT = 54;
	public static final int KEY_LCONTROL = 29;
	public static final int KEY_RCONTROL = 157;
	public static final int KEY_F = 33;
	public static final int KEY_ESCAPE = 1;
	public static final int KEY_TAB = 15;
	public static final int KEY_BACK = 14;
	public static final int KEY_RETURN = 28;
	public static final int KEY_SPACE = 57;
	public static final int KEY_A = 30;
	public static final int KEY_D = 32;
	public static final int KEY_S = 31;
	public static final int KEY_W = 17;
	public static final int KEY_UP = 200;
	public static final int KEY_DOWN = 208;
	public static final int KEY_LEFT = 203;
	public static final int KEY_RIGHT = 205;

	public static boolean isKeyDown(int key) {
		return net.lax1dude.eaglercraft.v1_8.Keyboard.isKeyDown(key);
	}

	public static boolean isCreated() {
		return net.lax1dude.eaglercraft.v1_8.Keyboard.isCreated();
	}

	public static boolean next() {
		return net.lax1dude.eaglercraft.v1_8.Keyboard.next();
	}

	public static int getEventKey() {
		return 0;
	}

	public static char getEventCharacter() {
		return 0;
	}

	public static boolean getEventKeyState() {
		return false;
	}

	public static boolean isRepeatEvent() {
		return false;
	}
}
