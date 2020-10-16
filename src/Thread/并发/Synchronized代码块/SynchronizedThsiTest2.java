package Thread.并发.Synchronized代码块;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
线程池测试类
*/
public class SynchronizedThsiTest2 {

    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(5, 20, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 5; i++) {

            // 线程各有一个synchronizedCode对象
            SynchronizedThis synchronizedThis = new SynchronizedThis();
            es.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 5个线程this对象不同，此时同步块加this锁 无用： 5个线程在同步块代码里是并行执行
                        // 5个线程最后count=1，因为每个 synchronizedThis对象都有自己独立的变量 count
                        synchronizedThis.This();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}