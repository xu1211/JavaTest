package Thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cosmoxu
 * @version GC, v 0.1 2022/11/17 14:55
 *
 * https://blog.csdn.net/xyc1211/article/details/127902867
 */
public class GC {

            public static AtomicInteger num = new AtomicInteger(0);

            public static void main(String[] args) throws InterruptedException {
                Runnable runnable=()->{
                    //for (long i = 0; i < 1000000000; i++) {
                    for (int i = 0; i < 1000000000; i++) {
                        num.getAndAdd(1);
                    }
                    System.out.println(Thread.currentThread().getName()+"执行结束!");
                };

                Thread t1 = new Thread(runnable);
                Thread t2 = new Thread(runnable);
                t1.start();
                t2.start();
                Thread.sleep(1000);
                System.out.println("num = " + num);
            }
        }