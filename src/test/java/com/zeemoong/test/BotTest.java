package com.zeemoong.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BotTest {

    @Autowired
    private Bot bot;

    @Test
    public void ComponentScanTest(){

        System.out.println("bot = " + bot);
        System.out.println("bot.name() = " + bot.name());
        System.out.println("bot.age() = " + bot.age());

    }

}