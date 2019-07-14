package day1;

public class RunThread {

    public static void main(String[] args) {

        // Thread welcome = new Thread(new day1.Welcome());
        Welcome welcome = new Welcome();
        //注意是start不是run
        // welcome.start()
        welcome.run();


        System.out.printf("1...hello multi-thread %s. %n",Thread.currentThread().getName());
    }

}

class Welcome implements Runnable{
    // 线程是一次性资源 run 方法运行结束被jvm回收
    @Override
    public void run() {
        System.out.printf("2..hello multi-thread %s. %n",Thread.currentThread().getName());

    }
}
