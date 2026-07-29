package kotlinx.coroutines.flow.internal;

import ik.p;
import kotlin.coroutines.CoroutineContext;
import kotlin.z1;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes5.dex */
public final class UndispatchedContextCollector<T> implements kotlinx.coroutines.flow.f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final CoroutineContext f38706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final Object f38707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final p<T, kotlin.coroutines.c<? super z1>, Object> f38708c;

    public UndispatchedContextCollector(@yt.k kotlinx.coroutines.flow.f<? super T> fVar, @yt.k CoroutineContext coroutineContext) {
        this.f38706a = coroutineContext;
        this.f38707b = ThreadContextKt.b(coroutineContext);
        this.f38708c = new UndispatchedContextCollector$emitRef$1(fVar, null);
    }

    @Override // kotlinx.coroutines.flow.f
    @yt.l
    public Object f(T t10, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        Object objC = d.c(this.f38706a, t10, this.f38707b, this.f38708c, cVar);
        return objC == yj.b.h() ? objC : z1.f38230a;
    }
}
