package kotlin.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.c2;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
public class d1 extends c1 {
    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.6")
    public static final <E> Set<E> i(int i10, @kotlin.b ik.l<? super Set<E>, z1> builderAction) {
        kotlin.jvm.internal.f0.p(builderAction, "builderAction");
        Set setE = c1.e(i10);
        builderAction.i(setE);
        return c1.a(setE);
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.6")
    public static final <E> Set<E> j(@kotlin.b ik.l<? super Set<E>, z1> builderAction) {
        kotlin.jvm.internal.f0.p(builderAction, "builderAction");
        Set setD = c1.d();
        builderAction.i(setD);
        return c1.a(setD);
    }

    @yt.k
    public static final <T> Set<T> k() {
        return EmptySet.f37669a;
    }

    @bk.f
    @kotlin.v0(version = "1.1")
    public static final <T> HashSet<T> l() {
        return new HashSet<>();
    }

    @yt.k
    public static final <T> HashSet<T> m(@yt.k T... elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        return (HashSet) ArraysKt___ArraysKt.Ny(elements, new HashSet(r0.j(elements.length)));
    }

    @bk.f
    @kotlin.v0(version = "1.1")
    public static final <T> LinkedHashSet<T> n() {
        return new LinkedHashSet<>();
    }

    @yt.k
    public static final <T> LinkedHashSet<T> o(@yt.k T... elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        return (LinkedHashSet) ArraysKt___ArraysKt.Ny(elements, new LinkedHashSet(r0.j(elements.length)));
    }

    @bk.f
    @kotlin.v0(version = "1.1")
    public static final <T> Set<T> p() {
        return new LinkedHashSet();
    }

    @yt.k
    public static final <T> Set<T> q(@yt.k T... elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        return (Set) ArraysKt___ArraysKt.Ny(elements, new LinkedHashSet(r0.j(elements.length)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <T> Set<T> r(@yt.k Set<? extends T> set) {
        kotlin.jvm.internal.f0.p(set, "<this>");
        int size = set.size();
        return size != 0 ? size != 1 ? set : c1.f(set.iterator().next()) : k();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bk.f
    public static final <T> Set<T> s(Set<? extends T> set) {
        return set == 0 ? k() : set;
    }

    @bk.f
    public static final <T> Set<T> t() {
        return k();
    }

    @yt.k
    public static final <T> Set<T> u(@yt.k T... elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        return elements.length > 0 ? ArraysKt___ArraysKt.Kz(elements) : k();
    }

    @kotlin.v0(version = "1.4")
    @yt.k
    public static final <T> Set<T> v(@yt.l T t10) {
        return t10 != null ? c1.f(t10) : k();
    }

    @kotlin.v0(version = "1.4")
    @yt.k
    public static final <T> Set<T> w(@yt.k T... elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        return (Set) ArraysKt___ArraysKt.vb(elements, new LinkedHashSet());
    }
}
