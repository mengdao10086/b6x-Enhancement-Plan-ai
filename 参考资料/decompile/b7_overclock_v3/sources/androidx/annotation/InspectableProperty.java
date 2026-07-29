package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.k;
import sj.c;
import sj.d;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.METHOD})
@k(message = "Replaced by the {@code androidx.resourceinpsection} package.")
@c(AnnotationRetention.SOURCE)
@Retention(RetentionPolicy.SOURCE)
@d(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER})
public @interface InspectableProperty {

    public enum ValueType {
        NONE,
        INFERRED,
        INT_ENUM,
        INT_FLAG,
        COLOR,
        GRAVITY,
        RESOURCE_ID
    }

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @c(AnnotationRetention.SOURCE)
    @Retention(RetentionPolicy.SOURCE)
    @d(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS})
    public @interface a {
        String name();

        int value();
    }

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @c(AnnotationRetention.SOURCE)
    @Retention(RetentionPolicy.SOURCE)
    @d(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS})
    public @interface b {
        int mask() default 0;

        String name();

        int target();
    }

    int attributeId() default 0;

    a[] enumMapping() default {};

    b[] flagMapping() default {};

    boolean hasAttributeId() default true;

    String name() default "";

    ValueType valueType() default ValueType.INFERRED;
}
