package Labs;

import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

/*
    Пользователь вводит некоторое число. Записать его цифры в стек.
    Вывести число, у которого цифры идут в обратном порядке.
    Предусмотреть возможность введения произвольного количества чисел.
 */

public class Lab5 {
    public static void main(String[] args) {
        //Сканнер для свитывания чисел из консоли
        Scanner mainScanner = new Scanner(System.in);
        //Список чисел введеных пользователем
        ArrayList<Integer> allNumbers = new ArrayList<>();
        boolean exit = false;

        System.out.println("Enter numbers:");
        while(!exit) {
            try {
                allNumbers.add(mainScanner.nextInt());
            } catch(Exception error) {
                exit = true;
            }
        }

        //Основной стэк, содержит в себе стеки являющиеся числами, где каждый элемент это цифра числа
        Stack[] mainStack = new Stack[allNumbers.size()];

        for (int i = 0; i < allNumbers.size(); i++) {
            //Добавление нового числа
            mainStack[i] = new Stack();
            //Превращаем число в массив символов
            for (char ch: allNumbers.get(i).toString().toCharArray()) {
                //Записываем в стек цифры превращенные обратно в integer
                mainStack[i].push(Character.getNumericValue(ch));
            }
        }

        for (Stack number : mainStack) {
            while(!number.isEmpty()) {
                //Вывод стека с конца и удаление элемента
                System.out.print(number.pop());
            }
            System.out.println();
        }
    }
}
