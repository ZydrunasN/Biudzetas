package classes;

import classes.IO.ConsoleIOManager;
import classes.IO.IOManager;
import classes.irasai.Irasas;
import classes.irasai.IslaiduIrasas;
import classes.irasai.PajamuIrasas;

import java.math.BigDecimal;
import java.util.ArrayList;

public final class Biudzetas {
    private static final ArrayList<Irasas> irasai = new ArrayList<>();

    public void pridetiIrasa(final Irasas irasas) {
        irasai.add(irasas);
    }

    public ArrayList<PajamuIrasas> gautiPajamuIrasus() {
        final ArrayList <PajamuIrasas> pajamos = new ArrayList<>();
        for (Irasas irasas : irasai) {
            if (irasas instanceof PajamuIrasas) pajamos.add((PajamuIrasas) irasas);
        }
        return pajamos;
    }

    public ArrayList<IslaiduIrasas> gautiIslaiduIrasus() {
        final ArrayList<IslaiduIrasas> islaidos = new ArrayList<>();
        for (Irasas irasas : irasai) {
            if (irasas instanceof IslaiduIrasas) islaidos.add((IslaiduIrasas) irasas);
        }
        return islaidos;
    }
    
    public Irasas gautiIrasa (final int id) {
        for (Irasas irasas: irasai) {
            if (irasas.getId() == id) return irasas;
        }
        return null;
    }

    public double balansas() {
        BigDecimal money = new BigDecimal(0);

        for (Irasas irasas : irasai) {
            if(irasas instanceof PajamuIrasas) {
                money = money.add(irasas.getSuma());
            } else if(irasas instanceof  IslaiduIrasas) {
                money = money.subtract(irasas.getSuma());
            }
        }

        return money.doubleValue();
    }

    public void pasalintiIrasa (final int id) {
        for (Irasas irasas: irasai) {
            if(irasas.getId() == id) {
                irasai.remove(irasas);
                break;
            }
        }
    }

    public void atnaujintiIrasa(final Irasas naujasIrasas) {
        for (Irasas irasas: irasai) {
            if (irasas.equals(naujasIrasas)) {
                final int index = irasai.indexOf(irasas);
                irasai.set(index,naujasIrasas);
                break;
            }
        }
    }
}