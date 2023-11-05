package com.shucai.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class JsonUtils {

    public static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 将对象转成json
     * @param data
     * @return
     */
    public static String object2Json(Object data) {
        try {
            String value = MAPPER.writeValueAsString(data);
            return value;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * json转为对象
     * @param jsonData
     * @param beanType
     * @return
     * @param <T>
     */
    public static <T> T json2Pojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (IOException e) {
           e.printStackTrace();
        }
        return null;
    }

    /**
     * json转为pojo对象list
     * @param jsonData
     * @param beanType
     * @return
     * @param <T>
     */
    public static <T>List<T> json2List(String jsonData, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);

        try {
            List<T> list = MAPPER.readValue(jsonData, javaType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
