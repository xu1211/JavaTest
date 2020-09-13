package Thread;

/**
 * 多线程案例
 *
 * main线程 与 自定义线程 同时运行
 */
class threadDemo extends Thread {

    @Override  //把自定义线程的任务代码写在run方法中
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("自定义线程：" + i);
        }
    }
}

public class threadTest {
    public static void main(String[] args) {
        //main线程
        for (int i = 0; i < 100; i++) {
            System.out.println("main线程：" + i);
        }

        //自定义线程
        threadDemo d = new threadDemo();
        d.start();

    }
}
