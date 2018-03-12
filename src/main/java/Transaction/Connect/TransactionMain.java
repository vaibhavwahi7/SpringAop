package Transaction.Connect;

import Transaction.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TransactionMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TransactionConfig.class);
        AccountService accountService =(AccountService) applicationContext.getBean("accountService");
        accountService.insertIntoUserAccountUsingProgrammaticTransaction();
//        accountService.insertIntoUserAccount();
    }
}
