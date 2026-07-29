package androidx.collection;

import androidx.lifecycle.r0;
import kotlin.d0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
@d0(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\u001a\u0015\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000H\u0086\b\u001a-\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003\"\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {i1.a.f31577d5, "Landroidx/collection/c;", "a", "", r0.f6236g, "b", "([Ljava/lang/Object;)Landroidx/collection/c;", "collection-ktx"}, k = 2, mv = {1, 4, 0})
public final class d {
    @yt.k
    public static final <T> c<T> a() {
        return new c<>();
    }

    @yt.k
    public static final <T> c<T> b(@yt.k T... values) {
        f0.q(values, "values");
        c<T> cVar = new c<>(values.length);
        for (T t10 : values) {
            cVar.add(t10);
        }
        return cVar;
    }
}
