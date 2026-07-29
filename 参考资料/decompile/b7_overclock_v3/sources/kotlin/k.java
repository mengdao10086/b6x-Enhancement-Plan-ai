package kotlin;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
@sj.a
@Documented
@Retention(RetentionPolicy.RUNTIME)
@sj.d(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.TYPEALIAS})
public @interface k {
    DeprecationLevel level() default DeprecationLevel.WARNING;

    String message();

    t0 replaceWith() default @t0(expression = "", imports = {});
}
