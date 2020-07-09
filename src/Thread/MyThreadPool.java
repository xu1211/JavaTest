package Thread;

import java.util.LinkedList;

/*自己写个简单的线程池*/
public class MyThreadPool {

    // 线程池大小
    int threadPoolSize;

    // 任务容器
    LinkedList<Runnable> tasks = new LinkedList<Runnable>();

    // 消费任务的线程
    public MyThreadPool() {
        threadPoolSize = 10;

        // 启动10个任务消费者线程
        synchronized (tasks) {
            for (int i = 0; i < threadPoolSize; i++) {
                new TaskConsumeThread("任务消费者线程 " + i).start();
            }
        }
    }

    public void add(Runnable r) {
        synchronized (tasks) {
            tasks.add(r);
            // 唤醒等待的任务消费者线程
            tasks.notifyAll();
        }
    }

    /**
     * 内部类
     * 作用：创建线程，从任务容器
     */
    class TaskConsumeThread extends Thread {
        public TaskConsumeThread(String name) {
            super(name);
        }

        Runnable task;

        public void run() {
            System.out.println("启动： " + this.getName());
            while (true) {
                synchronized (tasks) {
                    // 没有任务则等待
                    while (tasks.isEmpty()) {
                        try {
                            System.out.println(this.getName() + "没有任务，进入等待状态");
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 有任务则拿走任务
                    task = tasks.removeLast();
                    // 允许添加任务的线程可以继续添加任务
                    tasks.notifyAll();

                }
                System.out.println(this.getName() + " 获取到任务，并执行");
                task.run();
            }
        }
    }

}