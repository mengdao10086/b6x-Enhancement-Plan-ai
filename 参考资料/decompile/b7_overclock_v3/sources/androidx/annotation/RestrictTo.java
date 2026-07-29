package androidx.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import sj.a;
import sj.c;
import sj.d;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE})
@c(AnnotationRetention.BINARY)
@a
@Documented
@Retention(RetentionPolicy.CLASS)
@d(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FIELD, AnnotationTarget.FILE})
public @interface RestrictTo {

    public enum Scope {
        LIBRARY,
        LIBRARY_GROUP,
        LIBRARY_GROUP_PREFIX,
        GROUP_ID,
        TESTS,
        SUBCLASSES
    }

    Scope[] value();
}
