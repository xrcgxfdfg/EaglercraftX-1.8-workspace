package eu.shoroa.contrib.render;

public class ShBlur {
	private static final ShBlur INSTANCE = new ShBlur();

	public static ShBlur getInstance() {
		return INSTANCE;
	}

	public void drawBlur(Runnable task) {
		if (task != null) {
			task.run();
		}
	}

	public void drawBlur(float x, float y, float width, float height, float radius) {
		// No-op in browser build.
	}
}
