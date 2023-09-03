package com.shucai.generic;

public class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate myDate) {
        //year
        int y = year - myDate.getYear();
        if (y != 0) {
            return y;
        }
        //month
        int m = month - myDate.getMonth();
        if (m != 0) {
            return m;
        }
        //day
        int d = day - myDate.getDay();
        if (d != 0) {
            return d;
        }

        return 0;
//        return year - myDate.getYear() == 0 ? 0 : (month - myDate.getMonth() == 0 ? 0 : day - myDate.getDay());
    }
}
