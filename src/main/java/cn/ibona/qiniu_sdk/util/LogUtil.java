package cn.ibona.qiniu_sdk.util;

import android.util.Log;

/**
 * Created by yuanmingzhuo on 16-3-11.
 */
public class LogUtil {

    private static final String TAG="TEST_CASE_QINGIU";

    public static void writeLog(String msg){
        Log.v(TAG,"|-------------------------------------------|");
        Log.v(TAG,"| "+msg+"     |");
        Log.v(TAG,"|___________________________________________|");
    }

}
