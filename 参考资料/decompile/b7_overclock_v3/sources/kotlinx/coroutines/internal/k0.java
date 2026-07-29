package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

/* JADX INFO: loaded from: classes5.dex */
public class k0<T> extends kotlinx.coroutines.a<T> implements zj.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @hk.e
    @yt.k
    public final kotlin.coroutines.c<T> f38808d;

    /* JADX WARN: Multi-variable type inference failed */
    public k0(@yt.k CoroutineContext coroutineContext, @yt.k kotlin.coroutines.c<? super T> cVar) {
        super(coroutineContext, true, true);
        this.f38808d = cVar;
    }

    @Override // zj.c
    @yt.l
    public final StackTraceElement D() {
        return null;
    }

    @Override // kotlinx.coroutines.a
    public void E1(@yt.l Object obj) {
        kotlin.coroutines.c<T> cVar = this.f38808d;
        cVar.x(kotlinx.coroutines.h0.a(obj, cVar));
    }

    @Override // kotlinx.coroutines.JobSupport
    public final boolean Q0() {
        return true;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void e0(@yt.l Object obj) {
        l.e(IntrinsicsKt__IntrinsicsJvmKt.d(this.f38808d), kotlinx.coroutines.h0.a(obj, this.f38808d), null, 2, null);
    }

    @Override // zj.c
    @yt.l
    public final zj.c r() {
        kotlin.coroutines.c<T> cVar = this.f38808d;
        if (cVar instanceof zj.c) {
            return (zj.c) cVar;
        }
        return null;
    }
}
