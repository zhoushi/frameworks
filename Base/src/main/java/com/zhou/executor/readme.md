### Task Execution

* Executor框架
```
Executor基于生产者-消费者模式，提交任务的执行者是生产者，执行任务的线程是消费者

执行策略 ： 一个执行策略指明了任务执行的“what,where,when,how”几个因素。

线程池:管理一个工作线程的同构池(homogeneous pool)线程池是与工作队列(work queue)紧密绑定
```

* Callable 和 Future 可携带结果的任务