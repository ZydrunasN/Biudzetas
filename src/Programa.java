import classes.IO.ConsoleIOManager;
import classes.IO.ConsoleInput;
import classes.IO.ConsoleOutput;
import classes.IO.IOManager;

import java.util.Scanner;

public class Programa {
    private static final Print print = new Print();
    private static final Input input = new Input();
    private static final IOManager console = new ConsoleIOManager();
    public static final ConsoleOutput write = (ConsoleOutput) console.output();
    public static final ConsoleInput in = (ConsoleInput) console.input();


    public static void main(String[] args) {
        boolean veikia = true;

        print.MenuTxtCommands();
        while (veikia) {
            int veiksmas = in.thisInt();

            veikia = meniu(veiksmas);
            System.out.println("Komanda Ivikdyta");
        }
    }

    public static boolean meniu(int veiksmas) {
        switch (veiksmas) {
            case 0 -> { return false; }
            case 1-> input.piniguIsemimas();
            case 2-> input.piniguInesimas();
            case 3-> print.atvaizduotiPajamas();
            case 4-> print.atvaizduotiIslaidas();
            case 5-> print.atvaizduotiBalansa();
            case 6-> print.gautiIrasus();
            case 7-> input.pasalintiIrasa();
            case 8-> input.redaguotiIrasa();
            default-> System.out.println("Neteisinga komanda.");
        }
        return true;
    }
}
