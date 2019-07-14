package day1;

public class day1 {

    public static void main(String[] args) {
        Thread helloThread = new HelloThread();

        helloThread.start();
        System.out.printf("1...hello multi-thread %s. %n",Thread.currentThread().getName());
    }


}

class HelloThread extends Thread{
    @Override
    public void run() {
        System.out.printf("2..hello multi-thread %s. %n",Thread.currentThread().getName());
    }
}
