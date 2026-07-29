package androidx.lifecycle;

import java.time.Duration;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
public final class CoroutineLiveDataKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f6067a = 5000;

    public static final class a implements k0, kotlin.jvm.internal.a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.l f6068a;

        public a(ik.l function) {
            kotlin.jvm.internal.f0.p(function, "function");
            this.f6068a = function;
        }

        @Override // kotlin.jvm.internal.a0
        @yt.k
        public final kotlin.u<?> a() {
            return this.f6068a;
        }

        @Override // androidx.lifecycle.k0
        public final /* synthetic */ void b(Object obj) {
            this.f6068a.i(obj);
        }

        public final boolean equals(@yt.l Object obj) {
            if ((obj instanceof k0) && (obj instanceof kotlin.jvm.internal.a0)) {
                return kotlin.jvm.internal.f0.g(a(), ((kotlin.jvm.internal.a0) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }
    }

    @yt.l
    public static final <T> Object a(@yt.k h0<T> h0Var, @yt.k LiveData<T> liveData, @yt.k kotlin.coroutines.c<? super EmittedSource> cVar) {
        return kotlinx.coroutines.h.h(kotlinx.coroutines.d1.e().o2(), new CoroutineLiveDataKt$addDisposableSource$2(h0Var, liveData, null), cVar);
    }

    @yt.k
    public static final <T> LiveData<T> b(@yt.k CoroutineContext context, long j10, @yt.k ik.p<? super g0<T>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> block) {
        kotlin.jvm.internal.f0.p(context, "context");
        kotlin.jvm.internal.f0.p(block, "block");
        return new CoroutineLiveData(context, j10, block);
    }

    @yt.k
    @g.v0(26)
    public static final <T> LiveData<T> c(@yt.k CoroutineContext context, @yt.k Duration timeout, @yt.k ik.p<? super g0<T>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> block) {
        kotlin.jvm.internal.f0.p(context, "context");
        kotlin.jvm.internal.f0.p(timeout, "timeout");
        kotlin.jvm.internal.f0.p(block, "block");
        return new CoroutineLiveData(context, c.f6174a.a(timeout), block);
    }

    public static /* synthetic */ LiveData d(CoroutineContext coroutineContext, long j10, ik.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f37755a;
        }
        if ((i10 & 2) != 0) {
            j10 = 5000;
        }
        return b(coroutineContext, j10, pVar);
    }

    public static /* synthetic */ LiveData e(CoroutineContext coroutineContext, Duration duration, ik.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f37755a;
        }
        return c(coroutineContext, duration, pVar);
    }
}
