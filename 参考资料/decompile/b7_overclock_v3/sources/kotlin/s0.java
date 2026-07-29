package kotlin;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@v0(version = "1.1")
@sj.c(AnnotationRetention.BINARY)
@sj.a
@Retention(RetentionPolicy.CLASS)
@sj.d(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY})
@Documented
public @interface s0 {
}
