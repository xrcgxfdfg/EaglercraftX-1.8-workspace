package com.google.gson;

import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;

public class Gson {
    public <T> T fromJson(Reader reader, Class<T> clazz) {
        return null;
    }

    public <T> T fromJson(String json, Class<T> clazz) {
        return null;
    }

    public <T> T fromJson(JsonElement jsonElement, Type type) {
        return null;
    }

    public String toJson(Object src) {
        return "{}";
    }

    public void toJson(Object src, Writer writer) {
        try {
            writer.write("{}" );
        } catch (Exception ignored) {}
    }
}
