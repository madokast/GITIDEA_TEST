package Java并发编程的艺术.Tools;

import java.util.Map;

public class PrintMap {
    public static void print(Map map){
        for(Object entry:map.entrySet()){
            System.out.println(entry);
        }
    }
}
