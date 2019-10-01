package app;


import org.junit.Test;

import static org.junit.Assert.*;

public class HelloServiceTest {

    private HelloService SUT = new HelloService();

    @Test
    public void test_prepareGreeting_null_returnsFallbackValue()throws Exception{
        //given + when
        String result = SUT.prepareGreeting(null);

        //then
        assertEquals("Hello " + HelloService.FALLBACK_NAME + "!", result);

    }

    @Test
    public void test_prepareGreeting_name_returnsFallbackValue()throws Exception{
        //given
        String name = "test";

        //when
        String result = SUT.prepareGreeting(name);

        //then
        assertEquals("Hello " + name + "!", result);

    }

 }
