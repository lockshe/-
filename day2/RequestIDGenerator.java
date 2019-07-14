package day2;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class RequestIDGenerator {

    // 单例模式
    private final static RequestIDGenerator instance = new RequestIDGenerator();

    private final static short SEQ_LIMIT = 999;

    private static short seq = -1;

    // 对外屏蔽构造方法
    // 私有构造器
    private RequestIDGenerator(){

    }

    // 导致竞争态
//    private short nextSequence(){
//        if(seq<=SEQ_LIMIT){
//            seq++;
//        }else{
//            seq=0;
//        }
//
//        return seq;
//    }

    // 加锁消除竞态
    private synchronized short nextSequence(){
        if(seq<=SEQ_LIMIT){
            seq++;
        }else{
            seq=0;
        }

        return seq;
    }

    public static  RequestIDGenerator getInstance(){
        return instance;
    }

    public String nextID(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        String timestamp = sdf.format(new Date());
        DecimalFormat df = new DecimalFormat("000");
        short seqNo = nextSequence();
        return timestamp+df.format(seqNo);

    }

    public static void main(String[] args) {
        System.out.println(RequestIDGenerator.getInstance().nextID());
    }
}
