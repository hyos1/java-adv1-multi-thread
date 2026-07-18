package thread.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static util.MyLogger.log;

public class BoundedQueueV6_4 implements BoundedQueue {

    private BlockingQueue<String> queue;


    public BoundedQueueV6_4(int max) {
        queue = new ArrayBlockingQueue<>(max);
    }


    @Override
    public void put(String data) {
        queue.add(data); // 다 차면 java.lang.IllegalStateException: Queue full
    }

    @Override
    public String take() {
        return queue.remove(); // 삭제할 데이터가 없으면 java.util.NoSuchElement
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}