
## 并发同步问题
（https://blog.csdn.net/xyc1211/article/details/109131454）

>多个线程本身不会导致问题，只要资源没有发生变化,多个线程读取相同的资源就是安全的。\
**问题在于多个线程访问了相同的资源做了写操作。**\
如：同一内存区（变量，数组，或对象）、系统（数据库，web services等）或文件。

### Java多线程同步解决方案

- 悲观锁
    1. Synchronized锁
          - [同步代码块](./Synchronized代码块)
            - [class对象锁](./Synchronized代码块/SynchronizedClass.java)
            - [obj对象锁](./Synchronized代码块/SynchronizedObj.java)
            - [this对象锁](./Synchronized代码块/SynchronizedThis.java)
          - [同步方法](./Synchronized方法)
            - [静态方法](./Synchronized方法/SynchronizedStaticMethod.java)
            - [普通方法](./Synchronized方法/SynchronizedMethod.java)
    2. Lock锁
          - [lock](./Lock/lock.java)
          - [tryLock](./Lock/TryLockTest1.java)
          - [lock通讯](./Lock/LockCommunication.java) 类似[/src/Thread/communication/communication.java](../communication/communication.java)
- 乐观锁 CAS算法
    - [基于CAS思想的 Atomic 原子类](./CAS/CAS.java)
    - [ABA问题](./CAS/defectOfABA.java)