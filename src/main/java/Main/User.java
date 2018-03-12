package Main;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.IOException;

public class User {


    @Deprecated
    public void testMethod() throws IOException
    {
        System.out.println("this is a test method");
            throw new IOException();
    }
}
