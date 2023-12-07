package com.coderbyte.apprickmorty.utils;

import com.github.cliftonlabs.json_simple.JsonObject;

public class CadenaUtil {

    private CadenaUtil() {
        throw new IllegalStateException(CadenaUtil.class.toString());
    }

    public static String convertBodyToJson(String attributeName, Object body) {
        JsonObject json = new JsonObject();
        json.put(attributeName, body);
        return json.toString();
    }
}
