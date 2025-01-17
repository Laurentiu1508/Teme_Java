
package Pb4;

import java.util.Scanner;

public class Pb4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Persoana[] persoane;

        System.out.println("Cate persoane doriti sa introduceti?");
        int n = sc.nextInt();
        sc.nextLine(); // Consumă newline
        persoane = new Persoana[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Dati numele persoanei:");
            String nume = sc.nextLine();

            String cnp;
            do {
                System.out.println("Dati CNP-ul persoanei:");
                cnp = sc.nextLine();
                Persoana p = new Persoana(nume, cnp);

                if (!p.verificareNrCifre()) {
                    System.out.println("CNP-ul trebuie sa aiba 13 cifre.");
                    continue;
                }

                if (!p.verificareCaractere()) {
                    System.out.println("CNP-ul trebuie sa contina doar cifre.");
                    continue;
                }

                if (!p.verificarePrima()) {
                    System.out.println("Prima cifra a CNP-ului este invalida.");
                    continue;
                }

                if (!p.verificareCifraControl()) {
                    System.out.println("CNP-ul are o cifra de control invalida.");
                    continue;
                }

                break; // CNP valid

            } while (true);

            persoane[i] = new Persoana(nume, cnp);
        }

        for (Persoana p : persoane) {
            System.out.println(p);
        }

        sc.close();
    }
}