package Lab6;

import java.io.*;

public class AllCommands {
    //Поле хранит в себе путь до директории
    private File directory;

    AllCommands(){
        directory = new File("C://Users/mongr/Desktop/JavaTest");
    }

    //Добавление к пути директории из списка
    public void setPathName(String path){
        //Создание нового пути до директории
        File file = new File(directory.getAbsolutePath() + '/' + path);
        //Если директория существует
        if (file.exists() && file.isDirectory()) {
            setDirectory(file);
        }
        else{
            System.out.println("Path is not exist");
        }
    }

    //Вывод всех папок и файлов
    public void printAllThree(){
        //Если мы в папке
        if (directory.isDirectory()){
            //Для каждого элемента в директории
            for (File item : directory.listFiles()){
                if (item.isDirectory()){
                    System.out.println(item.getName() + "\t is folder");
                }
                else if (item.isFile()){
                    System.out.println(item.getName() + "\t is file");
                }
            }
        }
    }

    //Вывод текста из файла на экран
    public void openFile(String fileName){
        //Создаем FileReader
        try (FileReader reader =  new FileReader(directory.getAbsoluteFile() + "/" + fileName)) {
            //Переменная для шагов по кажому символу в файле
            int c;
            //Вывод всех файлов на экран
            while ((c=reader.read())!=-1) System.out.print((char) c);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //Добавить текст или переписать файл
    public void addResetText(String fileName, boolean check, String text){
        //Создаем FileWriter для записи, если check true, то текст добавится в конец, иначе перепишется весь файл
        try (FileWriter writer = new FileWriter(directory.getAbsoluteFile() + "/" + fileName, check)) {
            //Запись текста
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Создание файла
    public void createFile(String fileName){
        //Создание нового файла
        File newFile = new File(directory.getAbsoluteFile() + "/" + fileName);
        try{
            //Запись файла в директорию
            boolean created = newFile.createNewFile();
            //Проверка на запись
            if (created) System.out.println("File " + fileName + " has been created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFile(String fileName){
        //Запись выбранного файла
        File newFile = new File(directory.getAbsoluteFile() + "/" + fileName);
        //Удаление файла
        boolean created = newFile.delete();
        //Проверка на удаление
        if (created) System.out.println("File " + fileName + " has been deleted");
        else System.out.println("File " + fileName + " not found");
    }


    public File getDirectory() {
        return directory;
    }

    public void setDirectory(File directory) {
        //Проверка на существования файла
        if (directory.exists() && directory.isDirectory()) {
            this.directory = directory;
        }
        else{
            System.out.println("Path is not exist");
        }
    }
}
