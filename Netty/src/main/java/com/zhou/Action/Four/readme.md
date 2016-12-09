### Transports(传输)

* Transport API
```
传输API的核心是Channel接口
每个Channel都会分配一个ChannelPipeline和ChannelConfig,ChannelConfig负责设置并存储配置，
并允许在运行期间更新它们。ChannelPipeline容纳了使用的ChannelHandler实例，这些ChannelHandler
将处理通道传递的“入站”和“出站”数据，ChannelHandler的实现允许你改变数据状态和传输数据

ChannelHandler作用:
1:传输数据时，将数据从一种格式转换到另一种格式
2:异常通知
3:Channel变为有效或无效时获得通知
4:Channel被注册或从EventLoop中注销时获得通知
5:通知用户特定事件
```