package thread.volatile1;

import util.MyLogger;
import util.ThreadUtils;

import static util.MyLogger.*;

public class VolatileFlagMain {

    public static void main(String[] args) {

        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "work");
        log("runFlag = " + myTask.runFlag);
        thread.start();

        ThreadUtils.sleep(1000);
        log("runFlag false로 변경 시도");
        myTask.runFlag = false;
        log("변경 시도 후 runFlag = " + myTask.runFlag);
        log("main 종료");
    }

    static class MyTask implements Runnable {

//        boolean runFlag = true;
        volatile boolean runFlag = true;
        @Override
        public void run() {
            log("task 시작");
            while (runFlag) {
                System.out.println("hello");
            }
            log("task 종료");
        }
    }
}