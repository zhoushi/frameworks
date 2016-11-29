### netty权威指南

* 第一章

```
linux io: i/o多路复用技术（select）
概念: 通过把多个I/O的阻塞复用到同一个select的阻塞上，从而使得系统在单线程的情况下可以
同时处理多个客户端请求
应用场景:服务器需要同时处理多个处于监听状态或者多个连接状态的套接字
         服务器需要同时处理多种网络协议的套接字
         
         epoll的API更加简单：包括创建一个epoll描述符、添加监听事件、阻塞等待所监听的事件

java io: 
```

* 第二章
```
BIO:网络编程的基本模型是Client/Server模型，也就是两个进程之间进行相互通信

伪异步的io：采用线程池和任务队列可以实现一种叫做伪异步I/O通信框架：
将客户端的Socket封装成一个Task投递到后端的线程池中进行处理

NIO:NEW IO

缓冲区Buffer:Buffer是一个对象，它包含一些要写入或者要读出的数据
缓冲区实质上是一个数组

通道Channel:Channel是一个通道，可以通过它读取和写入数据，网络数据通过Channel读取和写入

多路复用器Selector:Selector会不断地轮询注册在其上的Channel,如果某个Channel上面有新的TCP
连接接入、读和写事件，这个Channel就处于就绪状态，会被Selector轮询出来，然后通过SelectionKey
可以获取就绪Channel的集合
```