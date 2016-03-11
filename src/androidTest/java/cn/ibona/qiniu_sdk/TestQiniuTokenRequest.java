package cn.ibona.qiniu_sdk;

import android.test.InstrumentationTestCase;
import android.test.suitebuilder.annotation.MediumTest;

import cn.ibona.qiniu_sdk.net.listener.TokenLisntener;
import cn.ibona.qiniu_sdk.net.request.QiniuTokenRequest;
import cn.ibona.qiniu_sdk.util.LogUtil;

/**
 * Created by yuanmingzhuo on 16-3-11.
 */
public class TestQiniuTokenRequest extends InstrumentationTestCase {

    @MediumTest
    public void testGetToken(){
        try {
            QiniuTokenRequest.getToken(95 + "", new TokenLisntener() {
                @Override
                public void getTokenSuccess(String token) {
                    LogUtil.writeLog(token);
                }

                @Override
                public void getTokenError(String msg) {
                    LogUtil.writeLog(msg);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
