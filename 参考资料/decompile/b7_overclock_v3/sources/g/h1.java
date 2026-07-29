package g;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
@sj.c(AnnotationRetention.BINARY)
@sj.a
@Documented
@Retention(RetentionPolicy.CLASS)
@sj.d(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER})
public @interface h1 {
}
