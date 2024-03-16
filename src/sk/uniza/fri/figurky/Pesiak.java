package sk.uniza.fri.figurky;

import sk.uniza.fri.sachovnica.Sachovnica;
import sk.uniza.fri.sachovnica.grafickeObjekty.Obrazok;

/**
 * 2. 5. 2021 - 21:49
 *
 * @author Dávid
 */
public class Pesiak extends Figurka {
    private Obrazok obrazok;

    public Pesiak(int surRiadku, int surStlpca, int paLavyHornyX, int paLavyHornyY, String farba) {
        super(surRiadku, surStlpca, paLavyHornyX, paLavyHornyY, farba);
        if (farba.equals("white")) {
            this.obrazok = new Obrazok("Pawn_White.png", paLavyHornyX, paLavyHornyY, this.getRozmer(), this.getRozmer());
        } else {
            this.obrazok = new Obrazok("Pawn_Black.png", paLavyHornyX, paLavyHornyY, this.getRozmer(), this.getRozmer());
        }
    }

    @Override
    public void zvol(Sachovnica paSachovnica) {
        // prezerame policka okolo pesiaka(jedna vetva pre bielych pesiakov, ktori sa hybu smerom hore, druha vetva pre ciernych pesiakov, ktori sa hybu smerom dole)
        if (this.getFarba().equals(Sachovnica.getFarbaFiguriek2())) {
            // prve prezerame policko hore nad pesiakom(zistujeme ci sa moze pohnut dohora)
            if (!paSachovnica.jeObsadenePolicko(this.getSurRiadku() - 1, this.getSurStlpca())) {
                paSachovnica.oznacPolicko(this.getSurRiadku() - 1, this.getSurStlpca());
                // ak je pred pesiakom volno, zistujeme ci nie je na vychodzej pozicii. Ak je, tak prezrieme este dalsie policko pred nim
                if (this.getSurRiadku() == 6) {
                    if (!paSachovnica.jeObsadenePolicko(4, this.getSurStlpca())) {
                        paSachovnica.oznacPolicko(4, this.getSurStlpca());
                    }
                }
            }

            // teraz prezerame policko ktore su vlavo hore a vpravo hore od pesiaka(ak je na nich protivnikova figurka, oznacime ich)
            if (paSachovnica.existujePolicko(this.getSurRiadku() - 1, this.getSurStlpca() - 1)) {
                if (paSachovnica.jeObsadenePolicko(this.getSurRiadku() - 1, this.getSurStlpca() - 1)) {
                    if (!paSachovnica.getFarbaFigurky(this.getSurRiadku() - 1, this.getSurStlpca() - 1).equals(this.getFarba())) {
                        paSachovnica.oznacPolicko(this.getSurRiadku() - 1, this.getSurStlpca() - 1);
                    }
                }
            }

            if (paSachovnica.existujePolicko(this.getSurRiadku() - 1, this.getSurStlpca() + 1)) {
                if (paSachovnica.jeObsadenePolicko(this.getSurRiadku() - 1, this.getSurStlpca() + 1)) {
                    if (!paSachovnica.getFarbaFigurky(this.getSurRiadku() - 1, this.getSurStlpca() + 1).equals(this.getFarba())) {
                        paSachovnica.oznacPolicko(this.getSurRiadku() - 1, this.getSurStlpca() + 1);
                    }
                }
            }

        } else if (this.getFarba().equals(Sachovnica.getFarbaFiguriek1())) {
            // prve prezerame policko dole pod pesiakom(zistujeme ci sa moze pohnut dodola)
            if (!paSachovnica.jeObsadenePolicko(this.getSurRiadku() + 1, this.getSurStlpca())) {
                paSachovnica.oznacPolicko(this.getSurRiadku() + 1, this.getSurStlpca());
                // ak je pred pesiakom volno, zistujeme ci nie je na vychodzej pozicii. Ak je, tak prezrieme este dalsie policko pred nim
                if (this.getSurRiadku() == 1) {
                    if (!paSachovnica.jeObsadenePolicko(3, this.getSurStlpca())) {
                        paSachovnica.oznacPolicko(3, this.getSurStlpca());
                    }
                }
            }

            // teraz prezerame policko ktore su vlavo dole a vpravo dole od pesiaka(ak je na nich protivnikova figurka, oznacime ich)
            if (paSachovnica.existujePolicko(this.getSurRiadku() + 1, this.getSurStlpca() - 1)) {
                if (paSachovnica.jeObsadenePolicko(this.getSurRiadku() + 1, this.getSurStlpca() - 1)) {
                    if (!paSachovnica.getFarbaFigurky(this.getSurRiadku() + 1, this.getSurStlpca() - 1).equals(this.getFarba())) {
                        paSachovnica.oznacPolicko(this.getSurRiadku() + 1, this.getSurStlpca() - 1);
                    }
                }
            }

            if (paSachovnica.existujePolicko(this.getSurRiadku() + 1, this.getSurStlpca() + 1)) {
                if (paSachovnica.jeObsadenePolicko(this.getSurRiadku() + 1, this.getSurStlpca() + 1)) {
                    if (!paSachovnica.getFarbaFigurky(this.getSurRiadku() + 1, this.getSurStlpca() + 1).equals(this.getFarba())) {
                        paSachovnica.oznacPolicko(this.getSurRiadku() + 1, this.getSurStlpca() + 1);
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
