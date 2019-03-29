package www.zyds.com.utils;

import android.content.Context;

import www.zyds.com.zyds.bean.LogEntity;

/**
 * Created by lsh on 2016/4/15.
 */
public class GetUserTokenUtils {
    public static final String TOKEN_NAME="KY-TOKEN";
    public static String token="";
    public static boolean mIsTest = false;
    public static String getToken(Context context){
        if(context!=null){
            LogEntity logEntity=(LogEntity) PreferencesObjectUtil.readObject("user",context);
            if(logEntity!=null){
                token=logEntity.getRes().getToken();
            }else{
                token="";
            }
            if (mIsTest){
                return 1+"";
            }else {
                return token;
            }
        }
        return "";
    }
    public static String getTokenReg(Context context){
        LogEntity logEntityReg=(LogEntity) PreferencesObjectUtil.readObject("reguser",context);
        if(logEntityReg!=null){
            token=logEntityReg.getRes().getToken();
        }else{
            token="";
        }
        if (mIsTest){
            return 1+"";
        }else {
            return token;
        }

    }
    public static String getTokenLogin(Context context){
        LogEntity logEntityReg=(LogEntity) PreferencesObjectUtil.readObject("loginuser",context);
        if(logEntityReg!=null){
            token=logEntityReg.getRes().getToken();
        }else{
            token="";
        }
        if (mIsTest){
            return 1+"";
        }else {
            return token;
        }

    }
}
