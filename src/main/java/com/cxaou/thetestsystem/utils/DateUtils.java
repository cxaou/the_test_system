package com.cxaou.thetestsystem.utils;

import java.time.*;
import java.util.Date;

public class DateUtils {

    /**
     *  传入时间，比较是否开始考试
     * @param startTime 开始考试的时间
     * @return 开始 true ， 否则 false
     */
    public static boolean is_stare(LocalDateTime startTime){
        Duration duration = Duration.between(LocalDateTime.now(),startTime);
        // 如果小于0 说明 不满足要求
        System.out.println("duration.toMillis() = " + duration.toMillis());
        return duration.toMillis() <= 0;
    }

    /**
     * 时间加法，  LocalDateTime + LocalTime
     * @param dateTime
     * @param time
     * @return
     */
    public static LocalDateTime calculateEndDateTime(LocalDateTime dateTime, LocalTime time){
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        return dateTime.plusHours(hour).plusMinutes(minute).plusSeconds(second);
    }

    /**
     * 时间类型转换 Date  转换成 LocalDateTime
     * @param date
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(Date date){
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }

}
