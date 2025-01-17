package Problema_2;

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Pb2 {
    public static void main(String[] args) {
        File f = new File("C:\\Users\\dansp\\Desktop\\LAU's doc\\Programare_Java\\Lab1_rezolvare\\src\\Problema_2\\in.txt");
        Scanner sc = null;
        int [] v=new int[10];
        int i=0,max=0,sum=0,min=100,maxim=0;
        float ma;

        try {
            sc = new Scanner(f);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                v[i]=Integer.parseInt(line);
                i++;
            }
            max=i;
        } catch (FileNotFoundException e) {

            System.out.println("File not found " + e.getMessage());
        }finally {
            if(sc!=null)
            sc.close();
        }
for(i=0;i<max;i++)
{       sum+=v[i];
        if(v[i]<min) min=v[i];
        if(v[i]>maxim) maxim=v[i];
}
 ma= (float)sum/max;
        System.out.println("Numerele sunt:");
        for(i=0;i<max;i++)
            System.out.println(v[i]);
        System.out.println("Suma numerelor este:  " + sum);
        System.out.println("Media aritmetica este: " + ma);
        System.out.println("Minimul este: " + min);
        System.out.println("Maximul este: " + maxim);

        try (PrintStream ps = new PrintStream(new FileOutputStream("out.txt"))) {

            // Scrierea valorilor în fișier
            ps.println("Numerele sunt:");
            for (i=0;i<max;i++) {
                ps.println(v[i]);
            }
            ps.println("Suma numerelor este: " + sum);
            ps.println("Media aritmetică este: " + ma);
            ps.println("Minimul este: " + min);
            ps.println("Maximul este: " + maxim);

            System.out.println("Datele au fost scrise cu succes în fișierul out.txt.");

        } catch (IOException e) {
            System.out.println("Eroare la scrierea în fișier: " + e.getMessage());
        }
    }
}