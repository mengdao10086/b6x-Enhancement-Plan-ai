package kotlinx.coroutines.flow.internal;

import kotlin.z1;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.y1;

/* JADX INFO: loaded from: classes5.dex */
@y1
public final class m<T> implements kotlinx.coroutines.flow.f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final s<T> f38722a;

    /* JADX WARN: Multi-variable type inference failed */
    public m(@yt.k s<? super T> sVar) {
        this.f38722a = sVar;
    }

    @Override // kotlinx.coroutines.flow.f
    @yt.l
    public Object f(T t10, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        Object objG = this.f38722a.G(t10, cVar);
        return objG == yj.b.h() ? objG : z1.f38230a;
    }
}
