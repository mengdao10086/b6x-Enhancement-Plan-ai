package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes5.dex */
public final class l<T> implements u<T>, a<T>, kotlinx.coroutines.flow.internal.i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.l
    public final c2 f38727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u<T> f38728b;

    /* JADX WARN: Multi-variable type inference failed */
    public l(@yt.k u<? extends T> uVar, @yt.l c2 c2Var) {
        this.f38727a = c2Var;
        this.f38728b = uVar;
    }

    @Override // kotlinx.coroutines.flow.n, kotlinx.coroutines.flow.e
    @yt.l
    public Object a(@yt.k f<? super T> fVar, @yt.k kotlin.coroutines.c<?> cVar) {
        return this.f38728b.a(fVar, cVar);
    }

    @Override // kotlinx.coroutines.flow.n
    @yt.k
    public List<T> b() {
        return this.f38728b.b();
    }

    @Override // kotlinx.coroutines.flow.internal.i
    @yt.k
    public e<T> c(@yt.k CoroutineContext coroutineContext, int i10, @yt.k BufferOverflow bufferOverflow) {
        return v.d(this, coroutineContext, i10, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.u
    public T getValue() {
        return this.f38728b.getValue();
    }
}
