package kotlin.jvm.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.TYPE})
@kotlin.v0(version = "1.6")
@sj.c(AnnotationRetention.BINARY)
@Retention(RetentionPolicy.CLASS)
@sj.d(allowedTargets = {AnnotationTarget.CLASS})
public @interface q0 {
    @hk.h(name = "b")
    String[] b() default {};
}
