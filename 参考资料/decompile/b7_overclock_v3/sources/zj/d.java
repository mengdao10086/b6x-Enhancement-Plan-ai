package zj;

import com.flydigi.sdk.bluetooth.l;
import com.umeng.analytics.pro.an;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationTarget;
import kotlin.v0;
import m0.k;

/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.TYPE})
@v0(version = "1.3")
@Retention(RetentionPolicy.RUNTIME)
@sj.d(allowedTargets = {AnnotationTarget.CLASS})
public @interface d {
    @hk.h(name = "c")
    String c() default "";

    @hk.h(name = "f")
    String f() default "";

    @hk.h(name = "i")
    int[] i() default {};

    @hk.h(name = l.f16298a)
    int[] l() default {};

    @hk.h(name = k.f40564b)
    String m() default "";

    @hk.h(name = "n")
    String[] n() default {};

    @hk.h(name = an.aB)
    String[] s() default {};

    @hk.h(name = "v")
    int v() default 1;
}
