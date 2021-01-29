package Lab8;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        //Наш аннатируемый класс
        AnnotationClass annotationClass = new AnnotationClass();
        //получаем объект Class нашего аннатируемого класса, для вызова методов
        Class<?> c = annotationClass.getClass();
        //Для всех методов, которые есть в классе
        for (Method m : c.getDeclaredMethods()){
            //Если метод аннатируем нашим AnnotationInterface
            if (m.isAnnotationPresent(AnnotationInterface.class)){
                //Принудительное переключение доступа
                m.setAccessible(true);
                //Повторяем операцию в количестве, указанном в параметре аннотации
                for (int i = 0; i < m.getAnnotation(AnnotationInterface.class).annotationValue(); i++){
                    try {
                        //Вызов метода у аннотируемого класса
                        m.invoke(annotationClass);
                    }
                    catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
