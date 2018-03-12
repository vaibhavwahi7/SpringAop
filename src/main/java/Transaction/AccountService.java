package Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;


@Component
public class AccountService {


    @Autowired
    JdbcTemplate jdbcTemplate;


    @Autowired
    PlatformTransactionManager transactionManager;

    @Autowired
    LoggingService loggingService;

    @Transactional(propagation = Propagation.REQUIRED)
    public void insertIntoUserAccountUsingProgrammaticTransaction() {
        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);

        System.out.println("Inserting into table Programmatic");
        try {

//          Q1.) Create User Account table with name,balance fields


//          Q2.) Create CRUD operation in Account Service
//               (Add/Get/Delete/Update amount in User Account table)


            String sql3="update user_account set amount=amount-500 where username='peter'";
            String sql4="update user_account set amount=amount+500 where username='john'";
            jdbcTemplate.update(sql3);
            jdbcTemplate.update(sql4);


//  Q6.) Create account_transaction table with sender,receiver, balance_transferred fields.



            String sql1 = "INSERT into account_transaction1 (sender,receiver,balance_transferred) VALUES (?,?,?)";
            jdbcTemplate.update(sql1, new Object[]{1, 2, 2000});
        } catch (Exception e) {
            transactionManager.rollback(transactionStatus);
        }
        transactionManager.commit(transactionStatus);

    }




//     Q5.) Provide Appropriate Readonly attribute as per Method Behaviour.





//    @Transactional(propagation = Propagation.REQUIRED)
    @Transactional(readOnly = true)
    public void insertIntoUserAccount() {
        System.out.println("Inserting into table");
//        String sql = "INSERT INTO user_account (username,amount)VALUES(?,?)";
//        String sql1="update user_account set amount=? where username='Peter'";
//        String sql2="delete from user_account where id=?";
//
        String sql5="select * from user_account";
        jdbcTemplate.execute(sql5);
//        jdbcTemplate.update(sql, new Object[]{"john", 2700});
//        jdbcTemplate.update(sql1,3500);
//        jdbcTemplate.update(sql2,3);
//        try {
//            loggingService.loggingIntoTransactionTable();
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }

    }


   /* @Transactional(propagation = Propagation.REQUIRED)
    public void insertEmployee1() throws Exception {
        System.out.println("Inserting into table");
        String sql = "INSERT INTO user_account (username,amount)VALUES(?,?)";
        jdbcTemplate.update(sql, new Object[]{"Peter", 2700});
        for (int i = 0; i < 3; i++) {
            loggingService.loggingIntoTransactionTable1();
        }
        throw new Exception();

    }*/
}
