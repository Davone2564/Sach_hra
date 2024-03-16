package sk.uniza.fri.figurky;

import sk.uniza.fri.sachovnica.Sachovnica;
import sk.uniza.fri.sachovnica.grafickeObjekty.Obrazok;

/**
 * 2. 5. 2021 - 21:49
 *
 * @author Dávid
 */
public class Kral extends Figurka {
    private Obrazok obrazok;

    public Kral(int surRiadku, int surStlpca, int paLavyHornyX, int paLavyHornyY, String farba) {
        super(surRiadku, surStlpca, paLavyHornyX, paLavyHornyY, farba);
        if (farba.equals("white")) {
            this.obrazok = new Obrazok("King_White.png", paLavyHornyX, paLavyHornyY, this.getRozmer(), this.getRozmer());
        } else {
            this.obrazok = new Obrazok("King_Black.png", paLavyHornyX, paLavyHornyY, this.getRozmer(), this.getRozmer());
        }
    }

    @Override
    public void zvol(Sachovnica paSachovnica) {
        // prezerame vsetky body okolo krala
        for (int i = this.getSurRiadku() - 1; i <= this.getSurRiadku() + 1; i++) {
            for (int j = this.getSurStlpca() - 1; j <= this.getSurStlpca() + 1; j++) {
                if ((i != this.getSurRiadku()) && (j != this.getSurStlpca())) {
                    if (paSachovnica.jeObsadenePolicko(i, j)) {
                        if (!paSachovnica.getFarbaFigurky(i, j).equals(this.getFarba())) {
                            paSachovnica.oznacPolicko(i, j);
                        }
                    } else {
                        paSachovnica.oznacPolicko(i, j);
                    }
                }
            }
        }
    }

    @Override
    public void zobraz() {
        this.obrazok.setSuradnicaX(this.getSurStlpca() * Sachovnica.getRozmerPolicka() + Sachovnica.getRozmerPolicka() / 10 + 6 * Sachovnica.getRozmerPolicka());
        this.obrazok.setSuradnicaY(this.getSurRiadku() * Sachovnica.getRozmerPolicka() + Sachovnica.getRozmerPolicka() / 10);
        this.obrazok.zobraz();
    }

    @Override
    public void skry() {
        this.obrazok.skry();
    }
}
