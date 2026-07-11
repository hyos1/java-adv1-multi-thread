package thread.lock;

import java.util.concurrent.locks.LockSupport;

import static util.MyLogger.log;

public class LockSupportMainV2 {

    public static void main(String[] args) throws InterruptedException {

        ParkTest parkTest = new ParkTest();
        Thread thread1 = new Thread(parkTest, "Thread-1");
        thread1.start();

        // Thread-1이 park 상태가 되도록 잠시 대기
        Thread.sleep(100);
        log("Thread-1 state: " + thread1.getState());
    }

    static class ParkTest implements Runnable {

        @Override
        public void run() {
            log("park 시작");
            LockSupport.parkNanos(2000_000000); // 백만 나노초가 1ms, 1초는 10억 나노초
            log("park 종료, state = " + Thread.currentThread().getState());
            log("인터럽트 상태: " + Thread.currentThread().isInterrupted());
        }
    }
}