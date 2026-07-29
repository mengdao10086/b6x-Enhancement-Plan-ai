package kotlin.coroutines;

import ik.l;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.a;
import kotlin.jvm.internal.f0;
import kotlin.q;
import kotlin.v0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.3")
@q
public abstract class b<B extends CoroutineContext.a, E extends B> implements CoroutineContext.b<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final l<CoroutineContext.a, E> f37757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final CoroutineContext.b<?> f37758b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.coroutines.CoroutineContext$b<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [ik.l<? super kotlin.coroutines.CoroutineContext$a, ? extends E extends B>, ik.l<kotlin.coroutines.CoroutineContext$a, E extends B>, java.lang.Object] */
    public b(@k CoroutineContext.b<B> baseKey, @k l<? super CoroutineContext.a, ? extends E> safeCast) {
        f0.p(baseKey, "baseKey");
        f0.p(safeCast, "safeCast");
        this.f37757a = safeCast;
        this.f37758b = baseKey instanceof b ? (CoroutineContext.b<B>) ((b) baseKey).f37758b : baseKey;
    }

    public final boolean a(@k CoroutineContext.b<?> key) {
        f0.p(key, "key");
        return key == this || this.f37758b == key;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/CoroutineContext$a;)TE; */
    @yt.l
    public final CoroutineContext.a b(@k CoroutineContext.a element) {
        f0.p(element, "element");
        return (CoroutineContext.a) this.f37757a.i(element);
    }
}
