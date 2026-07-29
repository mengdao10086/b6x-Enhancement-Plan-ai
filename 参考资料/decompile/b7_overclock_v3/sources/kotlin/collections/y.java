package kotlin.collections;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class y extends x {
    @yt.k
    public static final <T> List<T> W0(@yt.k List<? extends T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        return new z0(list);
    }

    @hk.h(name = "asReversedMutable")
    @yt.k
    public static final <T> List<T> X0(@yt.k List<T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        return new y0(list);
    }

    public static final int Y0(List<?> list, int i10) {
        if (new qk.m(0, CollectionsKt__CollectionsKt.G(list)).p(i10)) {
            return CollectionsKt__CollectionsKt.G(list) - i10;
        }
        throw new IndexOutOfBoundsException("Element index " + i10 + " must be in range [" + new qk.m(0, CollectionsKt__CollectionsKt.G(list)) + "].");
    }

    public static final int Z0(List<?> list, int i10) {
        if (new qk.m(0, list.size()).p(i10)) {
            return list.size() - i10;
        }
        throw new IndexOutOfBoundsException("Position index " + i10 + " must be in range [" + new qk.m(0, list.size()) + "].");
    }
}
