package com.sunyjams.common.utils;

import java.lang.reflect.Field;

/**
 * Created by starrysky on 14-12-26.
 */
public class ReflectUtils {

    public static Object getFieldValue(Class<?> aClass, String fieldName, Object receiver) throws Exception {

        if (aClass == null || fieldName == null || receiver == null) {
            throw new NullPointerException("参数不能为空!");
        }

        Field field = aClass.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(receiver);
    }

    public static Object getFieldValueQuietly(Class<?> aClass, String fieldName, Object receiver) {

        try {
            return getFieldValue(aClass, fieldName, receiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setFieldValue(Object object, String name, Object value) {
        setValueQuietly(findField(object.getClass(), name), object, value);
    }

    public static void setValueQuietly(Field field, Object object, Object value) {

        if (field == null) return ;

        try {
            field.set(object, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("rawtypes")
	public static Field findField(Class classz, String name) {

        if (classz == null || name == null) return null;

        try {
            Field field = classz.getDeclaredField(name);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return findField(classz.getSuperclass(), name);
    }
}
