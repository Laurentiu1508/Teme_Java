package Lab4;

public class SistemCalcul extends Echipament {
    private String tipMon;
    private double vitProc;
    private int cHdd;
    private SistemOperare sistemOperare;

    public SistemCalcul(String denumire, int nrInv, double pret, String zonaMag, StareEchipament stare, String tipMon, double vitProc, int cHdd, SistemOperare sistemOperare) {
        super(denumire, nrInv, pret, zonaMag, stare);
        this.tipMon = tipMon;
        this.vitProc = vitProc;
        this.cHdd = cHdd;
        this.sistemOperare = sistemOperare;
    }

    @Override
    public void afisareDetalii() {
        System.out.println("Sistem de Calcul: " + denumire + ", " + nrInv + ", " + pret + ", " + zonaMag + ", " + stare + ", " + tipMon + ", " + vitProc + " GHz, " + cHdd + " GB, " + sistemOperare);
    }

    public void setSistemOperare(SistemOperare sistemOperare) {
        this.sistemOperare = sistemOperare;
    }
}
