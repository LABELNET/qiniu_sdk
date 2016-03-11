package cn.ibona.qiniu_sdk.net.listener;

/**
 * Created by yuanmingzhuo on 16-3-11.
 * 监听 token
 */
public interface TokenLisntener {

    //token 超时
    void isTokenTimeOut();

    //token 失效 401
    void isTokenDisable();

}
