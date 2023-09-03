package com.shucai.date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateForPeriodicTransfer {

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2023,2,27);
        System.out.println(new SimpleDateFormat("yyyyMMdd").format(c.getTime()));
        List<String> list = getLastMonthDays(c.getTime());
        System.out.println(list);
    }

    public static List<String> getLastMonthDays(Date date) {
        List<String> days = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        //二月最后一天
        if (calendar.get(Calendar.MONTH) == 1 &&
                isLastDayOfMonth(calendar.getTime())) {
            calendar.add(Calendar.MONTH, -1);
            days.add(format.format(calendar.getTime()));
            while (!isLastDayOfMonth(calendar.getTime())) {
                calendar.add(Calendar.DAY_OF_MONTH, +1);
                days.add(format.format(calendar.getTime()));
            }
            return days;
        }

        //三月
        if (calendar.get(Calendar.MONTH) == 2) {
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            calendar.add(Calendar.MONTH, -1);
            int max = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            if (day >= max) {
                calendar.set(Calendar.DAY_OF_MONTH, max);
                findThreeDays(days, format, calendar);
                return days;
            }
        }

        calendar.add(Calendar.MONTH, -1);
        findThreeDays(days, format, calendar);
        return days;
    }

    private static void findThreeDays(List<String> days, SimpleDateFormat format, Calendar calendar) {
        String today = format.format(calendar.getTime());
        days.add(today);
        calendar.add(Calendar.DAY_OF_MONTH, +1);
        String tomorrow = format.format(calendar.getTime());
        days.add(tomorrow);
        calendar.add(Calendar.DAY_OF_MONTH, -2);
        String yesterday = format.format(calendar.getTime());
        days.add(yesterday);
    }

    private static boolean isLastDayOfMonth(Date time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        return calendar.get(Calendar.DAY_OF_MONTH) ==
                calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
