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
     private final Scanner sc = new Scanner(System.in);

    public void pasalintiIrasa() {
        print.pasalintiIrasaTxt();

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

        print.piniguInesimasTxt();

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

        print.piniguIsemimasTxt();

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
        print.redaguotiIrasaTxt();
        final int id = sc.nextInt();
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
        print.arRedaguotitxt();
        byte choice = sc.nextByte();
        if (choice == 1) {
            System.out.println("Įveskite naują reikšmę");
            final BigDecimal suma = sc.nextBigDecimal();
            irasas.setSuma(suma);
        }

        System.out.println("Kategorija: "+irasas.getPajamuKategorija().getName());
        print.arRedaguotitxt();
        choice = sc.nextByte();
        if (choice == 1) {
            System.out.println("Įveskite naują reikšmę");
            print.pajamuKategorijaTxt();
            byte kategorija = sc.nextByte();
            irasas.setPajamuKategorija(kategorija);
        }

        System.out.println("Papildoma informacija: "+irasas.getPapildomaInformacija());
        print.arRedaguotitxt();
        choice = sc.nextByte();
        if (choice == 1) {
            System.out.println("Įveskite naują reikšmę");
            String papildomaInformacija = sc.next();
            irasas.setPapildomaInformacija(papildomaInformacija);
        }
        budget.atnaujintiIrasa(irasas);
    }

     public void redaguotiIslaiduIrasa(IslaiduIrasas irasas) {
        byte choice;

         System.out.println("Suma: "+irasas.getSuma()+" Eur");
         print.arRedaguotitxt();
         choice = sc.nextByte();
         if (choice == 1) {
             System.out.println("Įveskite naują reikšmę");
             BigDecimal suma = sc.nextBigDecimal();
             irasas.setSuma(suma);
         }

         System.out.println("Kategorija: "+irasas.getIslaiduKategorija().getName());
         print.arRedaguotitxt();
         choice = sc.nextByte();
         if (choice == 1) {
             System.out.println("Įveskite naują reikšmę");
             print.islaiduKategorijaTxt();
             byte kategorija = sc.nextByte();
             irasas.setIslaiduKategorija(kategorija);
         }

         System.out.println("Atsiskaitymo budas: "+irasas.getAtsiskaitymoBudas());
         print.arRedaguotitxt();
         choice = sc.nextByte();
         if (choice == 1) {
             System.out.println("Įveskite naują reikšmę");
             String atsiskaitymoBudas = sc.next();
             irasas.setAtsiskaitymoBudas(atsiskaitymoBudas);
         }

         System.out.println("Banko kortele: "+irasas.getBankoKortele());
         print.arRedaguotitxt();
         choice = sc.nextByte();
         if (choice == 1) {
             System.out.println("Įveskite naują reikšmę");
             String bankoKortele = sc.next();
             irasas.setBankoKortele(bankoKortele);
         }
         budget.atnaujintiIrasa(irasas);
     }
}
