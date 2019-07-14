package day2;

import com.sun.javafx.geom.transform.CanTransformVec3d;

public class day2 {

    private static int count;

    private static int countDown(){
        return count--;
    }
    public static void main(String[] args) {
        count = args.length>=1?Integer.valueOf(args[0]):60;

        System.out.printf("count is %d %n",count);
        int remaining;

        while (true){
            remaining=countDown();
            if(remaining == 0){
                break;
            }else {
                System.out.println("Remaining "+count+"seconds(s)");
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        System.out.println("Done");
    }
}
