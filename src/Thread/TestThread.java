package Thread;

import java.util.concurrent.TimeUnit;

/*
线程池测试类
*/
public class TestThread {

    public static void main(String[] args) {
        // 初始化自定义线程池，创建线程
        MyThreadPool pool = new MyThreadPool();
        // 任务生产者
        for (int i = 0; i < 5; i++) {
            int I = i;
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行任务" + I);
                }
            };

            // 任务加入任务容器
            pool.add(task);

            // 等待一段时间在生产下一个任务
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 初始化java线程池，创建线程
        JavaThreadPool ThreadPool = new JavaThreadPool();
        for (int i = 0; i < 20; i++) {

            ThreadPool.es.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "线程池0-正在执行任务");
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