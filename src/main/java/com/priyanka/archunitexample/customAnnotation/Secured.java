package com.priyanka.archunitexample.customAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

@Target({METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface Secured {
    public String doSomething() default "";
}
