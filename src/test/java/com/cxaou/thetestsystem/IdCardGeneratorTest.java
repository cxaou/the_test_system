package com.cxaou.thetestsystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IdCardGeneratorTest {

    /**
     * 生成身份证
     */
    @Test
    void createIdCardGeneratorTest(){
        IdCardGenerator g = new IdCardGenerator();
        for (int i = 0; i < 10; i++) {
            System.out.print(g.generate());
            System.out.print("\t");
            System.out.print(g.generate());
            System.out.print("\t");
            System.out.print(g.generate());
            System.out.print("\t");
            System.out.println(g.generate());
        }
    }
}
