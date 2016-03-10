package cn.ibona.qiniu_sdk.net.request;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import cn.ibona.qiniu_sdk.net.NetUrl;
import cn.ibona.qiniu_sdk.util.QiniuConstant;

/**
 * Created by yuanmingzhuo on 16-3-10.
 * 获取Token请求
 */
public class QiniuTokenRequest {

    private final   OkHttpClient mOkHttpClient=new OkHttpClient();

    /**
     * token请求 对象
     * @param params uid 集合
     * @return
     */
    private static QiniuTokenRequest newInstance(Map<String,String> params){
        return new QiniuTokenRequest(params);
    }

    //uid
    private Map<String,String> params;
    public QiniuTokenRequest(Map<String,String> params) {
        this.params=params;
    }

    /**
     * token数据请求
     * @throws Exception
     */
    private  void getStringFromServer() throws Exception {

        mOkHttpClient.setConnectTimeout(30, TimeUnit.SECONDS);

        RequestBody body=new FormEncodingBuilder()
                .add(QiniuConstant.USER_ID_KEY, params.get(QiniuConstant.USER_ID_KEY))
                .build();

        Request request=new Request.Builder()
                .url(NetUrl.TOKEN_URL)
                .post(body)
                .build();

        Response response=mOkHttpClient.newCall(request).execute();

        if(response.isSuccessful()){

            //自己进行解析

        }else{


        }
    }


}
