package kotlin.reflect;

import kotlin.c2;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@hk.h(name = "KClasses")
@t0({"SMAP\nKClasses.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KClasses.kt\nkotlin/reflect/KClasses\n+ 2 KClassesImpl.kt\nkotlin/reflect/KClassesImplKt\n*L\n1#1,48:1\n9#2:49\n*S KotlinDebug\n*F\n+ 1 KClasses.kt\nkotlin/reflect/KClasses\n*L\n26#1:49\n*E\n"})
public final class e {
    /* JADX WARN: Multi-variable type inference failed */
    @v0(version = "1.4")
    @bk.h
    @c2(markerClass = {kotlin.q.class})
    @yt.k
    public static final <T> T a(@yt.k d<T> dVar, @yt.l Object obj) {
        f0.p(dVar, "<this>");
        if (dVar.x0(obj)) {
            f0.n(obj, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.cast");
            return obj;
        }
        throw new ClassCastException("Value cannot be cast to " + dVar.p());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @v0(version = "1.4")
    @yt.l
    @bk.h
    @c2(markerClass = {kotlin.q.class})
    public static final <T> T b(@yt.k d<T> dVar, @yt.l Object obj) {
        f0.p(dVar, "<this>");
        if (!dVar.x0(obj)) {
            return null;
        }
        f0.n(obj, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.safeCast");
        return obj;
    }
}
