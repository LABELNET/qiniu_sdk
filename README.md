# qiniu_sdk
  七牛深度封装

# 接口设计文档
  
 
  ## 上传图片
  
  *【函数原型】 static void uploadImage(Context context,UploadBean bean,QiniuCallback qiniuCallback)
  *【功能】 上传图片到七牛服务器
  *【类】 cn.ibona.qiniu_sdk.net.QiniuRequest
  *【参数说明】 
  *context   上下文
  *bean     UploadBean对象
  *callback 回调接口
  *【返回值说明】 没有
  *【备注说明】     
  * 参数UploadBean对象属性
   *  uid         当前用户id , 必须
   *  imagePath   上传图片的sd卡路径,必须
    * imageName   上传图片的文件名称, 不必须
     * token  当前上传的 token 值 , 不需要添加
   * 参数qiniuCallback 
    * onSuccess(String key)      上传成功，返回key,服务器文件名称
    * onError(String msg)        上传失败，返回 msg , 错误信息
    * onProcess(double percent)  上传进度，需要可以重写
    
---
![Image](https://github.com/LABELNET/qiniu_sdk/blob/master/%E6%8E%A5%E5%8F%A3%E8%AE%BE%E8%AE%A1%E5%8E%9F%E5%9E%8B.png?raw=true)

---

#使用
 ---java
 
    private void qiniuSdkUploadImage() {

        UploadBean bean=new UploadBean();
        bean.setUid("95");
        bean.setImageName("yuan-ming-zhuo-test"+random.nextInt(1000)+".jpg");
        bean.setImagePath(imgPath);


        QiniuRequest.uploadImage(getApplication(), bean, new QiniuCallback() {
            @Override
            public void onSuccess(String key) {

            }

            @Override
            public void onError(String msg) {
 
            }

            @Override
            public void onProcess(double percent) {


            }
        });

    }
 ---
      
      
  
  
  
  
