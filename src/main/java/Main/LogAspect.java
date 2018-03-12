    package Main;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

    @Component
@Aspect
public class LogAspect{

        @Pointcut("execution(* Main.User.*(..))")
        public void testMethod()
        {

        }

//            @Before("execution(public void testMethod())")
//            public void test()
//            {
//                System.out.println("This is called before");
//            }
            @After("execution(public void testMethod())")
            public void test1()
            {
                System.out.println("This is call after");
            }
            @Around("execution(public void testMethod())")
            Object aroundAdvice( ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
                System.out.println ("around before" );
                Object o=proceedingJoinPoint.proceed ();
                System.out.println ("around after" );
                return o;
            }

        @AfterThrowing (pointcut = "execution(public void testMethod())", throwing = "ex")
        public void logAfterThrowingAllMethods(Throwable ex)
        {
            System.out.println("" + ex);
        }

        @After("within(Main.User)")
        public void LoggingAdvice2()
        { System.out.println("I am in execution");  }



        @Before("within(Main.User)")
        public void LoggingAdvice3()
        { System.out.println("I am in execution"); }

        @Before("args(Main.User)")
        public void LoggingAdvice4()
        { System.out.println("I take string argument"); }


        @AfterReturning("args(name)")
        public void givename(String name)
        { System.out.println("this method takes argument as"+name); }

        @Before("testMethod()")
        public void name(JoinPoint joinPoint)
        {
            System.out.println(joinPoint.getArgs());
            System.out.println(joinPoint.getSignature());
            System.out.println("Called After Method");
            System.out.println("This is called before");
        }
    }





