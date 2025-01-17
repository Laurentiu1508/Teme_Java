package Lab4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

        public class Main {
            public static void main(String[] args) {
                List<Echipament> echipamente = new ArrayList<>();

                try (BufferedReader br = new BufferedReader(new FileReader("electronice.txt"))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split(";");
                        String denumire = parts[0];
                        int nrInv = Integer.parseInt(parts[1]);
                        double pret = Double.parseDouble(parts[2]);
                        String zonaMag = parts[3];
                        StareEchipament stare = StareEchipament.valueOf(parts[4].toUpperCase());
                        String tipEchipament = parts[5].toLowerCase();

                        switch (tipEchipament) {
                            case "imprimanta":
                                int ppm = Integer.parseInt(parts[6]);
                                String rezolutie = parts[7];
                                int pCar = Integer.parseInt(parts[8]);
                                TipImprimare tipImprimare = TipImprimare.valueOf(parts[9].toUpperCase());
                                echipamente.add(new Imprimanta(denumire, nrInv, pret, zonaMag, stare, ppm, rezolutie, pCar, tipImprimare));
                                break;
                            case "copiator":
                                int pTon = Integer.parseInt(parts[6]);
                                FormatCopiere formatCopiere = FormatCopiere.valueOf(parts[7].toUpperCase());
                                echipamente.add(new Copiator(denumire, nrInv, pret, zonaMag, stare, pTon, formatCopiere));
                                break;
                            case "sistem de calcul":
                                String tipMon = parts[6];
                                double vitProc = Double.parseDouble(parts[7]);
                                int cHdd = Integer.parseInt(parts[8]);
                                SistemOperare sistemOperare = SistemOperare.valueOf(parts[9].toUpperCase());
                                echipamente.add(new SistemCalcul(denumire, nrInv, pret, zonaMag, stare, tipMon, vitProc, cHdd, sistemOperare));
                                break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Implementarea meniului
                Scanner scanner = new Scanner(System.in);
                boolean running = true;

                while (running) {
                    System.out.println("\nMeniu:");
                    System.out.println("1. Afișarea tuturor echipamentelor");
                    System.out.println("2. Afișarea imprimantelor");
                    System.out.println("3. Afișarea copiatoarelor");
                    System.out.println("4. Afișarea sistemelor de calcul");
                    System.out.println("5. Modificarea stării unui echipament");
                    System.out.println("6. Setarea unui mod de scriere pentru o imprimantă");
                    System.out.println("7. Setarea unui format de copiere pentru un copiator");
                    System.out.println("8. Instalarea unui sistem de operare pe un sistem de calcul");
                    System.out.println("9. Afișarea echipamentelor vândute");
                    System.out.println("10. Serializare/Deserializare");
                    System.out.println("0. Ieșire");
                    System.out.print("Selectați o opțiune: ");

                    int option = scanner.nextInt();
                    scanner.nextLine(); // Consumăm linia

                    switch (option) {
                        case 1:
                            echipamente.forEach(Echipament::afisareDetalii);
                            break;
                        case 2:
                            echipamente.stream()
                                    .filter(e -> e instanceof Imprimanta)
                                    .forEach(Echipament::afisareDetalii);
                            break;
                        case 3:
                            echipamente.stream()
                                    .filter(e -> e instanceof Copiator)
                                    .forEach(Echipament::afisareDetalii);
                            break;
                        case 4:
                            echipamente.stream()
                                    .filter(e -> e instanceof SistemCalcul)
                                    .forEach(Echipament::afisareDetalii);
                            break;
                        case 5:
                            System.out.print("Introduceți nr_inv al echipamentului: ");
                            int nrInv = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Introduceți noua stare (ACHIZITIONAT, EXPUS, VANDUT): ");
                            StareEchipament stare = StareEchipament.valueOf(scanner.nextLine().toUpperCase());
                            echipamente.stream()
                                    .filter(e -> e.nrInv == nrInv)
                                    .forEach(e -> e.setStare(stare));
                            break;
                        case 6:
                            System.out.print("Introduceți nr_inv al imprimantei: ");
                            nrInv = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Introduceți modul de scriere (COLOR, ALB_NEGRU): ");
                            TipImprimare tipImprimare = TipImprimare.valueOf(scanner.nextLine().toUpperCase());
                            echipamente.stream()
                                    .filter(e -> e instanceof Imprimanta && e.nrInv == nrInv)
                                    .forEach(e -> ((Imprimanta) e).setTipImprimare(tipImprimare));
                            break;
                        case 7:
                            System.out.print("Introduceți nr_inv al copiatorului: ");
                            nrInv = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Introduceți formatul de copiere (A3, A4): ");
                            FormatCopiere formatCopiere = FormatCopiere.valueOf(scanner.nextLine().toUpperCase());
                            echipamente.stream()
                                    .filter(e -> e instanceof Copiator && e.nrInv == nrInv)
                                    .forEach(e -> ((Copiator) e).setFormatCopiere(formatCopiere));
                            break;
                        case 8:
                            System.out.print("Introduceți nr_inv al sistemului de calcul: ");
                            nrInv = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Introduceți sistemul de operare (WINDOWS, LINUX): ");
                            SistemOperare sistemOperare = SistemOperare.valueOf(scanner.nextLine().toUpperCase());
                            echipamente.stream()
                                    .filter(e -> e instanceof SistemCalcul && e.nrInv == nrInv)
                                    .forEach(e -> ((SistemCalcul) e).setSistemOperare(sistemOperare));
                            break;
                        case 9:
                            echipamente.stream()
                                    .filter(e -> e.stare == StareEchipament.VANDUT)
                                    .forEach(Echipament::afisareDetalii);
                            break;
                        case 10:
                            System.out.println("1. Serializare");
                            System.out.println("2. Deserializare");
                            int subOption = scanner.nextInt();
                            scanner.nextLine();
                            if (subOption == 1) {
                                serializareEchipamente(echipamente);
                            } else if (subOption == 2) {
                                echipamente = deserializareEchipamente();
                            }
                            break;
                        case 0:
                            running = false;
                            break;
                        default:
                            System.out.println("Opțiune invalidă!");
                            break;
                    }
                }

                scanner.close();
            }

            private static void serializareEchipamente(List<Echipament> echipamente) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("echip.bin"))) {
                    oos.writeObject(echipamente);
                    System.out.println("Serializare realizată cu succes.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @SuppressWarnings("unchecked")
            private static List<Echipament> deserializareEchipamente() {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("echip.bin"))) {
                    System.out.println("Deserializare realizată cu succes.");
                    return (List<Echipament>) ois.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                    return new ArrayList<>();
                }
            }
    }
