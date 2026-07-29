package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.s0
public final class v0 implements CoroutineContext.b<u0<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final ThreadLocal<?> f38840a;

    public v0(@yt.k ThreadLocal<?> threadLocal) {
        this.f38840a = threadLocal;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ v0 c(v0 v0Var, ThreadLocal threadLocal, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            threadLocal = v0Var.f38840a;
        }
        return v0Var.b(threadLocal);
    }

    public final ThreadLocal<?> a() {
        return this.f38840a;
    }

    @yt.k
    public final v0 b(@yt.k ThreadLocal<?> threadLocal) {
        return new v0(threadLocal);
    }

    public boolean equals(@yt.l Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof v0) && kotlin.jvm.internal.f0.g(this.f38840a, ((v0) obj).f38840a);
    }

    public int hashCode() {
        return this.f38840a.hashCode();
    }

    @yt.k
    public String toString() {
        return "ThreadLocalKey(threadLocal=" + this.f38840a + ')';
    }
}
