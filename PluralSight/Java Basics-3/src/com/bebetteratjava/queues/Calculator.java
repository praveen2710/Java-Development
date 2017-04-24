package com.bebetteratjava.queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import static java.lang.Integer.parseInt;

/**
 * Created by pb033954 on 4/2/2017.
 */
public class Calculator {

    public int evaluateQueue(final String input){
        System.out.println("Queue");
        final Deque<String> stack = new ArrayDeque<>();
        final String[] tokens = input.split(" ");
        for (String token: tokens) {
            System.out.println(token);
            stack.offerLast(token);
        }

        Iterator<String> itr =  stack.iterator();
        while (itr.hasNext()){
            System.out.println("|"+itr.next()+"|");
        }

        System.out.println(stack.peekFirst());

        System.out.println(stack.peekLast());


        while ((stack.size()>1)){
            final int left  = parseInt(stack.pollFirst());
            System.out.println("left:"+left);
            final String operator = stack.pollFirst();
            System.out.println("Operator:"+operator);
            final int right = parseInt(stack.pollFirst());
            System.out.println("right:"+right);

            int result = 0;
            switch (operator){
                case "+":
                    result = left+right;
                    break;
                case "-":
                    result = left-right;
                    break;
                case "/":
                    result = left/right;
                    break;
                case "*" :
                    result = left*right;
                    break;
            }
            stack.offerFirst(String.valueOf(result));
        }
        return parseInt(stack.pop());
    }

    public int evaluateStack(final String input) {
        System.out.println("Stack");
        final Deque<String> stack = new ArrayDeque<>();
        final String[] tokens = input.split(" ");
        for (String token: tokens) {
            System.out.println(token);
            stack.offerLast(token);
        }

        Iterator<String> itr =  stack.iterator();
        while (itr.hasNext()){
            System.out.println("|"+itr.next()+"|");
        }

        System.out.println(stack.peekFirst());

        System.out.println(stack.peekLast());


        while ((stack.size()>1)){
            final int left  = parseInt(stack.pollLast());
            System.out.println("left:"+left);
            final String operator = stack.pollLast();
            System.out.println("Operator:"+operator);
            final int right = parseInt(stack.pollLast());
            System.out.println("right:"+right);

            int result = 0;
            switch (operator){
                case "+":
                    result = left+right;
                    break;
                case "-":
                    result = left-right;
                    break;
                case "/":
                    result = left/right;
                    break;
                case "*" :
                    result = left*right;
                    break;
            }
            stack.offerLast(String.valueOf(result));
        }
        return parseInt(stack.pop());
    }
}
