import classes.*;
import classes.irasai.Irasas;
import classes.irasai.IslaiduIrasas;
import classes.irasai.PajamuIrasas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

final class Input {

     private final Biudzetas budget = new Biudzetas();
     private final Print print = new Print();

    public void pasalintiIrasa() {
        Programa.write.pasalintiIrasaTxt();

        System.out.println("------------Pajamos----------------");
        print.atvaizduotiPajamas();
        System.out.println("------------Islaidos----------------");
        print.atvaizduotiIslaidas();

        final int id = Programa.in.thisInt();
        if (id < 0) {
            System.out.println("Blogai įvesti nurodymai!");
            return;
        }
        budget.pasalintiIrasa(id);
    }

    public void piniguInesimas () {

        print.pajamuKategorijaTxt();
        System.out.print("Iveskite kategorijos numeri: ");
        final int kategorija = Programa.in.thisInt();

        Programa.write.piniguInesimasTxt();

        final BigDecimal kiek = Programa.in.thisBigdecimal();
        final String papildomaInfo = Programa.in.thisWord();

        PajamuIrasas pajamos = new PajamuIrasas(
                kiek,
                PajamuKategorija.pajamuKategorijaSuID(kategorija),
                LocalDate.now(),
                true,
                papildomaInfo);

        budget.pridetiIrasa(pajamos);
    }

    public void piniguIsemimas() {
        print.islaiduKategorijaTxt();
        System.out.print("Iveskite kategorijos numeri: ");
        final int kategorija = Programa.in.thisInt();

        Programa.write.piniguIsemimasTxt();

        final BigDecimal kiek = Programa.in.thisBigdecimal();
        final String atsiskaitymoBudas = Programa.in.thisWord();
        final String kortele = Programa.in.thisWord();

        IslaiduIrasas islaidos = new IslaiduIrasas(
                kiek,
                IslaiduKategorija.islaiduKategorijaSuID(kategorija),
                LocalDate.now(),
                atsiskaitymoBudas,
                kortele);
        budget.pridetiIrasa(islaidos);
    }

    public void redaguotiIrasa() {
        print.gautiIrasus();
        Programa.write.redaguotiIrasaTxt();
        final int id = Programa.in.thisInt();
        final Irasas irasas = budget.gautiIrasa(id);

        final PajamuIrasas pajamuIrasas;
        final IslaiduIrasas islaiduIrasas;

        if(irasas instanceof  PajamuIrasas) {
            pajamuIrasas = (PajamuIrasas) irasas;
            redaguotiPajamuIrasa(pajamuIrasas);
        }

        if(irasas instanceof  IslaiduIrasas) {
            islaiduIrasas = (IslaiduIrasas) irasas;
            redaguotiIslaiduIrasa(islaiduIrasas);
        }
    }

    public void redaguotiPajamuIrasa(final PajamuIrasas irasas) {
        System.out.println("Suma: "+irasas.getSuma()+" Eur");
        Programa.write.arRedaguotitxt();
        byte choice = Programa.in.thisByte();
        if (choice == 1) {
            System.out.println("Įveskite naują reikšmę");
            final BigDecimal suma = Programa.in.thisBigdecimal();
            irasas.setSuma(suma);
        }

        System.out.println("Kategorija: "+irasas.getPajamuKategorija().getName());
        Programa.write.arRedaguotitxt();
        choice = Programa.in.thisByte();
        if (choice == 1) {
            System.out.println("Įveskite naują reikšmę");
            print.pajamuKategorijaTxt();
            byte kategorija = Programa.in.thisByte();
            irasas.setPajamuKategorija(kategorija);
        }

        System.out.println("Papildoma informacija: "+irasas.getPapildomaInformacija());
        Programa.write.arRedaguotitxt();
        choice = Programa.in.thisByte();
        if (choice == 1) {
            System.out.println("Įveskite naują reikšmę");
            String papildomaInformacija = Programa.in.thisWord();
            irasas.setPapildomaInformacija(papildomaInformacija);
        }
        budget.atnaujintiIrasa(irasas);
    }

     public void redaguotiIslaiduIrasa(IslaiduIrasas irasas) {
        byte choice;

         System.out.println("Suma: "+irasas.getSuma()+" Eur");
         Programa.write.arRedaguotitxt();
         choice = Programa.in.thisByte();
         if (choice == 1) {
             System.out.println("Įveskite naują reikšmę");
             BigDecimal suma = Programa.in.thisBigdecimal();
             irasas.setSuma(suma);
         }

         System.out.println("Kategorija: "+irasas.getIslaiduKategorija().getName());
         Programa.write.arRedaguotitxt();
         choice = Programa.in.thisByte();
         if (choice == 1) {
             System.out.println("Įveskite naują reikšmę");
             print.islaiduKategorijaTxt();
             byte kategorija = Programa.in.thisByte();
             irasas.setIslaiduKategorija(kategorija);
         }

         System.out.println("Atsiskaitymo budas: "+irasas.getAtsiskaitymoBudas());
         Programa.write.arRedaguotitxt();
         choice = Programa.in.thisByte();
         if (choice == 1) {
             System.out.println("Įveskite naują reikšmę");
             String atsiskaitymoBudas = Programa.in.thisWord();
             irasas.setAtsiskaitymoBudas(atsiskaitymoBudas);
         }

         System.out.println("Banko kortele: "+irasas.getBankoKortele());
         Programa.write.arRedaguotitxt();
         choice = Programa.in.thisByte();
         if (choice == 1) {
             System.out.println("Įveskite naują reikšmę");
             String bankoKortele = Programa.in.thisWord();
             irasas.setBankoKortele(bankoKortele);
         }
         budget.atnaujintiIrasa(irasas);
     }
}
