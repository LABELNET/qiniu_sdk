package cn.ibona.qiniu_sdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Date;

/**
 * Created by yuanmingzhuo on 16-3-10.
 * 本地存储和读取Token
 * 同时存储系统时间
 */
public final class QiniuSharedPref {


    //初始化 SharedPreference
    private static SharedPreferences sPref;
    public static void init(Context cxt){
        sPref=PreferenceManager.getDefaultSharedPreferences(cxt);
    }


    /**
     * 存储token
     * @param token 当前token
     * @param date 当前时间
     */
    public static void setToken(String token,String date) {
        SharedPreferences.Editor edit = sPref.edit();
        edit.putString(QiniuConstant.SHARED_PREFENCE_TOKEN_KEY,token);
        edit.putString(QiniuConstant.SHARED_PREFENCE_TOKEN_TIME_KEY,token);
        edit.commit();
    }

    /**
     * 获取 token
     * @return
     */
    public String getToken() {
        return sPref.getString(QiniuConstant.SHARED_PREFENCE_TOKEN_KEY,QiniuConstant.SHARED_PREFENCE_TOKEN_DEFAULT);
    }

    /**
     * 获取时间
     * @return
     */
    public String getDate(){
        return sPref.getString(QiniuConstant.SHARED_PREFENCE_TOKEN_TIME_KEY,QiniuConstant.SHARED_PREFENCE_TOKEN_TIME_DEFAULT);
    }

}
