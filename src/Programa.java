import java.util.Scanner;

public class Programa {
    private final static Print print = new Print();
    private final static Input input = new Input();
    private final static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        boolean veikia = true;

        print.MenuTxtCommands();
        while (veikia) {
            int veiksmas = sc.nextInt();

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
