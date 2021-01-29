package Lab6;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Список комманд
        AllCommands allCommands = new AllCommands();
        //Сканнер для чтения данных из консоли
        Scanner scanner = new Scanner(System.in);
        //Проверка на выход
        boolean exit = false;

        do {
            System.out.print('>');
            //commandCheck Содержит в себе команду из консоли
            String commandCheck = scanner.nextLine();
            switch (commandCheck){
                //Вывод всего каталога
                case "Print" -> allCommands.printAllThree();
                //Вывод текста из файла
                case "Open" ->{
                    System.out.print("Enter file name: ");
                    String fileName = scanner.nextLine();
                    allCommands.openFile(fileName);
                }
                //Перезапись всего текста в файле
                case "Reset" ->{
                    System.out.print("Enter file name: ");
                    String fileName = scanner.nextLine();
                    System.out.print("\nEnter new text: ");
                    String text = scanner.nextLine();
                    allCommands.addResetText(fileName,false, text);
                }
                //Добавление текста в конец файла
                case "Add" ->{
                    System.out.print("Enter file name: ");
                    String fileName = scanner.nextLine();
                    System.out.print("\nEnter additional text: ");
                    String text = scanner.nextLine();
                    allCommands.addResetText(fileName,true, text);
                }
                //Создание нового файла
                case "New" ->{
                    System.out.print("Enter file name: ");
                    String fileName = scanner.nextLine();
                    allCommands.createFile(fileName);
                }
                //Удаление файла
                case "Delete" ->{
                    System.out.print("Enter file name: ");
                    String fileName = scanner.nextLine();
                    allCommands.deleteFile(fileName);
                }
                //Переход к папке из директории
                case "GoToFolder" ->{
                    System.out.print("Enter folder name: ");
                    String folderName = scanner.nextLine();
                    allCommands.setPathName(folderName);
                }
                //Переход к директории через путь
                case "GoToPath" ->{
                    System.out.print("Enter full path name: ");
                    String pathName = scanner.nextLine();
                    allCommands.setDirectory(new File(pathName));
                }
                case "Exit" -> exit = true;

                default -> System.out.println("Command not found!");
            }

        }while (!exit);
    }
}
