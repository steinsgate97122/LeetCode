package practice;

public class P32PrintInOrder {
    /*
    No.1114 print-in-order
    启动3个线程，分别会调用foo的first second third方法
    线程的启动顺序不一定是first → second → third
    但需要保证最终的打印顺序是first second third
    对于多线程问题，一般用synchronized(lock)来保证同一时间只有一个线程在指向代码块
    在synchronized代码块内，可以用wait让当前线程等待并释放锁；用notify唤醒1个等待线程；用notifyAll唤醒所有等待线程
    在定义一个状态位，每个方法进入时都先确认是不是可执行的state，如果不是就wait，如果是的话就正常执行后修改state，并且notifyAll即可
     */
    static class Foo {
        final Object o = new Object();
        int state = 1;

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            synchronized (o) {
                while (state != 1) {
                    o.wait();
                }
                printFirst.run();
                state = 2;
                o.notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (o) {
                while (state != 2) {
                    o.wait();
                }
                printSecond.run();
                state = 3;
                o.notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (o) {
                while (state != 3) {
                    o.wait();
                }
                printThird.run();
            }
        }
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        // 下面三个Thread顺序可以任意掉换
        new Thread(() -> {
            try {
                foo.second(() -> System.out.println("Two"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.first(() -> System.out.println("One"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.third(() -> System.out.println("Three"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
