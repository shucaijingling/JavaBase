package com.shucai.date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateTest {

    public static void main(String[] args) {

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");


        Calendar calendar = Calendar.getInstance();
        calendar.set(2023,1,28);

        System.out.println(calendar.get(Calendar.MONTH));

        //判断是否是月底最后一天
        boolean lastDayOfMonth = isLastDayOfMonth(calendar.getTime());
        System.out.println(lastDayOfMonth);

        List<String> days = getDays(calendar.getTime());
        System.out.println(days);


        String cal = format.format(calendar.getTime());
        System.out.println(cal);
    }


    public static boolean isLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH) == calendar
                .getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取某个日期的上个月的当天到月底的所有日期
     */
    public static List<String> getDays(Date date) {
        //格式化
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        Calendar calendar = Calendar.getInstance();
        //获取当天
        calendar.setTime(date);
        //如果是最后一天，获取上个月的当天到月底
        List<String> days = new ArrayList<>();
        if (isLastDayOfMonth(date)) {
            calendar.add(Calendar.MONTH, -1);

            while (!isLastDayOfMonth(calendar.getTime())) {
                calendar.add(Calendar.DAY_OF_MONTH, +1);
                days.add(dateFormat.format(calendar.getTime()));
            }
        }

        return days;
    }
}
