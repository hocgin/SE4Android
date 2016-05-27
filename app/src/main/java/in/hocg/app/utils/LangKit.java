package in.hocg.app.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import org.json.JSONException;

import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by hocgin on 16-4-28.
 */
public class LangKit {

    /**
     * 对象判定null 返回默认值
     * @param t
     * @param def
     * @param <T>
     * @return
     */
    public static <T> T ifNull(T t, T def) {
        if (isNull(t)) {
            return def;
        }
        return t;
    }

    /**
     * 字符判定null 或 “”返回默认值
     * @param t
     * @param def
     * @return
     */
    public static String ifEmpty(String t, String def) {
        if (isEmpty(t)) {
            return def;
        }
        return t;
    }

    /**
     * 对象判定是否null
     * @param t
     * @return
     */
    public static boolean isNull(Object t) {
        return null == t;
    }

    /**
     * 字符串对象判断是否null 或 “”
     * @param t
     * @return
     */
    public static boolean isEmpty(String t) {
        return !(null != t && !"".equals(t));
    }

    /**
     * 去前后空格
     * @param str
     * @return
     */
    public static String trim(String str) {
        if (!isEmpty(str)) {
            return str.trim();
        }
        return "";
    }

    /**
     * 识别前缀
     * http://www.baidu.com => http
     * todo: 改成枚举
     * @param url
     * @return
     */
    public static String discernPrefix(String url) {
        url = trim(url);
        if (!isEmpty(url) && url.contains("://")) {
            return url.split("://")[0];
        }
        return "";
    }


    public static void main(String[] args) throws JSONException {
    }


    /**
     * 打开浏览器
     *
     * @param context
     * @param url     [含http://]
     */
    public static void openBrowser(Context context, String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(intent);
    }

    /**
     * 系统分享 文字
     * @param context
     * @param text
     */
    public static void shareText(Context context, String text) {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, String.format("%s 来自http://hocg.in.", text));
        shareIntent.setType("text/plain");

        //设置分享列表的标题，并且每次都显示分享列表
        context.startActivity(Intent.createChooser(shareIntent, "分享到"));
    }

    /**
     * 数组转成 xx,xx,xx 形式
     * @param objects
     * @return
     */
    public static String toArray(Object... objects) {
        if (isNull(objects)) {
            return "";
        }
        String str = "";
        for (Object object : objects) {
            str += String.format("%s,", object.toString());
        }
        str = str.substring(0, str.length() - 1);
        return str;
    }

    /**
     * 延迟执行某些方法
     *
     * @param task
     * @param delay
     */
    public static void taskDelay(TimerTask task, long delay) {
        new Timer().schedule(task, delay);
    }

    public static boolean equals(Object o1, Object o2) {
        return (o1 == null && o2 == null) || o1 == o2 || (o1 != null && o1.equals(o2));
    }

    /**
     * 反射字段
     *
     * @param object
     * @param filedName
     * @return
     * @throws IllegalAccessException
     */
    public static Object getFiled(Object object, String filedName) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            // 字段值
            if (equals(field.getName(), filedName)) {
                field.setAccessible(true);
                return field.get(object);
            }
        }
        return null;
    }

}
