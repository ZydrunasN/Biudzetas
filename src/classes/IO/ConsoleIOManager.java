package classes.IO;

import java.util.Scanner;

public final class ConsoleIOManager implements IOManager{
    private final ConsoleInput in = new ConsoleInput();
    private final ConsoleOutput out = new ConsoleOutput();
    private final Scanner sc = new Scanner(System.in);

    public ConsoleIOManager() {
        ConsoleInput consoleInput = new ConsoleInput();
        consoleInput.setScanner(sc);
    }

    @Override
    public Object input() {
        return in;
    }

    @Override
    public Object output() {
        return out;
    }
}
