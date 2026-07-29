package ki;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
@li.a
public @interface a {
    String to() default "";
}
