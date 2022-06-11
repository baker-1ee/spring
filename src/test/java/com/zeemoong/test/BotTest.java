package com.zeemoong.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
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