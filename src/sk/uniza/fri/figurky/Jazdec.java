package sk.uniza.fri.figurky;

import sk.uniza.fri.sachovnica.Sachovnica;
import sk.uniza.fri.sachovnica.grafickeObjekty.Obrazok;

/**
 * 2. 5. 2021 - 21:49
 *
 * @author Dávid
 */
public class Jazdec extends Figurka {
    private Obrazok obrazok;

    public Jazdec(int surRiadku, int surStlpca, int paLavyHornyX, int paLavyHornyY, String farba) {
        super(surRiadku, surStlpca, paLavyHornyX, paLavyHornyY, farba);
        if (farba.equals("white")) {
            this.obrazok = new Obrazok("Knight_White.png", paLavyHornyX, paLavyHornyY, this.getRozmer(), this.getRozmer());
        } else {
            this.obrazok = new Obrazok("Knight_Black.png", paLavyHornyX, paLavyHornyY, this.getRozmer(), this.getRozmer());
        }
    }

    @Override
    public void zvol(Sachovnica paSachovnica) {
        // v cykle postupne prezerame vsetky policka, na ktore ma na sachovnici kon dosah
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    if (paSachovnica.existujePolicko(this.getSurRiadku() - 1, this.getSurStlpca() - 2)) {
                        if (!paSachovnica.jeObsadenePolicko(this.getSurRiadku() - 1, this.getSurStlpca() - 2)) {
                            paSachovnica.oznacPolicko(this.getSurRiadku() - 1, this.getSurStlpca() - 2);
                        } else {
                            if (!paSachovnica.getFarbaFigurky(this.getSurRiadku() - 1, this.getSurStlpca() - 2).equals(this.getFarba())) {
                                paSachovnica.oznacPolicko(this.getSurRiadku() - 1, this.getSurStlpca() - 2);
                            }
                        }
                    }

                    if (paSachovnica.existujePolicko(this.getSurRiadku() + 1, this.getSurStlpca() - 2)) {
                        if (!paSachovnica.jeObsadenePolicko(this.getSurRiadku() + 1, this.getSurStlpca() - 2)) {
                            paSachovnica.oznacPolicko(this.getSurRiadku() + 1, this.getSurStlpca() - 2);
                        } else {
                            if (!paSachovnica.getFarbaFigurky(this.getSurRiadku() + 1, this.getSurStlpca() - 2).equals(this.getFarba())) {
                                paSachovnica.oznacPolicko(this.getSurRiadku() + 1, this.getSurStlpca() - 2);
                            }
                        }
                    }
                    continue;
                case 3:
                    if (paSachovnica.existujePolicko(this.getSurRiadku() - 1, this.getSurStlpca() + 2)) {
                        if (!paSachovnica.jeObsadenePolicko(this.getSurRiadku() - 1, this.getSurStlpca() + 2)) {
                            paSachovnica.oznacPolicko(this.getSurRiadku() - 1, this.getSurStlpca() + 2);
                        } else {
                            if (!paSachovnica.getFarbaFigurky(this.getSurRiadku() - 1, this.getSurStlpca() + 2).equals(this.getFarba())) {
                                paSachovnica.oznacPolicko(this.getSurRiadku() - 1, this.getSurStlpca() + 2);
                            }
                        }
                    }

                    if (paSachovnica.existujePolicko(this.getSurRiadku() + 1, this.getSurStlpca() + 2)) {
                        if (!paSachovnica.jeObsadenePolicko(this.getSurRiadku() + 1, this.getSurStlpca() + 2)) {
                            paSachovnica.oznacPolicko(this.getSurRiadku() + 1, this.getSurStlpca() + 2);
                        } else {
                            if (!paSachovnica.getFarbaFigurky(this.getSurRiadku() + 1, this.getSurStlpca() + 2).equals(this.getFarba())) {
                                paSachovnica.oznacPolicko(this.getSurRiadku() + 1, this.getSurStlpca() + 2);
                            }
                        }
                    }
                    continue;
                case 1:
                    if (paSachovnica.existujePolicko(this.getSurRiadku() - 2, this.getSurStlpca() - 1)) {
                        if (!paSachovnica.jeObsadenePolicko(this.getSurRiadku() - 2, this.getSurStlpca() - 1)) {
                            paSachovnica.oznacPolicko(this.getSurRiadku() - 2, this.getSurStlpca() - 1);
                        } else {
                            if (!paSachovnica.getFarbaFigurky(this.getSurRiadku() - 2, this.getSurStlpca() - 1).equals(this.getFarba())) {
                                paSachovnica.oznacPolicko(this.getSurRiadku() - 2, this.getSurStlpca() - 1);
                            }
                        }
                    }

                    if (paSachovnica.existujePolicko(this.getSurRiadku() + 2, this.getSurStlpca() - 1)) {
                        if (!paSachovnica.jeObsadenePolicko(this.getSurRiadku() + 2, this.getSurStlpca() - 1)) {
                            paSachovnica.oznacPolicko(this.getSurRiadku() + 2, this.getSurStlpca() - 1);
                        } else {
                            if (!paSachovnica.getFarbaFigurky(this.getSurRiadku() + 2, this.getSurStlpca() - 1).equals(this.getFarba())) {
                                paSachovnica.oznacPolicko(this.getSurRiadku() + 2, this.getSurStlpca() - 1);
                            }
                        }
                    }
                    continue;
                case 2:
                    if (paSachovnica.existujePolicko(this.getSurRiadku() - 2, this.getSurStlpca() + 1)) {
                        if (!paSachovnica.jeObsadenePolicko(this.getSurRiadku() - 2, this.getSurStlpca() + 1)) {
                            paSachovnica.oznacPolicko(this.getSurRiadku() - 2, this.getSurStlpca() + 1);
                        } else {
                            if (!paSachovnica.getFarbaFigurky(this.getSurRiadku() - 2, this.getSurStlpca() + 1).equals(this.getFarba())) {
                                paSachovnica.oznacPolicko(this.getSurRiadku() - 2, this.getSurStlpca() + 1);
                            }
                        }
                    }

                    if (paSachovnica.existujePolicko(this.getSurRiadku() + 2, this.getSurStlpca() + 1)) {
                        if (!paSachovnica.jeObsadenePolicko(this.getSurRiadku() + 2, this.getSurStlpca() + 1)) {
                            paSachovnica.oznacPolicko(this.getSurRiadku() + 2, this.getSurStlpca() + 1);
                        } else {
                            if (!paSachovnica.getFarbaFigurky(this.getSurRiadku() + 2, this.getSurStlpca() + 1).equals(this.getFarba())) {
                                paSachovnica.oznacPolicko(this.getSurRiadku() + 2, this.getSurStlpca() + 1);
                            }
                        }
                    }
                    continue;
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