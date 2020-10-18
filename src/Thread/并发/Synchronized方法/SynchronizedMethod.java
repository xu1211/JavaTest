package Thread.并发.Synchronized方法;

/*
锁方法，方法属于对象， 等同this 对当前实例对象加锁
*/
public class SynchronizedMethod {
    int count = 0;

    // Synchronized锁 addCount()方法
    public synchronized void addCount() throws InterruptedException {
        System.out.printf("线程%s开始     count=%s\n", Thread.currentThread().getName(), count);
        Thread.sleep(2000);
        count++;
        System.out.printf("线程%s结束     count=%s\n", Thread.currentThread().getName(), count);
    }

    /*
    * 等同方法全加this锁
    */
    public void addCount1() throws InterruptedException {
        synchronized(this) {
            System.out.printf("线程%s开始     count=%s\n", Thread.currentThread().getName(), count);
            Thread.sleep(2000);
            count++;
            System.out.printf("线程%s结束     count=%s\n", Thread.currentThread().getName(), count);
        }
    }
}