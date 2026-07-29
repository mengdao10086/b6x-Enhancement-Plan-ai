package kotlinx.coroutines.selects;

import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.s0;
import kotlin.u0;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.p;
import kotlinx.coroutines.p0;

/* JADX INFO: loaded from: classes5.dex */
@s0
public final class UnbiasedSelectBuilderImpl<R> extends n<R> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public final p<R> f39023h;

    public UnbiasedSelectBuilderImpl(@yt.k kotlin.coroutines.c<? super R> cVar) {
        super(cVar.b());
        this.f39023h = new p<>(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
    }

    @s0
    public final void s0(@yt.k Throwable th2) {
        p<R> pVar = this.f39023h;
        Result.a aVar = Result.f37633a;
        pVar.x(Result.b(u0.a(th2)));
    }

    @yt.l
    @s0
    public final Object u0() {
        if (this.f39023h.n()) {
            return this.f39023h.C();
        }
        kotlinx.coroutines.j.f(p0.a(b()), null, CoroutineStart.UNDISPATCHED, new UnbiasedSelectBuilderImpl$initSelectResult$1(this, null), 1, null);
        return this.f39023h.C();
    }
}
