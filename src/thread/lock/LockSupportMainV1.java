package thread.lock;

import util.MyLogger;

import java.util.concurrent.locks.LockSupport;

import static util.MyLogger.*;

public class LockSupportMainV1 {

    public static void main(String[] args) throws InterruptedException {

        ParkTest parkTest = new ParkTest();
        Thread thread1 = new Thread(parkTest, "Thread-1");
        thread1.start();

        // Thread-1이 park 상태가 되도록 잠시 대기
        Thread.sleep(100);
        log("Thread-1 state: " + thread1.getState());

//        LockSupport.unpark(thread1);
//        Thread.sleep(100);
//        log("main -> unpark(Thread-1)"); // 1. unpark 사용

        thread1.interrupt();
        log("main -> interrupt()"); // 2. interrupt() 사용
    }

    static class ParkTest implements Runnable {

        @Override
        public void run() {
            log("park 시작");
            LockSupport.park();
            log("park 종료, state = " + Thread.currentThread().getState());
            log("인터럽트 상태: " + Thread.currentThread().isInterrupted());
        }
    }
}