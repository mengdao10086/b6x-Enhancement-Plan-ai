package ye;

/* JADX INFO: loaded from: classes7.dex */
public abstract class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f57333b = new e(null, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f57334a;

    public g(g gVar) {
        this.f57334a = gVar;
    }

    public final g a(int i10, int i11) {
        return new e(this, i10, i11);
    }

    public final g b(int i10, int i11) {
        return new b(this, i10, i11);
    }

    public abstract void c(af.a aVar, byte[] bArr);

    public final g d() {
        return this.f57334a;
    }
}
