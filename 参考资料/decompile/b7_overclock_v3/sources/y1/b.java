package y1;

import g.n0;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface b {

    @Target({})
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
        int mask() default 0;

        @n0
        String name();

        int value();
    }

    @n0
    a[] intMapping() default {};

    @n0
    String value();
}
