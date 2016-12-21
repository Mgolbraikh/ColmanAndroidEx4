package com.example.owner.mystudentappfrag;

/**
 * Created by Ziv on 20/12/2016.
 */

public class Utils {
    public static String getTimeFormat(int hour,int minute){
        String suffix = "AM";

        if (hour >= 12){
            suffix="PM";
            hour = hour %12;
        }
        return String.format("%02d:%02d %s", hour,minute,suffix);
    }

    public static String getDateFormat(int year, int month, int day){
        return String.format("%02d/%02d/%d",day,month+1,year);
    }
}
