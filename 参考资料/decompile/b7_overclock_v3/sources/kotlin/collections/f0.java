package kotlin.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nGroupingJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GroupingJVM.kt\nkotlin/collections/GroupingKt__GroupingJVMKt\n+ 2 Grouping.kt\nkotlin/collections/GroupingKt__GroupingKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,52:1\n143#2:53\n80#2,4:54\n85#2:59\n1#3:58\n1855#4,2:60\n*S KotlinDebug\n*F\n+ 1 GroupingJVM.kt\nkotlin/collections/GroupingKt__GroupingJVMKt\n*L\n22#1:53\n22#1:54,4\n22#1:59\n48#1:60,2\n*E\n"})
public class f0 {
    @kotlin.v0(version = "1.1")
    @yt.k
    public static final <T, K> Map<K, Integer> a(@yt.k d0<T, ? extends K> d0Var) {
        kotlin.jvm.internal.f0.p(d0Var, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> itB = d0Var.b();
        while (itB.hasNext()) {
            K kA = d0Var.a(itB.next());
            Object intRef = linkedHashMap.get(kA);
            if (intRef == null && !linkedHashMap.containsKey(kA)) {
                intRef = new Ref.IntRef();
            }
            Ref.IntRef intRef2 = (Ref.IntRef) intRef;
            intRef2.element++;
            linkedHashMap.put(kA, intRef2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            kotlin.jvm.internal.f0.n(entry, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4>");
            kotlin.jvm.internal.w0.m(entry).setValue(Integer.valueOf(((Ref.IntRef) entry.getValue()).element));
        }
        return kotlin.jvm.internal.w0.k(linkedHashMap);
    }

    @bk.f
    @kotlin.s0
    public static final <K, V, R> Map<K, R> b(Map<K, V> map, ik.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> f10) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(f10, "f");
        Iterator<T> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            kotlin.jvm.internal.f0.n(entry, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4>");
            kotlin.jvm.internal.w0.m(entry).setValue(f10.i(entry));
        }
        return kotlin.jvm.internal.w0.k(map);
    }
}
