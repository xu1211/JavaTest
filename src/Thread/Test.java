package Thread;

import Thread.JavaThreadPool;

import java.util.concurrent.TimeUnit;

class Demo1 extends Thread {

    @Override  //把自定义线程的任务代码写在run方法中
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("自定义线程：" + i);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        //main线程
        for (int i = 0; i < 100; i++) {
            System.out.println("main线程：" + i);
        }

        //自定义线程
        Demo1 d = new Demo1();
        d.start();

    }
}
