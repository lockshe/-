package day3;


public class VisibilityDemo {

    public static void main(String[] args) throws InterruptedException{
        TimeConsumingTask timeConsumingTask = new TimeConsumingTask();
        Thread thread = new Thread(timeConsumingTask);
        thread.start();
        Thread.sleep(10000);
        timeConsumingTask.cancel();
    }

    static class TimeConsumingTask implements Runnable{

        private boolean toCancel = false;

        @Override
        public void run() {
            while (!toCancel){ // 会导致循环不变表达式外提优化
                if(doExecute()){
                    break;
                }
            }


            if(toCancel){
                System.out.println("sys is canceled");
            }else{
                System.out.println("task done");
            }
        }

        private boolean doExecute(){
            boolean isDone = false;
            System.out.println("is executing.................");
            try {
                int time = (int)Math.random()*8;
                Thread.sleep(time);
            }catch (InterruptedException e){
                System.out.println(e);
            }finally {
                return isDone;
            }
        }

        public void cancel(){
            toCancel = true;
            System.out.println(this+"....is canceled.");
        }
    }
}
