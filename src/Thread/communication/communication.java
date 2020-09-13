package Thread.communication;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author xuyuc
 *
 * sleep() 沉睡一段实践，不释放锁
 * wait() 暂停执行，释放锁
 * notify() 唤醒一个
 * notifyAll() 唤醒所有
 */
public class communication {
    // waiting线程执行条件
    private volatile boolean go = false;

    public static void main(String args[]) throws InterruptedException {
        final communication test = new communication();

        Runnable waitTask = new Runnable() {
            @Override
            public void run() {
                try {
                    test.shouldGo();
                } catch (InterruptedException ex) {
                    Logger.getLogger(communication.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(Thread.currentThread() + " 执行完毕");
            }
        };

        Runnable notifyTask = new Runnable() {
            @Override
            public void run() {
                test.go();
                System.out.println(Thread.currentThread() + " 唤醒完毕");
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

        // 主线程sleep，确保 waiting 线程 全部启动完成
        Thread.sleep(200);

        //starting notifying 线程
        t4.start();

    }

    /*
     * 只能在 synchronized 或 bock 中调用 wait / notify
     */
    private synchronized void shouldGo() throws InterruptedException {
        System.out.println(Thread.currentThread() + " 获取锁");
        while (go != true) {
            System.out.println(Thread.currentThread() + " 不满足执行条件，wait()");
            // 暂停执行，释放锁
            wait();
            System.out.println(Thread.currentThread() + " 被唤醒");
        }

        // 重置waiting线程执行条件为false
        go = false;
    }

    /*
     * both shouldGo() and go() are locked on current object referenced by "this" keyword
     */
    private synchronized void go() {
        System.out.println(Thread.currentThread() + " 开始唤醒线程");
        while (go == false) {
            // waiting线程执行条件为true
            go = true;

            // 只唤醒 WT1, WT2, WT3 中的一个
            //notify();

            // 唤醒 WT1, WT2, WT3 所有
            notifyAll();
        }

    }


}

