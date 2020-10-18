package Thread.并发.Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xuyuc
 * @since 2020/10/18 13:34
 */
public class LockCommunication {
    Lock mLock = new ReentrantLock();
    Condition condition = mLock.newCondition();

    public void await() {
        try {
            //上锁
            mLock.lock();
            System.out.printf("线程%s开始等待,时间：%s\n", Thread.currentThread().getName(), System.currentTimeMillis());

            //临时释放对象 lock，并等待
            condition.await();

            System.out.printf("线程%s结束等待,时间：%s\n", Thread.currentThread().getName(), System.currentTimeMillis());
        } catch (Exception ex) {
        } finally {
            //释放锁
            mLock.unlock();
            System.out.println(Thread.currentThread().getName() + "执行完毕，释放锁");
        }
    }

    //通知方法
    public void signal() {
        try {
            mLock.lock();
            Thread.sleep(3000);
            System.out.println("通知线程结束等待，时间：" + System.currentTimeMillis());

            // 只唤醒一个等待线程
            //condition.signal();
            // 唤醒所有等待线程
            condition.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mLock.unlock();
        }
    }
}


