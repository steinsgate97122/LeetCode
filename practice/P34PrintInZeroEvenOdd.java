package practice;

import java.util.function.IntConsumer;

public class P34PrintInZeroEvenOdd {
    /*
    No.1116 print-zero-even-odd
    例如初始化5，需要输出0102030405
     */
    static class ZeroEvenOdd {
        private int n;
        final Object o = new Object();
        int status = 0;
        int cur = 1;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            synchronized (o) {
                for (int i = 0; i < n; i++) {
                    while (status != 0) {
                        o.wait();
                    }
                    printNumber.accept(0);
                    status = 1;
                    o.notifyAll();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            synchronized (o) {
                for (int i = 0; i < n / 2; i++) {
                    while (status != 1 || cur % 2 != 0) {
                        o.wait();
                    }
                    printNumber.accept(cur);
                    status = 0;
                    cur++;
                    o.notifyAll();
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            synchronized (o) {
                for (int i = 0; i < Math.ceil(n / 2.0); i++) {
                    while (status != 1 || cur % 2 != 1) {
                        o.wait();
                    }
                    printNumber.accept(cur);
                    status = 0;
                    cur++;
                    o.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(7);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
