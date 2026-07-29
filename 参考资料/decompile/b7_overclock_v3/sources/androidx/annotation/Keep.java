package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import sj.c;
import sj.d;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.PACKAGE, ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD})
@c(AnnotationRetention.BINARY)
@Retention(RetentionPolicy.CLASS)
@d(allowedTargets = {AnnotationTarget.FILE, AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS, AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.FIELD})
public @interface Keep {
}
