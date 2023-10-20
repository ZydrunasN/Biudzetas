import classes.*;
import classes.irasai.IslaiduIrasas;
import classes.irasai.PajamuIrasas;

final class Print {
    private final Biudzetas budget = new Biudzetas();

    public void atvaizduotiPajamas() {
        for (PajamuIrasas pajamosAt: budget.gautiPajamuIrasus()) {
            Programa.write.atvaizduotiPajamasTxt(
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
            Programa.write.atvaizduotiIslaidasTxt(
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
        Programa.write.miniTxt3();
        for (PajamuKategorija kategorija: PajamuKategorija.values()) {
            Programa.write.pajamuKategorijaTxt(
                    i++,
                    kategorija.getName()
            );
        }
    }

    public void islaiduKategorijaTxt(){
        int i = 1;
        Programa.write.miniTxt2();
        for (IslaiduKategorija kategorija: IslaiduKategorija.values()) {
            Programa.write.islaiduKategorijaTxt(
                    i++,
                    kategorija.getName()
            );
        }
    }

    public void gautiIrasus() {
        atvaizduotiPajamas();
        Programa.write.miniTxt1();
        atvaizduotiIslaidas();
    }

    public void atvaizduotiBalansa() {
        Programa.write.atvaizduotiBalansaTxt(budget.balansas());
    }
}
