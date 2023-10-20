package classes.IO;

import classes.IslaiduKategorija;
import classes.PajamuKategorija;
import classes.irasai.IslaiduIrasas;
import classes.irasai.PajamuIrasas;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class ConsoleOutput {

    public void atvaizduotiPajamasTxt(int id, BigDecimal suma, String kategorija, LocalDate data, String info) {
        System.out.printf("%s. %s %s %s %s\n",
                id,
                suma,
                kategorija,
                data,
                info
        );
    }

    public void atvaizduotiIslaidasTxt(int id, BigDecimal suma, String kategorija, LocalDate data,
                                    String atsiskaitymas, String kortele) {
        System.out.printf("%s. %s %s %s %s %s\n",
                id,
                suma,
                kategorija,
                data,
                atsiskaitymas,
                kortele
        );
    }

    public void pajamuKategorijaTxt(int i, String kategorija){
        System.out.println("        Nurodykite viena iš nurodytu pajamu kategoriju: \n");
        System.out.printf("%s. %s\n",i ,kategorija);
    }

    public void islaiduKategorijaTxt(int i, String kategorija){
        System.out.println("        Nurodykite viena iš nurodytu Išlaidu kategoriju: \n");
        System.out.printf("%s. %s\n",i, kategorija);
    }

    public void atvaizduotiBalansaTxt(double balansas) {
        System.out.println("Jūsų balansas yra "+balansas+" eurai");
    }

    public void MenuTxtCommands() {
        System.out.println("         Banko operaciju komandos: \n" +
                "0 - Sustabdyti programa\n"+
                "1 - Išsiimti valiutos\n" +
                "2 - Įsidėti pinigu į sąskaitą\n" +
                "3 - Atvaizduoti pajamas\n" +
                "4 - Atvaizduoti islaidas\n" +
                "5 - Pasitikrinti balansa\n" +
                "6 - Atvaizduoti visas pajamas ir visas išlaidas\n" +
                "7 - Pašalinti pajamu arba išlaidu įrašą" +
                "8 - Redaguoti irašą iš duoto sąrašo"
        );
    }

    public void pasalintiIrasaTxt() {
        System.out.println("        (Įrašo pašalinimas) Įrašykite įrašo identifikacini numeri esanti prieš tašką.");
    }

    public void piniguInesimasTxt() {
        System.out.println("        (Pinigu įnešimas į sąskaitą) Įrašykite duota informacija nurodyta tvarka: \n" +
                "kiek įdėti, papildoma informacija"
        );
    }

    public void piniguIsemimasTxt() {
        System.out.println("        (Pinigu išėmimas iš sąskaitos) Įrašykite duota informacija nurodyta tvarka: \n" +
                "kiek išimti, atsiskaitymo būdas, banko kortelė"
        );
    }

    public void redaguotiIrasaTxt() {
        System.out.println("        (Įrašo redagavimas) Nurodikite įrašo Identifikacini numeri(id) kuri norite redaguoti");
    }

    public void arRedaguotitxt() {
        System.out.println("[1] - redaguoti, [2] - toliau");
    }

    public void miniTxt1() {
        System.out.println("\n------------------------------------");
    }

    public void miniTxt2() {
        System.out.println("        Nurodykite viena iš nurodytu Išlaidu kategoriju: \n");
    }
    public void miniTxt3() {
        System.out.println("        Nurodykite viena iš nurodytu pajamu kategoriju: \n");
    }
    public void miniTxt4() {

    }
    public void miniTxt5() {

    }
    public void miniTxt6() {

    }
    public void miniTxt7() {

    }
}
