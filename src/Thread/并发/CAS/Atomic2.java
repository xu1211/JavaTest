package Thread.并发.CAS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author xuyuc
 * @since 2020/10/18 17:34
 */
public class Atomic2 {
    private static AtomicBoolean flag = new AtomicBoolean(true);

    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(5, 20, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 5; i++) {
            es.submit(new Runnable() {
                @Override
                public void run() {
                    Atomic2.atomicBooleanTest();
                }
            });
        }
    }

    // 只有一个线程会 执行业务，不会脏读
    public static void atomicBooleanTest() {
        System.out.printf("线程%s开始     flag=%s\n", Thread.currentThread().getName(), flag.get());

        // flag=true 则执行，并flag改为false
        if (flag.compareAndSet(true, false)) {
            System.out.printf("线程%s执行业务     flag=%s\n", Thread.currentThread().getName(), flag.get());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag.set(true);
        } else {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("线程%s重试     flag=%s\n", Thread.currentThread().getName(), flag.get());
            atomicBooleanTest();
        }
    }

}