package com.chengong.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by cheng on 5/31/2017.
 */
public class JsonParser {

    private static Set<Character> skip;

    static {
        skip = new HashSet<>();
        skip.addAll(Arrays.asList(' ', '\n', '"'));
    }

    public static Json parse(BufferedReader in) throws IOException {
        int i;
        while((i = in.read()) != -1) {

        }
        return null;
    }

    private interface Json {
        String getValue();
        Map<String, Json> getObject();
        List<Json> getArray();
    }

    private static class JsonObject implements Json {
        Map<String, Json> map;
        JsonObject () {
            map = new HashMap<>();
        }

        @Override
        public String getValue() {
            return null;
        }

        @Override
        public Map<String, Json> getObject() {
            return map;
        }

        @Override
        public List<Json> getArray() {
            return null;
        }
    }

    private static class JsonArray implements Json {
        List<Json> array;
        JsonArray () {
            array = new ArrayList<>();
        }

        @Override
        public String getValue() {
            return null;
        }

        @Override
        public Map<String, Json> getObject() {
            return null;
        }

        @Override
        public List<Json> getArray() {
            return array;
        }
    }

    private static class JsonString implements Json {
        String value;
        JsonString (String value) {
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public Map<String, Json> getObject() {
            return null;
        }

        @Override
        public List<Json> getArray() {
            return null;
        }
    }
}
