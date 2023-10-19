import classes.*;
import classes.irasai.IslaiduIrasas;
import classes.irasai.PajamuIrasas;

final class Print {
    private final Biudzetas budget = new Biudzetas();

    public void atvaizduotiPajamas() {
        for (PajamuIrasas pajamosAt: budget.gautiPajamuIrasus()) {
            System.out.printf("%s. %s %s %s %s\n",
                    pajamosAt.getId(),
                    pajamosAt.getSuma(),
                    pajamosAt.getPajamuKategorija().getName(),
                    pajamosAt.getData(),
                    pajamosAt.getPapildomaInformacija()
            );
        }
    }

    public void atvaizduotiIslaidas() {
        for (IslaiduIrasas islaidosAt: budget.gautiIslaiduIrasus()) {
            System.out.printf("%s. %s %s %s %s %s\n",
                    islaidosAt.getId(),
                    islaidosAt.getSuma(),
                    islaidosAt.getIslaiduKategorija().getName(),
                    islaidosAt.getData(),
                    islaidosAt.getAtsiskaitymoBudas(),
                    islaidosAt.getBankoKortele()
            );
        }
    }

    public void pajamuKategorijaTxt(){
        int i = 1;
        System.out.println("        Nurodykite viena iš nurodytu pajamu kategoriju: \n");
        for (PajamuKategorija kategorija: PajamuKategorija.values()) {
            System.out.printf("%s. %s\n",
                    i++,
                    kategorija.getName()
            );
        }
    }

    public void islaiduKategorijaTxt(){
        int i = 1;
        System.out.println("        Nurodykite viena iš nurodytu Išlaidu kategoriju: \n");
        for (IslaiduKategorija kategorija: IslaiduKategorija.values()) {
            System.out.printf("%s. %s\n",
                    i++,
                    kategorija.getName()
            );
        }
    }

    public void gautiIrasus() {
        atvaizduotiPajamas();
        System.out.println("\n------------------------------------");
        atvaizduotiIslaidas();
    }

    public void atvaizduotiBalansa() {
        System.out.println("Jūsų balansas yra "+budget.balansas()+" eurai");
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
                "8 - Redaguoti irašą iš duoto sąrašo");
    }

    public void pasalintiIrasaTxt() {
        System.out.println("        (Įrašo pašalinimas) Įrašykite įrašo identifikacini numeri esanti prieš tašką.");
    }

    public void piniguInesimasTxt() {
        System.out.println("        (Pinigu įnešimas į sąskaitą) Įrašykite duota informacija nurodyta tvarka: \n" +
                "kiek įdėti, papildoma informacija");
    }

    public void piniguIsemimasTxt() {
        System.out.println("        (Pinigu išėmimas iš sąskaitos) Įrašykite duota informacija nurodyta tvarka: \n" +
                "kiek išimti, atsiskaitymo būdas, banko kortelė");
    }

    public void redaguotiIrasaTxt() {
        System.out.println("        (Įrašo redagavimas) Nurodikite įrašo Identifikacini numeri(id) kuri norite redaguoti");
    }

    public void arRedaguotitxt() {
        System.out.println("[1] - redaguoti, [2] - toliau");
    }
}
