package com.beautifulharborbackstage.utils;

import lombok.extern.java.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Log
public class DateUtil {
    public static Date getFirstDayOfMonth(int month) {
         Calendar cal = Calendar.getInstance();
         // 设置月份
         cal.set(Calendar.MONTH, month - 1);
         // 获取某月最小天数
         int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
         // 设置日历中月份的最小天数
         cal.set(Calendar.DAY_OF_MONTH, firstDay);
         // 格式化日期
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         String firstDayOfMonth = sdf.format(cal.getTime())+" 00:00:00";
         log.info(firstDayOfMonth);
         return cal.getTime();
     }
    /**
     * 获得该月最后一天
     *
     * @param month
     * @return
     */
     public static Date getLastDayOfMonth(int month) {
        Calendar cal = Calendar.getInstance();
        // 设置月份
        cal.set(Calendar.MONTH, month - 1);
        // 获取某月最大天数
        int lastDay=0;
       //2月的平年瑞年天数
       if(month==2) {
         lastDay = cal.getLeastMaximum(Calendar.DAY_OF_MONTH);
       }else {
          lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
       }
        // 设置日历中月份的最大天数
         cal.set(Calendar.DAY_OF_MONTH, lastDay);
        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayOfMonth = sdf.format(cal.getTime())+" 23:59:59";
        log.info(lastDayOfMonth);
        return cal.getTime();
     }
}