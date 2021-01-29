package Labs;

/*
    Дан массив без повторяющихся элементов.
    Пермешать его так, чтобы каждый элемент оказался на новом месте.
    Вывести изначальный и получившийся массивы.
 */

public class Lab1 {
    public static void main(String[] args) {
        int[] massFirst = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int swapNumber;
        int randomNumber;

        //Вывод массива до перестановки
        for (int i = 0; i < massFirst.length; i++)
            System.out.print(massFirst[i] + " ");

        //Алгоритм сортировки (Фишера - Йетса)
        for (int i = 0; i < massFirst.length; i++){
            randomNumber = (int) (Math.random() * i);
            swapNumber = massFirst[i];
            massFirst[i] = massFirst[randomNumber];
            massFirst[randomNumber] = swapNumber;
        }

        System.out.println();

        //Вывод массива после перестановки
        for (int i = 0; i < massFirst.length; i++)
            System.out.print(massFirst[i] + " ");
    }
}
