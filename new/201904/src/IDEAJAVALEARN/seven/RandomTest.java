package IDEAJAVALEARN.seven;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Random().nextInt(10)+1);
        }
    }
}
