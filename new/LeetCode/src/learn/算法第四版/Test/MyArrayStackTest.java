package learn.算法第四版.Test;

import learn.算法第四版.MyArrayStack;
import learn.算法第四版.MyLinkedStack;
import learn.算法第四版.Stack;

import javax.xml.transform.Source;

public class MyArrayStackTest {
    public static void main(String[] args) {
//        Stack<Integer> stack = new MyArrayStack<>();
        Stack<Integer> stack = new MyLinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("stack.iterator().hasNext() = " + stack.iterator().hasNext());

        for (Integer integer : stack) {
            System.out.println(integer);
        }

        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());

        System.out.println("--------------");
        for (Integer integer : stack) {
            System.out.println(integer);
        }

    }
}
