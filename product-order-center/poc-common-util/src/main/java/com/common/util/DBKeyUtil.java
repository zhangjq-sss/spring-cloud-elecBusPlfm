package com.common.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author fazhan.ding
 * @Description
 * @date 2018/6/21 18:11
 */
public class DBKeyUtil {

    protected static Log log = LogFactory.getLog(DBKeyUtil.class);

    /**
     * DB逻辑Key生成工具
     * 生成规则：年月日+随机数+时间戳+线程id+模块名
     *
     * @param   moduleName  模块名
     * @return  Mark
     *
     * @exception
     */
    public static synchronized String getDBKey(String moduleName) throws Exception
    {

        StringBuffer buffer = new StringBuffer();

        //年月日
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        buffer.append(sdf.format(date));
        //模块名
        buffer.append(moduleName);
        //随机数
        Random random = new Random();
        int number = random.nextInt(1000);
        if(number < 1000){
            number = 999 - number;
        }
        buffer.append(number);
        //时间戳
        buffer.append(System.currentTimeMillis() % 1000000);
        //随机数
        number = random.nextInt(1000);
        if(number < 1000){
            number = 999 - number;
        }
        buffer.append(number);
        //线程id
        String threadid = String.valueOf(Thread.currentThread().getId());
        buffer.append(threadid);
//        System.out.println(buffer);

        return buffer.toString();
    }
}