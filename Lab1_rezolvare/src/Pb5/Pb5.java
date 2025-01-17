package Pb5;

import java.util.Scanner;
import java.util.Random;
public class Pb5
{
    public static void main(String[] args) {
        Random rand = new Random ();
        int a = rand.nextInt(20);
        System.out.println("Numarul este: "+a);
        int f1=0,f2=1;
        int nr=f1;
        while(nr<a)
        {
            nr=f1+f2;
            f1=f2;
            f2=nr;
        }
if(a==nr)
    System.out.println("Numarul " + a + " face parte din sirul lui Fibonacci." );
else
    System.out.println("Numarul "+ a + " nu face parte din sirul lui Fibonacci.");
    }

}

