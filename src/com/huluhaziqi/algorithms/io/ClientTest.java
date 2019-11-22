package com.huluhaziqi.algorithms.io;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ClientTest {
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 3333));
        ByteBuffer byteBuffer = ByteBuffer.allocate(128);
        byteBuffer.put("hello service this is client".getBytes());
        byteBuffer.flip();
        socketChannel.write(byteBuffer);

        ByteBuffer readBuffer = ByteBuffer.allocate(128);
        socketChannel.read(readBuffer);
        System.out.println(readBuffer);
        readBuffer.flip();
        StringBuilder stringBuilder = new StringBuilder();
        while (readBuffer.hasRemaining()) {
            System.out.println(readBuffer);
            stringBuilder.append((char) readBuffer.get());
        }
        System.out.println("from service " + stringBuilder.toString());
        socketChannel.close();
        ;


    }
}
