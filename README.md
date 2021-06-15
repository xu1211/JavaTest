@[toc]

# JavaTest
 java实验室

---

## [常用数据类型转换](./src/typeConversion)


## [继承](./src/extendsTest)
- [接口 AD](./src/extendsTest/AD.java)
- [接口 AP](./src/extendsTest/AP.java)
- [抽象类 Hero](./src/extendsTest/Hero.java)
- [实现类 adHero](./src/extendsTest/adHero.java)
- [实现类 apHero](./src/extendsTest/apHero.java)
- [启动类](./src/extendsTest/GameStart.java)

## [IO](./src/IO)
- [BIO 同步阻塞](./src/IO/BIO)

一请求一应答, 等待客户端的连接请求时会阻塞, 需要要为每个 Socket 连接开启一个线程
- [原生NIO 同步非阻塞](./src/IO/NIO)

复杂难用，bug多

- Netty NIO

## 新语法特性
- [lambda(jdk8)](./src/languageFeatures/lambda.java)
  
  匿名内部类的简化写法
- [stream(jdk8)](./src/languageFeatures/stream.java)
  
  把【集合，数组，I/O channel，产生器generator】转为stream流,
  使stream的每个元素都传入到操作方法里面执行一下

## [多线程](./src/Thread)

  - [多线程](./src/Thread/threadTest.java)
  - 线程池
    - [线程池简单实现](./src/Thread/threadPool/MyThreadTest.java)
    - [Java自带线程池](./src/Thread/threadPool/JavaThreadTest.java)
    - [execute 与 submit](./src/Thread/threadPool/submit.java)
  - [多线程通讯](./src/Thread/communication/communication.java)
  - [并发同步问题](./src/Thread/并发)
  - [ThreadLocal](./src/Thread/threadLocal/threadLocalTest.java)

## [动态代理](./src/proxy)
- [JDK 动态代理](./src/proxy/JDKProxy/proxy.java)
只能代理 实现了接口的类
- [CGLIB 动态代理](./src/proxy/CGLIBProxy/proxy.java)
可以代理 未实现任何接口的类

## [数据结构](./src/dataStructure)
- 数组 array
- 链表 linked list
- 栈 stack
- 堆 heap
- 队列 queue
- 树 tree
- 图 graph
- 布隆过滤器 BloomFiler
- [Java LinkedList实现 队列，栈](./src/dataStructure/collection/List/linkedList.java)

## [算法](./src/algorithm)
- [排序](./src/algorithm/sort)
    - [冒泡排序](./src/algorithm/sort/bubbleSort.java)
    - [插入排序](./src/algorithm/sort/insertionSort.java)
    - [选择排序](./src/algorithm/sort/selctionSort.java)
    - [快速排序](./src/algorithm/sort/quickSort.java)
- [搜索](./src/algorithm/)
    - 深度优先DFS
    - 广度优先BFS
- [递归]
- [动态规划]
- [二分查找]
- [贪心]
- 数学，几何

