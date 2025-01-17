package Pb2;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main_2 {
    public static void main(String[] args)
    {

    List<Produs> produse=new ArrayList<Produs>();

       try(Scanner sc=new Scanner(new File("C:\\Users\\dansp\\Desktop\\LAU's doc\\Programare_Java\\Lab3\\src\\Pb2\\produse.csv"))) {
           while (sc.hasNextLine()) {
               String linie = sc.nextLine();
               String[] campuri = linie.split(",");

               String denumire = campuri[0];
               double pret = Double.parseDouble(campuri[1]);
               int cantitate = Integer.parseInt(campuri[2]);
               LocalDate dataExpirarii = LocalDate.parse(campuri[3]);

               produse.add(new Produs(denumire, pret, cantitate, dataExpirarii));
           }
       }catch (FileNotFoundException e) {
           System.err.println("Fișierul nu a fost găsit: " + e.getMessage());
       } catch (Exception e) {
           System.err.println("Eroare la citirea fișierului: " + e.getMessage());
       }

        Scanner scanner = new Scanner(System.in);
        int optiune;

        do {
            System.out.println("\nMeniu:");
            System.out.println("1. Afișare produse");
            System.out.println("2. Afișare produse expirate");
            System.out.println("3. Vânzare produs");
            System.out.println("4. Afișare produse cu preț minim");
            System.out.println("5. Salvare produse cu cantitate mică în fișier");
            System.out.println("0. Ieșire");
            System.out.print("Alegeți o opțiune: ");
            optiune = scanner.nextInt();

            switch (optiune) {
                case 1:

                    produse.forEach(System.out::println);
                    break;

                case 2:

                    LocalDate azi = LocalDate.now();
                    produse.stream()
                            .filter(p -> p.getDataExpirare().isBefore(azi))
                            .forEach(System.out::println);
                    break;

                case 3:

                    System.out.print("Introduceți numele produsului: ");
                    scanner.nextLine();
                    String nume = scanner.nextLine();
                    System.out.print("Introduceți cantitatea de vândut: ");
                    int cantitate = scanner.nextInt();

                    Produs produsVandut = produse.stream()
                            .filter(p -> p.getDenumire().equalsIgnoreCase(nume))
                            .findFirst()
                            .orElse(null);

                    if (produsVandut != null) {
                        if (produsVandut.getCantitate() >= cantitate) {
                            produsVandut.setCantitate(produsVandut.getCantitate() - cantitate);
                            Produs.adaugaIncasari(produsVandut.getPret() * cantitate);
                            System.out.println("Vânzarea a fost realizată!");
                            if (produsVandut.getCantitate() == 0) {
                                produse.remove(produsVandut);
                                System.out.println("Produsul a fost eliminat din stoc.");
                            }
                        } else {
                            System.out.println("Cantitate insuficientă pe stoc!");
                        }
                    } else {
                        System.out.println("Produsul nu a fost găsit!");
                    }
                    break;

                case 4:

                    double pretMinim = produse.stream()
                            .mapToDouble(Produs::getPret)
                            .min()
                            .orElse(-1);

                    produse.stream()
                            .filter(p -> p.getPret() == pretMinim)
                            .forEach(System.out::println);
                    break;

                case 5:

                    System.out.print("Introduceți cantitatea maximă: ");
                    int cantitateMaxima = scanner.nextInt();

                    try (java.io.PrintWriter writer = new java.io.PrintWriter(new File("produse_mici.txt"))) {
                        produse.stream()
                                .filter(p -> p.getCantitate() < cantitateMaxima)
                                .forEach(p -> writer.println(p));
                        System.out.println("Produsele au fost salvate în fișierul produse_mici.txt.");
                    } catch (Exception e) {
                        System.err.println("Eroare la salvarea fișierului: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("La revedere!");
                    break;

                default:
                    System.out.println("Opțiune invalidă.");
            }
        } while (optiune != 0);

       }

    }

