package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;

public class JsonArray extends JsonElement implements Iterable<JsonElement> {
    private final ArrayList<JsonElement> elements = new ArrayList<>();

    public JsonArray add(JsonElement element) { elements.add(element); return this; }
    public Iterator<JsonElement> iterator() { return elements.iterator(); }
    public boolean isJsonArray() { return true; }
    public JsonArray getAsJsonArray() { return this; }
}
