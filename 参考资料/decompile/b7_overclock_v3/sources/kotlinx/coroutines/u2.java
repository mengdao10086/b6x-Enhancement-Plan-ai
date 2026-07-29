package kotlinx.coroutines;

import kotlin.Result;

/* JADX INFO: loaded from: classes5.dex */
public final class u2 extends i2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final kotlin.coroutines.c<kotlin.z1> f39075e;

    /* JADX WARN: Multi-variable type inference failed */
    public u2(@yt.k kotlin.coroutines.c<? super kotlin.z1> cVar) {
        this.f39075e = cVar;
    }

    @Override // kotlinx.coroutines.e0
    public void R(@yt.l Throwable th2) {
        kotlin.coroutines.c<kotlin.z1> cVar = this.f39075e;
        Result.a aVar = Result.f37633a;
        cVar.x(Result.b(kotlin.z1.f38230a));
    }

    @Override // ik.l
    public /* bridge */ /* synthetic */ kotlin.z1 i(Throwable th2) {
        R(th2);
        return kotlin.z1.f38230a;
    }
}
