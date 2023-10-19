package classes.irasai;

import classes.IslaiduKategorija;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class IslaiduIrasas extends Irasas {
  private String atsiskaitymoBudas;
  private IslaiduKategorija islaiduKategorija;
  private String bankoKortele;

   public IslaiduIrasas (BigDecimal suma, IslaiduKategorija islaiduKategorija, LocalDate data, String atsiskaitymoBudas, String bankoKortele) {
      super(suma,data);
      this.atsiskaitymoBudas = atsiskaitymoBudas;
      this.bankoKortele = bankoKortele;
      this.islaiduKategorija = islaiduKategorija;
   }

   public String getAtsiskaitymoBudas() {
      return atsiskaitymoBudas;
   }

   public String getBankoKortele() {
      return bankoKortele;
   }

    public IslaiduKategorija getIslaiduKategorija() {
        return islaiduKategorija;
    }

    public void setIslaiduKategorija(byte id) {
        islaiduKategorija = IslaiduKategorija.islaiduKategorijaSuID(id);
    }

    public void setAtsiskaitymoBudas(String atsiskaitymoBudas) {
        this.atsiskaitymoBudas = atsiskaitymoBudas;
    }

    public void setBankoKortele(String bankoKortele) {
        this.bankoKortele = bankoKortele;
    }
}
