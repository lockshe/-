package day1;


import day3.VisibilityDemo;

import java.lang.invoke.CallSite;
import java.util.Random;

public class RunTimeTest {
    // 两者区别
    public static void main(String[] args) {

        Thread t;
        CountRun countRun;
        final int number = Runtime.getRuntime().availableProcessors();
        System.out.println(number);
        // 共用一个Runnable接口
        for(int i=0;i<2*number;i++){
            countRun = new CountRun();
            t = new Thread(countRun);
            t.start();
        }

        //使用Thread类
        for (int i=0;i<2*number;i++){

            t=new CountThread();
            t.start();
        }
    }

    static class Counter{

        int counter=0;

        public void increment(){
            counter++;
        }

        public int getCounter(){
            return counter;
        }
    }

    static class CountRun implements Runnable{
        private Counter counter = new Counter();

        @Override
        public void run() {
            for (int i=0;i<100;i++){
                counter.increment();
                rest();
            }
            System.out.println("CountRun--->"+counter.getCounter());
        }

        private void rest(){
            int time= (int)Math.random()*8;
            try {
                Thread.sleep(time);
            }catch (Exception e){
                System.out.println(e);
            }

        }
    }

    static class CountThread extends Thread{
        private Counter counter = new Counter();

        @Override
        public void run() {
            for (int i=0;i<100;i++){
                counter.increment();
                rest();
            }
            System.out.println("CountThread--->"+counter.getCounter());
        }

        private void rest(){
            int time= (int)Math.random()*8;
            try {
                Thread.sleep(time);
            }catch (Exception e){
                System.out.println(e);
            }

        }
    }
}
