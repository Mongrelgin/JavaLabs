package Labs;

/*
    Дана матрица.
    В каждой строке найти наибольший элемент.
    Из этих элементов найти наименьший и удалить ту строку которой он принадлежит.
    Вывести исходную матрицу и новую.
 */

public class Lab2 {
    public static void main(String[] args) {
        //x - размерность матрицы, counter - нужен для копирования матрицы
        int x = 4, maxNumber = -1, minNumber = 10, vectorNumber = 0, counter = 0;
        int mainMatrix [][] = new int [x][x];
        int endMatrix[][] = new int [x-1][x];
        int vector[] = new int [x];

        //Заполнение и вывод матрицы
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                mainMatrix[i][j] = (int) (Math.random() * 10);
                System.out.print(mainMatrix[i][j] + " ");
            }
            System.out.println();
        }

        //Создание массива с максимальными числами в строках матрицы
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if (mainMatrix[i][j] > maxNumber)
                    maxNumber = mainMatrix[i][j];
            }
            vector[i] = maxNumber;
            maxNumber = -1;
        }

        //for (int i = 0; i < vector.length; i++) {
        //    System.out.print(vector[i]);
        //}
        //Поиск индекса минимального числа в массива
        for (int i = 0; i < x; i++) {

            if (vector[i] < minNumber) {
                minNumber = vector[i];
                vectorNumber = i;
            }

        }

        //System.out.println("    " + vectorNumber);

        System.out.println();

        //Создание новой матрицы и копирование в неё данных исключая найденный массив
        for (int i = 0; i < x-1; i++) {
            if (vectorNumber == i)
                counter++;
            for (int j = 0; j < x; j++) {
                endMatrix[i][j] = mainMatrix[i + counter][j];
                System.out.print(endMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
