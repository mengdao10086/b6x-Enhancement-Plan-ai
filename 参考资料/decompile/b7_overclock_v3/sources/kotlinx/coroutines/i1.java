package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
public final class i1 extends i2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final g1 f38754e;

    public i1(@yt.k g1 g1Var) {
        this.f38754e = g1Var;
    }

    @Override // kotlinx.coroutines.e0
    public void R(@yt.l Throwable th2) {
        this.f38754e.dispose();
    }

    @Override // ik.l
    public /* bridge */ /* synthetic */ kotlin.z1 i(Throwable th2) {
        R(th2);
        return kotlin.z1.f38230a;
    }
}
