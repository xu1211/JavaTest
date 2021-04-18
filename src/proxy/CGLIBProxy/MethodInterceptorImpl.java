package proxy.CGLIBProxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MethodInterceptorImpl implements MethodInterceptor {
    /**
     * @param proxy 被代理的对象（需要增强的对象）
     * @param method 被拦截的方法（需要增强的方法）
     * @param args 方法入参
     * @param methodProxy 用于调用原始方法
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("===============================================");
        //调用方法之前，我们可以添加自己的操作
        System.out.println("调用之前>>>>>");
        System.out.println("传入的方法：" + method.getName());
        System.out.println("传入参数：" + args[0]);
        Object object = methodProxy.invokeSuper(proxy, args);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("调用之后>>>>>");
        return object;
    }
}
