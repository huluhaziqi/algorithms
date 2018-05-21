package lin.java.test.javaConcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RentrantLockDemo {

    public static void main(String[] args) {
        RentrantExample example = new RentrantExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> example.f());
        executorService.execute(() -> example.f());
    }
}

class RentrantExample {
    private Lock lock = new ReentrantLock();

    public void f() {
        lock.lock();
        for (int i = 0; i < 20; i++) {
            System.out.println(i + "");
        }
        lock.unlock();
    }

}
