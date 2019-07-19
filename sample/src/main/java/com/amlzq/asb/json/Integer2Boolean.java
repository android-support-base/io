package com.amlzq.asb.json;

import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * 将int转boolean类型
 */
public class Integer2Boolean extends TypeAdapter<Boolean> {

    @Override
    public void write(JsonWriter out, Boolean value) throws IOException {
        if (value == null) {
            out.nullValue();
        } else {
            out.value(value);
        }
    }

    @Override
    public Boolean read(JsonReader in) throws IOException {
        JsonToken peek = in.peek();
        switch (peek) {
            case NUMBER:
                return in.nextInt() == 1;//如果为true则返回为int的1，false返回0.
            case NULL:
                in.nextNull();
                return null;
            case BOOLEAN:
                return in.nextBoolean();
            case STRING:
                return toBoolean(in.nextString());
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
    public static Boolean toBoolean(String name) {
//        if (TextUtils.isEmpty(name)) {
//            return 0;
//        } else {
//            if (name.equalsIgnoreCase("true")) {
//                return 1;
//            } else if (name.equalsIgnoreCase("false")) {
//                return 0;
//            } else if (name.equals("1")) {
//                return 1;
//            } else if (name.equals("0")) {
//                return 0;
//            }
//        }
        return true;
    }

}
