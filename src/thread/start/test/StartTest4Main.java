package thread.start.test;

import util.MyLogger;

public class StartTest4Main {

    public static void main(String[] args) {

        CounterRunnable runnableA = new CounterRunnable("A", 500);
        CounterRunnable runnableB = new CounterRunnable("B", 1000);

        Thread threadA = new Thread(runnableA, "Thread-A");
        threadA.start();
        Thread threadB = new Thread(runnableB, "Thread-B");
        threadB.start();
    }

    static class CounterRunnable implements Runnable {

        private final String threadName;
        private final long seconds;

        public CounterRunnable(String threadName, long seconds) {
            this.threadName = threadName;
            this.seconds = seconds;
        }

        @Override
        public void run() {
            while (true) {
                MyLogger.log("value: " + threadName);
                try {
                    Thread.sleep(seconds);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}