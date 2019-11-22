package com.huluhaziqi.algorithms.io;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServiceTest {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1", 3333));

        SocketChannel socketChannel = serverSocketChannel.accept();

        ByteBuffer byteBuffer = ByteBuffer.allocate(128);
        byteBuffer.put("hello client this is service".getBytes());
        byteBuffer.flip();
        socketChannel.write(byteBuffer);

        ByteBuffer readBuffer = ByteBuffer.allocate(128);
        socketChannel.read(readBuffer);
        readBuffer.flip();
        StringBuilder stringBuilder = new StringBuilder();
        while (readBuffer.hasRemaining()) {
            stringBuilder.append((char) readBuffer.get());
        }
        System.out.println("from client " + stringBuilder.toString());


        socketChannel.close();
        serverSocketChannel.close();
    }
}
