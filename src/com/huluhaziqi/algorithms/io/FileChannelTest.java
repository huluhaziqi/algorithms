package com.huluhaziqi.algorithms.io;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {

    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("src/1.txt", "rw");
        FileChannel fileChannel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(32);
        int readBytes = fileChannel.read(buffer);
        while (readBytes != -1) {
            System.out.println("readBytes + " + readBytes);
            buffer.flip();
            while (buffer.hasRemaining()){
                System.out.println((char) buffer.get());
            }
            buffer.clear();
            readBytes = fileChannel.read(buffer);
        }

        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        byteBuffer.put("fssfds".getBytes());
        byteBuffer.flip();
        fileChannel.write(byteBuffer);
        fileChannel.close();

    }
}
