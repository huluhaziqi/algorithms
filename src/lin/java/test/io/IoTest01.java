package lin.java.test.io;

import java.nio.ByteBuffer;

public class IoTest01 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        byteBuffer.clear();
        byteBuffer.position(5);
        System.out.println(byteBuffer);
        byteBuffer.mark();
        System.out.println(byteBuffer);
        byteBuffer.position(10);
        System.out.println(byteBuffer);
        byteBuffer.reset();
        System.out.println(byteBuffer);
        byteBuffer.clear();
        System.out.println(byteBuffer);
        byteBuffer.limit(32);
        System.out.println(byteBuffer);
        byteBuffer.position(10);
        System.out.println(byteBuffer);
        byteBuffer.position(15);
        System.out.println(byteBuffer);

        System.out.println("test");
        byteBuffer.clear();
        byteBuffer.put("abc".getBytes());
        System.out.println(byteBuffer);
        byteBuffer.flip();
        System.out.println((char) byteBuffer.get());
        System.out.println(byteBuffer.position());
        System.out.println((char) byteBuffer.get());
        System.out.println((char) byteBuffer.get());
        System.out.println(byteBuffer.position());
        //将position设置成0，mark为-1
        byteBuffer.rewind();
        System.out.println((char) byteBuffer.get(2));
        System.out.println(byteBuffer.position());

    }
}
