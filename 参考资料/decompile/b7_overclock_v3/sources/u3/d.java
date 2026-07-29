package u3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface d {

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface a {
        String[] value() default {""};
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface b {
        String[] value() default {""};
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface c {
        String[] value() default {""};
    }
}
