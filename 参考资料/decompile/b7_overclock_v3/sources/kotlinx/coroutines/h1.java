package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
public final class h1 extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final g1 f38749a;

    public h1(@yt.k g1 g1Var) {
        this.f38749a = g1Var;
    }

    @Override // ik.l
    public /* bridge */ /* synthetic */ kotlin.z1 i(Throwable th2) {
        s(th2);
        return kotlin.z1.f38230a;
    }

    @Override // kotlinx.coroutines.n
    public void s(@yt.l Throwable th2) {
        this.f38749a.dispose();
    }

    @yt.k
    public String toString() {
        return "DisposeOnCancel[" + this.f38749a + ']';
    }
}
