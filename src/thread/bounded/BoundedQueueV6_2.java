package thread.bounded;

import util.MyLogger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static util.MyLogger.*;

public class BoundedQueueV6_2 implements BoundedQueue {

    private BlockingQueue<String> queue;


    public BoundedQueueV6_2(int max) {
        queue = new ArrayBlockingQueue<>(max);
    }


    @Override
    public void put(String data) {
        boolean result = queue.offer(data); // 성공 시 true, 실패 시 false
        log("저장 시도 결과 = " + result);
    }

    @Override
    public String take() {
        return queue.poll(); // 꺼낼 값 없으면 null 반환
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}