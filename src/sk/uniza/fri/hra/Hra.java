package sk.uniza.fri.hra;

import sk.uniza.fri.figurky.Figurka;
import sk.uniza.fri.sachovnica.Sachovnica;

import javax.swing.JOptionPane;

/**
 * 2. 5. 2021 - 21:49
 *
 * @author Dávid
 */
public class Hra {
    private StavHry stav;
    private Sachovnica sachovnica;
    private Figurka zvolFigurka;
    private boolean jeZvolFigurka;

    public Hra() {
        this.sachovnica = Sachovnica.getSachovnica();
        this.stav = StavHry.NEROZHODNUTY;
        this.zvolFigurka = null;
        this.jeZvolFigurka = false;
    }

    /**
     * Metóda pretransformuje súradnice zadané do dialógového okna na súradnice matice, ktorá predstavuje políčka na šachovnici <br>
     * @param surStlpca súradnica stĺpca šachovnice ktorú zadal užívateľ do dialógového okna
     * @param surRiadku súradnica riadku šachovnice ktorú zadal užívateľ do dialógového okna
     * @return vracia pole, v ktorom sa nachádzajú pretransformované súradnice
     */
    private int[] urcSuradniceMatice(String surStlpca, String surRiadku) {
        int riadokMatice;
        int stlpecMatice;
        // premieňa súradnice riadku šachovnice
        if (Character.isDigit(surRiadku.charAt(0))) {
            if ((Integer.parseInt(surRiadku) > 0) && (Integer.parseInt(surRiadku) < 9)) {
                riadokMatice = 8 - Integer.parseInt(surRiadku);
            } else {
                throw new IllegalCoordinatesFormatException();
            }
        } else {
            throw new IllegalCoordinatesFormatException();
        }
        // premieňa súradnice stĺpca šachovnice
        switch (surStlpca) {
            case "A":
                stlpecMatice = 0;
                break;
            case "B":
                stlpecMatice = 1;
                break;
            case "C":
                stlpecMatice = 2;
                break;
            case "D":
                stlpecMatice = 3;
                break;
            case "E":
                stlpecMatice = 4;
                break;
            case "F":
                stlpecMatice = 5;
                break;
            case "G":
                stlpecMatice = 6;
                break;
            case "H":
                stlpecMatice = 7;
                break;
            default:
                throw new IllegalCoordinatesFormatException();
        }
        int[] suradnice = {riadokMatice, stlpecMatice};
        return suradnice;
    }

    public StavHry getStav() {
        return this.stav;
    }

    /**
     * Metóda riadi priebeh celej hry
     */
    public void hraj() {
        this.sachovnica.zobraz();
        JOptionPane.showMessageDialog(null, "Vitaj pri hre Šach. Keď budeš zadávať súradnice políčka, tak napíš najprv písmeno stĺpca veľkým a potom číslo riadku. ");
        while (this.getStav() == StavHry.NEROZHODNUTY) {
            JOptionPane.showMessageDialog(null, "Na rade je biely tím");
            this.tahHraca("white");
            JOptionPane.showMessageDialog(null, "Na rade je čierny tím");
            this.tahHraca("black");
        }
    }

    /**
     * Metóda vyzve hráča na ťah v hre
     * @param farba určuje farbu figúriek, s ktorými hrá hráč, ktorý ide práve na ťah
     */
    public void tahHraca(String farba) {
        String odpoved;
        int[] suradnice;

        while (!this.jeZvolFigurka) {
            try {
                odpoved = JOptionPane.showInputDialog(null, "Napis suradnice policka na ktorom je figurka, ktoru chces zvolit:");
                suradnice = this.urcSuradniceMatice(odpoved.substring(0, 1), odpoved.substring(1));
                this.zvolFigurka = this.sachovnica.zvolFigurku(suradnice[0], suradnice[1]);
            } catch (IllegalCoordinatesFormatException ife) {
                JOptionPane.showMessageDialog(null, "Zadal si súradnice v nesprávnom formáte");
                continue;
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null, "Zadal si neplatné súradnice políčka šachovnice");
                continue;
            }

            if ((this.sachovnica.jeOznaceneAsponJednoPolicko()) && (this.zvolFigurka.getFarba().equals(farba))) {
                this.jeZvolFigurka = true;
            } else {
                this.zvolFigurka = null;
                JOptionPane.showMessageDialog(null, "Figúrku s týmito súradnicami nie je možné zvoliť.");
            }
        }

        while (this.jeZvolFigurka) {
            try {
                odpoved = JOptionPane.showInputDialog(null, "Zadaj suradnice policka, na ktore chces danu figurku posunut");
                suradnice = this.urcSuradniceMatice(odpoved.substring(0, 1), odpoved.substring(1));
                this.sachovnica.posunFigurku(this.zvolFigurka, this.sachovnica.getPolicko(suradnice[0], suradnice[1]));
                this.sachovnica.odznacPolicka();
                this.zvolFigurka = null;
                this.jeZvolFigurka = false;
            } catch (IllegalCoordinatesFormatException icfe) {
                JOptionPane.showMessageDialog(null, "Zadal si súradnice políčka v nesprávnom formáte");
            } catch (IllegalMoveException ime) {
                JOptionPane.showMessageDialog(null, "Na toto políčko sa nemôžeš posunúť");
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null, "Zadal si súradnice políčka mimo šachovnice");
            } finally {
                continue;
            }
        }
    }
}
