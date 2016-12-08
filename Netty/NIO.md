### NIO
* nio介绍
```
nio由以下几个核心部分组成:
    1:Channels:数据可以从Channel读到Buffer中，也可以从Buffer写到Channel中
    2:Buffers:数据是从通道读入缓冲区，从缓冲区写入到通道中
    3:Selectors:Selector允许单线程处理多个Channel。
```
* Channels
```

```
* Buffer
```
缓冲区本质是一块可以写入数据，然后可以从中读取数据的内存这块内存被包装成NIO Buffer对象
并提供了一组方法，用来方便的访问该块内存
1:capacity Buffer有一个固定的大小值：你只能往里写capacity个byte、long、char等类型
2:position position表示当前的位置 ，当一个byte、long等数据写入到Buffer后 position会向前
移动到下一个可插入数据的Buffer单元
3:limit 在写模式下，Buffer的limit表示你最多能往Buffer里写多少数据。 写模式下，limit等于Buffer的capacity。
当切换Buffer到读模式时， limit表示你最多能读到多少数据。因此，当切换Buffer到读模式时，limit会被设置成写模
式下的position值。换句话说，你能读到之前写入的所有数据（limit被设置成已写数据的数量，这个值在写模式下就是position）
```

* Selector
```
一个单独的线程可以管理多个channel，从而管理多个网络连接


```