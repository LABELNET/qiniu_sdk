package cn.ibona.qiniu_sdk.net.request;

import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.util.concurrent.TimeUnit;
import cn.ibona.qiniu_sdk.net.NetUrl;
import cn.ibona.qiniu_sdk.net.listener.TokenLisntener;
import cn.ibona.qiniu_sdk.net.listener.UploadListener;
import cn.ibona.qiniu_sdk.util.QiniuConstant;

/**
 * Created by yuanmingzhuo on 16-3-10.
 * 获取Token请求
 */
public class QiniuTokenRequest implements UploadListener{


    /**
     * token 获取监听
     */
    private TokenLisntener tokenLisntener;
    public void setTokenLisntener(TokenLisntener tokenLisntener) {
        this.tokenLisntener = tokenLisntener;
    }

    private final   OkHttpClient mOkHttpClient=new OkHttpClient();
    /**
     * token请求 对象
     * @uid   用户id
     * @return
     */
    private static QiniuTokenRequest newInstance(String uid){
        return new QiniuTokenRequest(uid);
    }

    //uid
    private String uid;
    public QiniuTokenRequest(String uid) {
        this.uid=uid;
    }

    /**
     * token数据请求
     * @throws Exception
     */
    private  void getStringFromServer() throws Exception {

        mOkHttpClient.setConnectTimeout(30, TimeUnit.SECONDS);

        RequestBody body=new FormEncodingBuilder()
                .add(QiniuConstant.USER_ID_KEY,uid)
                .build();

        Request request=new Request.Builder()
                .url(NetUrl.TOKEN_URL)
                .post(body)
                .build();

        Response response=mOkHttpClient.newCall(request).execute();

        if(response.isSuccessful()){
            //自己进行解析
            parseJson(response.body().string());
        }else{
            tokenLisntener.getTokenError("");
        }
    }

    /**
     * json 解析
     * @param json json值
     */
    private void parseJson(String json) {



    }

    @Override
    public void isTokenTimeOut() {
        //重新请求token 并 本地存储
    }
}
