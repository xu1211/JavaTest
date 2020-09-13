package Thread.threadPool;

import java.util.concurrent.TimeUnit;

/*
线程池测试类
*/
public class JavaThreadTest {

    public static void main(String[] args) {

        // 2. 使用java自带线程池
        JavaThreadPool ThreadPool = new JavaThreadPool();
        for (int i = 0; i < 20; i++) {

            ThreadPool.es.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "线程池0-正在执行任务");
                }
            });
            ThreadPool.es.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "线程池1-正在执行任务");
                }
            });
            ThreadPool.es1.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "线程池1-正在执行任务");
                }
            });

            ThreadPool.es2.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "线程池2-正在执行任务");
                }
            });

            ThreadPool.es3.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "线程池3-正在执行任务");
                }
            });

            ThreadPool.es4.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("时间：" + System.currentTimeMillis() + "--" + Thread.currentThread().getName() + "线程池4-正在执行任务");
                }
            }, 3, TimeUnit.SECONDS);

            ThreadPool.es5.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("时间：" + System.currentTimeMillis() + "--" + Thread.currentThread().getName() + "线程池5-正在执行任务");
                }
            }, 3, TimeUnit.SECONDS);
        }
    }

}