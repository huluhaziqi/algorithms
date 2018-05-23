package lin.java.test.pattern;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SingleTonExample {

    public static void main(String[] args) {
        Executor executor = Executors.newCachedThreadPool();
//        SingleTon singleTon =
    }

    class MyThread extends Thread{
        @Override
        public void run() {

        }
    }
}
