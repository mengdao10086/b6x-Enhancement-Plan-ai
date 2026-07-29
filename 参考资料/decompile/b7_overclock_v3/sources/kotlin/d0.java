package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.TYPE})
@v0(version = "1.3")
@sj.c(AnnotationRetention.RUNTIME)
@Retention(RetentionPolicy.RUNTIME)
@sj.d(allowedTargets = {AnnotationTarget.CLASS})
public @interface d0 {

    public static final class a {
        @k(level = DeprecationLevel.WARNING, message = "Bytecode version had no significant use in Kotlin metadata and it will be removed in a future version.")
        public static /* synthetic */ void a() {
        }

        @v0(version = "1.2")
        public static /* synthetic */ void b() {
        }

        @v0(version = "1.1")
        public static /* synthetic */ void c() {
        }
    }

    @hk.h(name = "bv")
    int[] bv() default {1, 0, 3};

    @hk.h(name = m9.h.f40774q)
    String[] d1() default {};

    @hk.h(name = "d2")
    String[] d2() default {};

    @hk.h(name = "k")
    int k() default 1;

    @hk.h(name = "mv")
    int[] mv() default {};

    @hk.h(name = "pn")
    String pn() default "";

    @hk.h(name = "xi")
    int xi() default 0;

    @hk.h(name = "xs")
    String xs() default "";
}
