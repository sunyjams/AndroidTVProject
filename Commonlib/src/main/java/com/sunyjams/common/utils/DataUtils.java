package com.sunyjams.common.utils;

/**
 * Created by James
 * on 2017/10/9.
 * description
 */

public class DataUtils {

    public final static int convertToInt(Object value, int defaultValue){
        if(null == value || "".equals(value.toString().trim())){
            return defaultValue;
        }
        try{
            return Integer.valueOf(value.toString());
        }catch (Exception e){
            try{
                return Double.valueOf(value.toString()).intValue();
            }catch (Exception e1){
                return defaultValue;
            }
        }
    }

    public static int toInt(String s){
        try {
            return Integer.valueOf(s);
        }catch (Exception e){
            return 0;
        }
    }

    public static int toInt(Integer i){
        if(null == i){
            return 0;
        }
        return i.intValue();
    }

    public static long toLong(String s){
        try {
            return Long.valueOf(s);
        }catch (Exception e){
            return 0L;
        }
    }

    public static long toLong(Long l){
        if(l == null){
            return 0L;
        }
        return l.longValue();
    }

}
