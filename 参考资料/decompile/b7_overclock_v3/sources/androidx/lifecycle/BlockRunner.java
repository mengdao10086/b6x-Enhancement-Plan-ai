package androidx.lifecycle;

import kotlin.z1;
import kotlinx.coroutines.c2;

/* JADX INFO: loaded from: classes2.dex */
public final class BlockRunner<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final CoroutineLiveData<T> f6057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final ik.p<g0<T>, kotlin.coroutines.c<? super z1>, Object> f6058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f6059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final kotlinx.coroutines.o0 f6060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final ik.a<z1> f6061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.l
    public c2 f6062f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.l
    public c2 f6063g;

    /* JADX WARN: Multi-variable type inference failed */
    public BlockRunner(@yt.k CoroutineLiveData<T> liveData, @yt.k ik.p<? super g0<T>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> block, long j10, @yt.k kotlinx.coroutines.o0 scope, @yt.k ik.a<z1> onDone) {
        kotlin.jvm.internal.f0.p(liveData, "liveData");
        kotlin.jvm.internal.f0.p(block, "block");
        kotlin.jvm.internal.f0.p(scope, "scope");
        kotlin.jvm.internal.f0.p(onDone, "onDone");
        this.f6057a = liveData;
        this.f6058b = block;
        this.f6059c = j10;
        this.f6060d = scope;
        this.f6061e = onDone;
    }

    @g.k0
    public final void g() {
        if (this.f6063g != null) {
            throw new IllegalStateException("Cancel call cannot happen without a maybeRun".toString());
        }
        this.f6063g = kotlinx.coroutines.j.f(this.f6060d, kotlinx.coroutines.d1.e().o2(), null, new BlockRunner$cancel$1(this, null), 2, null);
    }

    @g.k0
    public final void h() {
        c2 c2Var = this.f6063g;
        if (c2Var != null) {
            c2.a.b(c2Var, null, 1, null);
        }
        this.f6063g = null;
        if (this.f6062f != null) {
            return;
        }
        this.f6062f = kotlinx.coroutines.j.f(this.f6060d, null, null, new BlockRunner$maybeRun$1(this, null), 3, null);
    }
}
