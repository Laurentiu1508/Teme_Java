package Lab4;

public class Imprimanta extends Echipament {
    private int ppm;
    private String rezolutie;
    private int pCar;
    private TipImprimare tipImprimare;

    public Imprimanta(String denumire, int nrInv, double pret, String zonaMag, StareEchipament stare, int ppm, String rezolutie, int pCar, TipImprimare tipImprimare) {
        super(denumire, nrInv, pret, zonaMag, stare);
        this.ppm = ppm;
        this.rezolutie = rezolutie;
        this.pCar = pCar;
        this.tipImprimare = tipImprimare;
    }

    @Override
    public void afisareDetalii() {
        System.out.println("Imprimanta: " + denumire + ", " + nrInv + ", " + pret + ", " + zonaMag + ", " + stare + ", " + ppm + " ppm, " + rezolutie + ", " + pCar + " pag/cart, " + tipImprimare);
    }

    public void setTipImprimare(TipImprimare tipImprimare) {
        this.tipImprimare = tipImprimare;
    }
}
