package xk;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.p0;
import xk.b;

/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.TYPE})
@sj.b
@sj.c(AnnotationRetention.SOURCE)
@Repeatable(a.class)
@Retention(RetentionPolicy.SOURCE)
@sj.d(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.PROPERTY})
public @interface e<T, P extends b<? super T>> {

    @Target({ElementType.TYPE})
    @sj.c(AnnotationRetention.SOURCE)
    @p0
    @Retention(RetentionPolicy.SOURCE)
    @sj.d(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.PROPERTY})
    public @interface a {
        e[] value();
    }
}
