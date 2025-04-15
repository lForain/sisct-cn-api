package br.gov.mds.siscn.service;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldMetadata {
    String label();
    int order() default 0;
    boolean required() default false;
}