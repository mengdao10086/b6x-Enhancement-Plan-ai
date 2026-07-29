package kotlin;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.TYPE})
@r
@v0(version = "1.8")
@sj.c(AnnotationRetention.BINARY)
@Retention(RetentionPolicy.CLASS)
@sj.d(allowedTargets = {AnnotationTarget.CLASS})
public @interface z0 {
    Class<? extends Annotation> markerClass();
}
