package lin.java.test.javaConcurrency;

import java.util.concurrent.*;

public class FutureTest {

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("thread 方式");
            }
        };
        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1");
            }
        });
        thread1.start();

        try {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "callable";
                }
            });
            executorService.submit(futureTask);
            System.out.println(futureTask.get());
            Future<String> future = executorService.submit(new Callable<String>() {
                @Override
                public String call() {
                    return "callable";
                }
            });

            Thread thread2 = new Thread(futureTask);
            thread2.start();
            String result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
