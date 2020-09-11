package com.priyanka.archunitexample.customAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Target({FIELD})
@Retention(RetentionPolicy.CLASS)
public @interface MyAnnotation {
    public String doSomething() default "";
}
