package com.sunyjams.common.utils;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Created by James
 * on 2017/10/9.
 * description
 */
public class JsonUtils{

    /**
     * usage String json = JsonUtils.toJson(new UserInfo());
     * @param t
     * @param <T>
     * @return
     */
    public static <T> String toJson(T t) {
        String json = null;
        try {
            Gson gson = new Gson();
            json = gson.toJson(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * usage UserInfo userInfo = JsonUtils.fromJson("{'username','James'}", UserInfo.class);
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String json, Class clazz) {
        T t = null;
        try {
            Gson gson = new Gson();
            t = (T) gson.fromJson(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * List<PageElement> list = JsonUtils.fromJson(json, new TypeToken<List<PageElement>>(){}.getType());
     * @param json
     * @param typeOfT
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String json, Type typeOfT) {
        T t = null;
        try {
            Gson gson = new Gson();
            t = (T) gson.fromJson(json, typeOfT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * String str = JsonUtils.toJson(list, new TypeToken<List<PageElement>>(){}.getType());
     * @param obj
     * @param t
     * @param <T>
     * @return
     */
    public static <T> String toJson(Object obj, Type t) {
        String json = null;
        try {
            Gson gson = new Gson();
            json = gson.toJson(obj, t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
}
