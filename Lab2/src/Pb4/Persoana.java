
package Pb4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Persoana {

    private String nume;
    private String cnp;

    public Persoana(String nume, String cnp) {
        this.nume = nume;
        this.cnp = cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCnp() {
        return cnp;
    }

    public String getNume() {
        return nume;
    }

    public int getVarsta() {
        int prefix;
        int an = Integer.parseInt(cnp.substring(1, 3));
        int luna = Integer.parseInt(cnp.substring(3, 5));
        int zi = Integer.parseInt(cnp.substring(5, 7));

        // Determină prefixul anului din prima cifră
        switch (cnp.charAt(0)) {
            case '1':
            case '2':
                prefix = 1900;
                break;
            case '3':
            case '4':
                prefix = 1800;
                break;
            case '5':
            case '6':
                prefix = 2000;
                break;
            default:
                throw new IllegalArgumentException("CNP invalid");
        }

        LocalDate birthDate = LocalDate.of(prefix + an, luna, zi);
        return LocalDate.now().getYear() - birthDate.getYear();
    }

    public Boolean verificareNrCifre() {
        return this.cnp.length() == 13;
    }

    public Boolean verificareCaractere() {
        for (char ch : cnp.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    public Boolean verificarePrima() {
        return "1256".indexOf(cnp.charAt(0)) != -1;
    }

    public Boolean verificareCifraControl() {
        int[] coeficienti = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
        int suma = 0;

        for (int i = 0; i < 12; i++) {
            suma += coeficienti[i] * Character.getNumericValue(cnp.charAt(i));
        }

        int cifraControl = suma % 11;
        if (cifraControl == 10) cifraControl = 1;

        return cifraControl == Character.getNumericValue(cnp.charAt(12));
    }

    @Override
    public String toString() {
        return "Nume: " + getNume() + "  CNP: " + getCnp() + "  Varsta: " + getVarsta();
    }
}
