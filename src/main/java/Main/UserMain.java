package Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class UserMain

{
    public static void main(String[] args) {


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
        User u =applicationContext.getBean(User.class);
        try {
            u.testMethod();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


