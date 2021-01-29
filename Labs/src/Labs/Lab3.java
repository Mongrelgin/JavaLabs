package Labs;

/*
    Дана строка.
    Разделить строку на фрагменты по три подряд идущих символа.
    В каждом фаргменте заменить средний символ на случайный символ, не равный соседним.
    Вывести все фаргменты, упорядоченные по алфавиту.
 */

import java.util.Arrays;

public class Lab3 {
    public static void main(String[] args) {
        String text = "this is the text for the third lab!    ";
        //Переменные для символов
        String strMid, strLeft, strRight;
        char[] symbolMid, symbolLeft, symbolRight;
        //Переменная для вычисления нужного индекса основного массива
        int j = 0;

        //Проверка на кол-во символов в строке
        if (text.length() % 3 == 1){
            text = text + "  ";
        }
        else if(text.length() % 3 == 2){
            text = text + " ";
        }

        //Основной массив с тройками символов
        String[] mainVector = new String[text.length()/3];

        for (int i = 0; i < text.length();) {
            //Запись символов из подстроки стринга в отдельный стринг
            strMid = text.substring(i+1, i+2);
            strLeft = text.substring(i,i+1);
            strRight = text.substring(i+2, i+3);

            //Преобразование стринга в чар
            symbolMid = strMid.toCharArray();
            symbolLeft = strLeft.toCharArray();
            symbolRight = strRight.toCharArray();

            //Запись случайного символа в средний символ тройки
            symbolMid[0] = (char) ((Math.random() * 126) + 32);

            //Проверка на равенство между соседними символами
            while (symbolMid[0] == symbolLeft[0] || symbolMid[0] == symbolRight[0]){
                symbolMid[0] = (char) ((Math.random() * 126) + 32);
            }

            //Создание стринга содержащего тройку символов и запись его в массив
            String shortWord = "" + symbolLeft[0] + symbolMid[0] + symbolRight[0];
            mainVector[i-j] = shortWord;

            System.out.println(shortWord);

            j += 2;
            i += 3;
        }

        //Сортировка массива символов
        Arrays.sort(mainVector);
        System.out.println();

        //Вывод массива троек на экран
        for (int i = 0; i < mainVector.length; i++) {
            System.out.println(mainVector[i]);
        }

    }
}
