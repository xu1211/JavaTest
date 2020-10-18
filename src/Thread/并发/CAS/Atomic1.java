package Thread.并发.CAS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author xuyuc
 * @since 2020/10/18 17:34
 */
public class Atomic1 {
    static  AtomicInteger count = new AtomicInteger(0);

    public  static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(5, 20, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 5; i++) {
            es.submit(new Runnable() {
                @Override
                public void run() {
                    // 最后count=5
                    // Atomic 原子类 操作的底层实现正是利用的CAS机制
                    count.incrementAndGet();
                    System.out.printf("线程%s,count=%s\n", Thread.currentThread().getName(), count);
                }
            });
        }
    }

}