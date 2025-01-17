//package Pb2;
//
//import java.io.*;
//import java.util.Random;
//import java.util.Scanner;
//import java.util.Arrays;
//
//public class Pb2 {
//    public static void main(String[] args)
//    {
//
//         int linii=0,i;
//         Random rand=new Random();
//
//        double min = 0.0;
//        double max = 1.0;
//
//        try(FileInputStream fis=new FileInputStream(new File("C:\\Users\\dansp\\Desktop\\LAU's doc\\Programare_Java\\Lab2\\src\\Pb2\\cantec_in.txt"));
//            Scanner sc=new Scanner(fis))
//        {
//
//            while (sc.hasNextLine())
//            {
//                String line = sc.nextLine().trim();
//                if (!line.isEmpty())
//                linii++;
//                //sc.nextLine();
//
//            }
//
//
//
//        } catch (IOException e) {
//            System.out.println("Fișierul nu a fost găsit: " + e.getMessage());
//        }
//
//        Vers []vers = new Vers [linii] ;
//
//        try(FileInputStream fis=new FileInputStream(new File("C:\\Users\\dansp\\Desktop\\LAU's doc\\Programare_Java\\Lab2\\src\\Pb2\\cantec_in.txt"));
//            Scanner sc=new Scanner(fis))
//        {
//
//        for ( i = 0; i < linii; i++)
//
//            if (sc.hasNextLine())
//                vers[i] = new Vers(" ");
//                vers[i].set_v(sc.nextLine());
//
//        } catch (IOException e) {
//            System.out.println("Fișierul nu a fost găsit: " + e.getMessage());
//        }
//
//
//
//
//        try (PrintStream ps = new PrintStream(new FileOutputStream("cantec_out.txt"))) {
//            for (i = 0; i < linii; i++)
//            {
//
//                double randomValue = min + (rand.nextDouble() * (max - min));
//                vers[i].Steluta("or");
//                vers[i].Rand(randomValue);
//                ps.println(vers[i].nrcuv()+" cuvinte "+vers[i].nrvoc()+" vocale "+" "+vers[i].get_v());
//
//            }
//
//            System.out.println("Datele au fost scrise cu succes în fișierul out.txt.");
//
//        } catch (IOException e) {
//            System.out.println("Eroare la scrierea în fișier: " + e.getMessage());
//        }
//
//    }
//}

package Pb2;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Pb2 {
    public static void main(String[] args) {
        int linii = 0, i;
        Random rand = new Random();
        double min = 0.0;
        double max = 1.0;


        try (FileInputStream fis = new FileInputStream(new File("C:\\Users\\dansp\\Desktop\\LAU's doc\\Programare_Java\\Lab2\\src\\Pb2\\cantec_in.txt"));
             Scanner sc = new Scanner(fis)) {
            while (sc.hasNextLine()) {
                sc.nextLine();
                linii++;
            }
        } catch (IOException e) {
            System.out.println("Fișierul nu a fost găsit: " + e.getMessage());
            return;
        }


        Vers[] vers = new Vers[linii];


        try (FileInputStream fis = new FileInputStream(new File("C:\\Users\\dansp\\Desktop\\LAU's doc\\Programare_Java\\Lab2\\src\\Pb2\\cantec_in.txt"));
             Scanner sc = new Scanner(fis)) {
            for (i = 0; i < linii; i++) {
                if (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    vers[i] = new Vers(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Fișierul nu a fost găsit: " + e.getMessage());
            return;
        }


        try (PrintStream ps = new PrintStream(new FileOutputStream("cantec_out.txt"))) {
            for (i = 0; i < linii; i++) {
                double randomValue = min + (rand.nextDouble() * (max - min));
                vers[i].Steluta("or,");
                vers[i].Rand(randomValue);
                ps.println(vers[i].nrcuv() + " cuvinte " + vers[i].nrvoc() + " vocale " + vers[i].get_v());
            }
            System.out.println("Datele au fost scrise cu succes în fișierul cantec_out.txt.");
        } catch (IOException e) {
            System.out.println("Eroare la scrierea în fișier: " + e.getMessage());
        }
    }
}
