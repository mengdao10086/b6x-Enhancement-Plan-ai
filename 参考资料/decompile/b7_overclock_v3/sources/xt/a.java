package xt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes6.dex */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface a {

    /* JADX INFO: renamed from: o5, reason: collision with root package name */
    public static final String f56127o5 = "The method argument (if parameter was annotated) or this container (if instance method was annotated)";

    /* JADX INFO: renamed from: p5, reason: collision with root package name */
    public static final String f56128p5 = "this";

    /* JADX INFO: renamed from: q5, reason: collision with root package name */
    public static final String f56129q5 = "This container (if the parameter was annotated) or the return value (if instance method was annotated)";

    /* JADX INFO: renamed from: r5, reason: collision with root package name */
    public static final String f56130r5 = "The return value of this method";

    /* JADX INFO: renamed from: s5, reason: collision with root package name */
    public static final String f56131s5 = "this";

    String source() default "The method argument (if parameter was annotated) or this container (if instance method was annotated)";

    boolean sourceIsContainer() default false;

    String target() default "This container (if the parameter was annotated) or the return value (if instance method was annotated)";

    boolean targetIsContainer() default false;
}
