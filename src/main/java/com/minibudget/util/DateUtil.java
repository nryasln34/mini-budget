package com.minibudget.util;

import java.sql.Timestamp;
import java.util.Date;

public class DateUtil {

    public static Timestamp toTimeStamp(Date date){
        Timestamp timeStamp = new Timestamp(date.getTime());
        return timeStamp;
    }

    public static Date toDate(Timestamp timestamp){
        return new Date(timestamp.getDate());
    }

}
