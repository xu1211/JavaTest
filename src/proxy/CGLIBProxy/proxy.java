package proxy.CGLIBProxy;

import net.sf.cglib.proxy.Enhancer;
import proxy.real.SmsService;

/**
 * @author xuyuc
 * @since 2020/10/20 21:54
 */
public class proxy {
    public static void main(String args[]) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(SmsService.class.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(SmsService.class);
        // 设置方法拦截器
        enhancer.setCallback(new MethodInterceptorImpl());
        // 创建代理对象
        SmsService SmsService = (SmsService) enhancer.create();

        // 通过代理对象 调用方法
        SmsService.send("hello cglib代理");
        SmsService.withdraw("发错了，撤回");
    }
}
