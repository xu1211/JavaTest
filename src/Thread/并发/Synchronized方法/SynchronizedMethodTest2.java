package Thread.并发.Synchronized方法;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
线程池测试类
*/
public class SynchronizedMethodTest2 {

    public static void main(String[] args) {

        ExecutorService es = new ThreadPoolExecutor(5, 20, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 5; i++) {

            // 线程有各自的SynchronizedMethod对象
            SynchronizedMethod synchronizedmethod = new SynchronizedMethod();
            es.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 方法加锁等同this锁：因为5个线程各自对象不同，所以在同步块代码里是并执行
                        // 5个线程最后count都=1
                        synchronizedmethod.addCount();
                        //等同： synchronizedmethod.addCount1();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}