package proxy.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK 动态代理类
 * InvocationHandlerImpl 实现了 InvocationHandler 接口，并能实现方法调用从代理类到委托类的分派转发
 * 即：要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法
 */
public class InvocationHandlerImpl implements InvocationHandler {
    /**
     * 代理类中的真实对象
     */
    private final Object target;

    public InvocationHandlerImpl(Object target) {
        this.target = target;
    }

    /**
     * 动态代理对象调用原生方法的时候，最终实际上调用到的是 invoke() 方法
     * 调用处理器根据这三个参数进行预处理或分派到委托类实例上反射执行
     * @param proxy 代理类实例
     * @param method 被调用的方法对象
     * @param args 调用参数
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("调用之前 " + method.getName());
        // 当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        Object result = method.invoke(target, args);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("调用之后 " + method.getName());
        return result;
    }
}