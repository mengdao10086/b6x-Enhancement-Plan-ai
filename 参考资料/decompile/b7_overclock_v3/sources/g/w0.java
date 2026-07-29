package g;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE})
@sj.b
@sj.c(AnnotationRetention.BINARY)
@sj.a
@Retention(RetentionPolicy.CLASS)
@sj.d(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FIELD, AnnotationTarget.FILE})
@Documented
@Repeatable(a.class)
public @interface w0 {

    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
    @sj.c(AnnotationRetention.BINARY)
    @kotlin.jvm.internal.p0
    @Retention(RetentionPolicy.CLASS)
    @sj.d(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FIELD, AnnotationTarget.FILE})
    public @interface a {
        w0[] value();
    }

    int extension();

    int version();
}
