package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.c2;
import kotlin.random.Random;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nCollections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collections.kt\nkotlin/collections/CollectionsKt__CollectionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,471:1\n394#1:473\n1#2:472\n*S KotlinDebug\n*F\n+ 1 Collections.kt\nkotlin/collections/CollectionsKt__CollectionsKt\n*L\n388#1:473\n*E\n"})
public class CollectionsKt__CollectionsKt extends s {
    public static /* synthetic */ int A(List list, Comparable comparable, int i10, int i11, ik.l lVar, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = list.size();
        }
        return t(list, i10, i11, new CollectionsKt__CollectionsKt$binarySearchBy$1(lVar, comparable));
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.6")
    public static final <E> List<E> B(int i10, @kotlin.b ik.l<? super List<E>, z1> builderAction) {
        kotlin.jvm.internal.f0.p(builderAction, "builderAction");
        List listJ = s.j(i10);
        builderAction.i(listJ);
        return s.a(listJ);
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.6")
    public static final <E> List<E> C(@kotlin.b ik.l<? super List<E>, z1> builderAction) {
        kotlin.jvm.internal.f0.p(builderAction, "builderAction");
        List listI = s.i();
        builderAction.i(listI);
        return s.a(listI);
    }

    @bk.f
    public static final <T> boolean D(Collection<? extends T> collection, Collection<? extends T> elements) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        return collection.containsAll(elements);
    }

    @yt.k
    public static final <T> List<T> E() {
        return EmptyList.f37667a;
    }

    @yt.k
    public static final qk.m F(@yt.k Collection<?> collection) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        return new qk.m(0, collection.size() - 1);
    }

    public static final <T> int G(@yt.k List<? extends T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        return list.size() - 1;
    }

    /* JADX WARN: Incorrect types in method signature: <C::Ljava/util/Collection<*>;:TR;R:Ljava/lang/Object;>(TC;Lik/a<+TR;>;)TR; */
    @bk.f
    @kotlin.v0(version = "1.3")
    public static final Object H(Collection collection, ik.a defaultValue) {
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return collection.isEmpty() ? defaultValue.o() : collection;
    }

    @bk.f
    public static final <T> boolean I(Collection<? extends T> collection) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        return !collection.isEmpty();
    }

    @bk.f
    @kotlin.v0(version = "1.3")
    public static final <T> boolean J(Collection<? extends T> collection) {
        return collection == null || collection.isEmpty();
    }

    @bk.f
    public static final <T> List<T> K() {
        return E();
    }

    @yt.k
    public static final <T> List<T> L(@yt.k T... elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        return elements.length > 0 ? m.t(elements) : E();
    }

    @yt.k
    public static final <T> List<T> M(@yt.l T t10) {
        return t10 != null ? s.k(t10) : E();
    }

    @yt.k
    public static final <T> List<T> N(@yt.k T... elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        return ArraysKt___ArraysKt.ub(elements);
    }

    @bk.f
    @kotlin.v0(version = "1.1")
    public static final <T> List<T> O() {
        return new ArrayList();
    }

    @yt.k
    public static final <T> List<T> P(@yt.k T... elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new h(elements, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <T> List<T> Q(@yt.k List<? extends T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : s.k(list.get(0)) : E();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bk.f
    public static final <T> Collection<T> R(Collection<? extends T> collection) {
        return collection == 0 ? E() : collection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bk.f
    public static final <T> List<T> S(List<? extends T> list) {
        return list == 0 ? E() : list;
    }

    public static final void T(int i10, int i11, int i12) {
        if (i11 > i12) {
            throw new IllegalArgumentException("fromIndex (" + i11 + ") is greater than toIndex (" + i12 + ").");
        }
        if (i11 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i11 + ") is less than zero.");
        }
        if (i12 <= i10) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i12 + ") is greater than size (" + i10 + ").");
    }

    @kotlin.v0(version = "1.3")
    @yt.k
    public static final <T> List<T> U(@yt.k Iterable<? extends T> iterable, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        List<T> listS5 = CollectionsKt___CollectionsKt.S5(iterable);
        CollectionsKt___CollectionsKt.Z4(listS5, random);
        return listS5;
    }

    @kotlin.v0(version = "1.3")
    @kotlin.s0
    public static final void V() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    @kotlin.v0(version = "1.3")
    @kotlin.s0
    public static final void W() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    @bk.f
    @kotlin.v0(version = "1.1")
    public static final <T> List<T> o(int i10, ik.l<? super Integer, ? extends T> init) {
        kotlin.jvm.internal.f0.p(init, "init");
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add(init.i(Integer.valueOf(i11)));
        }
        return arrayList;
    }

    @bk.f
    @kotlin.v0(version = "1.1")
    public static final <T> List<T> p(int i10, ik.l<? super Integer, ? extends T> init) {
        kotlin.jvm.internal.f0.p(init, "init");
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add(init.i(Integer.valueOf(i11)));
        }
        return arrayList;
    }

    @bk.f
    @kotlin.v0(version = "1.1")
    public static final <T> ArrayList<T> q() {
        return new ArrayList<>();
    }

    @yt.k
    public static final <T> ArrayList<T> r(@yt.k T... elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        return elements.length == 0 ? new ArrayList<>() : new ArrayList<>(new h(elements, true));
    }

    @yt.k
    public static final <T> Collection<T> s(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return new h(tArr, false);
    }

    public static final <T> int t(@yt.k List<? extends T> list, int i10, int i11, @yt.k ik.l<? super T, Integer> comparison) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(comparison, "comparison");
        T(list.size(), i10, i11);
        int i12 = i11 - 1;
        while (i10 <= i12) {
            int i13 = (i10 + i12) >>> 1;
            int iIntValue = comparison.i(list.get(i13)).intValue();
            if (iIntValue < 0) {
                i10 = i13 + 1;
            } else {
                if (iIntValue <= 0) {
                    return i13;
                }
                i12 = i13 - 1;
            }
        }
        return -(i10 + 1);
    }

    public static final <T extends Comparable<? super T>> int u(@yt.k List<? extends T> list, @yt.l T t10, int i10, int i11) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        T(list.size(), i10, i11);
        int i12 = i11 - 1;
        while (i10 <= i12) {
            int i13 = (i10 + i12) >>> 1;
            int iL = uj.g.l(list.get(i13), t10);
            if (iL < 0) {
                i10 = i13 + 1;
            } else {
                if (iL <= 0) {
                    return i13;
                }
                i12 = i13 - 1;
            }
        }
        return -(i10 + 1);
    }

    public static final <T> int v(@yt.k List<? extends T> list, T t10, @yt.k Comparator<? super T> comparator, int i10, int i11) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        T(list.size(), i10, i11);
        int i12 = i11 - 1;
        while (i10 <= i12) {
            int i13 = (i10 + i12) >>> 1;
            int iCompare = comparator.compare(list.get(i13), t10);
            if (iCompare < 0) {
                i10 = i13 + 1;
            } else {
                if (iCompare <= 0) {
                    return i13;
                }
                i12 = i13 - 1;
            }
        }
        return -(i10 + 1);
    }

    public static /* synthetic */ int w(List list, int i10, int i11, ik.l lVar, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = list.size();
        }
        return t(list, i10, i11, lVar);
    }

    public static /* synthetic */ int x(List list, Comparable comparable, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = list.size();
        }
        return u(list, comparable, i10, i11);
    }

    public static /* synthetic */ int y(List list, Object obj, Comparator comparator, int i10, int i11, int i12, Object obj2) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        if ((i12 & 8) != 0) {
            i11 = list.size();
        }
        return v(list, obj, comparator, i10, i11);
    }

    public static final <T, K extends Comparable<? super K>> int z(@yt.k List<? extends T> list, @yt.l K k10, int i10, int i11, @yt.k ik.l<? super T, ? extends K> selector) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        return t(list, i10, i11, new CollectionsKt__CollectionsKt$binarySearchBy$1(selector, k10));
    }
}
