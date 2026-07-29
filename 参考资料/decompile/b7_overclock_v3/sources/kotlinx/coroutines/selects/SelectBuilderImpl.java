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
public final class SelectBuilderImpl<R> extends SelectImplementation<R> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public final p<R> f38996g;

    public SelectBuilderImpl(@yt.k kotlin.coroutines.c<? super R> cVar) {
        super(cVar.b());
        this.f38996g = new p<>(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
    }

    @yt.l
    @s0
    public final Object n0() {
        if (this.f38996g.n()) {
            return this.f38996g.C();
        }
        kotlinx.coroutines.j.f(p0.a(b()), null, CoroutineStart.UNDISPATCHED, new SelectBuilderImpl$getResult$1(this, null), 1, null);
        return this.f38996g.C();
    }

    @s0
    public final void q0(@yt.k Throwable th2) {
        p<R> pVar = this.f38996g;
        Result.a aVar = Result.f37633a;
        pVar.x(Result.b(u0.a(th2)));
    }
}
