package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import kotlin.collections.builders.SetBuilder;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
public class c1 {
    @kotlin.v0(version = "1.3")
    @kotlin.s0
    @yt.k
    public static final <E> Set<E> a(@yt.k Set<E> builder) {
        kotlin.jvm.internal.f0.p(builder, "builder");
        return ((SetBuilder) builder).b();
    }

    @bk.f
    @kotlin.v0(version = "1.3")
    @kotlin.s0
    public static final <E> Set<E> b(int i10, ik.l<? super Set<E>, z1> builderAction) {
        kotlin.jvm.internal.f0.p(builderAction, "builderAction");
        Set setE = e(i10);
        builderAction.i(setE);
        return a(setE);
    }

    @bk.f
    @kotlin.v0(version = "1.3")
    @kotlin.s0
    public static final <E> Set<E> c(ik.l<? super Set<E>, z1> builderAction) {
        kotlin.jvm.internal.f0.p(builderAction, "builderAction");
        Set setD = d();
        builderAction.i(setD);
        return a(setD);
    }

    @kotlin.v0(version = "1.3")
    @kotlin.s0
    @yt.k
    public static final <E> Set<E> d() {
        return new SetBuilder();
    }

    @kotlin.v0(version = "1.3")
    @kotlin.s0
    @yt.k
    public static final <E> Set<E> e(int i10) {
        return new SetBuilder(i10);
    }

    @yt.k
    public static final <T> Set<T> f(T t10) {
        Set<T> setSingleton = Collections.singleton(t10);
        kotlin.jvm.internal.f0.o(setSingleton, "singleton(element)");
        return setSingleton;
    }

    @yt.k
    public static final <T> TreeSet<T> g(@yt.k Comparator<? super T> comparator, @yt.k T... elements) {
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(elements, "elements");
        return (TreeSet) ArraysKt___ArraysKt.Ny(elements, new TreeSet(comparator));
    }

    @yt.k
    public static final <T> TreeSet<T> h(@yt.k T... elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        return (TreeSet) ArraysKt___ArraysKt.Ny(elements, new TreeSet());
    }
}
