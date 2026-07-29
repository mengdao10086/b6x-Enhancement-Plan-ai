package hk;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationTarget;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.METHOD})
@kotlin.k(message = "Switch to new -Xjvm-default modes: `all` or `all-compatibility`")
@v0(version = "1.2")
@Retention(RetentionPolicy.RUNTIME)
@sj.d(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY})
public @interface b {
}
