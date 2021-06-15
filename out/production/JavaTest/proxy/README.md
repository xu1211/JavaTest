# 类路径

## JDK代理
- real `真实对象`
    - SmsServiceInterface   `服务接口`
    - SmsServiceImpl        `服务实现类`
- JDKProxy  `代理对象`
    - InvocationHandlerImpl `动态代理类`
    - proxy `使用代理对象`


## CGlib代理
- real `真实方法`
    - SmsService   `服务方法`
- CGLIBProxy  `代理对象`
    - MethodInterceptorImpl `动态代理类`
    - proxy `使用代理对象`