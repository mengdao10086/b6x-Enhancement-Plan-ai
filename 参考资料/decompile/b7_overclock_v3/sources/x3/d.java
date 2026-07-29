package x3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface d {

    /* JADX INFO: renamed from: l5, reason: collision with root package name */
    public static final int f54882l5 = 0;

    /* JADX INFO: renamed from: m5, reason: collision with root package name */
    public static final int f54883m5 = 1;

    /* JADX INFO: renamed from: n5, reason: collision with root package name */
    public static final int f54884n5 = 2;

    boolean memoizeStaticMethod() default false;

    int override() default 0;

    boolean skipStaticMethod() default false;

    String staticMethodName() default "";
}
