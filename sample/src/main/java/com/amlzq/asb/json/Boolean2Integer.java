package com.amlzq.asb.json;

import android.text.TextUtils;

import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * json中的boolean字段改为int类型的1或者0
 * https://blog.csdn.net/danlyalex/article/details/79963304
 */
public class Boolean2Integer extends TypeAdapter<Integer> {

    @Override
    public void write(JsonWriter out, Integer value) throws IOException {
        if (value == null) {
            out.nullValue();
        } else {
            out.value(value);
        }
    }

    @Override
    public Integer read(JsonReader in) throws IOException {
        JsonToken peek = in.peek();
        switch (peek) {
            case BOOLEAN:
                return in.nextBoolean() ? 1 : 0;//如果为true则返回为int的1，false返回0.
            case NULL:
                in.nextNull();
                return null;
            case NUMBER:
                return in.nextInt();
            case STRING:
                return toInteger(in.nextString());
            default:
                throw new JsonParseException("Expected BOOLEAN or NUMBER but was " + peek);
        }
    }

    /**
     * true  TURE 都为true
     * "0" 为 false
     * "1" 为 true
     *
     * @param name
     * @return
     */
    public static int toInteger(String name) {
        if (TextUtils.isEmpty(name)) {
            return 0;
        } else {
            if (name.equalsIgnoreCase("true")) {
                return 1;
            } else if (name.equalsIgnoreCase("false")) {
                return 0;
            } else if (name.equals("1")) {
                return 1;
            } else if (name.equals("0")) {
                return 0;
            }
        }
        return 0;
    }

}
