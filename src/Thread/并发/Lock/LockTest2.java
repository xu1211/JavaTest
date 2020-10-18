package Thread.并发.Lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
线程池测试类
*/
public class LockTest2 {

    public static void main(String[] args) {

        ExecutorService es = new ThreadPoolExecutor(5, 20, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 5; i++) {
            // 线程有各自的lock对象，锁不互斥
            lock l = new lock();

            es.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 5个线程最后count都=1
                        l.addCount();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}