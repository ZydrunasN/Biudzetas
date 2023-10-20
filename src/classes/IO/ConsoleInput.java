package classes.IO;

import java.math.BigDecimal;
import java.util.Scanner;

public final class ConsoleInput {
    private static Scanner sc;

    public int thisInt() {
        return sc.nextInt();
    }

    public String thisWord() {
        return sc.next();
    }

    public BigDecimal thisBigdecimal() {
        return sc.nextBigDecimal();
    }

    public byte thisByte() {
        return sc.nextByte();
    }

    public void setScanner(Scanner sc) {
        this.sc = sc;
    }
}
