package com.cxaou.thetestsystem;

import com.cxaou.thetestsystem.utils.DateUtils;
import com.cxaou.thetestsystem.utils.VerifyUserExaminationPaperVoUtils;
import com.cxaou.thetestsystem.utils.VerifyUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class VerifyUtilsTest {


    @Test
    void passwordTest(){
        boolean b = VerifyUtils.verifyPassword("0000a0");
        System.out.println("b = " + b);
    }

    @Test
    void usernameTest(){
        boolean a = VerifyUtils.isUsername("abaaa_65");
        System.out.println("a = " + a);
    }

    @Test
    void verifyCoreParameter(){
        LocalDateTime localDateTime = LocalDateTime.of(2022,11,2,21,30,0);
        System.out.println("VerifyUserExaminationPaperVo.verifyCoreParameter(userExaminationPaperVo) = "
                + VerifyUserExaminationPaperVoUtils.verifyDateParameter(localDateTime));
    }

    @Test
    void is_stareTest(){
        LocalDateTime localDateTime = LocalDateTime.of(2022,11,3,8,25);
        System.out.println("VerifyUserExaminationPaperVoUtils.is_stare(localDateTime) = " +
               DateUtils.isStare(localDateTime));
    }

    @Test
    void end_dateTime(){
        LocalTime time = LocalTime.of(4,30,10);
        LocalDateTime dateTime = LocalDateTime.now();


        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        System.out.println("second = " + second);
        System.out.println("hour = " + hour);
        LocalDateTime localDateTime = dateTime.plusHours(hour).plusMinutes(minute).plusSeconds(second);
        System.out.println("localDateTime = " + localDateTime);
        System.out.println("dateTime = " + dateTime);
    }


    @Test
    void dateToLocalDateTimeTest(){
        Date date = new Date();
        System.out.println("date = " + date);
        LocalDateTime localDateTime = DateUtils.dateToLocalDateTime(date);
        System.out.println("localDateTime = " + localDateTime);
    }

    @Test
    void dateIsTimeOut(){
        LocalDateTime localDateTime = LocalDateTime.of(2022,11,4,19,55);
        boolean timeout = DateUtils.isTimeout(localDateTime);
        System.out.println("timeout = " + timeout);
    }

    @Test
    void testSet(){
        Set<Long> set = new HashSet<>();
        boolean add = set.add(10L);
        boolean add1 = set.add(10L);
        boolean add2 = set.add(11L);
        System.out.println("add = " + add);
        System.out.println("add = " + add1);
        System.out.println("add = " + add2);
    }
}
