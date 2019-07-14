package day2;

public class RaceConditionDemo {


    public static void main(String[] args) {
        int numberOfThreads = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[numberOfThreads];
        for(int i=0;i<numberOfThreads;i++){
            threads[i] = new WorkerThread(i,10);
        }

        for (Thread thread : threads){
            thread.start();
        }

    }

    static class WorkerThread extends Thread{

        private final int requestCount;

        public WorkerThread(int id,int requestCount){
            super("worker--"+id);
            this.requestCount=requestCount;
        }

        @Override
        public void run(){
            int i = requestCount;
            String requestID;

            RequestIDGenerator requestIDGenerator = RequestIDGenerator.getInstance();
            while (i-- > 0){
                requestID=requestIDGenerator.nextID();
                processRequest(requestID);
            }

        }

        private void processRequest(String requestID){
            try {
                // int random = (int)Math.random()*8;
                Thread.sleep(1000);
                System.out.printf("%s got RequestID: %s %n",Thread.currentThread().getName(),requestID);
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }


    }


}
