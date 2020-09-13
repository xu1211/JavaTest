package Thread.threadLocal;

/**
 * @since 2020/9/11 21:37
 * 线程内部的存储类,在指定线程内存储数据，数据存储以后，只有指定线程可以得到存储数据
 */

import java.text.SimpleDateFormat;
import java.util.Random;

public class threadLocalTest implements Runnable {

    // SimpleDateFormat 不是线程安全的，所以每个线程都要有自己独立的副本
    private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd HHmm");
        }
    };

    public static void main(String[] args) throws InterruptedException {
        threadLocalTest obj = new threadLocalTest();
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(obj, "" + i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Thread Name= " + Thread.currentThread().getName() + " formatter初始值 = " + formatter.get().toPattern());

        formatter.set(new SimpleDateFormat("yyyy"));

        System.out.println("Thread Name= " + Thread.currentThread().getName() + " formatter修改为 = " + formatter.get().toPattern());
    }

}
