### 基础知识

* NIO
```
Channels and Buffers(通道和缓冲区):标准的IO基于字节流和字符流进行操作，而NIO是基于通道和缓冲区进行操作，数据总是从通道读
取到缓冲区中，或者从缓冲区写入到通道中
Selectors(选择器):选择器用于监听多个通道的事件，因此，单个的线程可以监听多个数据通道
```

* 线程
```
同步和异步
同步调用:同步方法调用一旦开始，调用者必先等到方法调用返回后，才能继续后续的行为
异步调用:异步方法调用更像一个消息传递，一旦开始，方法调用就会立即返回，调用者就可以继续后续的操作，二异步方法通常会在另
外一个线程中“真实”地执行

并发(Concurrency)和并行(Parallelism)
并发:
并行:并行的多个任务是真实的同时执行，而对于并发来说，这个过程只是交替的

死锁、饥饿和活锁
```

* JMM
```
JAVA的内存模型
    原子性(Atomicity)：指一个操作不可中断的，即使是在多个线程一起执行的时候，一个操作一旦开始，就不会被其他线程干扰。
    可见性(Visibility)：指当一个线程修改了某一个共享变量的值，其他线程是否能够立即知道这个修改
    有序性(Ordering)：
    
    volatile与JMM
    
```

* JDK并发包
```
允许多个线程同时访问：信号量(Semaphore)

ReadWriteLock读写锁：读写分离锁，可以有效地帮助减少锁竞争，以提升系统性能

线程池：为了避免系统频繁地创建和销毁线程，我们可以让创建的线程进行复用

比较交换(CAS)：与众不同的并发策略
```

* Disruptor
```
无锁的缓存框架：Disruptor
```

* Executor
```
线程执行者
```

* 类加载和字节码
```
一个.class文件定义了JVM中的一个类型，包括域，方法，继承信息等
```

* 设计模式
```
NIO中使用的Reactor模式
AIO中使用的Proactor模式
```

* 阿里巴巴java开发手册
```
集合处理：1：Set存储的是不重复的对象，依据hashCode和equals进行判断，所以Set存储的对象必须重写这两个方法，如果自定义对象
为map的键则要重写hashcode和equals
          2：使用集合转数组的方法，必须使用集合的toArray(T[] array),传入的是类型完全一样的数组，大小就是list.size()
          3：使用工具类Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方法
          4：在JDK7版本以上，Comparator要满足自反性，传递性，对称性，不然Arrays.sort,Collections.sort会报IllegaArgumentE
          xception异常

工程规约： 1：分层领域模型规约
                DO(Data Object):与数据库表结构一一对应，通过DAO层向上传输数据源对象
                DTO(Data Transfer Object):数据传输对象，Service和Manager向外传输的对象
                BO(Business Object):业务对象 可以由Service层输出的封装业务逻辑的对象
                VO(View Object):显示层对象，通常是web向模板渲染引擎层传输的对象
```