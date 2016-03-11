package cn.ibona.qiniu_sdk.net.request;


import android.content.Context;
import android.support.annotation.Nullable;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UpProgressHandler;
import com.qiniu.android.storage.UploadManager;
import com.qiniu.android.storage.UploadOptions;
import org.json.JSONObject;
import java.io.File;
import java.util.Map;
import cn.ibona.qiniu_sdk.net.QiniuCallback;
import cn.ibona.qiniu_sdk.net.listener.TokenLisntener;
import cn.ibona.qiniu_sdk.net.listener.UploadListener;
import cn.ibona.qiniu_sdk.util.QiniuConstant;
import cn.ibona.qiniu_sdk.util.QiniuDateUtil;
import cn.ibona.qiniu_sdk.util.QiniuSharedPref;

/**
 * Created by yuanmingzhuo on 16-3-10.
 * 上传图片请求
 */
public class QiniuUploadRequest implements TokenLisntener{

    /**
     * 上传回调请求-通知token失效，重新请求
     */
    private UploadListener uploadListener;

    public void setUploadListener(UploadListener uploadListener) {
        this.uploadListener = uploadListener;
    }

    /**
     * 回调请求
     */
    private QiniuCallback qiniuCallback;
    public void setQiniuCallback(QiniuCallback qiniuCallback) {
        this.qiniuCallback = qiniuCallback;
    }


    private Map<String,String> params;
    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    /**
     * 请求token类
     */

    private  UploadManager uploadManager;
    public QiniuUploadRequest() {
        uploadManager=new UploadManager();
    }

    /**
     * 上传图片
     */
    public void upload(String imagePath,String imageName,String token) {

        final File uploadFile = getFile(imagePath);
        if (uploadFile == null) {
             qiniuCallback.onError(QiniuConstant.UPLOAD_IMAGE_IFO);
             return;
          }

        UploadOptions uploadOptions = new UploadOptions(null, null, false,
                new UpProgressHandler() {
                    @Override
                    public void progress(String key, double percent) {
                        qiniuCallback.onProcess(percent);
                    }
                }, null);
        this.uploadManager.put(uploadFile,imageName, token,
                new UpCompletionHandler() {
                    @Override
                    public void complete(String key, ResponseInfo respInfo,
                                         JSONObject jsonData) {
                        if (respInfo.isOK()) {
                              qiniuCallback.onSuccess(key);
                        } else {
                            //401 , 执行回调操作
                            if (respInfo.statusCode==QiniuConstant.RESPONSE_STATUS_CODE){
                                uploadListener.isTokenTimeOut();
                            }
                        }
                    }

                }, uploadOptions);
    }

    @Nullable
    private File getFile(String imagePath) {
        File uploadFile = new File(imagePath);
        if(!(uploadFile.exists() && uploadFile.isFile())){
            return null;
        }
        return uploadFile;
    }



    @Override
    public void getTokenSuccess(String token) {
         //存储token，重新请求
        QiniuSharedPref.setToken(token, QiniuDateUtil.getDateStringByNow());

    }

    @Override
    public void getTokenError(String msg) {
        qiniuCallback.onError(msg);
    }
}
