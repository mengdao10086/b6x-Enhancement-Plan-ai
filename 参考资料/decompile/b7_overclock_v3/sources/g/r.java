package g;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@sj.c(AnnotationRetention.BINARY)
@sj.a
@Documented
@Retention(RetentionPolicy.CLASS)
@sj.d(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD, AnnotationTarget.LOCAL_VARIABLE, AnnotationTarget.ANNOTATION_CLASS})
public @interface r {

    @yt.k
    public static final a O1 = a.f28850a;
    public static final int P1 = 0;
    public static final int Q1 = 1;
    public static final int R1 = 2;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f28850a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f28851b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f28852c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f28853d = 2;
    }

    int unit() default 1;
}
