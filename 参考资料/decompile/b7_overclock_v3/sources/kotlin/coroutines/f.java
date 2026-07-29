package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.f0;
import kotlin.q;
import kotlin.v0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
public final class f {
    /* JADX WARN: Multi-variable type inference failed */
    @v0(version = "1.3")
    @l
    @q
    public static final <E extends CoroutineContext.a> E a(@k CoroutineContext.a aVar, @k CoroutineContext.b<E> key) {
        f0.p(aVar, "<this>");
        f0.p(key, "key");
        if (!(key instanceof b)) {
            if (aVar.getKey() == key) {
                return aVar;
            }
            return null;
        }
        b bVar = (b) key;
        if (!bVar.a(aVar.getKey())) {
            return null;
        }
        E e10 = (E) bVar.b(aVar);
        if (e10 instanceof CoroutineContext.a) {
            return e10;
        }
        return null;
    }

    @v0(version = "1.3")
    @k
    @q
    public static final CoroutineContext b(@k CoroutineContext.a aVar, @k CoroutineContext.b<?> key) {
        f0.p(aVar, "<this>");
        f0.p(key, "key");
        if (!(key instanceof b)) {
            return aVar.getKey() == key ? EmptyCoroutineContext.f37755a : aVar;
        }
        b bVar = (b) key;
        return (!bVar.a(aVar.getKey()) || bVar.b(aVar) == null) ? aVar : EmptyCoroutineContext.f37755a;
    }
}
