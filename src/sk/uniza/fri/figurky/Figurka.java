package sk.uniza.fri.figurky;

import sk.uniza.fri.hra.IllegalMoveException;
import sk.uniza.fri.sachovnica.Policko;
import sk.uniza.fri.sachovnica.Sachovnica;

/**
 * 2. 5. 2021 - 21:49
 *
 * @author Dávid
 */
public abstract class Figurka {
    private int rozmer;
    private int surRiadku;
    private int surStlpca;
    private String farba;

    public Figurka(int surRiadku, int surStlpca, int paLavyHornyX, int paLavyHornyY, String farba) {
        this.surRiadku = surRiadku;
        this.surStlpca = surStlpca;
        this.farba = farba;
        this.rozmer = (Sachovnica.getRozmerPolicka() / 5) * 4;
    }

    public int getRozmer() {
        return this.rozmer;
    }

    public int getSurRiadku() {
        return this.surRiadku;
    }

    public int getSurStlpca() {
        return this.surStlpca;
    }

    public String getFarba() {
        return this.farba;
    }

    public void setSurRiadku(int surRiadku) {
        this.surRiadku = surRiadku;
    }

    public void setSurStlpca(int surStlpca) {
        this.surStlpca = surStlpca;
    }

    /**
     * Figúrka sa posunie o políčko
     * @param paPosunX
     * @param paPosunY
     */
    public void posunOPolicko(int paPosunX, int paPosunY) {
        this.surRiadku += paPosunY;
        this.surStlpca += paPosunX;
    }


    public void posun(Policko cielovePolicko, Sachovnica paSachovnica) {
        // v podmienke zistujeme ci je policko oznacene(ci nan mozeme preskocit)
        if (cielovePolicko.jeOznacene()) {
            this.posunOPolicko(cielovePolicko.getSurStlpca() - this.surStlpca, cielovePolicko.getSurRiadku() - this.surRiadku);
            this.zobraz();
        } else {
            throw new IllegalMoveException();
        }
    }

    /**
     * Metóda zvolí figurku
     * @param paSachovnica šachovnica, kde chceme figúrku zvoliť
     */
    public abstract void zvol(Sachovnica paSachovnica);

    public abstract void zobraz();

    public abstract void skry();
}
