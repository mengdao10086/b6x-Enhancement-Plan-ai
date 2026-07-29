package androidx.collection;

import kotlin.Pair;
import kotlin.d0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
@d0(bv = {}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0086\b\u001aQ\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"K", i1.a.X4, "Landroidx/collection/a;", "a", "", "Lkotlin/Pair;", "pairs", "b", "([Lkotlin/Pair;)Landroidx/collection/a;", "collection-ktx"}, k = 2, mv = {1, 4, 0})
public final class b {
    @yt.k
    public static final <K, V> a<K, V> a() {
        return new a<>();
    }

    @yt.k
    public static final <K, V> a<K, V> b(@yt.k Pair<? extends K, ? extends V>... pairs) {
        f0.q(pairs, "pairs");
        a<K, V> aVar = new a<>(pairs.length);
        for (Pair<? extends K, ? extends V> pair : pairs) {
            aVar.put(pair.f(), pair.h());
        }
        return aVar;
    }
}
