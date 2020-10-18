package Thread.并发.Synchronized方法;

/*
静态方法是属于类的而不属于对象，synchronized修饰的静态方法锁定的是这个类的所有对象
*/
public class SynchronizedStaticMethod {
    static int count = 0;

    // Synchronized锁 addCount()方法
    public synchronized static void addCount() throws InterruptedException {
        System.out.printf("线程%s开始     count=%s\n", Thread.currentThread().getName(), count);
        Thread.sleep(2000);
        count++;
        System.out.printf("线程%s结束     count=%s\n", Thread.currentThread().getName(), count);
    }

}