package Thread.并发.CAS;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xuyuc
 * @since 2020/10/18 20:46
 */
public class defectOfABA {
    public static void main(String[] args) {

        // 初始化 atomicInteger = 1
        final AtomicInteger atomicInteger = new AtomicInteger(1);

        Thread coreThread = new Thread(() -> {
            final int currentValue = atomicInteger.get();
            System.out.println(Thread.currentThread().getName() + " ------ currentValue=" + currentValue);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 如果值为 1，则改为2
            boolean casResult = atomicInteger.compareAndSet(1, 2);
            System.out.println(Thread.currentThread().getName()
                    + " ------ currentValue=" + currentValue
                    + ", 改为currentValue=" + atomicInteger.get()
                    + ", CAS结果=" + casResult);
        }
        );
        coreThread.start();

        // 让 coreThread 线程先跑起来
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread amateurThread = new Thread(() -> {
            int currentValue = atomicInteger.get();
            // 如果值为 1，则改为 2
            boolean casResult = atomicInteger.compareAndSet(1, 2);
            System.out.println(Thread.currentThread().getName()
                    + " ------ currentValue=" + currentValue
                    + ", 改为currentValue=" + atomicInteger.get()
                    + ", CAS结果=" + casResult);

            currentValue = atomicInteger.get();
            // 如果值为 1，则改为 1
            casResult = atomicInteger.compareAndSet(2, 1);
            System.out.println(Thread.currentThread().getName()
                    + " ------ currentValue=" + currentValue
                    + ", 改为currentValue=" + atomicInteger.get()
                    + ", CAS结果=" + casResult);
        }
        );
        amateurThread.start();
    }
}
