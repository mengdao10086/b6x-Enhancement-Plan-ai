package yt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes6.dex */
public final class f {

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.CLASS)
    public @interface a {
        @xt.d(prefix = "class Renderer{Object[] $childrenArray(){return ", suffix = ";}}", value = "JAVA")
        @j
        String childrenArray() default "";

        @xt.d(prefix = "class Renderer{boolean $hasChildren(){return ", suffix = ";}}", value = "JAVA")
        @j
        String hasChildren() default "";

        @xt.d(prefix = "class Renderer{String $text(){return ", suffix = ";}}", value = "JAVA")
        @j
        String text() default "";
    }

    public f() {
        throw new AssertionError("Debug should not be instantiated");
    }
}
