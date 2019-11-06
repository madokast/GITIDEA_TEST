package zrx.com.leetcode.utils;

/**
 * Description
 * 需求类，不满足抛出异常
 * <p>
 * Data
 * 2019/11/6 10:48
 *
 * @author zrx
 * @version 1.0
 */

public class MyRequire {
    public static void greaterThanZero(int num){
        if(num<=0){
            throw new RuntimeException(num+"<=0");
        }

    }

    public static void greater(int smaller,int bigger){
        if(bigger<=smaller){
            throw new RuntimeException(smaller+">="+bigger);
        }
    }
}