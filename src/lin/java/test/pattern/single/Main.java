package lin.java.test.pattern.single;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 1000; i++){
            executorService.submit(new Thread(){
                @Override
                public void run() {
                    super.run();
                    System.out.println(SingleTon3.A.getValue());
                    System.out.println(SingleTon3.B.getValue());
                }
            });
        }
    }
}
