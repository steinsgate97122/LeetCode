package practice;

public class P33PrintInFooBar {
    /*
    No.1115 print-foobar-alternately
    期望输出n次foobar，应该是2个线程分别调用foo和bar，同样要维护一个状态位
     */
    static class FooBar {
        private int n;
        final Object o = new Object();
        int status = 0;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            synchronized (o) {
                for (int i = 0; i < n; i++) {
                    while (status != 0) {
                        o.wait();
                    }
                    printFoo.run();
                    status = 1;
                    o.notifyAll();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            synchronized (o) {
                for (int i = 0; i < n; i++) {
                    while (status != 1) {
                        o.wait();
                    }
                    printBar.run();
                    status = 0;
                    o.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(3);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.foo(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("foo");
                        }
                    });
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t2.start();
        t1.start();
    }
}
