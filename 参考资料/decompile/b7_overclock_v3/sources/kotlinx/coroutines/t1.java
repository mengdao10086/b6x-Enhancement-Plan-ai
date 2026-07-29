package kotlinx.coroutines;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.RequiresOptIn;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.TYPE, ElementType.METHOD})
@sj.c(AnnotationRetention.BINARY)
@sj.a
@RequiresOptIn(level = RequiresOptIn.Level.WARNING, message = "This declaration is in a preview state and can be changed in a backwards-incompatible manner with a best-effort migration. Its usage should be marked with '@kotlinx.coroutines.FlowPreview' or '@OptIn(kotlinx.coroutines.FlowPreview::class)' if you accept the drawback of relying on preview API")
@Retention(RetentionPolicy.CLASS)
@sj.d(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.TYPEALIAS, AnnotationTarget.PROPERTY})
@Documented
public @interface t1 {
}
