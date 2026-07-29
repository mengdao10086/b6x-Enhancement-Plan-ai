package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
public final class b2 extends i2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final ik.l<Throwable, kotlin.z1> f38291e;

    /* JADX WARN: Multi-variable type inference failed */
    public b2(@yt.k ik.l<? super Throwable, kotlin.z1> lVar) {
        this.f38291e = lVar;
    }

    @Override // kotlinx.coroutines.e0
    public void R(@yt.l Throwable th2) {
        this.f38291e.i(th2);
    }

    @Override // ik.l
    public /* bridge */ /* synthetic */ kotlin.z1 i(Throwable th2) {
        R(th2);
        return kotlin.z1.f38230a;
    }
}
