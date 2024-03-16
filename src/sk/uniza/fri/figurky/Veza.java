package sk.uniza.fri.figurky;

import sk.uniza.fri.sachovnica.Sachovnica;
import sk.uniza.fri.sachovnica.grafickeObjekty.Obrazok;

/**
 * 2. 5. 2021 - 21:49
 *
 * @author Dávid
 */
public class Veza extends Figurka {
    private Obrazok obrazok;

    public Veza(int surRiadku, int surStlpca, int paLavyHornyX, int paLavyHornyY, String farba) {
        super(surRiadku, surStlpca, paLavyHornyX, paLavyHornyY, farba);
        if (farba.equals("white")) {
            this.obrazok = new Obrazok("Rook_White.png", paLavyHornyX, paLavyHornyY, this.getRozmer(), this.getRozmer());
        } else {
            this.obrazok = new Obrazok("Rook_Black.png", paLavyHornyX, paLavyHornyY, this.getRozmer(), this.getRozmer());
        }
    }

    @Override
    public void zvol(Sachovnica paSachovnica) {
        // v cykle prezerame policka smerom hore od veze
        for (int i = this.getSurRiadku() - 1; i > -1; i--) {
            if (paSachovnica.jeObsadenePolicko(i, this.getSurStlpca())) {
                if (!paSachovnica.getFarbaFigurky(i, this.getSurStlpca()).equals(this.getFarba())) {
                    paSachovnica.oznacPolicko(i, this.getSurStlpca());
                }
                break;
            } else {
                paSachovnica.oznacPolicko(i, this.getSurStlpca());
            }
        }

        // v cykle prezerame policka smerom dole od veze
        for (int i = this.getSurRiadku() + 1; i < 8; i++) {
            if (paSachovnica.jeObsadenePolicko(i, this.getSurStlpca())) {
                if (!paSachovnica.getFarbaFigurky(i, this.getSurStlpca()).equals(this.getFarba())) {
                    paSachovnica.oznacPolicko(i, this.getSurStlpca());
                }
                break;
            } else {
                paSachovnica.oznacPolicko(i, this.getSurStlpca());
            }
        }

        // v cykle prezerame policka smerom dolava od veze
        for (int i = this.getSurStlpca() - 1; i > -1; i--) {
            if (paSachovnica.jeObsadenePolicko(this.getSurRiadku(), i)) {
                if (!paSachovnica.getFarbaFigurky(this.getSurRiadku(), i).equals(this.getFarba())) {
                    paSachovnica.oznacPolicko(this.getSurRiadku(), i);
                }
                break;
            } else {
                paSachovnica.oznacPolicko(this.getSurRiadku(), i);
            }
        }

        // v cykle prezerame policka smerom doprava od veze
        for (int i = this.getSurStlpca() + 1; i < 8; i++) {
            if (paSachovnica.jeObsadenePolicko(this.getSurRiadku(), i)) {
                if (!paSachovnica.getFarbaFigurky(this.getSurRiadku(), i).equals(this.getFarba())) {
                    paSachovnica.oznacPolicko(this.getSurRiadku(), i);
                }
                break;
            } else {
                paSachovnica.oznacPolicko(this.getSurRiadku(), i);
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
