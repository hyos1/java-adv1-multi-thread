package thread.control.test;

import util.MyLogger;
import util.ThreadUtils;

public class JoinTest1Main {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new MyTask(), "t1");
        Thread t2 = new Thread(new MyTask(), "t2");
        Thread t3 = new Thread(new MyTask(), "t3");

        long startTime = System.currentTimeMillis();
        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();

        long endTime = System.currentTimeMillis();
        long taskTime = endTime - startTime;
        System.out.println("모든 스레드 실행 완료 걸린 시간: " + taskTime);
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                MyLogger.log(i);
                ThreadUtils.sleep(1000);
            }
        }
    }
}