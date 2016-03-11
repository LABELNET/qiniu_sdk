package cn.ibona.qiniu_sdk.util;

/**
 * Created by yuanmingzhuo on 16-3-10.
 * 放置常量
 */
public interface QiniuConstant {



    String SHARED_PREFENCE_TOKEN_KEY="shared_pref_token_key";  //shared_pref token key
    String SHARED_PREFENCE_TOKEN_TIME_KEY="shared_pref_token_time_key"; //shared_pref token time
    String SHARED_PREFENCE_TOKEN_DEFAULT="no";
    String SHARED_PREFENCE_TOKEN_TIME_DEFAULT="2016-01-01 00:00:00";


    String QINIU_DATE_UTIL_FORMAT="yyyy-MM-dd HH:mm:ss";

    String USER_ID_KEY="uid";


    //token json 数据解析
    String JSON_TOKEN_STATUE="status";
    String JSON_TOKEN_IFNO="info";
    String JSON_TOKEN_DATA="data";
    String JSON_TOKEN_TOKEN="token";

    //上传图片提示信息
    String UPLOAD_IMAGE_IFO="图片路径不存在";

    int RESPONSE_STATUS_CODE=401;




}
