package cn.ibona.qiniu_sdk.net;

import android.content.Context;

import java.util.Map;

import cn.ibona.qiniu_sdk.net.request.QiniuUploadRequest;
import cn.ibona.qiniu_sdk.util.QiniuConstant;
import cn.ibona.qiniu_sdk.util.QiniuSharedPref;

/**
 * Created by yuanmingzhuo on 16-3-11.
 * 图片上传七牛对外接口
 */
public class QiniuRequest {

    /**
     * 上传图片
     * @param context
     * @param params
     * @param qiniuCallback
     */
    public void uploadImage(Context context,Map<String,String> params,QiniuCallback qiniuCallback){

        if(context==null){
            return;
        }

        if(params==null){
            return;
        }

        QiniuSharedPref.init(context);
        QiniuUploadRequest request=new QiniuUploadRequest();
        request.setParams(params);
        request.setQiniuCallback(qiniuCallback);

        String token = QiniuSharedPref.getToken();
        if(token.equals(QiniuConstant.SHARED_PREFENCE_TOKEN_DEFAULT)){
            return;
        }

        String imagePath=params.get("imagePath");
        String imageName=params.get("imageName");
        String uid=params.get("uid");



    }

}
