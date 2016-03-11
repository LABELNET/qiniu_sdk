package cn.ibona.qiniu_sdk.net.request;

import com.qiniu.android.utils.AsyncRun;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.TimeUnit;
import cn.ibona.qiniu_sdk.net.NetUrl;
import cn.ibona.qiniu_sdk.net.listener.TokenLisntener;
import cn.ibona.qiniu_sdk.util.LogUtil;
import cn.ibona.qiniu_sdk.util.QiniuConstant;

/**
 * Created by yuanmingzhuo on 16-3-10.
 * 获取Token请求
 */
public class QiniuTokenRequest{


    /**
     * token 获取监听
     */
    private TokenLisntener tokenLisntener;
    public void setTokenLisntener(TokenLisntener tokenLisntener) {
        this.tokenLisntener = tokenLisntener;
    }

    private final OkHttpClient mOkHttpClient=new OkHttpClient();

    //uid
    private String uid;
    public QiniuTokenRequest(String uid) {
        this.uid = uid;
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

        String responseStr=response.body().string();

        if(response.isSuccessful()){
            //自己进行解析
            parseJson(responseStr);
        }else{
            tokenLisntener.getTokenError(responseStr);
        }
    }

    /**
     * json 解析
     * @param json json值
     */
    private void parseJson(String json) {
        LogUtil.writeLog(json);
        try {
            JSONObject object=new JSONObject(json);
            int status=object.getInt(QiniuConstant.JSON_TOKEN_STATUE);
            String info=object.getString(QiniuConstant.JSON_TOKEN_IFNO);
            if(status==0){
                object=object.getJSONObject(QiniuConstant.JSON_TOKEN_DATA);
                String token = object.getString(QiniuConstant.JSON_TOKEN_TOKEN);
                tokenLisntener.getTokenSuccess(token);
            }else{
                tokenLisntener.getTokenError(info);
            }

        } catch (JSONException e) {
            tokenLisntener.getTokenError(e.getMessage());
        }
    }

    /**
     * 获取token
     * @param uid 用户id
     * @throws Exception 异常
     */
    public static void getToken(final String uid, final TokenLisntener tokenLisntener){
        final QiniuTokenRequest tokenRequest = new QiniuTokenRequest(uid);
        tokenRequest.setTokenLisntener(tokenLisntener);

       new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   tokenRequest.getStringFromServer();
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       }).start();

    }

}
