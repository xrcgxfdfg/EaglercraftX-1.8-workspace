package org.apache.logging.log4j;

public class LogManager {
    public static Logger getLogger(String name) {
        return new Logger() {};
    }

    public static Logger getLogger(Class<?> clazz) {
        return new Logger() {};
    }
}
