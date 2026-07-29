package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.ANNOTATION_TYPE})
@v0(version = "1.3")
@sj.c(AnnotationRetention.BINARY)
@Retention(RetentionPolicy.CLASS)
@sj.d(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
public @interface RequiresOptIn {

    public enum Level {
        WARNING,
        ERROR
    }

    Level level() default Level.ERROR;

    String message() default "";
}
