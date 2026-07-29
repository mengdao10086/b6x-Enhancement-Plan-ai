package g;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.ANNOTATION_TYPE})
@sj.c(AnnotationRetention.SOURCE)
@Retention(RetentionPolicy.SOURCE)
@sj.d(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
public @interface e0 {
    boolean flag() default false;

    boolean open() default false;

    int[] value() default {};
}
