package lin.java.test.javaConcurrency;

public class JoinDemo {
    public static void main(String[] args) {
        Thread pre = Thread.currentThread();
        for (int i = 0; i < 1000000; i++) {
            Thread cur = new JoinThread(pre);
            cur.start();
            pre = cur;
        }
    }

    public static class JoinThread extends Thread {
        private Thread thread;

        public JoinThread(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
//                thread.join();
                System.out.println(thread.getName() + " terminated");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
