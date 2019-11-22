package com.huluhaziqi.algorithms.io;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class WebClient {
    public static void main(String[] args) throws Exception{
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8000));
        ByteBuffer byteBuffer = ByteBuffer.allocate(128);
        byteBuffer.put("hello service this is client".getBytes());
        byteBuffer.flip();
        ByteBuffer readBuffer = ByteBuffer.allocate(128);
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            byteBuffer.rewind();
            socketChannel.write(byteBuffer);
            readBuffer.clear();
            socketChannel.read(readBuffer);
            stringBuilder.append((char) readBuffer.get());
            System.out.println(stringBuilder.toString());
        }
    }
}
