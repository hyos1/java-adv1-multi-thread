package thread.start;

public class DaemonThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": start()");

        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true); // 데몬 스레드 설정
        daemonThread.setName("DaemonThread");
        HelloThread helloThread1 = new HelloThread();
        HelloThread helloThread2 = new HelloThread();

        daemonThread.start();
        helloThread1.start();
        helloThread2.start();

        System.out.println(Thread.currentThread().getName() + ": end()");
    }

    static class DaemonThread extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": run()");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ": end()");
        }
    }
}