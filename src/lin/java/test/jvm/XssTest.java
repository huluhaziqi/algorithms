package lin.java.test.jvm;

import java.util.ArrayList;
import java.util.List;

public class XssTest {
    public static void main(String[] args) {

        List<byte[]> list = new ArrayList<>();
        for (int i = 1; i < 1000; i++) {
            byte[] tem = new byte[1024 * 1024];
            list.add(tem);
//            if(i == 3){
//                list.clear();
//            }
            System.out.println("i = " + i);
        }
//        System.gc();
        System.out.println("end");
    }

    public static int count = 0;

    public static void f() {
        count++;
        System.out.println(count);
        f();
    }
}
