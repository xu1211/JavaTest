package Thread.并发.Synchronized代码块;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
线程池测试类
*/
public class SynchronizedThisTest1 {

    public static void main(String[] args) {
        // 线程共用同一个synchronizedCode1对象
        SynchronizedThis synchronizedThis = new SynchronizedThis();

        ExecutorService es = new ThreadPoolExecutor(5, 20, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 5; i++) {
            es.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 5个线程this对象相同，此时同步块加this锁 有用： 5个线程在同步块代码里是串行执行
                        // 最后count=5，因为共用同一个 synchronizedObj对象的变量 count
                        synchronizedThis.This();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}