package com.bebetteratjava.customannotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by pb033954 on 4/1/2017.
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WorkHandler {
//    @WorkHandler(useThreadPool)
//    @WorkHandler(false)
    boolean useThreadPool() default true;
//    @WorkHandler()
//    @WorkHandler(false)
//    boolean value() default true;
}