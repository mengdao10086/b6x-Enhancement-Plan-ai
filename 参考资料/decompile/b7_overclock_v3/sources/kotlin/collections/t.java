package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: loaded from: classes5.dex */
public class t extends CollectionsKt__CollectionsKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @kotlin.jvm.internal.t0({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n*L\n1#1,70:1\n*E\n"})
    public static final class a<T> implements Iterable<T>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.a<Iterator<T>> f37739a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(ik.a<? extends Iterator<? extends T>> aVar) {
            this.f37739a = aVar;
        }

        @Override // java.lang.Iterable
        @yt.k
        public Iterator<T> iterator() {
            return this.f37739a.o();
        }
    }

    @bk.f
    public static final <T> Iterable<T> X(ik.a<? extends Iterator<? extends T>> iterator) {
        kotlin.jvm.internal.f0.p(iterator, "iterator");
        return new a(iterator);
    }

    @kotlin.s0
    public static final <T> int Y(@yt.k Iterable<? extends T> iterable, int i10) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i10;
    }

    @yt.l
    @kotlin.s0
    public static final <T> Integer Z(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }

    @yt.k
    public static final <T> List<T> a0(@yt.k Iterable<? extends Iterable<? extends T>> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends Iterable<? extends T>> it2 = iterable.iterator();
        while (it2.hasNext()) {
            x.n0(arrayList, it2.next());
        }
        return arrayList;
    }

    @yt.k
    public static final <T, R> Pair<List<T>, List<R>> b0(@yt.k Iterable<? extends Pair<? extends T, ? extends R>> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        int iY = Y(iterable, 10);
        ArrayList arrayList = new ArrayList(iY);
        ArrayList arrayList2 = new ArrayList(iY);
        for (Pair<? extends T, ? extends R> pair : iterable) {
            arrayList.add(pair.f());
            arrayList2.add(pair.h());
        }
        return kotlin.d1.a(arrayList, arrayList2);
    }
}
