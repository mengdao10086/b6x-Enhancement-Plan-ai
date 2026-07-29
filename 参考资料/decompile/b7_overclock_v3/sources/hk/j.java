package hk;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@Target({})
@v0(version = "1.2")
@sj.c(AnnotationRetention.SOURCE)
@sj.a
@Retention(RetentionPolicy.SOURCE)
@sj.d(allowedTargets = {AnnotationTarget.FILE})
@Documented
public @interface j {
    String name();
}
