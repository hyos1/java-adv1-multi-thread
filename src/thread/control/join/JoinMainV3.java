package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV3 {

    public static void main(String[] args) throws InterruptedException {

        SumRunnable runnableA = new SumRunnable(1, 50);
        SumRunnable runnableB = new SumRunnable(51, 100);
        Thread threadA = new Thread(runnableA);
        Thread threadB = new Thread(runnableB);

        threadA.start();
        threadB.start();

        // 스레드가 종료될 때까지 대기
        log("join() - main 스레드가 threadA, threadB 종료될 때까지 대기");
        threadA.join();
        threadB.join();
        log("main 스레드 대기 완료");

        int sum = runnableA.getResult() + runnableB.getResult();
        System.out.println("sum = " + sum);
        log("End");
    }

    static class SumRunnable implements Runnable {

        int startValue;
        int endValue;
        int result;

        public SumRunnable(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업 시작");
            sleep(2000);
            for (int i = startValue; i <= endValue; i++) {
                result += i;
            }
            log("작업 완료 result = " + result);
        }

        public int getResult() {
            return result;
        }
    }
}