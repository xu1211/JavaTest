package Thread.并发.Synchronized方法;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
线程池测试类
*/
public class SynchronizedStaticMethodTest1 {

    public static void main(String[] args) {
        // 线程共用一个SynchronizedStaticMethod对象
        SynchronizedStaticMethod synchronizedstaticmethod = new SynchronizedStaticMethod();

        ExecutorService es = new ThreadPoolExecutor(5, 20, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 5; i++) {
            es.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        // synchronizedmethod.addCount()方法加锁： 5个线程在同步块代码里是串行执行
                        // 最后count=5
                        synchronizedstaticmethod.addCount();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}