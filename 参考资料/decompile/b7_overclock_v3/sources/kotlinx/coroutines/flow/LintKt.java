package kotlinx.coroutines.flow;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import kotlin.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
public final class LintKt {
    @kotlin.k(level = DeprecationLevel.ERROR, message = "cancel() is resolved into the extension of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext().cancel() instead or specify the receiver of cancel() explicitly", replaceWith = @t0(expression = "currentCoroutineContext().cancel(cause)", imports = {}))
    public static final void a(@yt.k f<?> fVar, @yt.l CancellationException cancellationException) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ void b(f fVar, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        a(fVar, cancellationException);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Applying 'cancellable' to a SharedFlow has no effect. See the SharedFlow documentation on Operator Fusion.", replaceWith = @t0(expression = "this", imports = {}))
    @yt.k
    public static final <T> e<T> c(@yt.k n<? extends T> nVar) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @bk.f
    @kotlin.k(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this operator typically has not effect, it can only catch exceptions from 'onSubscribe' operator", replaceWith = @t0(expression = "this", imports = {}))
    public static final <T> e<T> d(n<? extends T> nVar, ik.q<? super f<? super T>, ? super Throwable, ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar) {
        f0.n(nVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.catch>");
        return g.u(nVar, qVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Applying 'conflate' to StateFlow has no effect. See the StateFlow documentation on Operator Fusion.", replaceWith = @t0(expression = "this", imports = {}))
    @yt.k
    public static final <T> e<T> e(@yt.k u<? extends T> uVar) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @bk.f
    @kotlin.k(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this terminal operation never completes.")
    public static final <T> Object f(n<? extends T> nVar, kotlin.coroutines.c<? super Integer> cVar) {
        f0.n(nVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.count>");
        c0.e(0);
        Object objZ = g.Z(nVar, cVar);
        c0.e(1);
        return objZ;
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Applying 'distinctUntilChanged' to StateFlow has no effect. See the StateFlow documentation on Operator Fusion.", replaceWith = @t0(expression = "this", imports = {}))
    @yt.k
    public static final <T> e<T> g(@yt.k u<? extends T> uVar) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Applying 'flowOn' to SharedFlow has no effect. See the SharedFlow documentation on Operator Fusion.", replaceWith = @t0(expression = "this", imports = {}))
    @yt.k
    public static final <T> e<T> h(@yt.k n<? extends T> nVar, @yt.k CoroutineContext coroutineContext) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @yt.k
    public static final CoroutineContext i(@yt.k f<?> fVar) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "coroutineContext is resolved into the property of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext() instead or specify the receiver of coroutineContext explicitly", replaceWith = @t0(expression = "currentCoroutineContext()", imports = {}))
    public static /* synthetic */ void j(f fVar) {
    }

    public static final boolean k(@yt.k f<?> fVar) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "isActive is resolved into the extension of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext().isActive or cancellable() operator instead or specify the receiver of isActive explicitly. Additionally, flow {} builder emissions are cancellable by default.", replaceWith = @t0(expression = "currentCoroutineContext().isActive", imports = {}))
    public static /* synthetic */ void l(f fVar) {
    }

    @bk.f
    @kotlin.k(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this operator has no effect.", replaceWith = @t0(expression = "this", imports = {}))
    public static final <T> e<T> m(n<? extends T> nVar, long j10, ik.p<? super Throwable, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar) {
        f0.n(nVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.retry>");
        return g.w1(nVar, j10, pVar);
    }

    public static /* synthetic */ e n(n nVar, long j10, ik.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = Long.MAX_VALUE;
        }
        if ((i10 & 2) != 0) {
            pVar = new LintKt$retry$1(null);
        }
        f0.n(nVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.retry>");
        return g.w1(nVar, j10, pVar);
    }

    @bk.f
    @kotlin.k(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this operator has no effect.", replaceWith = @t0(expression = "this", imports = {}))
    public static final <T> e<T> o(n<? extends T> nVar, ik.r<? super f<? super T>, ? super Throwable, ? super Long, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> rVar) {
        f0.n(nVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.retryWhen>");
        return g.y1(nVar, rVar);
    }

    @bk.f
    public static final <T> Object p(n<? extends T> nVar, List<T> list, kotlin.coroutines.c<?> cVar) {
        f0.n(nVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toList>");
        c0.e(0);
        g.Y1(nVar, list, cVar);
        c0.e(1);
        throw new IllegalStateException("this code is supposed to be unreachable");
    }

    @bk.f
    @kotlin.k(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this terminal operation never completes.")
    public static final <T> Object q(n<? extends T> nVar, kotlin.coroutines.c<? super List<? extends T>> cVar) {
        f0.n(nVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toList>");
        c0.e(0);
        Object objC = FlowKt__CollectionKt.c(nVar, null, cVar, 1, null);
        c0.e(1);
        return objC;
    }

    @bk.f
    public static final <T> Object r(n<? extends T> nVar, Set<T> set, kotlin.coroutines.c<?> cVar) {
        f0.n(nVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toSet>");
        c0.e(0);
        g.a2(nVar, set, cVar);
        c0.e(1);
        throw new IllegalStateException("this code is supposed to be unreachable");
    }

    @bk.f
    @kotlin.k(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this terminal operation never completes.")
    public static final <T> Object s(n<? extends T> nVar, kotlin.coroutines.c<? super Set<? extends T>> cVar) {
        f0.n(nVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toSet>");
        c0.e(0);
        Object objE = FlowKt__CollectionKt.e(nVar, null, cVar, 1, null);
        c0.e(1);
        return objE;
    }
}
