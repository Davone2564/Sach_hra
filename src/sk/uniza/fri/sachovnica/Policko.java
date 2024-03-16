package sk.uniza.fri.sachovnica;

import sk.uniza.fri.sachovnica.grafickeObjekty.Stvorec;

/**
 * 2. 5. 2021 - 21:49
 *
 * @author Dávid
 */
public class Policko {
    private Stvorec stvorec;
    private int surRiadku;
    private int surStlpca;
    private boolean oznacene;
    private boolean zvyraznene;
    private String farba;

    public Policko(int surRiadku, int surStlpca, int paLavyHornyX, int paLavyHornyY, String paFarba) {
        this.surRiadku = surRiadku;
        this.surStlpca = surStlpca;
        this.farba = paFarba;
        this.stvorec = new Stvorec(paLavyHornyX, paLavyHornyY, Sachovnica.getRozmerPolicka(), paFarba);
        this.oznacene = false;
        this.zvyraznene = false;
    }

    public String getFarba() {
        return this.farba;
    }

    public int getSurRiadku() {
        return this.surRiadku;
    }

    public int getSurStlpca() {
        return this.surStlpca;
    }

    public void oznac() {
        this.oznacene = true;
        this.stvorec.setFarba("green");
    }

    public void odznac() {
        this.oznacene = false;
        this.stvorec.setFarba(this.farba);
    }

    public void zvyrazni() {
        this.zvyraznene = true;
        this.stvorec.setFarba("magenta");
    }

    public boolean jeOznacene() {
        return this.oznacene;
    }

    public boolean jeZvyraznene() {
        return this.zvyraznene;
    }

    public void zobraz() {
        this.stvorec.zobraz();
    }

    public void skry() {
        this.stvorec.skry();
    }
}
