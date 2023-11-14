package classes.IO;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public final class ConsoleInput {
    private static Scanner sc;

    public int thisInt() {
        try {
            return Integer.parseInt(sc.next());
        } catch (NumberFormatException e){
            System.err.println("Klaida! įvedėte ne skaičiu, prašau įvesti skaičių");
            return Integer.parseInt(sc.next());
        }
    }

    public String thisWord() {
        return sc.next();
    }

    public BigDecimal thisBigdecimal() {
        return sc.nextBigDecimal();
    }

    public byte thisByte() {
        try {
            return Byte.parseByte(sc.next());
        } catch (NumberFormatException e) {
            System.err.println("Klaida! įvedėte ne skaičiu, prašau įvesti skaičių");
            return Byte.parseByte(sc.next());
        }
    }

    public void setScanner(Scanner sc) {
        this.sc = sc;
    }
}
