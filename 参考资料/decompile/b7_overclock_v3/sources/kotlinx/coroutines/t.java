package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
public final class t extends d2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @hk.e
    @yt.k
    public final p<?> f39070e;

    public t(@yt.k p<?> pVar) {
        this.f39070e = pVar;
    }

    @Override // kotlinx.coroutines.e0
    public void R(@yt.l Throwable th2) {
        p<?> pVar = this.f39070e;
        pVar.T(pVar.z(S()));
    }

    @Override // ik.l
    public /* bridge */ /* synthetic */ kotlin.z1 i(Throwable th2) {
        R(th2);
        return kotlin.z1.f38230a;
    }
}
