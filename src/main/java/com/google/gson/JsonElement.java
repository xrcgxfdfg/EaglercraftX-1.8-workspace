package com.google.gson;

public class JsonElement {
    public boolean isJsonPrimitive() { return false; }
    public boolean isJsonArray() { return false; }
    public boolean isJsonObject() { return false; }
    public JsonPrimitive getAsJsonPrimitive() { return null; }
    public JsonArray getAsJsonArray() { return null; }
    public JsonObject getAsJsonObject() { return null; }
}
