package company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("MyBash 1.1 команды:");
        CmdLine.cmdExecute("help");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();

            if (input.length() == 0) continue;
            if (CmdLine.cmdExecute(input)) break;
        }
    }
}
