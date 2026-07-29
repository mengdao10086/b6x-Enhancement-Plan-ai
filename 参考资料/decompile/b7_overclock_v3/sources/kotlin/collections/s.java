package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import kotlin.collections.builders.ListBuilder;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nCollectionsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CollectionsJVM.kt\nkotlin/collections/CollectionsKt__CollectionsJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,120:1\n1#2:121\n*E\n"})
public class s {
    @kotlin.v0(version = "1.3")
    @kotlin.s0
    @yt.k
    public static final <E> List<E> a(@yt.k List<E> builder) {
        kotlin.jvm.internal.f0.p(builder, "builder");
        return ((ListBuilder) builder).q();
    }

    @bk.f
    @kotlin.v0(version = "1.3")
    @kotlin.s0
    public static final <E> List<E> b(int i10, ik.l<? super List<E>, z1> builderAction) {
        kotlin.jvm.internal.f0.p(builderAction, "builderAction");
        List listJ = j(i10);
        builderAction.i(listJ);
        return a(listJ);
    }

    @bk.f
    @kotlin.v0(version = "1.3")
    @kotlin.s0
    public static final <E> List<E> c(ik.l<? super List<E>, z1> builderAction) {
        kotlin.jvm.internal.f0.p(builderAction, "builderAction");
        List listI = i();
        builderAction.i(listI);
        return a(listI);
    }

    @bk.f
    @kotlin.v0(version = "1.3")
    @kotlin.s0
    public static final int d(int i10) {
        if (i10 < 0) {
            if (!bk.m.a(1, 3, 0)) {
                throw new ArithmeticException("Count overflow has happened.");
            }
            CollectionsKt__CollectionsKt.V();
        }
        return i10;
    }

    @bk.f
    @kotlin.v0(version = "1.3")
    @kotlin.s0
    public static final int e(int i10) {
        if (i10 < 0) {
            if (!bk.m.a(1, 3, 0)) {
                throw new ArithmeticException("Index overflow has happened.");
            }
            CollectionsKt__CollectionsKt.W();
        }
        return i10;
    }

    @bk.f
    public static final Object[] f(Collection<?> collection) {
        kotlin.jvm.internal.f0.p(collection, "collection");
        return kotlin.jvm.internal.t.a(collection);
    }

    @bk.f
    public static final <T> T[] g(Collection<?> collection, T[] array) {
        kotlin.jvm.internal.f0.p(collection, "collection");
        kotlin.jvm.internal.f0.p(array, "array");
        return (T[]) kotlin.jvm.internal.t.b(collection, array);
    }

    @yt.k
    public static final <T> Object[] h(@yt.k T[] tArr, boolean z10) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        if (z10 && kotlin.jvm.internal.f0.g(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        kotlin.jvm.internal.f0.o(objArrCopyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return objArrCopyOf;
    }

    @kotlin.v0(version = "1.3")
    @kotlin.s0
    @yt.k
    public static final <E> List<E> i() {
        return new ListBuilder();
    }

    @kotlin.v0(version = "1.3")
    @kotlin.s0
    @yt.k
    public static final <E> List<E> j(int i10) {
        return new ListBuilder(i10);
    }

    @yt.k
    public static final <T> List<T> k(T t10) {
        List<T> listSingletonList = Collections.singletonList(t10);
        kotlin.jvm.internal.f0.o(listSingletonList, "singletonList(element)");
        return listSingletonList;
    }

    @kotlin.v0(version = "1.2")
    @yt.k
    public static final <T> List<T> l(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        List<T> listS5 = CollectionsKt___CollectionsKt.S5(iterable);
        Collections.shuffle(listS5);
        return listS5;
    }

    @kotlin.v0(version = "1.2")
    @yt.k
    public static final <T> List<T> m(@yt.k Iterable<? extends T> iterable, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        List<T> listS5 = CollectionsKt___CollectionsKt.S5(iterable);
        Collections.shuffle(listS5, random);
        return listS5;
    }

    @bk.f
    public static final <T> List<T> n(Enumeration<T> enumeration) {
        kotlin.jvm.internal.f0.p(enumeration, "<this>");
        ArrayList list = Collections.list(enumeration);
        kotlin.jvm.internal.f0.o(list, "list(this)");
        return list;
    }
}
