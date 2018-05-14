package lin.java.test.javaConcurrency;

public class DeadLockDemo {

    public static void main(String[] args) {
        deadDemo();
    }

    private static String resource_a = "A";

    private static String resource_b = "B";

    public static void deadDemo() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource_a) {
                    System.out.println(resource_a);
                    try {
                        Thread.sleep(3000);
                        synchronized (resource_b) {
                            System.out.println(resource_b);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource_b) {
                    System.out.println(resource_b);
                    try {
                        Thread.sleep(3000);
                        synchronized (resource_a) {
                            System.out.println(resource_a);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
