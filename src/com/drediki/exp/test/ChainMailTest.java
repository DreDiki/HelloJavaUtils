package com.drediki.exp.test;

import com.drediki.exp.chainmail.Chain;

/**
 * Created by DreDiki on 2016/12/16.
 */


public class ChainMailTest {

    public static void main(String[] args) {
        System.out.println("Hello");
        Chain<Integer> integerChain = new Chain<>();
        integerChain.add(1);
        integerChain.add(5);
        integerChain.add(3);
        integerChain.add(7);
        integerChain.add(4);

        System.out.println("==========================================================");
        System.out.println(integerChain.getLast().getCore());
        System.out.println(integerChain.getHead().getCore());
        System.out.println(integerChain.contains(2));
        System.out.println(integerChain.getLength());
        System.out.println("==========================================================");

        integerChain.reverse();
        System.out.println(integerChain.printChain());

        System.out.println("==========================================================");
        System.out.println(integerChain.sorted());
        integerChain.sort();
        System.out.println(integerChain.sorted());
        System.out.println(integerChain.printChain());
        System.out.println("==========================================================");

        Chain<Integer> another = new Chain<>();
        another.add(2);
        another.add(2);
        another.add(6);
        another.add(9);
        integerChain.merge(another);
        System.out.println(integerChain.printChain());
        System.out.println("==========================================================");

        integerChain.sort(true);
        System.out.println(integerChain.sorted(true));
        System.out.println(integerChain.printChain());
        System.out.println("==========================================================");

        integerChain.removeFirst();
        integerChain.removeLast();
        System.out.println(integerChain.printChain());
        System.out.println(integerChain.getLength());

        System.out.println("==========================================================");

        integerChain.clean();
        integerChain.add(5);
        System.out.println(integerChain.getLast().getCore());
        integerChain.addToFront(999);
        System.out.println(integerChain.printChain());

        System.out.println("==========================================================");


    }

}
