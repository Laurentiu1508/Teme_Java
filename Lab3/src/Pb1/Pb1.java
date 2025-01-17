package Pb1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pb1 {

    public static void main(String[] args) {

        List<Parabola> parabole = new ArrayList<Parabola>();

        try(FileInputStream fis=new FileInputStream(new File("C:\\Users\\dansp\\Desktop\\LAU's doc\\Programare_Java\\Lab3\\src\\Pb1\\in.txt"));
       Scanner sc=new Scanner(fis))
        {
            while(sc.hasNextLine())
            {
                String line=sc.nextLine();
                String[] parts = line.split(" ");
                int a = Integer.parseInt(parts[0].trim());
                int b = Integer.parseInt(parts[1].trim());
                int c = Integer.parseInt(parts[2].trim());

                Parabola parabola = new Parabola(a, b, c);
                parabole.add(parabola);

            }

            System.out.println("Parabole citite din fișier:");
            for (Parabola p : parabole) {
                System.out.println(p);
                System.out.println("Varful parabolei este: "+p.Varf());
            }
            Parabola parabola1 = parabole.get(0);
            Parabola parabola2 = parabole.get(1);
            String Mij1=parabola1.Mijloc_Segment_Parb(parabola2);
            String Lungime1=parabola1.Lungime_Segment(parabola1, parabola2);
            String Mij2=parabola2.Mijloc_Segment_Parb(parabola1);
            String Lungime2=parabola2.Lungime_Segment(parabola1, parabola2);
            String MijlocStatic=Parabola.Mij_Parab(parabola1, parabola2);
            String LungimeStatic=Parabola.Lungime_Segment_Static(parabola1, parabola2);
            System.out.println("Mijlocul 1:"+Mij1);
            System.out.println("Mijlocul 2:"+Mij2);
            System.out.println("Mijlocul static:"+MijlocStatic);
            System.out.println("Lungime 1:"+Lungime1);
            System.out.println("Lungime 2: "+Lungime2);
            System.out.println("Lungime statica:"+LungimeStatic);


        }catch(IOException e)
        {
            System.err.println("A apărut o eroare la citirea fișierului: " + e.getMessage());

        }



        }

    }

