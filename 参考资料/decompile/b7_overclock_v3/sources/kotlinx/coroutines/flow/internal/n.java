package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public final class n<T> implements kotlin.coroutines.c<T>, zj.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final kotlin.coroutines.c<T> f38723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final CoroutineContext f38724b;

    /* JADX WARN: Multi-variable type inference failed */
    public n(@yt.k kotlin.coroutines.c<? super T> cVar, @yt.k CoroutineContext coroutineContext) {
        this.f38723a = cVar;
        this.f38724b = coroutineContext;
    }

    @Override // zj.c
    @yt.l
    public StackTraceElement D() {
        return null;
    }

    @Override // kotlin.coroutines.c
    @yt.k
    public CoroutineContext b() {
        return this.f38724b;
    }

    @Override // zj.c
    @yt.l
    public zj.c r() {
        kotlin.coroutines.c<T> cVar = this.f38723a;
        if (cVar instanceof zj.c) {
            return (zj.c) cVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.c
    public void x(@yt.k Object obj) {
        this.f38723a.x(obj);
    }
}
