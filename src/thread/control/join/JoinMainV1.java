package thread.control.join;

import util.MyLogger;

import static util.MyLogger.*;

public class JoinMainV1 {

    public static void main(String[] args) throws InterruptedException {

        log("Start");
        int sum = 0;
        // Thread를 상속받아서 만든 경우
//        SumThread sumThread1 = new SumThread(1, 50);
//        sumThread1.start();
//        SumThread sumThread2 = new SumThread(51, 100);
//        sumThread2.start();
//        Thread.sleep(2000);
//        sum = sumThread1.getResult() + sumThread2.getResult();

        // Runnable로 만든 경우
        SumRunnable runnableA = new SumRunnable(1, 50);
        SumRunnable runnableB = new SumRunnable(51, 100);
        Thread threadA = new Thread(runnableA);
        Thread threadB = new Thread(runnableB);
        threadA.start();
        threadB.start();
        sum = runnableA.getResult() + runnableB.getResult();
        System.out.println("sum = " + sum);
        log("End");
    }

    static class SumRunnable implements Runnable {

        int result;
        private int startValue;
        private int endValue;

        public SumRunnable(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업 시작");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = startValue; i <= endValue; i++) {
                result += i;
            }
            log("작업 완료 result = " + result);
        }

        public int getResult() {
            return result;
        }
    }

    static class SumThread extends Thread {
        public int result;
        private final int startValue;
        private final int endValue;

        public SumThread(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            for (int i = startValue; i <= endValue; i++) {
                result += i;
            }
        }

        public int getResult() {
            return result;
        }
    }
}