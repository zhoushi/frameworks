### Netty In Action

* 第三章
```
Netty 的10个核心类
1：Bootstrap 用来连接远程主机，有一个EventLoopGroup 
1.1：ServerBootstrap 有2个EventLoopGroup
2：EventLoop
3：EventLoopGroup
4：ChannelPipeline
5：Channel
6：Future or ChannelFuture
7：ChannelInitializer
8：ChannelHandler

Channel:传输API
ChannelHandler:{
1:传输数据时，将数据从一种格式转换到另一种格式
2:异常通知
3:Channel变为有效或者无效时获得通知
4:Channel被注册或从EventLoop中注销时获得通知
5:通知用户特定事件
}

ChannelHandler实例添加到ChannelPipeline中，
ChannelPipeline实现了过滤器模式，
```
