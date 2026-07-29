package kotlin;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* JADX INFO: loaded from: classes5.dex */
@hk.h(name = "TuplesKt")
public final class d1 {
    @yt.k
    public static final <A, B> Pair<A, B> a(A a10, B b10) {
        return new Pair<>(a10, b10);
    }

    @yt.k
    public static final <T> List<T> b(@yt.k Pair<? extends T, ? extends T> pair) {
        kotlin.jvm.internal.f0.p(pair, "<this>");
        return CollectionsKt__CollectionsKt.L(pair.f(), pair.h());
    }

    @yt.k
    public static final <T> List<T> c(@yt.k Triple<? extends T, ? extends T, ? extends T> triple) {
        kotlin.jvm.internal.f0.p(triple, "<this>");
        return CollectionsKt__CollectionsKt.L(triple.h(), triple.i(), triple.k());
    }
}
