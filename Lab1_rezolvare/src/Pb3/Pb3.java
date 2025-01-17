package Pb3;

import java.util.Scanner;

public class Pb3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dati numarul dorit: ");
        int n = sc.nextInt();
        int i,nr=1;
        for(i=2;i<=n/2;i++)
        {
            if(n%i==0)
            {
                System.out.print(i+" ");
                nr++;
            }

        }

        if(nr==1 && n!=1)
            System.out.println("\nNumarul " + n + " e prim.");
        else
            System.out.println("\nNumarul " + n + " nu e prim.");
    }
}
