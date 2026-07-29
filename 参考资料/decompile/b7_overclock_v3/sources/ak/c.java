package ak;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.RequiresOptIn;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.ANNOTATION_TYPE})
@sj.c(AnnotationRetention.BINARY)
@sj.a
@RequiresOptIn
@Retention(RetentionPolicy.CLASS)
@sj.d(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
@Documented
public @interface c {
}
