package Thread.threadPool;

import java.util.concurrent.*;

/**
 * @author xuyuc
 *
 * 线程池执行任务几种方式：
 * 1.execute(Runnable)
 * 2.submit(Runnable)
 * 3.submit(Runnable,result)
 * 4.submit(Callable)
 *
 * Runnable任务没返回值，Callable任务有返回值；
 * execute()不能获取任务状态，submit()方法可以通过get()获取任务状态；
 * get()方法有阻塞性，调用后主线程会阻塞，等到任务执行完毕拿到了返回值，主线程才会继续运行
 */
public class submit {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
         /*
           创建线程池
         */
        ExecutorService es = new ThreadPoolExecutor(5, 20, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5));

        /*
          void execute(Runnable command) 提交任务
            执行没有返回
        */
        es.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " execute(Runnable command) 正在执行任务,无返回");
            }
        });

        /*
          Future<?> submit(Runnable task) 提交任务
            get()得到的返回值为null
        */
        Future future1 = es.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " submit(Runnable task) 正在执行任务");

            }
        });
        System.out.println("submit(Runnable task) 返回值： " + future1.get());

        /*
          <T> Future<T> submit(Runnable task, T result) 提交任务
            通过一个T result载体获取返回值； 其实不能算返回值，是交给线程处理
        */
        final String[] result = new String[1];
        Runnable r = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " submit(Runnable task, T result) 正在执行任务");
                result[0] = "result SUCCESS";
            }
        };
        Future<String[]> future2 = es.submit(r, result);
        String[] result1 = future2.get();
        System.out.println("submit(Runnable task, T result) 返回值： " + result1[0]);

        /*
          <T> Future<T> submit(Callable<T> task) 提交任务
            get()获取返回结果
        */
        Future<String> future = es.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName() + " 正在执行任务");
                Thread.sleep(3000);
                return "Callable SUCCESS";
            }
        });
        System.out.println("submit(Callable<T> task) 返回值： " + future.get());

    }
}
