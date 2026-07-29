package kotlin;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes5.dex */
@Target({})
@v0(version = "1.1")
@sj.a
@Documented
@Retention(RetentionPolicy.RUNTIME)
@sj.d(allowedTargets = {AnnotationTarget.TYPE})
public @interface n0 {
    String name();
}
