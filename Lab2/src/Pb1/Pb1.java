package Pb1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class Pb1 {
    public static void main(String[] args) throws IOException {
        String []s=new String[30];
          int i=0,j;
          String c=new String();
         // File f=new File("C:\\Users\\dansp\\Desktop\\LAU's doc\\Programare_Java\\Lab2\\src\\Pb1\\judete.txt");

          try(FileInputStream fis=new FileInputStream(new File("C:\\Users\\dansp\\Desktop\\LAU's doc\\Programare_Java\\Lab2\\src\\Pb1\\judete.txt"));
         Scanner sc=new Scanner(fis))
          {

              while (sc.hasNextLine())
              {
                  String linie = sc.nextLine();
                  s[i]=linie;
                  i++;
              }

          } catch (FileNotFoundException e) {
              System.out.println("Fișierul nu a fost găsit: " + e.getMessage());
          }
        j=i;
          Arrays.sort(s,0,j);
               for(i=0;i<j;i++)
               System.out.println(s[i]+" ");

        Scanner scn=new Scanner(System.in);
               System.out.println("Dati judetul pe care-l cautati: ");
               c=scn.nextLine();
        int index = Arrays.binarySearch(s,0,j, c);

        if (index >= 0)
        {
            System.out.println("Elementul a fost găsit la indexul: " + index);
        }
        else
        {
            System.out.println("Elementul nu a fost găsit.");
        }
    }
}


