package cn.ibona.qiniu_sdk;

import android.app.Application;
import android.test.InstrumentationTestCase;
import android.util.Log;

import java.util.Date;

import cn.ibona.qiniu_sdk.util.QiniuDateUtil;
import cn.ibona.qiniu_sdk.util.QiniuSharedPref;

/**
 * Created by yuanmingzhuo on 16-3-11.
 */
public class TestQiniuDateUtil extends InstrumentationTestCase{

    private static final String TAG="TEST_CASE_QINGIU";


    public void test(){

    }

    /**
     * 测试获得当前时间字符串
     */
    public void testNowDateString(){

        String stringByNow = QiniuDateUtil.getDateStringByNow();
        Log.d(TAG,stringByNow);

    }

    public void testSHaredPref() throws InterruptedException {

        String stringByNow = QiniuDateUtil.getDateStringByNow();

        QiniuSharedPref.init(getInstrumentation().getContext());
        QiniuSharedPref.setToken("yuanmingzhuo",stringByNow);

        String date = QiniuSharedPref.getDate();
        Log.d(TAG,"1: "+date);
        String token=QiniuSharedPref.getToken();
        Log.d(TAG,"2: "+token);

        Thread.sleep(3000);

        Date date1 = QiniuDateUtil.getDateByString(date);
        Date date2=new Date();

        if (date1 != null) {
            long nums = date2.getTime()-date1.getTime();
            Log.d(TAG,"3:"+nums);

        }else{
            Log.d(TAG,"4: 日期format转换失败");
        }

    }

}
