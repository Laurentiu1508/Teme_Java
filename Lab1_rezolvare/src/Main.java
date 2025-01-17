
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        int lungime;
        int latime;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Lungimea trebuie sa fie mai mare ca latimea!");
            System.out.print("L=");
             lungime = sc.nextInt();
            System.out.print("l=");
             latime = sc.nextInt();
        }while(latime>lungime);
        System.out.print("Aria dreptunghiului este " +(lungime*latime)+ " si perimetrul " +(lungime+latime));
    }
}