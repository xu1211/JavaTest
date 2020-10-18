package Thread.并发.Synchronized代码块;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
线程池测试类
*/
public class SynchronizedObjTest2 {

    public static void main(String[] args) {
        // 线程共用同一个Object对象
        Object lock = new Object();

        ExecutorService es = new ThreadPoolExecutor(5, 20, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 5; i++) {
            es.submit(new Runnable() {
                @Override
                public void run() {
                    SynchronizedObj synchronizedObj = new SynchronizedObj();
                    try {
                        // 5个线程lock对象相同，此时同步块加lock锁有用： 5个线程在同步块代码里是串行执行
                        // 但是5个线程最后count都=1，因为每个 synchronizedObj对象都有自己独立的变量 count
                        synchronizedObj.Object(lock);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}