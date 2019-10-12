package cn.edu.mju.util;

import javafx.util.converter.IntegerStringConverter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;

/**
 * 处理请求相关工具类
 * @author <a href="https://github.com/haidilaohotpot">cheng</a>
 * @since 1.0.0 2019/10/8
 */
public class RequestUtils {



    public static int getInt(Map<String,Object> params, String name) {

        try {
            return Integer.decode((String) params.get(name));
        } catch (Exception e) {
            return -1;
        }
    }

    public static long getLong(Map<String,Object> params, String name) {

        try {
            return Long.valueOf((String) params.get(name));
        } catch (Exception e) {
            return -1;
        }
    }

    public static Double getDouble(Map<String,Object> params, String name) {

        try {
            return Double.valueOf((String) params.get(name));
        } catch (Exception e) {
            return -1d;
        }
    }

    public static Boolean getBoolean(Map<String,Object> params, String name) {

        try {
            return Boolean.valueOf((String) params.get(name));
        } catch (Exception e) {
            return false;
        }
    }

    public static BigDecimal getBigDecimal(Map<String,Object> params, String name) {

        try {
            return BigDecimal.valueOf(Double.valueOf((String)params.get(name)));
        } catch (Exception e) {
            return null;
        }
    }

    public static String getString(Map<String,Object> params, String name) {
        try {
            String result = (String) params.get(name);
            if (result != null) {
                result = result.trim();
            }
            if ("".equals(result))
                result = null;
            return result;
        } catch (Exception e) {
            return null;
        }

    }



    public static String[] getStringList(Map<String, Object> params, String name) {


        try {
            String result = (String) params.get(name);
            String[] split = result.split(",");
            return split;
        } catch (Exception e) {
            return null;
        }

    }


}
