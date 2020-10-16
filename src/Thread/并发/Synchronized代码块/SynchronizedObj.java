package Thread.并发.Synchronized代码块;

/*
同步块代码之间互斥，非同步块代码不互斥
*/
public class SynchronizedObj {
    int count = 0;

    public void Object(Object lock) throws InterruptedException {
        System.out.printf("线程%s开始     count=%s\n", Thread.currentThread().getName(), count);

        // 锁Object lock对象
        synchronized (lock) {
            System.out.printf("线程%s同步开始     count=%s\n", Thread.currentThread().getName(), count);
            Thread.sleep(2000);
            count++;
            System.out.printf("线程%s同步结束     count=%s\n", Thread.currentThread().getName(), count);
        }
        System.out.printf("线程%s结束     count=%s\n", Thread.currentThread().getName(), count);
    }
}