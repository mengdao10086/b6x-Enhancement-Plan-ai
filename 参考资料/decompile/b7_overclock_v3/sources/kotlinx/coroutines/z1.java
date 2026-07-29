package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
public final class z1 extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final ik.l<Throwable, kotlin.z1> f39083a;

    /* JADX WARN: Multi-variable type inference failed */
    public z1(@yt.k ik.l<? super Throwable, kotlin.z1> lVar) {
        this.f39083a = lVar;
    }

    @Override // ik.l
    public /* bridge */ /* synthetic */ kotlin.z1 i(Throwable th2) {
        s(th2);
        return kotlin.z1.f38230a;
    }

    @Override // kotlinx.coroutines.n
    public void s(@yt.l Throwable th2) {
        this.f39083a.i(th2);
    }

    @yt.k
    public String toString() {
        return "InvokeOnCancel[" + r0.a(this.f39083a) + '@' + r0.b(this) + ']';
    }
}
