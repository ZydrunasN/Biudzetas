package classes;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Biudzetas {
    private static ArrayList<Irasas> irasai = new ArrayList<>();

    public void pridetiIrasa(Irasas irasas) {
        irasai.add(irasas);
    }

    public ArrayList<PajamuIrasas> gautiPajamuIrasus() {
        ArrayList <PajamuIrasas> pajamos = new ArrayList<>();
        for (Irasas irasas : irasai) {
            if (irasas instanceof PajamuIrasas) pajamos.add((PajamuIrasas) irasas);
        }
        return pajamos;
    }

    public ArrayList<IslaiduIrasas> gautiIslaiduIrasus() {
        ArrayList<IslaiduIrasas> islaidos = new ArrayList<>();
        for (Irasas irasas : irasai) {
            if (irasas instanceof IslaiduIrasas) islaidos.add((IslaiduIrasas) irasas);
        }
        return islaidos;
    }
    
    public Irasas gautiIrasa (int id) {
        for (Irasas irasas: irasai) {
            if (irasas.getId() == id) return irasas;
        }
        return null;
    }

    public double balansas() {
        BigDecimal money = new BigDecimal(0);

        for (PajamuIrasas pajam : gautiPajamuIrasus()) {
            money = money.add(pajam.getSuma());
        }

        for (IslaiduIrasas islaid : gautiIslaiduIrasus()) {
            money = money.subtract(islaid.getSuma());
        }

        return money.doubleValue();
    }

    public void pasalintiIrasa (int id) {
        for (Irasas irasas: irasai) {
            if(irasas.getId() == id) {
                irasai.remove(irasas);
                break;
            }
        }
    }

    public void atnaujintiIrasa(Irasas naujasIrasas) {
        for (Irasas irasas: irasai) {
            if (irasas.getId() == naujasIrasas.getId()) {
                int index = irasai.indexOf(irasas);
                irasai.set(index,naujasIrasas);
            }
        }
    }
}