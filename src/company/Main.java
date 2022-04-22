package company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("MyFS 1.0 команды:");
        MyFile.help();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();

            if (input.length() == 0) {
                continue;
            }

            String[] arr = input.split("\\s");
            String cmd = arr[0];
            String path = "";
            if (arr.length >= 2) {
                path = arr[1];
            }
            switch (cmd) {
                case "ls":
                    MyFile.listDirectory(path);
                    break;
                case "ls_py":
                    MyFile.listPythonFiles(path);
                    break;
                case "is_dir":
                    MyFile.isDirectory(path);
                    break;
                case "define":
                    MyFile.define(path);
                    break;
                case "readmod":
                    MyFile.printPermissions(path);
                    break;
                case "setmod":
                    if (arr.length == 3) {
                        MyFile.setPermissions(path, arr[2]);
                    } else {
                        System.out.println("Ошибка! не правильно использованна команда, чтобы " +
                                "ознакомиться с командами введите help");
                    }
                    break;
                case "cat":
                    MyFile.printContent(path);
                    break;
                case "append":
                    MyFile.appendFooter(path);
                    break;
                case "bc":
                    MyFile.createBackup(path);
                    break;
                case "greplong":
                    MyFile.printLongestWord(path);
                    break;
                case "help":
                    MyFile.help();
                    break;
                case "exit":
                    boolean res = MyFile.exit();
                    if (res) {
                        return;
                    }
                    break;
                default:
                    System.out.println("Ошибка! Команда не существует чтобы ознакомиться с командами введите help");
            }
        }
    }
}
