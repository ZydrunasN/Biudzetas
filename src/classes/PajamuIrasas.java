package classes;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PajamuIrasas extends Irasas{
   private PajamuKategorija pajamuKategorija;
   private boolean arPinigaiGauti;
   private String papildomaInformacija;

    public PajamuIrasas(BigDecimal suma, PajamuKategorija pajamuKategorija,LocalDate data, boolean arPinigaiGauti, String papildomaInformacija) {
        super(suma,data);
        this.arPinigaiGauti = arPinigaiGauti;
        this.papildomaInformacija = papildomaInformacija;
        this.pajamuKategorija = pajamuKategorija;
    }

    public boolean isArPinigaiGauti() {
        return arPinigaiGauti;
    }

    public String getPapildomaInformacija() {
        return papildomaInformacija;
    }

    public PajamuKategorija getPajamuKategorija() {
        return pajamuKategorija;
    }

    public void setPajamuKategorija(byte id) {
        pajamuKategorija = PajamuKategorija.pajamuKategorijaSuID(id);
    }

    public void setPapildomaInformacija(String papildomaInformacija) {
        this.papildomaInformacija = papildomaInformacija;
    }
}
