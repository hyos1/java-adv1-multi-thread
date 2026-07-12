package thread.sync;

import util.MyLogger;
import util.ThreadUtils;

import static util.MyLogger.*;

public class BankMain {

    public static void main(String[] args) throws InterruptedException {
//        BankAccount account = new BankAccountV1(10000);
//        BankAccount account = new BankAccountV2(10000);
//        BankAccount account = new BankAccountV3(10000);
//        BankAccount account = new BankAccountV4(10000);
        BankAccount account = new BankAccountV5(10000);
        Thread t1 = new Thread(new WithdrawTask(8000, account), "t1");
        Thread t2 = new Thread(new WithdrawTask(8000, account), "t2");

        t1.start();
        t2.start();

        ThreadUtils.sleep(500);
        log("t1 state = " + t1.getState());
        log("t2 state = " + t2.getState());

        t1.join();
        t2.join();

        log("최종 잔액: " + account.getBalance());
    }

}