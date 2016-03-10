package cn.ibona.qiniu_sdk.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yuanmingzhuo on 16-3-10.
 * 时间工具类
 */
public class QiniuDateUtil {


    private static final SimpleDateFormat sdf=new SimpleDateFormat(QiniuConstant.QINIU_DATE_UTIL_FORMAT);

    public static Date getDateByString(String date)  {
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }



}
