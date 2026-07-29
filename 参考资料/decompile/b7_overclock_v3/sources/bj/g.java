package bj;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface g {
    public static final String A = "custom";
    public static final String B = "io.reactivex:computation";
    public static final String C = "io.reactivex:io";
    public static final String D = "io.reactivex:new-thread";
    public static final String E = "io.reactivex:trampoline";
    public static final String F = "io.reactivex:single";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f9493z = "none";

    String value();
}
