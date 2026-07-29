package g;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.FIELD, ElementType.METHOD})
@sj.c(AnnotationRetention.BINARY)
@sj.a
@Documented
@Retention(RetentionPolicy.CLASS)
@sj.d(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.FIELD})
public @interface k {
    int api() default -1;

    String codename() default "";

    int extension() default 0;

    int lambda() default -1;

    int parameter() default -1;
}
