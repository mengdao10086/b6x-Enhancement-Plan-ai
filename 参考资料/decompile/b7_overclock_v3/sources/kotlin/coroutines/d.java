package kotlin.coroutines;

import ik.p;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.f0;
import kotlin.v0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.3")
public interface d extends CoroutineContext.a {

    /* JADX INFO: renamed from: u2, reason: collision with root package name */
    @k
    public static final b f37759u2 = b.f37760a;

    public static final class a {
        public static <R> R a(@k d dVar, R r10, @k p<? super R, ? super CoroutineContext.a, ? extends R> operation) {
            f0.p(operation, "operation");
            return (R) CoroutineContext.a.C0431a.a(dVar, r10, operation);
        }

        @l
        public static <E extends CoroutineContext.a> E b(@k d dVar, @k CoroutineContext.b<E> key) {
            f0.p(key, "key");
            if (!(key instanceof kotlin.coroutines.b)) {
                if (d.f37759u2 != key) {
                    return null;
                }
                f0.n(dVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return dVar;
            }
            kotlin.coroutines.b bVar = (kotlin.coroutines.b) key;
            if (!bVar.a(dVar.getKey())) {
                return null;
            }
            E e10 = (E) bVar.b(dVar);
            if (e10 instanceof CoroutineContext.a) {
                return e10;
            }
            return null;
        }

        @k
        public static CoroutineContext c(@k d dVar, @k CoroutineContext.b<?> key) {
            f0.p(key, "key");
            if (!(key instanceof kotlin.coroutines.b)) {
                return d.f37759u2 == key ? EmptyCoroutineContext.f37755a : dVar;
            }
            kotlin.coroutines.b bVar = (kotlin.coroutines.b) key;
            return (!bVar.a(dVar.getKey()) || bVar.b(dVar) == null) ? dVar : EmptyCoroutineContext.f37755a;
        }

        @k
        public static CoroutineContext d(@k d dVar, @k CoroutineContext context) {
            f0.p(context, "context");
            return CoroutineContext.a.C0431a.d(dVar, context);
        }

        public static void e(@k d dVar, @k c<?> continuation) {
            f0.p(continuation, "continuation");
        }
    }

    public static final class b implements CoroutineContext.b<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f37760a = new b();
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @l
    <E extends CoroutineContext.a> E c(@k CoroutineContext.b<E> bVar);

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @k
    CoroutineContext f(@k CoroutineContext.b<?> bVar);

    void m(@k c<?> cVar);

    @k
    <T> c<T> z(@k c<? super T> cVar);
}
