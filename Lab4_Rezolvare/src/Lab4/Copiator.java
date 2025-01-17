package Lab4;

public class Copiator extends Echipament {
    private int pTon;
    private FormatCopiere formatCopiere;

    public Copiator(String denumire, int nrInv, double pret, String zonaMag, StareEchipament stare, int pTon, FormatCopiere formatCopiere) {
        super(denumire, nrInv, pret, zonaMag, stare);
        this.pTon = pTon;
        this.formatCopiere = formatCopiere;
    }

    @Override
    public void afisareDetalii() {
        System.out.println("Copiator: " + denumire + ", " + nrInv + ", " + pret + ", " + zonaMag + ", " + stare + ", " + pTon + " pag/toner, " + formatCopiere);
    }

    public void setFormatCopiere(FormatCopiere formatCopiere) {
        this.formatCopiere = formatCopiere;
    }
}
