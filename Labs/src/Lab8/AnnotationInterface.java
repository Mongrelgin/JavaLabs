package Lab8;

import java.lang.annotation.*;
/*
    @Retention(RetentionPolicy.RUNTIME) - будет записана в .class файл и доступна во время выполнения через reflection
    @Target(ElementType.METHOD) - Аннотация применяется для методов
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AnnotationInterface {
    int annotationValue() default 0;
}
