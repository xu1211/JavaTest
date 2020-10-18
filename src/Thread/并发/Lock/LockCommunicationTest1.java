package Thread.并发.Lock;

import Thread.communication.communication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
线程池测试类
*/
public class LockCommunicationTest1 {

    public static void main(String[] args) throws InterruptedException {

        LockCommunication lc = new LockCommunication();

        // wait任务
        Runnable waitTask = new Runnable() {
            @Override
            public void run() {
                lc.await();
            }
        };
        // notify任务
        Runnable notifyTask = new Runnable() {
            @Override
            public void run() {
                lc.signal();
            }
        };

        // waiting 线程
        Thread t1 = new Thread(waitTask, "WT1");
        Thread t2 = new Thread(waitTask, "WT2");
        Thread t3 = new Thread(waitTask, "WT3");
        // notifying 线程
        Thread t4 = new Thread(notifyTask, "NT1");

        // starting all waiting 线程
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(3000);

        //starting notifying 线程
        t4.start();
    }
}