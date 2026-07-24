package thread.executor.future;

import util.MyLogger;
import util.ThreadUtils;

import java.util.concurrent.*;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

public class FutureExceptionMain {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        log("작업 전달");
        Future<Integer> future = es.submit(new Excallable());
        sleep(1000); // 로그 순서대로 나오기 위해 잠시 대기

        try {
            log("future.get() 호출 시도, future.state(): " + future.state());
            Integer result = future.get();
            log("result value = " + result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            e.printStackTrace();
            log("e = " + e);
            Throwable cause = e.getCause();
            log("cause = " + cause);
            String message = cause.getMessage();
            log("message = " + message);
        }
        es.close();
    }

    static class Excallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            log("Callable 실행, 예외 발생");
            throw new IllegalStateException("ex!");
        }
    }
}