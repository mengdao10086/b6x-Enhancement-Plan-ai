package kotlin.collections;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\n_Sets.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Sets.kt\nkotlin/collections/SetsKt___SetsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,139:1\n857#2,2:140\n847#2,2:142\n1#3:144\n*S KotlinDebug\n*F\n+ 1 _Sets.kt\nkotlin/collections/SetsKt___SetsKt\n*L\n28#1:140,2\n52#1:142,2\n*E\n"})
public class e1 extends d1 {
    @yt.k
    public static final <T> Set<T> A(@yt.k Set<? extends T> set, @yt.k T[] elements) {
        kotlin.jvm.internal.f0.p(set, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        x.H0(linkedHashSet, elements);
        return linkedHashSet;
    }

    @bk.f
    public static final <T> Set<T> B(Set<? extends T> set, T t10) {
        kotlin.jvm.internal.f0.p(set, "<this>");
        return y(set, t10);
    }

    @yt.k
    public static final <T> Set<T> C(@yt.k Set<? extends T> set, @yt.k Iterable<? extends T> elements) {
        int size;
        kotlin.jvm.internal.f0.p(set, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        Integer numZ = t.Z(elements);
        if (numZ != null) {
            size = set.size() + numZ.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(r0.j(size));
        linkedHashSet.addAll(set);
        x.n0(linkedHashSet, elements);
        return linkedHashSet;
    }

    @yt.k
    public static final <T> Set<T> D(@yt.k Set<? extends T> set, T t10) {
        kotlin.jvm.internal.f0.p(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(r0.j(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t10);
        return linkedHashSet;
    }

    @yt.k
    public static final <T> Set<T> E(@yt.k Set<? extends T> set, @yt.k kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.f0.p(set, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(r0.j(set.size() * 2));
        linkedHashSet.addAll(set);
        x.o0(linkedHashSet, elements);
        return linkedHashSet;
    }

    @yt.k
    public static final <T> Set<T> F(@yt.k Set<? extends T> set, @yt.k T[] elements) {
        kotlin.jvm.internal.f0.p(set, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(r0.j(set.size() + elements.length));
        linkedHashSet.addAll(set);
        x.p0(linkedHashSet, elements);
        return linkedHashSet;
    }

    @bk.f
    public static final <T> Set<T> G(Set<? extends T> set, T t10) {
        kotlin.jvm.internal.f0.p(set, "<this>");
        return D(set, t10);
    }

    @yt.k
    public static final <T> Set<T> x(@yt.k Set<? extends T> set, @yt.k Iterable<? extends T> elements) {
        kotlin.jvm.internal.f0.p(set, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        Collection<?> collectionQ0 = x.q0(elements);
        if (collectionQ0.isEmpty()) {
            return CollectionsKt___CollectionsKt.V5(set);
        }
        if (!(collectionQ0 instanceof Set)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(set);
            linkedHashSet.removeAll(collectionQ0);
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        for (T t10 : set) {
            if (!collectionQ0.contains(t10)) {
                linkedHashSet2.add(t10);
            }
        }
        return linkedHashSet2;
    }

    @yt.k
    public static final <T> Set<T> y(@yt.k Set<? extends T> set, T t10) {
        kotlin.jvm.internal.f0.p(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(r0.j(set.size()));
        boolean z10 = false;
        for (T t11 : set) {
            boolean z11 = true;
            if (!z10 && kotlin.jvm.internal.f0.g(t11, t10)) {
                z10 = true;
                z11 = false;
            }
            if (z11) {
                linkedHashSet.add(t11);
            }
        }
        return linkedHashSet;
    }

    @yt.k
    public static final <T> Set<T> z(@yt.k Set<? extends T> set, @yt.k kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.f0.p(set, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        x.G0(linkedHashSet, elements);
        return linkedHashSet;
    }
}
