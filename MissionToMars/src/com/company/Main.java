package com.company;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int count = 0;
        while(count != 10){
            double i = Math.random();
            System.out.println(i);
            count++;
        }
        System.out.println(teste());

    }

    private static boolean teste(){
        return 3>2;
    }
}


