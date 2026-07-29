package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

/* JADX INFO: loaded from: classes5.dex */
public final class k2<T> extends v0<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final kotlin.coroutines.c<kotlin.z1> f38893d;

    public k2(@yt.k CoroutineContext coroutineContext, @yt.k ik.p<? super o0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar) {
        super(coroutineContext, false);
        this.f38893d = IntrinsicsKt__IntrinsicsJvmKt.c(pVar, this, this);
    }

    @Override // kotlinx.coroutines.JobSupport
    public void k1() throws Throwable {
        zk.a.e(this.f38893d, this);
    }
}
