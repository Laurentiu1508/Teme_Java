
package Pb1;

public class Parabola {

    private int a, b, c;

    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String Varf() {
        double x, y;
        x = (double) -b / (2 * a);
        y = (-Math.pow(b, 2) + 4 * a * c) / (4 * a);

        return "(" + x + "," + y + ")";
    }

    @Override
    public String toString() {
        return "f(x)=" + this.a + "*(x^2) + " + this.b + "*x + " + this.c;
    }

    public String Mijloc_Segment_Parb(Parabola p) {
        double x_mij, y_mij, x1, y1, x2, y2;

        String varfP = p.Varf();
        x2 = Double.parseDouble(varfP.substring(1, varfP.indexOf(",")));
        y2 = Double.parseDouble(varfP.substring(varfP.indexOf(",") + 1, varfP.length() - 1));

        String varfThis = this.Varf();
        x1 = Double.parseDouble(varfThis.substring(1, varfThis.indexOf(",")));
        y1 = Double.parseDouble(varfThis.substring(varfThis.indexOf(",") + 1, varfThis.length() - 1));

        x_mij = (x1 + x2) / 2;
        y_mij = (y1 + y2) / 2;

        return "Mijloc segment: (" + x_mij + "," + y_mij + ")";
    }

    public static String Mij_Parab(Parabola p, Parabola s) {
        double x_mij, y_mij, x1, y1, x2, y2;

        String varfP = p.Varf();
        x2 = Double.parseDouble(varfP.substring(1, varfP.indexOf(",")));
        y2 = Double.parseDouble(varfP.substring(varfP.indexOf(",") + 1, varfP.length() - 1));


        String varfS = s.Varf();
        x1 = Double.parseDouble(varfS.substring(1, varfS.indexOf(",")));
        y1 = Double.parseDouble(varfS.substring(varfS.indexOf(",") + 1, varfS.length() - 1));


        x_mij = (x1 + x2) / 2;
        y_mij = (y1 + y2) / 2;

        return "Mijloc segment din metoda statica: (" + x_mij + "," + y_mij + ")";
    }

    public String Lungime_Segment(Parabola p, Parabola s) {
        double lungime, x1, y1, x2, y2;


        String varfP = p.Varf();
        x2 = Double.parseDouble(varfP.substring(1, varfP.indexOf(",")));
        y2 = Double.parseDouble(varfP.substring(varfP.indexOf(",") + 1, varfP.length() - 1));


        String varfS = s.Varf();
        x1 = Double.parseDouble(varfS.substring(1, varfS.indexOf(",")));
        y1 = Double.parseDouble(varfS.substring(varfS.indexOf(",") + 1, varfS.length() - 1));


        lungime = Math.hypot(x2 - x1, y2 - y1);

        return "Lungime segment: " + lungime;
    }

    public static String Lungime_Segment_Static(Parabola p, Parabola s) {
        double lungime, x1, y1, x2, y2;


        String varfP = p.Varf();
        x2 = Double.parseDouble(varfP.substring(1, varfP.indexOf(",")));
        y2 = Double.parseDouble(varfP.substring(varfP.indexOf(",") + 1, varfP.length() - 1));


        String varfS = s.Varf();
        x1 = Double.parseDouble(varfS.substring(1, varfS.indexOf(",")));
        y1 = Double.parseDouble(varfS.substring(varfS.indexOf(",") + 1, varfS.length() - 1));

        lungime = Math.hypot(x2 - x1, y2 - y1);

        return "Lungime segment metoda statica: " + lungime;
    }
}
