package com.cxaou.thetestsystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBootTest
class TheTestSystemApplicationTests {

    @Test
    void contextLoads() {
    }

	@Autowired
    private TokenUtil tokenUtil;
    
   @Test
    void testToken(){
        String sign = tokenUtil.sign(10002L);
        System.out.println("sign = " + sign);
        boolean verify = tokenUtil.verify(sign);
        System.out.println("verify = " + verify);
    }    
}
