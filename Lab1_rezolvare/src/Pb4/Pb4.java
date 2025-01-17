package Pb4;

import java.util.Scanner;
import java.util.Random;

public class Pb4 {
    public static void main(String[] args) {
        Random rand = new Random();
        int a = rand.nextInt(31);
        int b = rand.nextInt(31);
        System.out.println("Primul numar: "+ a);
        System.out.println("Al doilea numar: "+ b);
        int c=a;
        int d=b;
        while(c!=d)
        {
            if(c>d)
                c-=d;
            else
                d-=c;
        }
        System.out.println("Cmmdc a numerelor "+ a + " si " + b + " este: " + c);
    }
}
