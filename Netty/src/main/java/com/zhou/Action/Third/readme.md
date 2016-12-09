### 第三章

* Netty Crash Course
```
Bootstrap引导程序==》Handlers来处理特定的事件（将对象转换成字符数组，也可以抛出异常）
ChannelPipeline和EventLoop和EventLoopGroup密切相关都是事件处理相关
```

* Channels Events and Input/Output
```
EventLoopGroup和一个Channel可以关联多个个单一的EventLoop，而EventLoop就是一个Channel执行实际工作的线程
当注册一个Channel后，Netty将这个Channel绑定到一个EventLoop
```

* Bootstrap and ServerBootstrap
```
Bootstrap用来连接远程主机，有1个EventLoopGroup
ServerBootstrap用来绑定本地端口，有2个EventLoopGroup
```

* 通道处理和数据流
```
ChannelPipeline的作用我们可以理解为用来管理ChannelHandler的一个容器
```

* 编码器，解码器和业务逻辑：细看Handlers
```
编码和解码：发送或接收消息后，Netty必须将消息数据从一种形式转化为另一种。
业务逻辑：
```