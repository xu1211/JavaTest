package Thread.并发.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xuyuc
 * @since 2020/10/18 13:34
 */
public class lock {
    // 使用了同一mLock对象的锁块之间是互斥的。
    Lock mLock = new ReentrantLock();
    int count = 0;

    public void addCount() throws InterruptedException {
        //上锁
        mLock.lock();

        //选择性的获取锁，如果一段时间获取不到，可以放弃
        mLock.tryLock();

        System.out.printf("线程%s开始     count=%s\n", Thread.currentThread().getName(), count);
        Thread.sleep(2000);
        count++;
        System.out.printf("线程%s结束     count=%s\n", Thread.currentThread().getName(), count);

        //释放锁
        mLock.unlock();
    }

    public void tryAddCount() {
        //选择性的获取锁，如果一段时间获取不到，可以放弃
        if(mLock.tryLock()) {
            try{
                System.out.printf("线程%s开始     count=%s\n", Thread.currentThread().getName(), count);
                Thread.sleep(2000);
                count++;
                System.out.printf("线程%s结束     count=%s\n", Thread.currentThread().getName(), count);

            }catch(Exception ex){

            }finally{
                //释放锁
                mLock.unlock();
            }
        }else {
            //else时为未获取锁，则无需去关闭锁
            //如果不能获取锁，则直接做其他事情
            System.out.printf("线程%s未获取锁,不执行\n", Thread.currentThread().getName(), count);
        }

    }
}


