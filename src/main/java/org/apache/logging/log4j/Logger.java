package org.apache.logging.log4j;

public interface Logger {
    default void info(String message) {
        System.out.println("[INFO] " + message);
    }

    default void warn(String message) {
        System.out.println("[WARN] " + message);
    }

    default void error(String message) {
        System.out.println("[ERROR] " + message);
    }

    default void error(String message, Throwable throwable) {
        System.out.println("[ERROR] " + message);
        if (throwable != null) {
            throwable.printStackTrace(System.out);
        }
    }

    default void debug(String message) {
        System.out.println("[DEBUG] " + message);
    }
}
