package Thread.并发.Synchronized方法;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
线程池测试类
*/
public class SynchronizedStaticMethodTest2 {

    public static void main(String[] args) {

        ExecutorService es = new ThreadPoolExecutor(5, 20, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 5; i++) {

            // 线程有各自的SynchronizedStaticMethod对象
            SynchronizedStaticMethod synchronizedstaticmethod = new SynchronizedStaticMethod();
            es.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 静态方法synchronizedmethod.addCount()方法加锁： 5个线程在同步块代码里是串行执行
                        // 5个线程最后count都=1
                        synchronizedstaticmethod.addCount();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}