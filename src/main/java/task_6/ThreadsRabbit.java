package task_6;

import java.io.IOException;

/**
 * multithreading class about rabbit, which eats carrot until we press enter
 */
public class ThreadsRabbit {
    private volatile static boolean flag = true;

    public static void main(String[] args) {
        new ThreadsRabbit.StopEating().start();
        new ThreadsRabbit.Eating().start();
    }

    public static class StopEating extends Thread {
        public void run() {
            try {
               int key = System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            flag = false;
        }
    }

    public static class Eating extends Thread {
        public void run() {
            while (flag) {
                System.err.println("eating....");
                try {
                    Thread.sleep(190);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
