package sk.uniza.fri.sachovnica;

import sk.uniza.fri.figurky.Figurka;
import sk.uniza.fri.figurky.Dama;
import sk.uniza.fri.figurky.Jazdec;
import sk.uniza.fri.figurky.Veza;
import sk.uniza.fri.figurky.Kral;
import sk.uniza.fri.figurky.Pesiak;
import sk.uniza.fri.figurky.Strelec;
import sk.uniza.fri.sachovnica.grafickeObjekty.Znak;

/**
 * Trieda Sachovnica vytvorí maximálne jednu šachovnicu, ktorá sa dá zobraziť na plátne
 * 
 * @author (Dávid Mičo) 
 * @version (08.01.2021)
 */
public class Sachovnica {
    //atribúty triedy
    private static Sachovnica instancia; // jediná inštancia šachovnice ktorá sa dá vytvoriť
    private static final int ROZMER_POLICKA = 75; // finálny atribút triedy ktorý určuje rozmer jedného políčka šachovnice
    private static final String FARBA_FIGURIEK1 = "black";
    private static final String FARBA_FIGURIEK2 = "white";
    //atribúty inštancie
    private Policko[][] policka;
    private Figurka[][] figurky;
    private Znak[] pismena; // pole súradníc stĺpcov pod šachovnicou
    private Znak[] cisla; // pole súradníc riadkov vľavo od šachovnice
    private final int pocetPolicok = 8; // počet políčok na jednom riadku šachovnice
    private final String farbaPolicok1 = "white";
    private final String farbaPolicok2 = "lightGray"; // farby políčok na šachovnici
    
    /**
     * Konštruktor triedy Sachovnica bez parametrov - vytvorí šachovnicu s pevne danou veľkosťou a umiestnením na plátne
     */
    private Sachovnica() {
        this.policka = new Policko[this.pocetPolicok][this.pocetPolicok];
        this.figurky = new Figurka[this.pocetPolicok][this.pocetPolicok];
        int rozmerPolicka = Sachovnica.ROZMER_POLICKA;
        // vytvorenie políčok šachovnice
        int odsadenieSachovnice = 6 * rozmerPolicka;
        for (int riadok = 0; riadok < this.policka.length; riadok++) {
            for (int stlpec = 0; stlpec < this.policka[0].length; stlpec++) {
                if (riadok % 2 == 0) {
                    if (stlpec % 2 == 0) {
                        this.policka[riadok][stlpec] = new Policko(riadok, stlpec, stlpec * rozmerPolicka + odsadenieSachovnice, riadok * rozmerPolicka, this.farbaPolicok1);
                    } else {
                        this.policka[riadok][stlpec] = new Policko(riadok, stlpec, stlpec * rozmerPolicka + odsadenieSachovnice, riadok * rozmerPolicka, this.farbaPolicok2);
                    }
                } else {
                    if (stlpec % 2 == 0) {
                        this.policka[riadok][stlpec] = new Policko(riadok, stlpec, stlpec * rozmerPolicka + odsadenieSachovnice, riadok * rozmerPolicka, this.farbaPolicok2);
                    } else {
                        this.policka[riadok][stlpec] = new Policko(riadok, stlpec, stlpec * rozmerPolicka + odsadenieSachovnice, riadok * rozmerPolicka, this.farbaPolicok1);
                    }
                }
            }
        }

        this.pismena = new Znak[8];
        this.cisla = new Znak[8];
        // vytvorenie pomocného riadku pod políčkami šachovnice, určujúceho súradnice stĺpcov šachovnice 
        this.pismena[0] = new Znak("A", 0 * rozmerPolicka + (rozmerPolicka + 15) + 5 * rozmerPolicka, rozmerPolicka * 9 - 10);
        this.pismena[1] = new Znak("B", 1 * rozmerPolicka + (rozmerPolicka + 15) + 5 * rozmerPolicka, rozmerPolicka * 9 - 10);
        this.pismena[2] = new Znak("C", 2 * rozmerPolicka + (rozmerPolicka + 15) + 5 * rozmerPolicka, rozmerPolicka * 9 - 10);
        this.pismena[3] = new Znak("D", 3 * rozmerPolicka + (rozmerPolicka + 15) + 5 * rozmerPolicka, rozmerPolicka * 9 - 10);
        this.pismena[4] = new Znak("E", 4 * rozmerPolicka + (rozmerPolicka + 15) + 5 * rozmerPolicka, rozmerPolicka * 9 - 10);
        this.pismena[5] = new Znak("F", 5 * rozmerPolicka + (rozmerPolicka + 15) + 5 * rozmerPolicka, rozmerPolicka * 9 - 10);
        this.pismena[6] = new Znak("G", 6 * rozmerPolicka + (rozmerPolicka + 15) + 5 * rozmerPolicka, rozmerPolicka * 9 - 10);
        this.pismena[7] = new Znak("H", 7 * rozmerPolicka + (rozmerPolicka + 15) + 5 * rozmerPolicka, rozmerPolicka * 9 - 10);
        // vytvorenie pomocného stĺpca vľavo od šachovnice, určujúceho súradnice riadkov šachovnice
        for (int i = 8; i > 0; i--) {
            this.cisla[i - 1] = new Znak(i + "", 20 + 5 * rozmerPolicka, (9 - i) * rozmerPolicka - 15);
        }

        // umiestňovanie figúriek na šachovnicu
        for (int riadok = 0; riadok < this.pocetPolicok; riadok++) {
            for (int stlpec = 0; stlpec < this.pocetPolicok; stlpec++) {
                if (riadok == 0) {
                    if ((stlpec == 0) || (stlpec == 7)) {
                        this.figurky[riadok][stlpec] = new Veza(riadok, stlpec, stlpec * rozmerPolicka + rozmerPolicka / 10 + odsadenieSachovnice, rozmerPolicka / 10, this.FARBA_FIGURIEK1);
                    } else if ((stlpec == 1) || (stlpec == 6)) {
                        this.figurky[riadok][stlpec] = new Jazdec(riadok, stlpec, stlpec * rozmerPolicka + rozmerPolicka / 10 + odsadenieSachovnice, rozmerPolicka / 10, this.FARBA_FIGURIEK1);
                    } else if ((stlpec == 2) || (stlpec == 5)) {
                        this.figurky[riadok][stlpec] = new Strelec(riadok, stlpec, stlpec * rozmerPolicka + rozmerPolicka / 10 + odsadenieSachovnice, rozmerPolicka / 10, this.FARBA_FIGURIEK1);
                    } else if (stlpec == 3) {
                        this.figurky[riadok][stlpec] = new Dama(riadok, stlpec, stlpec * rozmerPolicka + rozmerPolicka / 10 + odsadenieSachovnice, rozmerPolicka / 10, this.FARBA_FIGURIEK1);
                    } else {
                        this.figurky[riadok][stlpec] = new Kral(riadok, stlpec, stlpec * rozmerPolicka + rozmerPolicka / 10 + odsadenieSachovnice, rozmerPolicka / 10, this.FARBA_FIGURIEK1);
                    }
                } else if (riadok == 1) {
                    this.figurky[riadok][stlpec] = new Pesiak(riadok, stlpec, stlpec * rozmerPolicka + rozmerPolicka / 10 + odsadenieSachovnice, riadok * rozmerPolicka + rozmerPolicka / 10, this.FARBA_FIGURIEK1);
                } else if (riadok == 6) {
                    this.figurky[riadok][stlpec] = new Pesiak(riadok, stlpec, stlpec * rozmerPolicka + rozmerPolicka / 10 + odsadenieSachovnice, riadok * rozmerPolicka + rozmerPolicka / 10, this.FARBA_FIGURIEK2);
                } else if (riadok == 7) {
                    if ((stlpec == 0) || (stlpec == 7)) {
                        this.figurky[riadok][stlpec] = new Veza(riadok, stlpec, stlpec * rozmerPolicka + rozmerPolicka / 10 + odsadenieSachovnice, riadok * rozmerPolicka + rozmerPolicka / 10, this.FARBA_FIGURIEK2);
                    } else if ((stlpec == 1) || (stlpec == 6)) {
                        this.figurky[riadok][stlpec] = new Jazdec(riadok, stlpec, stlpec * rozmerPolicka + rozmerPolicka / 10 + odsadenieSachovnice, riadok * rozmerPolicka + rozmerPolicka / 10, this.FARBA_FIGURIEK2);
                    } else if ((stlpec == 2) || (stlpec == 5)) {
                        this.figurky[riadok][stlpec] = new Strelec(riadok, stlpec, stlpec * rozmerPolicka + rozmerPolicka / 10 + odsadenieSachovnice, riadok * rozmerPolicka + rozmerPolicka / 10, this.FARBA_FIGURIEK2);
                    } else if (stlpec == 3) {
                        this.figurky[riadok][stlpec] = new Dama(riadok, stlpec, stlpec * rozmerPolicka + rozmerPolicka / 10 + odsadenieSachovnice, riadok * rozmerPolicka + rozmerPolicka / 10, this.FARBA_FIGURIEK2);
                    } else {
                        this.figurky[riadok][stlpec] = new Kral(riadok, stlpec, stlpec * rozmerPolicka + rozmerPolicka / 10 + odsadenieSachovnice, riadok * rozmerPolicka + rozmerPolicka / 10, this.FARBA_FIGURIEK2);
                    }
                }
            }
        }
    }
    
    // metódy triedy
    /**
     * Metóda vráti jedinú inštanciu triedy Sachovnica, ak nie je ešte vytvorená, tak ju vytvorí <br>
     * @return vráti inštanciu triedy Sachovnica
     */
    public static Sachovnica getSachovnica() {
        if (Sachovnica.instancia == null) {
            Sachovnica.instancia = new Sachovnica();
        }
        
        return Sachovnica.instancia;
    }
    
    /**
     * @return vráti rozmer políčka na šachovnici
     */
    public static int getRozmerPolicka() {
        return Sachovnica.ROZMER_POLICKA;
    }

    public static String getFarbaFiguriek1() {
        return FARBA_FIGURIEK1;
    }

    public static String getFarbaFiguriek2() {
        return FARBA_FIGURIEK2;
    }

    public Policko getPolicko(int paSurRiadku, int paSurStlpca) {
        if ((paSurRiadku >= 0) && (paSurRiadku < this.pocetPolicok) && (paSurStlpca >= 0) && (paSurStlpca < this.pocetPolicok)) {
            return this.policka[paSurRiadku][paSurStlpca];
        } else {
            throw new IllegalArgumentException("Neplatné súradnice políčka");
        }
    }

    public String getFarbaFigurky(int paSurRiadku, int paSurStlpca) {
        return this.figurky[paSurRiadku][paSurStlpca].getFarba();
    }

    /**
     * Metóda zistí či je označené(môžeme sa na neho posunúť) aspoň jedno políčko na šachovnici
     * @return
     */
    public boolean jeOznaceneAsponJednoPolicko() {
        for (int riadok = 0; riadok < this.pocetPolicok; riadok++) {
            for (int stlpec = 0; stlpec < this.pocetPolicok; stlpec++) {
                if (this.policka[riadok][stlpec].jeOznacene()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean jeObsadenePolicko(int paRiadok, int paStlpec) {
        return this.figurky[paRiadok][paStlpec] != null;
    }
    
    /**
     * Metóda zobrazí celú šachovnicu na plátne
     */
    public void zobraz() {
        for (int i = 0; i < 8; i++) {
            this.pismena[i].zobraz();
        }    
        
        for (int j = 0; j < 8; j++) {
            this.cisla[j].zobraz();
        } 
        
        for (int riadok = 0; riadok < this.policka.length; riadok++) {
            for (int stlpec = 0; stlpec < this.policka[0].length; stlpec++) {
                this.policka[riadok][stlpec].zobraz();
                if (this.figurky[riadok][stlpec] != null) {
                    this.figurky[riadok][stlpec].zobraz();
                }
            }
        }
    }   
    
    /**
     * Metóda označí dané políčko (môže na neho figúrka preskočiť) na šachovnici
     * @param paRiadok číslo riadku políčka ktoré chceme označiť
     * @param paStlpec číslo stĺpca políčka ktoré chceme označiť
     */
    public void oznacPolicko(int paRiadok, int paStlpec) {
        this.policka[paRiadok][paStlpec].oznac();
    }

    /**
     * Metóda zvolí figúrku na konkrétnom riadku a stĺpci
     * @param paSurRiadku súradnica riadku figúrky, ktorú ideme zvoliť
     * @param paSurStlpca súradnica stĺpca figúrky, ktorú ideme zvoliť
     * @return
     */
    public Figurka zvolFigurku(int paSurRiadku, int paSurStlpca) {
        if ((paSurRiadku >= 0) && (paSurRiadku < this.pocetPolicok) && (paSurStlpca >= 0) && (paSurStlpca < this.pocetPolicok)) {
            if (this.figurky[paSurRiadku][paSurStlpca] != null) {
                this.figurky[paSurRiadku][paSurStlpca].zvol(this);
                return this.figurky[paSurRiadku][paSurStlpca];
            } else {
                throw new IllegalArgumentException("Na tomto políčku sa nenachádza figúrka");
            }
        } else {
            throw new IllegalArgumentException("Neplatné súradnice figúrky");
        }
    }

    /**
     * Metóda posunie figúrku na konkrétne políčko(ak sa dá)
     * @param figurka figúrka, ktorú ideme posúvať
     * @param policko políčko, na ktoré chceme posunúť figúrku
     */
    public void posunFigurku(Figurka figurka, Policko policko) {
        figurka.posun(policko, this);

        if (this.figurky[policko.getSurRiadku()][policko.getSurStlpca()] != null) {
            this.figurky[policko.getSurRiadku()][policko.getSurStlpca()].skry();
        }

        this.figurky[figurka.getSurRiadku()][figurka.getSurStlpca()] = null;
        this.figurky[policko.getSurRiadku()][policko.getSurStlpca()] = figurka;
    }
    
    /**
     * Metóda zvýrazní dané políčko (nachádza sa na ňom figúrka, ktorú sme si zvolili) na šachovnici
     * @param paRiadok číslo riadku políčka ktoré chceme zvýrazniť
     * @param paStlpec číslo stĺpca políčka ktoré chceme zvýrazniť
     */
    public void zvyrazniPolicko(int paRiadok, int paStlpec) {
        this.policka[paRiadok][paStlpec].zvyrazni();
    }
    
    /**
     * Metóda odznačí všetky políčka na šachovnici
     */
    public void odznacPolicka() {
        for (int riadok = 0; riadok < this.policka.length; riadok++) {
            for (int stlpec = 0; stlpec < this.policka[riadok].length; stlpec++) { 
                if ((this.policka[riadok][stlpec].jeOznacene()) || (this.policka[riadok][stlpec].jeZvyraznene())) {
                    this.policka[riadok][stlpec].odznac();
                }
            }
        }
    }   
    
    /**
     * Metóda zistí či je na šachovnici políčko s danými súradnicami
     * @param paRiadok číslo riadku políčka
     * @param paStlpec číslo stĺpca políčka
     * @return vráti true ak existuje políčko s danými súradnicami
     */
    public boolean existujePolicko(int paRiadok, int paStlpec) {
        return (paRiadok < this.policka.length) && (paRiadok >= 0) && (paStlpec < this.policka[0].length) && (paStlpec >= 0);
    }
}
