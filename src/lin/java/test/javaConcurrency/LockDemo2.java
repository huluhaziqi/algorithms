package lin.java.test.javaConcurrency;

public class LockDemo2 {


    public static void main(String[] args) {
        // 线程a
        Thread td1 = new Thread(new Runnable() {
            public void run() {
                LockDemo2.method1();
            }
        });
        // 线程b
        Thread td2 = new Thread(new Runnable() {
            public void run() {
                LockDemo2.method2();
            }
        });

        td1.start();
        td2.start();
    }

    public static void method1() {
        synchronized (String.class) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程a尝试获取integer.class");
            synchronized (Integer.class) {
                System.out.println("线程a获取到integer.class");
            }

        }
    }

    public static void method2() {
        // 不再获取线程a需要的Integer.class锁。
        synchronized (String.class) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程b尝试获取Integer.class");
            synchronized (Integer.class) {
                System.out.println("线程b获取到Integer.class");
            }

        }
    }

}

