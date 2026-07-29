package g;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.FIELD, ElementType.METHOD})
@sj.c(AnnotationRetention.BINARY)
@Retention(RetentionPolicy.CLASS)
@sj.d(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER})
public @interface b0 {
    String value();
}
