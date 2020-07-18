package Thread.threadPool;

import java.util.concurrent.*;

/*Java线程池的几种创建方式*/
public class JavaThreadPool {
    ExecutorService es;
    ExecutorService es1;
    ExecutorService es2;
    ExecutorService es3;
    ScheduledExecutorService es4;
    ScheduledExecutorService es5;

    public JavaThreadPool() {

        this.es = new ThreadPoolExecutor(5, 20, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5));

        //1.SingleThreadExecutor：创建使用单个线程的线程池，只用一个线程来执行任务
        /*
        FinalizableDelegatedExecutorService(
        new ThreadPoolExecutor(1, 1,
                                    0L, TimeUnit.MILLISECONDS,
                                    new LinkedBlockingQueue<Runnable>()));
       */
        this.es1 = Executors.newSingleThreadExecutor();


        //2.FixedThreadPool：创建固定数量的可复用的线程数
        /*
        ThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        */
        this.es2 = Executors.newFixedThreadPool(3);


        //3.CachedThreadPool：创建一个会根据需要创建新线程的线程池 最大线程数为Interge的最大值；空闲线程存活时间是1分钟
        /*
        ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        */
        this.es3 = Executors.newCachedThreadPool();


        //4.ScheduledThreadPool：创建拥有固定线程数量的定时线程任务的线程池， 程序以起始时间为准则，每隔指定时间执行一次
        /*
        public ScheduledThreadPoolExecutor(int corePoolSize) {
            super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS,
                    new DelayedWorkQueue());
        }
         */
        this.es4 = Executors.newScheduledThreadPool(2);
        System.out.println("时间：" + System.currentTimeMillis());


        //5.创建只有一个线程的定时线程任务的线程池
        this.es5 = Executors.newSingleThreadScheduledExecutor();
        System.out.println("时间：" + System.currentTimeMillis());

    }
}
