package Thread.并发.Synchronized代码块;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
线程池测试类
*/
public class SynchronizedClassTest2 {

    public static void main(String[] args) {

        ExecutorService es = new ThreadPoolExecutor(5, 20, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 5; i++) {

            // 线程有各自的SynchronizedClass对象
            SynchronizedClass synchronizedclass = new SynchronizedClass();
            es.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        // SynchronizedClass.class唯一，此时同步块加锁有用： 5个线程在同步块代码里是串行执行
                        // 5个线程最后count=1，因为每个 SynchronizedClass对象都有自己独立的变量 count
                        synchronizedclass.Class();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}