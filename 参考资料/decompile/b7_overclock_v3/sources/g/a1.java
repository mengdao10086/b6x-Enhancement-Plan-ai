package g;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@sj.c(AnnotationRetention.BINARY)
@sj.a
@Documented
@Retention(RetentionPolicy.CLASS)
@sj.d(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.LOCAL_VARIABLE, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS})
public @interface a1 {
    long max() default Long.MAX_VALUE;

    long min() default Long.MIN_VALUE;

    long multiple() default 1;

    long value() default -1;
}
