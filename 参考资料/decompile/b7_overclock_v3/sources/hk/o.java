package hk;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.FIELD, ElementType.METHOD})
@sj.c(AnnotationRetention.SOURCE)
@Retention(RetentionPolicy.SOURCE)
@sj.d(allowedTargets = {AnnotationTarget.FILE, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.FIELD})
public @interface o {
}
