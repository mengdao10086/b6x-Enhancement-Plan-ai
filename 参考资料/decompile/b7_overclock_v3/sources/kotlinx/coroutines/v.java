package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
public final class v extends d2 implements u {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @hk.e
    @yt.k
    public final w f39076e;

    public v(@yt.k w wVar) {
        this.f39076e = wVar;
    }

    @Override // kotlinx.coroutines.e0
    public void R(@yt.l Throwable th2) {
        this.f39076e.G0(S());
    }

    @Override // kotlinx.coroutines.u
    public boolean d(@yt.k Throwable th2) {
        return S().o0(th2);
    }

    @Override // kotlinx.coroutines.u
    @yt.k
    public c2 getParent() {
        return S();
    }

    @Override // ik.l
    public /* bridge */ /* synthetic */ kotlin.z1 i(Throwable th2) {
        R(th2);
        return kotlin.z1.f38230a;
    }
}
