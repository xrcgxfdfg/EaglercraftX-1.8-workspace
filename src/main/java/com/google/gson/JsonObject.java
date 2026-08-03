package com.google.gson;

public class JsonObject extends JsonElement {
    public JsonObject addProperty(String property, String value) { return this; }
    public JsonObject addProperty(String property, Number value) { return this; }
    public JsonObject addProperty(String property, Boolean value) { return this; }
    public JsonObject addProperty(String property, Character value) { return this; }
    public JsonObject addProperty(String property, int value) { return this; }
    public JsonObject addProperty(String property, long value) { return this; }
    public JsonObject addProperty(String property, double value) { return this; }
    public JsonObject addProperty(String property, float value) { return this; }
    public JsonObject add(String name, JsonElement element) { return this; }
    public boolean isJsonObject() { return true; }
    public JsonObject getAsJsonObject() { return this; }
}
