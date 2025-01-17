package Pb3;

import java.util.Scanner;

public class Pb3 {

    public static void main(String[] args) {

        StringBuilder sir,subsir;
        int poz,poz_stergere,nr_poz;
        Scanner sc=new Scanner(System.in);
        System.out.println("Dati primul sir:");
        sir= new StringBuilder(sc.nextLine());
        System.out.println("Dati subsirul dorit pt inserare:");
        subsir= new StringBuilder(sc.nextLine());
        System.out.println("Pe ce pozitie doriti sa inserati subsirul?");
        poz=sc.nextInt();
        sir.insert(poz,subsir);
        System.out.println(sir);
        System.out.println("De la ce pozitie doriti sa stergeti din sir?");
        poz_stergere=sc.nextInt();
        System.out.println("Cate pozitii doriti sa stergeti?");
        nr_poz=sc.nextInt();
        sir.delete(poz_stergere,poz_stergere+nr_poz);
        System.out.println(sir);


    }

}
