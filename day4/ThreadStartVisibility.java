package day4;

public class ThreadStartVisibility {

    static int data=0;

    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep((int)Math.random()*8);
                    while (true) {
                        System.out.println(data);
                    }
                }catch (InterruptedException e){
                    System.out.println(e);
                }

            }
        };

        data=1;
        thread.start();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){

        }
        data=2;
    }

}
