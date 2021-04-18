package proxy.JDKProxy;

import proxy.JDKProxy.InvocationHandlerImpl;
import proxy.real.SmsServiceInterface;
import proxy.real.SmsServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author xuyuc
 * @since 2020/10/19 22:24
 */
public class proxy {
    public static void main(String args[]) {
        // 创建真实对象
        SmsServiceImpl sms = new SmsServiceImpl();
        // 传入真实对象，生成handler
        InvocationHandler handler = new InvocationHandlerImpl(sms);
        System.out.println("要代理的接口：" + sms.getClass().getInterfaces()[0]);

        /**
         * Proxy.newProxyInstance 方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例
         */
        SmsServiceInterface smsService = (SmsServiceInterface) Proxy.newProxyInstance(
                sms.getClass().getClassLoader(), // 目标类的类加载
                sms.getClass().getInterfaces(), // 代理需要实现的接口，可指定多个
                handler); // 代理对象对应的自定义 InvocationHandler

        System.out.println("生成的动态代理对象：" + smsService.getClass().getName());

        // 通过动态代理对象 调用方法
        smsService.send("hello jdk代理");
        smsService.withdraw("发错了，撤回");
    }
}
