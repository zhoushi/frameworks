package com.zhou.Action.Third;


import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by Administrator on 2016/12/9.
 */
public class PlaioNioServer {

    public void server(int port)throws Exception{
        System.out.println("Listening for connections on port"+port);

        Selector selector = Selector.open();

        ServerSocketChannel serverChannel = ServerSocketChannel.open();

        ServerSocket serverSocket = serverChannel.socket();
        serverSocket.bind(new InetSocketAddress(port));
        serverChannel.configureBlocking(false);

        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        final ByteBuffer msg = ByteBuffer.wrap("Hi!\r\n".getBytes());
        while (true){
            int n = selector.select();
            if (n>0){
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();

                while (iter.hasNext()){
                    SelectionKey key = iter.next();
                    iter.remove();

                    try {
                        if (key.isAcceptable()){
                            ServerSocketChannel server = (ServerSocketChannel) key.channel();
                            SocketChannel client = server.accept();
                            System.out.println("Accepted connection from"+client);
                            client.configureBlocking(false);
                            client.register(selector,SelectionKey.OP_WRITE,msg.duplicate());
                        }
                        if (key.isWritable()){
                            SocketChannel client = (SocketChannel) key.channel();
                            ByteBuffer buff = (ByteBuffer) key.attachment();
                            while (buff.hasRemaining()){
                                if (client.write(buff)==0){
                                    break;
                                }
                            }
                            client.close();
                        }

                    }catch (Exception e){
                        key.cancel();
                        key.channel().close();
                    }
                }
            }
        }
    }
}
