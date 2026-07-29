package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes5.dex */
public final class k<T> implements n<T>, a<T>, kotlinx.coroutines.flow.internal.i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.l
    public final c2 f38725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n<T> f38726b;

    /* JADX WARN: Multi-variable type inference failed */
    public k(@yt.k n<? extends T> nVar, @yt.l c2 c2Var) {
        this.f38725a = c2Var;
        this.f38726b = nVar;
    }

    @Override // kotlinx.coroutines.flow.n, kotlinx.coroutines.flow.e
    @yt.l
    public Object a(@yt.k f<? super T> fVar, @yt.k kotlin.coroutines.c<?> cVar) {
        return this.f38726b.a(fVar, cVar);
    }

    @Override // kotlinx.coroutines.flow.n
    @yt.k
    public List<T> b() {
        return this.f38726b.b();
    }

    @Override // kotlinx.coroutines.flow.internal.i
    @yt.k
    public e<T> c(@yt.k CoroutineContext coroutineContext, int i10, @yt.k BufferOverflow bufferOverflow) {
        return o.e(this, coroutineContext, i10, bufferOverflow);
    }
}
