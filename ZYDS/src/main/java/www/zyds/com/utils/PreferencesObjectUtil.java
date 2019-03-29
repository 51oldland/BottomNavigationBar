package www.zyds.com.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

import www.zyds.com.zyds.bean.LogEntity;

/**
 * 将对象进行序列化，存到sharePreference中，供使用
 *
 * @author Administrator
 */
public class PreferencesObjectUtil {
    private static SharedPreferences sp;
    private static PreferencesObjectUtil mSPUtil;
    private static SharedPreferences.Editor editor;
    private Context context;

    public static PreferencesObjectUtil getInstant(Context context) {
        if (mSPUtil==null){
            mSPUtil = new PreferencesObjectUtil();
        }
        if (sp==null){
            sp = context.getSharedPreferences("base64",
                    Context.MODE_PRIVATE);
        }
        if (editor == null){
            editor = sp.edit();
        }
        return mSPUtil;
    }

    /**
     * 把对象从sharePreference中读取出来
     *
     * @param key     键名
     * @param context 上下文对象
     * @return
     */
    public static Object readObject(String key, Context context) {
        Object obj = null;

        String productBase64 = sp.getString(key, "");

        // 读取字节

        byte[] base64 = Base64.decode(productBase64.getBytes(), 0);

        // 封装到字节流
        ByteArrayInputStream bais = new ByteArrayInputStream(base64);
        try {
            // 再次封装
            ObjectInputStream bis = new ObjectInputStream(bais);
            try {
                // 读取对象
                obj = bis.readObject();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                Log.i("ok", "读取失败");
            } catch (EOFException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                Log.i("ok", "读取失败");
            }
        } catch (StreamCorruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.i("ok", "读取失败");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.i("ok", "读取失败");
        }
        return obj;
    }

    /**
     * 将对象保存到sharePerference中
     *
     * @param obj     序列化的对象
     * @param key     键
     * @param context 上下文对象
     */
    public static void saveObject(Object obj, String key, Context context) {

        // 创建字节输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            // 创建对象输出流，并封装字节流
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            // 将对象写入字节流
            oos.writeObject(obj);
            // 将字节流编码成base64的字符串
            String obj_base64 = new String(Base64.encode(baos.toByteArray(), 0));
            editor.putString(key, obj_base64);
            editor.commit();
        } catch (IOException e) {
            // TODO Auto-generated
            e.printStackTrace();
            Log.i("ok", "存储失败");
        }

    }


    public Object readObject(String key) {
        Object obj = null;

        String productBase64 = sp.getString(key, "");

        // 读取字节

        byte[] base64 = Base64.decode(productBase64.getBytes(), 0);

        // 封装到字节流
        ByteArrayInputStream bais = new ByteArrayInputStream(base64);
        try {
            // 再次封装
            ObjectInputStream bis = new ObjectInputStream(bais);
            try {
                // 读取对象
                obj = bis.readObject();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                Log.i("ok", "读取失败");
            }
        } catch (StreamCorruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.i("ok", "读取失败");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.i("ok", "读取失败");
        }
        return obj;
    }


    public void saveObject(Object obj, String key) {
        // 创建字节输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            // 创建对象输出流，并封装字节流
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            // 将对象写入字节流
            oos.writeObject(obj);
            // 将字节流编码成base64的字符串
            String obj_base64 = new String(Base64.encode(baos.toByteArray(), 0));
            editor.putString(key, obj_base64);

            editor.commit();
        } catch (IOException e) {
            // TODO Auto-generated
            Log.i("ok", "存储失败");
        }

    }

    public static void clearAllDate(Context context) {
        editor.clear();
        editor.commit();
    }

    public static void clearAllDateNotForUser(Context context) {
        LogEntity logEntity = (LogEntity) PreferencesObjectUtil.readObject("user", context);
        editor.clear();
        editor.commit();
        saveObject(logEntity, "user", context);
    }

    public static void clearDate(Context context, String key) {
        editor.remove(key);
        editor.commit();
    }
}
