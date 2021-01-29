package Lab8;

/*
    Написать аннотацию с целочисленным параметро. Создать класс, содержащий только приватные методды (3-4шт),
    аннотировать любые из них. Вызвать из другого класса все аннотированные методы столько раз, сколько указано
    в параметре аннотации
 */

public class AnnotationClass {
    @AnnotationInterface(annotationValue = 2)
    private void printHelloMethod(){
        System.out.println("Hello!");
    }

    @AnnotationInterface(annotationValue = 3)
    private void printThanksMethod(){
        System.out.println("Thanks!");
    }

    @AnnotationInterface(annotationValue = 4)
    private void printGoodbyeMethod(){
        System.out.println("Goodbye!");
    }
}
