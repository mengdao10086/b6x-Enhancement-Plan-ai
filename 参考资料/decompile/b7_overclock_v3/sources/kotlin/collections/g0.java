package kotlin.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nGrouping.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Grouping.kt\nkotlin/collections/GroupingKt__GroupingKt\n*L\n1#1,291:1\n80#1,6:292\n53#1:298\n80#1,6:299\n80#1,6:305\n53#1:311\n80#1,6:312\n80#1,6:318\n53#1:324\n80#1,6:325\n80#1,6:331\n189#1:337\n80#1,6:338\n*S KotlinDebug\n*F\n+ 1 Grouping.kt\nkotlin/collections/GroupingKt__GroupingKt\n*L\n53#1:292,6\n112#1:298\n112#1:299,6\n143#1:305,6\n164#1:311\n164#1:312,6\n189#1:318,6\n211#1:324\n211#1:325,6\n239#1:331,6\n257#1:337\n257#1:338,6\n*E\n"})
public class g0 extends f0 {
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @kotlin.v0(version = "1.1")
    @yt.k
    public static final <T, K, R> Map<K, R> c(@yt.k d0<T, ? extends K> d0Var, @yt.k ik.r<? super K, ? super R, ? super T, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(d0Var, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> itB = d0Var.b();
        while (itB.hasNext()) {
            ?? next = itB.next();
            Object objA = d0Var.a(next);
            a0.b bVar = (Object) linkedHashMap.get(objA);
            linkedHashMap.put(objA, operation.N(objA, bVar, next, Boolean.valueOf(bVar == null && !linkedHashMap.containsKey(objA))));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @kotlin.v0(version = "1.1")
    @yt.k
    public static final <T, K, R, M extends Map<? super K, R>> M d(@yt.k d0<T, ? extends K> d0Var, @yt.k M destination, @yt.k ik.r<? super K, ? super R, ? super T, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(d0Var, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(operation, "operation");
        Iterator<T> itB = d0Var.b();
        while (itB.hasNext()) {
            ?? next = itB.next();
            Object objA = d0Var.a(next);
            a0.b bVar = (Object) destination.get(objA);
            destination.put(objA, operation.N(objA, bVar, next, Boolean.valueOf(bVar == null && !destination.containsKey(objA))));
        }
        return destination;
    }

    @kotlin.v0(version = "1.1")
    @yt.k
    public static final <T, K, M extends Map<? super K, Integer>> M e(@yt.k d0<T, ? extends K> d0Var, @yt.k M destination) {
        kotlin.jvm.internal.f0.p(d0Var, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        Iterator<T> itB = d0Var.b();
        while (itB.hasNext()) {
            K kA = d0Var.a(itB.next());
            Object obj = destination.get(kA);
            if (obj == null && !destination.containsKey(kA)) {
                obj = 0;
            }
            destination.put(kA, Integer.valueOf(((Number) obj).intValue() + 1));
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @kotlin.v0(version = "1.1")
    @yt.k
    public static final <T, K, R> Map<K, R> f(@yt.k d0<T, ? extends K> d0Var, @yt.k ik.p<? super K, ? super T, ? extends R> initialValueSelector, @yt.k ik.q<? super K, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(d0Var, "<this>");
        kotlin.jvm.internal.f0.p(initialValueSelector, "initialValueSelector");
        kotlin.jvm.internal.f0.p(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> itB = d0Var.b();
        while (itB.hasNext()) {
            ?? next = itB.next();
            Object objA = d0Var.a(next);
            R rR0 = (Object) linkedHashMap.get(objA);
            if (rR0 == null && !linkedHashMap.containsKey(objA)) {
                rR0 = initialValueSelector.r0(objA, next);
            }
            linkedHashMap.put(objA, operation.A(objA, rR0, next));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @kotlin.v0(version = "1.1")
    @yt.k
    public static final <T, K, R> Map<K, R> g(@yt.k d0<T, ? extends K> d0Var, R r10, @yt.k ik.p<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(d0Var, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> itB = d0Var.b();
        while (itB.hasNext()) {
            ?? next = itB.next();
            K kA = d0Var.a(next);
            a0.c cVar = (Object) linkedHashMap.get(kA);
            if (cVar == null && !linkedHashMap.containsKey(kA)) {
                cVar = (Object) r10;
            }
            linkedHashMap.put(kA, operation.r0(cVar, next));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @kotlin.v0(version = "1.1")
    @yt.k
    public static final <T, K, R, M extends Map<? super K, R>> M h(@yt.k d0<T, ? extends K> d0Var, @yt.k M destination, @yt.k ik.p<? super K, ? super T, ? extends R> initialValueSelector, @yt.k ik.q<? super K, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(d0Var, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(initialValueSelector, "initialValueSelector");
        kotlin.jvm.internal.f0.p(operation, "operation");
        Iterator<T> itB = d0Var.b();
        while (itB.hasNext()) {
            ?? next = itB.next();
            Object objA = d0Var.a(next);
            R rR0 = (Object) destination.get(objA);
            if (rR0 == null && !destination.containsKey(objA)) {
                rR0 = initialValueSelector.r0(objA, next);
            }
            destination.put(objA, operation.A(objA, rR0, next));
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @kotlin.v0(version = "1.1")
    @yt.k
    public static final <T, K, R, M extends Map<? super K, R>> M i(@yt.k d0<T, ? extends K> d0Var, @yt.k M destination, R r10, @yt.k ik.p<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(d0Var, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(operation, "operation");
        Iterator<T> itB = d0Var.b();
        while (itB.hasNext()) {
            ?? next = itB.next();
            K kA = d0Var.a(next);
            a0.c cVar = (Object) destination.get(kA);
            if (cVar == null && !destination.containsKey(kA)) {
                cVar = (Object) r10;
            }
            destination.put(kA, operation.r0(cVar, next));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.v0(version = "1.1")
    @yt.k
    public static final <S, T extends S, K> Map<K, S> j(@yt.k d0<T, ? extends K> d0Var, @yt.k ik.q<? super K, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.f0.p(d0Var, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator itB = d0Var.b();
        while (itB.hasNext()) {
            S sA = (Object) itB.next();
            Object objA = d0Var.a(sA);
            a0.b bVar = (Object) linkedHashMap.get(objA);
            if (!(bVar == null && !linkedHashMap.containsKey(objA))) {
                sA = operation.A(objA, bVar, sA);
            }
            linkedHashMap.put(objA, sA);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.v0(version = "1.1")
    @yt.k
    public static final <S, T extends S, K, M extends Map<? super K, S>> M k(@yt.k d0<T, ? extends K> d0Var, @yt.k M destination, @yt.k ik.q<? super K, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.f0.p(d0Var, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(operation, "operation");
        Iterator itB = d0Var.b();
        while (itB.hasNext()) {
            S sA = (Object) itB.next();
            Object objA = d0Var.a(sA);
            a0.b bVar = (Object) destination.get(objA);
            if (!(bVar == null && !destination.containsKey(objA))) {
                sA = operation.A(objA, bVar, sA);
            }
            destination.put(objA, sA);
        }
        return destination;
    }
}
