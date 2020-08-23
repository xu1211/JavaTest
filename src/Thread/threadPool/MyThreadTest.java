package Thread.threadPool;

import java.util.concurrent.TimeUnit;

/*
线程池测试类
*/
public class MyThreadTest {

    public static void main(String[] args) {

        // 1.自己写一个线程池实现
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
    }

}