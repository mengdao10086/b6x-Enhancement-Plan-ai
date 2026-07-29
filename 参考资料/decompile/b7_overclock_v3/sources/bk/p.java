package bk;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.DeprecationLevel;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.internal.RequireKotlinVersionKind;
import kotlin.jvm.internal.p0;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@sj.b
@v0(version = "1.2")
@sj.c(AnnotationRetention.SOURCE)
@Retention(RetentionPolicy.SOURCE)
@sj.d(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.TYPEALIAS})
@Repeatable(a.class)
public @interface p {

    @Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
    @sj.c(AnnotationRetention.SOURCE)
    @p0
    @Retention(RetentionPolicy.SOURCE)
    @sj.d(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.TYPEALIAS})
    public @interface a {
        p[] value();
    }

    int errorCode() default -1;

    DeprecationLevel level() default DeprecationLevel.ERROR;

    String message() default "";

    String version();

    RequireKotlinVersionKind versionKind() default RequireKotlinVersionKind.LANGUAGE_VERSION;
}
