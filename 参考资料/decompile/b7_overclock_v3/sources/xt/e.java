package xt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes6.dex */
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface e {
    long[] flags() default {};

    Class<?> flagsFromClass() default void.class;

    long[] intValues() default {};

    @yt.j
    String[] stringValues() default {};

    Class<?> valuesFromClass() default void.class;
}
