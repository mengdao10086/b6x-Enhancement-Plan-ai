package androidx.annotation.experimental;

import com.umeng.socialize.handler.UMTencentSSOHandler;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.d0;
import kotlin.k;
import kotlin.t0;
import sj.c;
import sj.d;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.ANNOTATION_TYPE})
@k(message = "This annotation has been replaced by `@RequiresOptIn`", replaceWith = @t0(expression = "RequiresOptIn", imports = {"androidx.annotation.RequiresOptIn"}))
@c(AnnotationRetention.BINARY)
@d0(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\n\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Landroidx/annotation/experimental/Experimental;", "", UMTencentSSOHandler.LEVEL, "Landroidx/annotation/experimental/Experimental$Level;", "()Landroidx/annotation/experimental/Experimental$Level;", "Level", "annotation-experimental_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Retention(RetentionPolicy.CLASS)
@d(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
public @interface Experimental {

    @d0(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Landroidx/annotation/experimental/Experimental$Level;", "", "(Ljava/lang/String;I)V", "WARNING", "ERROR", "annotation-experimental_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum Level {
        WARNING,
        ERROR
    }

    Level level() default Level.ERROR;
}
