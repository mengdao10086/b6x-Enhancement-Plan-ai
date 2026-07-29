package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

/* JADX INFO: loaded from: classes5.dex */
public final class l2 extends y2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final kotlin.coroutines.c<kotlin.z1> f38906d;

    public l2(@yt.k CoroutineContext coroutineContext, @yt.k ik.p<? super o0, ? super kotlin.coroutines.c<? super kotlin.z1>, ? extends Object> pVar) {
        super(coroutineContext, false);
        this.f38906d = IntrinsicsKt__IntrinsicsJvmKt.c(pVar, this, this);
    }

    @Override // kotlinx.coroutines.JobSupport
    public void k1() throws Throwable {
        zk.a.e(this.f38906d, this);
    }
}
