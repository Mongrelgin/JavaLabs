package Lab7;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(3,5,2,6,7);
        System.out.println(ReturnAverrageNumber(integerList));

        List<String> stringList = Arrays.asList("l","sa","popoloo","Hello");
        System.out.println(ReturnToUpperCase(stringList));

        List<Integer> integerList1 = Arrays.asList(3,2,4,3,1,5,6,7,2,6);
        System.out.println(UniqueSimbolsToSquare(integerList1));
    }

    private static List<Integer> UniqueSimbolsToSquare(List<Integer> integerList1) {
        return integerList1.stream()
                //Фильтруем элементы листа, с помощью  метода Collections.frequency, который
                //оставляет все элементы листа повторяющиеся только 1 раз
                .filter(x -> Collections.frequency(integerList1,x) == 1)
                //С помощью map возводим все элементы листа в квадрат
                .map(x -> x*x)
                //Собираем все элементы потока в лист для возрвращения
                .collect(Collectors.toList());
    }

    private static List<String> ReturnToUpperCase(List<String> stringList) {
        return stringList
                //создаем stream из данных нашего листа
                .stream()
                //С помощью map применяем метод toUpperCase ко всем элементам листа
                .map(String::toUpperCase)
                //Собираем все элементы потока в лист для возрвращения
                .collect(Collectors.toList());
    }

    //Метод возвращает среднее значения набора чисел
    private static double ReturnAverrageNumber(List<Integer> integerList){
        return integerList
                //создаем stream из данных нашего листа
                .stream()
                //reduce - все элементы потока превращаем в один, передаем методом лямбда выражение,
                //которое указывает на то, что все числа нужно сложить друг с другом
                .reduce((x,y) -> x+y)
                //Получаем значения и делим его на кол-во элементов в листе
                .get() / (double) integerList.size();
    }
}
