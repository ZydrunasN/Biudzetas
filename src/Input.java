import classes.*;
import classes.irasai.Irasas;
import classes.irasai.IslaiduIrasas;
import classes.irasai.PajamuIrasas;

import java.math.BigDecimal;
import java.time.LocalDate;

final class Input {

     private final Biudzetas budget = new Biudzetas();
     private final Print print = new Print();

    public void pasalintiIrasa() {
        Programa.write.pasalintiIrasaTxt();

        Programa.write.miniTxt5();
        print.atvaizduotiPajamas();
        Programa.write.miniTxt6();
        print.atvaizduotiIslaidas();

        final int id = Programa.in.thisInt();
        if (id < 0) {
            Programa.write.errTxt2();
            return;
        }
        budget.pasalintiIrasa(id);
    }

    public void piniguInesimas () {

        print.pajamuKategorija();
        Programa.write.miniTxt7();
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
        Programa.write.miniTxt7();
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
        Programa.write.redaguotiTxt1(irasas.getSuma());
        Programa.write.arRedaguotitxt();
        byte choice = Programa.in.thisByte();
        if (choice == 1) {
            Programa.write.miniTxt8();
            final BigDecimal suma = Programa.in.thisBigdecimal();
            irasas.setSuma(suma);
        }

        Programa.write.redaguotiTxt2(irasas.getPajamuKategorija().getName());
        Programa.write.arRedaguotitxt();
        choice = Programa.in.thisByte();
        if (choice == 1) {
            Programa.write.miniTxt8();
            print.pajamuKategorija();
            byte kategorija = Programa.in.thisByte();
            irasas.setPajamuKategorija(kategorija);
        }

        Programa.write.redaguotiTxt3(irasas.getPapildomaInformacija());
        Programa.write.arRedaguotitxt();
        choice = Programa.in.thisByte();
        if (choice == 1) {
            Programa.write.miniTxt8();
            String papildomaInformacija = Programa.in.thisWord();
            irasas.setPapildomaInformacija(papildomaInformacija);
        }
        budget.atnaujintiIrasa(irasas);
    }

     public void redaguotiIslaiduIrasa(IslaiduIrasas irasas) {
        byte choice;

         Programa.write.redaguotiTxt1(irasas.getSuma());
         Programa.write.arRedaguotitxt();
         choice = Programa.in.thisByte();
         if (choice == 1) {
             Programa.write.miniTxt8();
             BigDecimal suma = Programa.in.thisBigdecimal();
             irasas.setSuma(suma);
         }

         Programa.write.redaguotiTxt2(irasas.getIslaiduKategorija().getName());
         Programa.write.arRedaguotitxt();
         choice = Programa.in.thisByte();
         if (choice == 1) {
             Programa.write.miniTxt8();
             print.islaiduKategorijaTxt();
             byte kategorija = Programa.in.thisByte();
             irasas.setIslaiduKategorija(kategorija);
         }

         Programa.write.redaguotiTxt4(irasas.getAtsiskaitymoBudas());
         Programa.write.arRedaguotitxt();
         choice = Programa.in.thisByte();
         if (choice == 1) {
             Programa.write.miniTxt8();
             String atsiskaitymoBudas = Programa.in.thisWord();
             irasas.setAtsiskaitymoBudas(atsiskaitymoBudas);
         }

         Programa.write.redaguotiTxt5(irasas.getBankoKortele());
         Programa.write.arRedaguotitxt();
         choice = Programa.in.thisByte();
         if (choice == 1) {
             Programa.write.miniTxt8();
             String bankoKortele = Programa.in.thisWord();
             irasas.setBankoKortele(bankoKortele);
         }
         budget.atnaujintiIrasa(irasas);
     }
}
