package cn.ibona.qiniu_sdk.net;

/**
 * Created by yuanmingzhuo on 16-3-11.
 */
public abstract class QiniuCallback {

    /**
     * 上传成功
     * @param key 图片名称
     */
    public abstract void onSuccess(String key);

    /**
     * 上传失败
     * @param msg 错误信息
     */
    public abstract void onError(String msg);

    /**
     * 当前进度
     * @param percent 进度值
     */
    public void onProcess(double percent){}

}
