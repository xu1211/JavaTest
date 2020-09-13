package Thread.threadPool;

import java.util.concurrent.*;

/*
Java线程池的几种创建方式
*/
public class JavaThreadPool {

    /*
        corePoolSize 核心线程数线程数:  最小可以同时运行的线程数量，初始化线程数。
        maximumPoolSize 最大线程数:  当队列中存放的任务达到队列容量的时候，当前可以同时运行的线程数量变为最大线程数。
        workQueue 任务队列: 当新任务来的时候会先判断当前运行的线程数量是否达到核心线程数，如果达到的话，新任务就会被存放在队列中。
        keepAliveTime 等待时间:  当线程池中的线程数量大于 corePoolSize 的时候，如果这时没有新的任务提交，核心线程外的线程不会立即销毁，而是会等待，直到等待的时间超过了 keepAliveTime才会被回收销毁；
        unit 等待时间的单位: keepAliveTime参数的时间单位。
        threadFactory :executor 创建新线程的时候会用到。
        handler 饱和策略:  当前同时运行的线程数量达到最大线程数量并且队列也已经被放满了任时的处理策略
            1.ThreadPoolExecutor.AbortPolicy    ：抛出 RejectedExecutionException来拒绝新任务的处理。
            2.ThreadPoolExecutor.CallerRunsPolicy   ：任何一个任务请求都会被执行 但影响性能存在延迟。调用执行自己的线程运行任务，就是直接在调用execute方法的线程中运行被拒绝的任务，如果执行程序已关闭则会丢弃该任务。
            3.ThreadPoolExecutor.DiscardPolicy  ： 不处理新任务，直接丢弃掉。
            4.ThreadPoolExecutor.DiscardOldestPolicy    ： 丢弃最早的未处理的任务请求。
    */
    ExecutorService es;

    //1.SingleThreadExecutor：创建使用单个线程的线程池，只用一个线程来执行任务
        /*
        FinalizableDelegatedExecutorService(
        new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()));
       */
    ExecutorService es1;

    //2.FixedThreadPool：创建固定数量的可复用的线程数
        /*
        ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        */
    ExecutorService es2;

    //3.CachedThreadPool：创建一个会根据需要创建新线程的线程池 最大线程数为Interge的最大值；空闲线程存活时间是1分钟
        /*
        ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        */
    ExecutorService es3;

    //4.ScheduledThreadPool：创建拥有固定线程数量的定时线程任务的线程池， 程序以起始时间为准则，每隔指定时间执行一次
        /*
        public ScheduledThreadPoolExecutor(int corePoolSize) {
            super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS, new DelayedWorkQueue());
        }
         */
    ScheduledExecutorService es4;

    //5.创建只有一个线程的定时线程任务的线程池
    ScheduledExecutorService es5;

    public JavaThreadPool() {

        this.es = new ThreadPoolExecutor(5, 20, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5), new ThreadPoolExecutor.CallerRunsPolicy());

        this.es1 = Executors.newSingleThreadExecutor();

        this.es2 = Executors.newFixedThreadPool(3);

        this.es3 = Executors.newCachedThreadPool();

        this.es4 = Executors.newScheduledThreadPool(2);
        System.out.println("时间：" + System.currentTimeMillis());

        this.es5 = Executors.newSingleThreadScheduledExecutor();
        System.out.println("时间：" + System.currentTimeMillis());

    }
}
