package com.google.gson;

public class JsonPrimitive extends JsonElement {
    private final Object value;

    public JsonPrimitive(Object value) {
        this.value = value;
    }

    @Override
    public boolean isJsonPrimitive() { return true; }

    public boolean isString() { return value instanceof String; }
    public boolean isNumber() { return value instanceof Number; }
    public boolean isBoolean() { return value instanceof Boolean; }
    public String getAsString() { return String.valueOf(value); }
    public Number getAsNumber() { return (Number) value; }
    public boolean getAsBoolean() { return Boolean.parseBoolean(String.valueOf(value)); }
}
