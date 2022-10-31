package com.cxaou.thetestsystem;

import com.cxaou.thetestsystem.utils.VerifyUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
}
